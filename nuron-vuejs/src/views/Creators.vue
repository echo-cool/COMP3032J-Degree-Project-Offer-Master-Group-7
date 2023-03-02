<template>
    <layout>
        <div class="rn-creator-title-area rn-section-gapTop">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-6 col-md-6 col-sm-6 col-12">
                        <h2 class="title mb--0">Our Best Creators</h2>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-6 col-12 mt_mobile--15">
                        <div class="shortby-default text-start text-sm-end">
                            <label class="filter-leble">SHOT BY:</label>
                            <nice-select
                                :options="[
                                    {value: 'Top Rated', text: 'Top Rated'},
                                    {value: 'Best Seller', text: 'Best Seller'},
                                    {value: 'Recent Added', text: 'Recent Added'},
                                    {value: 'Varified', text: 'Varified'}
                                ]"
                                :default-current="0"
                                name="sellerSort"
                                @onChange="changeHandler"
                            />
                        </div>
                    </div>
                </div>
                <div class="row g-5 mt--30 creator-list-wrapper">
                    <div class="creator-single col-lg-3 col-md-4 col-sm-6"
                         v-for="(seller, index) in filteredRows.slice(pageStart, pageStart + countOfPage)"
                         :key="`seller-${index}`">
                        <seller :seller-data="seller" seller-style-class="explore"/>
                    </div>
                </div>
                <div v-if="filteredRows.length > 16" class="row">
                    <div class="col-lg-12">
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
    import NiceSelect from '@/components/select/NiceSelect'
    import Seller from '@/components/seller/Seller'
    import AuthorMixin from '@/mixins/AuthorMixin'
    import Pagination from '@/components/pagination/pagination'
    import AppFunctions from "@/helpers/AppFunctions";

    export default {
        name: 'Creators',
        components: {Pagination, Seller, NiceSelect, Breadcrumb, Layout},
        mixins: [AuthorMixin],
        data() {
            return {
                currPage: 1,
                countOfPage: 16,
                sortStatus: ''
            }
        },
        computed: {
            filteredRows() {
                if (this.sortStatus) {
                    return this.authors.filter(seller =>  AppFunctions.slugify(seller.status) === AppFunctions.slugify(this.sortStatus));
                } else {
                    return this.authors;
                }
            },
            pageStart() {
                return (this.currPage - 1) * this.countOfPage;
            },
            totalPage() {
                return Math.ceil(this.filteredRows.length / this.countOfPage);
            }
        },
        watch: {
            filteredRows(value) {
                if (value.length < 16) this.currPage = 1;
            }
        },
        methods: {
            changeHandler(item) {
                this.sortStatus = item.value;
            },
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