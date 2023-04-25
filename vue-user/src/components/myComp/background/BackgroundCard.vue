<template>

    <div class="col-lg-11 col-md-6 col-sm-6 col-12 mb--50" v-if="background !== null">
        <div class="rn-address rn-service-one">
            <div class="inner">
                <div class="icon">
                    <img src="/img/shape-1.a3cb4828.png" alt="Shape">
                </div>
                <h1 class="title">{{ cardTitle }}</h1>
                <p class="mb--30">
                    <span class="mr--50"><strong>GPA: </strong>{{ background.gpa }}</span>
                    <span class="mr--50"><strong>Rank: </strong>{{ background.ranking }}</span>
                </p>
                <p class="mb--30">
                    <span class="mr--50"><strong>Undergraduate School Level: </strong>{{ background.underGradSchoolCate }}</span>
                </p>
                <p class="mb--30">
                    <span class="mr--50"><strong>Undergraduate Major: </strong>{{ background.underGradMajor }}</span>
                </p>
                <p class="mb--30" v-if="background.testType === `IELTS`">
                    <span class="mr--50"><strong>IELTS: </strong>{{ background.totalIELTS }}</span>
                    <span class="mr--50"><strong>LISTENING: </strong>{{ background.listeningIELTS }}</span>
                    <span class="mr--50"><strong>READING: </strong>{{ background.readingIELTS }}</span>
                    <span class="mr--50"><strong>WRITING: </strong>{{ background.writingIELTS }}</span>
                    <span class="mr--50"><strong>SPEAKING: </strong>{{ background.speakingIELTS }}</span>
                </p>
                <p class="mb--30" v-else-if="background.testType === `TOEFL`">
                    <span class="mr--50"><strong>IELTS: </strong>{{ background.totalTOEFL }}</span>
                    <span class="mr--50"><strong>LISTENING: </strong>{{ background.listeningTOEFL }}</span>
                    <span class="mr--50"><strong>READING: </strong>{{ background.readingTOEFL }}</span>
                    <span class="mr--50"><strong>WRITING: </strong>{{ background.writingTOEFL }}</span>
                    <span class="mr--50"><strong>SPEAKING: </strong>{{ background.speakingTOEFL }}</span>
                </p>
                <p class="mb--30">
                    <span class="mr--50"><strong>GRE: </strong>{{ background.greTotal }}</span>
                    <span class="mr--50"><strong>VERBAL: </strong>{{ background.greVerbal }}</span>
                    <span class="mr--50"><strong>QUANTITATIVE: </strong>{{ background.greQuantitative }}</span>
                    <span class="mr--50"><strong>ANALYTICAL WRITING: </strong>{{ background.greAnalyticalWriting }}</span>
                </p>
            </div>
            <router-link v-if="isEditable" class="over-link" to="/edit-profile?to=application"></router-link>
        </div>
    </div>

</template>

<script>

export default {
    name: 'BackgroundCard',
    props: {
        background: {},
        cardTitle:{
            type: String,
            default: "Background Card"
        },
        isEditableObj: {},
        isEditable: {
            type: Boolean,
            default: false
        }
    },
    components: {

    },
    data() {
        return {

        }
    },
    created() {

    },
    methods: {

    }
}
</script>

<style>
  .mb--30 strong {
    color: #6c757d;
  }

  p span {
    font-size: 15px;
  }
</style>

