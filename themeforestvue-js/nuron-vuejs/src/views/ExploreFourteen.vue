<template>
    <layout>
        <breadcrumb title="Explore Style Left Side Filter" current="Explore Style Left Side Filter"/>

        <ExploreFilterLeft/>

        <share-modal/>

        <report-modal/>
    </layout>
</template>

<script>
    import ReportModal from '@/components/modal/ReportModal'
    import ShareModal from '@/components/modal/ShareModal'
    import ProductCard from '@/components/product/ProductCard'
    import ExploreNewestItem from '@/components/explore/ExploreNewestItem'
    import Breadcrumb from '@/components/breadcrumb/Breadcrumb'
    import Layout from '@/components/layouts/Layout'
    import SalScrollAnimationMixin from '@/mixins/SalScrollAnimationMixin'
    import ProductMixin from '@/mixins/ProductMixin'
    import ExploreFilterLeft from '@/components/explore/ExploreFilterLeft'

    export default {
        name: 'ExploreFourteen',
        components: {ExploreFilterLeft, ReportModal, ShareModal, ProductCard, ExploreNewestItem, Breadcrumb, Layout},
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