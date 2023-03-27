<template>
    <div class="rn-new-items rn-section-gapTop">
        <div class="container">
            <div class="row mb--50 align-items-center">
                <div class="col-lg-6 col-md-6 col-sm-6 col-12">
                    <h3 class="title mb--0" data-sal-delay="150" data-sal="slide-up" data-sal-duration="800">
                        Newest Items
                    </h3>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6 col-12 mt_mobile--15">
                    <div class="view-more-btn text-start text-sm-end">
                        <router-link class="btn-transparent" to="/product" data-sal-delay="150" data-sal="slide-up" data-sal-duration="800">
                            VIEW ALL <i class="feather-arrow-right"/>
                        </router-link>
                    </div>
                </div>
            </div>
            <div class="row g-5">
                <div class="col-5 col-lg-4 col-md-6 col-sm-6 col-12"
                     v-for="(item, index) in newestItemList"
                     :key="`newest-item-${index}`"
                     data-sal="slide-up"
                     :data-sal-delay="150+index"
                     data-sal-duration="800">
                    <product-card
                        :product-date="item"
                        product-style-class="no-overlay"
                    />
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import ProductCard from '@/components/product/ProductCard'

    export default {
        name: 'ExploreNewestItem',
        components: {ProductCard},
        data() {
            return {
                newestItemList: [
                    {
                        id: 1,
                        productImage: require(`@/assets/images/portfolio/portfolio-01.jpg`),
                        authors: [
                            {
                                id: 1,
                                name: 'Jone lee',
                                image: require(`@/assets/images/client/client-1.png`)
                            },
                            {
                                id: 2,
                                name: 'Jone lee',
                                image: require(`@/assets/images/client/client-2.png`)
                            },
                            {
                                id: 3,
                                name: 'Nisat Tara',
                                image: require(`@/assets/images/client/client-3.png`)
                            }
                        ],
                        biddingAmount: '20',
                        productName: 'Preatent',
                        latestBid: 'Highest bid 1/20',
                        lastBid: '0.244wETH',
                        reacted: '322'
                    },
                    {
                        id: 2,
                        productImage: require(`@/assets/images/portfolio/portfolio-02.jpg`),
                        authors: [
                            {
                                id: 4,
                                name: 'Jone lee',
                                image: require(`@/assets/images/client/client-4.png`)
                            },
                            {
                                id: 5,
                                name: 'Nira Ara',
                                image: require(`@/assets/images/client/client-5.png`)
                            },
                            {
                                id: 6,
                                name: 'Fatima Afrafy',
                                image: require(`@/assets/images/client/client-6.png`)
                            }
                        ],
                        biddingAmount: '10',
                        productName: 'Diamond Dog',
                        latestBid: 'Highest bid 5/11',
                        lastBid: '0.892wETH',
                        reacted: '420'
                    },
                    {
                        id: 3,
                        productImage: require(`@/assets/images/portfolio/portfolio-03.jpg`),
                        authors: [
                            {
                                id: 1,
                                name: 'Jone lee',
                                image: require(`@/assets/images/client/client-1.png`)
                            },
                            {
                                id: 8,
                                name: 'Janin Ara',
                                image: require(`@/assets/images/client/client-8.png`)
                            },
                            {
                                id: 9,
                                name: 'Atif Islam',
                                image: require(`@/assets/images/client/client-9.png`)
                            }
                        ],
                        biddingAmount: '10',
                        productName: 'OrBid6',
                        latestBid: 'Highest bid 2/31',
                        lastBid: '0.2128wETH',
                        reacted: '12'
                    },
                    {
                        id: 4,
                        productImage: require(`@/assets/images/portfolio/portfolio-04.jpg`),
                        authors: [
                            {
                                id: 1,
                                name: 'Jone lee',
                                image: require(`@/assets/images/client/client-1.png`)
                            },
                            {
                                id: 3,
                                name: 'Jone lee',
                                image: require(`@/assets/images/client/client-3.png`)
                            },
                            {
                                id: 5,
                                name: 'Jone lee',
                                image: require(`@/assets/images/client/client-5.png`)
                            }
                        ],
                        biddingAmount: '8',
                        productName: 'Morgan11',
                        latestBid: 'Highest bid 3/16',
                        lastBid: '0.265wETH',
                        reacted: '20'
                    },
                    {
                        id: 5,
                        productImage: require(`@/assets/images/portfolio/portfolio-05.jpg`),
                        authors: [
                            {
                                id: 2,
                                name: 'Jone lee',
                                image: require(`@/assets/images/client/client-2.png`)
                            },
                            {
                                id: 7,
                                name: 'Jone lee',
                                image: require(`@/assets/images/client/client-7.png`)
                            },
                            {
                                id: 9,
                                name: 'Jone lee',
                                image: require(`@/assets/images/client/client-9.png`)
                            }
                        ],
                        biddingAmount: '15',
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