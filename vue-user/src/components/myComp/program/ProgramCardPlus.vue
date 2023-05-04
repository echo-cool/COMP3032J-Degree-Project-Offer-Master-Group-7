<template>
    <div :class="[ {'colum-2 two-colum-parent-product col-lg-12': true}]">
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
                                        data-bs-target="#shareModal"
                                        @click="removeSelf(programId)">
                                    delete
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                 <background-card :background="background" :is-average="true" :card-title="`Average Background`" :is-editable="false"/>
            </div>
        </div>
    </div>
</template>

<script>
    import Countdown from '@/components/product/Countdown'
    import programApi from "@/api/program";
    import BackgroundCard from "@/components/myComp/background/BackgroundCard";

    export default {
        name: 'ProductListCardPlus',
        components: {Countdown, BackgroundCard},
        props: {
            programId: "",
            p: null,
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
                program: {},
                background: null,
                pp : ""
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
            getAverageBackground() {
                programApi.getAverageBackground(this.programId).then(response => {
                    this.background = response.data
                    console.log(this.background, "12212112121221")
                })
            },
            getById() {
                programApi.getProgramById(this.programId).then(response => {
                     console.log(response.data.program)
                    this.program = response.data.program
                    
                    // console.log(this.program)
                })
            },
            removeSelf(){
                console.log("pp: " + this.pp)
                this.$emit("deleteSelf", this.pp)
            }
        },
        created(){
            this.getById()
            this.getAverageBackground()
            console.log(this.p)
            this.pp = this.p
        }
    }
</script>
