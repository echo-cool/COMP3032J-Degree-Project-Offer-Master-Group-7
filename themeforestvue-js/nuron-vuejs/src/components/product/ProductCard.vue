<template>
    <div :class="`product-style-one ${productStyleClass}`">
        <div class="card-thumbnail">
            <router-link :to="`/product/${productDate.id}`">
                <img :src="productDate.productImage" :alt="productDate.productName" @load="$emit('handleImageLoad')">
            </router-link>
            <countdown v-if="productDate.countdown" :date="productDate.countdown.date"/>
            <router-link v-if="showPlaceBid" :to="`/product/${productDate.id}`" class="btn btn-primary">
                Place Bid
            </router-link>
        </div>
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
        <router-link :to="`/product/${productDate.id}`">
            <span class="product-name">{{ productDate.productName }}</span>
        </router-link>
        <span class="latest-bid">{{ productDate.latestBid }}</span>
        <div class="bid-react-area">
            <div class="last-bid">{{ productDate.lastBid }}</div>
            <div class="react-area">
                <i class="feather-heart"/>
                <span class="number">{{ productDate.reacted }}</span>
            </div>
        </div>
    </div>
</template>

<script>
    import Countdown from '@/components/product/Countdown';

    export default {
        name: 'ProductCard',
        components: {Countdown},
        props: {
            productDate: {},
            productStyleClass: {
                type: String
            },
            showPlaceBid: {
                type: Boolean,
                default: false
            }
        },
        watch: {
            '$route': function (to, from) {
                this.closeModal()
            }
        },
        methods: {
            closeModal() {
                const modals = document.querySelectorAll('.modal-backdrop');

                if (modals.length) {
                    modals.forEach(item => {
                        item.remove();
                    })
                }
            }
        }
    }
</script>