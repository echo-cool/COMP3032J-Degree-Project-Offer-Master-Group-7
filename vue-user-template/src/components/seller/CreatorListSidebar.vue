<template>
    <div class="rn-creators-area right-fix-notice creators mt--30">
        <div class="h--100">
            <div class="notice-heading">
                <h4>Top Artist</h4>
                <nice-select
                    :options="[
                        {value: 'today', text: 'Today'},
                        {value: 'seven-days', text: '7 Day\'s'},
                        {value: '30-days', text: '30 Days'},
                        {value: '6-months', text: '6 Month\'s'}
                    ]"
                    :default-current="0"
                    placeholder="Sort by time"
                    name="like"
                />
            </div>
        </div>
        <div class="rn-notification-wrapper creators">
            <div class="top-seller-inner-one"
                 v-for="(creator, index) in creatorsList"
                 :key="`creator-${index}`">
                <div class="top-seller-wrapper">
                    <div :class="[`thumbnail`, {'varified': creator.isVerified}]">
                        <router-link :to="`/author/${creator.id}`">
                            <img :src="creator.image" alt="Nft_Profile">
                        </router-link>
                    </div>
                    <div class="top-seller-content">
                        <router-link :to="`/author/${creator.id}`">
                            <h6 class="name">{{ creator.name }}</h6>
                        </router-link>
                        <span class="count-number">
                            {{ creator.sellingAmount }}
                        </span>
                    </div>
                </div>
                <router-link :to="`/author/${creator.id}`" class="btn btn-primary-alta">
                    Follow
                </router-link>
            </div>
        </div>
    </div>
</template>

<script>
    import NiceSelect from '@/components/select/NiceSelect'

    export default {
        name: 'CreatorListSidebar',
        components: {NiceSelect},
        data() {
            return {
                creatorsList: [
                    {
                        id: 1,
                        isVerified: true,
                        image: require(`@/assets/images/client/client-12.png`),
                        name: 'Brodband',
                        sellingAmount: '$2500,000'
                    },
                    {
                        id: 2,
                        isVerified: false,
                        image: require(`@/assets/images/client/client-2.png`),
                        name: 'Ms. Parkline',
                        sellingAmount: '$2300,000'
                    },
                    {
                        id: 3,
                        isVerified: false,
                        image: require(`@/assets/images/client/client-3.png`),
                        name: 'Methods',
                        sellingAmount: '$2100,000'
                    },
                    {
                        id: 4,
                        isVerified: true,
                        image: require(`@/assets/images/client/client-4.png`),
                        name: 'Jone sone',
                        sellingAmount: '$2000,000'
                    },
                    {
                        id: 5,
                        isVerified: false,
                        url: '#',
                        image: require(`@/assets/images/client/client-5.png`),
                        name: 'Siddhart',
                        sellingAmount: '$200,000'
                    },
                    {
                        id: 6,
                        isVerified: true,
                        image: require(`@/assets/images/client/client-6.png`),
                        name: 'Sobuj Mk',
                        sellingAmount: '$2000,000'
                    },
                    {
                        id: 7,
                        isVerified: true,
                        image: require(`@/assets/images/client/client-7.png`),
                        name: 'Trodband',
                        sellingAmount: '$2500,000'
                    },
                    {
                        id: 8,
                        isVerified: true,
                        image: require(`@/assets/images/client/client-8.png`),
                        name: 'Yash',
                        sellingAmount: '$2500,000'
                    },
                    {
                        id: 9,
                        isVerified: false,
                        image: require(`@/assets/images/client/client-9.png`),
                        name: 'YASHKIB',
                        sellingAmount: '$2500,000'
                    },
                    {
                        id: 10,
                        isVerified: true,
                        image: require(`@/assets/images/client/client-10.png`),
                        name: 'Brodband',
                        sellingAmount: '$2500,000'
                    }
                ],
            }
        }
    }
</script>