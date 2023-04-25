<template>
    <layout>
        <breadcrumb title="Program Details" current="Program Details"/>

        <!-- Start product details area -->
        <div class="product-details-area rn-section-gapTop">
            <div class="container">
                <div class="row g-5">
                    <!-- Product image area Start -->
                    <div class="col-lg-6 col-md-12 col-sm-12">
                        <div class="product-tab-wrapper rbt-sticky-top-adjust">
                            <div class="pd-tab-inner">
                                <div class="nav rn-pd-nav rn-pd-rt-content nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                                    <button :class="[`nav-link`, {'active': index === activeTabIndex}]"
                                            :id="`v-pills-${index}-tab`"
                                            data-bs-toggle="pill"
                                            :data-bs-target="`#v-pills-home-${index}`"
                                            type="button"
                                            role="tab"
                                            :aria-controls="`v-pills-home-${index}`"
                                            :aria-selected="index === activeTabIndex ? 'true' : 'false'"
                                            v-for="(thumbnailSm, index) in product.extraImages"
                                            :key="`small-thumbnail-${index}`">
                                        <span class="rn-pd-sm-thumbnail">
                                          <div class="text-center" style="display: flex; justify-content: center; align-content: center; align-items: center">
                                            <b-spinner label="Spinning" style="position: absolute; width: 30px; height: 30px; z-index: 0"></b-spinner>
                                            <img style="position: relative; z-index: 4" width="164" height="164" :src="`/backend/static/`+thumbnailSm" alt="Nft_Profile">
                                          </div>
                                        </span>
                                    </button>
                                </div>
                                <div class="tab-content rn-pd-content" id="v-pills-tabContent">
                                    <div :class="[`tab-pane fade`, {'show active': index === activeTabIndex}]"
                                         :id="`v-pills-home-${index}`"
                                         role="tabpanel"
                                         :aria-labelledby="`v-pills-${index}-tab`"
                                         v-for="(thumbnailLg, index) in product.extraImages"
                                         :key="`large-thumbnail-${index}`">
                                        <div class="rn-pd-thumbnail">
                                            <div class="text-center" style="display: flex; justify-content: center; align-content: center; align-items: center">
                                                <b-spinner label="Spinning" style="position: absolute; width: 40px; height: 40px; z-index: 0"></b-spinner>

                                                <img style="min-height: 330px; position: relative; z-index: 4" :src="`/backend/static/`+thumbnailLg" alt="Nft_Profile">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Product image area end -->

                    <div class="col-lg-6 col-md-12 col-sm-12 mt_md--50 mt_sm--60">
                        <div class="rn-pd-content-area">
                            <div class="pd-title-area">
                                <h4 class="title">{{ product.name }}</h4>
                                <div class="pd-react-area">
                                    <div class="heart-count">
                                        <i class="feather-heart"/>
                                        <span>{{ product.likesNumber }}</span>
                                    </div>
                                    <div class="count">
                                        <div class="share-btn share-btn-activation dropdown">
                                            <button class="icon" data-bs-toggle="dropdown" aria-expanded="false">
                                                <i class="feather-more-horizontal"/>
                                            </button>
                                            <div class="share-btn-setting dropdown-menu dropdown-menu-end">
                                                <button type="button" class="btn-setting-text share-text" data-bs-toggle="modal" data-bs-target="#shareModal">
                                                    Share
                                                </button>
                                                <button type="button" class="btn-setting-text report-text" data-bs-toggle="modal" data-bs-target="#reportModal">
                                                    Report
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <span class="bid">
                                Degree <span class="price">{{ product.degree }}</span>
                            </span>
                           <h6></h6>
        <div class="top-seller-inner-one" :class="sellerStyleClass" style="weight: 250px; height: 120px; overflow: hidden">
            <div class="top-seller-wrapper">
                <div :class="[`thumbnail`, {'varified': false}]">
<!--                <router-link :to="`/author/${sellerData.id}`">-->
                    <router-link :to="`/school-details/`+school.id">
                        <img v-if="school.img" :src="`/backend/static/`+school.img" alt="school-img" style="height: 50px;width: 50px">
                        <img v-else :src="require(`@/assets/images/client/client-1.png`)" alt="school-img">
                    </router-link>
                </div>

                <div class="top-seller-content">
<!--                <router-link :to="`/author/${sellerData.id}`">-->
                    <router-link :to="`/school-details/`+school.id">
                        <h6 class="name" v-if="school.name.length > 20">{{school.name.substring(0,20) + `..` }}</h6>

                        <h6 class="name" v-else>{{school.name}}</h6>
                     </router-link>
                <span class="count-number">
                    QS: {{ school.rankQS }}
                </span>
                <span class="count-number">
                    U.S. News: {{ school.rankUSNews }}
                </span>
            </div>
        </div>
        <router-link
            v-if="sellerStyleClass === 'explore'"
            class="over-link"
            :to="`/school-details/`+school.id"
        />
    </div>
        <h6 class="title-name"> Major: {{product.major}}</h6>
