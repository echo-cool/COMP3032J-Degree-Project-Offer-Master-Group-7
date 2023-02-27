<template>
    <layout-sidebar :show-right-sidebar="false">
        <template v-slot:banner>
            <div class="rn-banner-area">
                <carousel-five :carousel-items="bannerItems"/>
            </div>
        </template>

        <seller-style-one/>

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
            <service-style-one/>
        </div>
        <!-- End Service Area -->

        <share-modal/>

        <report-modal/>

        <placebid-modal/>
    </layout-sidebar>
</template>

<script>
    import LayoutSidebar from '@/components/layouts/LayoutSidebar'
    import SellerStyleOne from '@/components/seller/SellerStyleOne'
    import ExploreLive from '@/components/explore/ExploreLive'
    import CollectionStyleOne from '@/components/collection/CollectionStyleOne'
    import ExploreIsotopTwo from '@/components/explore/ExploreIsotopTwo'
    import ServiceStyleOne from '@/components/service/ServiceStyleOne'
    import CarouselFive from '@/components/carousel/CarouselFive'
    import ShareModal from "@/components/modal/ShareModal";
    import ReportModal from "@/components/modal/ReportModal";
    import PlacebidModal from "@/components/modal/PlacebidModal";

    export default {
        name: 'HomePageEight',
        components: {
            PlacebidModal,
            ReportModal,
            ShareModal,
            CarouselFive,
            ServiceStyleOne,
            ExploreIsotopTwo,
            CollectionStyleOne,
            ExploreLive,
            SellerStyleOne,
            LayoutSidebar
        },
        data() {
            return {
                bannerItems: [
                    {
                        id: 1,
                        image: 'bg_image--23',
                        title: `Discover <br> Rare Digital art & collect <span>NFT's</span>`,
                        description: `The term fungible means something that can be replaced by something similar. So, by the name Non Fungible Tokens, we can easily understand.`,
                        countdown: {
                            date: '2023-11-09'
                        },
                        authors: [
                            {
                                name: 'mr. Davei',
                                image: require(`@/assets/images/client/client-9.png`)
                            },
                            {
                                name: 'Mrs.Laumi',
                                image: require(`@/assets/images/client/client-10.png`)
                            },
                            {
                                name: 'Shanon',
                                image: require(`@/assets/images/client/client-11.png`)
                            }
                        ],
                        biddingAmount: '13',
                    },
                    {
                        id: 2,
                        image: 'bg_image--22',
                        title: `Discover <br> Rare Digital art & collect <span>NFT's</span>`,
                        description: `The term fungible means something that can be replaced by something similar. So, by the name Non Fungible Tokens, we can easily understand.`,
                        countdown: {
                            date: '2023-11-09'
                        },
                        authors: [
                            {
                                name: 'mr. Davei',
                                image: require(`@/assets/images/client/client-9.png`)
                            },
                            {
                                name: 'Mrs.Laumi',
                                image: require(`@/assets/images/client/client-10.png`)
                            },
                            {
                                name: 'Shanon',
                                image: require(`@/assets/images/client/client-11.png`)
                            }
                        ],
                        biddingAmount: '13',
                    },
                    {
                        id: 3,
                        image: 'bg_image--21',
                        title: `Discover <br> Rare Digital art & collect <span>NFT's</span>`,
                        description: `The term fungible means something that can be replaced by something similar. So, by the name Non Fungible Tokens, we can easily understand.`,
                        countdown: {
                            date: '2023-11-09'
                        },
                        authors: [
                            {
                                name: 'mr. Davei',
                                image: require(`@/assets/images/client/client-9.png`)
                            },
                            {
                                name: 'Mrs.Laumi',
                                image: require(`@/assets/images/client/client-10.png`)
                            },
                            {
                                name: 'Shanon',
                                image: require(`@/assets/images/client/client-11.png`)
                            }
                        ],
                        biddingAmount: '13',
                    }
                ]
            }
        }
    }
</script>
