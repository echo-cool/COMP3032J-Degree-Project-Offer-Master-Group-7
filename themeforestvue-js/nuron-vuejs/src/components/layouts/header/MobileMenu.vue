<template>
    <div class="popup-mobile-menu"
         @click.self="AppFunctions.removeClass('.popup-mobile-menu', 'active')">
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
                    <button class="close-button"
                            @click="AppFunctions.removeClass('.popup-mobile-menu', 'active')">
                        <i class="feather-x"/>
                    </button>
                </div>
            </div>
            <nav>
                <Nav/>
            </nav>
        </div>
    </div>
</template>

<script>
import Nav from './Nav';
import AppFunctions from '../../../helpers/AppFunctions';

export default {
    name: 'MobileMenu',
    components: {Nav},
    data() {
        return {
            AppFunctions
        }
    },
    mounted() {
        let elements = document.querySelectorAll('.popup-mobile-menu .has-droupdown > a'),
            elementsTwo = document.querySelectorAll('.popup-mobile-menu .with-megamenu > a');

        for (let i in elements) {
            if (elements.hasOwnProperty(i)) {
                elements[i].onclick = function () {
                    let subMenu = this.parentElement.querySelector('.submenu');

                    subMenu.classList.toggle('active');
                    this.classList.toggle('open');
                }
            }
        }

        for (let i in elementsTwo) {
            if (elementsTwo.hasOwnProperty(i)) {
                elementsTwo[i].onclick = function () {
                    let subMenu = this.parentElement.querySelector('.rn-megamenu');

                    subMenu.classList.toggle('active');
                    this.classList.toggle('open');
                }
            }
        }
    }
}
</script>