<!--                            <div class="catagory-collection">-->
<!--                                <div class="catagory">-->
<!--                                    <span>-->
<!--                                        Catagory <span class="color-body">10% royalties</span>-->
<!--                                    </span>-->
<!--                                    <div class="top-seller-inner-one">-->
<!--                                        <div class="top-seller-wrapper">-->
<!--                                            <div class="thumbnail">-->
<!--                                                <router-link to="/author/1">-->
<!--                                                    <img :src="require(`@/assets/images/client/client-1.png`)" alt="Nft_Profile">-->
<!--                                                </router-link>-->
<!--                                            </div>-->
<!--                                            <div class="top-seller-content">-->
<!--                                                <router-link to="/author/1">-->
<!--                                                    <h6 class="name">Brodband</h6>-->
<!--                                                </router-link>-->
<!--                                            </div>-->
<!--                                        </div>-->
<!--                                    </div>-->
<!--                                </div>-->
<!--                                <div class="collection">-->
<!--                                    <span>Collections</span>-->
<!--                                    <div class="top-seller-inner-one">-->
<!--                                        <div class="top-seller-wrapper">-->
<!--                                            <div class="thumbnail">-->
<!--                                                <router-link to="/author/2">-->
<!--                                                    <img :src="require(`@/assets/images/client/client-2.png`)" alt="Nft_Profile">-->
<!--                                                </router-link>-->
<!--                                            </div>-->
<!--                                            <div class="top-seller-content">-->
<!--                                                <router-link to="/author/2">-->
<!--                                                    <h6 class="name">Brodband</h6>-->
<!--                                                </router-link>-->
<!--                                            </div>-->
<!--                                        </div>-->
<!--                                    </div>-->
<!--                                </div>-->
<!--                            </div>-->
<!--                            <router-link class="btn btn-primary-alta" to="#">Unlockable content included</router-link>-->
                            <div class="rn-bid-details">
                                <div class="tab-wrapper-one">
<!--                                  <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">-->
<!--                                    <div class="rn-pd-bd-wrapper">-->
<!--                                      <div class="top-seller-inner-one">-->
<!--                                        <h6 class="name-title">Owner</h6>-->
<!--                                        <div class="top-seller-wrapper">-->
<!--                                          <div class="thumbnail">-->
<!--                                            <router-link to="#">-->
<!--                                              <img :src="require(`@/assets/images/client/client-1.png`)" alt="Nft_Profile">-->
<!--                                            </router-link>-->
<!--                                          </div>-->
<!--                                          <div class="top-seller-content">-->
<!--                                            <router-link to="#">-->
<!--                                              <h6 class="name">Brodband</h6>-->
<!--                                            </router-link>-->
<!--                                          </div>-->
<!--                                        </div>-->
<!--                                      </div>-->
<!--                                      <div class="rn-pd-sm-property-wrapper">-->
<!--                                        <h6 class="pd-property-title">-->
<!--                                          Property-->
<!--                                        </h6>-->
<!--                                        <div class="property-wrapper">-->
<!--                                          &lt;!&ndash; single property &ndash;&gt;-->
<!--                                          <div class="pd-property-inner">-->
<!--                                            <span class="color-body type">HYPE TYPE</span>-->
<!--                                            <span class="color-white value">CALM AF (STILL)</span>-->
<!--                                          </div>-->
<!--                                          &lt;!&ndash; single property End &ndash;&gt;-->

<!--                                          &lt;!&ndash; single property &ndash;&gt;-->
<!--                                          <div class="pd-property-inner">-->
<!--                                            <span class="color-body type">BASTARDNESS</span>-->
<!--                                            <span class="color-white value">C00LIO BASTARD</span>-->
<!--                                          </div>-->
<!--                                          &lt;!&ndash; single property End &ndash;&gt;-->

<!--                                          &lt;!&ndash; single property &ndash;&gt;-->
<!--                                          <div class="pd-property-inner">-->
<!--                                            <span class="color-body type">TYPE</span>-->
<!--                                            <span class="color-white value">APE</span>-->
<!--                                          </div>-->
<!--                                          &lt;!&ndash; single property End &ndash;&gt;-->

<!--                                          &lt;!&ndash; single property &ndash;&gt;-->
<!--                                          <div class="pd-property-inner">-->
<!--                                            <span class="color-body type">ASTARDNESS</span>-->
<!--                                            <span class="color-white value">BASTARD</span>-->
<!--                                          </div>-->
<!--                                          &lt;!&ndash; single property End &ndash;&gt;-->

<!--                                          &lt;!&ndash; single property &ndash;&gt;-->
<!--                                          <div class="pd-property-inner">-->
<!--                                            <span class="color-body type">BAD HABIT(S)</span>-->
<!--                                            <span class="color-white value">PIPE</span>-->
<!--                                          </div>-->
<!--                                          &lt;!&ndash; single property End &ndash;&gt;-->

<!--                                          &lt;!&ndash; single property &ndash;&gt;-->
<!--                                          <div class="pd-property-inner">-->
<!--                                            <span class="color-body type">BID</span>-->
<!--                                            <span class="color-white value">BPEYti</span>-->
<!--                                          </div>-->
<!--                                          &lt;!&ndash; single property End &ndash;&gt;-->

