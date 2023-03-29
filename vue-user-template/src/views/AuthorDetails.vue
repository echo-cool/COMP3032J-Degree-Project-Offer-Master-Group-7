<template>
    <layout>
        <div class="rn-author-bg-area bg_image--9 bg_image ptb--150">
            <div class="container">
                <div class="row"></div>
            </div>
        </div>

        <div class="rn-author-area mb--30 mt_dec--120">
            <div class="container">
                <div class="row padding-tb-50 align-items-center d-flex">
                    <div class="col-lg-12">
                        <div class="author-wrapper">
                            <div class="author-inner">
                                <div class="user-thumbnail">
                                    <img :src="author.image" :alt="author.name">
                                </div>
                                <div class="rn-author-info-content">
                                    <h4 class="title">{{ author.name }}</h4>
                                    <router-link to="#" class="social-follw">
                                        <i class="feather-twitter"/>
                                        <span class="user-name">it0bsession</span>
                                    </router-link>
                                    <div class="follow-area">
                                        <div class="follow followers">
                                            <span>
                                                186k <router-link to="#" class="color-body">followers</router-link>
                                            </span>
                                        </div>
                                        <div class="follow following">
                                            <span>
                                                156 <router-link to="#" class="color-body">following</router-link>
                                            </span>
                                        </div>
                                    </div>
                                    <div class="author-button-area">
                                        <span class="btn at-follw follow-button">
                                            <i class="feather-user-plus" data-feather="user-plus"/> Follow
                                        </span>
                                        <span class="btn at-follw share-button"
                                              data-bs-toggle="modal"
                                              data-bs-target="#shareModal">
                                            <i class="feather-share-2"/>
                                        </span>
                                        <div class="count at-follw d-inline-flex align-items-center">
                                            <div class="share-btn share-btn-activation dropdown">
                                                <button class="icon" data-bs-toggle="dropdown" aria-expanded="false">
                                                    <i class="feather-more-horizontal"/>
                                                </button>
                                                <div class="share-btn-setting dropdown-menu dropdown-menu-end">
                                                    <button type="button"
                                                            class="btn-setting-text report-text"
                                                            data-bs-toggle="modal"
                                                            data-bs-target="#reportModal">
                                                        Report
                                                    </button>
                                                    <button type="button" class="btn-setting-text report-text">
                                                        Claim Ownership
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                        <router-link to="/edit-profile" class="btn at-follw follow-button edit-btn">
                                            <i class="feather-edit"/>
                                        </router-link>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="rn-authore-profile-area">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="tab-wrapper-one">
                            <nav class="tab-button-one">
                                <div class="nav nav-tabs" id="nav-tab" role="tablist">
                                    <button class="nav-link"
                                            id="nav-home-tab"
                                            data-bs-toggle="tab"
                                            data-bs-target="#nav-home"
                                            type="button" role="tab"
                                            aria-controls="nav-home"
                                            aria-selected="false">
                                        On Sale
                                    </button>
                                    <button class="nav-link active"
                                            id="nav-profile-tab"
                                            data-bs-toggle="tab"
                                            data-bs-target="#nav-profile"
                                            type="button"
                                            role="tab"
                                            aria-controls="nav-profile"
                                            aria-selected="true">
                                        Owned
                                    </button>
                                    <button class="nav-link"
                                            id="nav-contact-tab"
                                            data-bs-toggle="tab"
                                            data-bs-target="#nav-contact"
                                            type="button"
                                            role="tab"
                                            aria-controls="nav-contact"
                                            aria-selected="false">
                                        Created
                                    </button>
                                    <button class="nav-link"
                                            id="nav-liked-tab"
                                            data-bs-toggle="tab"
                                            data-bs-target="#nav-liked"
                                            type="button" role="tab"
                                            aria-controls="nav-liked"
                                            aria-selected="false">
                                        Liked
                                    </button>
                                </div>
                            </nav>
                        </div>
                    </div>
                </div>

                <div class="tab-content rn-bid-content" id="nav-tabContent">
                    <div class="tab-pane row g-5 d-flex fade"
                         id="nav-home"
                         role="tabpanel"
                         aria-labelledby="nav-home-tab">
                        <div class="col-5 col-lg-4 col-md-6 col-sm-6 col-12"
                             v-for="(product, index) in author.products.onSale"
                             :key="`product-item-${index}`">
                            <product-card
                                :product-date="product"
                                product-style-class="no-overlay with-placeBid"
                                :show-place-bid="true"
                            />
                        </div>
                    </div>
                    <div class="tab-pane row g-5 d-flex fade show active"
                         id="nav-profile"
                         role="tabpanel"
                         aria-labelledby="nav-profile-tab">
                        <div class="col-5 col-lg-4 col-md-6 col-sm-6 col-12"
                             v-for="(product, index) in author.products.owned"
                             :key="`product-item-${index}`">
                            <product-card
                                :product-date="product"
                                product-style-class="no-overlay with-placeBid"
                                :show-place-bid="true"
                            />
                        </div>
                    </div>
                    <div class="tab-pane row g-5 d-flex fade"
                         id="nav-contact"
                         role="tabpanel"
                         aria-labelledby="nav-contact-tab">
                        <div class="col-5 col-lg-4 col-md-6 col-sm-6 col-12"
                             v-for="(product, index) in author.products.created"
                             :key="`product-item-${index}`">
                            <product-card
                                :product-date="product"
                                product-style-class="no-overlay with-placeBid"
                                :show-place-bid="true"
                            />
                        </div>
                    </div>
                    <div class="tab-pane row g-5 d-flex fade"
                         id="nav-liked"
                         role="tabpanel"
                         aria-labelledby="nav-contact-tab">
                        <div class="col-5 col-lg-4 col-md-6 col-sm-6 col-12"
                             v-for="(product, index) in author.products.liked"
                             :key="`product-item-${index}`">
                            <product-card
                                :product-date="product"
                                product-style-class="no-overlay with-placeBid"
                                :show-place-bid="true"
                            />
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <share-modal/>

        <report-modal/>
    </layout>
</template>

<script>
    import ShareModal from '@/components/modal/ShareModal'
    import ReportModal from '@/components/modal/ReportModal'
    import AuthorMixin from '@/mixins/AuthorMixin'
    import Layout from '@/components/layouts/Layout'
    import ProductCard from '@/components/product/ProductCard'

    export default {
        name: 'AuthorDetails',
        components: {ProductCard, Layout, ReportModal, ShareModal},
        mixins: [AuthorMixin],
        data() {
            return {
                id: this.$route.params.id,
                author: {}
            }
        },
        methods: {
            getAuthor(authorId) {
                this.author = this.authors.find(item => item.id == authorId);
            }
        },
        created() {
            this.getAuthor(this.id);
        }
    }
</script>