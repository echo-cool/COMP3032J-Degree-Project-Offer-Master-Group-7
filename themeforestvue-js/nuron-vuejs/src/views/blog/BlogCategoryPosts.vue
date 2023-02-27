<template>
    <layout>
        <breadcrumb :title="categoryName" :current="categoryName"/>

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
                        <blog-pagination :posts="categoryPosts" @paginatedData="paginatedData"/>
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
    import BlogCard from '@/components/blog/BlogCard'
    import AppFunctions from '@/helpers/AppFunctions'
    import BlogMixin from '@/mixins/BlogMixin'
    import BlogPagination from '@/components/pagination/BlogPagination'

    export default {
        name: 'BlogCategoryPosts',
        components: {BlogPagination, BlogCard, Breadcrumb, Layout},
        mixins: [SalScrollAnimationMixin, BlogMixin],
        data() {
            return {
                category: this.$route.params.slug,
                categoryPosts: [],
                filteredRows: '',
                pageStart: '',
                countOfPage: '',
                AppFunctions
            }
        },
        computed: {
            categoryName() {
                return this.categoryPosts[0].categories[0]
            }
        },
        methods: {
            getCategoryPosts() {
                this.categoryPosts = this.posts.map(blog => {
                    return {
                        ...blog,
                        categories: blog.categories.filter(data => AppFunctions.slugify(data) === this.category)
                    }
                }).filter(blog => blog.categories.length > 0);
            },
            paginatedData(filteredRows, pageStart, countOfPage) {
                this.filteredRows = filteredRows;
                this.pageStart = pageStart;
                this.countOfPage = countOfPage;
            }
        },
        created() {
            this.getCategoryPosts();
        }
    }
</script>