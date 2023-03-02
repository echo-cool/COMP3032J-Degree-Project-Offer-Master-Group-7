<template>
    <div class="bg_image--1 bg_image maintanance-heignt" data-black-overlay="7">
        <div class="rn-comeing-soon-area ">
            <div class="container-fluid pt--40 pb--35 maintanance-plr text-center">
                <div class="logo">
                    <router-link to="/">
                        <img :src="require(`@/assets/images/logo/logo-white.png`)" alt="Nft-Marketplace">
                    </router-link>
                </div>
                <div class="maintanance-inner">
                    <div class="wrapper">
                        <p>We're Back Soon</p>
                        <h2>Website Is Under <span>Maintanance</span></h2>
                        <!--<div class="countdown maintanance_countdown mt&#45;&#45;15" data-date="-12-09">
                            <div class="countdown-container days">
                                <span class="countdown-value days-bottom">58</span>
                            </div>
                            <div class="countdown-container hours">
                                <span class="countdown-value hours-bottom">01</span>
                            </div>
                            <div class="countdown-container minutes">
                                <span class="countdown-value minutes-bottom">14</span>
                            </div>
                            <div class="countdown-container seconds">
                                <span class="countdown-value seconds-bottom">04</span>
                            </div>
                        </div>-->
                        <router-link to="#" class="btn btn-primary btn-large mt--30">Learn More</router-link>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'Maintenance'
    }
</script>