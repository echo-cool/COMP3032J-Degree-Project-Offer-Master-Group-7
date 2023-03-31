<template>
    <div class="rn-live-bidding-area rn-section-gapTop">
        <div class="container">
            <carousel class="portfolio-slider"
                      :items-to-show="1"
                      :wrap-around="true"
                      :breakpoints="breakpoints">
                <template #addons>
                    <div class="carousel-header">
                        <div class="section-title">
                            <h3 class="title mb--0 live-bidding-title" data-sal-delay="150" data-sal-duration="800">
                                {{ title }}
                            </h3>
                        </div>
                        <div class="carousel-navigation">
                            <navigation/>
                        </div>
                    </div>
                </template>
<!--                <slide v-for="(carouselItem, index) in liveBiddingItems" :key="index">-->
<!--                    <program-card-->
<!--                        :product-date="carouselItem"-->
<!--                        :show-place-bid="showPlaceBid"-->
<!--                        :product-style-class="showPlaceBid ? 'no-overlay with-placeBid' : ''"-->
<!--                    />-->
<!--                </slide>-->
                <slide v-for="(application, index) in applications" :key="index">
                    <program-card
                        :program="application.program"
                        :school="application.program.school"
                        :show-d-d-l-countdown="true"
                        :deadline="application.deadline"
                        :is-liked-obj="isLiked(application.program.id)"
                    />
                </slide>
            </carousel>
        </div>
    </div>
</template>

<script>
import 'vue3-carousel/dist/carousel.css'
import {Carousel, Navigation, Slide} from 'vue3-carousel'
import ProgramCard from "@/components/myComp/program/ProgramCard.vue";
import LikeMixin from "@/mixins/user/LikeMixin";

export default {
        name: 'MyProgramListTimerCarousel',
        mixins: [
            LikeMixin
        ],
        computed: {

        },
        components: {
            ProgramCard,
            Carousel,
            Slide,
            Navigation,
        },
        props: {
            title: {
                type: String,
                default: 'Programs'
            },
            showPlaceBid: {
                type: Boolean,
                default: false
            },
            applications: {
                type: Array,
                default: function () {
                    return [];
                }
            }
        },
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
                        itemsToShow: 4,
                        snapAlign: 'left'
                    },
                    1399: {
                        itemsToShow: 5,
                        snapAlign: 'left'
                    }
                },
                liveBiddingItems: [
                    {
                        id: 7,
                        productImage: require(`@/assets/images/portfolio/portfolio-07.jpg`),
                        countdown: {
                            date: '2023-11-09'
                        },
                        authors: [
                            {
                                id: 2,
                                name: 'Mark Jordan',
                                image: require(`@/assets/images/client/client-2.png`)
                            },
                            {
                                id: 3,
                                name: 'Mark',
                                image: require(`@/assets/images/client/client-3.png`)
                            },
                            {
                                id: 5,
                                name: 'Jordan',
                                image: require(`@/assets/images/client/client-5.png`)
                            }
                        ],
                        biddingAmount: '20',
                        productName: 'Preatent',
                        latestBid: 'Highest bid 1/20',
                        lastBid: '0.244wETH',
                        reacted: '322'
                    },
                    {
                        id: 10,
                        productImage: require(`@/assets/images/portfolio/portfolio-10.jpg`),
                        countdown: {
                            date: '2023-11-09'
                        },
                        authors: [
                            {
                                id: 1,
                                name: 'Farik Shaikh',
                                image: require(`@/assets/images/client/client-1.png`)
                            },
                            {
                                id: 6,
                                name: 'Shaikh',
                                image: require(`@/assets/images/client/client-6.png`)
                            },
                            {
                                id: 8,
                                name: 'Farik',
                                image: require(`@/assets/images/client/client-8.png`)
                            }
                        ],
                        biddingAmount: '15',
                        productName: '#21 The Wonder',
                        latestBid: 'Highest bid 1/20',
                        lastBid: '0.244wETH',
                        reacted: '322'
                    },
                    {
                        id: 3,
                        productImage: require(`@/assets/images/portfolio/portfolio-03.jpg`),
                        countdown: {
                            date: '2023-10-09'
                        },
                        authors: [
                            {
                                id: 8,
                                name: 'Mona Lisa',
                                image: require(`@/assets/images/client/client-8.png`)
                            },
                            {
                                id: 4,
                                name: 'Lisa',
                                image: require(`@/assets/images/client/client-4.png`)
                            },
                            {
                                id: 9,
                                name: 'Mona',
                                image: require(`@/assets/images/client/client-9.png`)
                            }
                        ],
                        biddingAmount: '12',
                        productName: 'OrBid6',
                        latestBid: 'Highest bid 2/31',
                        lastBid: '0.244wETH',
                        reacted: '12'
                    },
                    {
                        id: 4,
                        productImage: require(`@/assets/images/portfolio/portfolio-04.jpg`),
                        countdown: {
                            date: '2023-12-09'
                        },
                        authors: [
                            {
                                id: 2,
                                name: 'Falak Sabbir',
                                image: require(`@/assets/images/client/client-2.png`)
                            },
                            {
                                id: 1,
                                name: 'Sabbir',
                                image: require(`@/assets/images/client/client-1.png`)
                            },
                            {
                                id: 11,
                                name: 'Falak',
                                image: require(`@/assets/images/client/client-11.png`)
                            }
                        ],
                        biddingAmount: '16',
                        productName: 'Morgan11',
                        latestBid: 'Highest bid 3/16',
                        lastBid: '0.244wETH',
                        reacted: '20'
                    },
                    {
                        id: 6,
                        productImage: require(`@/assets/images/portfolio/portfolio-06.jpg`),
                        countdown: {
                            date: '2024-10-08'
                        },
                        authors: [
                            {
                                id: 2,
                                name: 'Oram Kasin',
                                image: require(`@/assets/images/client/client-2.png`)
                            },
                            {
                                id: 3,
                                name: 'Kasin',
                                image: require(`@/assets/images/client/client-3.png`)
                            },
                            {
                                id: 5,
                                name: 'Oram',
                                image: require(`@/assets/images/client/client-5.png`)
                            }
                        ],
                        biddingAmount: '10',
                        productName: 'mAtal8',
                        latestBid: 'Highest bid 6/50',
                        lastBid: '0.244wETH',
                        reacted: '205'
                    },
                    {
                        id: 10,
                        productImage: require(`@/assets/images/portfolio/portfolio-10.jpg`),
                        countdown: {
                            date: '2023-11-08'
                        },
                        authors: [
                            {
                                id: 10,
                                name: 'Oram Kasin',
                                image: require(`@/assets/images/client/client-10.png`)
                            },
                            {
                                id: 6,
                                name: 'Kasin',
                                image: require(`@/assets/images/client/client-6.png`)
                            },
                            {
                                id: 1,
                                name: 'Oram',
                                image: require(`@/assets/images/client/client-1.png`)
                            }
                        ],
                        biddingAmount: '20',
                        productName: 'Delta25',
                        latestBid: 'Highest bid 6/30',
                        lastBid: '0.244wETH',
                        reacted: '205'
                    }
                ],
            }
        },
        created() {
            // init the liked program list
            this.getLikedPrograms();
        },
        methods:{

        }
    }
</script>

<style>

.carousel-navigation button{
    background: red;
}

</style>
