<template>
    <h2 class="text-left mb--50">RECOMMENDED PROGRAMS RANKED BY SIMILARITY</h2>
<!--    <nav class="product-tab-nav">-->
<!--        <div class="nav" id="nav-tab" role="tablist">-->
<!--            <button :class="[`nav-link`, {'active': activeTabIndex === index}]"-->
<!--                    :id="`nav-${filterName(navLink.name)}-tab`"-->
<!--                    data-bs-toggle="tab"-->
<!--                    :data-bs-target="`#nav-${filterName(navLink.name)}`"-->
<!--                    type="button"-->
<!--                    role="tab"-->
<!--                    :aria-controls="`nav-${filterName(navLink.name)}`"-->
<!--                    :aria-selected="index === activeTabIndex ? 'true' : 'false'"-->
<!--                    v-for="(navLink, index) in listItemsTab"-->
<!--                    :key="`nav-link-${index}`">-->
<!--                {{ navLink.name }}-->
<!--            </button>-->
<!--        </div>-->
<!--    </nav>-->
    <div class="tab-content" id="nav-tabContent">
        <div :class="[`lg-product_tab-pane tab-pane fade`, {'show active': activeTabIndex === index}, {'lg-product-col-2': isTwoColumn}]"
             :id="`program-${filterName(tabPane.name)}`"
             role="tabpanel"
             v-for="(tabPane, index) in listItemsTab"
             :key="`program-link-${index}`">

            <!-- !!! we must load this component after loading all the schools !!! -->
            <!-- !!! Otherwise, the schools would be undefined !!! -->
            <template v-if="schoolLoadNum === programs.length" v-for="(program, index) in programs"
                      :key="`program-${index}`">
                <program-list-card :program="program"
                                   :is-program-selected="isProgramSelected(program.id)"
                                   :show-two-column="isTwoColumn"
                                   :is-liked-obj="isLiked(program.id)"
                                    @reloadData="reloadData"/>
            </template>
        </div>
    </div>
</template>

<script>
    import ProductMixin from '@/mixins/ProductMixin'
    import ProgramListCard from "@/components/myComp/ProgramListCard.vue";
    import commonApi from "@/api/common";
    import profileApi from "@/api/profile";
    import ApplicationListMixin from "@/mixins/user/ApplicationListMixin";
    import {getRecommendedProgramsByKNN} from "@/api/recommendation";

    export default {
        name: 'ProgramListing',
        components: {ProgramListCard},
        mixins: [ProductMixin, ApplicationListMixin],
        props: {
            isTwoColumn: {
                type: Boolean,
                default: false
            },
            currentUser: {},
            applications: {
                type: Array,
                default: function () {
                    return [];
                }
            }
        },
        data() {
            return {
                likedPrograms: [],
                likedProgramIds: [],

                activeTabIndex: 0,
                listItemsTab: [
                    {
                        name: 'All Product',
                        items: ''
                    },
                    {
                        name: 'Newest Item',
                        items: ''
                    },
                    {
                        name: 'Rare Reals',
                        items: ''
                    }
                ],

                programs: [
                    {
                        id: "",
                        name: "",
                        school:{
                            id: "",
                            name: "",
                            img: ""
                        }
                    }
                ],

                selectedPrograms: [],
                selectedProgramIDs: [],

                schoolLoadNum: 0    // number of schools finished loading

            }
        },
        mounted() {
            this.filterName('All Products')
        },
        created() {
            this.listItemsTab.forEach((item, index) => {
                if (index === 1) {
                    item.items = this.products.slice().reverse();
                } else if (index === 2) {
                    item.items = this.products.sort(() => Math.random() - 0.5);
                } else {
                    item.items = this.products;
                }
            });

            // init the liked program list
            this.getLikedPrograms();
        },

        methods: {
            filterName(name) {
                return name.toLowerCase().replace(' ', '-')
            },

            // get all the programs
            getPrograms(){
                // call the api method
                getRecommendedProgramsByKNN()
                    .then(response => {
                        // update the programs list
                        this.programs = response.data.data;

                        // for each of the program, send request to get the school info
                        for (let k in this.programs){
                            // create the request url for the school of this program
                            let schoolURL = `/rest/programs/${this.programs[k].id}/school`;

                            // send request to update the school info of this program
                            commonApi.getByRestURL(schoolURL)
                                .then(response => { // response is the school
                                    // update the school of this program
                                    this.programs[k].school = response;
                                    // update the number of finished loading schools
                                    this.schoolLoadNum += 1;
                                })
                        }
                    })
            },

            getUserSelectedPrograms(){
                // call the api method
                profileApi.getSelectedPrograms()
                    .then(response => {

                        // get the list of user selected programs
                        this.selectedPrograms = response.data.selectedPrograms;
                        // reset the selectedProgramIDs list to empty
                        this.selectedProgramIDs = [];
                        // initialize the list of selected program id
                        for (let k in this.selectedPrograms){
                            this.selectedProgramIDs.push(this.selectedPrograms[k].id);
                        }

                    })
            },

            // check whether the application list contains a program
            isProgramSelected(programId){
                return this.selectedProgramIDs.includes(programId);
            },

            reloadData(){
                // tell the parent to fetch data again
                // (this contains the reload of user selected programs in this component)
                this.$emit("reloadData");
                // reload likes
                this.getLikedPrograms();
            },

            // get a list of ids of programs that the user liked
            getLikedPrograms(){
                // reset the lists to empty
                this.likedPrograms = [];
                this.likedProgramIds = [];
                profileApi.getLikedPrograms()
                    .then(response => {
                        // update the liked programs
                        this.likedPrograms = response.data.likedPrograms;
                        // create the list of program id
                        for (let k in this.likedPrograms){
                            this.likedProgramIds.push(this.likedPrograms[k].id);
                        }
                    })
            },

            // whether the user liked a program
            isLiked(programId){
                return {
                    isLiked: this.likedProgramIds.includes(programId)
                };
            }
        }
    }
</script>
