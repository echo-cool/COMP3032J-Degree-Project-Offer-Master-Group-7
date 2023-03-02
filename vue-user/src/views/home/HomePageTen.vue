<template>
    <layout>
        <!-- Start Banner Area -->
        <div class="slider-area ptb--60">
            <div class="container-fluid padding-contorler-am-slide">
                <div class="row d-flex align-items-center">
                    <div class="col-lg-12 col-xl-6 order-2 order-xl-1 padding-contorler-am-slide-right">
                        <div class="banner-top-rating sal-animate">
                            <div class="banner-badge-top"
                                 data-sal-delay="200"
                                 data-sal="slide-up"
                                 data-sal-duration="800">
                                <div class="icon">
                                    <img :src="require(`@/assets/images/icons/rating-2.png`)" alt="Icons Images">
                                </div>
                                <span class="subtitle">8000+ Trust Customer</span>
                            </div>
                            <div class="banner-badge-top"
                                 data-sal-delay="500"
                                 data-sal="slide-up"
                                 data-sal-duration="500">
                                <div class="icon">
                                    <img :src="require(`@/assets/images/icons/trophy.png`)" alt="Icons Images">
                                </div>
                                <span class="subtitle">#1 Top New theme</span>
                            </div>
                        </div>
                        <h1 class="title large-height theme-color"
                            data-sal-delay="200"
                            data-sal="slide-up"
                            data-sal-duration="800">
                            Discover Digital Art and<br> Sell Your Specific NFTs.
                        </h1>
                        <p class="slide-disc"
                           data-sal-delay="300"
                           data-sal="slide-up"
                           data-sal-duration="800">
                            a non-interchangeable unit of data stored on a blockchain, a form of digital ledger, that
                            can be sold and traded. Types of NFT data units.
                        </p>
                        <div class="button-group">
                            <router-link
                                class="btn btn-large btn-primary"
                                to="#"
                                data-sal-delay="400"
                                data-sal="slide-up"
                                data-sal-duration="800">
                                Get Started
                            </router-link>
                            <router-link
                                class="btn btn-large btn-primary-alta"
                                to="/create"
                                data-sal-delay="500"
                                data-sal="slide-up"
                                data-sal-duration="800">
                                Create
                            </router-link>
                        </div>
                    </div>
                    <div class="col-lg-12 col-xl-6 order-1 order-xl-2">
                        <div class="banner-gallery-wrapper">
                            <div class="banner-gallery-loop">
                                <div class="banner-gallery banner-gallery-1 mt--90">
                                    <img :src="require(`@/assets/images/banner/banner-01.png`)" alt="Banner Images">
                                    <img :src="require(`@/assets/images/banner/banner-01.png`)" alt="Banner Images">
                                </div>
                                <div class="banner-gallery banner-gallery-2">
                                    <img :src="require(`@/assets/images/banner/banner-02.png`)" alt="Banner Images">
                                    <img :src="require(`@/assets/images/banner/banner-02.png`)" alt="Banner Images">
                                </div>
                                <div class="banner-gallery banner-gallery-3 mt--90">
                                    <img :src="require(`@/assets/images/banner/banner-03.png`)" alt="Banner Images">
                                    <img :src="require(`@/assets/images/banner/banner-03.png`)" alt="Banner Images">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Banner Area -->

        <!-- Start Category Area -->
        <category-style-one/>
        <!-- End Category Area -->

        <!-- Start Live Bidding Area -->
        <explore-live-carousel/>
        <!-- End Live Bidding Area -->

        <!-- Start Service Area -->
        <service-style-one/>
        <!-- End Service Area -->

        <!-- Newest Items Area Start -->
        <explore-newest-item/>
        <!-- Newest Items Area End -->

        <!-- Top Seller Start -->
        <seller-style-one/>
        <!-- Top Seller End -->

        <!-- Explore Product Area Start -->
        <explore-filter/>
        <!-- Explore Product Area End -->

        <!-- Start Nuron Vedio Area -->
        <video-style-one video-url="https://www.youtube.com/embed/7e90gBu4pas"/>
        <!-- End Nuron Vedio Area -->

        <!-- Collection Area Start -->
        <collection-style-one/>
        <!-- Collection Area End -->

        <!-- start subscribe area -->
        <subscription-style-one/>
        <!-- end subscribe area -->

        <share-modal/>

        <report-modal/>
    </layout>
</template>

<script>
    import Layout from '../../components/layouts/Layout'
    import ExploreLiveCarousel from '@/components/explore/ExploreLiveCarousel'
    import ServiceCard from '@/components/service/ServiceCard'
    import ProductCard from '@/components/product/ProductCard'
    import SalScrollAnimationMixin from '@/mixins/SalScrollAnimationMixin'
    import ShareModal from '@/components/modal/ShareModal'
    import ReportModal from '@/components/modal/ReportModal'
    import ExploreFilter from '@/components/explore/ExploreFilter'
    import ServiceStyleOne from '@/components/service/ServiceStyleOne'
    import SellerStyleOne from '@/components/seller/SellerStyleOne'
    import CollectionStyleOne from '@/components/collection/CollectionStyleOne'
    import ExploreNewestItem from '@/components/explore/ExploreNewestItem'
    import CategoryStyleOne from '@/components/category/CategoryStyleOne'
    import SubscriptionStyleOne from '@/components/subscription/SubscriptionStyleOne'
    import VideoStyleOne from '@/components/video/VideoStyleOne'

    export default {
        name: 'HomePageTen',
        components: {
            VideoStyleOne,
            SubscriptionStyleOne,
            CategoryStyleOne,
            ExploreNewestItem,
            CollectionStyleOne,
            SellerStyleOne,
            ServiceStyleOne,
            ExploreFilter,
            ReportModal,
            ShareModal,
            ProductCard,
            ServiceCard,
            ExploreLiveCarousel,
            Layout
        },
        mixins: [SalScrollAnimationMixin]
    }
</script>