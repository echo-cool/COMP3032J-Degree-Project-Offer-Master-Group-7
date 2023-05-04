<template>
    <layout>
        <!-- Start banner area -->
        <div class="banner-style-4 rn-section-gapTop">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-xl-6 col-lg-6 col-md-12 order-2 order-lg-1 mt_md--40 mt_sm--40">
                        <div class="sldier-content">
                            <span class="title-badge" data-sal="slide-up" data-sal-delay="150" data-sal-duration="800">
                                OfferMaster Graduate Application Helper
                            </span>
                            <h2 class="title" data-sal="slide-up" data-sal-delay="200" data-sal-duration="800">
                                Get Recommended Programs for You
                            </h2>
                            <p class="banner-disc-one" data-sal="slide-up" data-sal-delay="250" data-sal-duration="800">
                                We can recommend you graduate programs that are the best fit for
                                <br> your academic background, which can maximize the success rate
                                <br> of your application.
                            </p>
                            <div class="button-group">
                                <router-link to="/program-selection" class="btn btn-large btn-primary" data-sal="slide-up" data-sal-delay="300" data-sal-duration="800">Get Started</router-link>
                                <router-link to="/edit-profile?to=application" class="btn btn-large btn-primary-alta" data-sal="slide-up" data-sal-delay="300" data-sal-duration="800">Complete Background</router-link>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-6 col-lg-6 col-md-12 order-1 order-lg-2">
                        <div class="slider slick-activation-04">
                            <banner-carousel/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End banner area -->

        <!-- Start Application Tools Area -->
        <application-tools/>
        <!-- End Application Tools Area -->

        <!-- Start My program carousel Area -->
<!--        <my-program-list-timer-carousel v-if="this.currentUser.id"-->
<!--                                        :title="`Due Date Countdown of My Selected Programs`"-->
<!--                                        :applications="applications"/>-->
        <!-- End My program carousel Area -->
        <div class="about-market-area rn-section-gapTop">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="about-wrapper text-center">
                            <h1>Our Competitiveness</h1>
                            <p class="discription">
                                Offer master website features the program and university recommendation (highlighting matched programs),
                                university database (used for searching and recommendation system training), applicant background system
                                and the applicants' community with the admission information and the recent offer timelines.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Start OfferMaster Guide Area -->
        <offer-master-guide/>
        <!-- End OfferMaster Guide Area -->


        <!-- About Graduate Application Start -->
        <div class="about-market-area rn-section-gapTop">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="about-wrapper text-center">
                            <h1>Best Global Universities for Computer Science</h1>
                            <p class="discription">
                                Offer Master platform is experienced in assisting applicants in applying for
                                programs. To fulfill our objective, we have formalized a list of the top 100
                                American institutions and colleges following the just-released QS World University Rankings 2023.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- About Graduate Application End -->

        <!-- Start Top School Area -->
        <top-schools/>

        <!-- End Top School Area -->
        <div class="about-market-area rn-section-gapTop">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="about-wrapper text-center">
                            <h1>Best Global Programs for Computer Science</h1>
                            <p class="discription">
                                Computer science covers a broad variety of topics.
                                Programming languages, information systems, artificial intelligence theory, and information technology are typical
                                study of computer science and how they are used.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Top Top Program Start -->
        <top-programs/>
        <!-- Top Top Program End -->

<!--         Top Explore Programs Start-->
        <explore-filter-programs :query="''"
                                 :limit="20"
                                 :current-user="currentUser"/>

<!--         Top Explore Programs End-->
        <chat-box1></chat-box1>
    </layout>
</template>

<script>
    import Layout from "@/components/layouts/Layout";
    import BannerCarousel from "@/components/myComp/homePageComp/BannerCarousel.vue";
    import SalScrollAnimationMixin from "@/mixins/SalScrollAnimationMixin";
    import ApplicationListMixin from "@/mixins/user/ApplicationListMixin";

    import MyProgramListTimerCarousel from "@/components/myComp/homePageComp/MyProgramListTimerCarousel.vue";
    import TopSchools from "@/components/myComp/homePageComp/TopSchools.vue";
    import TopPrograms from "@/components/myComp/homePageComp/TopPrograms.vue";
    import OfferMasterGuide from "@/components/myComp/homePageComp/OfferMasterGuide.vue";
    import ApplicationTools from "@/components/myComp/homePageComp/ApplicationTools.vue";
    import ExploreFilterPrograms from "@/components/myComp/homePageComp/ExploreFilterPrograms.vue";

    import cookie from "js-cookie";
    import ChatBox1 from "@/components/wyy/ChatBox1.vue";
    import Toastify from 'toastify-js'
    import "toastify-js/src/toastify.css"
    export default {
        name: 'HomePageFour',
        components: {
            BannerCarousel,
            Layout,
            MyProgramListTimerCarousel,
            TopSchools,
            TopPrograms,
            OfferMasterGuide,
            ApplicationTools,
            ExploreFilterPrograms,
            ChatBox1,
        },
        mixins: [SalScrollAnimationMixin, ApplicationListMixin],

        data(){
            return{
                currentUser: {},
            }
        },
        created() {
            Toastify({
                text: "Welcome to our site!",
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
            this.getCurrentUser();

        },
        methods: {
            // get current user info from cookie
            getCurrentUser(){
                // we have stored this when logging in
                let userStr = cookie.get("current_user");
                // turn json string to json obj
                if (userStr && userStr !== ""){
                    this.currentUser = JSON.parse(userStr);
                    console.log(this.currentUser);
                    // load the applications of this user
                    this.getApplications(this.currentUser.id);
                }
            }
        }
    }
</script>
