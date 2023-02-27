<template>
    <layout>
        <!-- Start Banner Area -->
        <div class="slider-one rn-section-gapTop">
            <div class="container">
                <div class="row row-reverce-sm align-items-center">
                    <div class="col-lg-5 col-md-6 col-sm-12 mt_sm--50">
                        <h2 class="title" data-sal-delay="200" data-sal="slide-up" data-sal-duration="800">
                            Discover Digital Art, Collect and Sell Your Specific NFTs.
                        </h2>
                        <p class="slide-disc" data-sal-delay="300" data-sal="slide-up" data-sal-duration="800">
                            Partner with one of the world’s largest retailers to showcase your brand and products.
                        </p>
                        <div class="button-group">
                            <router-link class="btn btn-large btn-primary" to="#" data-sal-delay="400" data-sal="slide-up" data-sal-duration="800">
                                Get Started
                            </router-link>
                            <router-link class="btn btn-large btn-primary-alta" to="/create" data-sal-delay="500" data-sal="slide-up" data-sal-duration="800">
                                Create
                            </router-link>
                        </div>
                    </div>
                    <div class="col-lg-5 col-md-6 col-sm-12 offset-lg-1">
                        <div class="slider-thumbnail">
                            <img :src="require(`@/assets/images/slider/slider-1.png`)" alt="Slider Images">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Banner Area -->

        <!-- Start Live Bidding Area -->
        <explore-live-carousel/>
        <!-- End Live Bidding Area -->

        <!-- Start Service Area -->
        <service-style-one/>
        <!-- End Service Area -->

        <!-- Newest Items Area Start -->
        <explore-newest-item/>
        <!-- Newest Items Area End -->

        <!-- Top Seller Start -->
        <seller-style-one/>
        <!-- Top Seller End -->

        <!-- Explore Product Area Start -->
        <explore-filter/>
        <!-- Explore Product Area End -->

        <!-- Collection Area Start -->
        <collection-style-one/>
        <!-- Collection Area End -->

        <share-modal/>

        <report-modal/>
    </layout>
</template>

<script>
    import Layout from '../../components/layouts/Layout'
    import ExploreLiveCarousel from '@/components/explore/ExploreLiveCarousel'
    import ServiceCard from '@/components/service/ServiceCard'
    import ProductCard from '@/components/product/ProductCard'
    import SalScrollAnimationMixin from '@/mixins/SalScrollAnimationMixin'
    import ShareModal from '@/components/modal/ShareModal'
    import ReportModal from '@/components/modal/ReportModal'
    import ExploreFilter from '@/components/explore/ExploreFilter'
    import ServiceStyleOne from '@/components/service/ServiceStyleOne'
    import SellerStyleOne from '@/components/seller/SellerStyleOne'
    import CollectionStyleOne from '@/components/collection/CollectionStyleOne'
    import ExploreNewestItem from '@/components/explore/ExploreNewestItem'

    import test from '@/api/homeTest'

    export default {
        name: 'HomePageOne',
        components: {
            ExploreNewestItem,
            CollectionStyleOne,
            SellerStyleOne,
            ServiceStyleOne,
            ExploreFilter,
            ReportModal,
            ShareModal,
            ProductCard,
            ServiceCard,
            ExploreLiveCarousel,
            Layout
        },
        mixins: [SalScrollAnimationMixin],

        data() {
            return{

            }
        },

        created() {
          this.getList();
        },

        methods:{
          getList(){
            test.testGetUser(1, 1)
                .then(response => { // 请求成功
                  // response 是后端接口返回的数据
                  // 用response里的值初始化data
                  // this.list = response.data.rows
                  // this.total = response.data.total
                  console.log("here");
                  console.log(response.data);
                })
                .catch(error => {   // 请求失败
                  console.log(error)
                })
          }
        }

    }
</script>