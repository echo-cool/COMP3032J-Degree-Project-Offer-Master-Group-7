<style>
.table td.fit,
.table th.fit {
    white-space: nowrap;
    width: 1%;
}
table.table-fit {
    width: auto !important;
    table-layout: auto !important;
}
table.table-fit thead th, table.table-fit tfoot th {
    width: auto !important;
}
table.table-fit tbody td, table.table-fit tfoot td {
    width: auto !important;
}
.upcoming-projects tr th span{
    font-size: medium !important;
}
tbody tr td span{
    font-size: small !important;
    overflow: hidden;
}
tbody tr td{
    white-space: nowrap;
    overflow:hidden;
}
table {

    table-layout: fixed;
    word-wrap: break-word;
}
</style>
<template>
    <layout>
        <breadcrumb title="Explore Application Decisions" current="Decision Reports"/>

        <div class="rn-upcoming-area rn-section-gap">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="table-title-area d-flex">
                            <i class="feather-briefcase"/>
                            <h3>Application Decision Reports</h3>
                        </div>
                        <div class="box-table table-responsive">
                            <table class="table upcoming-projects table-fixed " >
                                <thead>
                                <tr>
                                    <template v-for="(th, thIndex) in Object.keys(tableHeader)"
                                              :key="`th-${thIndex}`">
                                        <th class="fit">
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

                                <tbody v-if="applications.length !== 0" class="ranking">
                                <tr :class="{'color-light': rowIndex%2 === 0}"
                                    v-for="(row, rowIndex) in filteredRows.slice(pageStart, pageStart + countOfPage)"
                                    :key="`application-decision-${rowIndex}`">

                                    <td class="fit">
                                        <div class="product-wrapper d-flex align-items-center">
                                            <router-link :to="'/chat/' + row.user.id" class="thumbnail">
                                                <img :src="`/backend/static/${row.user.avatar}`" alt="Nft_Profile">
                                                <span>{{ row.user.username }}</span>
                                            </router-link>
                                        </div>
                                    </td>

                                    <td class="fit" >
                                        <router-link :to="`/school-details/${row.program.school.id}`">
                                            <span style="width: 100px;overflow: hidden">{{ row.program.school.name }}</span>
                                        </router-link>
                                    </td>

                                    <td class="fit">
                                        <router-link :to="`#`">
                                            <span>{{ row.program.name }}</span>
                                        </router-link>
                                    </td>

                                    <td class="fit">
                                        <span>{{ row.program.degree }}</span>
                                    </td>

                                    <td class="fit">
                                        <span>{{ row.eRound.toLowerCase().replace('_', ' - ') }}</span>
                                    </td>

                                    <td class="fit">
                                        <span :class="row.eStatus === 'ADMITTED' ? 'color-green' : 'color-red'">
                                            {{ row.eStatus }}
                                        </span>
                                    </td>

                                    <td class="fit">
                                        <span>{{ row.reportedTime }}</span>
                                    </td>

                                    <td class="fit">
                                        <button type="button"
                                                :id="`backgroundModalButton-${row.user.profile.id}`"
                                                class="btn btn-primary save-btn-edit"
                                                :data-bs-toggle="`modal`"
                                                @click="getUserProfile"
                                                :data-bs-target="`#backgroundModal-${row.user.profile.id}`">
                                            Peek Background
                                        </button>
                                    </td>

                                    <background-modal  :background="row.user.profile" :card-title="`Application Background of [` + row.user.username + `]`"/>
                                </tr>
                                </tbody>
                            </table>
                        </div>

<!--                        <nav class="pagination-wrapper" aria-label="Page navigation example">-->
<!--                            <ul :class="`pagination`">-->
<!--                                <li class="page-item"-->
<!--                                    :class="{'disabled': (currPage === 1)}"-->
<!--                                    @click.prevent="setPage(currPage-1)">-->
<!--                                    <a class="page-link" href="">-->
<!--                                        Previous-->
<!--                                    </a>-->
<!--                                </li>-->
<!--                                <li class="page-item"-->
<!--                                    v-for="n in totalPage"-->
<!--                                    @click.prevent="setPage(n)">-->
<!--                                    <a :class="[`page-link`, {'active': (currPage === (n))}]" href="">-->
<!--                                        {{n}}-->
<!--                                    </a>-->
<!--                                </li>-->
<!--                                <li class="page-item"-->
<!--                                    :class="{'disabled': (currPage === totalPage)}"-->
<!--                                    @click.prevent="setPage(currPage + 1)">-->
<!--                                    <a class="page-link" href="">-->
<!--                                        Next-->
<!--                                    </a>-->
<!--                                </li>-->
<!--                            </ul>-->
<!--                        </nav>-->

