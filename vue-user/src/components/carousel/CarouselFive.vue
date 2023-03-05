<template>
    <carousel class="slider-activation-banner-4 game-banner-short-slick-wrapper slick-arrow-style-one rn-slick-dot-style"
              :items-to-show="1"
              :wrap-around="true">
        <slide v-for="(carouselItem, index) in carouselItems"
               :key="index">
            <div :class="`slider-style-7 border-radious-none ${carouselItem.image} pt--150 pb--190 pt_sm--70 pb_sm--70 bg_image`"
                 data-black-overlay="6">
                <div class="rn-banner-wrapper text-start g-5 row">
                    <div class="col-xl-4 col-lg-12 col-12 order-3 order-xl-1 order-sm-1">
                        <router-link :to="`/product/${carouselItem.id}`">
                            <h2 class="title pl--30" v-html="carouselItem.title"></h2>
                        </router-link>
                    </div>
                    <div class="col-xl-6 col-lg-12 col-12 order-2 order-xl-2 order-sm-2">
                        <div class="item-description">
                            <p v-html="carouselItem.description"></p>
                            <div class="product-share-wrapper">
                                <div class="profile-share">
                                    <router-link :to="`/author/1`"
                                                 class="avatar"
                                                 :data-tooltip="author.name"
                                                 v-for="(author, index) in carouselItem.authors"
                                                 :key="`author-${index}`">
                                        <img :src="author.image" alt="Nft_Profile">
                                    </router-link>
                                    <router-link class="more-author-text" to="#">
                                        {{ carouselItem.biddingAmount }}+ Place Bit.
                                    </router-link>
                                </div>
                                <countdown :date="carouselItem.countdown.date"/>
                            </div>
                            <button type="button"
                                    class="btn btn-primary-alta btn-large mt--35"
                                    data-bs-toggle="modal"
                                    data-bs-target="#placebidModal"
                                    tabindex="0">
                                Place a Bid
                            </button>
                        </div>
                    </div>
                    <div class="col-xl-2 col-lg-12 col-12 order-1 order-xl-3 order-sm-3">
                        <div class="img-thumb-award d-flex justify-content-center">
                            <img :src="require(`@/assets/images/logo/award-logo.png`)" alt="Nuron-Logo">
                        </div>
                    </div>
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
    import Countdown from '@/components/product/Countdown'

    export default {
        name: 'CarouselFive',
        props: {
            carouselItems: ''
        },
        components: {Countdown, Pagination, Carousel, Slide, Navigation},
    }
</script>