<template>
    <div>
        <!-- Start header area -->
        <div class="d-none d-lg-block">
            <div class="header-area left-header-style d-flex">
                <div class="logo-area logo-custom-css">
                    <router-link class="logo-light" to="/">
                        <img :src="require(`@/assets/images/logo/logo-white.png`)" alt="nft-logo">
                    </router-link>
                    <router-link class="logo-dark" to="/">
                        <img :src="require(`@/assets/images/logo/logo-dark.png`)" alt="nft-logo">
                    </router-link>
                </div>
                <div class="sidebar-nav-wrapper">
                    <nav class="mainmenu-nav">
                        <ul class="mainmenu list-group">
                            <li class="nav-item">
                                <a class="nav-link smoth-animation" href="#list-item-1"><i class="feather-home"/>Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link smoth-animation" href="#list-item-2"><i class="feather-heart"/>Live Auction</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link smoth-animation" href="#list-item-3"><i class="feather-trending-up"/>Explore Product</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link smoth-animation" href="#list-item-4"><i class="feather-trending-up"/>Newest Item</a>
                            </li>
                        </ul>
                    </nav>
                    <div class="help-center-area mainmenu-nav mt--30">
                        <ul class="mainmenu">
                            <li class="nav-item">
                                <router-link class="nav-link" to="#"><i class="feather-settings"/>Settings</router-link>
                            </li>
                            <li class="nav-item">
                                <router-link class="nav-link" to="/support"><i class="feather-activity"/>Help Center</router-link>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="authore-profile">
                    <div class="thumbnail">
                        <img :src="require(`@/assets/images/client/testimonial-1.jpg`)" alt="Nft_marketplaces">
                    </div>
                    <div class="au-content">
                        <p class="name">Mark Jordan</p>
                        <p class="blc">Balance:<span class="value">12ETH</span></p>
                    </div>
                </div>
            </div>
        </div>
        <!-- End header area -->

        <!-- Start Popup Mobile Menu -->
        <div class="popup-mobile-menu one-page-vavigation-popup"
             @click.self="toggleMobileMenu">
            <div class="inner">
                <div class="header-top">
                    <div class="logo logo-custom-css">
                        <router-link class="logo-light" to="/">
                            <img :src="require(`@/assets/images/logo/logo-white.png`)" alt="nft-logo">
                        </router-link>
                        <router-link class="logo-dark" to="/">
                            <img :src="require(`@/assets/images/logo/logo-dark.png`)" alt="nft-logo">
                        </router-link>
                    </div>
                    <div class="close-menu">
                        <button class="close-button" @click.prevent="toggleMobileMenu">
                            <i class="feather-x"/>
                        </button>
                    </div>
                </div>
                <nav>
                    <!-- Start Mainmenu Nav -->
                    <ul class="mainmenu" id="navbar-example2">
                        <li class="nav-item"><a class="nav-link smoth-animation" href="#list-item-1" @click="toggleMobileMenu">Home</a></li>
                        <li class="nav-item"><a class="nav-link smoth-animation" href="#list-item-2" @click="toggleMobileMenu">Live Auction</a></li>
                        <li class="nav-item"><a class="nav-link smoth-animation" href="#list-item-3" @click="toggleMobileMenu">Newest Item</a></li>
                        <li class="nav-item"><a class="nav-link smoth-animation" href="#list-item-4" @click="toggleMobileMenu">Explore Product</a></li>
                    </ul>
                    <!-- End Mainmenu Nav -->
                </nav>
            </div>
        </div>
        <!-- Start Popup Mobile Menu -->

        <div :class="[`rn-nft-mid-wrapper`, {'nft-left-sidebar-nav pr--40 pr_sm--15': !showRightSidebar}]">
            <div id="list-item-1">
                <!-- Topbar Start -->
                <div class="rn-top-bar-area">
                    <div class="d-none d-lg-block">
                        <div class="input-group">
                            <input type="text" placeholder="Search Here..." class="form-control bg-color--2">
                            <div class="input-group-append">
                                <button class="btn btn-primary-alta btn-outline-secondary" type="button">
                                    <i class="feather-search"/>
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="contact-area">
                        <div class="rn-icon-list setting-option d-block d-lg-none">
                            <div class="icon-box search-mobile-icon">
                                <button @click.prevent="
                                    AppFunctions.toggleClass('.large-mobile-blog-search', 'active'),
                                    isMobileSearchActive = !isMobileSearchActive
                                ">
                                    <i :class="isMobileSearchActive ? 'feather-x' : 'feather-search'"/>
                                </button>
                            </div>
                            <form id="header-search-1" action="#" method="GET" class="large-mobile-blog-search">
                                <div class="rn-search-mobile form-group">
                                    <button type="submit" class="search-button"><i class="feather-search"/></button>
                                    <input type="text" placeholder="Search ...">
                                </div>
                            </form>
                        </div>
                        <div class="setting-option">
                            <div class="icon-box">
                                <router-link title="Contact With Us" to="/contact"><i class="feather-phone"/></router-link>
                            </div>
                        </div>
                        <div class="setting-option">
                            <div class="icon-box">
                                <router-link title="Message" to="#"><i class="feather-message-circle"></i></router-link>
                            </div>
                        </div>
                        <div class="setting-option header-btn">
                            <div class="icon-box">
                                <router-link class="btn btn-primary-alta btn-small" to="/create">Create</router-link>
                            </div>
                        </div>
                        <div class="setting-option mobile-menu-bar ml--5 d-block d-lg-none">
                            <div class="hamberger icon-box">
                                <button class="hamberger-button d-flex align-items-center"
                                        @click.prevent="toggleMobileMenu">
                                    <i class="feather-menu pb-1"/>
                                </button>
                            </div>
                        </div>
                        <div class="setting-option rbt-site-header ml--5" id="rbt-site-header">
                            <div class="icon-box">
                                <router-link class="btn btn-primary-alta btn-small" to="/connect">
                                    Wallet connect
                                </router-link>
                            </div>
                        </div>
                        <div class="header_admin" id="header_admin">
                            <div class="setting-option rn-icon-list user-account">
                                <div class="icon-box">
                                    <router-link to="/author/1">
                                        <img :src="require(`@/assets/images/icons/boy-avater.png`)" alt="Images">
                                    </router-link>
                                    <div class="rn-dropdown">
                                        <div class="rn-inner-top">
                                            <h4 class="title"><router-link to="#">Christopher William</router-link></h4>
                                            <span><router-link to="#">Set Display Name</router-link></span>
                                        </div>
                                        <div class="rn-product-inner">
                                            <ul class="product-list">
                                                <li class="single-product-list">
                                                    <div class="thumbnail">
                                                        <router-link to="/product/7">
                                                            <img :src="require(`@/assets/images/portfolio/portfolio-07.jpg`)" alt="Nft Product Images">
                                                        </router-link>
                                                    </div>
                                                    <div class="content">
                                                        <h6 class="title"><router-link to="#">Balance</router-link></h6>
                                                        <span class="price">25 ETH</span>
                                                    </div>
                                                    <div class="button"></div>
                                                </li>
                                                <li class="single-product-list">
                                                    <div class="thumbnail">
                                                        <router-link to="/product/1">
                                                            <img :src="require(`@/assets/images/portfolio/portfolio-01.jpg`)" alt="Nft Product Images">
                                                        </router-link>
                                                    </div>
                                                    <div class="content">
                                                        <h6 class="title"><router-link to="#">Balance</router-link></h6>
                                                        <span class="price">25 ETH</span>
                                                    </div>
                                                    <div class="button"></div>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="add-fund-button mt--20 pb--20">
                                            <router-link class="btn btn-primary-alta w-100" to="/connect">Add Your More Funds</router-link>
                                        </div>
                                        <ul class="list-inner">
                                            <li><router-link to="/author/1">My Profile</router-link></li>
                                            <li><router-link to="/edit-profile">Edit Profile</router-link></li>
                                            <li><router-link to="/connect">Manage funds</router-link></li>
                                            <li><router-link to="/login">Sign Out</router-link></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div id="my_switcher" class="my_switcher setting-option">
                            <ul>
                                <li>
                                    <a href="javascript: void(0);" data-theme="light" class="setColor light" @click.prevent="AppFunctions.addClass('body', 'active-light-mode'), AppFunctions.removeClass('body', 'active-dark-mode')">
                                        <img :src="require(`@/assets/images/icons/sun-01.svg`)" alt="Sun images">
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript: void(0);" data-theme="dark" class="setColor dark" @click.prevent="AppFunctions.addClass('body', 'active-dark-mode'), AppFunctions.removeClass('body', 'active-light-mode')">
                                        <img :src="require(`@/assets/images/icons/vector.svg`)" alt="Vector Images">
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- Topbar End -->

                <slot name="banner"></slot>
            </div>

            <slot></slot>
        </div>

        <div v-if="showRightSidebar" class="header-right-fixed">
            <!-- Notification Area Start -->
            <notification-list-sidebar/>
            <!-- Notification Area End -->

            <!-- Creators Area Start -->
            <creator-list-sidebar/>
            <!-- Creators Area End -->
        </div>

        <!-- Footer Area Start  -->
        <div class="rn-footer-area footer-for-left-sticky-header">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="inner text-center">
                            <div class="logo logo-custom-css">
                                <router-link class="logo-light" to="/"><img :src="require(`@/assets/images/logo/logo-white.png`)" alt="nft-logo"></router-link>
                                <router-link class="logo-dark" to="/"><img :src="require(`@/assets/images/logo/logo-dark.png`)" alt="nft-logo"></router-link>
                            </div>
                            <p class="description mt--30">© 2022. All rights reserved by <a target="_blank" href="https://themeforest.net/user/rainbow-themes/portfolio">Rainbow-Themes.</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer Area End  -->

        <back-to-top @click="scrollTop"/>
    </div>
</template>

<script>
    import AppFunctions from '@/helpers/AppFunctions'
    import SalScrollAnimationMixin from '@/mixins/SalScrollAnimationMixin'
    import BackToTop from '@/components/layouts/footer/BackToTop'
    import NiceSelect from "@/components/select/NiceSelect";
    import NotificationList from "@/components/notification/NotificationListSidebar";
    import NotificationListSidebar from "@/components/notification/NotificationListSidebar";
    import CreatorListSidebar from "@/components/seller/CreatorListSidebar";

    export default {
        name: 'LayoutSidebar',
        components: {CreatorListSidebar, NotificationListSidebar, NotificationList, NiceSelect, BackToTop},
        mixins: [SalScrollAnimationMixin],
        props: {
            showRightSidebar: {
                type: Boolean,
                default: true
            }
        },
        data() {
            return {
                AppFunctions,
                isMobileSearchActive: false
            }
        },
        methods: {
            scrollTop() {
                window.scrollTo(0, 0);
            },
            toggleMobileMenu() {
                AppFunctions.toggleClass('.popup-mobile-menu.one-page-vavigation-popup', 'active');
            }
        }
    }
</script>