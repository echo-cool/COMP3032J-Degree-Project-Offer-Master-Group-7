
<template>
    <div class="rn-product-area rn-section-gapTop">
        <div id="explore-graduate-programs" class="container">
            <div class="row mb--30 align-items-center">
                <div class="col-12">
                    <h3 class="title mb--0" data-sal-delay="150" data-sal="slide-up" data-sal-duration="800">
                        Explore Graduate Programs
                    </h3>
                </div>
            </div>

            <!-- filter bar -->
            <div class="default-exp-wrapper">
                <div class="inner">
                    <div class="filter-select-option">
                        <label class="filter-leble">LIKES</label>
                        <nice-select
                                :options="[
                                    { value: 'most-liked', text: 'Most liked' },
                                    { value: 'least-liked', text: 'Least liked' }
                                ]"
                                :default-current="0"
                                placeholder="Sort by likes"
                                name="like"
                                @onChange="onChangeLikes"
                        />
                    </div>

                    <div class="filter-select-option">
                        <label class="filter-leble">Degree</label>
                        <nice-select
                                :options="[
                                    {value: 'all', text: 'All Degrees'},
                                    {value: 'Master', text: 'Master'},
                                    {value: 'PhD', text: 'PhD'}
                                ]"
                                :default-current="0"
                                placeholder="Degree"
                                name="degree"
                                @onChange="onChangeDegree"
                        />
                    </div>

                    <div class="filter-select-option">
                        <label class="filter-leble">Major</label>
                        <nice-select
                                :options="[
                                    {value: 'all', text: 'All Majors'},
                                    {value: 'CS', text: 'CS'},
                                    {value: 'MIS', text: 'MIS'},
                                    {value: 'EE', text: 'EE'}
                                ]"
                                :default-current="0"
                                placeholder="Major"
                                name="major"
                                @onChange="onChangeMajor"
                        />
                    </div>

                    <div class="filter-select-option">
<!--                        <label class="filter-leble">School type</label>-->
<!--                        <nice-select-->
<!--                                :options="[-->
<!--                                    {value: 'all', text: 'All Types'},-->
<!--                                    {value: 'fixed-price', text: 'Fixed price'},-->
<!--                                    {value: 'timed-auction', text: 'Timed auction'},-->
<!--                                    {value: 'not-for-sale', text: 'Not for sale'},-->
<!--                                    {value: 'open-for-offers', text: 'Open for offers'}-->
<!--                                ]"-->
<!--                                :default-current="0"-->
<!--                                placeholder="School type"-->
<!--                                name="school_type"-->
<!--                                @onChange="changeSaleType"-->
<!--                        />-->
                    </div>

                    <div class="filter-select-option">
                        <label class="filter-leble">Average GPA Range</label>
                        <div class="price_filter s-filter clear">
                            <form action="#" method="GET">
                                <g-p-a-range-slider
                                        @onChangeRange="onChangeRange"
                                        @filterPrice="filterPrice"
                                />
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <!-- program card area -->
            <div class="row g-5"
                 data-sal="slide-up"
                 data-sal-delay="150"
                 data-sal-duration="800">
                <template v-for="(program, index) in programs"
                          :key="`program-item-${index}`">
                    <div class="col-5 col-lg-4 col-md-6 col-sm-6 col-12">
                        <!--                        <product-card-->
                        <!--                            :product-date="product"-->
                        <!--                            product-style-class="no-overlay with-placeBid"-->
                        <!--                            :show-countdown="false"-->
                        <!--                            :show-place-bid="true"-->
                        <!--                        />-->
                        <program-card :program="program"
                                      :school="program.school"
                                      :is-liked-obj="isLiked(program.id)"
                                      @removeLike="removeLike(program.id)"
                                      @addLike="addLike(program.id)"/>
                    </div>
                </template>

                <!-- loading icon -->
                <div v-if="isLoading">
                    <div  class="d-flex justify-content-center">
                        <div class="spinner-border" role="status" style="zoom: 5">
<!--                            -->
                        </div>
                    </div>
                    <div class="m-5 d-flex justify-content-center">
                        <h2>Loading...</h2>
                    </div>
                </div>

                <!-- no match -->
                <h3 v-if="!programs.length && !isLoading" class="text-center">No Match Found</h3>
            </div>

            <!-- pagination -->
            <nav class="pagination-wrapper" aria-label="Page navigation example">
                <paginate
                    :force-page="currPage"
                    :page-count="totalPage"
                    :page-range="3"
                    :margin-pages="2"
                    :click-handler="pageClickCallback"
                    :prev-text="'Prev'"
                    :next-text="'Next'"
                    :container-class="'pagination'"
                    :page-class="'page-item'"
                >
                </paginate>
            </nav>
        </div>
    </div>
