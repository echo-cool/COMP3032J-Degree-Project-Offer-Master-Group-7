<template>
    <div class="rn-notification-area right-fix-notice">
        <div class="h--100">
            <div class="notice-heading">
                <h4>My Program List</h4>

<!--                <nice-select-->
<!--                    :options="[-->
<!--                        {value: 'newest', text: 'Newest'},-->
<!--                        {value: 'trending', text: 'Tranding'},-->
<!--                        {value: 'saved', text: 'Saved'},-->
<!--                        {value: 'deleted', text: 'Delated'}-->
<!--                    ]"-->
<!--                    :default-current="0"-->
<!--                    placeholder="Sort by likes"-->
<!--                    name="like"-->
<!--                />-->
            </div>
        </div>

        <!-- !!! This is really FUCKING!!! -->
        <!-- We must use the application list in child component AFTER -->
        <!-- the list finishes loading in the Mixin -->
        <!-- Otherwise, the navbar would be unavailable -->
        <div v-if="applications.length !== 0" class="rn-notification-wrapper">
            <div class="single-notice"
                 v-for="(application, index) in applications"
                 :key="`application-${index}`">

                <div class="thumbnail">
<!--                    <router-link :to="application.program.school.url">-->
                        <img style="width: 100px" :src="`/backend/static/`+application.program.school.img" alt="Images">
<!--                    </router-link>-->
                </div>
                <div class="content-wrapper">
<!--                    <router-link :to="application.program.school.url">-->
                        <h6 class="title">{{ application.program.school.name }}</h6>
<!--                    </router-link>-->
                    <p>{{ application.program.name }}</p>
                    <div class="notice-time">
                        <span>{{ application.program.degree }} </span>
                        <!-- status -->
                        <span v-if="application.eStatus === `REJECTED`" class="color-danger">{{ application.eStatus }}</span>
                        <span v-else-if="application.eStatus === `ADMITTED`" class="color-green">{{ application.eStatus }}</span>
                        <span v-else class="color-info">{{ application.eStatus }}</span>
                    </div>
                    <!--                    <router-link :to="application.url" class="btn btn-primary-alta">Check Out</router-link>-->
                    <a class="btn btn-primary mr--10" @click="editApplication()"
                       :data-bs-toggle="`modal`"
                       :data-bs-target="`#application-edit-modal-${application.id}`">Edit</a>
                    <a class="btn btn-primary-alta" @click="removeApplication(application.id)">Remove</a>
                </div>
            </div>
        </div>

    </div>
</template>

<script>
    import NiceSelect from '@/components/select/NiceSelect'
    import programSelectionApi from "@/api/programSelection";
    import Toastify from "toastify-js";
    import ApplicationEditModal from "@/components/myComp/modal/ApplicationEditModal";

    export default {
        name: 'MyProgramListSidebar',
        components: {NiceSelect, ApplicationEditModal },
        props: {
            currentUser: {},
            applications: {
                type: Array,
                default: function () {
                    return [];
                }
            }
        },
        data() {
            return {

            }
        },

        created() {

        },

        methods:{

            editApplication(){
                // for test
                console.log("test in editApplication")
            },

            removeApplication(applicationId){
                programSelectionApi.deleteApplicationById(applicationId)
                    .then(response => {
                        // application removed successfully
                        Toastify({
                            text: "Program removed successfully from your list",
                            duration: 3000,
                            close: false,
                            // avatar:"/img/logo-dark.44b49d43.png",
                            gravity: "bottom", // `top` or `bottom`
                            position: "right", // `left`, `center` or `right`
                            stopOnFocus: false, // Prevents dismissing of toast on hover
                            style: {
                                "font-size": "large",
                                "font-family":"\"Roboto\", sans-serif",
                                background: "linear-gradient(to right, #00b09b, #96c93d)",
                            },
                            onClick: function(){} // Callback after click
                        }).showToast();
                        // window.alert("Program removed successfully from your list");
                        // notice the parent to fetch data again
                        this.$emit("reloadData");
                    })
            }

        }
    }
</script>
