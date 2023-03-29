<template>
    <aside class="rwt-sidebar">
        <div class="rbt-single-widget widget_categories">
            <h3 class="title">Categories</h3>
            <div class="inner">
                <ul class="category-list ">
                    <li v-for="(category, index) in categories" :key="`category-${index}`">
                        <router-link :to="`/category/${category.slug}`">
                            <span class="left-content">{{ category.title }}</span>
                            <span class="count-text">300</span>
                        </router-link>
                    </li>
                </ul>
            </div>
        </div>
        <div class="rbt-single-widget widget_recent_entries mt--40">
            <h3 class="title">Recent Posts</h3>
            <div class="inner">
                <ul>
                    <template v-for="(recentPost, index) in posts" :key="`recent-post-${index}`">
                        <li v-if="index < 4">
                            <router-link class="d-block" :to="`/blog-details/${recentPost.id}`">
                                {{ recentPost.title }}
                            </router-link>
                            <span class="cate">{{ recentPost.categories[0] }}</span>
                        </li>
                    </template>
                </ul>
            </div>
        </div>
        <div class="rbt-single-widget widget_tag_cloud mt--40">
            <h3 class="title">Tags</h3>
            <div class="inner mt--20">
                <div class="tagcloud">
                    <router-link v-for="(tag, index) in tags"
                                 :to="`/tag/${tag.slug}`"
                                 :key="`tag-${index}`">
                        {{ tag.title }}
                    </router-link>
                </div>
            </div>
        </div>
    </aside>
</template>

<script>
    import BlogMixin from '@/mixins/BlogMixin'

    export default {
        name: 'BlogSidebar',
        mixins: [BlogMixin]
    }
</script>