<template>
    <layout>
        <breadcrumb title="Our Product" current="Our Product"/>

        <explore-filter/>
    </layout>
</template>

<script>
    import Layout from '@/components/layouts/Layout'
    import Breadcrumb from '@/components/breadcrumb/Breadcrumb'
    import ExploreFilter from '@/components/explore/ExploreFilter'
    import SalScrollAnimationMixin from '@/mixins/SalScrollAnimationMixin'

    export default {
        name: 'Products',
        components: {ExploreFilter, Breadcrumb, Layout},
        mixins: [SalScrollAnimationMixin]
    }
</script>