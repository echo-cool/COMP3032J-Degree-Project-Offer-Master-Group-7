<template>
    <div class="rn-product-area rn-section-gapTop">
        <div class="container">
            <div class="row mb--30 align-items-center">
                <div class="col-12">
                    <h3 class="title mb--0" data-sal-delay="150" data-sal="slide-up" data-sal-duration="800">
                        Explore Graduate Programs
                    </h3>
                </div>
            </div>

            <div class="default-exp-wrapper">
                <div class="inner">
                    <div class="filter-select-option">
                        <label class="filter-leble">LIKES</label>
                        <nice-select
                            :options="[
                                    { value: 'most-liked', text: 'Most liked' },
                                    { value: 'least-liked', text: 'Least liked' }
                                ]"
                            :default-current="0"
                            placeholder="Sort by likes"
                            name="like"
                            @onChange="changeLikes"
                        />
                    </div>

                    <div class="filter-select-option">
                        <label class="filter-leble">Degree</label>
                        <nice-select
                            :options="[
                                    {value: 'all', text: 'All Degrees'},
                                    {value: 'art', text: 'Art'},
                                    {value: 'music', text: 'Music'},
                                    {value: 'video', text: 'Video'},
                                    {value: 'collectionable', text: 'Collectionable'}
                                ]"
                            :default-current="0"
                            placeholder="Category"
                            name="category"
                            @onChange="changeCategory"
                        />
                    </div>

                    <div class="filter-select-option">
                        <label class="filter-leble">Major</label>
                        <nice-select
                            :options="[
                                    {value: 'all', text: 'All Majors'},
                                    {value: 'Art Decco', text: 'Art Decco'},
                                    {value: 'BoredApeYachtClub', text: 'BoredApeYachtClub'},
                                    {value: 'MutantApeYachtClub', text: 'MutantApeYachtClub'},
                                    {value: 'Art Blocks Factory', text: 'Art Blocks Factory'}
                                ]"
                            :default-current="0"
                            placeholder="Collections"
                            name="collection"
                            @onChange="changeCollection"
                        />
                    </div>

                    <div class="filter-select-option">
                        <label class="filter-leble">School type</label>
                        <nice-select
                            :options="[
                                    {value: 'all', text: 'All Types'},
                                    {value: 'fixed-price', text: 'Fixed price'},
                                    {value: 'timed-auction', text: 'Timed auction'},
                                    {value: 'not-for-sale', text: 'Not for sale'},
                                    {value: 'open-for-offers', text: 'Open for offers'}
                                ]"
                            :default-current="0"
                            placeholder="Sale type"
                            name="sale_type"
                            @onChange="changeSaleType"
                        />
                    </div>

                    <div class="filter-select-option">
                        <label class="filter-leble">Average GPA Range</label>
                        <div class="price_filter s-filter clear">
                            <form action="#" method="GET">
                                <g-p-a-range-slider
                                    @onChangeRange="onChangeRange"
                                    @filterPrice="filterPrice"
                                />
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row g-5"
                 data-sal="slide-up"
                 data-sal-delay="150"
                 data-sal-duration="800">
                <template v-for="(product, index) in filteredProducts"
                          :key="`product-item-${index}`">
                    <div v-if="index < 10" class="col-5 col-lg-4 col-md-6 col-sm-6 col-12">
                        <product-card
                            :product-date="product"
                            product-style-class="no-overlay with-placeBid"
                            :show-countdown="false"
                            :show-place-bid="true"
                        />
                    </div>
                </template>
                <h3 v-if="!filteredProducts.length" class="text-center">No Match Found</h3>
            </div>
        </div>
    </div>
</template>

<script>
    import RangeSlider from '@/components/range/RangeSlider'
    import GPARangeSlider from "@/components/myComp/program/GPARangeSlider.vue";
    import NiceSelect from '@/components/select/NiceSelect'
    import ProductCard from '@/components/product/ProductCard'
    import ProductFilterMixin from '@/mixins/ProductFilterMixin'

    export default {
        name: 'ExploreFilterWithPlacebid',
        components: {GPARangeSlider, NiceSelect, ProductCard},
        mixins: [ProductFilterMixin]
    }
</script>