<!--                                          &lt;!&ndash; single property &ndash;&gt;-->
<!--                                          <div class="pd-property-inner">-->
<!--                                            <span class="color-body type">ASTRAGENAKAR</span>-->
<!--                                            <span class="color-white value">BASTARD</span>-->
<!--                                          </div>-->
<!--                                          &lt;!&ndash; single property End &ndash;&gt;-->

<!--                                          &lt;!&ndash; single property &ndash;&gt;-->
<!--                                          <div class="pd-property-inner">-->
<!--                                            <span class="color-body type">CITY</span>-->
<!--                                            <span class="color-white value">TOKYO</span>-->
<!--                                          </div>-->
<!--                                          &lt;!&ndash; single property End &ndash;&gt;-->
<!--                                        </div>-->
<!--                                      </div>-->
<!--                                      <div class="rn-pd-sm-property-wrapper">-->
<!--                                        <h6 class="pd-property-title">Catagory</h6>-->
<!--                                        <div class="catagory-wrapper">-->
<!--                                          &lt;!&ndash; single property &ndash;&gt;-->
<!--                                          <div class="pd-property-inner">-->
<!--                                            <span class="color-body type">ZARY</span>-->
<!--                                            <span class="color-white value">APP</span>-->
<!--                                          </div>-->
<!--                                          &lt;!&ndash; single property End &ndash;&gt;-->

<!--                                          &lt;!&ndash; single property &ndash;&gt;-->
<!--                                          <div class="pd-property-inner">-->
<!--                                            <span class="color-body type">SOMALIAN</span>-->
<!--                                            <span class="color-white value">TRIBUTE</span>-->
<!--                                          </div>-->
<!--                                          &lt;!&ndash; single property End &ndash;&gt;-->

<!--                                          &lt;!&ndash; single property &ndash;&gt;-->
<!--                                          <div class="pd-property-inner">-->
<!--                                            <span class="color-body type">TUNA</span>-->
<!--                                            <span class="color-white value">PIPE</span>-->
<!--                                          </div>-->
<!--                                          &lt;!&ndash; single property End &ndash;&gt;-->

<!--                                          &lt;!&ndash; single property &ndash;&gt;-->
<!--                                          <div class="pd-property-inner">-->
<!--                                            <span class="color-body type">BID</span>-->
<!--                                            <span class="color-white value">BPEYti</span>-->
<!--                                          </div>-->
<!--                                          &lt;!&ndash; single property End &ndash;&gt;-->

<!--                                          &lt;!&ndash; single property &ndash;&gt;-->
<!--                                          <div class="pd-property-inner">-->
<!--                                            <span class="color-body type">ASTRAGENAKAR</span>-->
<!--                                            <span class="color-white value">BASTARD</span>-->
<!--                                          </div>-->
<!--                                          &lt;!&ndash; single property End &ndash;&gt;-->

<!--                                          &lt;!&ndash; single property &ndash;&gt;-->
<!--                                          <div class="pd-property-inner">-->
<!--                                            <span class="color-body type">CITY</span>-->
<!--                                            <span class="color-white value">TOKYO</span>-->
<!--                                          </div>-->
<!--                                          &lt;!&ndash; single property End &ndash;&gt;-->
<!--                                        </div>-->
<!--                                      </div>-->
<!--                                    </div>-->
<!--                                  </div>-->

<!--                                    <nav class="tab-button-one">-->
<!--                                        <div class="nav nav-tabs" id="nav-tab" role="tablist">-->
<!--                                          <button class="nav-link"-->
<!--                                                  id="nav-profile-tab"-->
<!--                                                  data-bs-toggle="tab"-->
<!--                                                  data-bs-target="#nav-profile"-->
<!--                                                  type="button"-->
<!--                                                  role="tab"-->
<!--                                                  aria-controls="nav-profile"-->
<!--                                                  aria-selected="true">-->
<!--                                            Details-->
<!--                                          </button>-->
<!--                                            <button class="nav-link active"-->
<!--                                                    id="nav-home-tab"-->
<!--                                                    data-bs-toggle="tab"-->
<!--                                                    data-bs-target="#nav-home"-->
<!--                                                    type="button"-->
<!--                                                    role="tab"-->
<!--                                                    aria-controls="nav-home"-->
<!--                                                    aria-selected="false">-->
<!--                                                Bids-->
<!--                                            </button>-->

<!--                                            <button class="nav-link"-->
<!--                                                    id="nav-contact-tab"-->
<!--                                                    data-bs-toggle="tab"-->
<!--                                                    data-bs-target="#nav-contact"-->
<!--                                                    type="button"-->
<!--                                                    role="tab"-->
<!--                                                    aria-controls="nav-contact"-->
<!--                                                    aria-selected="false">-->
<!--                                                History-->
<!--                                            </button>-->
<!--                                        </div>-->
<!--                                    </nav>-->
<!--                                    <div class="tab-content rn-bid-content" id="nav-tabContent">-->
<!--                                        <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">-->
<!--                                            &lt;!&ndash; Single creator &ndash;&gt;-->
<!--                                            <div class="top-seller-inner-one">-->
<!--                                                <div class="top-seller-wrapper">-->
<!--                                                    <div class="thumbnail">-->
<!--                                                        <router-link to="#"><img :src="require(`@/assets/images/client/client-3.png`)" alt="Nft_Profile"></router-link>-->
<!--                                                    </div>-->
<!--                                                    <div class="top-seller-content">-->
<!--                                                        <span>0.11wETH by <router-link to="#">Allen Waltker</router-link></span>-->
<!--                                                        <span class="count-number">1 hours ago</span>-->
<!--                                                    </div>-->
<!--                                                </div>-->
<!--                                            </div>-->
<!--                                            &lt;!&ndash; Single creator &ndash;&gt;-->

