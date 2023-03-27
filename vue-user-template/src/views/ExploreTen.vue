<template>
    <layout>
        <breadcrumb title="Explore Style Column Two" current="Explore Style Column Two"/>

        <div class="rn-product-area rn-section-gapTop">
            <div class="container">
                <explore-list-style :is-two-column="true"/>
            </div>
        </div>

        <share-modal/>

        <report-modal/>

        <placebid-modal/>
    </layout>
</template>

<script>
    import Layout from "@/components/layouts/Layout";
    import Breadcrumb from "@/components/breadcrumb/Breadcrumb";
    import ExploreListStyle from "@/components/explore/ExploreListStyle";
    import NotificationListSidebar from "@/components/notification/NotificationListSidebar";
    import CreatorListSidebar from "@/components/seller/CreatorListSidebar";
    import ShareModal from "@/components/modal/ShareModal";
    import ReportModal from "@/components/modal/ReportModal";
    import PlacebidModal from "@/components/modal/PlacebidModal";

    export default {
        name: 'ExploreTen',
        components: {
            PlacebidModal,
            ReportModal,
            ShareModal, CreatorListSidebar, NotificationListSidebar, ExploreListStyle, Breadcrumb, Layout}
    }
</script>