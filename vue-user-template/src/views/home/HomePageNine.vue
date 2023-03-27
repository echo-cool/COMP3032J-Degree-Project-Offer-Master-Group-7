<template>
    <layout>
        <!-- start Banner Area -->
        <div class="rn-slider-area">
            <carousel class="slider-activation-banner-5 game-banner-slick-wrapper slick-arrow-style-one rn-slick-dot-style"
                      :items-to-show="1"
                      :wrap-around="true">
                <slide v-for="(carouselItem, index) in carouselItems"
                       :key="index">
                    <div :class="`${carouselItem.image} bg_image d-flex align-items-center padding-controler-slide-product justify-content-center slide slide-style-2 fullscreen_image-banner position-relative`" data-black-overlay="5">
                        <div class="container">
                            <div class="row d-flex align-items-center">
                                <div class="col-lg-7">
                                    <div class="inner text-start">
                                        <div class="top-bid-price d-flex">
                                            <span class="latest-bid mr--15">{{ carouselItem.latestBid }}</span>
                                            <div class="last-bid color-primary">{{ carouselItem.lastBid }}</div>
                                        </div>
                                        <router-link :to="`/product/${carouselItem.id}`">
                                            <h1 class="title theme-gradient">{{ carouselItem.title }}</h1>
                                        </router-link>
                                        <div class="product-share-wrapper lg-product-share">
                                            <div class="profile-share">
                                                <router-link :to="`/author/${author.id}`"
                                                             class="avatar"
                                                             :data-tooltip="author.name"
                                                             v-for="(author, index) in carouselItem.authors"
                                                             :key="`author-${index}`">
                                                    <img :src="author.image" alt="Nft_Profile">
                                                </router-link>
                                                <router-link class="more-author-text" to="#">
                                                    {{ carouselItem.biddingAmount }}+ Place Bit.
                                                </router-link>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-5">
                                    <div class="place-bet-area into-banner mt_md--30 mt_sm--30">
                                        <div class="rn-bet-create">
                                            <div class="bid-list text-start winning-bid">
                                                <h6 class="title">{{ carouselItem.name }}</h6>
                                                <div class="top-seller-inner-one">
                                                    <div class="top-seller-wrapper">
                                                        <div class="thumbnail">
                                                            <router-link :to="`/author/7`">
                                                                <img :src="require(`@/assets/images/client/client-7.png`)" alt="Nft_Profile">
                                                            </router-link>
                                                        </div>
                                                        <div class="top-seller-content">
                                                            <span class="heighest-bid">
                                                                Heighest bid
                                                                <router-link :to="`/author/7`">Atif aslam</router-link>
                                                            </span>
                                                            <span class="count-number">
                                                                0.115wETH
                                                            </span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="bid-list text-start left-bid">
                                                <h6 class="title">Auction has ended</h6>
                                                <countdown class="mt--15" :date="carouselItem.countdown.date"/>
                                            </div>
                                        </div>
                                        <button type="button"
                                                class="btn btn-primary mt--30"
                                                data-bs-toggle="modal"
                                                data-bs-target="#placebidModal">
                                            Place a Bid
                                        </button>
                                    </div>
                                    <div class="property-wrapper-flex d-flex text-start">
                                        <div class="rn-pd-sm-property-wrapper into-banner">
                                            <h6 class="pd-property-title">
                                                Catagory
                                            </h6>
                                            <div class="catagory-wrapper">
                                                <div class="pd-property-inner">
                                                    <span class="color-body type">ZARY</span>
                                                    <span class="color-white value">APP</span>
                                                </div>
                                                <div class="pd-property-inner">
                                                    <span class="color-body type">SOMALIAN</span>
                                                    <span class="color-white value">TRIBUTE</span>
                                                </div>
                                                <div class="pd-property-inner">
                                                    <span class="color-body type">TUNA</span>
                                                    <span class="color-white value">PIPE</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="rn-pd-sm-property-wrapper into-banner ml--30">
                                            <h6 class="pd-property-title">
                                                Property
                                            </h6>
                                            <div class="property-wrapper">
                                                <div class="pd-property-inner">
                                                    <span class="color-body type">HYPE TYPE</span>
                                                    <span class="color-white value">CALM AF</span>
                                                </div>
                                                <div class="pd-property-inner">
                                                    <span class="color-body type">BASTARDNESS</span>
                                                    <span class="color-white value">C00LIO BASTARD</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="tooltip-bottom-wrapper d-flex">
                                    <div class="share-react react d-flex">
                                        <div class="bid-react-area mr--15">
                                            <div class="react-area">
                                                <i class="feather-heart"/>
                                                <span class="number">322</span>
                                            </div>
                                        </div>
                                        <div class="share-btn share-btn-activation dropdown">
                                            <button class="icon" data-bs-toggle="dropdown" aria-expanded="false">
                                                <i class="feather-more-horizontal"/>
                                            </button>
                                            <div class="share-btn-setting dropdown-menu dropdown-menu-end">
                                                <button type="button"
                                                        class="btn-setting-text share-text"
                                                        data-bs-toggle="modal"
                                                        data-bs-target="#shareModal">
                                                    Share
                                                </button>
                                                <button type="button"
                                                        class="btn-setting-text report-text"
                                                        data-bs-toggle="modal"
                                                        data-bs-target="#reportModal">
                                                    Report
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </slide>
                <template #addons>
                    <Pagination/>
                </template>
            </carousel>
        </div>
        <!-- End Banner Area -->

        <!-- start top seller area -->
        <seller-style-two/>
        <!-- end top seller area -->

        <!-- About Market Place Start -->
        <div class="about-market-area rn-section-gapTop">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="about-wrapper text-center">
                            <h2>AN NURON THEME JUST FOR GAMERS</h2>
                            <p class="discription">
                                Proin gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum
                                auctor, nisi elit consequat ipsum, nec sagittis sem nibh id elit. Duis sed odio sit amet
                                nibh vulputate cursus a sit amet mauris. Morbi accumsan ipsum velit. Nam nec tellus a
                                odio
                                tincidunt auctor a ornare odio sed non.

                                Proin gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum
                                auctor, nisi elit consequat ipsum, nec sagittis sem nibh id elit.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- About Market Place End -->

        <!-- Explore Style Carousel -->
        <explore-live-carousel/>
        <!-- Explore Style Carousel End-->

        <!-- Start Tab Product list style area -->
        <div class="rn-product-area rn-section-gapTop">
            <div class="container">
                <div class="row g-5">
                    <div class="col-lg-8 custom-product-col">
                        <explore-list-style/>
                    </div>
                    <div class="col-lg-4 custom-product-col">
                        <div
                            class="header-right-fixed position-sticky product-notify-wrapper rbt-sticky-top-adjust-four mt--95 mt_md--20 mt_sm--15">
                            <!-- Notification area -->
                            <notification-list-sidebar/>
                            <!-- Notification area End -->

                            <!-- Start creators area -->
                            <creator-list-sidebar/>
                            <!-- End creators area -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- end Tab Product list style area -->

        <!-- Start Tab Product area -->
        <div class="rn-product-area rn-section-gapTop">
            <div class="container">
                <explore-list-style :is-two-column="true"/>
            </div>
        </div>
        <!-- end Tab Product area -->

        <!-- start service area -->
        <service-style-one/>
        <!-- End service area -->

        <!-- collection area Start -->
        <collection-style-one/>
        <!-- collection area End -->

        <share-modal/>

        <report-modal/>

        <placebid-modal/>
    </layout>
