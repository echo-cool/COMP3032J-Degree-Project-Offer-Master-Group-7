<template>
    <layout>
        <breadcrumb title="Make your payment easier" current="Make your payment easier"/>

        <!-- Start connect area -->
        <div class="rn-connect-area rn-section-gapTop">
            <div class="container">
                <div class="row g mb--50 mb_md--30 mb_sm--30 align-items-center">
                    <div class="col-lg-6">
                        <h3 class="connect-title">Connect your wallet</h3>
                        <p class="connect-td">
                            Connect with one of available wallet providers or create a new wallet.
                            <router-link to="#">What is a wallet?</router-link>
                        </p>
                    </div>
                    <div class="col-lg-6">
                        <p class="wallet-bootm-disc">
                            We do not own your private keys and cannot access your funds without your confirmation.
                        </p>
                    </div>
                </div>
                <div class="row g-5">
                    <div class="col-lg-6">
                        <div class="connect-thumbnail">
                            <div class="left-image">
                                <img :src="require(`@/assets/images/connect/connect-01.jpg`)" alt="Nft_Profile">
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="row g-5">
                            <!-- Start single wallet -->
                            <div class="col-xxl-4 col-lg-6 col-md-4 col-12 col-sm-6 col-12">
                                <div class="wallet-wrapper">
                                    <div class="inner">
                                        <div class="icon">
                                            <i class="feather-cast"/>
                                        </div>
                                        <div class="content">
                                            <h4 class="title"><a href="#">Bitcollet</a></h4>
                                            <p class="description">I throw myself down among the tall.</p>
                                        </div>
                                    </div>
                                    <router-link class="over-link" to="#"></router-link>
                                </div>
                            </div>
                            <!-- End single wallet -->

                            <!-- Start single wallet -->
                            <div class="col-xxl-4 col-lg-6 col-md-4 col-12 col-sm-6 col-12">
                                <div class="wallet-wrapper">
                                    <div class="inner">
                                        <div class="icon">
                                            <i class="feather-box color-purple"/>
                                        </div>
                                        <div class="content">
                                            <h4 class="title"><a href="#">GrasCash</a></h4>
                                            <p class="description">This is a great deals For cash transfer</p>
                                        </div>
                                    </div>
                                    <router-link class="over-link" to="#"></router-link>
                                </div>
                            </div>
                            <!-- End single wallet -->

                            <!-- Start single wallet -->
                            <div class="col-xxl-4 col-lg-6 col-md-4 col-12 col-sm-6 col-12">
                                <div class="wallet-wrapper">
                                    <div class="inner">
                                        <div class="icon">
                                            <i class="feather-award color-pink"/>
                                        </div>
                                        <div class="content">
                                            <h4 class="title">
                                                <router-link to="#">Import</router-link>
                                            </h4>
                                            <p class="description">Great opportunity to reach them.</p>
                                        </div>
                                    </div>
                                    <router-link class="over-link" to="#"></router-link>
                                </div>
                            </div>
                            <!-- End single wallet -->

                            <!-- Start single wallet -->
                            <div class="col-xxl-4 col-lg-6 col-md-4 col-12 col-sm-6 col-12">
                                <div class="wallet-wrapper">
                                    <div class="inner">
                                        <div class="icon">
                                            <i class="feather-briefcase color-yellow"/>
                                        </div>
                                        <div class="content">
                                            <h4 class="title">
                                                <router-link to="#">TiOne</router-link>
                                            </h4>
                                            <p class="description">Built your bigger offers then me</p>
                                        </div>
                                    </div>
                                    <router-link class="over-link" to="#"></router-link>
                                </div>
                            </div>
                            <!-- End single wallet -->

                            <!-- Start single wallet -->
                            <div class="col-xxl-4 col-lg-6 col-md-4 col-12 col-sm-6 col-12">
                                <div class="wallet-wrapper">
                                    <div class="inner">
                                        <div class="icon">
                                            <i class="color-green feather-command"/>
                                        </div>
                                        <div class="content">
                                            <h4 class="title"><a href="#">Bkashes</a></h4>
                                            <p class="description">Cash Transfer for easiest way you wast</p>
                                        </div>
                                    </div>
                                    <router-link class="over-link" to="#"></router-link>
                                </div>
                            </div>
                            <!-- End single wallet -->

                            <!-- Start single wallet -->
                            <div class="col-xxl-4 col-lg-6 col-md-4 col-12 col-sm-6 col-12">
                                <div class="wallet-wrapper">
                                    <div class="inner">
                                        <div class="icon">
                                            <i class="color-blue feather-cpu"/>
                                        </div>
                                        <div class="content">
                                            <h4 class="title">
                                                <router-link to="#">Pyynle</router-link>
                                            </h4>
                                            <p class="description">More then myself down among the Cash.</p>
                                        </div>
                                    </div>
                                    <router-link class="over-link" to="#"></router-link>
                                </div>
                            </div>
                            <!-- End single wallet -->

                            <!-- Start single wallet -->
                            <div class="col-12">
                                <div class="wallet-wrapper">
                                    <div class="inner">
                                        <div class="icon">
                                            <i class="color-red feather-gitlab"/>
                                        </div>
                                        <div class="content">
                                            <h4 class="title"><a href="#">YesCash</a></h4>
                                            <p class="description">Biggest Bank transfer for best opportunity</p>
                                        </div>
                                    </div>
                                    <router-link class="over-link" to="#"></router-link>
                                </div>
                            </div>
                            <!-- End single wallet -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End connect area -->
    </layout>
</template>

<script>
    import Layout from '@/components/layouts/Layout'
    import Breadcrumb from '@/components/breadcrumb/Breadcrumb'

    export default {
        name: 'Connect',
        components: {Breadcrumb, Layout}
    }
</script>