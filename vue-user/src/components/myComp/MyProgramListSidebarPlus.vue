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
        <div  class="rn-notification-wrapper">
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
                    <a class="btn btn-primary-alta" @click="addApplication(application.id)">Add</a>
                </div>

            </div>
        </div>
    </div>
</template>

<script>
    import NiceSelect from '@/components/select/NiceSelect'
    import programSelectionApi from "@/api/programSelection";

    export default {
        name: 'MyProgramListSidebarPlus',
        components: {NiceSelect},
        props: {
            currentUser: {},
            applications: {
                type: Array,
                default: function () {
                    return [];
                }
            },
            // appListMixinLoadSchoolCount: 0
        },
        data() {
            return {

            }
        },

        created() {

        },

        methods:{
            addApplication(applicationId){
                this.$emit("reloadData", applicationId);
            }

        }
    }
</script>
