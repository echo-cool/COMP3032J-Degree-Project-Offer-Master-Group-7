<template>
    <layout>
        <breadcrumb title="Our Top NFTs" current="Ranking"/>

        <div class="rn-upcoming-area rn-section-gap">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="table-title-area d-flex">
                            <i class="feather-briefcase"/>
                            <h3>The top NFTs on Nuron</h3>
                        </div>
                        <div class="box-table table-responsive">
                            <table class="table upcoming-projects">
                                <thead>
                                <tr>
                                    <template v-for="(th, thIndex) in Object.keys(rankingList[0])"
                                              :key="`th-${thIndex}`">
                                        <th>
                                            <span class="text-capitalize">
                                                {{ th === 'one_day_average' ? '24h%' : th.toLowerCase().replace('_', ' ') && th === 'seven_days_average' ? '7d%' : th.toLowerCase().replace('_', ' ') }}
                                            </span>
                                        </th>
                                    </template>
                                </tr>
                                </thead>
                                <tbody class="ranking">
                                <tr :class="{'color-light': rowIndex%2 === 0}"
                                    v-for="(row, rowIndex) in filteredRows.slice(pageStart, pageStart + countOfPage)"
                                    :key="`upcoming-project-${rowIndex}`">
                                    <td><span>{{ row.id }}.</span></td>
                                    <td>
                                        <div class="product-wrapper d-flex align-items-center">
                                            <router-link to="/product/1" class="thumbnail">
                                                <img :src="row.product.image.src" alt="Nft_Profile">
                                            </router-link>
                                            <span>{{ row.product.title }}</span>
                                        </div>
                                    </td>
                                    <td><span>{{ row.volume }}</span></td>
                                    <td>
                                        <span :class="row.one_day_average.status === '+' ? 'color-green' : 'color-red'">
                                            {{ row.one_day_average.status }}{{ row.one_day_average.charge }}
                                        </span>
                                    </td>
                                    <td>
                                        <span :class="row.seven_days_average.status === '+' ? 'color-green' : 'color-red'">
                                            {{ row.seven_days_average.status }}{{ row.seven_days_average.charge }}
                                        </span>
                                    </td>
                                    <td><span>{{ row.floor_price }}</span></td>
                                    <td><span>{{ row.owners }}</span></td>
                                    <td><span>{{ row.items }}</span></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>

                        <nav class="pagination-wrapper" aria-label="Page navigation example">
                            <ul :class="`pagination`">
                                <li class="page-item"
                                    :class="{'disabled': (currPage === 1)}"
                                    @click.prevent="setPage(currPage-1)">
                                    <a class="page-link" href="">
                                        Previous
                                    </a>
                                </li>
                                <li class="page-item"
                                    v-for="n in totalPage"
                                    @click.prevent="setPage(n)">
                                    <a :class="[`page-link`, {'active': (currPage === (n))}]" href="">
                                        {{n}}
                                    </a>
                                </li>
                                <li class="page-item"
                                    :class="{'disabled': (currPage === totalPage)}"
                                    @click.prevent="setPage(currPage + 1)">
                                    <a class="page-link" href="">
                                        Next
                                    </a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </layout>
</template>

