<template>
    <layout>
        <breadcrumb title="Upcoming NFT Projects" current="Upcoming NFT Projects"/>

        <div class="rn-upcoming-area rn-section-gap">
            <div class="container">
                <div :class="[`row`, {'mt--80': index !== 0}]"
                     v-for="(table, index) in filteredRows.slice(pageStart, pageStart + countOfPage)"
                     :key="`upcoming-project-${index}`">
                    <div class="col-12">
                        <div class="table-title-area d-flex">
                            <i class="feather-calendar"/>
                            <h3>{{ table.date }}</h3>
                        </div>

                        <div class="box-table table-responsive">
                            <table class="table upcoming-projects">
                                <thead>
                                <tr>
                                    <template v-for="(th, thIndex) in Object.keys(table.projects[0])"
                                              :key="`th-${thIndex}`">
                                        <th v-if="thIndex !== 0">
                                            <span class="text-capitalize">{{ th }}</span>
                                        </th>
                                    </template>
                                </tr>
                                </thead>
                                <tbody>
                                <tr :class="{'color-light': rowIndex%2 === 0}"
                                    v-for="(row, rowIndex) in table.projects"
                                    :key="`row-${rowIndex}`">
                                    <td><span>{{ row.project }}</span></td>
                                    <td><span class="color-green">{{ row.time }}</span></td>
                                    <td><span class="color-danger">{{ row.count }}</span></td>
                                    <td><span class="color-info">{{ row.price }}</span></td>
                                    <td><span>{{ row.extras }}</span></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
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
    </layout>
</template>

