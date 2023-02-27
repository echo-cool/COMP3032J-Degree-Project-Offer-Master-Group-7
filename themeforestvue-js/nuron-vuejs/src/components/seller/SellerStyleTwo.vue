<template>
    <div class="rn-creator-title-area rn-section-gapTop">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-6 col-md-6 col-sm-6 col-12" data-sal-delay="150" data-sal="slide-up" data-sal-duration="800">
                    <h2 class="title mb--0">
                        Our Best Creators
                    </h2>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6 col-12 mt_mobile--15">
                    <div class="shortby-default text-start text-sm-end">
                        <label class="filter-leble">SHOT BY:</label>
                        <nice-select
                            :options="[
                                    {value: 'Top Rated', text: 'Top Rated'},
                                    {value: 'Best Seller', text: 'Best Seller'},
                                    {value: 'Recent Added', text: 'Recent Added'},
                                    {value: 'Varified', text: 'Varified'}
                                ]"
                            :default-current="0"
                            name="sellerSort"
                            @onChange="changeHandler"
                        />
                    </div>
                </div>
            </div>
            <div class="row g-5 mt--30 creator-list-wrapper"
                 data-sal="slide-up"
                 data-sal-delay="150"
                 data-sal-duration="800">
                <div class="creator-single col-lg-3 col-md-4 col-sm-6"
                     v-for="(seller, index) in sortByStatusSeller"
                     :key="`seller-${index}`">
                    <seller :seller-data="seller" seller-style-class="explore"/>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import NiceSelect from '@/components/select/NiceSelect'
    import Seller from '@/components/seller/Seller'
    import AuthorMixin from '@/mixins/AuthorMixin'
    import AppFunctions from '@/helpers/AppFunctions'

    export default {
        name: 'SellerStyleTwo',
        components: {Seller, NiceSelect},
        mixins: [AuthorMixin],
        data() {
            return {
                sortByStatusSeller: '',
                sortStatus: 'top rated'
            }
        },
        watch: {
            'sortStatus': function (val) {
                this.getSellerByStatus(val)
            }
        },
        methods: {
            changeHandler(item) {
                this.sortStatus = item.value;
            },
            getSellerByStatus(type) {
                this.sortByStatusSeller = this.authors.filter(seller =>  AppFunctions.slugify(seller.status) === AppFunctions.slugify(type));
            }
        },
        mounted() {
            this.getSellerByStatus(this.sortStatus);
        }
    }
</script>