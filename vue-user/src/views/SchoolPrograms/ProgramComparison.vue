<template>
    <layout>
    <breadcrumb title="Program Comparison" current="Program Comparison"/>
    <div class="rn-product-area rn-section-gapTop">
            <div class="container">
                <div class="row g-5">
                    <div class="col-lg-4 custom-product-col">
                        <program-card-plus :p="'l'" :programId="l" v-if="l" @deleteSelf="deleteSelf" />

                    </div>
                    <div class="col-lg-4 custom-product-col">
                        <program-card-plus :p="'r'" :programId="r" v-if="r" @deleteSelf="deleteSelf" />
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
                            <my-program-list-sidebar-plus :current-user="currentUser"
                                                     :applications="applications"
                                                     @reloadData="reloadData"/>
                            <!-- End My Program List area -->
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </layout>
</template>

<script>
    import Layout from '@/components/layouts/Layout'
    import router from "@/router";
    import Breadcrumb from '@/components/breadcrumb/Breadcrumb'
    import ProductCard from '@/components/product/ProductCard'
    import ShareModal from '@/components/modal/ShareModal'
    import ReportModal from '@/components/modal/ReportModal'
    import Countdown from '@/components/product/Countdown'
    import PlacebidModal from '@/components/modal/PlacebidModal'
    import ProgramCardPlus from '@/components/myComp/program/ProgramCardPlus'
    import applicationListMixin from "@/mixins/user/ApplicationListMixin";
    import MyProgramListSidebarPlus from "@/components/myComp/MyProgramListSidebarPlus.vue";
    // import programApi from "@/api/program"
    // import ProductMixin from "@/mixins/ProductMixin";
    // import TopSchoolItem from "@/components/myComp/homePageComp/TopSchoolItem.vue";
    import request from "@/utils/request";
    import VirtualCampusTourFrame from "@/components/myComp/VirtualCampusTourFrame";
    // import programSelectionApi from "@/api/programSelection";
    import cookie from "js-cookie";
    import Toastify from "toastify-js";

    // import profileApi from "@/api/profile";

    export default {

        name: 'ProgramComparison',
        components: {
            // TopSchoolItem,
            PlacebidModal,
            Countdown,
            ReportModal,
            ShareModal,
            ProductCard,
            Breadcrumb,
            MyProgramListSidebarPlus,
            Layout,
            VirtualCampusTourFrame,
            ProgramCardPlus
        },
        mixins: [applicationListMixin],
        data() {
            return {
                currentUser: {},
                r: null,
                l: null,
                // schoolId: this.$route.params.id.split("X")[1],
                // product: {},
                // activeTabIndex: 0,
                // relatedSchools: [],
                // relatedPrograms: [],
                // school: {},

                // selectedPrograms: [],
                // selectedProgramIDs: [],
                // programSelected: false,
            }
        },
        methods: {
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
                    // console.log(this.applications)

                    // this.getBackground();

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
            reloadData(id){
                if (this.l == null) this.l = id
                else if (this.l != null && this.r == null){
                    this.r = id
                }
            },

            deleteSelf(t){
                console.log(t)
                if (t == 'l') this.l = null
                else this.r = null
                // this.idList = this.idList.filter(item => {return item != id})
            }


        },
        created() {
            this.getCurrentUser();

        },
        watch: {
            '$route.params.id': function (val) {
                this.id = this.$route.params.id,
                this.getProduct(this.id);
            }
        },
    }
</script>
