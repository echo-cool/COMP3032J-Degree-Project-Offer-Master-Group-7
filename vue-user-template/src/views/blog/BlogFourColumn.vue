<template>
    <layout>
        <breadcrumb title="Our Blog" current="Our Blog"/>

        <div class="rn-blog-area rn-section-gapTop">
            <div class="container">
                <div class="row g-5">
                    <template v-for="(blog, index) in filteredRows.slice(pageStart, pageStart + countOfPage)"
                              :key="`blog-${index}`">
                        <div class="col-xl-3 col-lg-4 col-md-6 col-12">
                            <blog-card :blog="blog"/>
                        </div>
                    </template>
                </div>
                <div class="row">
                    <div class="col-lg-12" data-sal="slide-up" data-sal-delay="550" data-sal-duration="800">
                        <blog-pagination :posts="posts" @paginatedData="paginatedData"/>
                    </div>
                </div>
            </div>
        </div>
    </layout>
</template>

<script>
    import Layout from '@/components/layouts/Layout'
    import Breadcrumb from '@/components/breadcrumb/Breadcrumb'
    import BlogCard from '@/components/blog/BlogCard'
    import Pagination from '@/components/pagination/pagination'
    import SalScrollAnimationMixin from '@/mixins/SalScrollAnimationMixin'
    import BlogPagination from '@/components/pagination/BlogPagination'
    import BlogMixin from '@/mixins/BlogMixin'

    export default {
        name: 'BlogFourColumn',
        components: {BlogPagination, Pagination, BlogCard, Breadcrumb, Layout},
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