<template>
    <div :class="[`lg-product-wrapper product-list-card`, {'colum-2 two-colum-parent-product col-lg-6': showTwoColumn}]">
        <div class="inner">
            <div class="lg-left-content">
                <router-link :to="`/program-details/${program.id}`" class="thumbnail">
                    <img :src="`/backend/static/`+ program.img" :alt="program.name" @load="$emit('handleImageLoad')">
                </router-link>
                <div class="read-content">
                    <router-link :to="`/program-details/${program.id}`">
                        <h6 class="title">{{ program.name }}</h6>
                    </router-link>
                    <span class="latest-bid">{{ program.degree }}</span>
                    <div class="share-wrapper d-flex">
                        <div class="react-area mr--15">
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
        </div>
    </div>
</template>

<script>
    import Countdown from '@/components/product/Countdown'
    import programApi from "@/api/program";

    export default {
        name: 'ProductListCardPlus',
        components: {Countdown},
        props: {
            programId: "",
            
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
            }
        },
        data() {
            return {
                program: {}
                // schoolId: this.$route.params.id.split("X")[1],
                // product: {},
                // activeTabIndex: 0,
                // relatedSchools: [],
                // relatedPrograms: [],
                // school: {},

                // selectedPrograms: [],
                // selectedProgramIDs: [],
                // programSelected: false,
            }
        },
        methods: {
            getById() {
                programApi.getProgramById(this.programId).then(response => {
                     console.log(response.data.program)
                    this.program = response.data.program
                    
                    console.log(this.program)
                })
            }
        },
        created(){
            this.getById(this.programId)
        }
    }
</script>