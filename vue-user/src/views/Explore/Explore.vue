<template>
    <layout>
        <breadcrumb title="Explore Programs" current="Explore Programs"/>

        <explore-filter-programs :query="query" :current-user="currentUser"/>
    </layout>
</template>

<script>
    import Layout from '@/components/layouts/Layout'
    import Breadcrumb from '@/components/breadcrumb/Breadcrumb'
    import SalScrollAnimationMixin from '@/mixins/SalScrollAnimationMixin'
    import ExploreFilterPrograms from "@/components/myComp/homePageComp/ExploreFilterPrograms";
    import cookie from "js-cookie";

    export default {
        name: 'Explore',
        components: {ExploreFilterPrograms, Breadcrumb, Layout},
        mixins: [SalScrollAnimationMixin],
        data() {
          return {
            currentUser: {},
            query: ""
          }
        },
        created() {
            this.getCurrentUser()
            this.query = this.$route.query.search
            console.log(this.query)
        },
        methods: {
          getCurrentUser(){
            // we have stored this when logging in
            let userStr = cookie.get("current_user");
            // turn json string to json obj
            if (userStr && userStr !== ""){
              this.currentUser = JSON.parse(userStr);
              // load the applications of this user
            }
          }
        }
    }
</script>
