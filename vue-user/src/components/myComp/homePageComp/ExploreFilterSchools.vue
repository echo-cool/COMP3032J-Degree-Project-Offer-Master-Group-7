
<template>
  <div class="rn-product-area rn-section-gapTop">
    <div class="container">
      <div class="row mb--30 align-items-center">
        <div class="col-12">
          <h3 class="title mb--0" data-sal-delay="150" data-sal="slide-up" data-sal-duration="800">
            Explore Schools
          </h3>
        </div>
      </div>


      <div class="row g-5"
           data-sal="slide-up"
           data-sal-delay="150"
           data-sal-duration="800">
        <template v-for="(school, index) in schools"
                  :key="`school-item-${index}`">
          <div class="col-5 col-lg-4 col-md-6 col-sm-6 col-12">
            <!--                        <product-card-->
            <!--                            :product-date="product"-->
            <!--                            product-style-class="no-overlay with-placeBid"-->
            <!--                            :show-countdown="false"-->
            <!--                            :show-place-bid="true"-->
            <!--                        />-->
            <school-card  :school="school"
                          />
          </div>
        </template>
        <div v-if="!schools.length">
          <div  class="d-flex justify-content-center">
            <div class="spinner-border" role="status" style="zoom: 5">

            </div>
          </div>
          <div class="m-5 d-flex justify-content-center">
            <h2>Loading...</h2>
          </div>
        </div>
        <!--                <h3 v-if="!programs.length" class="text-center">No Match Found</h3>-->
      </div>
    </div>
  </div>
</template>

<script>
import GPARangeSlider from "@/components/myComp/program/GPARangeSlider.vue";
import NiceSelect from '@/components/select/NiceSelect'
import ProductCard from '@/components/product/ProductCard'
import ProductFilterMixin from '@/mixins/ProductFilterMixin'
import schoolApi from "@/api/shool";
import LikeMixin from "@/mixins/user/LikeMixin";
import SchoolCard from "@/components/myComp/school/SchoolCard";

export default {
  name: 'ExploreFilterSchools',
  components: {
    SchoolCard,
    GPARangeSlider,
    NiceSelect,
    ProductCard
  },
  props: {
    currentUser: {}
  },
  mixins: [ProductFilterMixin, LikeMixin],
  data() {
    return {
      // likedPrograms: [],
      // likedProgramIds: [],
      schools: []
    }
  },
  created() {
    // this.$isLoading(true) // show loading screen
    // this.programQuery.query = this.query
    this.getSchools();
    // if (this.currentUser.id) {
    //   // init the liked program list
    //   this.getLikedPrograms();
    // }
  },
  methods: {

    onChangeLikes(item) {
      this.programQuery.likes = item.value;
      this.filterChangeHandler();
    },
    onChangeDegree(item) {
      this.programQuery.degree = item.value;
      this.filterChangeHandler();
    },
    onChangeMajor(item) {
      this.programQuery.major = item.value;
      this.filterChangeHandler();
    },

    filterChangeHandler() {
      // request the programs again using new query
      this.getSchools();
    },

    getSchools() {

      // call the api method
      schoolApi.getAllSchools()
          .then(response => {
            // update the program list
            this.schools = response.data.schools;
          })
    },

  }
}
</script>
