<template>
    <layout>
        <breadcrumb title="Ariticle Polishing" current="Ariticle Polishing"/>

        <div class="rn-blog-area rn-blog-details-default rn-section-gapTop" v-if="ariticle.id">
            <div class="container">
                <div class="row g-6">
                    <div class="col-xl-8 col-lg-8">
                        <div class="rn-blog-listen">
                            <div class="blog-content-top">
                                <h2 class="title">{{ article.title }}</h2>
                                <span class="date">{{ article.createdAt }}</span>
                            </div>
                            <div class="news-details" v-html="ariticle.content"/>
                            <div class="comments-wrapper pt--40">
                                <div class="comments-area">
                                    <div class="trydo-blog-comment">
                                        <h5 class="comment-title mb--40">
                                           Article Polishing
                                        </h5>
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
    import request from "@/utils/request";

    import { GrammarlyEditorPlugin, GrammarlyButton } from "@grammarly/editor-sdk-vue";

    export default {
        name: 'ArticlePolishing',
        components: { Breadcrumb, Layout, GrammarlyEditorPlugin, GrammarlyButton},
        mixins: [SalScrollAnimationMixin, ArticleMixin],
        data() {
            return {
                id: this.$route.params.id,
                article: {}
            }
        },
        methods: {
            getArticle(ariticleId) {
                article = this.articleApi.getById(ariticleId).then(response => {
                    this.article = response['data']['article']
                })
            },
        },
        created() {
            this.id = this.$route.params.id;
            this.getArticle(this.id);
        },
        watch: {
            '$route.params.id': function (val) {
                this.id = val;
                this.getArticle(this.id);
            }
        },
    }
</script>