<template>
    <layout>
        <!-- Start banner area -->
        <div class="banner-style-4 rn-section-gapTop">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-xl-6 col-lg-6 col-md-12 order-2 order-lg-1 mt_md--40 mt_sm--40">
                        <div class="sldier-content">
                            <span class="title-badge" data-sal="slide-up" data-sal-delay="150" data-sal-duration="800">
                                Nuron Marketplace
                            </span>
                            <h2 class="title" data-sal="slide-up" data-sal-delay="200" data-sal-duration="800">
                                Search your rare NFT's by world <br> class artists
                            </h2>
                            <p class="banner-disc-one" data-sal="slide-up" data-sal-delay="250" data-sal-duration="800">
                                Where Bitcoin was hailed as the digital answer to currency, NFTs
                                <br> are now being touted as the digital answer to collectables.
                            </p>
                            <div class="button-group">
                                <router-link to="#" class="btn btn-large btn-primary" data-sal="slide-up" data-sal-delay="300" data-sal-duration="800">Get Started</router-link>
                                <router-link to="/create" class="btn btn-large btn-primary-alta" data-sal="slide-up" data-sal-delay="300" data-sal-duration="800">Create</router-link>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-6 col-lg-6 col-md-12 order-1 order-lg-2">
                        <div class="slider slick-activation-04">
                            <carousel-four/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End banner area -->

        <!-- Start Live Bidding Area -->
        <explore-live-carousel/>
        <!-- End Live Bidding Area -->

        <!-- Explore Product Area Start -->
        <explore-filter-with-placebid/>
        <!-- Explore Product Area End -->

        <!-- Top Seller Start -->
        <seller-style-one/>
        <!-- Top Seller End -->

        <!-- Start Service Area -->
        <service-style-one/>
        <!-- End Service Area -->

        <!-- Collection Area Start -->
        <collection-style-one/>
        <!-- Collection Area End -->
    </layout>
</template>

<script>
    import Layout from "@/components/layouts/Layout";
    import CarouselFour from "@/components/carousel/CarouselFour";
    import SalScrollAnimationMixin from "@/mixins/SalScrollAnimationMixin";
    import ExploreLiveCarousel from "@/components/explore/ExploreLiveCarousel";
    import ExploreFilterWithPlacebid from "@/components/explore/ExploreFilterWithPlacebid";
    import SellerStyleOne from "@/components/seller/SellerStyleOne";
    import ServiceStyleOne from "@/components/service/ServiceStyleOne";
    import CollectionStyleOne from "@/components/collection/CollectionStyleOne";

    export default {
        name: 'HomePageFour',
        components: {
            CollectionStyleOne,
            ServiceStyleOne,
            SellerStyleOne, ExploreFilterWithPlacebid, ExploreLiveCarousel, CarouselFour, Layout},
        mixins: [SalScrollAnimationMixin]
    }
</script>