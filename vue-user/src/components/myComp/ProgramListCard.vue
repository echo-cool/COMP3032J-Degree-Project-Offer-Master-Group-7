<template>
    <div :class="[`lg-product-wrapper product-list-card`, {'colum-2 two-colum-parent-product col-lg-6': showTwoColumn}]">
        <div class="inner">
            <div class="lg-left-content">
                <router-link :to="`#`" class="thumbnail">
<!--                    <img :src="program.school.img" :alt="program.school.name" @load="$emit('handleImageLoad')">-->
                    <img :src="require(`@/assets/images/portfolio/lg/portfolio-01.jpg`)" :alt="program.school.name" @load="$emit('handleImageLoad')">
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
                        <h6 class="title">{{ program.name }}</h6>
                    </router-link>
                    <span class="latest-bid">{{ program.school.name }}</span>
                    <div class="share-wrapper d-flex">
                        <div class="react-area mr--15">
                            <i class="feather-heart"/>
                            <span class="number">{{ program.name }}</span>
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
                    type="button"
                    class="btn btn-primary-alta mr--30"
                    @click="removeProgramFromUserApplications(program.id)">
                Remove from the list
            </button>
            <button v-else
                    type="button"
                    class="btn btn-primary-alta mr--30"
                    @click="addProgramIntoUserApplications()">
                Add to My Program List
            </button>

        </div>
    </div>
</template>

<script>
    import Countdown from '@/components/product/Countdown'
    import programSelectionApi from "@/api/programSelection";

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
            }
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
                        // update the showing
                        // this.isProgramSelected = false;

                    })
            },

            // add a program into user application list
            addProgramIntoUserApplications(){

            }
        }
    }
</script>
