<template>
    <div :class="`product-style-one ${productStyleClass}`">
        <div class="card-thumbnail">
            <router-link :to="`/school-details/${productDate.id}`">
              <div class="text-center" style="display: flex; justify-content: center; align-content: center; align-items: center">
                <b-spinner label="Spinning" style="position: absolute; width: 40px; height: 40px; z-index: 0"></b-spinner>

                <img style="height: 150px; position: relative; z-index: 4" :src="`/backend/static/`+productDate.img" :alt="productDate.name" @load="$emit('handleImageLoad')">
              </div>
            </router-link>
            <countdown v-if="productDate.countdown" :date="productDate.countdown.date"/>
            <router-link v-if="showPlaceBid" :to="`/school-details/${productDate.id}`" class="btn btn-primary">
                Place Bid
            </router-link>
        </div>
        <div class="product-share-wrapper">
<!--            <div class="profile-share">-->
<!--                <router-link v-for="(author, index) in productDate.programs"-->
<!--                             :key="`author-${index}`"-->
<!--                             :to="`/program/${author.id}`"-->
<!--                             class="avatar"-->
<!--                             :data-tooltip="author.name">-->
<!--                    <img :src="`/backend/static/`+author.img" :alt="author.name">-->
<!--                </router-link>-->
<!--&lt;!&ndash;                <router-link to="#" class="more-author-text">&ndash;&gt;-->
<!--&lt;!&ndash;                    {{ productDate.biddingAmount }}+ Place Bit.&ndash;&gt;-->
<!--&lt;!&ndash;                </router-link>&ndash;&gt;-->
<!--            </div>-->
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
        <router-link :to="`/${productType}/${productDate.id}`">
            <span class="product-name">{{ productDate.name }}</span>
        </router-link>
        <span class="latest-bid" v-if="productDate.rankQS">QS Ranking: {{ productDate.rankQS }}</span>
        <span class="latest-bid" v-if="productDate.school">From: {{ productDate.school.name }}</span>
        <div class="bid-react-area">
            <div class="last-bid" v-if="productDate.rankUSNews">US News: {{ productDate.rankUSNews }}#</div>
            <div class="react-area">
                <i class="feather-heart"/>
                <span class="number">{{ productDate.likesNumber }}</span>
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
            productType:{
              type: String,
              default: "school-details",
            },
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
