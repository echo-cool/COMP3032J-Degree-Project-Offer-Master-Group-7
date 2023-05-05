<template>
    <layout>
        <!-- Start Banner Area -->
        <div class="rn-about-banner-area rn-section-gapTop">
            <div class="container mb--30">
                <div class="row">
                    <div class="col-12">
                        <h2 class="title about-title-m"
                            data-sal="slide-up"
                            data-sal-duration="800"
                            data-sal-delay="150">
                            Our Teams. <br>For Your Dedicated Dreams
                        </h2>
                    </div>
                </div>
            </div>
            <div class="container-fluid about-fluidimg ">
                <div class="row">
                    <div class="img-wrapper">
                        <div class="bg_image--22 bg_image"/>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row g-5">
                    <div class="col-lg-6">
                        <div class="h--100">
                            <div class="rn-about-card mt_dec--50 widge-wrapper rbt-sticky-top-adjust">
                                <div class="inner">
                                    <h2 class="title"
                                        data-sal="slide-up"
                                        data-sal-duration="800"
                                        data-sal-delay="150">
                                        Our Motivation
                                    </h2>
                                    <p class="about-disc"
                                       data-sal="slide-up"
                                       data-sal-duration="800"
                                       data-sal-delay="150">
                                        To free applicants from collecting useful data from massive information,
                                        we provide a University Database module for browsing the information of schools and programs.
                                        Furthermore, applicants with little experience in applying may need some online tools to assist
                                        with their program choosing, essay writing, etc. Therefore, we provide helpful functionalities
                                        based on our University Database module, such as the essay refinement and GPA conversion.
                                        The functionalities like GPA conversion will also be used to support the recommendation system,
                                        which is the core feature of this platform.
                                        To help users learn from others’ application experiences, we
                                        provide an application community module to maintain the latest information.
                                    </p>
                                    <router-link to="/community"
                                                 class="btn btn-primary-alta btn-large sal-animate mt--20"
                                                 data-sal="slide-up"
                                                 data-sal-duration="800"
                                                 data-sal-delay="150">
                                        See Our Community
                                    </router-link>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="rn-about-card transparent-bg">
                            <div class="inner">
                                <h3 class="title" data-sal="slide-up" data-sal-duration="800" data-sal-delay="150">
                                    Helping Candidates <br>Throughout Their Application Process.
                                </h3>
                                <p class="about-disc mb--0"
                                   data-sal="slide-up"
                                   data-sal-duration="800"
                                   data-sal-delay="150">
                                    Our team is dedicated to developing an online website for potential
                                    graduate students to choose their appropriate programs and simplify their applications, which would
                                    mainly provide comprehensive information about universities and recommend suitable programs for
                                    them based on their own application backgrounds.
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Banner Area -->

        <div class="rn-about-Quote-area rn-section-gapTop">
            <div class="container">
                <div class="row g-5 d-flex align-items-center">
                    <div class="col-lg-6">
                        <div class="rn-about-title-wrapper">
                            <h3 class="title" data-sal="slide-up" data-sal-duration="800" data-sal-delay="150">
                                Lay a Solid Foundation for your Application Success
                            </h3>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="rn-about-wrapper" data-sal="slide-up" data-sal-duration="800" data-sal-delay="150">
                            <p>
                                Our company is dedicated to web application development with excellent user experience, high
                                performance, and stability. Our potential users are those who aim to apply to overseas universities. Our
                                platform provides applicants with one-stop application support, such as program selection, admission community, etc. The program recommendation
                                based on applicants’ backgrounds is our key feature.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Start Statistics Area -->
        <div class="rn-statistick-area rn-section-gapTop">
            <div class="container">
                <div class="row mb--30">
                    <div class="col-12 text-center">
                        <h3>Application Statistics</h3>
                    </div>
                </div>
                <div class="row g-5">
                    <div class="offset-lg-2 col-lg-4 col-md-6">
                        <div class="single-counter-up text-center">
                            <Waypoint @change="onChange">
                                <div v-if="startCounter" class="number counter-odomitter-active">
                                    <count-up :startVal="0" :endVal="100" :duration="5" class="d-inline-block"/>
                                </div>
                            </Waypoint>
                            <div class="botton-title">North America</div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6">
                        <div class="single-counter-up text-center">
                            <Waypoint @change="onChange">
                                <div v-if="startCounter" class="number counter-odomitter-active">
                                    <count-up :startVal="0" :endVal="500" :duration="5" class="d-inline-block"/>
                                </div>
                            </Waypoint>
                            <div class="botton-title">Europe</div>
                        </div>
                    </div>
                    <div class="offset-lg-2 col-lg-4 col-md-6">
                        <div class="single-counter-up text-center">
                            <Waypoint @change="onChange">
                                <div v-if="startCounter" class="number counter-odomitter-active">
                                    <count-up :startVal="0" :endVal="700" :duration="5" class="d-inline-block"/>
                                </div>
                            </Waypoint>
                            <div class="botton-title">England</div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6">
                        <div class="single-counter-up text-center">
                            <Waypoint @change="onChange">
                                <div v-if="startCounter" class="number counter-odomitter-active up-plus">
                                    <count-up :startVal="0" :endVal="900" :duration="5" class="d-inline-block"/>
                                </div>
                            </Waypoint>
                            <div class="botton-title">Hongkong</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Statistics Area -->

        <!-- Start CTA Area -->
        <div class="rn-callto-action rn-section-gapTop">
            <div class="container-fluid about-fluidimg-cta">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="bg_image--6 bg_image bg-image-border" data-black-overlay="7">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="call-to-action-wrapper">
                                        <h3 data-sal="slide-up" data-sal-duration="800" data-sal-delay="150">
                                            Discover Programs <br> Best Match You
                                        </h3>
                                        <p data-sal="slide-up" data-sal-duration="800" data-sal-delay="150">
                                            Let us get started! Using Offer Master to help you success in your application process and
                                            maximize your strengths.
                                        </p>
                                        <div class="callto-action-btn-wrapper"
                                             data-sal="slide-up"
                                             data-sal-duration="800"
                                             data-sal-delay="150">
                                            <router-link to="/program-selection" class="btn btn-primary btn-large">
                                                Create
                                            </router-link>
                                            <router-link to="/contact" class="btn btn-primary-alta btn-large">
                                                Contact Us
                                            </router-link>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End CTA Area -->

        <!-- Start BLog Area  -->
        <div class="rn-blog-area rn-section-gapTop">
            <div class="container">
                <div class="row mb--50 align-items-center">
                    <div class="col-lg-6 col-md-6 col-sm-6 col-12">
                        <h3 class="title mb--0" data-sal-delay="150" data-sal="slide-up" data-sal-duration="800">
                            Our Recent Blog
                        </h3>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-6 col-12 mt_mobile--15">
                        <div class="view-more-btn text-start text-sm-end"
                             data-sal-delay="150"
                             data-sal="slide-up"
                             data-sal-duration="800">
                            <router-link class="btn-transparent" to="/blog">
                                VIEW ALL<i class="feather-arrow-right"/>
                            </router-link>
                        </div>
                    </div>
                </div>
                <div class="row g-5">
                    <template v-for="(blog, index) in posts" :key="`blog-${index}`">
                        <div v-if="index < 4"
                             class="col-xl-3 col-lg-4 col-md-6 col-12"
                             data-sal="slide-up"
                             data-sal-duration="800"
                             data-sal-delay="150"
                             style="transform: none;">
                            <blog-card :blog="blog"/>
                        </div>
                    </template>
                </div>
            </div>
        </div>
        <!-- End BLog Area  -->
    </layout>
</template>

<script>
    import CountUp from 'vue-countup-v3'
    import { Waypoint } from 'vue-waypoint'
    import Layout from "@/components/layouts/Layout";
    import BlogCard from "@/components/blog/BlogCard";
    import SalScrollAnimationMixin from "@/mixins/SalScrollAnimationMixin";
    import BlogMixin from "@/mixins/BlogMixin";

    export default {
        name: 'About',
        components: {BlogCard, Layout, CountUp, Waypoint},
        mixins: [SalScrollAnimationMixin, BlogMixin],
        data() {
            return {
                startCounter: false
            }
        },
        methods: {
            onChange(waypointState) {
                if (waypointState.going === 'IN') {
                    this.startCounter = true;
                }
            }
        }
    }
</script>
