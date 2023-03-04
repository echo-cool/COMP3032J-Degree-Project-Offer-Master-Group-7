<template>
    <layout>
        <particle-background/>

        <!-- Start banner area -->
        <div class="slider-style-5 rn-section-gapTop">
            <div class="container">
                <div class="row g-5 align-items-center">
                    <div class="col-lg-6 order-2 order-lg-1 mt_md--30 mt_sm--30">
                        <div class="banner-left-content">
                            <span class="title-badge" data-sal="slide-up" data-sal-delay="150" data-sal-duration="800">
                                Nuron Marketplace
                            </span>
                            <h2 class="title" data-sal="slide-up" data-sal-delay="200" data-sal-duration="800">
                                Search your rare NFT's by world <br> class artists
                            </h2>
                            <p class="banner-disc-one" data-sal="slide-up" data-sal-delay="300" data-sal-duration="800">
                                Where Bitcoin was hailed as the digital answer to currency, NFTs
                                <br> are now being touted as the digital answer to collectables.
                            </p>
                            <div class="button-group">
                                <router-link to="#" class="btn btn-large btn-primary" data-sal="slide-up"
                                             data-sal-delay="350" data-sal-duration="800">
                                    Get Started
                                </router-link>
                                <router-link to="/create" class="btn btn-large btn-primary-alta" data-sal="slide-up"
                                             data-sal-delay="350" data-sal-duration="800">
                                    Create
                                </router-link>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 order-1 order-lg-2">
                        <div class="row g-5">
                            <div class="col-lg-6 col-md-6" v-for="(product, index) in bannerProducts"
                                 :key="`product-${index}`">
                                <product-card :product-date="product"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End banner area -->

        <!-- Start Top Seller Area -->
        <seller-style-one/>
        <!-- End Top Seller Area -->

        <!-- Start Explore Area -->
        <explore-filter-with-placebid/>
        <!-- End Explore Area -->

        <!-- Start Service Area -->
        <service-style-one/>
        <!-- End Service Area -->

        <!-- Start Collection Area -->
        <collection-style-one/>
        <!-- End Collection Area -->
    </layout>
</template>

<script>
    import Layout from '@/components/layouts/Layout'
    import ProductCard from '@/components/product/ProductCard'
    import SalScrollAnimationMixin from '@/mixins/SalScrollAnimationMixin'
    import SellerStyleOne from '@/components/seller/SellerStyleOne'
    import ExploreFilterWithPlacebid from '@/components/explore/ExploreFilterWithPlacebid'
    import ServiceStyleOne from '@/components/service/ServiceStyleOne'
    import CollectionStyleOne from '@/components/collection/CollectionStyleOne'
    import ParticleBackground from "@/components/particles/ParticleBackground";

    export default {
        name: 'HomePageFive',
        components: {
            ParticleBackground,
            CollectionStyleOne,
            ServiceStyleOne,
            ExploreFilterWithPlacebid,
            SellerStyleOne,
            ProductCard,
            Layout
        },
        mixins: [SalScrollAnimationMixin],
        data() {
            return {
                bannerProducts: [
                    {
                        productImage: require(`@/assets/images/portfolio/portfolio-07.jpg`),
                        countdown: {
                            date: '2023-11-09'
                        },
                        authors: [
                            {
                                name: 'Jone-lee',
                                image: require(`@/assets/images/client/client-6.png`)
                            },
                            {
                                name: 'Mr.Jone-lee',
                                image: require(`@/assets/images/client/client-4.png`)
                            },
                            {
                                name: 'lee',
                                image: require(`@/assets/images/client/client-9.png`)
                            }
                        ],
                        biddingAmount: '11',
                        productName: 'Preatent',
                        latestBid: 'Highest bid 1/20',
                        lastBid: '0.244wETH',
                        reacted: '322'
                    },
                    {
                        productImage: require(`@/assets/images/portfolio/portfolio-09.jpg`),
                        countdown: {
                            date: '2023-10-12'
                        },
                        authors: [
                            {
                                name: 'Tawhid',
                                image: require(`@/assets/images/client/client-1.png`)
                            },
                            {
                                name: 'Hoiris',
                                image: require(`@/assets/images/client/client-11.png`)
                            },
                            {
                                name: 'Kohli',
                                image: require(`@/assets/images/client/client-7.png`)
                            }
                        ],
                        biddingAmount: '8',
                        productName: 'mAtal8',
                        latestBid: 'Highest bid 6/50',
                        lastBid: '0.244wETH',
                        reacted: '205'
                    },
                ]
            }
        }
    }
</script>
