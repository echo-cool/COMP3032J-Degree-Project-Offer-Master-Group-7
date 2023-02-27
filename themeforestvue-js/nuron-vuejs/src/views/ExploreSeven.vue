<template>
    <layout>
        <breadcrumb title="Place Bid With Isotope" current="Place Bid With Isotope"/>

        <explore-isotop :place-bid="true"/>
    </layout>
</template>

<script>
    import Layout from '@/components/layouts/Layout'
    import Breadcrumb from '@/components/breadcrumb/Breadcrumb'
    import SalScrollAnimationMixin from '@/mixins/SalScrollAnimationMixin'
    import ExploreIsotop from "@/components/explore/ExploreIsotop";

    export default {
        name: 'ExploreSeven',
        components: {ExploreIsotop, Breadcrumb, Layout},
        mixins: [SalScrollAnimationMixin]
    }
</script>