<template>
    <div :class="[`lg-product-wrapper product-list-card`, {'colum-2 two-colum-parent-product col-lg-6': showTwoColumn}]">
        <div class="inner">
            <div class="lg-left-content">
                <router-link :to="`#`" class="thumbnail">
                    <img :src="`/backend/static/`+program.img" :alt="program.school.name" @load="$emit('handleImageLoad')">
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
                    <router-link :to="`#`">
                        <h6 class="title">{{ program.name }} - {{ program.degree }}</h6>
                    </router-link>
                    <span class="latest-bid">{{ program.school.name }}</span>
                    <div class="share-wrapper d-flex">
                        <div v-if="isLikedObj.isLiked" class="react-area-activated mr--15" @click="likeProgram(program.id)">
                            <i class="feather-heart"/>
                            <span class="number">{{ program.likes }}</span>
                        </div>
                        <div v-else class="react-area mr--15" @click="likeProgram(program.id)">
                            <i class="feather-heart"/>
                            <span class="number">{{ program.likes }}</span>
                        </div>
                        <div class="share-btn share-btn-activation dropdown">
                            <button class="icon" data-bs-toggle="dropdown" aria-expanded="false">
                                <i class="feather-more-horizontal"/>
                            </button>
                            <div class="share-btn-setting dropdown-menu dropdown-menu-end">
                                <button type="button"
                                        class="btn-setting-text report-text"
                                        @click="editApplications(program.id)">
                                    Edit
                                </button>
                                <button type="button"
                                        class="btn-setting-text report-text"
                                        @click="removeProgramFromUserApplications(program.id)">
                                    Remove
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <div class="">
                <h6 class="title">Time Remaining</h6>
                <countdown :date="deadline" class="mt--15"/>
            </div>



        </div>
    </div>
</template>

<script>
    import Countdown from '@/components/product/Countdown'
    import programSelectionApi from "@/api/programSelection";
    import programApi from "@/api/program";

    export default {
        name: 'SelectedProductListCard',
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
            isLikedObj: {},
            deadline: ""
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
                        window.alert("Program removed successfully from your list!")
                        // tell the parent component to reload data for updating showing
                        this.$emit("reloadData");
                    })
            },

            editApplications(){

            },

            likeProgram(programId){
                // call API method
                programApi.likeProgram(programId)
                    .then(response => {
                        if(response.success){
                            // update the like number of this program
                            this.program.likes = response.data.likes;
                            // change the liked status
                            this.isLikedObj.isLiked = !this.isLikedObj.isLiked;
                        }
                    })
            }
        }
    }
</script>
