<template>
    <layout>
        <breadcrumb :title="tagName" :current="tagName"/>

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
                        <blog-pagination :posts="tagPosts" @paginatedData="paginatedData"/>
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
    import BlogPagination from '@/components/pagination/BlogPagination'
    import SalScrollAnimationMixin from '@/mixins/SalScrollAnimationMixin'
    import BlogMixin from '@/mixins/BlogMixin'
    import AppFunctions from '@/helpers/AppFunctions'

    export default {
        name: 'BlogTagPosts',
        components: {BlogPagination, BlogCard, Breadcrumb, Layout},
        mixins: [SalScrollAnimationMixin, BlogMixin],
        data() {
            return {
                tag: this.$route.params.slug,
                tagPosts: [],
                filteredRows: '',
                pageStart: '',
                countOfPage: '',
                AppFunctions
            }
        },
        computed: {
            tagName() {
                return this.tagPosts[0].tags[0]
            }
        },
        methods: {
            getTagPosts() {
                this.tagPosts = this.posts.map(blog => {
                    return {
                        ...blog,
                        tags: blog.tags.filter(data => AppFunctions.slugify(data) === this.tag)
                    }
                }).filter(blog => blog.tags.length > 0);
            },
            paginatedData(filteredRows, pageStart, countOfPage) {
                this.filteredRows = filteredRows;
                this.pageStart = pageStart;
                this.countOfPage = countOfPage;
            }
        },
        created() {
            this.getTagPosts();
        }
    }
</script>