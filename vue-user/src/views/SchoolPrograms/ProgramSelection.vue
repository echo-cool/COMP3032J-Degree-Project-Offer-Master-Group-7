<template>
    <layout>
        <breadcrumb title="Program Selection List" current="Program Selection List"/>

        <div class="rn-product-area rn-section-gapTop">
            <div class="container">
                <div class="row g-5">
                    <div class="col-lg-8 custom-product-col">

<!--                      Background Card-->
                        <div class="col-lg-11 col-md-6 col-sm-6 col-12 mb--50" v-if="background !== null">
                          <div class="rn-address rn-service-one">
<!--                            <div class="icon">-->
<!--                              <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"-->
<!--                                   fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"-->
<!--                                   stroke-linejoin="round" class="feather feather-headphones">-->
<!--                                <path d="M3 18v-6a9 9 0 0 1 18 0v6"></path>-->
<!--                                <path-->
<!--                                    d="M21 19a2 2 0 0 1-2 2h-1a2 2 0 0 1-2-2v-3a2 2 0 0 1 2-2h3zM3 19a2 2 0 0 0 2 2h1a2 2 0 0 0 2-2v-3a2 2 0 0 0-2-2H3z">-->
<!--                                </path>-->
<!--                              </svg>-->
<!--                            </div>-->
                            <div class="inner">
                              <div class="icon">
                                <img src="/img/shape-1.a3cb4828.png" alt="Shape">
                              </div>
                              <h4 class="title">Your Background For Recommendation</h4>
                              <p class="mb--30">
                                <span class="mr--50"><strong class="color-green">GPA: </strong>{{ background.gpa }}</span>
                                <span class="mr--50"><strong class="color-green">Rank: </strong>{{ background.rank }}</span>
                              </p>
                              <p class="mb--30">
                                <span class="mr--50"><strong class="color-green">Undergraduate School Level: </strong>{{ background.underGradSchoolCate }}</span>
                              </p>
                              <p class="mb--30">
                                <span class="mr--50"><strong class="color-green">Undergraduate Major: </strong>{{ background.underGradMajor }}</span>
                              </p>
                              <p class="mb--30" v-if="background.testType === `IELTS`">
                                <span class="mr--50"><strong class="color-green">IELTS: </strong>{{ background.totalIELTS }}</span>
                                <span class="mr--50"><strong class="color-green">LISTENING: </strong>{{ background.listeningIELTS }}</span>
                                <span class="mr--50"><strong class="color-green">READING: </strong>{{ background.readingIELTS }}</span>
                                <span class="mr--50"><strong class="color-green">WRITING: </strong>{{ background.writingIELTS }}</span>
                                <span class="mr--50"><strong class="color-green">SPEAKING: </strong>{{ background.speakingIELTS }}</span>
                              </p>
                              <p class="mb--30" v-else-if="background.testType === `TOEFL`">
                                <span class="mr--50"><strong class="color-green">IELTS: </strong>{{ background.totalTOEFL }}</span>
                                <span class="mr--50"><strong class="color-green">LISTENING: </strong>{{ background.listeningTOEFL }}</span>
                                <span class="mr--50"><strong class="color-green">READING: </strong>{{ background.readingTOEFL }}</span>
                                <span class="mr--50"><strong class="color-green">WRITING: </strong>{{ background.writingTOEFL }}</span>
                                <span class="mr--50"><strong class="color-green">SPEAKING: </strong>{{ background.speakingTOEFL }}</span>
                              </p>
                              <p class="mb--30">
                                <span class="mr--50"><strong class="color-green">GRE: </strong>{{ background.greTotal }}</span>
                                <span class="mr--50"><strong class="color-green">VERBAL: </strong>{{ background.greVerbal }}</span>
                                <span class="mr--50"><strong class="color-green">QUANTITATIVE: </strong>{{ background.greQuantitative }}</span>
                                <span class="mr--50"><strong class="color-green">ANALYTICAL WRITING: </strong>{{ background.greAnalyticalWriting }}</span>
                              </p>
                            </div>
                            <router-link class="over-link" to="/edit-profile?to=application"></router-link>
                          </div>
                        </div>

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
    import commonApi from "@/api/common";
    import OfferMasterGuide from "@/components/myComp/homePageComp/OfferMasterGuide";

    export default {
        name: 'ExploreNine',
        computed: {
            app() {
                return app
            }
        },
        mixins: [applicationListMixin, OfferMasterGuide],
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

                    this.getBackground();

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
