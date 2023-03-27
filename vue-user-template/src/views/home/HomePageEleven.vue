<template>
    <layout :show-footer-brand="true">
        <!-- Start Banner Area -->
        <div class="slider-area">
            <div class="container-fluid padding-contorler-am-slide-11">
                <div class="row d-flex align-items-center">
                    <div class="col-lg-12 col-xl-6 order-2 order-xl-1 home-11-slide-padding">
                        <h2 class="title"
                            data-sal-delay="200"
                            data-sal="slide-up"
                            data-sal-duration="800">
                            Discover Digital Art, Collect <br> and Sell Your Specific <br>
                            <span class="gradient-title">NFTs.</span>
                        </h2>
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
                        <div class="odometer-area-slide">
                            <div class="single-odometer"
                                 data-sal-delay="400"
                                 data-sal="slide-left"
                                 data-sal-duration="800">
                                <h3 class="counter">
                                    <span class="odometer">
                                        <count-up :startVal="0" :endVal="3091" :duration="5"/>
                                    </span>
                                    <span class="counter-label">Collectibles</span>
                                </h3>
                            </div>
                            <div class="single-odometer"
                                 data-sal-delay="600"
                                 data-sal="slide-left"
                                 data-sal-duration="800">
                                <h3 class="counter">
                                    <span class="odometer">
                                        <count-up :startVal="0" :endVal="1020" :duration="5"/>
                                    </span>
                                    <span class="counter-label">Auctions</span>
                                </h3>
                            </div>
                            <div class="single-odometer"
                                 data-sal-delay="800"
                                 data-sal="slide-left"
                                 data-sal-duration="800">
                                <h3 class="counter">
                                    <span class="odometer">
                                        <count-up :startVal="0" :endVal="5329" :duration="5"/>
                                    </span>
                                    <span class="counter-label">NFT Artist</span>
                                </h3>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-12 col-xl-6 order-1 order-xl-2">
                        <div class="banner-right-feature-product"
                             data-sal-delay="300"
                             data-sal="slide-left"
                             data-sal-duration="800">
                            <!-- start single product -->
                            <div class="single-slide-product"
                                 data-sal-delay="700"
                                 data-sal="slide-left"
                                 data-sal-duration="800">
                                <product-card
                                    :product-date="bannerProductItem"
                                />
                                <!--                            <div class="product-style-one tilt">
                                                                <div class="card-thumbnail">
                                                                    <a href="product-details.html">
                                                                        <img src="assets/images/portfolio/portfolio-07.jpg"
                                                                             alt="NFT_portfolio">
                                                                    </a>
                                                                    <div class="countdown" data-date="2023-11-09">
                                                                        <div class="countdown-container days">
                                                                            <span class="countdown-value">87</span>
                                                                            <span class="countdown-heading">D's</span>
                                                                        </div>
                                                                        <div class="countdown-container hours">
                                                                            <span class="countdown-value">23</span>
                                                                            <span class="countdown-heading">H's</span>
                                                                        </div>
                                                                        <div class="countdown-container minutes">
                                                                            <span class="countdown-value">38</span>
                                                                            <span class="countdown-heading">Min's</span>
                                                                        </div>
                                                                        <div class="countdown-container seconds">
                                                                            <span class="countdown-value">27</span>
                                                                            <span class="countdown-heading">Sec</span>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="product-share-wrapper">
                                                                    <div class="profile-share">
                                                                        <a href="author.html" class="avatar" data-tooltip="Jone-lee"><img class="large"
                                                                                                                                          src="assets/images/client/client-6.png"
                                                                                                                                          alt="Nft_Profile"></a>
                                                                        <a href="author.html" class="avatar" data-tooltip="Mr.Jone-lee"><img
                                                                            class="large" src="assets/images/client/client-4.png" alt="Nft_Profile"></a>
                                                                        <a href="author.html" class="avatar" data-tooltip="Mr.Alamin-Bali"><img
                                                                            class="large" src="assets/images/client/client-9.png" alt="Nft_Profile"></a>
                                                                        <a class="more-author-text" href="#">11+ Place Bit.</a>
                                                                    </div>
                                                                    <div class="share-btn share-btn-activation dropdown">
                                                                        <button class="icon" type="button" data-bs-toggle="dropdown"
                                                                                aria-expanded="false">
                                                                            <svg viewBox="0 0 14 4" fill="none" width="16" height="16"
                                                                                 class="sc-bdnxRM sc-hKFxyN hOiKLt">
                                                                                <path fill-rule="evenodd" clip-rule="evenodd"
                                                                                      d="M3.5 2C3.5 2.82843 2.82843 3.5 2 3.5C1.17157 3.5 0.5 2.82843 0.5 2C0.5 1.17157 1.17157 0.5 2 0.5C2.82843 0.5 3.5 1.17157 3.5 2ZM8.5 2C8.5 2.82843 7.82843 3.5 7 3.5C6.17157 3.5 5.5 2.82843 5.5 2C5.5 1.17157 6.17157 0.5 7 0.5C7.82843 0.5 8.5 1.17157 8.5 2ZM11.999 3.5C12.8274 3.5 13.499 2.82843 13.499 2C13.499 1.17157 12.8274 0.5 11.999 0.5C11.1706 0.5 10.499 1.17157 10.499 2C10.499 2.82843 11.1706 3.5 11.999 3.5Z"
                                                                                      fill="currentColor"></path>
                                                                            </svg>
                                                                        </button>

                                                                        <div class="share-btn-setting dropdown-menu dropdown-menu-end">
                                                                            <button type="button" class="btn-setting-text share-text"
                                                                                    data-bs-toggle="modal" data-bs-target="#shareModal">
                                                                                Share
                                                                            </button>
                                                                            <button type="button" class="btn-setting-text report-text"
                                                                                    data-bs-toggle="modal" data-bs-target="#reportModal">
                                                                                Report
                                                                            </button>
                                                                        </div>

                                                                    </div>

                                                                </div>
                                                                <a href="product-details.html"><span class="product-name large-product-title">Collect,Sell Your Specific NFT's</span></a>
                                                                <span class="latest-bid">Highest bid 1/20</span>
                                                                <div class="bid-react-area">
                                                                    <div class="last-bid">0.244wETH</div>
                                                                    <div class="react-area">
                                                                        <svg viewBox="0 0 17 16" fill="none" width="16" height="16"
                                                                             class="sc-bdnxRM sc-hKFxyN kBvkOu">
                                                                            <path
                                                                                d="M8.2112 14L12.1056 9.69231L14.1853 7.39185C15.2497 6.21455 15.3683 4.46116 14.4723 3.15121V3.15121C13.3207 1.46757 10.9637 1.15351 9.41139 2.47685L8.2112 3.5L6.95566 2.42966C5.40738 1.10976 3.06841 1.3603 1.83482 2.97819V2.97819C0.777858 4.36443 0.885104 6.31329 2.08779 7.57518L8.2112 14Z"
                                                                                stroke="currentColor" stroke-width="2"></path>
                                                                        </svg>
                                                                        <span class="number">322</span>
                                                                    </div>
                                                                </div>
                                                            </div>-->
                            </div>
                            <!-- end single product -->
                            <div class="badge-inner" data-sal-delay="900" data-sal="slide-left"
                                 data-sal-duration="1000">
                                <img class="image-1" :src="require(`@/assets/images/banner/badge.png`)"
                                     alt="banner_badge">
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
        <ExploreFilterLeft/>
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
    import CountUp from 'vue-countup-v3'
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
    import ExploreFilterLeft from '@/components/explore/ExploreFilterLeft'

    export default {
        name: 'HomePageEleven',
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