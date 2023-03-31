<template>
    <layout>
        <breadcrumb title="Post Details" current="Post Details"/>

        <div class="rn-blog-area rn-blog-details-default rn-section-gapTop" v-if="blog.id">
            <div class="container">
                <div class="row g-6">
                    <div class="col-xl-8 col-lg-8">
                        <div class="rn-blog-listen">
                            <div class="blog-content-top">
                                <h2 class="title">{{ blog.title }}</h2>
                                <span class="date">{{blog.createdAt}}</span>
                            </div>
                            <div class="bd-thumbnail">
                                <div class="large-img mb--30">
                                    <img class="w-100" :src="`/backend/static/`+blog.img" alt="Blog Images">
                                </div>
                            </div>
                            <div class="news-details" v-html="blog.content"/>
                            <div class="comments-wrapper pt--40">
                                <div class="comments-area">
                                    <div class="trydo-blog-comment">
                                        <h5 class="comment-title mb--40">
                                            {{blog.comments.length}} replies on “{{blog.title}}”
                                        </h5>
                                        <ul class="comment-list">
                                            <!-- Start Single Comment  -->
                                            <li class="comment parent" v-if="blog.comments.length !== 0" v-for="comment in blog.comments">
                                                <div class="single-comment">
                                                    <div class="comment-author comment-img">
                                                        <img class="comment-avatar"
                                                             :src="'/backend/static/' + comment.author.avatar"
                                                             alt="Comment Image"
                                                              style="width: 60px; border-radius: 100%;">
                                                        <div class="m-b-20">
                                                            <div class="commenter">{{ comment.author.username }}</div>
                                                            <div class="time-spent">{{ comment.createdAt }}</div>
                                                        </div>
                                                    </div>
                                                    <div class="comment-text">
                                                        <p>
                                                            {{ comment.content }}
                                                        </p>
                                                    </div>

                                                </div>

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
                                    <form class="mt--40" action="#" id="comment-form" onsubmit="return false">
                                        <div class="row">
                                            <div class="col-lg-12 col-md-12 col-12">
                                                <div class="rnform-group">
                                                    <grammarly-editor-plugin :config="{
                                                  activation: 'focus',
                                                  autocomplete: 'on',
                                                  underlines: 'on',
                                                  toneDetector: 'on'
                                                  }" clientId="client_FB5htQfgvMprDoEMqvDsLw">
                                                      <textarea name="comment" placeholder="Comment" />
                                                      <grammarly-button />
                                                    </grammarly-editor-plugin>
                                                </div>
                                            </div>
                                            <div class="col-lg-12">
                                                <div class="blog-btn" v-on:click="submitComment()">
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
                                <template v-if="posts[0].id !== 0" v-for="(blog, index) in posts" :key="`blog-${index}`">
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
    import {getPost} from "@/api/community";
    import request from "@/utils/request";

    import { GrammarlyEditorPlugin, GrammarlyButton } from "@grammarly/editor-sdk-vue";

    export default {
        name: 'PostDetails',
        components: {BlogSidebar, BlogCard, Breadcrumb, Layout, GrammarlyEditorPlugin, GrammarlyButton},
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
            },
            submitComment() {
                let form = document.getElementById("comment-form")
                let formData = new FormData(form)
                formData.append("postID", this.blog.id)
                request({
                  url: '/api/post/createPostComment',
                  method: 'post',
                  data: formData
                }).then(response => {
                  if (response['success'] === true) {
                      window.location.reload(true)
                  }
                })
                return false
            }
        },
        created() {
            getPost(this.id).then(response => {
              this.blog = response['data']['post']
              console.log(this.blog.content)
            })
        },
        watch: {
            '$route.params.id': function (val) {
                this.id = val;
                this.getBlog(this.id);
            }
        },
    }
</script>