<!--                                            &lt;!&ndash; Single creator &ndash;&gt;-->
<!--                                            <div class="top-seller-inner-one">-->
<!--                                                <div class="top-seller-wrapper">-->
<!--                                                    <div class="thumbnail">-->
<!--                                                        <router-link to="#"><img :src="require(`@/assets/images/client/client-4.png`)" alt="Nft_Profile"></router-link>-->
<!--                                                    </div>-->
<!--                                                    <div class="top-seller-content">-->
<!--                                                        <span>0.09wETH by <router-link to="#">Joe Biden</router-link></span>-->
<!--                                                        <span class="count-number">1.30 hours ago</span>-->
<!--                                                    </div>-->
<!--                                                </div>-->
<!--                                            </div>-->
<!--                                            &lt;!&ndash; Single creator &ndash;&gt;-->

<!--                                            &lt;!&ndash; Single creator &ndash;&gt;-->
<!--                                            <div class="top-seller-inner-one">-->
<!--                                                <div class="top-seller-wrapper">-->
<!--                                                    <div class="thumbnail">-->
<!--                                                        <router-link to="#">-->
<!--                                                            <img :src="require(`@/assets/images/client/client-5.png`)" alt="Nft_Profile">-->
<!--                                                        </router-link>-->
<!--                                                    </div>-->
<!--                                                    <div class="top-seller-content">-->
<!--                                                        <span>0.07wETH by <router-link to="#">Sonial mridha</router-link></span>-->
<!--                                                        <span class="count-number">1.35 hours ago</span>-->
<!--                                                    </div>-->
<!--                                                </div>-->
<!--                                            </div>-->
<!--                                            &lt;!&ndash; Single creator &ndash;&gt;-->

<!--                                            &lt;!&ndash; Single creator &ndash;&gt;-->
<!--                                            <div class="top-seller-inner-one">-->
<!--                                                <div class="top-seller-wrapper">-->
<!--                                                    <div class="thumbnail">-->
<!--                                                        <router-link to="#"><img :src="require(`@/assets/images/client/client-6.png`)" alt="Nft_Profile"></router-link>-->
<!--                                                    </div>-->
<!--                                                    <div class="top-seller-content">-->
<!--                                                        <span>0.07wETH by <router-link to="#">Tribute Dhusra</router-link></span>-->
<!--                                                        <span class="count-number">1.55 hours ago</span>-->
<!--                                                    </div>-->
<!--                                                </div>-->
<!--                                            </div>-->
<!--                                            &lt;!&ndash; Single creator &ndash;&gt;-->

<!--                                            &lt;!&ndash; Single creator &ndash;&gt;-->
<!--                                            <div class="top-seller-inner-one">-->
<!--                                                <div class="top-seller-wrapper">-->
<!--                                                    <div class="thumbnail">-->
<!--                                                        <router-link to="#">-->
<!--                                                            <img :src="require(`@/assets/images/client/client-7.png`)" alt="Nft_Profile">-->
<!--                                                        </router-link>-->
<!--                                                    </div>-->
<!--                                                    <div class="top-seller-content">-->
<!--                                                        <span>0.07wETH by <router-link to="#">Sonia Sobnom</router-link></span>-->
<!--                                                        <span class="count-number">2 hours ago</span>-->
<!--                                                    </div>-->
<!--                                                </div>-->
<!--                                            </div>-->
<!--                                            &lt;!&ndash; Single creator &ndash;&gt;-->

<!--                                            &lt;!&ndash; Single creator &ndash;&gt;-->
<!--                                            <div class="top-seller-inner-one">-->
<!--                                                <div class="top-seller-wrapper">-->
<!--                                                    <div class="thumbnail">-->
<!--                                                        <router-link to="#">-->
<!--                                                            <img :src="require(`@/assets/images/client/client-8.png`)" alt="Nft_Profile">-->
<!--                                                        </router-link>-->
<!--                                                    </div>-->
<!--                                                    <div class="top-seller-content">-->
<!--                                                        <span>0.02wETH by <router-link to="#">Sadia Rummon</router-link></span>-->
<!--                                                        <span class="count-number">2.5 hours ago</span>-->
<!--                                                    </div>-->
<!--                                                </div>-->
<!--                                            </div>-->
<!--                                            &lt;!&ndash; Single creator &ndash;&gt;-->
<!--                                        </div>-->
<!--                                        <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">-->
<!--                                            <div class="rn-pd-bd-wrapper">-->
<!--                                                <div class="top-seller-inner-one">-->
<!--                                                    <h6 class="name-title">Owner</h6>-->
<!--                                                    <div class="top-seller-wrapper">-->
<!--                                                        <div class="thumbnail">-->
<!--                                                            <router-link to="#">-->
<!--                                                                <img :src="require(`@/assets/images/client/client-1.png`)" alt="Nft_Profile">-->
<!--                                                            </router-link>-->
<!--                                                        </div>-->
<!--                                                        <div class="top-seller-content">-->
<!--                                                            <router-link to="#">-->
<!--                                                                <h6 class="name">Brodband</h6>-->
<!--                                                            </router-link>-->
<!--                                                        </div>-->
<!--                                                    </div>-->
<!--                                                </div>-->
<!--                                                <div class="rn-pd-sm-property-wrapper">-->
<!--                                                    <h6 class="pd-property-title">-->
<!--                                                        Property-->
<!--                                                    </h6>-->
<!--                                                    <div class="property-wrapper">-->
<!--                                                        &lt;!&ndash; single property &ndash;&gt;-->
<!--                                                        <div class="pd-property-inner">-->
<!--                                                            <span class="color-body type">HYPE TYPE</span>-->
<!--                                                            <span class="color-white value">CALM AF (STILL)</span>-->
<!--                                                        </div>-->
<!--                                                        &lt;!&ndash; single property End &ndash;&gt;-->

