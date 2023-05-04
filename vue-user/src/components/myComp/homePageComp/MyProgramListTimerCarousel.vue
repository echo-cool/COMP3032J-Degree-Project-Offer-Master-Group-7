<template>
    <div class="rn-live-bidding-area rn-section-gapTop">
        <div class="container">
            <carousel class="portfolio-slider"
                      :items-to-show="1"
                      :wrap-around="true"
                      :breakpoints="breakpoints">
                <template #addons>
                    <div class="carousel-header">
                        <div class="section-title">
                            <h3 class="title mb--0 live-bidding-title" data-sal-delay="150" data-sal-duration="800">
                                {{ title }}
                            </h3>
                        </div>
                        <div class="carousel-navigation">
                            <navigation/>
                        </div>
                    </div>
                </template>

                <slide v-for="(application, index) in applications" :key="`application-program-${index}`">
                    <program-card
                        :program="application.program"
                        :school="application.program.school"
                        :show-d-d-l-countdown="true"
                        :deadline="application.deadline"
                        :is-liked-obj="isLiked(application.program.id)"
                    />
                </slide>
            </carousel>
        </div>
    </div>
</template>

<script>
import 'vue3-carousel/dist/carousel.css'
import {Carousel, Navigation, Slide} from 'vue3-carousel'
import ProgramCard from "@/components/myComp/program/ProgramCard.vue";
import LikeMixin from "@/mixins/user/LikeMixin";

export default {
        name: 'MyProgramListTimerCarousel',
        mixins: [
            LikeMixin
        ],
        computed: {

        },
        components: {
            ProgramCard,
            Carousel,
            Slide,
            Navigation,
        },
        props: {
            title: {
                type: String,
                default: 'Programs'
            },
            showPlaceBid: {
                type: Boolean,
                default: false
            },
            applications: {
                type: Array,
                default: function () {
                    return [];
                }
            }
        },
        data() {
            return {
                breakpoints: {
                    576: {
                        itemsToShow: 2,
                        snapAlign: 'left'
                    },
                    768: {
                        itemsToShow: 2,
                        snapAlign: 'left'
                    },
                    992: {
                        itemsToShow: 3,
                        snapAlign: 'left'
                    },
                    1200: {
                        itemsToShow: 4,
                        snapAlign: 'left'
                    },
                    1399: {
                        itemsToShow: 5,
                        snapAlign: 'left'
                    }
                },

            }
        },
        created() {
            // init the liked program list
            // this.getLikedPrograms();
        },
        methods:{

        }
    }
</script>

<style>

.carousel-navigation button{

}

</style>
