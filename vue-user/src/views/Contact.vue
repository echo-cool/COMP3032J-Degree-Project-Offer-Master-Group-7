<template>


    <div class="maintanence-area">
        <div class="wrapper">
            <div class="row row--0 h-100">
                <div class="col-lg-4 col-md-4">
                    <div class="inner">
                        <div class="logo logo-custom-css" style="width: 300px">
                            <router-link class="logo-light" to="/">
                                <img :src="require(`@/assets/images/logo/new/logo-white.png`)" alt="nft-logo" style="max-width: 200px; margin-bottom: 0px">
                            </router-link>
                            <router-link class="logo-dark" to="/">
                                <img :src="require(`@/assets/images/logo/new/logo-dark.png`)" alt="nft-logo" style="max-width: 200px;margin-bottom: 0px">
                            </router-link>
                        </div>
                        <div id="aplayer"></div>
                        <div class="content">
                            <span class="sub-title">Feel free to</span>
                            <h3 class="title">
                                <span>Contact Us</span>
                            </h3>
                            <p>
                                We are available please connect with us via
                                <br>
                                Phone: <a href="tel:+8613552074215">+86 135 5207 4215</a> or
                                <br> Email: <a href="mailto:wyy@echo.cool"> wyy@echo.cool</a>
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
    // import 'aplayer/dist/APlayer.min.css';
    // import 'aplayer/dist/APlayer.min.js';
    // const ap = new APlayer({
    //     container: document.getElementById('aplayer'),
    //     audio: [{
    //         name: 'name',
    //         artist: 'artist',
    //         url: 'url.mp3',
    //         cover: 'cover.jpg'
    //     }]
    // });

    // import APlayer from 'aplayer';
    //
    // const ap = new APlayer();
    export default {
        name: 'ComingSoon',
        components: {Carousel, Slide},
        data() {
            return {
                carouselItems: [
                    {image: 'WechatIMG989'},
                    {image: 'WechatIMG986'},
                    {image: 'WechatIMG993'},
                    {image: 'WechatIMG995'}
                ]
            }
        }
    }
</script>