</template>

<script>
import GPARangeSlider from "@/components/myComp/program/GPARangeSlider.vue";
import NiceSelect from '@/components/select/NiceSelect'
import ProductCard from '@/components/product/ProductCard'
import ProductFilterMixin from '@/mixins/ProductFilterMixin'
import programApi from "@/api/program";
import ProgramCard from "@/components/myComp/program/ProgramCard.vue";
import LikeMixin from "@/mixins/user/LikeMixin";
import Paginate from "vuejs-paginate-next";


export default {
    name: 'ExploreFilterPrograms',
    components: {
        ProgramCard,
        GPARangeSlider,
        NiceSelect,
        ProductCard,
        Paginate
    },
    props: {
        "query": {
            type: String,
            default: ""
        },
        "limit": {
            type: Number,
            default: -1
        },
        currentUser: {}
    },
    mixins: [ProductFilterMixin, LikeMixin],
    data() {
        return {
            programQuery: {
                likes: "most-liked",
                degree: "all",
                major: "all",
                query: "",
                gpa: null
            },
            // filterPrice: null,
            programs: [],
            isLoading: true,

            changePageScrollToX: 0,
            changePageScrollToY: 0,

            currPage: 1,
            totalItemCount: 0,
            // countOfPage: 10,         // number of items in a page
        }
    },
    computed: {
        filteredRows() {
            return this.programs;
        },
        pageStart() {
            return (this.currPage - 1) * this.limit;
        },
        totalPage() {
            return Math.ceil(this.totalItemCount / this.limit);
        }
    },
    created() {
        // this.$isLoading(true) // show loading screen
        this.programQuery.query = this.query
        this.getProgramsByQuery();
        if (this.currentUser.id) {
            // init the liked program list
            this.getLikedPrograms();
        }
    },
    methods: {
        filterPrice(){
            this.currPage = 1;
            this.getProgramsByQuery();
        },

        onChangeRange(item) {
            console.log(item)
            this.programQuery.gpa = item
        },
        onChangeLikes(item) {
            this.programQuery.likes = item.value;
            this.filterChangeHandler();
        },
        onChangeDegree(item) {
            this.programQuery.degree = item.value;
            this.filterChangeHandler();
        },
        onChangeMajor(item) {
            this.programQuery.major = item.value;
            this.filterChangeHandler();
        },

        filterChangeHandler() {
            // reset the current page
            this.currPage = 1;
            // request the programs again using new query
            this.getProgramsByQuery();
        },

        getProgramsByQuery() {
            // clear the program list (for loading)
            this.programs = [];
            // update loading status
            this.isLoading = true;
            // call the api method
            programApi.getProgramsByQuery(this.programQuery, this.limit, this.currPage)
                .then(response => {
                    // update the program list
                    this.programs = response.data.programs.content;
                    this.totalItemCount = response.data.totalElements;
                    this.isLoading = false;
                    // this is ridiculous!!
                    // only here we can get the non-zero offsetTop!!
                    this.changePageScrollToY = document.getElementById('explore-graduate-programs').offsetTop;
                })
        },

        pageClickCallback (pageNum) {
            this.currPage = pageNum;
            window.scrollTo(this.changePageScrollToX, this.changePageScrollToY);
            // request the programs again using new page
            this.getProgramsByQuery();
        }

        // // get a list of ids of programs that the user liked
        // getLikedPrograms(){
        //     // reset the lists to empty
        //     this.likedPrograms = [];
        //     this.likedProgramIds = [];
        //     profileApi.getLikedPrograms()
        //         .then(response => {
        //             // update the liked programs
        //             this.likedPrograms = response.data.likedPrograms;
        //             // create the list of program id
        //             for (let k in this.likedPrograms){
        //                 this.likedProgramIds.push(this.likedPrograms[k].id);
        //             }
        //         })
        // },
        //
        // // whether the user liked a program
        // isLiked(programId){
        //     return {
        //         isLiked: this.likedProgramIds.includes(programId)
        //     };
        // }

    }
}
</script>


<style>
nav .active a {
    background: var(--color-primary) !important;
    color: var(--color-white) !important;
}

nav li a:hover {
    cursor: pointer;
}

nav li.disabled a{
    background: var(--color-lighter) !important;
}
</style>
