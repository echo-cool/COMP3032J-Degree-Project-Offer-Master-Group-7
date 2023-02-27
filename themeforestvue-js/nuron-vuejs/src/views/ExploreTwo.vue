<template>
    <layout>
        <breadcrumb title="Explore Style Isotop" current="Explore Style Isotop"/>

        <explore-isotop/>
    </layout>
</template>

<script>
    import Layout from '@/components/layouts/Layout'
    import Breadcrumb from '@/components/breadcrumb/Breadcrumb'
    import SalScrollAnimationMixin from '@/mixins/SalScrollAnimationMixin'
    import ExploreIsotop from '@/components/explore/ExploreIsotop'

    export default {
        name: 'ExploreTwo',
        components: {ExploreIsotop, Breadcrumb, Layout},
        mixins: [SalScrollAnimationMixin]
    }
</script>