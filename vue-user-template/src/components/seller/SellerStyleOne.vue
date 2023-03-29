<template>
    <div class="rn-top-top-seller-area nice-selector-transparent rn-section-gapTop">
        <div class="container">
            <div class="row mb--30">
                <div class="col-12 justify-sm-center d-flex" data-sal-delay="150" data-sal="slide-up" data-sal-duration="800">
                    <h3 class="title">
                        Top Seller in
                    </h3>
                    <nice-select
                        :options="[
                                { value: '1 Day', text: '1 day' },
                                { value: '7 Days', text: '7 Day\'s' },
                                { value: '15 Days', text: '15 Day\'s' },
                                { value: '30 Days', text: '30 Day\'s' }
                            ]"
                        :default-current="0"
                        name="sellerSort"
                        @onChange="changeHandler"
                    />
                </div>
            </div>
            <div class="row justify-sm-center g-5 top-seller-list-wrapper"
                 data-sal="slide-up"
                 data-sal-delay="150"
                 data-sal-duration="800">
                <template v-for="(seller, index) in filteredSeller"
                          :key="`seller-${index}`">
                    <div class="col-5 col-lg-3 col-md-4 col-sm-6 top-seller-list">
                        <seller :seller-data="seller"/>
                    </div>
                </template>
            </div>
        </div>
    </div>
</template>

<script>
    import NiceSelect from '@/components/select/NiceSelect'
    import Seller from '@/components/seller/Seller'
    import AuthorMixin from '@/mixins/AuthorMixin'
    import SalScrollAnimationMixin from "@/mixins/SalScrollAnimationMixin";
    import AppFunctions from "@/helpers/AppFunctions";

    export default {
        name: 'SellerStyleOne',
        components: {Seller, NiceSelect},
        mixins: [AuthorMixin, SalScrollAnimationMixin],
        data() {
            return {
                filteredSeller: '',
                topSellerIn: '1 Day'
            }
        },
        watch: {
            'topSellerIn': function (val) {
                this.getFilteredSeller(val)
            }
        },
        methods: {
            changeHandler(item) {
                this.topSellerIn = item.value;
            },
            getFilteredSeller(type) {
                this.filteredSeller = this.authors.filter(seller =>  AppFunctions.slugify(seller.topSince) === AppFunctions.slugify(type));
            },
        },
        mounted() {
            this.getFilteredSeller(this.topSellerIn);
        }
    }
</script>