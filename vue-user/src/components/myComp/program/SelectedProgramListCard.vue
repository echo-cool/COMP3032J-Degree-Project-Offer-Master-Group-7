<template>
    <div :class="[`lg-product-wrapper product-list-card`, {'colum-2 two-colum-parent-product col-lg-6': showTwoColumn}]">
        <div class="inner">
            <div class="lg-left-content">
                <router-link :to="`/program-details/` + application.program.id" class="thumbnail">
                    <img :src="`/backend/static/`+application.program.img" :alt="application.program.school.name" @load="$emit('handleImageLoad')" style="max-width: 140px;">
                </router-link>
                <div class="read-content">
<!--                    <div class="product-share-wrapper">-->
<!--                        <div class="profile-share">-->
<!--                            <router-link v-for="(author, index) in productDate.authors"-->
<!--                                         :key="`author-${index}`"-->
<!--                                         :to="`/author/${author.id}`"-->
<!--                                         class="avatar"-->
<!--                                         :data-tooltip="author.name">-->
<!--                                <img :src="author.image" :alt="author.name">-->
<!--                            </router-link>-->

<!--                            <router-link to="#" class="more-author-text">-->
<!--                                {{ program.school.name }}+ Place Bit.-->
<!--                            </router-link>-->
<!--                        </div>-->
<!--                        <div class="last-bid">{{ program.name }}</div>-->
<!--                    </div>-->
                    <router-link :to="`/program-details/` + application.program.id">
                        <h6 class="title">{{ application.program.name }} - {{ application.program.degree }} <span class="title">({{ application.eRound.toLowerCase().replace("_", " ") }})</span></h6>
                    </router-link>

                    <router-link :to="`/school-details/`+application.program.school.id">
                        <span class="latest-bid mr--20 fs-5 color-body">{{ application.program.school.name }}</span>
                    </router-link>

                    <span v-if="application.eStatus === `REJECTED`" class="color-danger fs-5">{{ application.eStatus.replace("_", " ") }}</span>
                    <span v-else-if="application.eStatus === `ADMITTED`" class="color-green fs-5">{{ application.eStatus.replace("_", " ") }}</span>
                    <span v-else class="color-info fs-5">{{ application.eStatus.replace("_", " ") }}</span>

                    <div class="share-wrapper d-flex">
                        <div v-if="isLikedObj.isLiked" class="react-area-activated mr--15" @click="likeProgram(application.program.id)">
                            <i class="feather-heart"/>
                            <span class="number">{{ application.program.likesNumber }}</span>
                        </div>
                        <div v-else class="react-area mr--15" @click="likeProgram(application.program.id)">
                            <i class="feather-heart"/>
                            <span class="number">{{ application.program.likesNumber }}</span>
                        </div>

                        <div class="share-btn share-btn-activation dropdown">
                            <button class="icon" data-bs-toggle="dropdown" aria-expanded="false">
                                <i class="feather-more-horizontal"/>
                            </button>
                            <div class="share-btn-setting dropdown-menu dropdown-menu-end">
                                <button type="button"
                                        class="btn-setting-text report-text"
                                        :data-bs-toggle="`modal`"
                                        :data-bs-target="`#application-edit-modal-${application.id}`">
                                    Edit
                                </button>
                                <button type="button"
                                        class="btn-setting-text report-text"
                                        @click="removeProgramFromUserApplications(application.program.id)">
                                    Remove
                                </button>
                            </div>
                        </div>
                    </div>
                </div>


            </div>

<!--            <div>-->
<!--                <h6 class="title fs-4">Time Remaining</h6>-->
<!--                <countdown :date="application.deadline" class="mt&#45;&#45;15"/>-->
<!--            </div>-->

<!--            <div class="read-content mr&#45;&#45;50">-->
<!--                <h6 class="title fs-2 mb&#45;&#45;20">Application Deadline</h6>-->
<!--                <div v-if="application.deadline" class="fs-3">{{ application.deadline }}</div>-->
<!--                <div v-else class="fs-4">You have not set the Deadline yet.</div>-->
<!--            </div>-->

            <div v-if="application.deadline" class="read-content mr--120">
                <h6 class="title fs-2 mb--20">Application Deadline</h6>
                <div class="fs-3">{{ application.deadline }}</div>
            </div>
            <div v-else class="read-content mr--20">
                <h6 class="title fs-2 mb--20">Application Deadline</h6>
                <div class="fs-3">You have not set the Deadline yet</div>
            </div>

        </div>
    </div>

    <application-edit-modal :key="`app-edit-modal-${application.id}`" :application="application" :e-round="application.eRound" :e-status="application.eStatus" :deadline="application.deadline"/>
</template>

<script>
    import Countdown from '@/components/product/Countdown'
    import programSelectionApi from "@/api/programSelection";
    import programApi from "@/api/program";
    import ApplicationEditModal from "@/components/myComp/modal/ApplicationEditModal.vue";
    import app from "../../../App.vue";
    import Toastify from "toastify-js";

    export default {
        name: 'SelectedProductListCard',
        computed: {
            app() {
                return app
            }
        },
        components: {
            Countdown,
            ApplicationEditModal
        },
        props: {
            productDate: {},
            productStyleClass: {
                type: String
            },
            showPlaceBid: {
                type: Boolean,
                default: false
            },
            showTwoColumn: {
                type: Boolean,
                default: false
            },
            application: {},
            isProgramSelected: {
                type: Boolean,
                default: false
            },
            isLikedObj: {},
        },
        data(){
            return{

            }
        },
        created() {

        },
        methods:{
            // remove a program from user application list
            removeProgramFromUserApplications(programId){
                programSelectionApi.deleteApplicationByProgramId(programId)
                    .then(response => {
                        // delete successfully
                        Toastify({
                            text: "The program removed successfully into your list!",
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

                        // tell the parent component to reload data for updating showing
                        this.$emit("reloadData");
                    })
            },

            likeProgram(programId){
                // call API method
                programApi.likeProgram(programId)
                    .then(response => {
                        if(response.success){

                            // tell the parent comp to change the liked status (statically)
                            if (response.data.likesNumber > this.application.program.likesNumber){
                                // add like
                                this.$emit("addLike");
                            }else{
                                // remove like
                                this.$emit("removeLike");
                            }

                            // update the like number of this program
                            this.application.program.likesNumber = response.data.likesNumber;
                        }
                    })
            }
        }
    }
</script>
