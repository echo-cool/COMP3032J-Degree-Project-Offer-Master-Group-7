<template>
    <layout>
        <breadcrumb title="Crete a New File" current="Crete a New File"/>

        <div class="create-area rn-section-gapTop">
            <div class="container">
                <div class="row g-5">
                    <div class="col-lg-3 offset-1 ml_md--0 ml_sm--0">
                        <!-- Start file Upload Area -->
                        <div class="upload-area">
                            <div class="upload-formate mb--30">
                                <h6 class="title">
                                    Upload file
                                </h6>
                                <p class="formate">
                                    Drag or choose your file to upload
                                </p>
                            </div>
                            <div class="brows-file-wrapper">
                                <input
                                    id="file"
                                    type="file"
                                    class="inputfile"
                                    multiple
                                    @change="imageChange"
                                />
                                <img
                                    v-if="selectedImage"
                                    id="createfileImage"
                                    :src="selectedImage"
                                    alt=""
                                    data-black-overlay="6"
                                />
                                <label for="file" title="No File Choosen">
                                    <i class="feather-upload"/>
                                    <span class="text-center">Choose a File</span>
                                    <p class="text-center mt--10">
                                        PNG, GIF, WEBP, MP4 or MP3.{" "} <br/> Max 1Gb.
                                    </p>
                                </label>
                            </div>
                        </div>
                        <!-- End File Upload Area -->

                        <div class="mt--100 mt_sm--30 mt_md--30 d-none d-lg-block">
                            <h5> Note: </h5>
                            <span> Service fee : <strong>2.5%</strong> </span> <br>
                            <span> You will receive : <strong>25.00 ETH $50,000</strong></span>
                        </div>
                    </div>

                    <div class="col-lg-7">
                        <div class="form-wrapper-one">
                            <form class="row" action="#">
                                <div class="col-md-12">
                                    <div class="input-box pb--20">
                                        <label for="name" class="form-label">Product Name</label>
                                        <input id="name" placeholder="e. g. `Digital Awesome Game`">
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="input-box pb--20">
                                        <label for="Description" class="form-label">Description</label>
                                        <textarea
                                            id="Description"
                                            rows="3"
                                            placeholder="e. g. “After purchasing the product you can get item...”">
                                        </textarea>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="input-box pb--20">
                                        <label for="dollerValue" class="form-label">Item Price in $</label>
                                        <input id="dollerValue" placeholder="e. g. `20$`">
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="input-box pb--20">
                                        <label for="Size" class="form-label">Size</label>
                                        <input id="Size" placeholder="e. g. `Size`">
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="input-box pb--20">
                                        <label for="Properties" class="form-label">Properties</label>
                                        <input id="Properties" placeholder="e. g. `Properties`">
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="input-box pb--20">
                                        <label for="Royality" class="form-label">Royality</label>
                                        <input id="Royality" placeholder="e. g. `20%`">
                                    </div>
                                </div>
                                <div class="col-md-4 col-sm-4">
                                    <div class="input-box pb--20 rn-check-box">
                                        <input class="rn-check-box-input" type="checkbox" id="putonsale">
                                        <label class="rn-check-box-label" for="putonsale">
                                            Put on Sale
                                        </label>
                                    </div>
                                </div>
                                <div class="col-md-4 col-sm-4">
                                    <div class="input-box pb--20 rn-check-box">
                                        <input class="rn-check-box-input" type="checkbox" id="instantsaleprice">
                                        <label class="rn-check-box-label" for="instantsaleprice">
                                            Instant Sale Price
                                        </label>
                                    </div>
                                </div>
                                <div class="col-md-4 col-sm-4">
                                    <div class="input-box pb--20 rn-check-box">
                                        <input class="rn-check-box-input" type="checkbox" id="unlockpurchased">
                                        <label class="rn-check-box-label" for="unlockpurchased">
                                            Unlock Purchased
                                        </label>
                                    </div>
                                </div>
                                <div class="col-md-12 col-xl-4">
                                    <div class="input-box">
                                        <button type="button" class="btn btn-primary-alta btn-large w-100"
                                                data-bs-toggle="modal" data-bs-target="#uploadModal">Preview
                                        </button>
                                    </div>
                                </div>
                                <div class="col-md-12 col-xl-8 mt_lg--15 mt_md--15 mt_sm--15">
                                    <div class="input-box">
                                        <button class="btn btn-primary btn-large w-100">Submit Item</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="mt--100 mt_sm--30 mt_md--30 d-block d-lg-none">
                        <h5> Note: </h5>
                        <span> Service fee : <strong>2.5%</strong> </span> <br>
                        <span> You will receive : <strong>25.00 ETH $50,000</strong></span>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal -->
        <div class="rn-popup-modal upload-modal-wrapper modal fade" id="uploadModal" tabindex="-1" aria-hidden="true">
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
                <i class="feather-x"/>
            </button>
            <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
                <div class="modal-content share-wrapper">
                    <div class="modal-body">
                        <product-card :product-date="product" product-style-class="no-overlay"/>
                    </div>
                </div>
            </div>
        </div>

        <share-modal/>

        <report-modal/>
    </layout>
</template>

<script>
    import Layout from '@/components/layouts/Layout'
    import Breadcrumb from '@/components/breadcrumb/Breadcrumb'
    import ProductCard from '@/components/product/ProductCard'
    import ShareModal from '@/components/modal/ShareModal'
    import ReportModal from '@/components/modal/ReportModal'

    export default {
        name: 'CreateProduct',
        components: {ReportModal, ShareModal, ProductCard, Breadcrumb, Layout},
        data() {
            return {
                selectedImage: null,
                product: {
                    id: 1,
                    productImage: require(`@/assets/images/portfolio/portfolio-01.jpg`),
                    authors: [
                        {
                            id: 1,
                            name: 'Jone lee',
                            image: require(`@/assets/images/client/client-1.png`)
                        },
                        {
                            id: 2,
                            name: 'Jone lee',
                            image: require(`@/assets/images/client/client-2.png`)
                        },
                        {
                            id: 3,
                            name: 'Nisat Tara',
                            image: require(`@/assets/images/client/client-3.png`)
                        }
                    ],
                    biddingAmount: '9',
                    productName: 'Preatent',
                    latestBid: 'Highest bid 1/20',
                    lastBid: '0.244wETH',
                    reacted: '322'
                }
            }
        },
        methods: {
            imageChange(e) {
                if (e.target.files && e.target.files.length > 0) {
                    const file = e.target.files[0];
                    this.selectedImage = URL.createObjectURL(file);
                }
            }
        }
    }
</script>