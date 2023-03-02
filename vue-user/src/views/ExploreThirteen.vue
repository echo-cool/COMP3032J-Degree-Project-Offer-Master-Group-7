<template>
    <layout>
        <breadcrumb title="Live With Place Bid" current="Live With Place Bid"/>

        <explore-live :show-place-bid="true"/>

        <explore-live-carousel title="Live Bidding With Carousel" :show-place-bid="true"/>

        <share-modal/>

        <report-modal/>
    </layout>
</template>

<script>
    import Layout from '@/components/layouts/Layout'
    import Breadcrumb from '@/components/breadcrumb/Breadcrumb'
    import ExploreLive from '@/components/explore/ExploreLive'
    import ShareModal from '@/components/modal/ShareModal'
    import ReportModal from '@/components/modal/ReportModal'
    import SalScrollAnimationMixin from '@/mixins/SalScrollAnimationMixin'
    import ExploreLiveCarousel from "@/components/explore/ExploreLiveCarousel";

    export default {
        name: 'ExploreThirteen',
        components: {ExploreLiveCarousel, ReportModal, ShareModal, ExploreLive, Breadcrumb, Layout},
        mixins: [SalScrollAnimationMixin]
    }
</script>