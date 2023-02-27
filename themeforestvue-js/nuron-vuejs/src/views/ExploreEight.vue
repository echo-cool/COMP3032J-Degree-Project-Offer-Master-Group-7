<template>
    <layout>
        <breadcrumb title="Place Bid With Carousel" current="Place Bid With Carousel"/>

        <div class="en-product-area rn-section-gap">
            <div class="container">
                <explore-carousel :place-bid="true"/>
            </div>
        </div>

        <div class="en-product-area rn-section-gapBottom">
            <div class="container">
                <explore-carousel title="Explore Carousel Dots" :arrow="false" :dots="true" :place-bid="true"/>
            </div>
        </div>

        <div class="en-product-area">
            <div class="container">
                <explore-carousel title="Explore Carousel Both" :dots="true" :place-bid="true"/>
            </div>
        </div>
    </layout>
</template>

<script>
    import Layout from '@/components/layouts/Layout'
    import Breadcrumb from '@/components/breadcrumb/Breadcrumb'
    import ExploreCarousel from '@/components/explore/ExploreCarousel'
    import SalScrollAnimationMixin from '@/mixins/SalScrollAnimationMixin'

    export default {
        name: 'ExploreEight',
        components: {ExploreCarousel, Breadcrumb, Layout},
        mixins: [SalScrollAnimationMixin]
    }
</script>