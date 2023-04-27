<template>
    <layout>
        <breadcrumb title="GPA Converting" current="GPA Converting"/>

        <div class="rn-product-area rn-section-gapTop">
            <div class="container">
                <div class="row g-5">

                    <form-wizard>
                        <tab-content title="Personal details">
                            My first tab content
                        </tab-content>
                        <tab-content title="Additional Info">
                            My second tab content
                        </tab-content>
                        <tab-content title="Last step">
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
        }
    }
</script>
