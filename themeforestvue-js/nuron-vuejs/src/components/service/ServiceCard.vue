<template>
    <div class="rn-service-one color-shape-7" data-sal="slide-up" data-sal-delay="150" data-sal-duration="800">
        <div class="inner">
            <div class="icon">
                <img :src="serviceData.image" alt="Shape">
            </div>
            <div class="subtitle">{{ serviceData.subtitle }}</div>
            <div class="content">
                <h4 class="title">
                    <router-link :to="serviceData.link">{{ serviceData.title }}</router-link>
                </h4>
                <p class="description">{{ serviceData.description }}</p>
                <router-link class="read-more-button" :to="serviceData.link">
                    <i class="feather-arrow-right"/>
                </router-link>
            </div>
        </div>
        <router-link class="over-link" :to="serviceData.link"></router-link>
    </div>
</template>

<script>
    export default {
        name: 'ServiceCard',
        props: {
            serviceData: {}
        }
    }
</script>