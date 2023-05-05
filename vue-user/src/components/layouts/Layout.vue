<template>
    <div>
        <Header/>
        <mobile-menu/>
        <main>
            <slot></slot>
        </main>
        <Footer :data="$props"/>
<!--        <back-to-top/>-->

        <chat-box1 class="chatBox"></chat-box1>

    </div>
</template>

<script>
    import Header from './header/Header'
    import Footer from './footer/Footer'
    import MobileMenu from './header/MobileMenu'
    import BackToTop from '@/components/layouts/footer/BackToTop'
    import ChatBox1 from "@/components/wyy/ChatBox1.vue";


    export default {
        name: 'Layout',
        components: {BackToTop, MobileMenu, Footer, Header, ChatBox1},
        props: {
            showFooterBrand: {
                type: Boolean,
                default: false
            }
        }
    }
</script>

<style>
    .sc-launcher{
        z-index: 9999
    }
    .sc-chat-window{
        z-index: 9999
    }
</style>
