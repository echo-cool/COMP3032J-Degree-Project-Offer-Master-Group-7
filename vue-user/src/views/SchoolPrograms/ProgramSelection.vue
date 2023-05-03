<template>
    <layout>
        <breadcrumb title="AI Program Recommendation" current="AI Program Recommendation"/>

        <div class="rn-product-area rn-section-gapTop">
            <div class="container">
                <div class="row g-5">
                    <div class="col-lg-8 custom-product-col">

                        <!-- Background Card -->
                        <background-card :background="background" :card-title="`Your Background For Recommendation`" :is-editable="true"/>
                        <!-- Background Card End -->


                        <explore-live-carousel :current-user="currentUser"
                                               @reloadData="reloadData"
                                               ref="childCarouselProgram"
                                              />

<!--                        <explore-list-style/>-->
                        <program-listing :current-user="currentUser"
                                         @reloadData="reloadData"
                                         ref="childCompProgramListing"/>
                    </div>
                    <div class="col-lg-4 custom-product-col">
                        <div class="header-right-fixed position-sticky product-notify-wrapper rbt-sticky-top-adjust-four mt_md--20 mt_sm--15">
                            <!-- Notification area -->
<!--                            <notification-list-sidebar/>-->
                            <!-- Notification area End -->

                            <!-- Start creators area -->
<!--                            <creator-list-sidebar/>-->
                            <!-- End creators area -->

                            <!-- Start My Program List area -->
                            <my-program-list-sidebar :current-user="currentUser"
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
    import commonApi from "@/api/common";
    import OfferMasterGuide from "@/components/myComp/homePageComp/OfferMasterGuide";
    import BackgroundCard from "@/components/myComp/background/BackgroundCard.vue";
    import ExploreLive from "@/components/explore/ExploreLive";
    import ExploreLiveCarousel from "@/components/explore/ExploreLiveCarousel";
    import Toastify from "toastify-js";

    export default {
        name: 'ExploreNine',
        computed: {
            app() {
                return app
            }
        },
        mixins: [applicationListMixin, OfferMasterGuide],
        components: {
            ExploreLiveCarousel,
            ReportModal,
            ShareModal,
            ExploreListStyle,
            PlacebidModal,
            CreatorListSidebar,
            NotificationListSidebar,
            Breadcrumb,
            Layout,
            MyProgramListSidebar,
            ProgramListing,
            BackgroundCard
        },
        data(){
            return{
                currentUser: {},
                background: null
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
                this.$refs.childCompProgramListing.getProgramsKNN();
                // fetch data of user selected programs
                this.$refs.childCompProgramListing.getUserSelectedPrograms();
                this.$refs.childCarouselProgram.getPrograms();
                this.$refs.childCarouselProgram.getUserSelectedPrograms();
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

                    this.getBackground();

                }else{
                    // user should be redirected to the login page if not logged in
                    Toastify({
                        text: "You should login first!",
                        duration: 3000,
                        close: false,
                        // avatar:"/img/logo-dark.44b49d43.png",
                        gravity: "top", // `top` or `bottom`
                        position: "right", // `left`, `center` or `right`
                        stopOnFocus: false, // Prevents dismissing of toast on hover
                        style: {
                            "font-size": "large",
                            "font-family":"\"Roboto\", sans-serif",
                            background: "linear-gradient(to right, #00b09b, #96c93d)",
                        },
                        onClick: function(){} // Callback after click
                    }).showToast();
                    // window.alert("You should login first!");
                    router.push({path: '/login'});
                }
            },

            // to fetch data again for updating showing
            reloadData(){
                // get the current user and their applications again
                this.getCurrentUser();
                // update the user selected programs (for the left listing part)
                this.$refs.childCompProgramListing.getUserSelectedPrograms();
                this.$refs.childCarouselProgram.getUserSelectedPrograms();

                this.$refs.childCarouselProgram.getPrograms();
            },

            getBackground() {
                let profileURL = `/rest/users/${this.currentUser.id}/profile`;
                commonApi.getByRestURL(profileURL).then(response => {
                    this.background = response
                })
            }
        }
    }
</script>

<style lang="scss" scoped>
    .header-right-fixed {
        top: 90px;
    }
</style>
