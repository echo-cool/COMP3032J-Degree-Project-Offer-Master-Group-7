import AppFunctions from '@/helpers/AppFunctions'
import {getAllPosts} from "@/api/community";

export default {
    data() {
        return {
            posts: [
                {
                    id: 0,
                    img: "",
                    createdAt: '',
                    title: '',
                    category: {id: 1, name: ""},
                    content: "",
                    comments: []
                },
            ],
            categories: [
                {
                    id: 0,
                    name: ""
                }
            ],
            AppFunctions
        }
    },
    methods: {
        getData() {
            getAllPosts().then(response => {
                this.posts = response['data']['posts']
                this.blogCategories()
            })
        },
        blogCategories() {
            let cats = this.posts.map(item => {
                    return item.category.name;
                }),
                singleCatArray = AppFunctions.flatDeep(cats),
                categories = [];

            singleCatArray.forEach(cat => {
                const obj = {
                    title: cat.trim(),
                    slug: AppFunctions.slugify(cat),
                    count: 1
                }
                const objIndex = AppFunctions.containsObject(obj, categories);
                if (objIndex !== -1) {
                    const prevCount = categories[objIndex].count;
                    categories[objIndex] = {
                        title: cat.trim(),
                        slug: AppFunctions.slugify(cat),
                        count: prevCount + 1
                    }
                } else {
                    categories.push(obj);
                }
            });

            this.categories = categories;
        },
        blogTags() {
            let tags = this.posts.map(item => {
                    return item.tags;
                }),
                singleTagArray = AppFunctions.flatDeep(tags),
                tagsData = [];

            singleTagArray.forEach(tag => {
                const obj = {
                        title: tag.trim(),
                        slug: AppFunctions.slugify(tag)
                    },
                    objIndex = AppFunctions.containsObject(obj, tagsData);

                if (objIndex !== -1) {
                    tagsData[objIndex] = {
                        title: tag.trim(),
                        slug: AppFunctions.slugify(tag)
                    }
                } else {
                    tagsData.push(obj);
                }
            });

            this.tags = tagsData;
        }
    },
    created() {
        this.getData();
    }
}