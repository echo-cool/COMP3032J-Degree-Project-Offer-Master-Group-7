<template>
    <div :class="[`lg-product-wrapper product-list-card`, {'colum-2 two-colum-parent-product col-lg-6': showTwoColumn}]">
        <div class="inner">
            <div class="lg-left-content">
                <router-link :to="`/product/${productDate.id}`" class="thumbnail">
                    <img :src="productDate.productImage" :alt="productDate.productName" @load="$emit('handleImageLoad')">
                </router-link>
                <div class="read-content">
                    <div class="product-share-wrapper">
                        <div class="profile-share">
                            <router-link v-for="(author, index) in productDate.authors"
                                         :key="`author-${index}`"
                                         :to="`/author/${author.id}`"
                                         class="avatar"
                                         :data-tooltip="author.name">
                                <img :src="author.image" :alt="author.name">
                            </router-link>
                            <router-link to="#" class="more-author-text">
                                {{ productDate.biddingAmount }}+ Place Bit.
                            </router-link>
                        </div>
                        <div class="last-bid">{{ productDate.lastBid }}</div>
                    </div>
                    <router-link :to="`/product/${productDate.id}`">
                        <h6 class="title">{{ productDate.productName }}</h6>
                    </router-link>
                    <span class="latest-bid">{{ productDate.latestBid }}</span>
                    <div class="share-wrapper d-flex">
                        <div class="react-area mr--15">
                            <i class="feather-heart"/>
                            <span class="number">{{ productDate.reacted }}</span>
                        </div>
                        <div class="share-btn share-btn-activation dropdown">
                            <button class="icon" data-bs-toggle="dropdown" aria-expanded="false">
                                <i class="feather-more-horizontal"/>
                            </button>
                            <div class="share-btn-setting dropdown-menu dropdown-menu-end">
                                <button type="button"
                                        class="btn-setting-text share-text"
                                        data-bs-toggle="modal"
                                        data-bs-target="#shareModal">
                                    Share
                                </button>
                                <button type="button"
                                        class="btn-setting-text report-text"
                                        data-bs-toggle="modal"
                                        data-bs-target="#reportModal">
                                    Report
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <button type="button"
                    class="btn btn-primary-alta mr--30"
                    data-bs-toggle="modal"
                    data-bs-target="#placebidModal">
                Place a Bid
            </button>
        </div>
    </div>
</template>

<script>
    import Countdown from '@/components/product/Countdown'

    export default {
        name: 'ProductListCard',
        components: {Countdown},
        props: {
            productDate: {},
            productStyleClass: {
                type: String
            },
            showPlaceBid: {
                type: Boolean,
                default: false
            },
            showTwoColumn: {
                type: Boolean,
                default: false
            }
        }
    }
</script>