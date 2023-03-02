<template>
    <layout>
        <breadcrumb title="Blog Single Column" current="Blog Single Column"/>

        <div class="rn-blog-area rn-blog-details-default rn-section-gapTop">
            <div class="container">
                <div class="row g-6 flex-wrap">
                    <div class="col-xl-8 col-lg-8">
                        <template v-for="(blog, index) in filteredRows.slice(pageStart, pageStart + countOfPage)"
                                  :key="`blog-${index}`">
                            <div class="mb--30">
                                <blog-card :blog="blog"/>
                            </div>
                        </template>
                        <div class="row">
                            <div class="col-lg-12" data-sal="slide-up" data-sal-delay="550" data-sal-duration="800">
                                <blog-pagination
                                    :posts="posts"
                                    :count-of-page="3"
                                    pagination-class="single-column-blog"
                                    @paginatedData="paginatedData"
                                />
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-4 col-lg-4 mt_md--40 mt_sm--40">
                        <blog-sidebar/>
                    </div>
                </div>

            </div>
        </div>
    </layout>
</template>

<script>
    import Pagination from '@/components/pagination/pagination'
    import BlogCard from '@/components/blog/BlogCard'
    import Breadcrumb from '@/components/breadcrumb/Breadcrumb'
    import Layout from '@/components/layouts/Layout'
    import SalScrollAnimationMixin from '@/mixins/SalScrollAnimationMixin'
    import BlogMixin from '@/mixins/BlogMixin'
    import BlogPagination from "@/components/pagination/BlogPagination";
    import BlogSidebar from "@/components/blog/BlogSidebar";

    export default {
        name: 'BlogSingleColumn',
        components: {BlogSidebar, BlogPagination, Pagination, BlogCard, Breadcrumb, Layout},
        mixins: [SalScrollAnimationMixin, BlogMixin],
        data() {
            return {
                filteredRows: '',
                pageStart: '',
                countOfPage: ''

            }
        },
        methods: {
            paginatedData(filteredRows, pageStart, countOfPage) {
                this.filteredRows = filteredRows;
                this.pageStart = pageStart;
                this.countOfPage = countOfPage;
            }
        }
    }
</script>