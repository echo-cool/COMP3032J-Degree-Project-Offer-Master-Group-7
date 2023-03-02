<template>
    <layout-sidebar>
        <template v-slot:banner>
            <div class="rn-banner-area">
                <div class="slider-style-7 bg_image--15 bg_image" data-black-overlay="8">
                    <div class="rn-banner-wrapper row">
                        <div class="col-xl-5 col-lg-12 col-12 order-3 order-xl-1">
                            <div class="item-description">
                                <p>
                                    The term fungible means something that can be replaced by something similar. So, by
                                    the
                                    name Non Fungible Tokens, we can easily understand.
                                </p>
                                <div class="product-share-wrapper">
                                    <div class="profile-share">
                                        <router-link to="/author/1" class="avatar" data-tooltip="Mark Joe"><img :src="require(`@/assets/images/client/client-1.png`)" alt="Nft_Profile"></router-link>
                                        <router-link to="/author/2" class="avatar" data-tooltip="Mr.Jone-lee"><img :src="require(`@/assets/images/client/client-3.png`)" alt="Nft_Profile"></router-link>
                                        <router-link to="/author/3" class="avatar" data-tooltip="David Worner"><img :src="require(`@/assets/images/client/client-5.png`)" alt="Nft_Profile"></router-link>
                                        <router-link class="more-author-text" to="#">9+ Place Bit.</router-link>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-4 col-lg-12 col-12 order-2 order-xl-2">
                            <h2 class="title">
                                Discover <br> Rare Digital art & collect <span>NFT's</span>
                            </h2>
                        </div>
                        <div class="col-xl-3 col-lg-12 col-12 order-1 order-xl-3">
                            <div class="img-thumb-award">
                                <img :src="require(`@/assets/images/logo/award-logo.png`)" alt="">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </template>

        <!-- Live Bidding Area Start -->
        <div id="list-item-2">
            <explore-live :product-limit="4" product-column="col-lg-6 col-xl-3 col-md-6 col-sm-6 col-12"/>
        </div>
        <!-- Live Bidding Area End -->

        <!-- Collection Area Start -->
        <collection-style-one/>
        <!-- Collection Area End -->

        <!-- Start Explore Area -->
        <div id="list-item-3">
            <explore-isotop-two/>
        </div>
        <!-- End Explore Area -->

        <!-- Start Service Area -->
        <div id="list-item-4">
            <service-style-one :service-limit="3" service-column="col-xl-4 col-lg-6 col-md-6 col-sm-6 col-12"/>
        </div>
        <!-- End Service Area -->
    </layout-sidebar>
</template>

<script>
    import LayoutSidebar from '@/components/layouts/LayoutSidebar'
    import ExploreLive from '@/components/explore/ExploreLive'
    import CollectionStyleOne from '@/components/collection/CollectionStyleOne'
    import ServiceStyleOne from '@/components/service/ServiceStyleOne'
    import ExploreIsotopTwo from '@/components/explore/ExploreIsotopTwo'

    export default {
        name: 'HomePageSeven',
        components: {ExploreIsotopTwo, ServiceStyleOne, CollectionStyleOne, ExploreLive, LayoutSidebar}
    }
</script>