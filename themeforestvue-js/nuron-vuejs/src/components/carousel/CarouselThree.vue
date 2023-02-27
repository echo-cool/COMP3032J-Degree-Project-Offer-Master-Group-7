<template>
    <carousel class="slider slider-activation-banner-3"
              :items-to-show="1"
              :wrap-around="true">
        <slide v-for="(carouselItem, index) in carouselItems"
               :key="index">
            <div class="slider-thumbnail thumbnail-overlay">
                <router-link :to="`/product/${carouselItem.id}`">
                    <img class="w-100" :src="carouselItem.image" alt="NFT_portfolio">
                </router-link>
                <div class="read-wrapper">
                    <h5>
                        <router-link :to="`/product/${carouselItem.id}`">
                            {{ carouselItem.title }}
                        </router-link>
                    </h5>
                    <span>{{ carouselItem.author }}</span>
                </div>
            </div>
        </slide>
        <template #addons>
            <Pagination/>
        </template>
    </carousel>
</template>

<script>
    import 'vue3-carousel/dist/carousel.css'
    import { Carousel, Slide, Navigation, Pagination } from 'vue3-carousel'

    export default {
        name: 'CarouselThree',
        props: {
            carouselItems: ''
        },
        components: {Pagination, Carousel, Slide, Navigation},
    }
</script>