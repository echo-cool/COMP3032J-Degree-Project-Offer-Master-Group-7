<template>
    <layout>
        <breadcrumb :title="category + ''" :current="category + ''"/>

        <div class="rn-blog-area rn-section-gapTop">
            <div class="container">
                <div class="row g-5" v-if="categoryPosts.length !== 0">
                    <template v-if="filteredRows !== ''" v-for="(blog, index) in filteredRows.slice(pageStart, pageStart + countOfPage)"
                              :key="`blog-${index}`">
                        <div class="col-xl-3 col-lg-4 col-md-6 col-12">
                            <blog-card :blog="blog"/>
                        </div>
                    </template>
                </div>
                <div class="row">
                    <div class="col-lg-12" data-sal="slide-up" data-sal-delay="550" data-sal-duration="800">
                        <blog-pagination :posts="categoryPosts" @paginatedData="paginatedData" v-if="categoryPosts.length !== 0"/>
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
    import {getPostsByCategory} from "@/api/community";

    export default {
        name: 'CommunityCategoryPosts',
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
                return this.categoryPosts[0].category.name
            }
        },
        methods: {
            getCategoryPosts() {
              getPostsByCategory(this.category).then(response => {
                this.categoryPosts = response['data']['posts']
                console.log(this.categoryPosts)
              })
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