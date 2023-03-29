<template>
    <div class="rn-popup-modal background-modal-wrapper modal fade" id="backgroundModal" tabindex="-1" aria-hidden="true">
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
            <i class="feather-x"/>
        </button>

        <BackgroundCard :background="background" :card-title="cardTitle"/>

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
