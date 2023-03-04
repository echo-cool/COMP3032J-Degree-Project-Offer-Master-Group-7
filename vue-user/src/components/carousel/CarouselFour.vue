<template>
    <carousel :items-to-show="1"
              :wrap-around="true">
        <slide v-for="(carouselItem, index) in carouselItems"
               :key="index">
            <div class="slider-thumbnail thumbnail-overlay">
                <router-link :to="`/product/${carouselItem.id}`">
                    <img class="w-100" :src="carouselItem.image" alt="NFT_portfolio">
                </router-link>
                <div class="read-wrapper">
                    <h5>
                        {{ carouselItem.title }}
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
    import {Carousel, Slide, Navigation, Pagination} from 'vue3-carousel'

    export default {
        name: 'CarouselFour',
        components: {Pagination, Carousel, Slide, Navigation},
        data() {
            return {
                carouselItems: [
                    {
                        id: 1,
                        image: require(`@/assets/images/banner/banner-04.jpg`),
                        title: 'Twinkle',
                        author: 'Latis Hook'
                    },
                    {
                        id: 2,
                        image: require(`@/assets/images/banner/banner-01.jpg`),
                        title: 'Monster',
                        author: 'Decruse'
                    },
                    {
                        id: 3,
                        image: require(`@/assets/images/banner/banner-02.jpg`),
                        title: 'Labibas Had',
                        author: 'Kenlee'
                    },
                    {
                        id: 4,
                        image: require(`@/assets/images/banner/banner-03.jpg`),
                        title: 'OperaHub',
                        author: 'Lathis Hook'
                    }
                ],
            }
        }
    }
</script>