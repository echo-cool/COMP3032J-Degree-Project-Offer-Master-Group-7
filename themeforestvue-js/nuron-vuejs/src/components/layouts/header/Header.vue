<template>
    <header class="rn-header haeder-default header--sticky">
        <div class="container">
            <div class="header-inner">
                <div class="header-left">
                    <logo/>
                    <div class="mainmenu-wrapper">
                        <nav class="mainmenu-nav d-none d-xl-block">
                            <Nav/>
                        </nav>
                    </div>
                </div>
                <div class="header-right">
                    <div class="setting-option d-none d-lg-block">
                        <form class="search-form-wrapper" action="#">
                            <input type="search" placeholder="Search Here" aria-label="Search">
                            <div class="search-icon">
                                <button><i class="feather-search"/></button>
                            </div>
                        </form>
                    </div>
                    <div class="setting-option rn-icon-list d-block d-lg-none">
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
                    <div class="setting-option header-btn rbt-site-header flex-shrink-0" id="rbt-site-header">
                        <div class="icon-box">
                            <router-link id="connectbtn" class="btn btn-primary-alta btn-small" to="/connect">Wallet connect</router-link>
                        </div>
                    </div>
                    <div class="setting-option rn-icon-list notification-badge">
                        <div class="icon-box">
                            <router-link to="/activity"><i class="feather-bell"/><span class="badge">6</span></router-link>
                        </div>
                    </div>
                    <div class="header_admin">
                        <div class="setting-option rn-icon-list user-account">
                            <div class="icon-box">
                                <router-link to="/">
                                    <img :src="require(`@/assets/images/icons/boy-avater.png`)" alt="Images">
                                </router-link>
                                <div class="rn-dropdown">
                                    <div class="rn-inner-top">
                                        <h4 class="title">
                                            <router-link to="/">Christopher William</router-link>
                                        </h4>
                                        <span>
                                            <router-link to="#">Set Display Name</router-link>
                                        </span>
                                    </div>
                                    <div class="rn-product-inner">
                                        <ul class="product-list">
                                            <li class="single-product-list">
                                                <div class="thumbnail">
                                                    <router-link to="/">
                                                        <img
                                                            :src="require(`@/assets/images/portfolio/portfolio-07.jpg`)"
                                                            alt="Nft Product Images">
                                                    </router-link>
                                                </div>
                                                <div class="content">
                                                    <h6 class="title">
                                                        <router-link to="/">Balance</router-link>
                                                    </h6>
                                                    <span class="price">25 ETH</span>
                                                </div>
                                                <div class="button"></div>
                                            </li>
                                            <li class="single-product-list">
                                                <div class="thumbnail">
                                                    <router-link to="/">
                                                        <img
                                                            :src="require(`@/assets/images/portfolio/portfolio-01.jpg`)"
                                                            alt="Nft Product Images">
                                                    </router-link>
                                                </div>
                                                <div class="content">
                                                    <h6 class="title">
                                                        <router-link to="/">Balance</router-link>
                                                    </h6>
                                                    <span class="price">25 ETH</span>
                                                </div>
                                                <div class="button"></div>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="add-fund-button mt--20 pb--20">
                                        <router-link class="btn btn-primary-alta w-100" to="/">Add Your More Funds
                                        </router-link>
                                    </div>
                                    <ul class="list-inner">
                                        <li>
                                            <router-link to="/">My Profile</router-link>
                                        </li>
                                        <li>
                                            <router-link to="/">Edit Profile</router-link>
                                        </li>
                                        <li>
                                            <router-link to="/">Manage funds</router-link>
                                        </li>
                                        <li>
                                            <router-link to="/">Sign Out</router-link>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="setting-option mobile-menu-bar d-block d-xl-none">
                        <div class="hamberger">
                            <button class="hamberger-button"
                                    @click="AppFunctions.addClass('.popup-mobile-menu', 'active')">
                                <i class="feather-menu"/>
                            </button>
                        </div>
                    </div>
                    <div class="my_switcher setting-option">
                        <ul>
                            <li>
                                <a href="#"
                                   data-theme="light"
                                   class="setColor light"
                                   @click.prevent="AppFunctions.addClass('body', 'active-light-mode'), AppFunctions.removeClass('body', 'active-dark-mode')">
                                    <img class="sun-image" :src="require(`@/assets/images/icons/sun-01.svg`)"
                                         alt="Sun images">
                                </a>
                            </li>
                            <li>
                                <a href="#"
                                   data-theme="dark"
                                   class="setColor dark"
                                   @click.prevent="AppFunctions.addClass('body', 'active-dark-mode'), AppFunctions.removeClass('body', 'active-light-mode')">
                                    <img class="Victor Image" :src="require(`@/assets/images/icons/vector.svg`)"
                                         alt="Vector Images">
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </header>
</template>

<script>
    import Nav from './Nav';
    import AppFunctions from '../../../helpers/AppFunctions';
    import Logo from "@/components/logo/Logo";

    export default {
        name: 'Header',
        components: {Logo, Nav},
        data() {
            return {
                AppFunctions,
                isMobileSearchActive: false
            }
        },
        mounted() {
            const header = document.querySelector('.header--sticky');
            const setStickyHeader = () => {
                const scrollPos = window.scrollY;
                if (scrollPos > 50) {
                    header.classList.add('sticky');
                } else {
                    header.classList.remove('sticky');
                }
            }
            window.addEventListener('scroll', setStickyHeader);
        }
    }
</script>