<template>
    <div class="slider-style-6 wide-wrapper slick-activation-06 slick-arrow-between">
        <carousel :items-to-show="1"
                  :wrap-around="true">
            <template #addons>
                <div class="carousel-navigation">
                    <navigation/>
                </div>
            </template>
            <slide v-for="(carouselItem, index) in carouselItems"
                   :key="index"
                   :class="`slide bg_image ${carouselItem.image}`">
                <div class="banner-read-thumb-lg">
                    <h4 v-html="carouselItem.title"></h4>
                    <p v-html="carouselItem.description"></p>
                    <div class="button-group">
                        <router-link to="/create" class="btn btn-large btn-primary mr--15">Get Started</router-link>
                        <router-link to="/create" class="btn btn-large btn-primary-alta">Create</router-link>
                    </div>
                </div>
            </slide>
        </carousel>
    </div>
</template>

<script>
    import 'vue3-carousel/dist/carousel.css'
    import { Carousel, Slide, Navigation } from 'vue3-carousel'

    export default {
        name: 'CarouselOne',
        props: {
            carouselItems: ''
        },
        components: {Carousel, Slide, Navigation},
    }
</script>