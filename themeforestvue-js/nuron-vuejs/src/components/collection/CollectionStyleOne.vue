<template>
    <div class="rn-collection-area rn-section-gapTop">
        <div class="container">
            <div class="row mb--50 align-items-center">
                <div class="col-lg-6 col-md-6 col-sm-6 col-12">
                    <h3 class="title mb--0" data-sal-delay="150" data-sal="slide-up" data-sal-duration="800">
                        Top Collection
                    </h3>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6 col-12 mt_mobile--15">
                    <div class="view-more-btn text-start text-sm-end" data-sal-delay="150" data-sal="slide-up"
                         data-sal-duration="800">
                        <router-link class="btn-transparent" to="/collection">
                            VIEW ALL <i class="feather-arrow-right"/>
                        </router-link>
                    </div>
                </div>
            </div>

            <div class="row g-5">
                <div class="col-lg-4 col-xl-3 col-md-6 col-sm-6 col-12"
                     v-for="(collection, index) in topCollectionList"
                     :key="`collection-${index}`"
                     data-sal="slide-up"
                     :data-sal-delay="150+index"
                     data-sal-duration="800">
                    <product-collection-card :product-collection-date="collection"/>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import ProductCollectionCard from '@/components/product/ProductCollectionCard'

    export default {
        name: 'CollectionStyleOne',
        components: {ProductCollectionCard},
        data() {
            return {
                topCollectionList: [
                    {
                        url: '/collection',
                        thumbnail: require(`@/assets/images/collection/collection-lg-01.jpg`),
                        smallThumbnails: [
                            {image: require(`@/assets/images/collection/collection-sm-01.jpg`)},
                            {image: require(`@/assets/images/collection/collection-sm-02.jpg`)},
                            {image: require(`@/assets/images/collection/collection-sm-03.jpg`)}
                        ],
                        client: require(`@/assets/images/client/client-15.png`),
                        title: 'Cubic Trad',
                        items: '27'
                    },
                    {
                        url: '/collection',
                        thumbnail: require(`@/assets/images/collection/collection-lg-02.jpg`),
                        smallThumbnails: [
                            {image: require(`@/assets/images/collection/collection-sm-04.jpg`)},
                            {image: require(`@/assets/images/collection/collection-sm-05.jpg`)},
                            {image: require(`@/assets/images/collection/collection-sm-06.jpg`)}
                        ],
                        client: require(`@/assets/images/client/client-12.png`),
                        title: 'Diamond Dog',
                        items: '20'
                    },
                    {
                        url: '/collection',
                        thumbnail: require(`@/assets/images/collection/collection-lg-03.jpg`),
                        smallThumbnails: [
                            {image: require(`@/assets/images/collection/collection-sm-07.jpg`)},
                            {image: require(`@/assets/images/collection/collection-sm-08.jpg`)},
                            {image: require(`@/assets/images/collection/collection-sm-09.jpg`)}
                        ],
                        client: require(`@/assets/images/client/client-13.png`),
                        title: 'Morgan11',
                        items: '15'
                    },
                    {
                        url: '/collection',
                        thumbnail: require(`@/assets/images/collection/collection-lg-05.jpg`),
                        smallThumbnails: [
                            {image: require(`@/assets/images/collection/collection-sm-10.jpg`)},
                            {image: require(`@/assets/images/collection/collection-sm-11.jpg`)},
                            {image: require(`@/assets/images/collection/collection-sm-12.jpg`)}
                        ],
                        client: require(`@/assets/images/client/client-14.png`),
                        title: 'Orthogon#720',
                        items: '10'
                    }
                ]
            }
        }
    }
</script>