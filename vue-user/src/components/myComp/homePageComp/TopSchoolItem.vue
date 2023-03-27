<template>
    <div class="top-seller-inner-one" :class="sellerStyleClass" style="height: 100px; overflow: hidden">
        <div class="top-seller-wrapper">
            <div :class="[`thumbnail`, {'varified': false}]">
<!--                <router-link :to="`/author/${sellerData.id}`">-->
                <router-link :to="`#`">
                    <img v-if="school.img" :src="`/backend/static/`+school.img" alt="school-img">
                    <img v-else :src="require(`@/assets/images/client/client-1.png`)" alt="school-img">
                </router-link>
            </div>
            <div class="top-seller-content">
<!--                <router-link :to="`/author/${sellerData.id}`">-->
                <router-link :to="`#`">
                    <h6 class="name" v-if="school.name.length > 20">{{school.name.substring(0,20) + `..` }}</h6>

                    <h6 class="name" v-else>{{school.name}}</h6>
                </router-link>
                <span class="count-number">
                    QS: {{ school.rankQS }}
                </span>
                <span class="count-number">
                    U.S. News: {{ school.rankUSNews }}
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
        name: 'TopSchoolItem',
        props: {
            sellerData: {},
            sellerStyleClass: {
                type: String
            },
            school: {}
        }
    }
</script>
