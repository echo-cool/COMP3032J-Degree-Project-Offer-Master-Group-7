<template>
    <div :class="`product-style-one`">
        <div class="card-thumbnail" style="">


          <!--            <router-link :to="`/product/${productDate.id}`">--> <!-- e.g. -->
            <router-link :to="`/program-details/`+program.id">

                <img style="height: 200px" v-if="program.img" :src="`/backend/static/`+ program.img" :alt="program.name" @load="$emit('handleImageLoad')">

              <img v-else :src="require(`@/assets/images/portfolio/portfolio-07.jpg`)" :alt="`img`" @load="$emit('handleImageLoad')">
              <div class="text-center">
                <b-spinner label="Spinning" style="position: absolute; width: 50px; height: 50px"></b-spinner>
              </div>
            </router-link>

            <countdown v-if="showDDLCountdown" :date="deadline"/>

        </div>
        <div class="product-share-wrapper">
            <div class="profile-share">
<!--                <router-link v-for="(author, index) in productDate.authors"-->
<!--                             :key="`author-${index}`"-->
<!--                             :to="`/author/${author.id}`"-->
<!--                             class="avatar"-->
<!--                             :data-tooltip="author.name">-->
<!--                    <img :src="author.image" :alt="author.name">-->
<!--                </router-link>-->
<!--                <router-link to="#" class="more-author-text">-->
<!--                    {{ application.program.name }}+ Place Bit.-->
<!--                </router-link>-->
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
<!--        <router-link :to="`/product/${productDate.id}`">--> <!-- e.g. -->
        <router-link :to="`/program-details/`+program.id">
            <span class="product-name">{{ program.name }}</span>
        </router-link>
        <router-link :to="`/school-details/`+school.id">
          <span class="latest-bid">{{ school.name }}</span>
        </router-link>
        <div class="bid-react-area">
            <div class="last-bid">{{ program.degree }} - {{ program.major }}</div>
            <div v-if="isLikedObj.isLiked" class="react-area" @click="likeProgram(program.id)" style="background: var(--color-primary); color: var(--color-white)">
                <i class="feather-heart"/>
                <span class="number">{{ program.likesNumber }}</span>
            </div>
            <div v-else class="react-area" @click="likeProgram(program.id)">
                <i class="feather-heart"/>
                <span class="number">{{ program.likesNumber }}</span>
            </div>
        </div>
    </div>
</template>

<script>
    import Countdown from "@/components/myComp/program/Countdown.vue";
    import programAip from "@/api/program";

    export default {
        name: 'ProgramCard',
        components: {Countdown},
        props: {
            program: {},
            school: {},
            showDDLCountdown: {
                type: Boolean,
                default: false
            },
            isLikedObj: {},
            deadline: ""
        },
        watch: {
            '$route': function (to, from) {
                this.closeModal()
            }
        },
        methods: {
            closeModal() {
                const modals = document.querySelectorAll('.modal-backdrop');

                if (modals.length) {
                    modals.forEach(item => {
                        item.remove();
                    })
                }
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

<style>
  ol li a {
    color: #0d6efd !important;
  }

  ol li a:hover {
    color: #00a3ff !important;
  }

  .latest-bid {
    color: #0d6efd;
    transition: var(--transition);
  }

  .latest-bid:hover {
    color: #00a3ff;
  }
</style>
