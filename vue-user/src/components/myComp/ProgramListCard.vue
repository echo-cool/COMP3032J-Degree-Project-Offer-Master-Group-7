<template>
    <div :class="[`lg-product-wrapper product-list-card`, {'colum-2 two-colum-parent-product col-lg-6': showTwoColumn}]">
        <div class="inner">
            <div class="lg-left-content">
                <router-link :to="`/program-details/`+program.id" class="thumbnail">
                    <img :src="`/backend/static/`+program.img" :alt="program.school.name" @load="$emit('handleImageLoad')" style="height: 160px; width: 250px;">
<!--                    <img :src="require(`@/assets/images/portfolio/lg/portfolio-01.jpg`)" :alt="program.school.name" @load="$emit('handleImageLoad')">-->
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
                    <router-link :to="`/program-details/`+program.id">
                        <h6 class="title">{{ program.name }} - {{ program.degree }}</h6>
                    </router-link>
                    <span class="latest-bid">{{ program.school.name }}</span>
                    <div class="share-wrapper d-flex">
                        <div v-if="isLikedObj.isLiked" class="react-area-activated mr--15" @click="likeProgram(program.id)">
                            <i class="feather-heart"/>
                            <span class="number">{{ program.likesNumber }}</span>
                        </div>
                        <div v-else class="react-area mr--15" @click="likeProgram(program.id)">
                            <i class="feather-heart"/>
                            <span class="number">{{ program.likesNumber }}</span>
                        </div>
                        <div class="share-btn share-btn-activation dropdown">
                            <button class="icon" data-bs-toggle="dropdown" aria-expanded="false">
                                <i class="feather-more-horizontal"/>
                            </button>
                            <div class="share-btn-setting dropdown-menu dropdown-menu-end">
                                <button type="button"
                                        class="btn-setting-text share-text"
                                        data-bs-toggle="modal"
                                        data-bs-target="#shareModal">
                                    Share
                                </button>
                                <button type="button"
                                        class="btn-setting-text report-text"
                                        data-bs-toggle="modal"
                                        data-bs-target="#reportModal">
                                    Report
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

<!--            <button type="button"-->
<!--                    class="btn btn-primary-alta mr&#45;&#45;30"-->
<!--                    data-bs-toggle="modal"-->
<!--                    data-bs-target="#placebidModal">-->
<!--                Place a Bid-->
<!--            </button>-->
            <button v-if="isProgramSelected"
                    style="width: 100px; height: 50px;"
                    type="button"
                    class="btn mr--30 btn-danger"
                    @click="removeProgramFromUserApplications(program.id)">Remove</button>
            <button v-else
                    style="width: 100px; height: 50px;"
                    type="button"
                    class="btn btn-primary-alta mr--30"
                    @click="addProgramIntoUserApplications(program.id)">Add</button>

        </div>
    </div>
</template>

<script>
    import Countdown from '@/components/product/Countdown'
    import programSelectionApi from "@/api/programSelection";
    import programAip from "@/api/program";
    import Toastify from "toastify-js";

    export default {
        name: 'ProductListCard',
        components: {Countdown},
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
            program: {},
            isProgramSelected: {
                type: Boolean,
                default: false
            },
            isLikedObj: {}
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
                            text: "Program removed successfully from your list!",
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
                        // window.alert("Program removed successfully from your list!")
                        // tell the parent component to reload data for updating showing
                        this.$emit("reloadData");
                    })
            },

            // add a program into user application list
            addProgramIntoUserApplications(programId){
                programSelectionApi.addApplication(programId)
                    .then(response => {
                        // add successfully
                        Toastify({
                            text: "The program added successfully into your list!",
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
                        // window.alert("The program added successfully into your list!")
                        // tell the parent component to reload data for updating showing
                        this.$emit("reloadData");
                    })
            },

            likeProgram(programId){
                // call API method
                programAip.likeProgram(programId)
                    .then(response => {
                        if(response.success){
                            // update the like number of this program
                            this.program.likesNumber = response.data.likesNumber;
                            // change the liked status
                            this.isLikedObj.isLiked = !this.isLikedObj.isLiked;
                        }
                    })
            }
        }
    }
</script>
