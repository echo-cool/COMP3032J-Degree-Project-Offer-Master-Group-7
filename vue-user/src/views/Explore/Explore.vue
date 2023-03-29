<template>
    <layout>
        <breadcrumb title="Explore Filter" current="Explore Filter"/>

        <explore-filter-programs :query="query"/>
    </layout>
</template>

<script>
    import Layout from '@/components/layouts/Layout'
    import Breadcrumb from '@/components/breadcrumb/Breadcrumb'
    import SalScrollAnimationMixin from '@/mixins/SalScrollAnimationMixin'
    import ExploreFilterPrograms from "@/components/myComp/homePageComp/ExploreFilterPrograms";

    export default {
        name: 'Explore',
        components: {ExploreFilterPrograms, Breadcrumb, Layout},
        mixins: [SalScrollAnimationMixin],
        data() {
          return {
            query: ""
          }
        },
        created() {
            this.query = this.$route.query.search
            console.log(this.query)
        }
    }
</script>