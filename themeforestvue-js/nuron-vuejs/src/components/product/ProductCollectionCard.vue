<template>
    <router-link :to="productCollectionDate.url" class="rn-collection-inner-one">
        <div class="collection-wrapper">
            <div class="collection-big-thumbnail">
                <img :src="productCollectionDate.thumbnail" alt="Nft_Profile">
            </div>
            <div class="collenction-small-thumbnail">
                <img :src="thumbnail.image"
                     v-for="(thumbnail, index) in productCollectionDate.smallThumbnails"
                     :key="`thumbnail-${index}`"
                     alt="Nft_Profile">
            </div>
            <div class="collection-profile">
                <img :src="productCollectionDate.client" alt="Nft_Profile">
            </div>
            <div class="collection-deg">
                <h6 class="title">{{ productCollectionDate.title }}</h6>
                <span class="items">{{ productCollectionDate.items }} Items</span>
            </div>
        </div>
    </router-link>
</template>

<script>
    export default {
        name: 'ProductCollectionCard',
        props: {
            productCollectionDate: {}
        }
    }
</script>