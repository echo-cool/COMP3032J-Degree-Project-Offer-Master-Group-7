<template>
    <layout>
        <breadcrumb title="Explore Filter" current="Explore Filter"/>

        <explore-filter/>
    </layout>
</template>

<script>
    import Layout from '@/components/layouts/Layout'
    import Breadcrumb from '@/components/breadcrumb/Breadcrumb'
    import ExploreFilter from '@/components/explore/ExploreFilter'
    import SalScrollAnimationMixin from '@/mixins/SalScrollAnimationMixin'

    export default {
        name: 'ExploreOne',
        components: {ExploreFilter, Breadcrumb, Layout},
        mixins: [SalScrollAnimationMixin]
    }
</script>