<template>
    <div class="rn-popup-modal report-modal-wrapper modal fade" :id="`backgroundModal-${background.id}`" tabindex="-1" aria-hidden="true">
        <button type="button" class="btn-close" :data-bs-dismiss="`modal`" aria-label="Close">
            <i class="feather-x"/>
        </button>

        <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable" style="max-width: 60%;">
            <div class="modal-content report-content-wrapper">
                <background-card :background="background" :card-title="cardTitle" :is-editable="false"/>

<!--                <div class="modal-header report-modal-header">-->
<!--                    <h5 class="modal-title">-->
<!--                        Why are you reporting?-->

<!--                    </h5>-->
<!--                </div>-->
<!--                <div class="modal-body">-->
<!--                    <p>Describe why you think this item should be removed from marketplace</p>-->
<!--                    <div class="report-form-box">-->
<!--                        <h6 class="title">Message</h6>-->
<!--                        <textarea name="message" placeholder="Write issues"></textarea>-->
<!--                        <div class="report-button">-->
<!--                            <button type="button" class="btn btn-primary mr&#45;&#45;10 w-auto">Report</button>-->
<!--                            <button type="button" class="btn btn-primary-alta w-auto" data-bs-dismiss="modal">Cancel</button>-->
<!--                        </div>-->
<!--                    </div>-->
<!--                </div>-->

            </div>
        </div>

    </div>
</template>

<script>

import BackgroundCard from "@/components/myComp/background/BackgroundCard.vue";

export default {
    name: "BackgroundModal",
    props: {
        background: {},
        cardTitle:{
            type: String,
            default: "Background Card"
        }
    },
    components: {
        BackgroundCard
    }
}
</script>

<style scoped>

</style>
