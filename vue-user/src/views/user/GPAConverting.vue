<template>
    <layout>
        <breadcrumb title="GPA Converting" current="GPA Converting"/>

        <div class="rn-product-area rn-section-gapTop">
            <div class="container">
                <div class="row g-5">

                    <form-wizard>

                        <!-- step 1 -->
                        <tab-content title="Select Original GPA Scale" :before-change="beforeChange1">
                            <div class="about-market-area rn-section-gapTop">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-12">
                                            <div class="about-wrapper text-center">
                                                <h1>Your Original GPA Scale</h1>
                                                <p class="discription">
                                                    You need to specify the original scale of your GPA. Our GPA converting tool will
                                                    then convert your GPA into U.S. 4.0 scale using different algorithms according to
                                                    the original scale you selected here.
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="input-two-wrapper">
                                <div class="half-wid">
                                    <select id="original-scale" class="profile-edit-select mt--0" v-model="originalScale">
                                        <option value="" disabled selected style="display: none">Select your original GPA Scale here</option>
                                        <option value="UCD">University College Dublin 4.2 scale</option>
                                        <option value="CHINA">Chinese 0 - 100 scale</option>
                                    </select>
                                </div>
                            </div>
                        </tab-content>

                        <!-- step 2 -->
                        <tab-content title="Download and Fill Transcript Template" :before-change="beforeChange2">
                            <div class="about-market-area rn-section-gapTop">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-12">
                                            <div class="about-wrapper text-center">
                                                <h1>Download and Fill in Our Transcript Template</h1>
                                                <p class="discription">
                                                    You can download the our Transcript Template here, which is an Excel file.
                                                    You should input the information of all the courses you have taken, including
                                                    the course name, credit hours and your grade. Each row is for a single course.
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <a href="/backend/static/excel/GPA_Convert_Template.xlsx" class="btn btn-primary button-area w-25" style="display: block; margin: 0 auto">Download Template</a>
                        </tab-content>

                        <!-- step 3 -->
                        <tab-content title="Upload Your Filled Transcript" :before-change="beforeChange3">
                            My second tab content
                        </tab-content>

                        <!-- step 4 -->
                        <tab-content title="Your Converted GPA in 4.0 Scale" :before-change="beforeChange4">
                            Yuhuuu! This seems pretty damn simple
                        </tab-content>
                    </form-wizard>

                </div>
            </div>
        </div>


    </layout>
</template>

<script>
    import Layout from '@/components/layouts/Layout'
    import Breadcrumb from '@/components/breadcrumb/Breadcrumb'

    import cookie from "js-cookie";
    import router from "@/router";
    import Toastify from "toastify-js";

    import GPAConvertApi from "@/api/GPAconvert";


    //local registration
    import {FormWizard, TabContent} from 'vue3-form-wizard'
    import 'vue3-form-wizard/dist/style.css'


    export default {
        name: 'GPAConverting',
        components: {
            Breadcrumb,
            Layout,
            FormWizard,
            TabContent
        },
        mixins: [],
        data() {
            return {
                originalScale: "",
            }
        },
        created() {
            // load the current user info as this page is created
            // user would be redirected to the login page if not logged in
            this.getCurrentUser();

        },
        computed: {

        },
        methods: {
            // get current user info from cookie
            getCurrentUser(){
                // we have stored this when logging in
                let userStr = cookie.get("current_user");
                // turn json string to json obj
                if (userStr){
                    this.currentUser = JSON.parse(userStr);

                }else{
                    // user should be redirected to the login page if not logged in
                    Toastify({
                        text: "You should login first!",
                        duration: 3000,
                        close: false,
                        // avatar:"/img/logo-dark.44b49d43.png",
                        gravity: "top", // `top` or `bottom`
                        position: "right", // `left`, `center` or `right`
                        stopOnFocus: false, // Prevents dismissing of toast on hover
                        style: {
                            "font-size": "large",
                            "font-family":"\"Roboto\", sans-serif",
                            background: "linear-gradient(to right, #00b09b, #96c93d)",
                        },
                        onClick: function(){} // Callback after click
                    }).showToast();
                    // window.alert("You should login first!");
                    router.push({path: '/login'});
                }
            },

            // select original GPA scale
            beforeChange1(){
                if (this.originalScale === "UCD" || this.originalScale === "CHINA"){
                    return true;
                }else{
                    Toastify({
                        text: "You should select your original GPA scale before next step!",
                        duration: 3000,
                        close: false,
                        // avatar:"/img/logo-dark.44b49d43.png",
                        gravity: "top", // `top` or `bottom`
                        position: "right", // `left`, `center` or `right`
                        stopOnFocus: false, // Prevents dismissing of toast on hover
                        style: {
                            "font-size": "large",
                            "font-family":"\"Roboto\", sans-serif",
                            background: "linear-gradient(to right, #00b09b, #96c93d)",
                        },
                        onClick: function(){} // Callback after click
                    }).showToast();
                    return false;
                }
            },

            beforeChange2(){
                console.log("before change 2");
                return true;

            },

            beforeChange3(){
                console.log("before change 3");
                return true;

            },

            beforeChange4(){
                console.log("before change 4");
                return true;

            }
        }
    }
</script>
