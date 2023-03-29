<template>

    <div class="col-lg-11 col-md-6 col-sm-6 col-12 mb--50" v-if="background !== null">
        <div class="rn-address rn-service-one">
            <div class="inner">
                <div class="icon">
                    <img src="/img/shape-1.a3cb4828.png" alt="Shape">
                </div>
                <h3 class="title">{{ cardTitle }}</h3>
                <p class="mb--30">
                    <span class="mr--50"><strong class="color-green">GPA: </strong>{{ background.gpa }}</span>
                    <span class="mr--50"><strong class="color-green">Rank: </strong>{{ background.rank }}</span>
                </p>
                <p class="mb--30">
                    <span class="mr--50"><strong class="color-green">Undergraduate School Level: </strong>{{ background.underGradSchoolCate }}</span>
                </p>
                <p class="mb--30">
                    <span class="mr--50"><strong class="color-green">Undergraduate Major: </strong>{{ background.underGradMajor }}</span>
                </p>
                <p class="mb--30" v-if="background.testType === `IELTS`">
                    <span class="mr--50"><strong class="color-green">IELTS: </strong>{{ background.totalIELTS }}</span>
                    <span class="mr--50"><strong class="color-green">LISTENING: </strong>{{ background.listeningIELTS }}</span>
                    <span class="mr--50"><strong class="color-green">READING: </strong>{{ background.readingIELTS }}</span>
                    <span class="mr--50"><strong class="color-green">WRITING: </strong>{{ background.writingIELTS }}</span>
                    <span class="mr--50"><strong class="color-green">SPEAKING: </strong>{{ background.speakingIELTS }}</span>
                </p>
                <p class="mb--30" v-else-if="background.testType === `TOEFL`">
                    <span class="mr--50"><strong class="color-green">IELTS: </strong>{{ background.totalTOEFL }}</span>
                    <span class="mr--50"><strong class="color-green">LISTENING: </strong>{{ background.listeningTOEFL }}</span>
                    <span class="mr--50"><strong class="color-green">READING: </strong>{{ background.readingTOEFL }}</span>
                    <span class="mr--50"><strong class="color-green">WRITING: </strong>{{ background.writingTOEFL }}</span>
                    <span class="mr--50"><strong class="color-green">SPEAKING: </strong>{{ background.speakingTOEFL }}</span>
                </p>
                <p class="mb--30">
                    <span class="mr--50"><strong class="color-green">GRE: </strong>{{ background.greTotal }}</span>
                    <span class="mr--50"><strong class="color-green">VERBAL: </strong>{{ background.greVerbal }}</span>
                    <span class="mr--50"><strong class="color-green">QUANTITATIVE: </strong>{{ background.greQuantitative }}</span>
                    <span class="mr--50"><strong class="color-green">ANALYTICAL WRITING: </strong>{{ background.greAnalyticalWriting }}</span>
                </p>
            </div>
            <router-link v-if="isEditableObj.isEditable" class="over-link" to="/edit-profile?to=application"></router-link>
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
        isEditableObj: {}
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

