<template>
    <carousel class="portfolio-slider rn-carousel-with-dots"
              :items-to-show="1"
              :wrap-around="true"
              :breakpoints="breakpoints">
        <template #addons>
            <div class="carousel-header">
                <div class="section-title">
                    <h3 class="title mb--0" data-sal-delay="150" data-sal="slide-up" data-sal-duration="800">
                        {{ title }}
                    </h3>
                </div>
                <div v-if="arrow" class="carousel-navigation">
                    <navigation/>
                </div>
                <div v-if="dots" class="carousel-pagination">
                    <pagination/>
                </div>
            </div>
        </template>
        <slide v-for="(carouselItem, index) in liveBiddingItems" :key="index">
            <product-card
                :product-style-class="placeBid ? 'no-overlay with-placeBid' : ''"
                :show-place-bid="placeBid"
                :product-date="carouselItem"
            />
        </slide>
    </carousel>
</template>

<script>
    import ProductCard from '@/components/product/ProductCard'
    import {Carousel, Navigation, Pagination, Slide} from 'vue3-carousel'

    export default {
        name: 'ExploreCarousel',
        props: {
            title: {
                type: String,
                default: 'Explore Carousel With Arrow'
            },
            arrow: {
                type: Boolean,
                default: true
            },
            dots: {
                type: Boolean,
                default: false
            },
            placeBid: {
                type: Boolean,
                default: false
            }
        },
        components: {
            ProductCard,
            Carousel,
            Slide,
            Navigation,
            Pagination
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
        }
    }
</script>