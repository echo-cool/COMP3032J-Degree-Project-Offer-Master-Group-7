<template>
    <layout>
        <breadcrumb title="Place Bid With Filter" current="Place Bid With Filter"/>

        <explore-filter-with-placebid/>
    </layout>
</template>

<script>
    import Layout from "@/components/layouts/Layout";
    import Breadcrumb from "@/components/breadcrumb/Breadcrumb";
    import ExploreFilterWithPlacebid from "@/components/explore/ExploreFilterWithPlacebid";
    import SalScrollAnimationMixin from "@/mixins/SalScrollAnimationMixin";

    export default {
        name: 'ExploreSix',
        components: {ExploreFilterWithPlacebid, Breadcrumb, Layout},
        mixins: [SalScrollAnimationMixin]
    }
</script>