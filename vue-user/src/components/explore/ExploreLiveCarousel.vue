<template>
    <div class="rn-live-bidding-area">
        <div class="container">
            <carousel v-if="programs.length !== 0" class="portfolio-slider"
                      :items-to-show="1"
                      :wrap-around="true"
                      :breakpoints="breakpoints"
                      >
                <template #addons>
                    <div class="carousel-header">
                        <div class="section-title">
                            <h3 class="title mb--0 live-bidding-title" data-sal-delay="150" data-sal="slide-up" data-sal-duration="800">
                                {{ title }}
                            </h3>
                        </div>
                        <div class="carousel-navigation">
                            <navigation/>
                        </div>
                    </div>
                </template>
                <slide v-for="(program, index) in programs" :key="`program-${index}`">
                    <program-card
                        :program="program"
                        :school="program.school"
                        :is-liked-obj="isLiked(program.id)"
                        :is-recommended="true"
                        :is-program-selected="isProgramSelected(program.id)"
                        @reloadData="reloadData"
                    />
                </slide>
            </carousel>
        </div>
    </div>
</template>

<script>
    import 'vue3-carousel/dist/carousel.css'
    import { Carousel, Slide, Navigation } from 'vue3-carousel'
    import ProductCard from '@/components/product/ProductCard'
    import {getRecommendedProgramsByCF, getRecommendedProgramsByKNN} from "@/api/recommendation";
    import ProgramCard from "@/components/myComp/program/ProgramCard";
    import LikeMixin from "@/mixins/user/LikeMixin";
    import profileApi from "@/api/profile";

    export default {
        name: 'ExploreLiveCarousel',
        mixins: [LikeMixin],
        components: {
            ProductCard,
            Carousel,
            Slide,
            Navigation,
            ProgramCard,
        },
        props: {
            title: {
                type: String,
                default: 'Recommend By CF'
            },
            showPlaceBid: {
                type: Boolean,
                default: false
            }
        },
        created() {
          // init the liked program list
          this.getLikedPrograms();
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
                      }
                  },
                  programs: [],
              }
          },
          methods: {
              getPrograms() {
                  console.log("start")
                  getRecommendedProgramsByCF().then(response => {
                      this.programs = response.data.data
                  })
              },

              getUserSelectedPrograms() {
                // call the api method
                profileApi.getSelectedPrograms()
                    .then(response => {

                      // get the list of user selected programs
                      this.selectedPrograms = response.data.selectedPrograms;
                      // reset the selectedProgramIDs list to empty
                      this.selectedProgramIDs = [];
                      // initialize the list of selected program id
                      for (let k in this.selectedPrograms) {
                        this.selectedProgramIDs.push(this.selectedPrograms[k].id);
                      }

                    })
              },

              reloadData() {
                // tell the parent to fetch data again
                // (this contains the reload of user selected programs in this component)
                this.$emit("reloadData");
                // reload likes
                this.getLikedPrograms();
              },

              // check whether the application list contains a program
              isProgramSelected(programId) {
                return this.selectedProgramIDs.includes(programId);
              },
          }
    }
</script>
