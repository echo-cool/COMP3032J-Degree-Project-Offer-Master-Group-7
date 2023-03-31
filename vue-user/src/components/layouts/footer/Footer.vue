<template>
    <div>
        <!-- Start Footer Area -->
        <div :class="[`rn-footer-one bg-color--1 mt--100 mt_md--80 mt_sm--80`, data.showFooterBrand ? 'rn-section-gapBottom' : 'rn-section-gap']">
            <div v-if="data.showFooterBrand" class="footer-top">
                <div class="container">
                    <div class="row">
                        <ul class="nu-brand-area">
                            <li><img :src="require(`@/assets/images/brand/brand-01.png`)" alt="nuron-brand_nft"></li>
                            <li><img :src="require(`@/assets/images/brand/brand-03.png`)" alt="nuron-brand_nft"></li>
                            <li><img :src="require(`@/assets/images/brand/brand-06.png`)" alt="nuron-brand_nft"></li>
                            <li><img :src="require(`@/assets/images/brand/brand-07.png`)" alt="nuron-brand_nft"></li>
                            <li><img :src="require(`@/assets/images/brand/brand-04.png`)" alt="nuron-brand_nft"></li>
                            <li><img :src="require(`@/assets/images/brand/brand-02.png`)" alt="nuron-brand_nft"></li>
                            <li><img :src="require(`@/assets/images/brand/brand-01.png`)" alt="nuron-brand_nft"></li>
                            <li><img :src="require(`@/assets/images/brand/brand-03.png`)" alt="nuron-brand_nft"></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row gx-5">
                    <div class="col-lg-3 col-md-6 col-sm-6 col-12">
                        <div class="widget-content-wrapper">
                            <div class="footer-left">
                                <logo/>
                                <p class="rn-footer-describe">
                                    Created with the collaboration of over 60 of the world's best Graduate Schools.
                                </p>
                            </div>
                            <div class="widget-bottom mt--40 pt--40">
                                <h6 class="title">Get The Latest OfferMaster Updates </h6>
                                <div class="input-group">
                                    <input type="text"
                                           class="form-control bg-color--2"
                                           placeholder="Your username"
                                           aria-label="Recipient's username">
                                    <div class="input-group-append">
                                        <button class="btn btn-primary-alta btn-outline-secondary" type="button">
                                            Subscribe
                                        </button>
                                    </div>
                                </div>
                                <div class="newsletter-dsc">
                                    <p>Email is safe. We don't spam.</p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6 col-sm-6 col-12 mt_mobile--40">
                        <div class="footer-widget widget-quicklink">
                            <h6 class="widget-title">OfferMaster</h6>
                            <ul class="footer-list-one">
                                <li class="single-list">
                                    <router-link to="/about">About Us</router-link>
                                </li>
                                <li class="single-list">
                                    <router-link to="/explore-decisions">Decision Reports</router-link>
                                </li>
                                <li class="single-list">
                                    <router-link to="/program-selection">Explore Schools</router-link>
                                </li>
                                <li class="single-list">
                                    <router-link to="/explore?search=">Explore Programs</router-link>
                                </li>
                                <li class="single-list">
                                    <router-link to="/program-selection">AI Recommendation</router-link>
                                </li>
                                <li class="single-list">
                                    <router-link to="/my-applications">My Applications</router-link>
                                </li>
                                <li class="single-list">
                                    <router-link to="/community">Applicants' Community</router-link>
                                </li>
<!--                                <li class="single-list">-->
<!--                                    <router-link to="#">System Auto Since</router-link>-->
<!--                                </li>-->
                            </ul>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6 col-sm-6 col-12 mt_md--40 mt_sm--40">
                        <div class="footer-widget widget-information">
                            <h6 class="widget-title">Information & Tools</h6>
                            <ul class="footer-list-one">
                                <li class="single-list">
                                    <router-link to="/edit-profile?to=application">My Application Background</router-link>
                                </li>
                                <li class="single-list">
                                    <router-link to="/my-applications">Selected Program List</router-link>
                                </li>
                                <li class="single-list">
                                    <router-link to="/edit-profile">Refine My Profile</router-link>
                                </li>
                                <li class="single-list">
                                    <router-link to="/edit-profile?to=password">Change Password</router-link>
                                </li>
                                <li class="single-list">
                                    <router-link to="/edit-profile?to=info">Change Email</router-link>
                                </li>
                                <li class="single-list">
                                    <router-link to="/sign-up">Register</router-link>
                                </li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6 col-sm-6 col-12 mt_md--40 mt_sm--40">
                        <div class="footer-widget">
                            <h6 class="widget-title">Popular Universities</h6>
                            <ul class="footer-recent-post">
                              <div v-for="(school, index) in schools"
                                   :key="index">
                                <li class="recent-post">
                                    <div class="thumbnail">
                                        <router-link :to="`/school-details/`+school.id">
                                            <img :src="`/backend/static/` + school.logo"
                                                 alt="school Images" style="width: 60px">
                                        </router-link>
                                    </div>
                                    <div class="content">
                                        <h6 class="title">
                                            <router-link :to="`/school-details/`+school.id">{{school.name}}</router-link>
                                        </h6>
<!--                                        <p></p>-->
                                        <span class="price">QS Ranking: {{school.rankQS}}#</span>
                                    </div>
                                </li>
                              </div>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Footer Area -->

        <!-- Start Copyright Area -->
        <div class="copy-right-one ptb--20 bg-color--1">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-6 col-md-12 col-sm-12">
                        <div class="copyright-left">
                            <span>©2023 OfferMaster, Inc. All rights reserved.</span>
                            <ul class="privacy">
                                <li>
                                    <router-link to="/terms-condition">Terms</router-link>
                                </li>
                                <li>
                                    <router-link to="/privacy-policy">Privacy Policy</router-link>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-12 col-sm-12">
                        <div class="copyright-right">
                            <social-links/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Copyright Area -->

        <div class="mouse-cursor cursor-outer"/>
        <div class="mouse-cursor cursor-inner"/>

        <!-- Start Top To Bottom Area  -->
        <back-to-top @click="scrollTop"/>
        <!-- End Top To Bottom Area  -->
    </div>
</template>

<script>
    import BackToTop from '@/components/layouts/footer/BackToTop'
    import Logo from "@/components/logo/Logo";
    import SocialLinks from "@/components/social/SocialLinks";
    import request from "@/utils/request";

    export default {
        name: 'Footer',
        components: {SocialLinks, Logo, BackToTop},
        props: {
            data: {
                default: null
            }
        },
      data() {
        return {
          schools:[]
        }
      },
      created(){
        this.getRandomSchools();
      },
        methods: {
            getRandomSchools(){
              let that = this;
              request({
                url: `/api/school/public/getRandomSchools/5`,
                method: 'get'
              }).then(function (res){
                that.schools = res.data.schools;
              });
            },
            scrollTop() {
                window.scrollTo(0, 0);
            }
        }
    }
</script>
