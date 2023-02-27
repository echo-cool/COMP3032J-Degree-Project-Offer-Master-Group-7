<template>
    <layout>
        <!-- Start banner area -->
        <div class="rn-banner-area rn-section-gapTop">
            <div class="container">
                <div class="row g-5">
                    <div class="col-lg-12">
                        <carousel-one :carousel-items="carouselItems"/>
                    </div>
                </div>
            </div>
        </div>
        <!-- End banner area End -->

        <!-- Start collection area -->
        <collection-style-one/>
        <!-- End collection area -->

        <!-- Start Explore Area -->
        <explore-isotop/>
        <!-- End Explore Area -->

        <!-- Start Top seller Area -->
        <seller-style-two/>
        <!-- End Top seller Area -->

        <!-- Start Service Area -->
        <service-style-one/>
        <!-- End Service Area -->
    </layout>
</template>

<script>
    import Layout from "@/components/layouts/Layout";
    import CarouselOne from "@/components/carousel/CarouselOne";
    import CollectionStyleOne from "@/components/collection/CollectionStyleOne";
    import ExploreIsotop from "@/components/explore/ExploreIsotop";
    import SalScrollAnimationMixin from "@/mixins/SalScrollAnimationMixin";
    import SellerStyleTwo from "@/components/seller/SellerStyleTwo";
    import ServiceStyleOne from "@/components/service/ServiceStyleOne";

    export default {
        name: 'HomePageSix',
        components: {ServiceStyleOne, SellerStyleTwo, ExploreIsotop, CollectionStyleOne, CarouselOne, Layout},
        mixins: [SalScrollAnimationMixin],
        data() {
            return {
                carouselItems: [
                    {
                        title: `The way to find any <br> Digital content`,
                        description: `Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolores <br/> expedita beatae exercitationem quasi ullam esse?`,
                        image: 'bg_image--19'
                    },
                    {
                        title: `The way to find any <br> Digital content`,
                        description: `Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolores <br/> expedita beatae exercitationem quasi ullam esse?`,
                        image: 'bg_image--18'
                    },
                    {
                        title: `The way to find any <br> Digital content`,
                        description: `Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolores <br/> expedita beatae exercitationem quasi ullam esse?`,
                        image: 'bg_image--20'
                    }
                ]
            }
        }
    }
</script>