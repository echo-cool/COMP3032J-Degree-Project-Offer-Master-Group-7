<template>
    <layout>
        <breadcrumb title="Sign Up" current="Sign Up"/>

        <div class="login-area rn-section-gapTop">
            <div class="container">
                <div class="row g-5">
                    <div class="offset-2 col-lg-4 col-md-6 ml_md--0 ml_sm--0 col-sm-12">
                        <div class="form-wrapper-one registration-area">
                            <h4>Sign up</h4>
                            <form>
<!--                                <div class="mb-5">-->
<!--                                    <label for="firstName" class="form-label">First name</label>-->
<!--                                    <input type="text" id="firstName">-->
<!--                                </div>-->
                                <div class="mb-5">
                                    <label for="sastName" class="form-label">Username</label>
                                    <input type="text" id="sastName" v-model="params.username">
                                </div>
                                <div class="mb-5">
                                    <label for="exampleInputEmail1" class="form-label">Email address</label>
                                    <input type="email" id="exampleInputEmail1" v-model="params.email">
                                </div>
                                <div class="mb-5">
                                    <label for="newPassword" class="form-label">Create Password</label>
                                    <input type="password" id="newPassword" v-model="params.password">
                                </div>
                                <div class="mb-5">
                                    <label for="exampleInputPassword1" class="form-label">Re Password</label>
                                    <input type="password" id="exampleInputPassword1" v-model="params.rePassword">
                                </div>
                                <div class="mb-5 rn-check-box">
                                    <input type="checkbox" class="rn-check-box-input" id="exampleCheck1">
                                    <label class="rn-check-box-label" for="exampleCheck1">Allow to all tearms &
                                        condition</label>
                                </div>
                                <button type="button" class="btn btn-primary mr--15" @click="register()">Sign Up</button>
                                <router-link to="/login" class="btn btn-primary-alta">Log In</router-link>
                            </form>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-12">
                        <div class="social-share-media form-wrapper-one">
                            <h6>Another way to sign up</h6>
                            <p> You can also sign up with the following ways.</p>
                            <button class="another-login login-facebook">
                                <img class="small-image" :src="require(`@/assets/images/icons/google.png`)" alt="">
                                <span>Log in with Google</span>
                            </button>
                            <button class="another-login login-facebook">
                                <img class="small-image" :src="require(`@/assets/images/icons/facebook.png`)" alt="">
                                <span>Log in with Facebook</span>
                            </button>
                            <button class="another-login login-twitter">
                                <img class="small-image" :src="require(`@/assets/images/icons/tweeter.png`)" alt="">
                                <span>Log in with Twitter</span>
                            </button>
                            <button class="another-login login-linkedin">
                                <img class="small-image" :src="require(`@/assets/images/icons/linkedin.png`)" alt="">
                                <span>Log in with linkedin</span>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </layout>
</template>

<script>
    import Layout from "@/components/layouts/Layout";
    import Breadcrumb from "@/components/breadcrumb/Breadcrumb";

    import router from "@/router/index";
    import registerApi from "@/api/register";

    export default {
        name: 'Signup',
        components: {Breadcrumb, Layout},
        data(){
            return{
                // the fields in the register form
                params:{
                    username: "",
                    email: "",
                    password: "",
                    rePassword: ""
                }
            }
        },
        created() {

        },
        methods:{
            register(){
                // call the api method
                registerApi.register(this.params)
                    .then(response => {

                        if(response.success){
                            // notify user
                            window.alert("Registration success, you can login now!");

                            // redirect to login page
                            router.push({path: '/login'});

                        }else{
                            // notify user
                            window.alert(response.message);
                        }
                    })
                    .catch(error => {
                        // notify user
                        window.alert(error.response.data.message)
                    })
            }
        }

    }
</script>