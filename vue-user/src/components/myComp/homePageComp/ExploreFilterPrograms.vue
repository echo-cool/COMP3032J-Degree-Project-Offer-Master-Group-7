<template>
    <div class="rn-product-area rn-section-gapTop">
        <div class="container">
            <div class="row mb--30 align-items-center">
                <div class="col-12">
                    <h3 class="title mb--0" data-sal-delay="150" data-sal="slide-up" data-sal-duration="800">
                        Explore Graduate Programs
                    </h3>
                </div>
            </div>

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
                        <label class="filter-leble">School type</label>
                        <nice-select
                            :options="[
                                    {value: 'all', text: 'All Types'},
                                    {value: 'fixed-price', text: 'Fixed price'},
                                    {value: 'timed-auction', text: 'Timed auction'},
                                    {value: 'not-for-sale', text: 'Not for sale'},
                                    {value: 'open-for-offers', text: 'Open for offers'}
                                ]"
                            :default-current="0"
                            placeholder="School type"
                            name="school_type"
                            @onChange="changeSaleType"
                        />
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
                                      :school="schoolsOfPrograms[index]"
                                      :is-liked-obj="isLiked(program.id)"/>
                    </div>
                </template>
                <h3 v-if="!programs.length" class="text-center">No Match Found</h3>
            </div>
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
    import profileApi from "@/api/profile";

    export default {
        name: 'ExploreFilterPrograms',
        components: {
            ProgramCard,
            GPARangeSlider,
            NiceSelect,
            ProductCard
        },
        props: {"query": {type: String, default: ""}, "limit": {type: Number, default: -1}, "current":{type: Number, default: 1}},
        mixins: [ProductFilterMixin],
        data() {
            return {
                likedPrograms: [],
                likedProgramIds: [],
                programQuery: {
                    likes: "most-liked",
                    degree: "all",
                    major: "all",
                    query: ""
                },
                programs: [],
                schoolsOfPrograms: []
            }
        },
        created() {
            this.programQuery.query = this.query
            this.getProgramsByQuery();
            // init the liked program list
            this.getLikedPrograms();
        },
        methods: {

            onChangeLikes(item){
                this.programQuery.likes = item.value;
                this.filterChangeHandler();
            },
            onChangeDegree(item){
                this.programQuery.degree = item.value;
                this.filterChangeHandler();
            },
            onChangeMajor(item){
                this.programQuery.major = item.value;
                this.filterChangeHandler();
            },

            filterChangeHandler(){
                // request the programs again using new query
                this.getProgramsByQuery();
            },

            getProgramsByQuery(){
              console.log(this.programQuery)
                // call the api method
                programApi.getProgramsByQuery(this.programQuery, this.limit, this.current)
                    .then(response => {
                        // update the program list
                        this.programs = response.data.programs.content;
                        // update the school list corresponding to the programs
                        this.schoolsOfPrograms = response.data.schoolsOfPrograms.content;
                    })
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
