<template>
    <layout>
        <breadcrumb title="Product Details" current="Product Details"/>

        <!-- Start product details area -->
        <div class="product-details-area rn-section-gapTop">
            <div class="container">
                <div class="row g-5">
                    <!-- Product image area Start -->
                    <div class="col-lg-7 col-md-12 col-sm-12">
                        <div class="product-tab-wrapper rbt-sticky-top-adjust">
                            <div class="pd-tab-inner">
                                <div class="nav rn-pd-nav rn-pd-rt-content nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                                    <button :class="[`nav-link`, {'active': index === activeTabIndex}]"
                                            :id="`v-pills-${index}-tab`"
                                            data-bs-toggle="pill"
                                            :data-bs-target="`#v-pills-home-${index}`"
                                            type="button"
                                            role="tab"
                                            :aria-controls="`v-pills-home-${index}`"
                                            :aria-selected="index === activeTabIndex ? 'true' : 'false'"
                                            v-for="(thumbnailSm, index) in product.thumbnailImages"
                                            :key="`small-thumbnail-${index}`">
                                        <span class="rn-pd-sm-thumbnail">
                                            <img width="164" height="164" :src="thumbnailSm.src" alt="Nft_Profile">
                                        </span>
                                    </button>
                                </div>
                                <div class="tab-content rn-pd-content" id="v-pills-tabContent">
                                    <div :class="[`tab-pane fade`, {'show active': index === activeTabIndex}]"
                                         :id="`v-pills-home-${index}`"
                                         role="tabpanel"
                                         :aria-labelledby="`v-pills-${index}-tab`"
                                         v-for="(thumbnailLg, index) in product.thumbnailImages"
                                         :key="`large-thumbnail-${index}`">
                                        <div class="rn-pd-thumbnail">
                                            <img :src="thumbnailLg.src" alt="Nft_Profile">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Product image area end -->

                    <div class="col-lg-5 col-md-12 col-sm-12 mt_md--50 mt_sm--60">
                        <div class="rn-pd-content-area">
                            <div class="pd-title-area">
                                <h4 class="title">{{ product.productName }}</h4>
                                <div class="pd-react-area">
                                    <div class="heart-count">
                                        <i class="feather-heart"/>
                                        <span>{{ product.reacted }}</span>
                                    </div>
                                    <div class="count">
                                        <div class="share-btn share-btn-activation dropdown">
                                            <button class="icon" data-bs-toggle="dropdown" aria-expanded="false">
                                                <i class="feather-more-horizontal"/>
                                            </button>
                                            <div class="share-btn-setting dropdown-menu dropdown-menu-end">
                                                <button type="button" class="btn-setting-text share-text" data-bs-toggle="modal" data-bs-target="#shareModal">
                                                    Share
                                                </button>
                                                <button type="button" class="btn-setting-text report-text" data-bs-toggle="modal" data-bs-target="#reportModal">
                                                    Report
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <span class="bid">
                                Height bid <span class="price">{{ product.lastBid }}</span>
                            </span>
                            <h6 class="title-name">#22 Portal , Info bellow</h6>
                            <div class="catagory-collection">
                                <div class="catagory">
                                    <span>
                                        Catagory <span class="color-body">10% royalties</span>
                                    </span>
                                    <div class="top-seller-inner-one">
                                        <div class="top-seller-wrapper">
                                            <div class="thumbnail">
                                                <router-link to="/author/1">
                                                    <img :src="require(`@/assets/images/client/client-1.png`)" alt="Nft_Profile">
                                                </router-link>
                                            </div>
                                            <div class="top-seller-content">
                                                <router-link to="/author/1">
                                                    <h6 class="name">Brodband</h6>
                                                </router-link>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="collection">
                                    <span>Collections</span>
                                    <div class="top-seller-inner-one">
                                        <div class="top-seller-wrapper">
                                            <div class="thumbnail">
                                                <router-link to="/author/2">
                                                    <img :src="require(`@/assets/images/client/client-2.png`)" alt="Nft_Profile">
                                                </router-link>
                                            </div>
                                            <div class="top-seller-content">
                                                <router-link to="/author/2">
                                                    <h6 class="name">Brodband</h6>
                                                </router-link>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <router-link class="btn btn-primary-alta" to="#">Unlockable content included</router-link>
                            <div class="rn-bid-details">
                                <div class="tab-wrapper-one">
                                    <nav class="tab-button-one">
                                        <div class="nav nav-tabs" id="nav-tab" role="tablist">
                                            <button class="nav-link active"
                                                    id="nav-home-tab"
                                                    data-bs-toggle="tab"
                                                    data-bs-target="#nav-home"
                                                    type="button"
                                                    role="tab"
                                                    aria-controls="nav-home"
                                                    aria-selected="false">
                                                Bids
                                            </button>
                                            <button class="nav-link"
                                                    id="nav-profile-tab"
                                                    data-bs-toggle="tab"
                                                    data-bs-target="#nav-profile"
                                                    type="button"
                                                    role="tab"
                                                    aria-controls="nav-profile"
                                                    aria-selected="true">
                                                Details
                                            </button>
                                            <button class="nav-link"
                                                    id="nav-contact-tab"
                                                    data-bs-toggle="tab"
                                                    data-bs-target="#nav-contact"
                                                    type="button"
                                                    role="tab"
                                                    aria-controls="nav-contact"
                                                    aria-selected="false">
                                                History
                                            </button>
                                        </div>
                                    </nav>
                                    <div class="tab-content rn-bid-content" id="nav-tabContent">
                                        <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                                            <!-- Single creator -->
                                            <div class="top-seller-inner-one">
                                                <div class="top-seller-wrapper">
                                                    <div class="thumbnail">
                                                        <router-link to="#"><img :src="require(`@/assets/images/client/client-3.png`)" alt="Nft_Profile"></router-link>
                                                    </div>
                                                    <div class="top-seller-content">
                                                        <span>0.11wETH by <router-link to="#">Allen Waltker</router-link></span>
                                                        <span class="count-number">1 hours ago</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Single creator -->

                                            <!-- Single creator -->
                                            <div class="top-seller-inner-one">
                                                <div class="top-seller-wrapper">
                                                    <div class="thumbnail">
                                                        <router-link to="#"><img :src="require(`@/assets/images/client/client-4.png`)" alt="Nft_Profile"></router-link>
                                                    </div>
                                                    <div class="top-seller-content">
                                                        <span>0.09wETH by <router-link to="#">Joe Biden</router-link></span>
                                                        <span class="count-number">1.30 hours ago</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Single creator -->

                                            <!-- Single creator -->
                                            <div class="top-seller-inner-one">
                                                <div class="top-seller-wrapper">
                                                    <div class="thumbnail">
                                                        <router-link to="#">
                                                            <img :src="require(`@/assets/images/client/client-5.png`)" alt="Nft_Profile">
                                                        </router-link>
                                                    </div>
                                                    <div class="top-seller-content">
                                                        <span>0.07wETH by <router-link to="#">Sonial mridha</router-link></span>
                                                        <span class="count-number">1.35 hours ago</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Single creator -->

                                            <!-- Single creator -->
                                            <div class="top-seller-inner-one">
                                                <div class="top-seller-wrapper">
                                                    <div class="thumbnail">
                                                        <router-link to="#"><img :src="require(`@/assets/images/client/client-6.png`)" alt="Nft_Profile"></router-link>
                                                    </div>
                                                    <div class="top-seller-content">
                                                        <span>0.07wETH by <router-link to="#">Tribute Dhusra</router-link></span>
                                                        <span class="count-number">1.55 hours ago</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Single creator -->

                                            <!-- Single creator -->
                                            <div class="top-seller-inner-one">
                                                <div class="top-seller-wrapper">
                                                    <div class="thumbnail">
                                                        <router-link to="#">
                                                            <img :src="require(`@/assets/images/client/client-7.png`)" alt="Nft_Profile">
                                                        </router-link>
                                                    </div>
                                                    <div class="top-seller-content">
                                                        <span>0.07wETH by <router-link to="#">Sonia Sobnom</router-link></span>
                                                        <span class="count-number">2 hours ago</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Single creator -->

                                            <!-- Single creator -->
                                            <div class="top-seller-inner-one">
                                                <div class="top-seller-wrapper">
                                                    <div class="thumbnail">
                                                        <router-link to="#">
                                                            <img :src="require(`@/assets/images/client/client-8.png`)" alt="Nft_Profile">
                                                        </router-link>
                                                    </div>
                                                    <div class="top-seller-content">
                                                        <span>0.02wETH by <router-link to="#">Sadia Rummon</router-link></span>
                                                        <span class="count-number">2.5 hours ago</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Single creator -->
                                        </div>
                                        <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
                                            <div class="rn-pd-bd-wrapper">
                                                <div class="top-seller-inner-one">
                                                    <h6 class="name-title">Owner</h6>
                                                    <div class="top-seller-wrapper">
                                                        <div class="thumbnail">
                                                            <router-link to="#">
                                                                <img :src="require(`@/assets/images/client/client-1.png`)" alt="Nft_Profile">
                                                            </router-link>
                                                        </div>
                                                        <div class="top-seller-content">
                                                            <router-link to="#">
                                                                <h6 class="name">Brodband</h6>
                                                            </router-link>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="rn-pd-sm-property-wrapper">
                                                    <h6 class="pd-property-title">
                                                        Property
                                                    </h6>
                                                    <div class="property-wrapper">
                                                        <!-- single property -->
                                                        <div class="pd-property-inner">
                                                            <span class="color-body type">HYPE TYPE</span>
                                                            <span class="color-white value">CALM AF (STILL)</span>
                                                        </div>
                                                        <!-- single property End -->

                                                        <!-- single property -->
                                                        <div class="pd-property-inner">
                                                            <span class="color-body type">BASTARDNESS</span>
                                                            <span class="color-white value">C00LIO BASTARD</span>
                                                        </div>
                                                        <!-- single property End -->

                                                        <!-- single property -->
                                                        <div class="pd-property-inner">
                                                            <span class="color-body type">TYPE</span>
                                                            <span class="color-white value">APE</span>
                                                        </div>
                                                        <!-- single property End -->

                                                        <!-- single property -->
                                                        <div class="pd-property-inner">
                                                            <span class="color-body type">ASTARDNESS</span>
                                                            <span class="color-white value">BASTARD</span>
                                                        </div>
                                                        <!-- single property End -->

                                                        <!-- single property -->
                                                        <div class="pd-property-inner">
                                                            <span class="color-body type">BAD HABIT(S)</span>
                                                            <span class="color-white value">PIPE</span>
                                                        </div>
                                                        <!-- single property End -->

                                                        <!-- single property -->
                                                        <div class="pd-property-inner">
                                                            <span class="color-body type">BID</span>
                                                            <span class="color-white value">BPEYti</span>
                                                        </div>
                                                        <!-- single property End -->

                                                        <!-- single property -->
                                                        <div class="pd-property-inner">
                                                            <span class="color-body type">ASTRAGENAKAR</span>
                                                            <span class="color-white value">BASTARD</span>
                                                        </div>
                                                        <!-- single property End -->

                                                        <!-- single property -->
                                                        <div class="pd-property-inner">
                                                            <span class="color-body type">CITY</span>
                                                            <span class="color-white value">TOKYO</span>
                                                        </div>
                                                        <!-- single property End -->
                                                    </div>
                                                </div>
                                                <div class="rn-pd-sm-property-wrapper">
                                                    <h6 class="pd-property-title">Catagory</h6>
                                                    <div class="catagory-wrapper">
                                                        <!-- single property -->
                                                        <div class="pd-property-inner">
                                                            <span class="color-body type">ZARY</span>
                                                            <span class="color-white value">APP</span>
                                                        </div>
                                                        <!-- single property End -->

                                                        <!-- single property -->
                                                        <div class="pd-property-inner">
                                                            <span class="color-body type">SOMALIAN</span>
                                                            <span class="color-white value">TRIBUTE</span>
                                                        </div>
                                                        <!-- single property End -->

                                                        <!-- single property -->
                                                        <div class="pd-property-inner">
                                                            <span class="color-body type">TUNA</span>
                                                            <span class="color-white value">PIPE</span>
                                                        </div>
                                                        <!-- single property End -->

                                                        <!-- single property -->
                                                        <div class="pd-property-inner">
                                                            <span class="color-body type">BID</span>
                                                            <span class="color-white value">BPEYti</span>
                                                        </div>
                                                        <!-- single property End -->

                                                        <!-- single property -->
                                                        <div class="pd-property-inner">
                                                            <span class="color-body type">ASTRAGENAKAR</span>
                                                            <span class="color-white value">BASTARD</span>
                                                        </div>
                                                        <!-- single property End -->

                                                        <!-- single property -->
                                                        <div class="pd-property-inner">
                                                            <span class="color-body type">CITY</span>
                                                            <span class="color-white value">TOKYO</span>
                                                        </div>
                                                        <!-- single property End -->
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">
                                            <!-- Single creator -->
                                            <div class="top-seller-inner-one">
                                                <div class="top-seller-wrapper">
                                                    <div class="thumbnail">
                                                        <router-link to="#">
                                                            <img :src="require(`@/assets/images/client/client-3.png`)" alt="Nft_Profile">
                                                        </router-link>
                                                    </div>
                                                    <div class="top-seller-content">
                                                        <span>0.11wETH by<router-link to="#">Allen Waltker</router-link></span>
                                                        <span class="count-number">1 hours ago</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Single creator -->

                                            <!-- Single creator -->
                                            <div class="top-seller-inner-one mt--20">
                                                <div class="top-seller-wrapper">
                                                    <div class="thumbnail">
                                                        <router-link to="#">
                                                            <img :src="require(`@/assets/images/client/client-2.png`)" alt="Nft_Profile">
                                                        </router-link>
                                                    </div>
                                                    <div class="top-seller-content">
                                                        <span>0.11wETH by<router-link to="#">Allen Waltker</router-link></span>
                                                        <span class="count-number">1 hours ago</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Single creator -->

                                            <!-- Single creator -->
                                            <div class="top-seller-inner-one mt--20">
                                                <div class="top-seller-wrapper">
                                                    <div class="thumbnail">
                                                        <router-link to="#">
                                                            <img :src="require(`@/assets/images/client/client-4.png`)" alt="Nft_Profile">
                                                        </router-link>
                                                    </div>
                                                    <div class="top-seller-content">
                                                        <span>0.11wETH by<router-link to="#">Allen Waltker</router-link></span>
                                                        <span class="count-number">1 hours ago</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Single creator -->

                                            <!-- Single creator -->
                                            <div class="top-seller-inner-one mt--20">
                                                <div class="top-seller-wrapper">
                                                    <div class="thumbnail">
                                                        <router-link to="#">
                                                            <img :src="require(`@/assets/images/client/client-5.png`)" alt="Nft_Profile">
                                                        </router-link>
                                                    </div>
                                                    <div class="top-seller-content">
                                                        <span>0.11wETH by<router-link to="#">Allen Waltker</router-link></span>
                                                        <span class="count-number">1 hours ago</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Single creator -->

                                            <!-- Single creator -->
                                            <div class="top-seller-inner-one mt--20">
                                                <div class="top-seller-wrapper">
                                                    <div class="thumbnail">
                                                        <router-link to="#">
                                                            <img :src="require(`@/assets/images/client/client-8.png`)" alt="Nft_Profile">
                                                        </router-link>
                                                    </div>
                                                    <div class="top-seller-content">
                                                        <span>0.11wETH by<router-link to="#">Allen Waltker</router-link></span>
                                                        <span class="count-number">1 hours ago</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Single creator -->
                                        </div>
                                    </div>
                                </div>
                                <div class="place-bet-area">
                                    <div class="rn-bet-create">
                                        <div class="bid-list winning-bid">
                                            <h6 class="title">Winning bit</h6>
                                            <div class="top-seller-inner-one">
                                                <div class="top-seller-wrapper">
                                                    <div class="thumbnail">
                                                        <router-link to="#">
                                                            <img :src="require(`@/assets/images/client/client-7.png`)" alt="Nft_Profile">
                                                        </router-link>
                                                    </div>
                                                    <div class="top-seller-content">
                                                        <span class="heighest-bid">Heighest bid <router-link to="#">Atif aslam</router-link></span>
                                                        <span class="count-number">0.115wETH</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="bid-list left-bid">
                                            <h6 class="title">Auction has ended</h6>
                                            <countdown :date="'2025-12-09'" class="mt--15"/>
                                        </div>
                                    </div>
                                    <button type="button" 
                                            class="btn btn-primary-alta mt--30" 
                                            data-bs-toggle="modal" 
                                            data-bs-target="#placebidModal">
                                        Place a Bid
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End product details area -->

        <!-- Recent view area Start -->
        <div class="rn-new-items rn-section-gapTop">
            <div class="container">
                <div class="row mb--30 align-items-center">
                    <div class="col-12">
                        <h3 class="title mb--0">Recent View</h3>
                    </div>
                </div>
                <div class="row g-5">
                    <div class="col-5 col-lg-4 col-md-6 col-sm-6 col-12"
                         v-for="(item, index) in recentViewItems"
                         :key="`newest-item-${index}`">
                        <product-card
                            :product-date="item"
                            product-style-class="no-overlay"
                        />
                    </div>
                </div>
            </div>
        </div>
        <!-- Recent view area End -->

        <!-- Related item area Start -->
        <div class="rn-new-items rn-section-gapTop">
            <div class="container">
                <div class="row mb--30 align-items-center">
                    <div class="col-12">
                        <h3 class="title mb--0">Related Item</h3>
                    </div>
                </div>
                <div class="row g-5">
                    <div class="col-5 col-lg-4 col-md-6 col-sm-6 col-12"
                         v-for="(item, index) in relatedItems"
                         :key="`newest-item-${index}`">
                        <product-card
                            :product-date="item"
                            product-style-class="no-overlay"
                        />
                    </div>
                </div>
            </div>
        </div>
        <!-- Related item area End -->
        
        <share-modal/>
        
        <report-modal/>

        <placebid-modal/>
    </layout>