<!--                                                        &lt;!&ndash; single property &ndash;&gt;-->
<!--                                                        <div class="pd-property-inner">-->
<!--                                                            <span class="color-body type">BASTARDNESS</span>-->
<!--                                                            <span class="color-white value">C00LIO BASTARD</span>-->
<!--                                                        </div>-->
<!--                                                        &lt;!&ndash; single property End &ndash;&gt;-->

<!--                                                        &lt;!&ndash; single property &ndash;&gt;-->
<!--                                                        <div class="pd-property-inner">-->
<!--                                                            <span class="color-body type">TYPE</span>-->
<!--                                                            <span class="color-white value">APE</span>-->
<!--                                                        </div>-->
<!--                                                        &lt;!&ndash; single property End &ndash;&gt;-->

<!--                                                        &lt;!&ndash; single property &ndash;&gt;-->
<!--                                                        <div class="pd-property-inner">-->
<!--                                                            <span class="color-body type">ASTARDNESS</span>-->
<!--                                                            <span class="color-white value">BASTARD</span>-->
<!--                                                        </div>-->
<!--                                                        &lt;!&ndash; single property End &ndash;&gt;-->

<!--                                                        &lt;!&ndash; single property &ndash;&gt;-->
<!--                                                        <div class="pd-property-inner">-->
<!--                                                            <span class="color-body type">BAD HABIT(S)</span>-->
<!--                                                            <span class="color-white value">PIPE</span>-->
<!--                                                        </div>-->
<!--                                                        &lt;!&ndash; single property End &ndash;&gt;-->

<!--                                                        &lt;!&ndash; single property &ndash;&gt;-->
<!--                                                        <div class="pd-property-inner">-->
<!--                                                            <span class="color-body type">BID</span>-->
<!--                                                            <span class="color-white value">BPEYti</span>-->
<!--                                                        </div>-->
<!--                                                        &lt;!&ndash; single property End &ndash;&gt;-->

<!--                                                        &lt;!&ndash; single property &ndash;&gt;-->
<!--                                                        <div class="pd-property-inner">-->
<!--                                                            <span class="color-body type">ASTRAGENAKAR</span>-->
<!--                                                            <span class="color-white value">BASTARD</span>-->
<!--                                                        </div>-->
<!--                                                        &lt;!&ndash; single property End &ndash;&gt;-->

<!--                                                        &lt;!&ndash; single property &ndash;&gt;-->
<!--                                                        <div class="pd-property-inner">-->
<!--                                                            <span class="color-body type">CITY</span>-->
<!--                                                            <span class="color-white value">TOKYO</span>-->
<!--                                                        </div>-->
<!--                                                        &lt;!&ndash; single property End &ndash;&gt;-->
<!--                                                    </div>-->
<!--                                                </div>-->
<!--                                                <div class="rn-pd-sm-property-wrapper">-->
<!--                                                    <h6 class="pd-property-title">Catagory</h6>-->
<!--                                                    <div class="catagory-wrapper">-->
<!--                                                        &lt;!&ndash; single property &ndash;&gt;-->
<!--                                                        <div class="pd-property-inner">-->
<!--                                                            <span class="color-body type">ZARY</span>-->
<!--                                                            <span class="color-white value">APP</span>-->
<!--                                                        </div>-->
<!--                                                        &lt;!&ndash; single property End &ndash;&gt;-->

<!--                                                        &lt;!&ndash; single property &ndash;&gt;-->
<!--                                                        <div class="pd-property-inner">-->
<!--                                                            <span class="color-body type">SOMALIAN</span>-->
<!--                                                            <span class="color-white value">TRIBUTE</span>-->
<!--                                                        </div>-->
<!--                                                        &lt;!&ndash; single property End &ndash;&gt;-->

<!--                                                        &lt;!&ndash; single property &ndash;&gt;-->
<!--                                                        <div class="pd-property-inner">-->
<!--                                                            <span class="color-body type">TUNA</span>-->
<!--                                                            <span class="color-white value">PIPE</span>-->
<!--                                                        </div>-->
<!--                                                        &lt;!&ndash; single property End &ndash;&gt;-->

