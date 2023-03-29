<template>
    <div class="maintanence-area">
        <div class="wrapper">
            <div class="row row--0 h-100">
                <div class="col-lg-4 col-md-4">
                    <div class="inner">
                        <div class="logo logo-custom-css">
                            <router-link class="logo-light" to="/">
                                <img :src="require(`@/assets/images/logo/logo-white.png`)" alt="nft-logo">
                            </router-link>
                            <router-link class="logo-dark" to="/">
                                <img :src="require(`@/assets/images/logo/logo-dark.png`)" alt="nft-logo">
                            </router-link>
                        </div>
                        <div class="content">
                            <span class="sub-title">Stay Tuned</span>
                            <h3 class="title">
                                <span>Coming Soon</span>
                            </h3>
                            <p>
                                We are available please connect with us via
                                <br>
                                Phone: <a href="tel:+880191122334">+880123456789</a> or
                                <br> Email: <a href="mailto:admin@example.com"> admin@example.com</a>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-8 col-md-8">
                    <carousel class="banner-one-slick comeing-soon-slick slider-style-4 slick-activation-09 slick-arrow-style-one rn-slick-dot-style"
                              :items-to-show="1"
                              :wrap-around="true">
                        <slide v-for="(carouselItem, index) in carouselItems" :key="index">
                            <div :class="`w-100 single-rn-slider ${carouselItem.image} bg_image`"/>
                        </slide>
                    </carousel>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import {Carousel, Slide} from 'vue3-carousel'

    export default {
        name: 'ComingSoon',
        components: {Carousel, Slide},
        data() {
            return {
                carouselItems: [
                    {image: 'bg_image--14'},
                    {image: 'bg_image--15'},
                    {image: 'bg_image--16'},
                    {image: 'bg_image--15'}
                ]
            }
        }
    }
</script>