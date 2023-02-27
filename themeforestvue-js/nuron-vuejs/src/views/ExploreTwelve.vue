<template>
    <layout>
        <breadcrumb title="Live Explore Carousel" current="Live Explore Carousel"/>

        <explore-live-carousel title="Live Explore Carousel"/>

        <share-modal/>

        <report-modal/>
    </layout>
</template>

<script>
    import Layout from '@/components/layouts/Layout'
    import Breadcrumb from '@/components/breadcrumb/Breadcrumb'
    import ExploreLiveCarousel from '@/components/explore/ExploreLiveCarousel'
    import ShareModal from '@/components/modal/ShareModal'
    import ReportModal from '@/components/modal/ReportModal'
    import SalScrollAnimationMixin from '@/mixins/SalScrollAnimationMixin'

    export default {
        name: 'ExploreTwelve',
        components: {ReportModal, ShareModal, ExploreLiveCarousel, Breadcrumb, Layout},
        mixins: [SalScrollAnimationMixin]
    }
</script>