<!--                                                        &lt;!&ndash; single property &ndash;&gt;-->
<!--                                                        <div class="pd-property-inner">-->
<!--                                                            <span class="color-body type">BID</span>-->
<!--                                                            <span class="color-white value">BPEYti</span>-->
<!--                                                        </div>-->
<!--                                                        &lt;!&ndash; single property End &ndash;&gt;-->

<!--                                                        &lt;!&ndash; single property &ndash;&gt;-->
<!--                                                        <div class="pd-property-inner">-->
<!--                                                            <span class="color-body type">ASTRAGENAKAR</span>-->
<!--                                                            <span class="color-white value">BASTARD</span>-->
<!--                                                        </div>-->
<!--                                                        &lt;!&ndash; single property End &ndash;&gt;-->

<!--                                                        &lt;!&ndash; single property &ndash;&gt;-->
<!--                                                        <div class="pd-property-inner">-->
<!--                                                            <span class="color-body type">CITY</span>-->
<!--                                                            <span class="color-white value">TOKYO</span>-->
<!--                                                        </div>-->
<!--                                                        &lt;!&ndash; single property End &ndash;&gt;-->
<!--                                                    </div>-->
<!--                                                </div>-->
<!--                                            </div>-->
<!--                                        </div>-->
<!--                                        <div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">-->
<!--                                            &lt;!&ndash; Single creator &ndash;&gt;-->
<!--                                            <div class="top-seller-inner-one">-->
<!--                                                <div class="top-seller-wrapper">-->
<!--                                                    <div class="thumbnail">-->
<!--                                                        <router-link to="#">-->
<!--                                                            <img :src="require(`@/assets/images/client/client-3.png`)" alt="Nft_Profile">-->
<!--                                                        </router-link>-->
<!--                                                    </div>-->
<!--                                                    <div class="top-seller-content">-->
<!--                                                        <span>0.11wETH by<router-link to="#">Allen Waltker</router-link></span>-->
<!--                                                        <span class="count-number">1 hours ago</span>-->
<!--                                                    </div>-->
<!--                                                </div>-->
<!--                                            </div>-->
<!--                                            &lt;!&ndash; Single creator &ndash;&gt;-->

<!--                                            &lt;!&ndash; Single creator &ndash;&gt;-->
<!--                                            <div class="top-seller-inner-one mt&#45;&#45;20">-->
<!--                                                <div class="top-seller-wrapper">-->
<!--                                                    <div class="thumbnail">-->
<!--                                                        <router-link to="#">-->
<!--                                                            <img :src="require(`@/assets/images/client/client-2.png`)" alt="Nft_Profile">-->
<!--                                                        </router-link>-->
<!--                                                    </div>-->
<!--                                                    <div class="top-seller-content">-->
<!--                                                        <span>0.11wETH by<router-link to="#">Allen Waltker</router-link></span>-->
<!--                                                        <span class="count-number">1 hours ago</span>-->
<!--                                                    </div>-->
<!--                                                </div>-->
<!--                                            </div>-->
<!--                                            &lt;!&ndash; Single creator &ndash;&gt;-->

<!--                                            &lt;!&ndash; Single creator &ndash;&gt;-->
<!--                                            <div class="top-seller-inner-one mt&#45;&#45;20">-->
<!--                                                <div class="top-seller-wrapper">-->
<!--                                                    <div class="thumbnail">-->
<!--                                                        <router-link to="#">-->
<!--                                                            <img :src="require(`@/assets/images/client/client-4.png`)" alt="Nft_Profile">-->
<!--                                                        </router-link>-->
<!--                                                    </div>-->
<!--                                                    <div class="top-seller-content">-->
<!--                                                        <span>0.11wETH by<router-link to="#">Allen Waltker</router-link></span>-->
<!--                                                        <span class="count-number">1 hours ago</span>-->
<!--                                                    </div>-->
<!--                                                </div>-->
<!--                                            </div>-->
<!--                                            &lt;!&ndash; Single creator &ndash;&gt;-->

<!--                                            &lt;!&ndash; Single creator &ndash;&gt;-->
<!--                                            <div class="top-seller-inner-one mt&#45;&#45;20">-->
<!--                                                <div class="top-seller-wrapper">-->
<!--                                                    <div class="thumbnail">-->
<!--                                                        <router-link to="#">-->
<!--                                                            <img :src="require(`@/assets/images/client/client-5.png`)" alt="Nft_Profile">-->
<!--                                                        </router-link>-->
<!--                                                    </div>-->
<!--                                                    <div class="top-seller-content">-->
<!--                                                        <span>0.11wETH by<router-link to="#">Allen Waltker</router-link></span>-->
<!--                                                        <span class="count-number">1 hours ago</span>-->
<!--                                                    </div>-->
<!--                                                </div>-->
<!--                                            </div>-->
<!--                                            &lt;!&ndash; Single creator &ndash;&gt;-->

