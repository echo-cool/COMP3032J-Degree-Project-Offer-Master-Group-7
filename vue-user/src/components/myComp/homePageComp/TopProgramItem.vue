<template>
    <div class="top-seller-inner-one" :class="sellerStyleClass">
        <div class="top-seller-wrapper">
            <div :class="[`thumbnail`, {'varified': false}]">
<!--                <router-link :to="`/author/${sellerData.id}`">-->
                <router-link :to="`#`">
                    <img v-if="school.img" :src="school.img" alt="program_pic">
                    <img v-else :src="require(`@/assets/images/client/client-1.png`)" alt="program_pic">
                </router-link>
            </div>
            <div class="top-seller-content">
<!--                <router-link :to="`/author/${sellerData.id}`">-->
                <router-link :to="`#`">
                    <h6 class="name">{{ school.name }}</h6>
                </router-link>
                <span class="count-number">
                    {{ program.name }}
                </span>
            </div>
        </div>
        <router-link
            v-if="sellerStyleClass === 'explore'"
            class="over-link"
            :to="`#`"
        />
    </div>
</template>

<script>
    export default {
        name: 'Program',
        props: {
            sellerStyleClass: {
                type: String
            },
            program: {},
            school: {}      // the school of this program
        }
    }
</script>
