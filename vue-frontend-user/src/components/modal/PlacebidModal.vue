<template>
    <div class="rn-popup-modal placebid-modal-wrapper modal fade" id="placebidModal" tabindex="-1" aria-hidden="true">
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"><i class="feather-x"/></button>
        <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title">Place a bid</h3>
                </div>
                <div class="modal-body">
                    <p>You are about to purchase This Product Form Nuron</p>
                    <div class="placebid-form-box">
                        <h5 class="title">Your bid</h5>
                        <div class="bid-content">
                            <div class="bid-content-top">
                                <div class="bid-content-left">
                                    <input id="value" type="text" name="value">
                                    <span>wETH</span>
                                </div>
                            </div>
                            <div class="bid-content-mid">
                                <div class="bid-content-left">
                                    <span>Your Balance</span>
                                    <span>Service fee</span>
                                    <span>Total bid amount</span>
                                </div>
                                <div class="bid-content-right">
                                    <span>9578 wETH</span>
                                    <span>10 wETH</span>
                                    <span>9588 wETH</span>
                                </div>
                            </div>
                        </div>
                        <div class="bit-continue-button">
                            <router-link to="/connect" class="btn btn-primary w-100">Place a bid</router-link>
                            <button type="button" class="btn btn-primary-alta mt--10" data-bs-dismiss="modal">Cancel</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'PlacebidModal'
    }
</script>