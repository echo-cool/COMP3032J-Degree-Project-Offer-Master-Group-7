<template>
  <div class="rn-top-top-seller-area nice-selector-transparent">
    <h2 class="title mb--0 live-bidding-title" data-sal-delay="150" data-sal="slide-up"
        data-sal-duration="800">Programs Match Your Application Background
<!--      <nice-select-->
<!--          :options="[-->
<!--              { value: 'knn', text: 'SIMILARITY WITH PROGRAMS' },-->
<!--              { value: 'cf', text: 'SIMILAR USERS\' SELECTIONS' },-->
<!--            ]"-->
<!--          :default-current="0"-->
<!--          name="sellerSort"-->
<!--          @onChange="changeHandler"-->
<!--      />-->
    </h2>
  </div>
  <!--    <nav class="product-tab-nav">-->
  <!--        <div class="nav" id="nav-tab" role="tablist">-->
  <!--            <button :class="[`nav-link`, {'active': activeTabIndex === index}]"-->
  <!--                    :id="`nav-${filterName(navLink.name)}-tab`"-->
  <!--                    data-bs-toggle="tab"-->
  <!--                    :data-bs-target="`#nav-${filterName(navLink.name)}`"-->
  <!--                    type="button"-->
  <!--                    role="tab"-->
  <!--                    :aria-controls="`nav-${filterName(navLink.name)}`"-->
  <!--                    :aria-selected="index === activeTabIndex ? 'true' : 'false'"-->
  <!--                    v-for="(navLink, index) in listItemsTab"-->
  <!--                    :key="`nav-link-${index}`">-->
  <!--                {{ navLink.name }}-->
  <!--            </button>-->
  <!--        </div>-->
  <!--    </nav>-->
  <div class="tab-content" id="nav-tabContent">
    <div
        :class="[`lg-product_tab-pane tab-pane fade`, {'show active': activeTabIndex === index}, {'lg-product-col-2': isTwoColumn}]"
        :id="`program-${filterName(tabPane.name)}`"
        role="tabpanel"
        v-for="(tabPane, index) in listItemsTab"
        :key="`program-link-${index}`">

      <!-- !!! we must load this component after loading all the schools !!! -->
      <!-- !!! Otherwise, the schools would be undefined !!! -->
      <template v-if="programs.length !== 0" v-for="(program, index) in programs"
                :key="`program-${index}`">
        <program-list-card :program="program"
                           :is-program-selected="isProgramSelected(program.id)"
                           :show-two-column="isTwoColumn"
                           :is-liked-obj="isLiked(program.id)"
                           @reloadData="reloadData"/>
      </template>
    </div>
  </div>
</template>

<script>
import ProductMixin from '@/mixins/ProductMixin'
import ProgramListCard from "@/components/myComp/ProgramListCard.vue";
import commonApi from "@/api/common";
import profileApi from "@/api/profile";
import ApplicationListMixin from "@/mixins/user/ApplicationListMixin";
import LikeMixin from "@/mixins/user/LikeMixin";
import {getRecommendedProgramsByCF, getRecommendedProgramsByKNN} from "@/api/recommendation";
import NiceSelect from "@/components/select/NiceSelect";

export default {
  name: 'ProgramListing',
  components: {ProgramListCard, NiceSelect},
  mixins: [ProductMixin, ApplicationListMixin, LikeMixin],
  props: {
    isTwoColumn: {
      type: Boolean,
      default: false
    },
    currentUser: {},
    applications: {
      type: Array,
      default: function () {
        return [];
      }
    }
  },
  data() {
    return {
      activeTabIndex: 0,
      listItemsTab: [
        {
          name: 'All Product',
          items: ''
        },
        {
          name: 'Newest Item',
          items: ''
        },
        {
          name: 'Rare Reals',
          items: ''
        }
      ],

      programs: [],

      selectedPrograms: [],
      selectedProgramIDs: [],

      // schoolLoadNum: 0    // number of schools finished loading

    }
  },
  mounted() {
    this.filterName('All Products')
  },
  created() {
    this.listItemsTab.forEach((item, index) => {
      if (index === 1) {
        item.items = this.products.slice().reverse();
      } else if (index === 2) {
        item.items = this.products.sort(() => Math.random() - 0.5);
      } else {
        item.items = this.products;
      }
    });

    // init the liked program list
    this.getLikedPrograms();
  },

  methods: {
    filterName(name) {
      return name.toLowerCase().replace(' ', '-')
    },

    // get all the programs
    getProgramsKNN() {
      // call the api method
      getRecommendedProgramsByKNN()
          .then(response => {
            // update the programs list
            this.programs = response.data.data;

          })
    },

    getProgramsCF() {
      getRecommendedProgramsByCF()
          .then(response => {
            // update the programs list
            this.programs = response.data.data;

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

    // check whether the application list contains a program
    isProgramSelected(programId) {
      return this.selectedProgramIDs.includes(programId);
    },

    reloadData() {
      // tell the parent to fetch data again
      // (this contains the reload of user selected programs in this component)
      this.$emit("reloadData");
      // reload likes
      this.getLikedPrograms();
    },

    // changeHandler(item) {
    //   console.log(item.value)
    //   if (item.value === "knn") {
    //     this.getProgramsKNN()
    //   }
    //   else if (item.value === "cf") {
    //     this.getProgramsCF()
    //   }
    // }

  }
}
</script>

<style>
 .nice-select {
   float: inherit !important;
   display: inline !important;
  }
</style>
