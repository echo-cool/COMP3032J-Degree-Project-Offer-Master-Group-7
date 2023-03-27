<template>
    <div class="rn-product-area rn-section-gapTop masonary-wrapper-activation">
        <div class="container">
            <div class="row align-items-center mb--30">
                <div class="col-lg-4">
                    <div class="section-title">
                        <h3 class="title mb--0">Explore Product</h3>
                    </div>
                </div>
                <div class="col-lg-8">
                    <div class="button-group isotop-filter filters-button-group d-flex justify-content-start justify-content-lg-end mt_md--30 mt_sm--30">
                        <button data-filter="*" class="is-checked">All</button>
                        <button data-filter=".cat--1">Art</button>
                        <button data-filter=".cat--2">Music</button>
                        <button data-filter=".cat--3">Vedio</button>
                        <button data-filter=".cat--4">Collectionable</button>
                        <button data-filter=".cat--5">Highest</button>
                        <button data-filter=".cat--6">Lowest</button>
                    </div>
                </div>
            </div>
            <div class="col-lg-12">
                <div class="grid-metro5 mesonry-list">
                    <div class="resizer"></div>

                    <div :class="`grid-metro-item ${product.category}`"
                         v-for="(product, index) in exploreProductList"
                         :key="`explore-item-${index}`">
                        <product-card
                            :product-date="product"
                            :product-style-class="placeBid ? 'no-overlay with-placeBid' : ''"
                            :show-place-bid="placeBid"
                            @handleImageLoad="handleImageLoad"
                        />
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import ProductCard from '@/components/product/ProductCard'
    import isotope from 'isotope-layout'

    export default {
        name: 'ExploreIsotop',
        components: {ProductCard},
        props: {
            placeBid: {
                type: Boolean,
                default: false
            }
        },
        data() {
            return {
                exploreProductList: [
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
                        biddingAmount: '9',
                        productName: 'Preatent',
                        latestBid: 'Highest bid 1/20',
                        lastBid: '0.244wETH',
                        reacted: '322',
                        category: 'cat--1 cat--3'
                    },
                    {
                        id: 2,
                        productImage: require(`@/assets/images/portfolio/portfolio-02.jpg`),
                        authors: [
                            {
                                id: 4,
                                name: 'mr. Davei',
                                image: require(`@/assets/images/client/client-4.png`)
                            },
                            {
                                id: 5,
                                name: 'Mrs.Laumi',
                                image: require(`@/assets/images/client/client-5.png`)
                            },
                            {
                                id: 6,
                                name: 'Shanon',
                                image: require(`@/assets/images/client/client-6.png`)
                            }
                        ],
                        biddingAmount: '11',
                        productName: 'Diamond Dog',
                        latestBid: 'Highest bid 5/11',
                        lastBid: '0.892wETH',
                        reacted: '420',
                        category: 'cat-3 cat--4'
                    },
                    {
                        id: 3,
                        productImage: require(`@/assets/images/portfolio/portfolio-03.jpg`),
                        authors: [
                            {
                                id: 7,
                                name: 'mr. Jone',
                                image: require(`@/assets/images/client/client-7.png`)
                            },
                            {
                                id: 8,
                                name: 'Laumi',
                                image: require(`@/assets/images/client/client-8.png`)
                            },
                            {
                                id: 9,
                                name: 'Tom',
                                image: require(`@/assets/images/client/client-9.png`)
                            }
                        ],
                        biddingAmount: '12',
                        productName: 'OrBid6',
                        latestBid: 'Highest bid 2/31',
                        lastBid: '0.2128wETH',
                        reacted: '12',
                        category: 'cat--5 cat--6'
                    },
                    {
                        id: 4,
                        productImage: require(`@/assets/images/portfolio/portfolio-04.jpg`),
                        countdown: {
                            date: '2023-11-09'
                        },
                        authors: [
                            {
                                id: 9,
                                name: 'mr. Davei',
                                image: require(`@/assets/images/client/client-9.png`)
                            },
                            {
                                id: 10,
                                name: 'Mrs.Laumi',
                                image: require(`@/assets/images/client/client-10.png`)
                            },
                            {
                                id: 11,
                                name: 'Shanon',
                                image: require(`@/assets/images/client/client-11.png`)
                            }
                        ],
                        biddingAmount: '13',
                        productName: 'Morgan11',
                        latestBid: 'Highest bid 3/16',
                        lastBid: '0.265wETH',
                        reacted: '20',
                        category: 'cat--1 cat--2'
                    },
                    {
                        id: 5,
                        productImage: require(`@/assets/images/portfolio/portfolio-05.jpg`),
                        authors: [
                            {
                                id: 8,
                                name: 'mr. Davei',
                                image: require(`@/assets/images/client/client-8.png`)
                            },
                            {
                                id: 7,
                                name: 'Mrs.Laumi',
                                image: require(`@/assets/images/client/client-7.png`)
                            },
                            {
                                id: 3,
                                name: 'Shanon',
                                image: require(`@/assets/images/client/client-3.png`)
                            }
                        ],
                        biddingAmount: '15',
                        productName: 'mAtal8',
                        latestBid: 'Highest bid 6/50',
                        lastBid: '0.244wETH',
                        reacted: '205',
                        category: 'cat--1 cat--2'
                    },
                    {
                        id: 6,
                        productImage: require(`@/assets/images/portfolio/portfolio-06.jpg`),
                        authors: [
                            {
                                id: 8,
                                name: 'Moris',
                                image: require(`@/assets/images/client/client-8.png`)
                            },
                            {
                                id: 1,
                                name: 'Jsufia',
                                image: require(`@/assets/images/client/client-1.png`)
                            },
                            {
                                id: 2,
                                name: 'Mordan',
                                image: require(`@/assets/images/client/client-2.png`)
                            }
                        ],
                        biddingAmount: '9',
                        productName: 'Platonum',
                        latestBid: 'Highest bid 1/10',
                        lastBid: '0.450wETH',
                        reacted: '65',
                        category: 'cat--1 cat--2'
                    },
                    {
                        id: 7,
                        productImage: require(`@/assets/images/portfolio/portfolio-07.jpg`),
                        countdown: {
                            date: '2023-11-09'
                        },
                        authors: [
                            {
                                id: 6,
                                name: 'Thinm',
                                image: require(`@/assets/images/client/client-6.png`)
                            },
                            {
                                id: 10,
                                name: 'Jubin',
                                image: require(`@/assets/images/client/client-10.png`)
                            },
                            {
                                id: 1,
                                name: 'Nautial',
                                image: require(`@/assets/images/client/client-1.png`)
                            }
                        ],
                        biddingAmount: '14',
                        productName: 'PlatOrgan',
                        latestBid: 'Highest bid 2/22',
                        lastBid: '0.311wETH',
                        reacted: '56',
                        category: 'cat--5 cat--4'
                    },
                    {
                        id: 10,
                        productImage: require(`@/assets/images/portfolio/portfolio-10.jpg`),
                        authors: [
                            {
                                id: 6,
                                name: 'Tabriz',
                                image: require(`@/assets/images/client/client-6.png`)
                            },
                            {
                                id: 8,
                                name: 'Juskin',
                                image: require(`@/assets/images/client/client-8.png`)
                            },
                            {
                                id: 9,
                                name: 'Money',
                                image: require(`@/assets/images/client/client-9.png`)
                            }
                        ],
                        biddingAmount: '14',
                        productName: 'Orgajis',
                        latestBid: 'Highest bid 2/10',
                        lastBid: '0.311wETH',
                        reacted: '89',
                        category: 'cat--5 cat--6'
                    },
                    {
                        id: 9,
                        productImage: require(`@/assets/images/portfolio/portfolio-09.jpg`),
                        authors: [
                            {
                                id: 6,
                                name: 'Morokko',
                                image: require(`@/assets/images/client/client-6.png`)
                            },
                            {
                                id: 1,
                                name: 'Levnon',
                                image: require(`@/assets/images/client/client-1.png`)
                            },
                            {
                                id: 10,
                                name: 'Trim sawdi',
                                image: require(`@/assets/images/client/client-10.png`)
                            }
                        ],
                        biddingAmount: '12',
                        productName: '#720',
                        latestBid: 'Highest bid 1/1',
                        lastBid: '0.244wETH',
                        reacted: '502',
                        category: 'cat--1 cat--3'
                    },
                    {
                        id: 11,
                        productImage: require(`@/assets/images/portfolio/portfolio-11.jpg`),
                        authors: [
                            {
                                id: 1,
                                name: 'Morokko',
                                image: require(`@/assets/images/client/client-1.png`)
                            },
                            {
                                id: 8,
                                name: 'Levnon',
                                image: require(`@/assets/images/client/client-8.png`)
                            },
                            {
                                id: 7,
                                name: 'Trim sawdi',
                                image: require(`@/assets/images/client/client-7.png`)
                            }
                        ],
                        biddingAmount: '5',
                        productName: 'Orthogon#720',
                        latestBid: 'Highest bid 1/1',
                        lastBid: '0.244wETH',
                        reacted: '308',
                        category: 'cat-3 cat--4'
                    }
                ],
                imgLoaded: 0
            }
        },
        methods: {
            handleImageLoad() {
                const imagesLength = document.querySelectorAll('.grid-metro-item').length

                this.imgLoaded++;
                if(this.imgLoaded === imagesLength) {
                    // Init Isotope
                    let iso = new isotope('.mesonry-list', {
                        transitionDuration: '0.7s',
                        layoutMode: 'masonry',
                        masonry: {
                            columnWidth: '.resizer',
                        }
                    });

                    // Filter function
                    let filterFns = {};

                    // Bind filter button click
                    let filtersElem = document.querySelector('.isotop-filter');
                    filtersElem.addEventListener('click', function(event) {
                        if (!event.target.closest('button')) {
                            return;
                        }
                        let filterValue = event.target.getAttribute('data-filter');
                        filterValue = filterFns[ filterValue ] || filterValue;
                        iso.arrange({filter: filterValue});
                    });

                    // Change is-checked class on buttons
                    let buttonGroups = document.querySelectorAll('.isotop-filter');
                    for (let i=0, len = buttonGroups.length; i < len; i++ ) {
                        let buttonGroup = buttonGroups[i];
                        radioButtonGroup(buttonGroup);
                    }

                    function radioButtonGroup(buttonGroup) {
                        buttonGroup.addEventListener('click', function(event) {
                            if (!event.target.closest('button')) {
                                return;
                            }
                            buttonGroup.querySelector('.is-checked').classList.remove('is-checked');
                            event.target.classList.add('is-checked');
                        });
                    }
                }
            }
        }
    }
</script>