<script>
    import Layout from '@/components/layouts/Layout'
    import Breadcrumb from '@/components/breadcrumb/Breadcrumb'
    import SalScrollAnimationMixin from '@/mixins/SalScrollAnimationMixin'

    export default {
        name: 'Ranking',
        components: {Breadcrumb, Layout},
        mixins: [SalScrollAnimationMixin],
        data() {
            return {
                rankingList: [
                    {
                        id: 1,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-05.jpg`)
                            }
                        },
                        volume: '7,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '-'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '+'
                        },
                        floor_price: '33.02',
                        owners: '3k',
                        items: '10k'
                    },
                    {
                        id: 2,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-06.jpg`)
                            }
                        },
                        volume: '20,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '-'
                        },
                        floor_price: '33.02',
                        owners: '2.5k',
                        items: '30k'
                    },
                    {
                        id: 3,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-07.jpg`)
                            }
                        },
                        volume: '11,50,000',
                        one_day_average: {
                            charge: '560.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '+'
                        },
                        floor_price: '33.02',
                        owners: '3.6k',
                        items: '230k'
                    },
                    {
                        id: 4,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-08.jpg`)
                            }
                        },
                        volume: '10,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '22.21%',
                            status: '-'
                        },
                        floor_price: '33.02',
                        owners: '3.2k',
                        items: '100k'
                    },
                    {
                        id: 5,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-01.jpg`)
                            }
                        },
                        volume: '9,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '-'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '+'
                        },
                        floor_price: '300.02',
                        owners: '33k',
                        items: '50k'
                    },
                    {
                        id: 6,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-02.jpg`)
                            }
                        },
                        volume: '20,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '-'
                        },
                        floor_price: '33.02',
                        owners: '2.5k',
                        items: '30k'
                    },
                    {
                        id: 7,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-03.jpg`)
                            }
                        },
                        volume: '11,50,000',
                        one_day_average: {
                            charge: '560.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '+'
                        },
                        floor_price: '33.02',
                        owners: '3.6k',
                        items: '230k'
                    },
                    {
                        id: 8,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-04.jpg`)
                            }
                        },
                        volume: '10,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '22.21%',
                            status: '-'
                        },
                        floor_price: '33.02',
                        owners: '3.2k',
                        items: '100k'
                    },
                    {
                        id: 9,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-05.jpg`)
                            }
                        },
                        volume: '9,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '-'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '+'
                        },
                        floor_price: '300.02',
                        owners: '33k',
                        items: '50k'
                    },
                    {
                        id: 10,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-06.jpg`)
                            }
                        },
                        volume: '20,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '-'
                        },
                        floor_price: '33.02',
                        owners: '2.5k',
                        items: '30k'
                    },
                    {
                        id: 11,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-07.jpg`)
                            }
                        },
                        volume: '11,50,000',
                        one_day_average: {
                            charge: '560.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '+'
                        },
                        floor_price: '33.02',
                        owners: '3.6k',
                        items: '230k'
                    },
                    {
                        id: 12,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-08.jpg`)
                            }
                        },
                        volume: '10,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '22.21%',
                            status: '-'
                        },
                        floor_price: '33.02',
                        owners: '3.2k',
                        items: '100k'
                    },
                    {
                        id: 13,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-01.jpg`)
                            }
                        },
                        volume: '9,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '-'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '+'
                        },
                        floor_price: '300.02',
                        owners: '33k',
                        items: '50k'
                    },
                    {
                        id: 14,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-02.jpg`)
                            }
                        },
                        volume: '20,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '-'
                        },
                        floor_price: '33.02',
                        owners: '2.5k',
                        items: '30k'
                    },
                    {
                        id: 15,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-03.jpg`)
                            }
                        },
                        volume: '11,50,000',
                        one_day_average: {
                            charge: '560.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '+'
                        },
                        floor_price: '33.02',
                        owners: '3.6k',
                        items: '230k'
                    },
                    {
                        id: 16,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-04.jpg`)
                            }
                        },
                        volume: '10,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '22.21%',
                            status: '-'
                        },
                        floor_price: '33.02',
                        owners: '3.2k',
                        items: '100k'
                    },
                    {
                        id: 17,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-05.jpg`)
                            }
                        },
                        volume: '9,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '-'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '+'
                        },
                        floor_price: '300.02',
                        owners: '33k',
                        items: '50k'
                    },
                    {
                        id: 18,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-08.jpg`)
                            }
                        },
                        volume: '10,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '22.21%',
                            status: '-'
                        },
                        floor_price: '33.02',
                        owners: '3.2k',
                        items: '100k'
                    },
                    {
                        id: 19,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-01.jpg`)
                            }
                        },
                        volume: '9,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '-'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '+'
                        },
                        floor_price: '300.02',
                        owners: '33k',
                        items: '50k'
                    },
                    {
                        id: 20,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-02.jpg`)
                            }
                        },
                        volume: '20,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '-'
                        },
                        floor_price: '33.02',
                        owners: '2.5k',
                        items: '30k'
                    },
                    {
                        id: 21,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-03.jpg`)
                            }
                        },
                        volume: '11,50,000',
                        one_day_average: {
                            charge: '560.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '+'
                        },
                        floor_price: '33.02',
                        owners: '3.6k',
                        items: '230k'
                    },
                    {
                        id: 22,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-04.jpg`)
                            }
                        },
                        volume: '10,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '22.21%',
                            status: '-'
                        },
                        floor_price: '33.02',
                        owners: '3.2k',
                        items: '100k'
                    },
                    {
                        id: 23,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-05.jpg`)
                            }
                        },
                        volume: '9,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '-'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '+'
                        },
                        floor_price: '300.02',
                        owners: '33k',
                        items: '50k'
                    },
                    {
                        id: 24,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-06.jpg`)
                            }
                        },
                        volume: '20,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '-'
                        },
                        floor_price: '33.02',
                        owners: '2.5k',
                        items: '30k'
                    },
                    {
                        id: 25,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-07.jpg`)
                            }
                        },
                        volume: '11,50,000',
                        one_day_average: {
                            charge: '560.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '+'
                        },
                        floor_price: '33.02',
                        owners: '3.6k',
                        items: '230k'
                    },
                    {
                        id: 26,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-08.jpg`)
                            }
                        },
                        volume: '10,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '22.21%',
                            status: '-'
                        },
                        floor_price: '33.02',
                        owners: '3.2k',
                        items: '100k'
                    },
                    {
                        id: 27,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-01.jpg`)
                            }
                        },
                        volume: '9,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '-'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '+'
                        },
                        floor_price: '300.02',
                        owners: '33k',
                        items: '50k'
                    },
                    {
                        id: 28,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-02.jpg`)
                            }
                        },
                        volume: '20,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '-'
                        },
                        floor_price: '33.02',
                        owners: '2.5k',
                        items: '30k'
                    },
                    {
                        id: 29,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-03.jpg`)
                            }
                        },
                        volume: '11,50,000',
                        one_day_average: {
                            charge: '560.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '+'
                        },
                        floor_price: '33.02',
                        owners: '3.6k',
                        items: '230k'
                    },
                    {
                        id: 30,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-04.jpg`)
                            }
                        },
                        volume: '10,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '22.21%',
                            status: '-'
                        },
                        floor_price: '33.02',
                        owners: '3.2k',
                        items: '100k'
                    },
                    {
                        id: 31,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-05.jpg`)
                            }
                        },
                        volume: '9,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '-'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '+'
                        },
                        floor_price: '300.02',
                        owners: '33k',
                        items: '50k'
                    },
                    {
                        id: 32,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-04.jpg`)
                            }
                        },
                        volume: '10,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '22.21%',
                            status: '-'
                        },
                        floor_price: '33.02',
                        owners: '3.2k',
                        items: '100k'
                    },
                    {
                        id: 33,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-05.jpg`)
                            }
                        },
                        volume: '9,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '-'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '+'
                        },
                        floor_price: '300.02',
                        owners: '33k',
                        items: '50k'
                    },
                    {
                        id: 34,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-06.jpg`)
                            }
                        },
                        volume: '20,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '-'
                        },
                        floor_price: '33.02',
                        owners: '2.5k',
                        items: '30k'
                    },
                    {
                        id: 35,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-07.jpg`)
                            }
                        },
                        volume: '11,50,000',
                        one_day_average: {
                            charge: '560.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '+'
                        },
                        floor_price: '33.02',
                        owners: '3.6k',
                        items: '230k'
                    },
                    {
                        id: 36,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-08.jpg`)
                            }
                        },
                        volume: '10,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '22.21%',
                            status: '-'
                        },
                        floor_price: '33.02',
                        owners: '3.2k',
                        items: '100k'
                    },
                    {
                        id: 37,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-01.jpg`)
                            }
                        },
                        volume: '9,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '-'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '+'
                        },
                        floor_price: '300.02',
                        owners: '33k',
                        items: '50k'
                    },
                    {
                        id: 38,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-02.jpg`)
                            }
                        },
                        volume: '20,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '-'
                        },
                        floor_price: '33.02',
                        owners: '2.5k',
                        items: '30k'
                    },
                    {
                        id: 39,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-03.jpg`)
                            }
                        },
                        volume: '11,50,000',
                        one_day_average: {
                            charge: '560.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '+'
                        },
                        floor_price: '33.02',
                        owners: '3.6k',
                        items: '230k'
                    },
                    {
                        id: 40,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-04.jpg`)
                            }
                        },
                        volume: '10,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '22.21%',
                            status: '-'
                        },
                        floor_price: '33.02',
                        owners: '3.2k',
                        items: '100k'
                    },
                    {
                        id: 41,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-05.jpg`)
                            }
                        },
                        volume: '9,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '-'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '+'
                        },
                        floor_price: '300.02',
                        owners: '33k',
                        items: '50k'
                    },
                    {
                        id: 42,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-08.jpg`)
                            }
                        },
                        volume: '10,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '22.21%',
                            status: '-'
                        },
                        floor_price: '33.02',
                        owners: '3.2k',
                        items: '100k'
                    },
                    {
                        id: 43,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-01.jpg`)
                            }
                        },
                        volume: '9,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '-'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '+'
                        },
                        floor_price: '300.02',
                        owners: '33k',
                        items: '50k'
                    },
                    {
                        id: 44,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-02.jpg`)
                            }
                        },
                        volume: '20,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '-'
                        },
                        floor_price: '33.02',
                        owners: '2.5k',
                        items: '30k'
                    },
                    {
                        id: 45,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-03.jpg`)
                            }
                        },
                        volume: '11,50,000',
                        one_day_average: {
                            charge: '560.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '+'
                        },
                        floor_price: '33.02',
                        owners: '3.6k',
                        items: '230k'
                    },
                    {
                        id: 46,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-04.jpg`)
                            }
                        },
                        volume: '10,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '22.21%',
                            status: '-'
                        },
                        floor_price: '33.02',
                        owners: '3.2k',
                        items: '100k'
                    },
                    {
                        id: 47,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-05.jpg`)
                            }
                        },
                        volume: '9,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '-'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '+'
                        },
                        floor_price: '300.02',
                        owners: '33k',
                        items: '50k'
                    },
                    {
                        id: 48,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-06.jpg`)
                            }
                        },
                        volume: '20,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '-'
                        },
                        floor_price: '33.02',
                        owners: '2.5k',
                        items: '30k'
                    },
                    {
                        id: 49,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-07.jpg`)
                            }
                        },
                        volume: '11,50,000',
                        one_day_average: {
                            charge: '560.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '+'
                        },
                        floor_price: '33.02',
                        owners: '3.6k',
                        items: '230k'
                    },
                    {
                        id: 50,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-08.jpg`)
                            }
                        },
                        volume: '10,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '22.21%',
                            status: '-'
                        },
                        floor_price: '33.02',
                        owners: '3.2k',
                        items: '100k'
                    },
                    {
                        id: 51,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-01.jpg`)
                            }
                        },
                        volume: '9,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '-'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '+'
                        },
                        floor_price: '300.02',
                        owners: '33k',
                        items: '50k'
                    },
                    {
                        id: 52,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-02.jpg`)
                            }
                        },
                        volume: '20,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '-'
                        },
                        floor_price: '33.02',
                        owners: '2.5k',
                        items: '30k'
                    },
                    {
                        id: 53,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-03.jpg`)
                            }
                        },
                        volume: '11,50,000',
                        one_day_average: {
                            charge: '560.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '+'
                        },
                        floor_price: '33.02',
                        owners: '3.6k',
                        items: '230k'
                    },
                    {
                        id: 54,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-04.jpg`)
                            }
                        },
                        volume: '10,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '+'
                        },
                        seven_days_average: {
                            charge: '22.21%',
                            status: '-'
                        },
                        floor_price: '33.02',
                        owners: '3.2k',
                        items: '100k'
                    },
                    {
                        id: 55,
                        product: {
                            title: 'Secure 25',
                            slug: '/collection',
                            image: {
                                src: require(`@/assets/images/portfolio/portfolio-05.jpg`)
                            }
                        },
                        volume: '9,50,000',
                        one_day_average: {
                            charge: '310.63%',
                            status: '-'
                        },
                        seven_days_average: {
                            charge: '62.21%',
                            status: '+'
                        },
                        floor_price: '300.02',
                        owners: '33k',
                        items: '50k'
                    }
                ],
                currPage: 1,
                countOfPage: 20
            }
        },
        computed: {
            filteredRows() {
                return this.rankingList;
            },
            pageStart() {
                return (this.currPage - 1) * this.countOfPage;
            },
            totalPage() {
                return Math.ceil(this.filteredRows.length / this.countOfPage);
            }
        },
        methods: {
            setPage(idx) {
                if(idx <= 0 || idx > this.totalPage) {
                    return;
                }
                this.currPage = idx;
                window.scrollTo(0, 0);
            },
        }
    }
</script>