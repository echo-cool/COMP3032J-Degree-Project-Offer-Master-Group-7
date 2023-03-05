<template>
    <layout>
        <breadcrumb title="Live Explore" current="Live Explore"/>

        <explore-live :show-title="false"/>

        <share-modal/>

        <report-modal/>
    </layout>
</template>

<script>
    import Layout from '@/components/layouts/Layout'
    import Breadcrumb from '@/components/breadcrumb/Breadcrumb'
    import ExploreLive from '@/components/explore/ExploreLive'
    import SalScrollAnimationMixin from '@/mixins/SalScrollAnimationMixin'
    import ShareModal from '@/components/modal/ShareModal'
    import ReportModal from '@/components/modal/ReportModal'

    export default {
        name: 'ExploreEleven',
        components: {ReportModal, ShareModal, ExploreLive, Breadcrumb, Layout},
        mixins: [SalScrollAnimationMixin]
    }
</script>