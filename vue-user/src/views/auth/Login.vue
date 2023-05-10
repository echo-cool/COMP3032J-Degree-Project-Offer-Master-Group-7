<template>
    <layout>
        <breadcrumb title="OfferMaster Login" current="OfferMaster Login"/>

        <div class="login-area rn-section-gapTop">
            <div class="container" >
                <div class="row g-5" id="login-area-forms" v-if="code == null">
                    <div class=" offset-2 col-lg-4 col-md-6 ml_md--0 ml_sm--0 col-sm-12">
                        <div class="form-wrapper-one">
                            <h4>Login</h4>
                            <form>
                                <div class="mb-5">
                                    <label for="exampleInputEmail1" class="form-label">Email address</label>
                                    <input type="email" id="exampleInputEmail1" v-model="params.email">
                                </div>
                                <div class="mb-5">
                                    <label for="exampleInputPassword1" class="form-label">Password</label>
                                    <input type="password" id="exampleInputPassword1" v-model="params.password">
                                </div>
                                <div class="mb-5 rn-check-box">
                                    <input type="checkbox" class="rn-check-box-input" id="exampleCheck1">
                                    <label class="rn-check-box-label" for="exampleCheck1">Remember me leter</label>
                                </div>
                                <button type="button" class="btn btn-primary mr--15" @click="login()">Log In</button>
                                <router-link to="/sign-up" class="btn btn-primary-alta">Sign Up</router-link>
                            </form>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-12">
                        <div class="social-share-media form-wrapper-one">
                            <h6>Another way to log in</h6>
                            <p>You can also login with the following ways.</p>
                            <button v-on:click="loginByGithub" class="another-login login-facebook">
                                <img v-on:click="loginByGithub" class="small-image" :src="require(`@/assets/images/icons/google.png`)" alt="">
                                <span v-on:click="loginByGithub" >Log in with Github</span>
                            </button>
                            <button v-on:click="loginByOAuth" class="another-login login-facebook">
                                <img v-on:click="loginByOAuth"  class="small-image" :src="require(`@/assets/images/icons/linkedin.png`)" alt="">
                                <span v-on:click="loginByOAuth" >Log in with Facebook</span>
                            </button>
                            <button v-on:click="loginByOAuth" class="another-login login-twitter">
                                <img v-on:click="loginByOAuth"  class="small-image" :src="require(`@/assets/images/icons/tweeter.png`)" alt="">
                                <span v-on:click="loginByOAuth" >Log in with Twitter</span>
                            </button>
                            <button v-on:click="loginByOAuth" class="another-login login-linkedin">
                                <img v-on:click="loginByOAuth"  class="small-image" :src="require(`@/assets/images/icons/linkedin.png`)" alt="">
                                <span v-on:click="loginByOAuth" >Log in with OAuth</span>
                            </button>
                        </div>
                    </div>
                </div>
                <div class="row g-5" id="login-area-forms" v-else>
                    <div class="d-flex justify-content-center">
                        <div class="spinner-border" role="status" style="zoom: 5">

                        </div>

                    </div>
                    <div class="d-flex justify-content-center">
                    <h2>Authenticating...</h2>
                    </div>
                </div>

            </div>
        </div>
    </layout>
</template>

<script>
    import Layout from "@/components/layouts/Layout.vue";
    import Breadcrumb from "@/components/breadcrumb/Breadcrumb.vue";

    import loginApi from "@/api/login"
    import cookie from "js-cookie"
    import request from "@/utils/request";

    export default {
        name: 'Login',
        components: {Breadcrumb, Layout},
        data(){
            return{
                params: {
                    email: "",
                    password: ""
                },
                currentUser: {},
                code: null
            }
        },

        created() {
            const code = this.$route.query.code
            console.log(code)
            this.code = code;
            if (code) {

                request({
                    url: `/api/auth/oauth/echocool/callback?code=` + code,
                    method: "get",
                }).then(response => {
                    const token = response['data']['jwt']

                    cookie.set("user_token", token);
                    console.log("user_token:" + token);
                    // store user info into the cookie
                    this.getUserInfo();

                })
            }
        },

        methods: {
            // the method for submitting login form
            login(){
                // call the method defined in the api
                loginApi.login(this.params)
                    .then(response => {     // this response is response.data

                        // get the token from response
                        // and store it into the cookie
                        cookie.set("user_token", response.accessToken);

                        // store user info into the cookie
                        this.getUserInfo();

                    })
                    .catch(error => {
                        // notify user
                        window.alert(error.response.data.message);
                    })
            },

            // get user info by token immediately after login
            getUserInfo(){
                // (also viable to get user info from login VO)
                // this.currentUser = response.data.data.user;

                // get the user info from backend by token
                // no parameter is required
                // because the token has been configured into the request header
                loginApi.getUserInfoByToken()
                    .then(response => {     // this response is R

                        // get the current user info
                        // and store it into the cookie
                        this.currentUser = response.data.user;
                        cookie.set("current_user", JSON.stringify(this.currentUser));

                        // redirect to the index page
                        // window.location.href = "/edit-profile";

                        // get the page user wanted to go from cookie
                        let goto = cookie.get("gotoAfterLogin");
                        // clear the goto cookie
                        cookie.set("gotoAfterLogin", "");
                        // redirect user to the page
                        if (goto){
                            window.location.href = goto;
                        }else{
                            window.location.href = "/edit-profile";
                        }


                    })
                    .catch(error => {
                        // notify user
                        window.alert(error.response.data.message);
                    })
            },

            loginByOAuth() {
                window.location.href = "/backend/api/auth/oauth/echocool/redirection";
            },

            loginByGithub() {
                window.location.href = "https://oauth.yuyangwang.org/external_auth/github/?next=%2Fo%2Fauthorize%2F%3Fclient_id%3DOjxfcvMiTPb7DEIoopIebvJNNzWtr8Og3R1uVRuU%26redirect_uri%3Dhttp%3A%2F%2Flocalhost%3A3000%2Flogin%26response_type%3Dcode%26scope%3Dopenid";
            }
        }

    }
</script>
