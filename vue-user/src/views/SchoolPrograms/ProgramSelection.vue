<template>
    <layout>
        <breadcrumb title="Program Selection List" current="Program Selection List"/>

        <div class="rn-product-area rn-section-gapTop">
            <div class="container">
                <div class="row g-5">
                    <div class="col-lg-8 custom-product-col">
<!--                        <explore-list-style/>-->
                        <program-listing :current-user="currentUser"
                                         @reloadData="reloadData"
                                         ref="childCompProgramListing"/>
                    </div>
                    <div class="col-lg-4 custom-product-col">
                        <div class="header-right-fixed position-sticky product-notify-wrapper rbt-sticky-top-adjust-four mt--95 mt_md--20 mt_sm--15">
                            <!-- Notification area -->
<!--                            <notification-list-sidebar/>-->
                            <!-- Notification area End -->

                            <!-- Start creators area -->
<!--                            <creator-list-sidebar/>-->
                            <!-- End creators area -->

                            <!-- Start My Program List area -->
                            <my-program-list-sidebar :app-list-mixin-load-school-count="appListMixinLoadSchoolCount"
                                                     :current-user="currentUser"
                                                     :applications="applications"
                                                     @reloadData="reloadData"/>
                            <!-- End My Program List area -->
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
    // self
    import MyProgramListSidebar from "@/components/myComp/MyProgramListSidebar.vue";
    import ProgramListing from "@/components/myComp/ProgramListing.vue";
    import cookie from "js-cookie";
    import router from "@/router";
    import app from "@/App.vue";
    import applicationListMixin from "@/mixins/user/ApplicationListMixin";

    export default {
        name: 'ExploreNine',
        computed: {
            app() {
                return app
            }
        },
        mixins: [applicationListMixin],
        components: {
            ReportModal,
            ShareModal,
            ExploreListStyle,
            PlacebidModal,
            CreatorListSidebar,
            NotificationListSidebar,
            Breadcrumb,
            Layout,
            MyProgramListSidebar,
            ProgramListing
        },
        data(){
            return{
                currentUser: {}
            }
        },
        created() {

            this.getCurrentUser();

        },
        mounted() {
            // load data for the child program-listing component only if user logged in
            if (cookie.get("current_user")){
                // load data for the child program-listing component
                // fetch data of programs
                this.$refs.childCompProgramListing.getPrograms();
                // fetch data of user selected programs
                this.$refs.childCompProgramListing.getUserSelectedPrograms();
            }
        },
        methods: {
            // get current user info from cookie
            getCurrentUser(){
                // we have stored this when logging in
                let userStr = cookie.get("current_user");
                // turn json string to json obj
                if (userStr){
                    this.currentUser = JSON.parse(userStr);
                    // load the applications of this user
                    this.getApplications(this.currentUser.id);
                    // load data for the child program-listing component
                    // but this should be in the stage of mounted
                    // otherwise we cannot refer to the child component

                }else{
                    // user should be redirected to the login page if not logged in
                    window.alert("You should login first!");
                    router.push({path: '/login'});
                }
            },

            // to fetch data again for updating showing
            reloadData(){
                // get the current user and their applications again
                this.getCurrentUser();
                // update the user selected programs (for the left listing part)
                this.$refs.childCompProgramListing.getUserSelectedPrograms();
            }
        }
    }
</script>

<style lang="scss" scoped>
    .header-right-fixed {
        top: 90px;
    }
</style>
