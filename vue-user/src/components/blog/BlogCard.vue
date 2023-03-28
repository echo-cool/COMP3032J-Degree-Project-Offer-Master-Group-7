<template>
    <div class="rn-blog">
        <div class="inner">
            <div class="thumbnail">
                <router-link :to="`/blog-details/${blog.id}`">
                    <img :src="`/backend/static/`+blog.img" :alt="blog.title">
                </router-link>
            </div>
            <div class="content">
                <div class="category-info">
                    <div class="category-list">
                        <router-link :to="`/category/${categorySlug}`">{{ blog.category.name }}</router-link>
                    </div>
                    <div class="meta">
                        <span><i class="feather-clock"/> {{ blog.createdAt }}</span>
                    </div>
                </div>
                <h4 class="title">
                    <router-link :to="`/blog-details/${blog.id}`">
                        {{ blog.title }} <i class="feather-arrow-up-right"/>
                    </router-link>
                </h4>
            </div>
        </div>
    </div>
</template>

<script>
    import AppFunctions from '@/helpers/AppFunctions'

    export default {
        name: 'BlogCard',
        props: {
            blog: {}
        },
        data() {
            return {
                AppFunctions
            }
        },
        computed: {
            categorySlug() {
                return AppFunctions.slugify(this.blog.category)
            }
        }
    }
</script>