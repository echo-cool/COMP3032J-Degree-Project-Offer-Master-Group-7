<template>
    <layout>
        <breadcrumb title="Our Top NFTs" current="Ranking"/>

        <div class="rn-upcoming-area rn-section-gap">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="table-title-area d-flex">
                            <i class="feather-briefcase"/>
                            <h3>Application Decision Reports</h3>
                        </div>
                        <div class="box-table table-responsive">
                            <table class="table upcoming-projects">
                                <thead>
                                <tr>
                                    <template v-for="(th, thIndex) in Object.keys(tableHeader)"
                                              :key="`th-${thIndex}`">
                                        <th>
<!--                                            <span class="text-capitalize">-->
<!--                                                {{ th === 'one_day_average' ? '24h%' : th.toLowerCase().replace('_', ' ') && th === 'seven_days_average' ? '7d%' : th.toLowerCase().replace('_', ' ') }}-->
<!--                                            </span>-->
                                            <span class="text-capitalize">
                                                {{ th.replace('_', ' ') }}
                                            </span>
                                        </th>
                                    </template>
                                </tr>
                                </thead>

                                <tbody v-if="loadCountUser === applications.length
                                            && loadCountProgram === applications.length
                                            && loadCountSchool === applications.length" class="ranking">
                                <tr :class="{'color-light': rowIndex%2 === 0}"
                                    v-for="(row, rowIndex) in filteredRows.slice(pageStart, pageStart + countOfPage)"
                                    :key="`application-decision-${rowIndex}`">

                                    <td>
                                        <div class="product-wrapper d-flex align-items-center">
                                            <router-link to="#" class="thumbnail">
                                                <img :src="`/backend/static/${row.user.avatar}`" alt="Nft_Profile">
                                                <span>{{ row.user.username }}</span>
                                            </router-link>
                                        </div>
                                    </td>

                                    <td>
                                        <router-link :to="`/school-details/${row.program.school.id}`">
                                            <span>{{ row.program.school.name }}</span>
                                        </router-link>
                                    </td>

                                    <td>
                                        <router-link :to="`#`">
                                            <span>{{ row.program.name }}</span>
                                        </router-link>
                                    </td>

                                    <td>
                                        <span>{{ row.program.degree }}</span>
                                    </td>

                                    <td>
                                        <span>{{ row.eRound.toLowerCase().replace('_', ' - ') }}</span>
                                    </td>

                                    <td>
                                        <span :class="row.eStatus === 'ADMITTED' ? 'color-green' : 'color-red'">
                                            {{ row.eStatus }}
                                        </span>
                                    </td>

                                    <td>
                                        <span>{{ row.reportedTime }}</span>
                                    </td>

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
    import applicationApi from "@/api/application";
    import commonApi from "@/api/common";

    export default {
        name: 'ExploreDecisions',
        components: {Breadcrumb, Layout},
        mixins: [SalScrollAnimationMixin],
        data() {
            return {
                tableHeader: {
                    Applicant: "",
                    School: "",
                    Program: "",
                    Degree: "",
                    Application_Round: "",
                    Application_Decision: "",
                    Reported_Time: ""
                },
                applications: [
                    {
                        user:{},
                        program: {
                            school: {}
                        }
                    }
                ],
                loadCountUser: 0,
                loadCountProgram: 0,
                loadCountSchool: 0,

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
                    }
                ],
                currPage: 1,
                countOfPage: 20,
            }
        },
        created() {

            this.getDecidedApplications();

        },
        computed: {
            filteredRows() {
                return this.applications;
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

            // get a list of decided applications (status: admitted, rejected)
            getDecidedApplications(){
                applicationApi.getDecidedApplications()
                    .then(response => {

                        // update the application list
                        this.applications = response.data.decisions;

                        // reset the loading count
                        this.loadCountUser = 0;
                        this.loadCountProgram = 0;

                        // we need to request the user and program obj for each application
                        for(let k in this.applications){
                            // request the user
                            let userURL = `/rest/applications/${this.applications[k].id}/user`;
                            commonApi.getByRestURL(userURL)
                                .then(response => {
                                    this.applications[k].user = response;
                                    this.loadCountUser += 1;
                                })

                            // request the program
                            let programURL = `/rest/applications/${this.applications[k].id}/program`;
                            commonApi.getByRestURL(programURL)
                                .then(response => {
                                    this.applications[k].program = response;
                                    this.loadCountProgram += 1;

                                    // request the school for this program
                                    let schoolURL = `/rest/programs/${this.applications[k].program.id}/school`
                                    commonApi.getByRestURL(schoolURL)
                                        .then(response => {
                                            this.applications[k].program.school = response;
                                            this.loadCountSchool += 1;
                                        })
                                })
                        }

                    });
            }
        }
    }
</script>
