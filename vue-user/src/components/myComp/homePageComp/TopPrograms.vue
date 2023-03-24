<template>
    <div class="rn-top-top-seller-area nice-selector-transparent rn-section-gapTop">
        <div class="container">
            <div class="row mb--30">
                <div class="col-12 justify-sm-center d-flex" data-sal-delay="150" data-sal="slide-up" data-sal-duration="800">
                    <h3 class="title">Popular</h3>
                    <nice-select
                        :options="[
                                { value: 'Master', text: 'Master' },
                                { value: 'PhD', text: 'PhD' },
                            ]"
                        :default-current="0"
                        name="sellerSort"
                        @onChange="changeHandler"
                    />
                    <h3 class="title">Programs</h3>

                </div>
            </div>
            <div class="row justify-sm-center g-5 top-seller-list-wrapper"
                 data-sal="slide-up"
                 data-sal-delay="150"
                 data-sal-duration="800">
                <template v-for="(program, index) in popularPrograms"
                          :key="`program-${index}`">
                    <div class="col-5 col-lg-3 col-md-4 col-sm-6 top-seller-list">
                        <top-program-item :program="program"
                                          :school="schoolsOfPrograms[index]"/>
                    </div>
                </template>
            </div>
        </div>
    </div>
</template>

<script>
    import NiceSelect from '@/components/select/NiceSelect.vue'
    import Seller from '@/components/seller/Seller.vue'
    import TopProgramItem from "@/components/myComp/homePageComp/TopProgramItem.vue";
    import AuthorMixin from '@/mixins/AuthorMixin'
    import SalScrollAnimationMixin from "@/mixins/SalScrollAnimationMixin";
    import AppFunctions from "@/helpers/AppFunctions";
    import schoolApi from "@/api/shool";
    import programApi from "@/api/program"

    export default {
        name: 'TopPrograms',
        components: {
            TopProgramItem,
            NiceSelect
        },
        mixins: [AuthorMixin, SalScrollAnimationMixin],
        data() {
            return {
                filteredSeller: '',
                topSellerIn: '1 Day',
                popularPrograms: [],
                schoolsOfPrograms: []   // corresponding schools of programs
            }
        },
        // watch: {
        //     'topSellerIn': function (val) {
        //         this.getFilteredSeller(val)
        //     }
        // },
        created() {

            this.getPopularPrograms("Master");

        },
        methods: {
            // changeHandler(item) {
            //     this.topSellerIn = item.value;
            // },
            // getFilteredSeller(type) {
            //     this.filteredSeller = this.authors.filter(seller =>  AppFunctions.slugify(seller.topSince) === AppFunctions.slugify(type));
            // },

            changeHandler(item){
                // request the top programs again using new degree
                this.getPopularPrograms(item.value);
            },

            getPopularPrograms(degree){
                // call the api method
                programApi.getPopularPrograms(degree, 8)
                    .then(response => {
                        // update the popular program list
                        this.popularPrograms = response.data.popularPrograms;
                        // update the school list corresponding to the programs
                        this.schoolsOfPrograms = response.data.schoolsOfPrograms;
                    })
            }
        },
        mounted() {
            // this.getFilteredSeller(this.topSellerIn);
        }
    }
</script>