</template>

<script>
    import Layout from '@/components/layouts/Layout'
    import Breadcrumb from '@/components/breadcrumb/Breadcrumb'
    import ProductCard from '@/components/product/ProductCard'
    import ShareModal from '@/components/modal/ShareModal'
    import ReportModal from '@/components/modal/ReportModal'
    import Countdown from '@/components/product/Countdown'
    import PlacebidModal from '@/components/modal/PlacebidModal'
    import ProductMixin from "@/mixins/ProductMixin";

    export default {
        name: 'ProductDetails',
        components: {PlacebidModal, Countdown, ReportModal, ShareModal, ProductCard, Breadcrumb, Layout},
        mixins: [ProductMixin],
        data() {
            return {
                id: this.$route.params.id,
                product: {},
                activeTabIndex: 0,
                recentViewItems: [
                    {
                        id: 1,
                        productImage: require(`@/assets/images/portfolio/portfolio-01.jpg`),
                        authors: [
                            {
                                id: 1,
                                name: 'Jone lee',
                                image: require(`@/assets/images/client/client-1.png`)
                            },
                            {
                                id: 2,
                                name: 'Jone lee',
                                image: require(`@/assets/images/client/client-2.png`)
                            },
                            {
                                id: 3,
                                name: 'Nisat Tara',
                                image: require(`@/assets/images/client/client-3.png`)
                            }
                        ],
                        biddingAmount: '9',
                        productName: 'Preatent',
                        latestBid: 'Highest bid 1/20',
                        lastBid: '0.244wETH',
                        reacted: '322'
                    },
                    {
                        id: 2,
                        productImage: require(`@/assets/images/portfolio/portfolio-02.jpg`),
                        authors: [
                            {
                                id: 4,
                                name: 'Jone lee',
                                image: require(`@/assets/images/client/client-4.png`)
                            },
                            {
                                id: 5,
                                name: 'Nira Ara',
                                image: require(`@/assets/images/client/client-5.png`)
                            },
                            {
                                id: 6,
                                name: 'Fatima Afrafy',
                                image: require(`@/assets/images/client/client-6.png`)
                            }
                        ],
                        biddingAmount: '10',
                        productName: 'Diamond Dog',
                        latestBid: 'Highest bid 5/11',
                        lastBid: '0.892wETH',
                        reacted: '420'
                    },
                    {
                        id: 3,
                        productImage: require(`@/assets/images/portfolio/portfolio-03.jpg`),
                        authors: [
                            {
                                id: 1,
                                name: 'Jone lee',
                                image: require(`@/assets/images/client/client-1.png`)
                            },
                            {
                                id: 8,
                                name: 'Janin Ara',
                                image: require(`@/assets/images/client/client-8.png`)
                            },
                            {
                                id: 9,
                                name: 'Atif Islam',
                                image: require(`@/assets/images/client/client-9.png`)
                            }
                        ],
                        biddingAmount: '10',
                        productName: 'OrBid6',
                        latestBid: 'Highest bid 2/31',
                        lastBid: '0.2128wETH',
                        reacted: '12'
                    },
                    {
                        id: 4,
                        productImage: require(`@/assets/images/portfolio/portfolio-04.jpg`),
                        authors: [
                            {
                                id: 1,
                                name: 'Jone lee',
                                image: require(`@/assets/images/client/client-1.png`)
                            },
                            {
                                id: 3,
                                name: 'Jone lee',
                                image: require(`@/assets/images/client/client-3.png`)
                            },
                            {
                                id: 5,
                                name: 'Jone lee',
                                image: require(`@/assets/images/client/client-5.png`)
                            }
                        ],
                        biddingAmount: '8',
                        productName: 'Morgan11',
                        latestBid: 'Highest bid 3/16',
                        lastBid: '0.265wETH',
                        reacted: '20'
                    },
                    {
                        id: 5,
                        productImage: require(`@/assets/images/portfolio/portfolio-05.jpg`),
                        authors: [
                            {
                                id: 2,
                                name: 'Jone lee',
                                image: require(`@/assets/images/client/client-2.png`)
                            },
                            {
                                id: 7,
                                name: 'Jone lee',
                                image: require(`@/assets/images/client/client-7.png`)
                            },
                            {
                                id: 9,
                                name: 'Jone lee',
                                image: require(`@/assets/images/client/client-9.png`)
                            }
                        ],
                        biddingAmount: '15',
                        productName: 'mAtal8',
                        latestBid: 'Highest bid 6/50',
                        lastBid: '0.244wETH',
                        reacted: '205'
                    }
                ],
                relatedItems: [
                    {
                        id: 1,
                        productImage: require(`@/assets/images/portfolio/portfolio-01.jpg`),
                        authors: [
                            {
                                id: 1,
                                name: 'Jone lee',
                                image: require(`@/assets/images/client/client-1.png`)
                            },
                            {
                                id: 2,
                                name: 'Jone lee',
                                image: require(`@/assets/images/client/client-2.png`)
                            },
                            {
                                id: 3,
                                name: 'Nisat Tara',
                                image: require(`@/assets/images/client/client-3.png`)
                            }
                        ],
                        biddingAmount: '9',
                        productName: 'Preatent',
                        latestBid: 'Highest bid 1/20',
                        lastBid: '0.244wETH',
                        reacted: '322'
                    },
                    {
                        id: 2,
                        productImage: require(`@/assets/images/portfolio/portfolio-02.jpg`),
                        authors: [
                            {
                                id: 4,
                                name: 'Jone lee',
                                image: require(`@/assets/images/client/client-4.png`)
                            },
                            {
                                id: 5,
                                name: 'Nira Ara',
                                image: require(`@/assets/images/client/client-5.png`)
                            },
                            {
                                id: 6,
                                name: 'Fatima Afrafy',
                                image: require(`@/assets/images/client/client-6.png`)
                            }
                        ],
                        biddingAmount: '10',
                        productName: 'Diamond Dog',
                        latestBid: 'Highest bid 5/11',
                        lastBid: '0.892wETH',
                        reacted: '420'
                    },
                    {
                        id: 3,
                        productImage: require(`@/assets/images/portfolio/portfolio-03.jpg`),
                        authors: [
                            {
                                id: 1,
                                name: 'Jone lee',
                                image: require(`@/assets/images/client/client-1.png`)
                            },
                            {
                                id: 8,
                                name: 'Janin Ara',
                                image: require(`@/assets/images/client/client-8.png`)
                            },
                            {
                                id: 9,
                                name: 'Atif Islam',
                                image: require(`@/assets/images/client/client-9.png`)
                            }
                        ],
                        biddingAmount: '10',
                        productName: 'OrBid6',
                        latestBid: 'Highest bid 2/31',
                        lastBid: '0.2128wETH',
                        reacted: '12'
                    },
                    {
                        id: 4,
                        productImage: require(`@/assets/images/portfolio/portfolio-04.jpg`),
                        authors: [
                            {
                                id: 1,
                                name: 'Jone lee',
                                image: require(`@/assets/images/client/client-1.png`)
                            },
                            {
                                id: 3,
                                name: 'Jone lee',
                                image: require(`@/assets/images/client/client-3.png`)
                            },
                            {
                                id: 5,
                                name: 'Jone lee',
                                image: require(`@/assets/images/client/client-5.png`)
                            }
                        ],
                        biddingAmount: '8',
                        productName: 'Morgan11',
                        latestBid: 'Highest bid 3/16',
                        lastBid: '0.265wETH',
                        reacted: '20'
                    },
                    {
                        id: 5,
                        productImage: require(`@/assets/images/portfolio/portfolio-05.jpg`),
                        authors: [
                            {
                                id: 2,
                                name: 'Jone lee',
                                image: require(`@/assets/images/client/client-2.png`)
                            },
                            {
                                id: 7,
                                name: 'Jone lee',
                                image: require(`@/assets/images/client/client-7.png`)
                            },
                            {
                                id: 9,
                                name: 'Jone lee',
                                image: require(`@/assets/images/client/client-9.png`)
                            }
                        ],
                        biddingAmount: '15',
                        productName: 'mAtal8',
                        latestBid: 'Highest bid 6/50',
                        lastBid: '0.244wETH',
                        reacted: '205'
                    }
                ],
            }
        },
        methods: {
            getProduct(productId) {
                this.product = this.products.find(item => item.id == productId);
            }
        },
        created() {
            this.getProduct(this.id);
        },
        watch: {
            '$route.params.id': function (val) {
                this.id = val;
                this.getProduct(this.id);
            }
        },
    }
</script>