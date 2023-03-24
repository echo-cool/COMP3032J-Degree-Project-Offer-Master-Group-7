<template>
    <div :class="`product-style-one`">
        <div class="card-thumbnail">
<!--            <router-link :to="`/product/${productDate.id}`">--> <!-- e.g. -->
            <router-link :to="`#`">
                <img v-if="application.program.school.img" :src="application.program.school.img" :alt="application.program.school.name" @load="$emit('handleImageLoad')">
                <img v-else :src="require(`@/assets/images/portfolio/portfolio-07.jpg`)" :alt="`img`" @load="$emit('handleImageLoad')">
            </router-link>
            <countdown :date="application.deadline"/>
        </div>
        <div class="product-share-wrapper">
            <div class="profile-share">
<!--                <router-link v-for="(author, index) in productDate.authors"-->
<!--                             :key="`author-${index}`"-->
<!--                             :to="`/author/${author.id}`"-->
<!--                             class="avatar"-->
<!--                             :data-tooltip="author.name">-->
<!--                    <img :src="author.image" :alt="author.name">-->
<!--                </router-link>-->
<!--                <router-link to="#" class="more-author-text">-->
<!--                    {{ application.program.name }}+ Place Bit.-->
<!--                </router-link>-->
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
<!--        <router-link :to="`/product/${productDate.id}`">--> <!-- e.g. -->
        <router-link :to="`#`">
            <span class="product-name">{{ application.program.school.name }}</span>
        </router-link>
        <span class="latest-bid">{{ application.program.name }}</span>
        <div class="bid-react-area">
            <div class="last-bid">{{ application.program.degree }}</div>
            <div class="react-area">
                <i class="feather-heart"/>
                <span class="number">{{ application.program.likes }}</span>
            </div>
        </div>
    </div>
</template>

<script>
    import Countdown from "@/components/myComp/program/Countdown.vue";

    export default {
        name: 'ProductCard',
        components: {Countdown},
        props: {
            application: {}
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