<!--                        <nav class="pagination-wrapper" aria-label="Page navigation example">-->
<!--                            <paginate-->
<!--                                :page-count="20"-->
<!--                                :page-range="3"-->
<!--                                :margin-pages="2"-->
<!--                                :click-handler="pageClickCallback"-->
<!--                                :prev-text="'Prev'"-->
<!--                                :next-text="'Next'"-->
<!--                                :container-class="'pagination'"-->
<!--                                :page-class="'page-item'"-->
<!--                            >-->
<!--                            </paginate>-->
<!--                        </nav>-->

                        <nav class="pagination-wrapper" aria-label="Page navigation example">
                            <paginate
                                :page-count="this.countOfPage"
                                :page-range="3"
                                :margin-pages="2"
                                :click-handler="pageClickCallback"
                                :prev-text="'Prev'"
                                :next-text="'Next'"
                                :container-class="'pagination'"
                                :page-class="'page-item'"
                            >
                            </paginate>
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
    import backgroundModal from "@/components/myComp/modal/BackgroundModal.vue";
    import backgroundCard from "@/components/myComp/background/BackgroundCard.vue";
    import Paginate from "vuejs-paginate-next";

    export default {
        name: 'ExploreDecisions',
        components: {
            Breadcrumb,
            Layout,
            backgroundModal,
            Paginate
        },
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
                    Reported_Time: "",
                    Operations: ""
                },
                applications: [],
                loadCountUser: 0,
                loadCountProgram: 0,
                loadCountSchool: 0,
                loadCountProfile: 0, // background

                currPage: 1,
                countOfPage: 15,

            }
        },
        created() {

            this.getDecidedApplications();

        },
        computed: {
            backgroundCard() {
                return backgroundCard
            },
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
          getUserProfile(event){
            // console.log(event);
            // let userID = event.target.id.split("-")[1];
            // // console.log(userID);
            // // request the profile (background) for this user
            // let profileURL = `/rest/users/${userID}/profile`
            // commonApi.getByRestURL(profileURL)
            //     .then(response => {
            //       this.applications[k].user.profile = response;
            //       this.loadCountProfile += 1;
            //     })
          },

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
                        // this.loadCountUser = 0;
                        // this.loadCountProgram = 0;
                        // this.loadCountProfile = 0;
                        // this.loadCountSchool = 0;

                        // we need to request the user and program obj for each application
                        // for(let k in this.applications){
                        //     // request the user
                        //     let userURL = `/rest/applications/${this.applications[k].id}/user`;
                        //     commonApi.getByRestURL(userURL)
                        //         .then(response => {
                        //             this.applications[k].user = response;
                        //             this.loadCountUser += 1;
                        //
                        //             // request the profile (background) for this user
                        //             let profileURL = `/rest/users/${this.applications[k].user.id}/profile`
                        //             commonApi.getByRestURL(profileURL)
                        //                 .then(response => {
                        //                     this.applications[k].user.profile = response;
                        //                     this.loadCountProfile += 1;
                        //                 })
                        //         })

                            // request the program
                            // let programURL = `/rest/applications/${this.applications[k].id}/program`;
                            // commonApi.getByRestURL(programURL)
                            //     .then(response => {
                            //         this.applications[k].program = response;
                            //         this.loadCountProgram += 1;
                            //
                            //         // request the school for this program
                            //         let schoolURL = `/rest/programs/${this.applications[k].program.id}/school`
                            //         commonApi.getByRestURL(schoolURL)
                            //             .then(response => {
                            //                 this.applications[k].program.school = response;
                            //                 this.loadCountSchool += 1;
                            //             })
                            //     })
                        // }

                    });
            },

            pageClickCallback (pageNum) {
                console.log(pageNum)
                this.currPage = pageNum;
                window.scrollTo(0, 0);
            }
        }
    }
</script>

<style>
nav .active a {
    background: var(--color-primary) !important;
    color: var(--color-white) !important;
}

nav li a:hover {
    cursor: pointer;
}

nav li.disabled a{
    background: var(--color-lighter) !important;
}
</style>
