<template>
    <layout>
        <div class="rn-activity-area rn-section-gapTop">
            <div class="container">
                <div class="row mb--30">
                    <h3 class="title">All following Activity</h3>
                </div>
                <div class="row g-6 activity-direction">
                    <div class="col-lg-8 mb_dec--15">
                        <div class="single-activity-wrapper"
                             v-for="(activity, index) in activityList"
                             :key="`activity-${index}`">
                            <div class="inner">
                                <div class="read-content">
                                    <div class="thumbnail">
                                        <router-link :to="`/product/${activity.id}`">
                                            <img :src="activity.image" alt="Nft_Profile">
                                        </router-link>
                                    </div>
                                    <div class="content">
                                        <router-link :to="`/product/${activity.id}`">
                                            <h6 class="title">{{ activity.name }}</h6>
                                        </router-link>
                                        <p v-html="activity.description"></p>
                                        <div class="time-maintane">
                                            <div class="time data">
                                                <i class="feather-clock me-1"/>
                                                <span>{{ activity.time }}</span>
                                            </div>
                                            <div class="user-area data">
                                                <i class="feather-user me-1"/>
                                                <router-link :to="`/author/1`">{{ activity.author }}</router-link>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="icone-area">
                                    <i :class="activity.icon"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="filter-wrapper">
                            <div class="widge-wrapper rbt-sticky-top-adjust">
                                <div class="inner">
                                    <h3>Market filter</h3>
                                    <div class="sing-filter">
                                        <button>Purchases</button>
                                        <button>Sales</button>
                                        <button>Followers</button>
                                        <button>Following</button>
                                        <button>Reserved</button>
                                        <button>Live Auction</button>
                                    </div>
                                </div>
                                <div class="inner">
                                    <h3>Filter by users</h3>
                                    <div class="sing-filter">
                                        <button>Love</button>
                                        <button>Saved</button>
                                        <button>Support us</button>
                                        <button>Report</button>
                                        <button>Vedio</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </layout>
</template>

<script>
    import Layout from '@/components/layouts/Layout'

    export default {
        name: 'Activity',
        components: {Layout},
        data() {
            return {
                activityList: [
                    {
                        id: 1,
                        image: require(`@/assets/images/activity/activity-01.jpg`),
                        name: 'Diamond Dog',
                        description: `10 editions listed by Bits for <span>2.50 ETH</span> each`,
                        time: '2:30 PM on 19th June,',
                        author: 'John Lee',
                        icon: 'feather-thumbs-up'
                    },
                    {
                        id: 2,
                        image: require(`@/assets/images/activity/activity-02.jpg`),
                        name: 'New Diamond Dog',
                        description: `10 editions listed by Bits for <span>2.50 ETH</span> each`,
                        time: '12:30 PM on 19th June,',
                        author: 'Mark Jone',
                        icon: 'feather-user-plus'
                    },
                    {
                        id: 3,
                        image: require(`@/assets/images/activity/activity-03.jpg`),
                        name: 'Shopping Car',
                        description: `Last editions listed by Bits for <span>3.50 ETH</span> each`,
                        time: '1:30 PM on 19th June,',
                        author: 'Mark Lee',
                        icon: 'feather-heart'
                    },
                    {
                        id: 4,
                        image: require(`@/assets/images/activity/activity-04.jpg`),
                        name: 'Nuron Scare',
                        description: `Listed by Bits for <span>6.50 ETH</span> each`,
                        time: '9:30 PM on 19th jan, 2001',
                        author: 'Moshiur Joo',
                        icon: 'feather-shopping-cart'
                    },
                    {
                        id: 5,
                        image: require(`@/assets/images/activity/activity-05.jpg`),
                        name: 'Sufining saffer',
                        description: `New editions listed by Bits for <span>9.50 ETH</span> each`,
                        time: '2:30 PM on 19th June,',
                        author: 'John Lee',
                        icon: 'feather-user-minus'
                    },
                    {
                        id: 6,
                        image: require(`@/assets/images/activity/activity-06.jpg`),
                        name: 'Diamond Dog',
                        description: `10 editions listed by Bits for <span>2.50 ETH</span> each`,
                        time: '2:30 PM on 19th June',
                        author: 'John Lee',
                        icon: 'feather-thumbs-up'
                    },
                    {
                        id: 7,
                        image: require(`@/assets/images/activity/activity-01.jpg`),
                        name: 'Cat Food',
                        description: `New Discover listed by Bits for <span>2.50 ETH</span> each`,
                        time: '2:30 PM on 19th June,',
                        author: 'John Lee',
                        icon: 'feather-heart'
                    },
                    {
                        id: 8,
                        image: require(`@/assets/images/activity/activity-02.jpg`),
                        name: 'Sun Afford',
                        description: `10 editions listed by Bits for <span>2.50 ETH</span> each`,
                        time: '2:30 PM on 19th June',
                        author: 'John Lee',
                        icon: 'feather-shopping-cart'
                    }
                ]
            }
        }
    }
</script>