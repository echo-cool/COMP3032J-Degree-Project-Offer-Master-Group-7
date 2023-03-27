<template>
    <div class="banner-area pt--25">
        <div class="container-fluid">
            <carousel class="slider-style-2"
                      :items-to-show="1"
                      :wrap-around="true"
                      :breakpoints="breakpoints">
                <template #addons>
                    <div class="carousel-navigation">
                        <navigation/>
                    </div>
                </template>
                <slide v-for="(carouselItem, index) in carouselItems" :key="index">
                    <div class="single-slide">
                        <div class="inner">
                            <div class="thumbnail">
                                <router-link :to="`/product/${carouselItem.id}`">
                                    <img :src="carouselItem.image" alt="NFT_portfolio">
                                </router-link>
                            </div>
                            <div class="banner-read-thumb text-start">
                                <h4>
                                    <router-link :to="`/product/${carouselItem.id}`">
                                        {{ carouselItem.title }}
                                    </router-link>
                                </h4>
                                <span>{{ carouselItem.author }}</span>
                            </div>
                        </div>
                    </div>
                </slide>
            </carousel>
        </div>
    </div>
</template>

<script>
    import 'vue3-carousel/dist/carousel.css'
    import { Carousel, Slide, Navigation } from 'vue3-carousel'

    export default {
        name: 'CarouselTwo',
        props: {
            carouselItems: ''
        },
        components: {Carousel, Slide, Navigation},
        data() {
            return {
                breakpoints: {
                    576: {
                        itemsToShow: 2,
                        snapAlign: 'left'
                    },
                    768: {
                        itemsToShow: 2,
                        snapAlign: 'left'
                    },
                    992: {
                        itemsToShow: 3,
                        snapAlign: 'left'
                    },
                    1200: {
                        itemsToShow: 3,
                        snapAlign: 'left'
                    },
                    1399: {
                        itemsToShow: 3,
                        snapAlign: 'left'
                    }
                },
            }
        }
    }
</script>