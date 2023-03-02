<template>
    <div class="rn-notification-area right-fix-notice">
        <div class="h--100">
            <div class="notice-heading">
                <h4>Notification</h4>
                <nice-select
                    :options="[
                        {value: 'newest', text: 'Newest'},
                        {value: 'trending', text: 'Tranding'},
                        {value: 'saved', text: 'Saved'},
                        {value: 'deleted', text: 'Delated'}
                    ]"
                    :default-current="0"
                    placeholder="Sort by likes"
                    name="like"
                />
            </div>
        </div>
        <div class="rn-notification-wrapper">
            <div class="single-notice"
                 v-for="(notification, index) in notificationList"
                 :key="`notification-${index}`">
                <div class="thumbnail">
                    <router-link :to="notification.url">
                        <img :src="notification.img" alt="Images">
                    </router-link>
                </div>
                <div class="content-wrapper">
                    <router-link :to="notification.url">
                        <h6 class="title">{{ notification.title }}</h6>
                    </router-link>
                    <p>{{ notification.description }}</p>
                    <div class="notice-time">
                        <span>{{ notification.date }} </span>
                        <span>{{ notification.time }}</span>
                    </div>
                    <router-link :to="notification.url" class="btn btn-primary-alta">Check Out</router-link>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import NiceSelect from '@/components/select/NiceSelect'

    export default {
        name: 'NotificationListSidebar',
        components: {NiceSelect},
        data() {
            return {
                notificationList: [
                    {
                        url: '/connect',
                        img: require(`@/assets/images/icons/meta.svg`),
                        title: 'Darken Forever Quick',
                        description: 'Has been sold by 1221 ETH',
                        date: '15 July',
                        time: '10:32 PM'
                    },
                    {
                        url: '/connect',
                        img: require(`@/assets/images/client/client-4.png`),
                        title: 'Sold Darken Forever Quick',
                        description: 'Has been sold by 1221 ETH',
                        date: '15 July',
                        time: '10:32 PM'
                    },
                    {
                        url: '/connect',
                        img: require(`@/assets/images/client/client-5.png`),
                        title: 'Sold Darken Forever Quick',
                        description: 'Has been sold by 1221 ETH',
                        date: '15 July',
                        time: '10:32 PM'
                    },
                    {
                        url: '/connect',
                        img: require(`@/assets/images/client/client-6.png`),
                        title: 'Sold Darken Forever Quick',
                        description: 'Has been sold by 1221 ETH',
                        date: '15 July',
                        time: '10:32 PM'
                    },
                    {
                        url: '/connect',
                        img: require(`@/assets/images/client/client-6.png`),
                        title: 'Sold Darken Forever Quick',
                        description: 'Has been sold by 1221 ETH',
                        date: '15 July',
                        time: '10:32 PM'
                    },
                    {
                        url: '/connect',
                        img: require(`@/assets/images/client/client-7.png`),
                        title: 'Sold Darken Forever Quick',
                        description: 'Has been sold by 1221 ETH',
                        date: '15 July',
                        time: '10:32 PM'
                    },
                    {
                        url: '/connect',
                        img: require(`@/assets/images/client/client-8.png`),
                        title: 'Sold Darken Forever Quick',
                        description: 'Has been sold by 1221 ETH',
                        date: '15 July',
                        time: '10:32 PM'
                    },
                    {
                        url: '/connect',
                        img: require(`@/assets/images/client/client-9.png`),
                        title: 'Sold Darken Forever Quick',
                        description: 'Has been sold by 1221 ETH',
                        date: '15 July',
                        time: '10:32 PM'
                    },
                    {
                        url: '/connect',
                        img: require(`@/assets/images/client/client-10.png`),
                        title: 'Sold Darken Forever Quick',
                        description: 'Has been sold by 1221 ETH',
                        date: '15 July',
                        time: '10:32 PM'
                    },
                    {
                        url: '/connect',
                        img: require(`@/assets/images/client/client-11.png`),
                        title: 'Sold Darken Forever Quick',
                        description: 'Has been sold by 1221 ETH',
                        date: '15 July',
                        time: '10:32 PM'
                    },
                    {
                        url: '/connect',
                        img: require(`@/assets/images/client/client-1.png`),
                        title: 'Sold Darken Forever Quick',
                        description: 'Has been sold by 1221 ETH',
                        date: '15 July',
                        time: '10:32 PM'
                    },
                    {
                        url: '/connect',
                        img: require(`@/assets/images/client/client-2.png`),
                        title: 'Sold Darken Forever Quick',
                        description: 'Has been sold by 1221 ETH',
                        date: '15 July',
                        time: '10:32 PM'
                    },
                    {
                        url: '/connect',
                        img: require(`@/assets/images/client/client-3.png`),
                        title: 'Sold Darken Forever Quick',
                        description: 'Has been sold by 1221 ETH',
                        date: '15 July',
                        time: '10:32 PM'
                    },
                    {
                        url: '/connect',
                        img: require(`@/assets/images/client/client-4.png`),
                        title: 'Sold Darken Forever Quick',
                        description: 'Has been sold by 1221 ETH',
                        date: '15 July',
                        time: '10:32 PM'
                    },
                    {
                        url: '/connect',
                        img: require(`@/assets/images/client/client-5.png`),
                        title: 'Sold Darken Forever Quick',
                        description: 'Has been sold by 1221 ETH',
                        date: '15 July',
                        time: '10:32 PM'
                    },
                    {
                        url: '/connect',
                        img: require(`@/assets/images/client/client-6.png`),
                        title: 'Sold Darken Forever Quick',
                        description: 'Has been sold by 1221 ETH',
                        date: '15 July',
                        time: '10:32 PM'
                    },
                ],
            }
        }
    }
</script>