</template>

<script>
    import Layout from '@/components/layouts/Layout'
    import SellerStyleTwo from '@/components/seller/SellerStyleTwo'
    import ExploreLiveCarousel from '@/components/explore/ExploreLiveCarousel'
    import ServiceStyleOne from '@/components/service/ServiceStyleOne'
    import CollectionStyleOne from '@/components/collection/CollectionStyleOne'
    import ExploreListStyle from '@/components/explore/ExploreListStyle'
    import NotificationListSidebar from '@/components/notification/NotificationListSidebar'
    import CreatorListSidebar from '@/components/seller/CreatorListSidebar'
    import ShareModal from '@/components/modal/ShareModal'
    import ReportModal from '@/components/modal/ReportModal'
    import PlacebidModal from '@/components/modal/PlacebidModal'
    import SalScrollAnimationMixin from '@/mixins/SalScrollAnimationMixin'
    import Countdown from '@/components/product/Countdown'
    import {Carousel, Slide, Pagination} from 'vue3-carousel'

    export default {
        name: 'HomePageNine',
        components: {
            Countdown,
            PlacebidModal,
            ReportModal,
            ShareModal,
            CreatorListSidebar,
            NotificationListSidebar,
            ExploreListStyle,
            CollectionStyleOne,
            ServiceStyleOne,
            ExploreLiveCarousel,
            SellerStyleTwo,
            Layout,
            Pagination,
            Carousel,
            Slide
        },
        mixins: [SalScrollAnimationMixin],
        data() {
            return {
                carouselItems: [
                    {
                        id: 1,
                        image: 'bg_image--21',
                        title: 'Digital Dod Glitter Worlds',
                        description: `The term fungible means something that can be replaced by something similar. So, by the name Non Fungible Tokens, we can easily understand.`,
                        countdown: {
                            date: '2023-11-09'
                        },
                        authors: [
                            {
                                id: 9,
                                name: 'mr. Davei',
                                image: require(`@/assets/images/client/client-9.png`)
                            },
                            {
                                id: 10,
                                name: 'Mrs.Laumi',
                                image: require(`@/assets/images/client/client-10.png`)
                            },
                            {
                                id: 2,
                                name: 'Shanon',
                                image: require(`@/assets/images/client/client-2.png`)
                            }
                        ],
                        biddingAmount: '15',
                        latestBid: 'Highest bid 1/20',
                        lastBid: '0.244wETH',
                        name: 'Winning bit',
                    },
                    {
                        id: 2,
                        image: 'bg_image--22',
                        title: 'Digital Dod Glitter Worlds',
                        description: `The term fungible means something that can be replaced by something similar. So, by the name Non Fungible Tokens, we can easily understand.`,
                        countdown: {
                            date: '2023-11-09'
                        },
                        authors: [
                            {
                                id: 9,
                                name: 'mr. Davei',
                                image: require(`@/assets/images/client/client-9.png`)
                            },
                            {
                                id: 10,
                                name: 'Mrs.Laumi',
                                image: require(`@/assets/images/client/client-10.png`)
                            },
                            {
                                id: 2,
                                name: 'Shanon',
                                image: require(`@/assets/images/client/client-2.png`)
                            }
                        ],
                        biddingAmount: '15',
                        latestBid: 'Highest bid 1/20',
                        lastBid: '0.244wETH',
                        name: 'Winning bit',
                    },
                    {
                        id: 3,
                        image: 'bg_image--23',
                        title: 'Digital Dod Glitter Worlds',
                        description: `The term fungible means something that can be replaced by something similar. So, by the name Non Fungible Tokens, we can easily understand.`,
                        countdown: {
                            date: '2023-11-09'
                        },
                        authors: [
                            {
                                id: 9,
                                name: 'mr. Davei',
                                image: require(`@/assets/images/client/client-9.png`)
                            },
                            {
                                id: 10,
                                name: 'Mrs.Laumi',
                                image: require(`@/assets/images/client/client-10.png`)
                            },
                            {
                                id: 2,
                                name: 'Shanon',
                                image: require(`@/assets/images/client/client-2.png`)
                            }
                        ],
                        biddingAmount: '15',
                        latestBid: 'Highest bid 1/20',
                        lastBid: '0.244wETH',
                        name: 'Winning bit',
                    },
                ]
            }
        }
    }
</script>

<style lang="scss" scoped>
    .header-right-fixed {
        top: 90px;
    }
</style>
