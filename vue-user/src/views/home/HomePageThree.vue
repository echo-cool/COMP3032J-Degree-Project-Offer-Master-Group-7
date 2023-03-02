<template>
    <layout>
        <div class="banner-three slider-style-3 pt--70">
            <div class="container">
                <div class="row g-4">
                    <div class="col-lg-5">
                        <div class="wrapper">
                            <carousel-three :carousel-items="bannerItems.large"/>
                        </div>
                    </div>
                    <div class="col-lg-7">
                        <div class="row g-4">
                            <div class="col-lg-4 col-md-6 col-sm-6 col-12"
                                 v-for="(product, index) in bannerItems.small"
                                 :key="`banner-product-small-${index}`">
                                <div class="slide-small-wrapper">
                                    <div class="thumbnail thumbnail-overlay">
                                        <router-link :to="`/product/${product.id}`">
                                            <img class="w-100" :src="product.image" alt="Nft_Profile">
                                        </router-link>
                                    </div>
                                    <div class="read-wrapper">
                                        <h5 class="title">
                                            <router-link :to="`/product/${product.id}`">{{ product.title }}</router-link>
                                        </h5>
                                        <span>{{ product.author }}</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Live Bidding Area Start -->
        <explore-live/>
        <!-- Live Bidding Area End -->

        <!-- Start Service Area -->
        <service-style-one/>
        <!-- End Service Area -->

        <!-- Start product area -->
        <explore-isotop :place-bid="true"/>
        <!-- end product area -->

        <!-- Top Seller Start -->
        <seller-style-one/>
        <!-- Top Seller End -->

        <!-- Collection Area Start -->
        <collection-style-one/>
        <!-- Collection Area End -->

        <share-modal/>

        <report-modal/>
    </layout>
</template>

<script>
    import Layout from '@/components/layouts/Layout'
    import SalScrollAnimationMixin from '@/mixins/SalScrollAnimationMixin'
    import CarouselThree from '@/components/carousel/CarouselThree'
    import ShareModal from '@/components/modal/ShareModal'
    import ReportModal from '@/components/modal/ReportModal'
    import ExploreLive from '@/components/explore/ExploreLive'
    import ServiceStyleOne from '@/components/service/ServiceStyleOne'
    import SellerStyleOne from '@/components/seller/SellerStyleOne'
    import CollectionStyleOne from '@/components/collection/CollectionStyleOne'
    import ExploreIsotop from '@/components/explore/ExploreIsotop'

    export default {
        name: 'HomePageThree',
        components: {
            ExploreIsotop,
            CollectionStyleOne,
            SellerStyleOne,
            ServiceStyleOne,
            ExploreLive,
            ReportModal,
            ShareModal,
            CarouselThree,
            Layout
        },
        mixins: [SalScrollAnimationMixin],
        data() {
            return {
                bannerItems: {
                    large: [
                        {
                            id: 1,
                            image: require(`@/assets/images/banner/banner-01.jpg`),
                            title: 'Twinkle',
                            author: 'Latis Hook'
                        },
                        {
                            id: 2,
                            image: require(`@/assets/images/banner/banner-02.jpg`),
                            title: 'Monster',
                            author: 'Decruse'
                        },
                        {
                            id: 3,
                            image: require(`@/assets/images/banner/banner-03.jpg`),
                            title: 'Labibas Had',
                            author: 'Kenlee'
                        },
                        {
                            id: 4,
                            image: require(`@/assets/images/banner/banner-04.jpg`),
                            title: 'OperaHub',
                            author: 'Lathis Hook'
                        }
                    ],
                    small: [
                        {
                            id: 5,
                            image: require(`@/assets/images/banner/banner-sm-01.jpg`),
                            title: 'HasLivbe',
                            author: 'Md. Master'
                        },
                        {
                            id: 6,
                            image: require(`@/assets/images/banner/banner-sm-02.jpg`),
                            title: 'Ladicorn Mos',
                            author: 'Md. Master'
                        },
                        {
                            id: 7,
                            image: require(`@/assets/images/banner/banner-sm-03.jpg`),
                            title: 'Twinkle',
                            author: 'Latis Hook'
                        },
                        {
                            id: 8,
                            image: require(`@/assets/images/banner/banner-sm-04.jpg`),
                            title: 'Monster',
                            author: 'Decruse'
                        },
                        {
                            id: 9,
                            image: require(`@/assets/images/banner/banner-sm-05.jpg`),
                            title: 'Labibas Had',
                            author: 'Kenlee'
                        },
                        {
                            id: 10,
                            image: require(`@/assets/images/banner/banner-sm-06.jpg`),
                            title: 'OperaHub',
                            author: 'Lathis Hook'
                        },
                    ]
                }
            }
        }
    }
</script>