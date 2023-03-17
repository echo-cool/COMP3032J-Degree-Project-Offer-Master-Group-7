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
    import cookie from "js-cookie";
    import router from "@/router";
    import ApplicationListMixin from "@/mixins/user/ApplicationListMixin";

    export default {
        name: 'MyProgramListSidebar',
        components: {NiceSelect},
        mixins: [ApplicationListMixin],
        data() {
            return {
                currentUser: {},
            }
        },

        created() {

            // load the current user info as this page is created
            this.getCurrentUser();
            // load the applications of this user
            this.getApplications(this.currentUser.id);

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
