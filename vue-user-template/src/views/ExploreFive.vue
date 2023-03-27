<template>
    <layout>
        <breadcrumb title="Explore With Place Bid" current="Explore With Place Bid"/>

        <div class="rn-new-items rn-section-gapTop">
            <div class="container">
                <div class="row g-5">
                    <template v-for="(item, index) in products"
                              :key="`newest-item-${index}`">
                        <div :class="[`col-5 col-lg-4 col-md-6 col-sm-6 col-12`, {'more-product d-none': index > 9}]"
                             data-sal="slide-up"
                             :data-sal-delay="150+index"
                             data-sal-duration="800">
                            <product-card
                                :product-date="item"
                                :show-place-bid="true"
                                product-style-class="no-overlay with-placeBid"
                            />
                        </div>
                    </template>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="view-more-btn mt--50">
                            <a class="btn btn-primary-alta btn-large w-100" href="#" @click.prevent="showMoreProduct">View More Items</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <share-modal/>

        <report-modal/>
    </layout>
</template>

<script>
    import Layout from '@/components/layouts/Layout'
    import Breadcrumb from '@/components/breadcrumb/Breadcrumb'
    import ProductCard from '@/components/product/ProductCard'
    import ShareModal from '@/components/modal/ShareModal'
    import ReportModal from '@/components/modal/ReportModal'
    import SalScrollAnimationMixin from '@/mixins/SalScrollAnimationMixin'
    import ProductMixin from '@/mixins/ProductMixin'

    export default {
        name: 'ExploreFive',
        components: {ReportModal, ShareModal, ProductCard, Breadcrumb, Layout},
        mixins: [SalScrollAnimationMixin, ProductMixin],
        methods: {
            showMoreProduct() {
                const moreItems = document.querySelectorAll('.more-product');
                moreItems.forEach(item => {
                    item.classList.remove('d-none');
                })
            }
        }
    }
</script>