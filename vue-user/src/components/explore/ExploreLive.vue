<template>
    <div class="rn-new-items rn-section-gapTop">
        <div class="container">
            <div v-if="showTitle" class="section-title mb--30">
                <h3 class="title mb--0 live-bidding-title" data-sal-delay="150" data-sal="slide-up" data-sal-duration="800">
                    Live Bidding
                </h3>
            </div>
            <div class="row g-5">
                <template v-for="(item, index) in liveBiddingItems"
                          :key="`newest-item-${index}`">
                    <div v-if="index < productLimit"
                         :class="productColumn"
                         data-sal="slide-up"
                         :data-sal-delay="150+index"
                         data-sal-duration="800">
                        <product-card
                            :product-date="item"
                            :show-place-bid="showPlaceBid"
                            :product-style-class="showPlaceBid ? 'no-overlay with-placeBid' : ''"
                        />
                    </div>
                </template>
            </div>
        </div>
    </div>
</template>

<script>
    import ProductCard from '@/components/product/ProductCard'

    export default {
        name: 'ExploreLive',
        components: {ProductCard},
        props: {
            showTitle: {
                type: Boolean,
                default: true
            },
            productLimit: {
                type: Number,
                default: 5
            },
            productColumn: {
                type: String,
                default: 'col-5 col-lg-4 col-md-6 col-sm-6 col-12'
            },
            showPlaceBid: {
                type: Boolean,
                default: false
            }
        },
        data() {
            return {
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
                    }
                ]
            }
        }
    }
</script>
