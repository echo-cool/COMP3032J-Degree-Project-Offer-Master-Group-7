<template>
    <layout>
        <breadcrumb title="My Selected Programs" current="My Applications"/>

        <div class="rn-product-area rn-section-gapTop">
            <div class="container">
                <div class="row g-5">

                    <!-- selected program cards -->
                    <div class="tab-content" id="nav-tabContent">
                        <!-- !!! we must load this component after loading all the schools !!! -->
                        <!-- !!! Otherwise, the schools would be undefined !!! -->
                        <template v-for="(application, index) in filteredRows.slice(pageStart, pageStart + countOfPage)"
                                  :key="`application-${index}`">
                            <selected-program-list-card :application="application"
                                                        :is-liked-obj="isLiked(application.program.id)"
                                                        @reloadData="reloadData"
                                                        @removeLike="removeLike(application.program.id)"
                                                        @addLike="addLike(application.program.id)"/>
                        </template>
                    </div>

                    <!-- pagination -->
<!--                    <nav class="pagination-wrapper" aria-label="Page navigation example">-->
<!--                        <ul :class="`pagination`">-->
<!--                            <li class="page-item"-->
<!--                                :class="{'disabled': (currPage === 1)}"-->
<!--                                @click.prevent="setPage(currPage-1)">-->
<!--                                <a class="page-link" href="">-->
<!--                                    Previous-->
<!--                                </a>-->
<!--                            </li>-->
<!--                            <li class="page-item"-->
<!--                                v-for="n in totalPage"-->
<!--                                @click.prevent="setPage(n)">-->
<!--                                <a :class="[`page-link`, {'active': (currPage === (n))}]" href="">-->
<!--                                    {{n}}-->
<!--                                </a>-->
<!--                            </li>-->
<!--                            <li class="page-item"-->
<!--                                :class="{'disabled': (currPage === totalPage)}"-->
<!--                                @click.prevent="setPage(currPage + 1)">-->
<!--                                <a class="page-link" href="">-->
<!--                                    Next-->
<!--                                </a>-->
<!--                            </li>-->
<!--                        </ul>-->
<!--                    </nav>-->

                    <!-- new pagination -->
                    <nav class="pagination-wrapper" aria-label="Page navigation example">
                        <paginate
                            :page-count="totalPage"
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
    </layout>
</template>

<script>
    import Layout from '@/components/layouts/Layout'
    import Breadcrumb from '@/components/breadcrumb/Breadcrumb'
    import SelectedProgramListCard from "@/components/myComp/program/SelectedProgramListCard.vue";
    import ApplicationListMixin from "@/mixins/user/ApplicationListMixin";
    import LikeMixin from "@/mixins/user/LikeMixin";
    import cookie from "js-cookie";
    import router from "@/router";
    import Toastify from "toastify-js";
    import Paginate from "vuejs-paginate-next";


    export default {
        name: 'MyApplications',
        components: {
            Breadcrumb,
            Layout,
            SelectedProgramListCard,
            Paginate
        },
        mixins: [ApplicationListMixin, LikeMixin],
        data() {
            return {
                currPage: 1,
                countOfPage: 5  // number of items per page
            }
        },
        created() {
            // load the current user info as this page is created
            // user would be redirected to the login page if not logged in
            this.getCurrentUser();
            // load the like info
            this.getLikedPrograms();

        },
        computed: {
            filteredRows() {
                return this.applications;
            },
            pageStart() {
                return (this.currPage - 1) * this.countOfPage;
            },
            totalPage() {
                return Math.ceil(this.applications.length / this.countOfPage);
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

            // get current user info from cookie
            getCurrentUser(){
                // we have stored this when logging in
                let userStr = cookie.get("current_user");
                // turn json string to json obj
                if (userStr){
                    this.currentUser = JSON.parse(userStr);
                    // initialize the applications for this user
                    this.getApplications(this.currentUser.id);

                }else{
                    // user should be redirected to the login page if not logged in
                    Toastify({
                        text: "You should login first!",
                        duration: 3000,
                        close: false,
                        // avatar:"/img/logo-dark.44b49d43.png",
                        gravity: "top", // `top` or `bottom`
                        position: "right", // `left`, `center` or `right`
                        stopOnFocus: false, // Prevents dismissing of toast on hover
                        style: {
                            "font-size": "large",
                            "font-family":"\"Roboto\", sans-serif",
                            background: "linear-gradient(to right, #00b09b, #96c93d)",
                        },
                        onClick: function(){} // Callback after click
                    }).showToast();
                    // record the url user wants to go in cookie
                    cookie.set("gotoAfterLogin", window.location.pathname);
                    // push to login page
                    router.push({path: '/login'});
                }
            },

            reloadData(){
                this.getCurrentUser();
                this.getLikedPrograms();
            },

            pageClickCallback (pageNum) {
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