<script>
    import Layout from '@/components/layouts/Layout'
    import Breadcrumb from '@/components/breadcrumb/Breadcrumb'

    export default {
        name: 'UpcomingProjects',
        components: {Breadcrumb, Layout},
        data() {
            return {
                upcomingProjects: [
                    {
                        date: 'December 18th',
                        projects: [
                            {
                                id: 1,
                                project: 'Secure 25',
                                time: '10 PM UTC',
                                count: '100%',
                                price: '$90',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 2,
                                project: 'Portable Fire',
                                time: '12 PM UTC',
                                count: '10%',
                                price: '$190',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 3,
                                project: 'Buddistras',
                                time: '10 PM UTC',
                                count: '900%',
                                price: '$200',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 4,
                                project: 'Mopsquersd',
                                time: '11 PM UTC',
                                count: '200%',
                                price: '$90',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 5,
                                project: 'Trads562',
                                time: '2 PM UTC',
                                count: '300%',
                                price: '$560',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 6,
                                project: 'Raresable',
                                time: '10 PM UTC',
                                count: '600%',
                                price: '$600',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 7,
                                project: 'Firetab',
                                time: '6 PM UTC',
                                count: '100%',
                                price: '$85',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 8,
                                project: 'TheEnd',
                                time: '5 PM UTC',
                                count: '85%',
                                price: '$90',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 9,
                                project: 'Firetab',
                                time: '6 PM UTC',
                                count: '100%',
                                price: '$85',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 10,
                                project: 'Raresable',
                                time: '10 PM UTC',
                                count: '600%',
                                price: '$190',
                                extras: 'If SOL is above $200'
                            }
                        ]
                    },
                    {
                        date: 'December 17th',
                        projects: [
                            {
                                id: 1,
                                project: 'Secure 25',
                                time: '10 PM UTC',
                                count: '100%',
                                price: '$90',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 2,
                                project: 'Portable Fire',
                                time: '12 PM UTC',
                                count: '10%',
                                price: '$190',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 3,
                                project: 'Buddistras',
                                time: '10 PM UTC',
                                count: '900%',
                                price: '$200',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 4,
                                project: 'Mopsquersd',
                                time: '11 PM UTC',
                                count: '200%',
                                price: '$90',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 5,
                                project: 'Trads562',
                                time: '2 PM UTC',
                                count: '300%',
                                price: '$560',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 6,
                                project: 'Raresable',
                                time: '10 PM UTC',
                                count: '600%',
                                price: '$600',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 7,
                                project: 'Firetab',
                                time: '6 PM UTC',
                                count: '100%',
                                price: '$85',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 8,
                                project: 'TheEnd',
                                time: '5 PM UTC',
                                count: '85%',
                                price: '$90',
                                extras: 'If SOL is above $200'
                            }
                        ]
                    },
                    {
                        date: 'December 16th',
                        projects: [
                            {
                                id: 1,
                                project: 'Secure 25',
                                time: '10 PM UTC',
                                count: '100%',
                                price: '$90',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 2,
                                project: 'Portable Fire',
                                time: '12 PM UTC',
                                count: '10%',
                                price: '$190',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 3,
                                project: 'Buddistras',
                                time: '10 PM UTC',
                                count: '900%',
                                price: '$200',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 4,
                                project: 'Mopsquersd',
                                time: '11 PM UTC',
                                count: '200%',
                                price: '$90',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 5,
                                project: 'Trads562',
                                time: '2 PM UTC',
                                count: '300%',
                                price: '$560',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 6,
                                project: 'Raresable',
                                time: '10 PM UTC',
                                count: '600%',
                                price: '$600',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 7,
                                project: 'Firetab',
                                time: '6 PM UTC',
                                count: '100%',
                                price: '$85',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 8,
                                project: 'TheEnd',
                                time: '5 PM UTC',
                                count: '85%',
                                price: '$90',
                                extras: 'If SOL is above $200'
                            }
                        ]
                    },
                    {
                        date: 'December 15th',
                        projects: [
                            {
                                id: 1,
                                project: 'Secure 25',
                                time: '10 PM UTC',
                                count: '100%',
                                price: '$90',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 2,
                                project: 'Portable Fire',
                                time: '12 PM UTC',
                                count: '10%',
                                price: '$190',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 3,
                                project: 'Buddistras',
                                time: '10 PM UTC',
                                count: '900%',
                                price: '$200',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 4,
                                project: 'Mopsquersd',
                                time: '11 PM UTC',
                                count: '200%',
                                price: '$90',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 5,
                                project: 'Trads562',
                                time: '2 PM UTC',
                                count: '300%',
                                price: '$560',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 6,
                                project: 'Raresable',
                                time: '10 PM UTC',
                                count: '600%',
                                price: '$600',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 7,
                                project: 'Firetab',
                                time: '6 PM UTC',
                                count: '100%',
                                price: '$85',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 8,
                                project: 'TheEnd',
                                time: '5 PM UTC',
                                count: '85%',
                                price: '$90',
                                extras: 'If SOL is above $200'
                            }
                        ]
                    },
                    {
                        date: 'December 14th',
                        projects: [
                            {
                                id: 1,
                                project: 'Secure 25',
                                time: '10 PM UTC',
                                count: '100%',
                                price: '$90',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 2,
                                project: 'Portable Fire',
                                time: '12 PM UTC',
                                count: '10%',
                                price: '$190',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 3,
                                project: 'Buddistras',
                                time: '10 PM UTC',
                                count: '900%',
                                price: '$200',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 4,
                                project: 'Mopsquersd',
                                time: '11 PM UTC',
                                count: '200%',
                                price: '$90',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 5,
                                project: 'Trads562',
                                time: '2 PM UTC',
                                count: '300%',
                                price: '$560',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 6,
                                project: 'Raresable',
                                time: '10 PM UTC',
                                count: '600%',
                                price: '$600',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 7,
                                project: 'Firetab',
                                time: '6 PM UTC',
                                count: '100%',
                                price: '$85',
                                extras: 'If SOL is above $200'
                            },
                            {
                                id: 8,
                                project: 'TheEnd',
                                time: '5 PM UTC',
                                count: '85%',
                                price: '$90',
                                extras: 'If SOL is above $200'
                            }
                        ]
                    }
                ],
                currPage: 1,
                countOfPage: 3
            }
        },
        computed: {
            filteredRows() {
                return this.upcomingProjects;
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