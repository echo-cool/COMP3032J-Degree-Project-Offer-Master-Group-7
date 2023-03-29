<template>
    <layout>
        <carousel-two :carousel-items="carouselItems"/>

        <!-- Best Seller Area Start -->
        <seller-style-two/>
        <!-- Best Seller Area End -->

        <!-- Newest Items Area Start -->
        <explore-newest-item/>
        <!-- Newest Items Area End -->

        <!-- Live Bidding Area Start -->
        <explore-live/>
        <!-- Live Bidding Area End -->

        <!-- Start Service Area -->
        <service-style-one/>
        <!-- End Service Area -->

        <!-- Explore Product Area Start -->
        <explore-filter/>
        <!-- Explore Product Area End -->

        <!-- Collection Area Start -->
        <collection-style-one/>
        <!-- Collection Area End -->

        <share-modal/>

        <report-modal/>
    </layout>
</template>

<script>
    import Layout from '@/components/layouts/Layout'
    import CarouselTwo from '@/components/carousel/CarouselTwo'
    import SalScrollAnimationMixin from '@/mixins/SalScrollAnimationMixin'
    import ShareModal from '@/components/modal/ShareModal'
    import ReportModal from '@/components/modal/ReportModal'
    import ExploreFilter from '@/components/explore/ExploreFilter'
    import SellerStyleTwo from '@/components/seller/SellerStyleTwo'
    import ExploreNewestItem from "@/components/explore/ExploreNewestItem";
    import ExploreLive from "@/components/explore/ExploreLive";
    import ServiceStyleOne from "@/components/service/ServiceStyleOne";
    import CollectionStyleOne from "@/components/collection/CollectionStyleOne";

    export default {
        name: 'HomePageTwo',
        components: {
            CollectionStyleOne,
            ServiceStyleOne,
            ExploreLive,
            ExploreNewestItem,
            SellerStyleTwo,
            ExploreFilter,
            ReportModal,
            ShareModal,
            CarouselTwo,
            Layout
        },
        mixins: [SalScrollAnimationMixin],
        data() {
            return {
                carouselItems: [
                    {
                        id: 1,
                        image: require(`@/assets/images/banner/banner-01.jpg`),
                        title: 'Cubic Bazier',
                        author: 'John Lee'
                    },
                    {
                        id: 2,
                        image: require(`@/assets/images/banner/banner-02.jpg`),
                        title: 'Faminho24',
                        author: 'Mr.Alamin'
                    },
                    {
                        id: 3,
                        image: require(`@/assets/images/banner/banner-03.jpg`),
                        title: 'Tzniistan',
                        author: 'Ms.maybin'
                    },
                    {
                        id: 4,
                        image: require(`@/assets/images/banner/banner-04.jpg`),
                        title: 'Bazier',
                        author: 'Ms.Dhoni'
                    }
                ],
            }
        }
    }
</script>