<template>
    <layout>
        <breadcrumb title="Ariticle Polishing" current="Ariticle Polishing"/>

        <div class="rn-blog-area rn-blog-details-default">
            <div class="container">
                <div class="row g-6">
                    <h3 class="title mt-lg-5">Write Your Essay Here and Get Polished</h3>
                    <div class="col-xl-8 col-lg-8" style="margin: auto">
                        <div class="rn-blog-listen">
                            <!-- <div class="news-details" v-html="article.content"/> -->
                            <div class="comments-wrapper pt--40">
                                <div class="comments-area">
                                    <div class="trydo-blog-comment">
<!--                                        <h3 class="title">Write Your Essay Here and Get Polished</h3>-->
<!--                                        <span class="date">{{ article.createdAt }}</span>-->
                                         <div class="rn-comment-form pt--0">
                                        <div class="inner">
                                        <form class="mt--20" action="#" id="comment-form" onsubmit="return false">
                                        <div class="row">
                                            <div class="col-lg-12 col-md-12 col-12">
                                                <div class="rnform-group">
                                                    <grammarly-editor-plugin :config="{
                                                  activation: 'focus',
                                                  autocomplete: 'on',
                                                  underlines: 'on',
                                                  toneDetector: 'on'
                                                  }" clientId="client_FB5htQfgvMprDoEMqvDsLw">
                                                      <editor
                                                          :initialValue="text"
                                                          :init="{
                                                          height: 600,
                                                          menubar: true,
                                                        }"
                                                      />
                                                      <grammarly-button />
                                                    </grammarly-editor-plugin>
                                                </div>
                                            </div>
<!--                                            <div class="col-lg-12">-->
<!--                                                <div class="blog-btn" v-on:click="submitComment()">-->
<!--                                                    <a class="btn btn-primary-alta btn-large w-100" href="#">-->
<!--                                                        <span>Upload</span>-->
<!--                                                    </a>-->
<!--                                                </div>-->
<!--                                            </div>-->
                                        </div>
                                    </form>
                                    </div>
                                    </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </layout>
</template>

<script>
    import Layout from '@/components/layouts/Layout'
    import Breadcrumb from '@/components/breadcrumb/Breadcrumb'
    import ArticleMixin from '@/mixins/ArticleMixin'
    import SalScrollAnimationMixin from '@/mixins/SalScrollAnimationMixin'
    import articleApi from "@/api/article";
    import Editor from "@tinymce/tinymce-vue";
    import request from "@/utils/request";

    import { GrammarlyEditorPlugin, GrammarlyButton } from "@grammarly/editor-sdk-vue";

    export default {
        name: 'ArticlePolishing',
        components: { Breadcrumb, Layout, GrammarlyEditorPlugin, GrammarlyButton, Editor},
        mixins: [SalScrollAnimationMixin, ArticleMixin],
        data() {
            return {
                id: this.$route.params.id,
                article: {}
            }
        },
        methods: {
            getArticle(ariticleId) {
                this.article = articleApi.getById(ariticleId).then(response => {
                    console.log(response)
                    this.article = response['data']['article']
                })
            },
            submitComment() {
                // let form = document.getElementById("comment-form")
                // let formData = new FormData(form)
                // formData.append("postID", this.blog.id)
                // request({
                //   url: '/api/post/createPostComment',
                //   method: 'post',
                //   data: formData
                // }).then(response => {
                //   if (response['success'] === true) {
                //       window.location.reload(true)
                //   }
                // })
                // return false
            }
        },
        created() {
            this.id = this.$route.params.id;
            // this.getArticle(this.id);
        },
        // watch: {
        //     '$route.params.id': function (val) {
        //         this.id = val;
        //         this.getArticle(this.id);
        //     }
        // },
    }
</script>