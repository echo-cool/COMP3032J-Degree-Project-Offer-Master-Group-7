<template>
    <layout>
        <breadcrumb title="Blog Details" current="Blog Details"/>

        <div class="rn-blog-area rn-blog-details-default rn-section-gapTop">
            <div class="container">
                <div class="row g-6">
                    <div class="col-xl-8 col-lg-8">
                        <div class="rn-blog-listen">
                            <div class="blog-content-top">
                                <h2 class="title">{{ blog.title }}</h2>
                                <span class="date">2 Aug, </span>
                            </div>
                            <div class="bd-thumbnail">
                                <div class="large-img mb--30">
                                    <img class="w-100" :src="blog.img" alt="Blog Images">
                                </div>
                            </div>
                            <div class="news-details" v-html="blog.body"/>
                            <div class="comments-wrapper pt--40">
                                <div class="comments-area">
                                    <div class="trydo-blog-comment">
                                        <h5 class="comment-title mb--40">
                                            9 replies on “Have You Heard?
                                            Agency Is Your Best
                                            Bet To Grow”
                                        </h5>
                                        <ul class="comment-list">
                                            <!-- Start Single Comment  -->
                                            <li class="comment parent">
                                                <div class="single-comment">
                                                    <div class="comment-author comment-img">
                                                        <img class="comment-avatar"
                                                             :src="require(`@/assets/images/blog/comment/comment-01.png`)"
                                                             alt="Comment Image">
                                                        <div class="m-b-20">
                                                            <div class="commenter">Parent</div>
                                                            <div class="time-spent">August 20, at 8:44 pm</div>
                                                        </div>
                                                    </div>
                                                    <div class="comment-text">
                                                        <p>
                                                            A component that allows for easy creation of menu
                                                            items, quickly
                                                            creating paragraphs of “Lorem Ipsum” and
                                                            pictures with custom
                                                            sizes.
                                                        </p>
                                                    </div>
                                                    <div class="reply-edit">
                                                        <div class="reply">
                                                            <a class="comment-reply-link" href="#">
                                                                <i class="rbt feather-corner-down-right"/> Reply
                                                            </a>
                                                        </div>
                                                    </div>
                                                </div>
                                                <ul class="children">
                                                    <li class="comment byuser">
                                                        <div class="single-comment">
                                                            <div class="comment-author comment-img">
                                                                <img class="comment-avatar"
                                                                     :src="require(`@/assets/images/blog/comment/comment-01.png`)"
                                                                     alt="Comment Image">
                                                                <div class="m-b-20">
                                                                    <div class="commenter">Admin Comment</div>
                                                                    <div class="time-spent"> August 20, at 8:44 pm</div>
                                                                </div>
                                                            </div>
                                                            <div class="comment-text">
                                                                <p>
                                                                    A component that allows for easy creation
                                                                    of menu items,
                                                                    quickly creating paragraphs of “Lorem
                                                                    Ipsum” and
                                                                    pictures with custom sizes.
                                                                </p>
                                                            </div>
                                                            <div class="reply-edit">
                                                                <div class="reply">
                                                                    <a class="comment-reply-link" href="#">
                                                                        <i class="rbt feather-corner-down-right"/> Reply
                                                                    </a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </li>
                                            <!-- End Single Comment  -->

                                            <!-- Start Single Comment  -->
                                            <li class="comment parent">
                                                <div class="single-comment">
                                                    <div class="comment-author comment-img">
                                                        <img class="comment-avatar"
                                                             :src="require(`@/assets/images/blog/comment/comment-01.png`)"
                                                             alt="Comment Image">
                                                        <div class="m-b-20">
                                                            <div class="commenter">Craig E. Judge</div>
                                                            <div class="time-spent"> August 20, at 8:44 pm</div>
                                                        </div>
                                                    </div>
                                                    <div class="comment-text">
                                                        <p>
                                                            A component that allows for easy creation of menu
                                                            items, quickly
                                                            creating paragraphs of “Lorem Ipsum” and
                                                            pictures with custom
                                                            sizes.
                                                        </p>
                                                    </div>
                                                    <div class="reply-edit">
                                                        <div class="reply">
                                                            <a class="comment-reply-link" href="#">
                                                                <i class="rbt feather-corner-down-right"/> Reply
                                                            </a>
                                                        </div>
                                                    </div>
                                                </div>
                                                <ul class="children">
                                                    <li class="comment">
                                                        <div class="single-comment">
                                                            <div class="comment-author comment-img">
                                                                <img class="comment-avatar"
                                                                     :src="require(`@/assets/images/blog/comment/comment-01.png`)"
                                                                     alt="Comment Image">
                                                                <div class="m-b-20">
                                                                    <div class="commenter"><a href="#">Child Comment</a></div>
                                                                    <div class="time-spent"> August 20, at 8:44 pm</div>
                                                                </div>
                                                            </div>
                                                            <div class="comment-text">
                                                                <p>
                                                                    A component that allows for easy creation
                                                                    of menu items,
                                                                    quickly creating paragraphs of “Lorem
                                                                    Ipsum” and
                                                                    pictures with custom sizes.
                                                                </p>
                                                            </div>
                                                            <div class="reply-edit">
                                                                <div class="reply">
                                                                    <a class="comment-reply-link" href="#">
                                                                        <i class="rbt feather-corner-down-right"/> Reply
                                                                    </a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <ul class="children">
                                                            <li class="comment">
                                                                <div class="single-comment">
                                                                    <div class="comment-author comment-img">
                                                                        <img class="comment-avatar"
                                                                             :src="require(`@/assets/images/blog/comment/comment-01.png`)"
                                                                             alt="Comment Image">
                                                                        <div class="m-b-20">
                                                                            <div class="commenter">
                                                                                <a href="#">Child Comment</a>
                                                                            </div>
                                                                            <div class="time-spent">August 20, at 8:44 pm</div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="comment-text">
                                                                        <p>
                                                                            A component that allows for easy
                                                                            creation of menu
                                                                            items,
                                                                            quickly creating paragraphs of
                                                                            “Lorem Ipsum” and
                                                                            pictures with custom sizes.
                                                                        </p>
                                                                    </div>
                                                                    <div class="reply-edit">
                                                                        <div class="reply">
                                                                            <a class="comment-reply-link" href="#">
                                                                                <i class="rbt feather-corner-down-right"/> Reply
                                                                            </a>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                </ul>
                                            </li>
                                            <!-- End Single Comment  -->
                                        </ul>
                                    </div>
                                </div>
                            </div>

                            <!-- Start Contact Form Area -->
                            <div class="rn-comment-form pt--60">
                                <div class="inner">
                                    <div class="section-title">
                                        <span class="subtitle">Have a Comment?</span>
                                        <h2 class="title">Leave a Reply</h2>
                                    </div>
                                    <form class="mt--40" action="#">
                                        <div class="row">
                                            <div class="col-lg-6 col-md-12 col-12">
                                                <div class="rnform-group"><input type="text" placeholder="Name"></div>
                                                <div class="rnform-group"><input type="email" placeholder="Email"></div>
                                                <div class="rnform-group"><input type="text" placeholder="Website"></div>
                                            </div>
                                            <div class="col-lg-6 col-md-12 col-12">
                                                <div class="rnform-group">
                                                    <textarea placeholder="Comment"></textarea>
                                                </div>
                                            </div>
                                            <div class="col-lg-12">
                                                <div class="blog-btn">
                                                    <a class="btn btn-primary-alta btn-large w-100" href="#">
                                                        <span>SEND MESSAGE</span>
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <!-- End Contact Form Area -->

                            <div class="row g-5 pt--60">
                                <div class="col-lg-12">
                                    <h3 class="title">Related Post</h3>
                                </div>
                                <template v-for="(blog, index) in posts" :key="`blog-${index}`">
                                    <div v-if="index < 3"
                                         class="col-xl-4 col-lg-6 col-md-6 col-12"
                                         data-sal="slide-up"
                                         data-sal-duration="800"
                                         data-sal-delay="150">
                                        <blog-card :blog="blog"/>
                                    </div>
                                </template>
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
    import Layout from '@/components/layouts/Layout'
    import Breadcrumb from '@/components/breadcrumb/Breadcrumb'
    import BlogMixin from '@/mixins/BlogMixin'
    import BlogCard from '@/components/blog/BlogCard'
    import SalScrollAnimationMixin from '@/mixins/SalScrollAnimationMixin'
    import BlogSidebar from '@/components/blog/BlogSidebar'

    export default {
        name: 'BlogDetails',
        components: {BlogSidebar, BlogCard, Breadcrumb, Layout},
        mixins: [SalScrollAnimationMixin, BlogMixin],
        data() {
            return {
                id: this.$route.params.id,
                blog: {}
            }
        },
        methods: {
            getBlog(blogId) {
                this.blog = this.posts.find(item => item.id == blogId);
            }
        },
        created() {
            this.getBlog(this.id);
        },
        watch: {
            '$route.params.id': function (val) {
                this.id = val;
                this.getBlog(this.id);
            }
        },
    }
</script>