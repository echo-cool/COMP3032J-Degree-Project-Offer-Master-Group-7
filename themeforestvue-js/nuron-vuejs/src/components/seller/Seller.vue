<template>
    <div class="top-seller-inner-one" :class="sellerStyleClass">
        <div class="top-seller-wrapper">
            <div :class="[`thumbnail`, {'varified': sellerData.isVerified}]">
                <router-link :to="`/author/${sellerData.id}`">
                    <img :src="sellerData.image" alt="Nft_Profile">
                </router-link>
            </div>
            <div class="top-seller-content">
                <router-link :to="`/author/${sellerData.id}`">
                    <h6 class="name">{{ sellerData.name }}</h6>
                </router-link>
                <span class="count-number">
                    {{ sellerData.sellingAmount }}
                </span>
            </div>
        </div>
        <router-link
            v-if="sellerStyleClass === 'explore'"
            class="over-link"
            :to="`/author/${sellerData.id}`"
        />
    </div>
</template>

<script>
    export default {
        name: 'Seller',
        props: {
            sellerData: {},
            sellerStyleClass: {
                type: String
            }
        }
    }
</script>