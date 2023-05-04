<template>
    <div class="rn-popup-modal report-modal-wrapper modal fade" :id="`application-edit-modal-${application.id}`" tabindex="-1" aria-hidden="true">
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
            <i class="feather-x"/>
        </button>
        <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable" style="max-width: 490px;">

            <div class="modal-content report-content-wrapper">
                <div class="modal-header report-modal-header">
                    <h1 class="modal-title">
                        Update Your Application Here
                    </h1>
                </div>

                <div class="modal-body">
                    <div class="mt--10 mb--35" style="font-size: 13px;">
                        If your are ADMITTED or REJECTED, the application status and your background would be published to the Decision Exploration section.
                    </div>
                    <div class="report-form-box">
                        <div class="input-two-wrapper">
                            <!-- application status -->
                            <div class="half-wid">
                                <label :for="`application-status-selection-${application.id}`" class="form-label mb--10" style="font-size: 15px;">Application Status</label>
                                <select :id="`application-status-selection-${application.id}`" class="profile-edit-select w-100 mt--0 m-lg-0" v-model="this.eStatus">
                                    <option value="ADMITTED">ADMITTED</option>
                                    <option value="REJECTED">REJECTED</option>
                                    <option value="AWAITING_REVIEW">AWAITING_REVIEW</option>
                                    <option value="AWAITING_DECISION">AWAITING_DECISION</option>
                                </select>
                            </div>
                            <!-- application round -->
                            <div class="half-wid ml--15">
                                <label :for="`application-round-selection-${application.id}`" class="form-label mb--10" style="font-size: 15px;">Application Round</label>
                                <select :id="`application-round-selection-${application.id}`" class="profile-edit-select w-100 mt--0 m-lg-0" v-model="this.eRound">
                                    <option value="SPRING_2023">SPRING_2023</option>
                                    <option value="SUMMER_2023">SUMMER_2023</option>
                                    <option value="FALL_2023">FALL_2023</option>
                                    <option value="SPRING_2024">SPRING_2024</option>
                                    <option value="SUMMER_2024">SUMMER_2024</option>
                                    <option value="FALL_2024">FALL_2024</option>
                                    <option value="SPRING_2025">SPRING_2025</option>
                                    <option value="SUMMER_2025">SUMMER_2025</option>
                                    <option value="FALL_2025">FALL_2025</option>
                                </select>
                            </div>
                        </div>
                        <!-- application deadline -->
                        <div class="input-two-wrapper">
                            <label :for="`application-deadline-update-${application.id}`" class="form-label mb--10 mt--35" style="font-size: 15px;">Application Deadline</label>
                            <input :id="`application-deadline-update-${application.id}`" class="profile-edit-select" type="date" v-model="this.deadline">
<!--                            <input :id="`application-deadline-update-${application.id}`" class="profile-edit-select" type="date" :value="application.deadline">-->
                        </div>
                        <!-- btn group -->
                        <div class="report-button mt-5">
                            <button v-if="this.eStatus === `ADMITTED` || this.eStatus === `REJECTED`" type="button" class="btn btn-primary mr--10 w-auto" @click="updateApplication">Update and Report</button>
                            <button v-else type="button" class="btn btn-primary mr--10 w-auto" @click="updateApplication">Update</button>
                            <button :id="`btn-close-edit-application-modal-${application.id}`" type="button" class="btn btn-primary-alta w-auto" data-bs-dismiss="modal">Cancel</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import applicationApi from "@/api/application";
    import Toastify from "toastify-js";

    export default {
        name: 'ApplicationEditModal',
        props: {
            application: {}
        },
        data() {
            return {

                eStatus: this.application.eStatus,
                eRound: this.application.eRound,
                deadline: this.application.deadline

            }
        },
        created() {

        },
        methods: {
            updateApplication(){
                // create the request body
                let updateObj = {}
                updateObj.id = this.application.id;
                updateObj.status = this.eStatus;
                updateObj.round = this.eRound;
                updateObj.deadline = this.deadline;

                // call api method
                applicationApi.updateApplication(updateObj)
                    .then(response => {
                        // update the application
                        this.application.eStatus = this.eStatus;
                        this.application.eRound = this.eRound;
                        this.application.deadline = this.deadline;

                        // notify user
                        Toastify({
                            text: "Application Updated Successful!",
                            duration: 3000,
                            close: false,
                            // avatar:"/img/logo-dark.44b49d43.png",
                            gravity: "top", // `top` or `bottom`
                            position: "right", // `left`, `center` or `right`
                            stopOnFocus: false, // Prevents dismissing of toast on hover
                            style: {
                                "font-size": "large",
                                "font-family":"\"Roboto\", sans-serif",
                                background: "linear-gradient(to right, #00b09b, #96c93d)",
                            },
                            onClick: function(){} // Callback after click
                        }).showToast();

                        // close the modal
                        document.getElementById(`btn-close-edit-application-modal-${this.application.id}`).click();
                    })
            }
        }
    }
</script>
