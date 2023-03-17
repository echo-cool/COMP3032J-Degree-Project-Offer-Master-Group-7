<template>
    <div class="rn-notification-area right-fix-notice">
        <div class="h--100">
            <div class="notice-heading">
                <h4>My Program List</h4>
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
                 v-for="(application, index) in applications"
                 :key="`application-${index}`">
                <div class="thumbnail">
<!--                    <router-link :to="application.program.school.url">-->
                        <img :src="application.program.school.img" alt="Images">
<!--                    </router-link>-->
                </div>
                <div class="content-wrapper">
<!--                    <router-link :to="application.program.school.url">-->
                        <h6 class="title">{{ application.program.school.name }}</h6>
<!--                    </router-link>-->
                    <p>{{ application.program.name }}</p>
                    <div class="notice-time">
                        <span>{{ application.degree }} </span>
                        <!-- status -->
                        <span v-if="application.eStatus === `REJECTED`" class="color-danger">{{ application.eStatus }}</span>
                        <span v-else-if="application.eStatus === `ADMITTED`" class="color-green">{{ application.eStatus }}</span>
                        <span v-else class="color-info">{{ application.eStatus }}</span>
                    </div>
                    <!--                    <router-link :to="application.url" class="btn btn-primary-alta">Check Out</router-link>-->
                    <a class="btn btn-primary mr--10" @click="editApplication()">Edit</a>
                    <a class="btn btn-primary-alta" @click="removeApplication()">Remove</a>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import NiceSelect from '@/components/select/NiceSelect'
    import profileApi from "@/api/profile";
    import cookie from "js-cookie";
    import router from "@/router";

    export default {
        name: 'NotificationListSidebar',
        components: {NiceSelect},
        data() {
            return {
                currentUser: {},

                applications: [
                    {
                        id: "",
                        eStatus: "",
                        deadline: "",
                        degree: null,
                        program:{
                            id: "",
                            name: "",
                            school:{
                                id: "",
                                name: "",
                                img: ""
                            }
                        }
                    }
                ],

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
        },

        created() {

            // load the current user info as this page is created
            this.getCurrentUser();
            // load the applications of this user
            this.getApplications();

        },

        methods:{

            // get current user info from cookie
            getCurrentUser(){
                // we have stored this when logging in
                let userStr = cookie.get("current_user");
                // turn json string to json obj
                if (userStr){
                    this.currentUser = JSON.parse(userStr);
                }else{
                    // user should be redirected to the login page if not logged in
                    window.alert("You should login first!");
                    router.push({path: '/login'});
                }
            },

            // get the applications (program list) of current user
            getApplications(){
                // call the api method
                profileApi.getApplicationsByUid(this.currentUser.id)
                    .then(response => {

                        // update the programs list
                        this.applications = response._embedded.applications;

                        // for each of the application, send request to get the program info
                        for (let k in this.applications) {
                            // create the request url for this program
                            let programURL = `/rest/applications/${this.applications[k].id}/program`;
                            // call api method
                            profileApi.getByRestURL(programURL)
                                .then(response => { // response is the program

                                    // update the program of this application
                                    this.applications[k].program = response;

                                    // create the request url for the school of this program
                                    let schoolURL = `/rest/programs/${this.applications[k].program.id}/school`;

                                    // send request to update the school info of this program
                                    profileApi.getByRestURL(schoolURL)
                                        .then(response => { // response is the school

                                            // update the school of this program
                                            this.applications[k].program.school = response;

                                        })

                                })
                        }

                    })
            },

            editApplication(){
                // for test
                console.log("test in editApplication")
            },

            removeApplication(){
                // for test
                console.log("test in removeApplication")
            }

        }
    }
</script>
