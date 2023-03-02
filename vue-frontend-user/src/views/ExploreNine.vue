<template>
    <layout>
        <breadcrumb title="Explore Style List" current="Explore Style List"/>

        <div class="rn-product-area rn-section-gapTop">
            <div class="container">
                <div class="row g-5">
                    <div class="col-lg-8 custom-product-col">
                        <explore-list-style/>
                    </div>
                    <div class="col-lg-4 custom-product-col">
                        <div class="header-right-fixed position-sticky product-notify-wrapper rbt-sticky-top-adjust-four mt--95 mt_md--20 mt_sm--15">
                            <!-- Notification area -->
                            <notification-list-sidebar/>
                            <!-- Notification area End -->

                            <!-- Start creators area -->
                            <creator-list-sidebar/>
                            <!-- End creators area -->
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <share-modal/>

        <report-modal/>

        <placebid-modal/>
    </layout>
</template>

<script>
    import Layout from '@/components/layouts/Layout'
    import Breadcrumb from '@/components/breadcrumb/Breadcrumb'
    import NotificationListSidebar from '@/components/notification/NotificationListSidebar'
    import CreatorListSidebar from '@/components/seller/CreatorListSidebar'
    import PlacebidModal from '@/components/modal/PlacebidModal'
    import ExploreListStyle from '@/components/explore/ExploreListStyle'
    import ShareModal from '@/components/modal/ShareModal'
    import ReportModal from '@/components/modal/ReportModal'

    export default {
        name: 'ExploreNine',
        components: {
            ReportModal,
            ShareModal,
            ExploreListStyle,
            PlacebidModal,
            CreatorListSidebar,
            NotificationListSidebar,
            Breadcrumb,
            Layout
        }
    }
</script>

<style lang="scss" scoped>
    .header-right-fixed {
        top: 90px;
    }
</style>