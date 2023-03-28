<template>
    <carousel v-if="schools.length>0" :items-to-show="1"
              :wrap-around="true">
        <slide v-for="(school, index) in schools"
               :key="index">
            <div class="slider-thumbnail thumbnail-overlay">
                <router-link :to="`/school-details/${school.id}`">
                    <img class="w-100" :src="`/backend/static/` + school.img" alt="NFT_portfolio">
                </router-link>
                <div class="read-wrapper">
                    <h5>
                        {{ school.name }}
                    </h5>
                    <span>QS Ranking: {{ school.rankQS }}</span>
                </div>
            </div>
        </slide>
        <template #addons>
            <Pagination/>
        </template>
    </carousel>
</template>

<script>
    import 'vue3-carousel/dist/carousel.css'
    import {Carousel, Slide, Navigation, Pagination} from 'vue3-carousel'
    import request from "@/utils/request";

    let schools;
    export default {
        name: 'CarouselFour',
        components: {Pagination, Carousel, Slide, Navigation},
        data() {
            return {
                schools:[
                  // {
                  //   name:"mzxsnd"
                  // }
                ]
            }
        },
        created() {
          this.getData();
        },

        methods:{
          getData(){
            let that = this;
            request({
              url: "/api/school/public/getRandomSchools/4",
              method: 'get'
            }).then(function (res){
              console.log(res.data.schools);
              that.schools = res.data.schools;
            });

          }

        }
    }
</script>
