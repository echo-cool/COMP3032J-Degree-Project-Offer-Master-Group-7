<template>

    <div class="col-lg-11 col-md-6 col-sm-6 col-12 mb--50" v-if="background !== null">
        <div class="rn-address rn-service-one">
            <div class="inner">
                <div class="icon">
                    <img src="/img/shape-1.a3cb4828.png" alt="Shape">
                </div>
                <h2 class="title">{{ cardTitle }}</h2>
                <p class="mb--30">
                    <span class="mr--50" v-if="!isNaN(background.gpa)"><strong>GPA: </strong>{{ background.gpa.toFixed(1) }}</span>
                    <span class="mr--50" v-else><strong>GPA: </strong>No Reported Data</span>
                    <span class="mr--50" v-if="!isNaN(background.ranking)"><strong>Rank: </strong>{{ background.ranking.toFixed(0) }}</span>
                    <span class="mr--50" v-else><strong>Rank: </strong>No Reported Data</span>
                </p>
                <p class="mb--30" v-if="!isAverage">
                    <span class="mr--50"><strong>Undergraduate School Level: </strong>{{ background.underGradSchoolCate }}</span>
                </p>
                <p class="mb--30" v-if="!isAverage">
                    <span class="mr--50"><strong>Undergraduate Major: </strong>{{ background.underGradMajor }}</span>
                </p>
                <p class="mb--30" v-if="isAverage || background.testType === `IELTS`">
                    <span class="mr--50" v-if="!isNaN(background.totalIELTS)"><strong>IELTS: </strong>{{ background.totalIELTS.toFixed(1) }}</span>
                    <span class="mr--50" v-else><strong>IELTS: </strong>No Reported Data</span>
                    <span class="mr--50" v-if="!isNaN(background.listeningIELTS)"><strong>LISTENING: </strong>{{ background.listeningIELTS.toFixed(1) }}</span>
                    <span class="mr--50" v-else><strong>LISTENING: </strong>No Reported Data</span>
                    <span class="mr--50" v-if="!isNaN(background.readingIELTS)"><strong>READING: </strong>{{ background.readingIELTS.toFixed(1) }}</span>
                    <span class="mr--50" v-else><strong>READING: </strong>No Reported Data</span>
                    <span class="mr--50" v-if="!isNaN(background.writingIELTS)"><strong>WRITING: </strong>{{ background.writingIELTS.toFixed(1) }}</span>
                    <span class="mr--50" v-else><strong>WRITING: </strong>No Reported Data</span>
                    <span class="mr--50" v-if="!isNaN(background.writingIELTS)"><strong>SPEAKING: </strong>{{ background.speakingIELTS.toFixed(1) }}</span>
                    <span class="mr--50" v-else><strong>SPEAKING: </strong>No Reported Data</span>
                </p>
                <p class="mb--30" v-else-if="background.testType === `TOEFL`">
                    <span class="mr--50"><strong>IELTS: </strong>{{ background.totalTOEFL }}</span>
                    <span class="mr--50"><strong>LISTENING: </strong>{{ background.listeningTOEFL }}</span>
                    <span class="mr--50"><strong>READING: </strong>{{ background.readingTOEFL }}</span>
                    <span class="mr--50"><strong>WRITING: </strong>{{ background.writingTOEFL }}</span>
                    <span class="mr--50"><strong>SPEAKING: </strong>{{ background.speakingTOEFL }}</span>
                </p>
                <p class="mb--30">
                    <span class="mr--50" v-if="!isNaN(background.greTotal)"><strong>GRE: </strong>{{ background.greTotal.toFixed(1) }}</span>
                    <span class="mr--50" v-else><strong>GRE: </strong>No Reported Data</span>
                    <span class="mr--50" v-if="!isNaN(background.greVerbal)"><strong>VERBAL: </strong>{{ background.greVerbal.toFixed(1) }}</span>
                    <span class="mr--50" v-else><strong>VERBAL: </strong>No Reported Data</span>
                    <span class="mr--50" v-if="!isNaN(background.greQuantitative)"><strong>QUANTITATIVE: </strong>{{ background.greQuantitative.toFixed(1) }}</span>
                    <span class="mr--50" v-else><strong>QUANTITATIVE: </strong>No Reported Data</span>
                    <span class="mr--50" v-if="!isNaN(background.greAnalyticalWriting)"><strong>ANALYTICAL WRITING: </strong>{{ background.greAnalyticalWriting.toFixed(1) }}</span>
                    <span class="mr--50" v-else><strong>ANALYTICAL WRITING: </strong>No Reported Data</span>
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
        },
        isAverage: {
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
    font-size: 18px;
  }
</style>