<!--                                            &lt;!&ndash; Single creator &ndash;&gt;-->
<!--                                            <div class="top-seller-inner-one mt&#45;&#45;20">-->
<!--                                                <div class="top-seller-wrapper">-->
<!--                                                    <div class="thumbnail">-->
<!--                                                        <router-link to="#">-->
<!--                                                            <img :src="require(`@/assets/images/client/client-8.png`)" alt="Nft_Profile">-->
<!--                                                        </router-link>-->
<!--                                                    </div>-->
<!--                                                    <div class="top-seller-content">-->
<!--                                                        <span>0.11wETH by<router-link to="#">Allen Waltker</router-link></span>-->
<!--                                                        <span class="count-number">1 hours ago</span>-->
<!--                                                    </div>-->
<!--                                                </div>-->
<!--                                            </div>-->
<!--                                            &lt;!&ndash; Single creator &ndash;&gt;-->
<!--                                        </div>-->
<!--                                    </div>-->
                                </div>
                                <div class="place-bet-area">
                                    <div class="rn-bet-create">
                                        <div class="bid-list winning-bid">
                                            <h6 class="title">Apply Now</h6>
                                            <div class="top-seller-inner-one">
                                                <div class="top-seller-wrapper">
                                                    <div class="thumbnail">
                                                        <router-link to="#">
                                                            <img :src="`/backend/static/` + product.img" alt="Nft_Profile" style="height: 50px; width: 50px">
                                                        </router-link>
                                                    </div>
                                                    <div class="top-seller-content">
                                                        <span class="heighest-bid">{{product.name}}</span>
<!--                                                        <span class="count-number">0.115wETH</span>-->
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="bid-list left-bid">
                                            <h6 class="title">Time Remaining</h6>
                                            <countdown :date="'2025-12-09'" class="mt--15"/>
                                        </div>
                                    </div>
                                    <div>
                                        <button v-if="programSelected" type="button"
                                                class="btn btn-primary-alta mt--30"
                                                @click="removeProgramFromUserApplications(product.id)">
                                            Remove From Apply List
                                        </button>
                                        <button v-else type="button"
                                                class="btn btn-primary-alta mt--30"
                                                @click="addProgramIntoUserApplications(product.id)">
                                            Add to Apply List
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End product details area -->

        <!-- Virtual Campus Tour Start -->
        <div class="rn-new-items rn-section-gapTop">
            <div class="container">
                <div class="row mb--30 align-items-center">
                    <div class="col-12">
                        <h3 class="title mb--0">Virtual Campus Tour</h3>
                    </div>
                </div>
<!--                <virtual-campus-tour-frame ref="childCompVCTGoogle"/>-->
            </div>
        </div>
        <!-- Virtual Campus Tour area End -->

        <!-- Offer Timeline Start -->
        <div class="rn-new-items rn-section-gapTop">
            <div class="container">
                <div class="row mb--30 align-items-center">
                    <div class="col-12">
                        <h3 class="title mb--0">Offer Timeline</h3>
                    </div>
                </div>
<!--                <offer-timeline-frame/>-->
                <offer-timeline-frame-high-charts :ad-count-last-year="countLstLastYear"
                                                  :ad-count-this-year="countLstThisYear"
                                                  :program-name="this.product.name"
                                                  :school-name="this.product.school.name"
                                                  ref="childCompOfferTimeline"/>
            </div>
        </div>
        <!-- Offer Timeline End -->

        <!-- Recent view area Start -->
        <div class="rn-new-items rn-section-gapTop">
            <div class="container">
                <div class="row mb--30 align-items-center">
                    <div class="col-12">
                        <h3 class="title mb--0">Related Schools</h3>
                    </div>
                </div>
                <div class="row g-5">
                    <div class="col-5 col-lg-4 col-md-6 col-sm-6 col-12"
                         v-for="(item, index) in relatedSchools"
                         :key="`newest-item-${index}`">
                        <product-card
                            :product-date="item"
                            product-style-class="no-overlay"
                        />
                    </div>
                </div>
            </div>
        </div>
        <!-- Recent view area End -->

        <!-- Related item area Start -->
        <div class="rn-new-items rn-section-gapTop">
            <div class="container">
                <div class="row mb--30 align-items-center">
                    <div class="col-12">
                        <h3 class="title mb--0">Related Programs</h3>
                    </div>
                </div>
                <div class="row g-5">
                    <div class="col-5 col-lg-4 col-md-6 col-sm-6 col-12"
                         v-for="(item, index) in relatedPrograms"
                         :key="`newest-item-${index}`">
                        <product-card
                            :product-date="item"
                            product-style-class="no-overlay"
                        />
                    </div>
                </div>
            </div>
        </div>
        <!-- Related item area End -->

        <share-modal/>

        <report-modal/>

        <placebid-modal/>
    </layout>
</template>

