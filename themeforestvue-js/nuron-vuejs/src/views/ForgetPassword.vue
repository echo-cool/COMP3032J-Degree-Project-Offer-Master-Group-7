<template>
    <layout>
        <breadcrumb title="Forget Password?" current="Forget Password?"/>

        <div class="forget-password-area rn-section-gapTop">
            <div class="container">
                <div class="row g-5">
                    <div class="offset-4 col-lg-4">
                        <div class="form-wrapper-one">
                            <div class="logo-thumbnail logo-custom-css mb--50">
                                <router-link class="logo-light" to="/">
                                    <img :src="require(`@/assets/images/logo/logo-white.png`)" alt="nft-logo">
                                </router-link>
                                <router-link class="logo-dark" to="/">
                                    <img :src="require(`@/assets/images/logo/logo-dark.png`)" alt="nft-logo">
                                </router-link>
                            </div>

                            <div class="mb-5">
                                <label for="exampleInputEmail1" class="form-label">Email address</label>
                                <input type="email" id="exampleInputEmail1" placeholder="Enter your email">
                            </div>
                            <div class="mb-5">
                                <input type="checkbox" class="rn-check-box-input" id="exampleCheck1">
                                <label class="rn-check-box-label" for="exampleCheck1">
                                    I agree to the <router-link to="/privacy-policy">privacy policy</router-link>
                                </label>
                            </div>
                            <div class="mb-5">
                                <button class="btn btn-large btn-primary">Send</button>
                            </div>
                            <span class="mt--20 notice">Note: We will send a password to your email</span>
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
    export default {
        name: "ForgetPassword",
        components: {Breadcrumb, Layout}
    }
</script>

<style scoped>

</style>