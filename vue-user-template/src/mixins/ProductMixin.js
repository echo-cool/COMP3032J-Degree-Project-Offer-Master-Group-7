export default {
    data() {
        return {
            products: [
                {
                    id: 1,
                    productImage: require(`@/assets/images/portfolio/lg/portfolio-01.jpg`),
                    thumbnailImages: [
                        {src: require(`@/assets/images/portfolio/lg/portfolio-01.jpg`)},
                        {src: require(`@/assets/images/portfolio/lg/portfolio-02.jpg`)},
                        {src: require(`@/assets/images/portfolio/lg/portfolio-03.jpg`)}
                    ],
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
                    biddingAmount: '9',
                    productName: 'Preatent',
                    latestBid: 'Highest bid 1/20',
                    lastBid: '0.244wETH',
                    reacted: '322',
                    categories: ['music', 'video'],
                    collection: {
                        name: 'Art Decco',
                        slug: '/collection',
                        image: {
                            src: require(`@/assets/images/client/client-2.png`)
                        },
                        totalSale: '2500,000'
                    },
                    saleType: 'fixed-price',
                    price: {
                        amount: 0.244,
                        currency: 'wETH'
                    },
                    sortBy: ['newest'],
                    publishedAt: '20-JUN-2021 08:03:00',
                    level: 'Intermediate',
                    language: 'English',
                    rating: 5
                },
                {
                    id: 2,
                    productImage: require(`@/assets/images/portfolio/lg/portfolio-02.jpg`),
                    thumbnailImages: [
                        {src: require(`@/assets/images/portfolio/lg/portfolio-02.jpg`)},
                        {src: require(`@/assets/images/portfolio/lg/portfolio-09.jpg`)},
                        {src: require(`@/assets/images/portfolio/lg/portfolio-03.jpg`)}
                    ],
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
                    lastBid: '0.244wETH',
                    reacted: '420',
                    categories: ['art', 'video'],
                    collection: {
                        name: 'Art Decco',
                        slug: '/collection',
                        image: {
                            src: require(`@/assets/images/client/client-2.png`)
                        },
                        totalSale: '2500,000'
                    },
                    saleType: 'timed-auction',
                    price: {
                        amount: 0.244,
                        currency: 'wETH'
                    },
                    sortBy: ['oldest'],
                    publishedAt: '21-JUN-2021 08:03:00',
                    level: 'Beginner',
                    language: 'Arabic',
                    rating: 4
                },
                {
                    id: 3,
                    productImage: require(`@/assets/images/portfolio/lg/portfolio-03.jpg`),
                    thumbnailImages: [
                        {src: require(`@/assets/images/portfolio/lg/portfolio-03.jpg`)},
                        {src: require(`@/assets/images/portfolio/lg/portfolio-05.jpg`)},
                        {src: require(`@/assets/images/portfolio/lg/portfolio-06.jpg`)}
                    ],
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
                    lastBid: '0.218wETH',
                    reacted: '12',
                    categories: ['music'],
                    collection: {
                        name: 'BoredApeYachtClub',
                        slug: '/collection',
                        image: {
                            src: require(`@/assets/images/client/client-2.png`)
                        },
                        totalSale: '2500,000'
                    },
                    saleType: 'fixed-price',
                    price: {
                        amount: 0.218,
                        currency: 'wETH'
                    },
                    sortBy: ['popular-courses'],
                    publishedAt: '25-JAN-2022 10:55:00',
                    level: 'High',
                    language: 'English',
                    rating: 5
                },
                {
                    id: 4,
                    productImage: require(`@/assets/images/portfolio/lg/portfolio-04.jpg`),
                    thumbnailImages: [
                        {src: require(`@/assets/images/portfolio/lg/portfolio-04.jpg`)},
                        {src: require(`@/assets/images/portfolio/lg/portfolio-08.jpg`)},
                        {src: require(`@/assets/images/portfolio/lg/portfolio-09.jpg`)}
                    ],
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
                    reacted: '20',
                    categories: ['video'],
                    collection: {
                        name: 'MutantApeYachtClub',
                        slug: '/collection',
                        image: {
                            src: require(`@/assets/images/client/client-2.png`)
                        },
                        totalSale: '2500,000'
                    },
                    saleType: 'not-for-sale',
                    price: {
                        amount: 0.265,
                        currency: 'wETH'
                    },
                    sortBy: ['oldest'],
                    publishedAt: '23-JUN-2021 08:03:00',
                    level: 'Intermediate',
                    language: 'Arabic',
                    rating: 4
                },
                {
                    id: 5,
                    productImage: require(`@/assets/images/portfolio/lg/portfolio-05.jpg`),
                    thumbnailImages: [
                        {src: require(`@/assets/images/portfolio/lg/portfolio-05.jpg`)},
                        {src: require(`@/assets/images/portfolio/lg/portfolio-10.jpg`)},
                        {src: require(`@/assets/images/portfolio/lg/portfolio-03.jpg`)}
                    ],
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
                    lastBid: '0.285wETH',
                    reacted: '205',
                    categories: ['collectionable', 'art'],
                    collection: {
                        name: 'Art Decco',
                        slug: '/collection',
                        image: {
                            src: require(`@/assets/images/client/client-2.png`)
                        },
                        totalSale: '2500,000'
                    },
                    saleType: 'timed-auction',
                    price: {
                        amount: 0.285,
                        currency: 'wETH'
                    },
                    sortBy: ['popular-courses'],
                    publishedAt: '24-JUN-2021 08:03:00',
                    level: 'Intermediate',
                    language: 'English',
                    rating: 5
                },
                {
                    id: 6,
                    productImage: require(`@/assets/images/portfolio/lg/portfolio-06.jpg`),
                    thumbnailImages: [
                        {src: require(`@/assets/images/portfolio/lg/portfolio-06.jpg`)},
                        {src: require(`@/assets/images/portfolio/lg/portfolio-02.jpg`)},
                        {src: require(`@/assets/images/portfolio/lg/portfolio-03.jpg`)}
                    ],
                    authors: [
                        {
                            id: 10,
                            name: 'Jone lee',
                            image: require(`@/assets/images/client/client-10.png`)
                        },
                        {
                            id: 11,
                            name: 'Jone lee',
                            image: require(`@/assets/images/client/client-11.png`)
                        },
                        {
                            id: 12,
                            name: 'Jone lee',
                            image: require(`@/assets/images/client/client-12.png`)
                        }
                    ],
                    biddingAmount: '15',
                    productName: 'Platonum',
                    latestBid: 'Highest bid 6/50',
                    lastBid: '0.334wETH',
                    reacted: '205',
                    categories: ['music'],
                    collection: {
                        name: 'MutantApeYachtClub',
                        slug: '/collection',
                        image: {
                            src: require(`@/assets/images/client/client-2.png`)
                        },
                        totalSale: '2500,000'
                    },
                    saleType: 'not-for-sale',
                    price: {
                        amount: 0.334,
                        currency: 'wETH'
                    },
                    sortBy: ['newest'],
                    publishedAt: '24-JUN-2021 08:05:00',
                    level: 'Beginner',
                    language: 'Russian',
                    rating: 3
                },
                {
                    id: 7,
                    productImage: require(`@/assets/images/portfolio/lg/portfolio-07.jpg`),
                    thumbnailImages: [
                        {src: require(`@/assets/images/portfolio/portfolio-07.jpg`)},
                        {src: require(`@/assets/images/portfolio/lg/portfolio-05.jpg`)},
                        {src: require(`@/assets/images/portfolio/lg/portfolio-03.jpg`)}
                    ],
                    authors: [
                        {
                            id: 2,
                            name: 'Jone lee',
                            image: require(`@/assets/images/client/client-2.png`)
                        },
                        {
                            id: 12,
                            name: 'Jone lee',
                            image: require(`@/assets/images/client/client-12.png`)
                        },
                        {
                            id: 11,
                            name: 'Jone lee',
                            image: require(`@/assets/images/client/client-11.png`)
                        }
                    ],
                    biddingAmount: '15',
                    productName: 'PlatOrgan',
                    latestBid: 'Highest bid 6/50',
                    lastBid: '0.453wETH',
                    reacted: '205',
                    categories: ['art'],
                    collection: {
                        name: 'Art Decco',
                        slug: '/collection',
                        image: {
                            src: require(`@/assets/images/client/client-2.png`)
                        },
                        totalSale: '2500,000'
                    },
                    saleType: 'not-for-sale',
                    price: {
                        amount: 0.453,
                        currency: 'wETH'
                    },
                    sortBy: ['newest'],
                    publishedAt: '24-JAN-2022 09:05:00',
                    level: 'Intermediate',
                    language: 'Arabic',
                    rating: 4
                },
                {
                    id: 8,
                    productImage: require(`@/assets/images/portfolio/lg/portfolio-08.jpg`),
                    thumbnailImages: [
                        {src: require(`@/assets/images/portfolio/lg/portfolio-08.jpg`)},
                        {src: require(`@/assets/images/portfolio/lg/portfolio-02.jpg`)},
                        {src: require(`@/assets/images/portfolio/lg/portfolio-03.jpg`)}
                    ],
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
                    productName: 'Orgajis',
                    latestBid: 'Highest bid 6/50',
                    lastBid: '0.892wETH',
                    reacted: '205',
                    categories: ['collectionable', 'video'],
                    collection: {
                        name: 'MutantApeYachtClub',
                        slug: '/collection',
                        image: {
                            src: require(`@/assets/images/client/client-2.png`)
                        },
                        totalSale: '2500,000'
                    },
                    saleType: 'not-for-sale',
                    price: {
                        amount: 0.892,
                        currency: 'wETH'
                    },
                    sortBy: ['oldest'],
                    publishedAt: '25-JAN-2022 09:55:00',
                    level: 'Intermediate',
                    language: 'English',
                    rating: 3
                },
                {
                    id: 9,
                    productImage: require(`@/assets/images/portfolio/lg/portfolio-09.jpg`),
                    thumbnailImages: [
                        {src: require(`@/assets/images/portfolio/lg/portfolio-09.jpg`)},
                        {src: require(`@/assets/images/portfolio/lg/portfolio-01.jpg`)},
                        {src: require(`@/assets/images/portfolio/lg/portfolio-11.jpg`)}
                    ],
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
                    productName: '#720',
                    latestBid: 'Highest bid 6/50',
                    lastBid: '0.756wETH',
                    reacted: '205',
                    categories: ['music', 'video'],
                    collection: {
                        name: 'Art Blocks Factory',
                        slug: '/collection',
                        image: {
                            src: require(`@/assets/images/client/client-2.png`)
                        },
                        totalSale: '2500,000'
                    },
                    saleType: 'open-for-offers',
                    price: {
                        amount: 0.756,
                        currency: 'wETH'
                    },
                    sortBy: ['featured-this-month'],
                    publishedAt: '25-JAN-2022 07:55:00',
                    level: 'Beginner',
                    language: 'Russian',
                    rating: 2
                },
                {
                    id: 10,
                    productImage: require(`@/assets/images/portfolio/lg/portfolio-10.jpg`),
                    thumbnailImages: [
                        {src: require(`@/assets/images/portfolio/lg/portfolio-10.jpg`)},
                        {src: require(`@/assets/images/portfolio/lg/portfolio-01.jpg`)},
                        {src: require(`@/assets/images/portfolio/lg/portfolio-03.jpg`)}
                    ],
                    authors: [
                        {
                            id: 2,
                            name: 'Jone lee',
                            image: require(`@/assets/images/client/client-2.png`)
                        },
                        {
                            id: 10,
                            name: 'Jone lee',
                            image: require(`@/assets/images/client/client-10.png`)
                        },
                        {
                            id: 1,
                            name: 'Jone lee',
                            image: require(`@/assets/images/client/client-1.png`)
                        }
                    ],
                    biddingAmount: '15',
                    productName: 'Orthogon#720',
                    latestBid: 'Highest bid 6/50',
                    lastBid: '0.566wETH',
                    reacted: '205',
                    categories: ['collectionable'],
                    collection: {
                        name: 'Art Decco',
                        slug: '/collection',
                        image: {
                            src: require(`@/assets/images/client/client-2.png`)
                        },
                        totalSale: '2500,000'
                    },
                    saleType: 'fixed-price',
                    price: {
                        amount: 0.566,
                        currency: 'wETH'
                    },
                    sortBy: ['featured-this-month'],
                    publishedAt: '24-JAN-2022 07:55:00',
                    level: 'Intermediate',
                    language: 'Russian',
                    rating: 2
                },
                {
                    id: 11,
                    productImage: require(`@/assets/images/portfolio/lg/portfolio-11.jpg`),
                    thumbnailImages: [
                        {src: require(`@/assets/images/portfolio/lg/portfolio-11.jpg`)},
                        {src: require(`@/assets/images/portfolio/lg/portfolio-02.jpg`)},
                        {src: require(`@/assets/images/portfolio/lg/portfolio-03.jpg`)}
                    ],
                    authors: [
                        {
                            id: 2,
                            name: 'Jone lee',
                            image: require(`@/assets/images/client/client-2.png`)
                        },
                        {
                            id: 9,
                            name: 'Jone lee',
                            image: require(`@/assets/images/client/client-9.png`)
                        },
                        {
                            id: 10,
                            name: 'Jone lee',
                            image: require(`@/assets/images/client/client-10.png`)
                        }
                    ],
                    biddingAmount: '15',
                    productName: '#21 The Wonder',
                    latestBid: 'Highest bid 6/50',
                    lastBid: '0.9wETH',
                    reacted: '205',
                    categories: ['art'],
                    collection: {
                        name: 'Art Blocks Factory',
                        slug: '/collection',
                        image: {
                            src: require(`@/assets/images/client/client-2.png`)
                        },
                        totalSale: '2500,000'
                    },
                    saleType: 'timed-auction',
                    price: {
                        amount: 0.9,
                        currency: 'wETH'
                    },
                    sortBy: ['oldest'],
                    publishedAt: '20-JUN-2021 08:03:00',
                    level: 'High',
                    language: 'Arabic',
                    rating: 2
                },
                {
                    id: 12,
                    productImage: require(`@/assets/images/portfolio/lg/portfolio-12.jpg`),
                    thumbnailImages: [
                        {src: require(`@/assets/images/portfolio/lg/portfolio-12.jpg`)},
                        {src: require(`@/assets/images/portfolio/lg/portfolio-04.jpg`)},
                        {src: require(`@/assets/images/portfolio/lg/portfolio-01.jpg`)}
                    ],
                    authors: [
                        {
                            id: 1,
                            name: 'Jone lee',
                            image: require(`@/assets/images/client/client-1.png`)
                        },
                        {
                            id: 5,
                            name: 'Jone lee',
                            image: require(`@/assets/images/client/client-5.png`)
                        },
                        {
                            id: 4,
                            name: 'Jone lee',
                            image: require(`@/assets/images/client/client-4.png`)
                        }
                    ],
                    biddingAmount: '15',
                    productName: 'Sun Afford',
                    latestBid: 'Highest bid 6/50',
                    lastBid: '0.544wETH',
                    reacted: '205',
                    categories: ['music', 'video'],
                    collection: {
                        name: 'BoredApeYachtClub',
                        slug: '/collection',
                        image: {
                            src: require(`@/assets/images/client/client-2.png`)
                        },
                        totalSale: '2500,000'
                    },
                    saleType: 'open-for-offers',
                    price: {
                        amount: 0.544,
                        currency: 'wETH'
                    },
                    sortBy: ['featured-this-month'],
                    publishedAt: '24-FEB-2022 07:55:00',
                    level: 'High',
                    language: 'Russian',
                    rating: 1
                },
                {
                    id: 13,
                    productImage: require(`@/assets/images/portfolio/lg/portfolio-01.jpg`),
                    thumbnailImages: [
                        {src: require(`@/assets/images/portfolio/lg/portfolio-12.jpg`)},
                        {src: require(`@/assets/images/portfolio/lg/portfolio-04.jpg`)},
                        {src: require(`@/assets/images/portfolio/lg/portfolio-01.jpg`)}
                    ],
                    authors: [
                        {
                            id: 1,
                            name: 'Jone lee',
                            image: require(`@/assets/images/client/client-1.png`)
                        },
                        {
                            id: 5,
                            name: 'Jone lee',
                            image: require(`@/assets/images/client/client-5.png`)
                        },
                        {
                            id: 4,
                            name: 'Jone lee',
                            image: require(`@/assets/images/client/client-4.png`)
                        }
                    ],
                    biddingAmount: '15',
                    productName: 'Orthogon#721',
                    latestBid: 'Highest bid 6/50',
                    lastBid: '0.544wETH',
                    reacted: '205',
                    categories: ['music', 'video'],
                    collection: {
                        name: 'BoredApeYachtClub',
                        slug: '/collection',
                        image: {
                            src: require(`@/assets/images/client/client-2.png`)
                        },
                        totalSale: '2500,000'
                    },
                    saleType: 'open-for-offers',
                    price: {
                        amount: 0.544,
                        currency: 'wETH'
                    },
                    sortBy: ['featured-this-month'],
                    publishedAt: '24-FEB-2022 07:55:00',
                    level: 'Intermediate',
                    language: 'Arabic',
                    rating: 3
                },
                {
                    id: 14,
                    productImage: require(`@/assets/images/portfolio/lg/portfolio-04.jpg`),
                    thumbnailImages: [
                        {src: require(`@/assets/images/portfolio/lg/portfolio-12.jpg`)},
                        {src: require(`@/assets/images/portfolio/lg/portfolio-04.jpg`)},
                        {src: require(`@/assets/images/portfolio/lg/portfolio-01.jpg`)}
                    ],
                    authors: [
                        {
                            id: 1,
                            name: 'Jone lee',
                            image: require(`@/assets/images/client/client-1.png`)
                        },
                        {
                            id: 5,
                            name: 'Jone lee',
                            image: require(`@/assets/images/client/client-5.png`)
                        },
                        {
                            id: 4,
                            name: 'Jone lee',
                            image: require(`@/assets/images/client/client-4.png`)
                        }
                    ],
                    biddingAmount: '15',
                    productName: 'Sun Afford',
                    latestBid: 'Highest bid 6/50',
                    lastBid: '0.544wETH',
                    reacted: '205',
                    categories: ['music', 'video'],
                    collection: {
                        name: 'BoredApeYachtClub',
                        slug: '/collection',
                        image: {
                            src: require(`@/assets/images/client/client-2.png`)
                        },
                        totalSale: '2500,000'
                    },
                    saleType: 'open-for-offers',
                    price: {
                        amount: 0.544,
                        currency: 'wETH'
                    },
                    sortBy: ['featured-this-month'],
                    publishedAt: '24-FEB-2022 07:55:00',
                    level: 'High',
                    language: 'Arabic',
                    rating: 2
                },
                {
                    id: 15,
                    productImage: require(`@/assets/images/portfolio/lg/portfolio-10.jpg`),
                    thumbnailImages: [
                        {src: require(`@/assets/images/portfolio/lg/portfolio-12.jpg`)},
                        {src: require(`@/assets/images/portfolio/lg/portfolio-04.jpg`)},
                        {src: require(`@/assets/images/portfolio/lg/portfolio-01.jpg`)}
                    ],
                    authors: [
                        {
                            id: 1,
                            name: 'Jone lee',
                            image: require(`@/assets/images/client/client-1.png`)
                        },
                        {
                            id: 5,
                            name: 'Jone lee',
                            image: require(`@/assets/images/client/client-5.png`)
                        },
                        {
                            id: 4,
                            name: 'Jone lee',
                            image: require(`@/assets/images/client/client-4.png`)
                        }
                    ],
                    biddingAmount: '15',
                    productName: 'cAtal7',
                    latestBid: 'Highest bid 6/50',
                    lastBid: '0.544wETH',
                    reacted: '205',
                    categories: ['music', 'video'],
                    collection: {
                        name: 'BoredApeYachtClub',
                        slug: '/collection',
                        image: {
                            src: require(`@/assets/images/client/client-2.png`)
                        },
                        totalSale: '2500,000'
                    },
                    saleType: 'open-for-offers',
                    price: {
                        amount: 0.544,
                        currency: 'wETH'
                    },
                    sortBy: ['featured-this-month'],
                    publishedAt: '24-FEB-2022 07:55:00',
                    level: 'Intermediate',
                    language: 'Russian',
                    rating: 5
                },
            ],
        }
    }
}