<script>
    import Layout from '@/components/layouts/Layout'
    import Breadcrumb from '@/components/breadcrumb/Breadcrumb'
    import ProductCard from '@/components/product/ProductCard'
    import ShareModal from '@/components/modal/ShareModal'
    import ReportModal from '@/components/modal/ReportModal'
    import Countdown from '@/components/product/Countdown'
    import PlacebidModal from '@/components/modal/PlacebidModal'
    import schoolApi from "@/api/shool"
    import programApi from "@/api/program"
    import ProductMixin from "@/mixins/ProductMixin";
    // import TopSchoolItem from "@/components/myComp/homePageComp/TopSchoolItem.vue";
    import request from "@/utils/request";
    import VirtualCampusTourFrame from "@/components/myComp/VirtualCampusTourFrame";
    import OfferTimelineFrame from "@/components/myComp/OfferTimelineFrame.vue";
    import OfferTimelineFrameHighCharts from "@/components/myComp/OfferTimelineFrameHighCharts.vue";
    import programSelectionApi from "@/api/programSelection";
    import cookie from "js-cookie";
    import profileApi from "@/api/profile";


    export default {

        name: 'ProgramDetails',
        components: {
            // TopSchoolItem,
            PlacebidModal,
            Countdown,
            ReportModal,
            ShareModal,
            ProductCard,
            Breadcrumb,
            Layout,
            VirtualCampusTourFrame,
            OfferTimelineFrame,
            OfferTimelineFrameHighCharts
        },
        mixins: [ProductMixin],
        data() {
            return {
                id: this.$route.params.id,
                // schoolId: this.$route.params.id.split("X")[1],
                product: {},
                activeTabIndex: 0,
                relatedSchools: [],
                relatedPrograms: [],
                school: {},

                selectedPrograms: [],
                selectedProgramIDs: [],
                programSelected: false,

                countLstThisYear: [], // a list of admission numbers each week (must be 52weeks(len) in total)
                countLstLastYear: []
            }
        },
        methods: {
            getProduct(productId) {
              this.product = this.products.find(item => item.id == productId);
              // !!! IMPORTANT !!!
              // load google map after finish requesting the school obj
              this.$refs.childCompVCTGoogle.initMap(Number(this.school.lat), Number(this.school.lng));
              // check whether the user selected this program
              this.isProgramSelected(this.product.id);

            },
            getPrograms() {
              let that = this;
                programApi.getAllPrograms().then(response => {
                    this.products = response['data']['programs']
                    this.getProduct(this.id)
                })
              request({
                url: `/api/program/public/getSchoolByProgram/` + that.id,
                method: 'get'
              }).then(function (res){
                let school = res.data.school;
                that.school = school;
                // schoolApi.getById(school.id).then(response => {
                //   this.school = response['data']['school']
                //   console.log(this.response)
                // })
              });


            },
            getData(){
              let that = this;
              request({
                url: `/api/school/public/getRandomSchools/15`,
                method: 'get'
              }).then(function (res){
                that.relatedSchools = res.data.schools;

              });

              request({
                url: `/api/program/public/getRandomPrograms/15`,
                method: 'get'
              }).then(function (resA){
                let programs = resA.data.programs;
                let count = 0;
                for(let index in programs){
                    request({
                      url: `/api/program/public/getSchoolByProgram/` + resA.data.programs[index].id,
                      method: 'get'
                    }).then(function (resB){
                      resA.data.programs[index].school = resB.data.school;
                      count++;
                      if(programs.length === count){
                        that.relatedPrograms = resA.data.programs;
                      }

                    });
                }
              });
            },

            getUserSelectedPrograms(checkProgramId){
                // call the api method
                profileApi.getSelectedPrograms()
                    .then(response => {

                        // get the list of user selected programs
                        this.selectedPrograms = response.data.selectedPrograms;
                        // reset the selectedProgramIDs list to empty
                        this.selectedProgramIDs = [];
                        // initialize the list of selected program id
                        for (let k in this.selectedPrograms){
                            this.selectedProgramIDs.push(this.selectedPrograms[k].id);
                        }

                        // check whether contains this program
                        this.programSelected = this.selectedProgramIDs.includes(checkProgramId);

                    })
            },

            // request whether the program is selected
            isProgramSelected(programId){
                // request only when user logged in
                let userStr = cookie.get("current_user");
                if (userStr){
                    // require all the selected programs
                    this.getUserSelectedPrograms(programId);
                }
            },

            // add a program into user application list
            addProgramIntoUserApplications(programId){
                programSelectionApi.addApplication(programId)
                    .then(response => {
                        // add successfully
                        window.alert("The program added successfully into your list!")
                        // update the button
                        this.programSelected = !this.programSelected;
                    })
            },

            // remove a program from user application list
            removeProgramFromUserApplications(programId){
                programSelectionApi.deleteApplicationByProgramId(programId)
                    .then(response => {
                        // delete successfully
                        window.alert("Program removed successfully from your list!")
                        // update the button
                        this.programSelected = !this.programSelected;
                    })
            },

            // load data for offer-timeline
            // request the admission numbers each week to init countLstAD
            getWeeklyADCount(programId){
                programApi.getWeeklyAdmissionCountByProgramId(programId)
                    .then(response => {
                        // for test
                        console.log("=================================response: " + response.data.countLstThisYear);
                        console.log("=================================response: " + response.data.countLstLastYear);
                        this.countLstThisYear = response.data.countLstThisYear;
                        this.countLstLastYear = response.data.countLstLastYear;
                    })
            }

        },
        created() {
            this.id = this.$route.params.id,
            this.getData();
            this.getPrograms();
            this.getWeeklyADCount(this.id);
        },
        mounted(){

        },
        watch: {
            '$route.params.id': function (val) {
                this.id = this.$route.params.id,
                this.getProduct(this.id);
            }
        },
    }
</script>
