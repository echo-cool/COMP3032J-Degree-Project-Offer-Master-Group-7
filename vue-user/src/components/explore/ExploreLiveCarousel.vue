<template>
    <div class="rn-live-bidding-area">
        <div class="container">
            <h2 v-if="isLoading" class="title mb--0 live-bidding-title" data-sal-delay="150" data-sal="slide-up"
                data-sal-duration="800">
                {{ title }}
            </h2>
            <div v-if="isLoading" style="height: 450px; display: flex; justify-content: center; align-items: center">
                <div class="d-flex justify-content-center" >
                    <div class="spinner-border" role="status" style="zoom: 5;" >
                        <span class="sr-only">Loading...</span>
                    </div>
                </div>
                <div class="m-5 d-flex justify-content-center " >
                    <h2>Loading...</h2>
                </div>
            </div>
            <template v-if="toggle">
                <carousel v-show="!isLoading" v-if="programs.length !== 0" class="portfolio-slider"
                          :items-to-show="1"
                          :wrap-around="true"
                          :breakpoints="breakpoints"
                          @init="handleInit"
                          ref="myCarousel"
                >

        <template #addons>
          <div class="carousel-header">
            <div class="section-title">
              <h3 class="title mb--0 live-bidding-title" data-sal-delay="150" data-sal="slide-up"
                  data-sal-duration="800">
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
              @reloadLike="reloadLike"
          />
        </slide>
      </carousel>
      </template>
    </div>
  </div>
</template>

<script>
import 'vue3-carousel/dist/carousel.css'
import {Carousel, Slide, Navigation} from 'vue3-carousel'
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
            default: 'Guess Your Favorites'
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
            isLoading: false,
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
            selectedPrograms: [],
            selectedProgramIDs: [],
            toggle: true,
            buttonIcon: '<svg class="carousel__icon" viewBox="0 0 24 24" role="img" ariaLabel="arrowRight"><title>arrowRight</title><path d="M8.59 16.59L13.17 12 8.59 7.41 10 6l6 6-6 6-1.41-1.41z"></path></svg>'
        }
    },
    methods: {
        getPrograms() {
            console.log("start")
            this.isLoading = true;
            getRecommendedProgramsByCF().then(response => {
                this.programs = response.data.data
                this.isLoading = false;
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

    reloadLike(programId, isLike) {
      if (isLike) {
        this.addLike(programId)
      }
      else {
        this.removeLike(programId)
      }
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

    handleInit() {
      let button = document.getElementsByClassName("carousel__next");
      button.innerHtml = this.buttonIcon
      console.log(button);
    }
  }
}
</script>

<style scoped>
.carousel__prev {
}
</style>
