<template>
    <div class="logo-thumbnail logo-custom-css">
        <router-link class="logo-light" to="/">
            <img :src="require(`@/assets/images/logo/logo-white.png`)" alt="nft-logo">
        </router-link>
        <router-link class="logo-dark" to="/">
            <img :src="require(`@/assets/images/logo/logo-dark.png`)" alt="nft-logo">
        </router-link>
    </div>
</template>

<script>
    export default {
        name: 'Logo'
    }
</script>