<template>
    <layout :show-footer-brand="true">
        <!-- Start Banner Area -->
        <div class="banner-area banner-12 bg_image--23 bg_image with-down-shadow">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="banner-xii-wrapper">
                            <div class="banner-content-wrapper">
                                <p class="pre-title">Nuron marketplace</p>
                                <h1 class="title">Dive into NFTs marketplace with a relevant Product</h1>
                                <p class="post-title">Unit of data stored on a digital ledger, called a blockchain, that certifies
                                    a digital asset to be unique and therefore not interchangeable</p>
                                <a class="btn btn-primary btn-large" href="#">Explore</a>
                                <div class="wallet-image-wrapper">
                                    <a href="#" class="avatar" data-tooltip="BITLY">
                                        <img :src="require(`@/assets/images/icons/wallet/4.png`)" alt="wallet_image">
                                    </a>
                                    <a href="#" class="avatar" data-tooltip="D-Coin">
                                        <img :src="require(`@/assets/images/icons/wallet/7.png`)" alt="wallet_image">
                                    </a>
                                    <a href="#" class="avatar" data-tooltip="Trans Card">
                                        <img :src="require(`@/assets/images/icons/wallet/8.png`)" alt="wallet_image">
                                    </a>
                                    <a href="#" class="avatar" data-tooltip="Meta Mask">
                                        <img :src="require(`@/assets/images/icons/wallet/1.png`)" alt="wallet_image">
                                    </a>
                                    <a href="#" class="avatar" data-tooltip="E-Currency">
                                        <img :src="require(`@/assets/images/icons/wallet/3.png`)" alt="wallet_image">
                                    </a>
                                    <a href="#" class="avatar" data-tooltip="BitCoin">
                                        <img :src="require(`@/assets/images/icons/wallet/2.png`)" alt="wallet_image">
                                    </a>
                                    <a href="#" class="avatar" data-tooltip="Attar Process">
                                        <img :src="require(`@/assets/images/icons/wallet/6.png`)" alt="wallet_image">
                                    </a>
                                    <a href="#" class="avatar" data-tooltip="Mark JOrdan">
                                        <img :src="require(`@/assets/images/icons/wallet/5.png`)" alt="wallet_image">
                                    </a>
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

        <!-- Collection Area Start -->
        <collection-style-one/>
        <!-- Collection Area End -->

        <!-- Start Live Bidding Area -->
        <explore-live-carousel/>
        <!-- End Live Bidding Area -->

        <!-- Start Service Area -->
        <service-style-one/>
        <!-- End Service Area -->

        <!-- start subscribe area -->
        <subscription-style-one/>
        <!-- end subscribe area -->

        <!-- Newest Items Area Start -->
        <explore-newest-item/>
        <!-- Newest Items Area End -->

        <!-- Top Seller Start -->
        <seller-style-one/>
        <!-- Top Seller End -->

        <!-- Explore Product Area Start -->
        <ExploreFilterLeft/>
        <!-- Explore Product Area End -->

        <!-- Start Nuron Vedio Area -->
        <video-style-one video-url="https://www.youtube.com/embed/7e90gBu4pas"/>
        <!-- End Nuron Vedio Area -->

        <share-modal/>

        <report-modal/>
    </layout>
</template>

<script>
    import ExploreFilterLeft from '@/components/explore/ExploreFilterLeft'
    import CountUp from 'vue-countup-v3'
    import VideoStyleOne from '@/components/video/VideoStyleOne'
    import SubscriptionStyleOne from '@/components/subscription/SubscriptionStyleOne'
    import CategoryStyleOne from '@/components/category/CategoryStyleOne'
    import ExploreNewestItem from '@/components/explore/ExploreNewestItem'
    import CollectionStyleOne from '@/components/collection/CollectionStyleOne'
    import SellerStyleOne from '@/components/seller/SellerStyleOne'
    import ServiceStyleOne from '@/components/service/ServiceStyleOne'
    import ExploreFilter from '@/components/explore/ExploreFilter'
    import ReportModal from '@/components/modal/ReportModal'
    import ShareModal from '@/components/modal/ShareModal'
    import ProductCard from '@/components/product/ProductCard'
    import ServiceCard from '@/components/service/ServiceCard'
    import ExploreLiveCarousel from '@/components/explore/ExploreLiveCarousel'
    import Layout from '@/components/layouts/Layout'
    import SalScrollAnimationMixin from '@/mixins/SalScrollAnimationMixin'

    export default {
        name: 'HomePageTwelve',
        components: {
            ExploreFilterLeft,
            CountUp,
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
        mixins: [SalScrollAnimationMixin],
        data() {
            return {
                bannerProductItem: {
                    productImage: require(`@/assets/images/portfolio/portfolio-07.jpg`),
                    countdown: {
                        date: '2023-11-09'
                    },
                    authors: [
                        {
                            id: 2,
                            name: 'Mark Jordan',
                            image: require(`@/assets/images/client/client-2.png`)
                        },
                        {
                            id: 3,
                            name: 'Mark',
                            image: require(`@/assets/images/client/client-3.png`)
                        },
                        {
                            id: 5,
                            name: 'Jordan',
                            image: require(`@/assets/images/client/client-5.png`)
                        }
                    ],
                    biddingAmount: '20',
                    productName: 'Collect,Sell Your Specific NFT\'s',
                    latestBid: 'Highest bid 1/20',
                    lastBid: '0.244wETH',
                    reacted: '322'
                }
            }
        }
    }
</script>