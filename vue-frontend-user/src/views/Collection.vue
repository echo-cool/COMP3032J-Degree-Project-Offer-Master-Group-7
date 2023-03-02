<template>
    <layout>
        <breadcrumb title="Our Collection" current="Collection"/>

        <!-- Collection area Start -->
        <div class="rn-collection-area rn-section-gapTop">
            <div class="container">
                <div class="row g-5">
                    <div class="col-lg-4 col-xl-3 col-md-6 col-sm-6 col-12"
                         v-for="(collection, index) in collectionList"
                         :key="`collection-${index}`">
                        <product-collection-card :product-collection-date="collection"/>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-12">
                        <pagination/>
                    </div>
                </div>
            </div>
        </div>
        <!-- Collection area End -->
    </layout>
</template>

<script>
    import Layout from '@/components/layouts/Layout'
    import Breadcrumb from '@/components/breadcrumb/Breadcrumb'
    import ProductCollectionCard from '@/components/product/ProductCollectionCard'
    import CollectionMixin from '@/mixins/CollectionMixin'
    import Pagination from '@/components/pagination/pagination'

    export default {
        name: 'Collection',
        components: {Pagination, ProductCollectionCard, Breadcrumb, Layout},
        mixins: [CollectionMixin]
    }
</script>