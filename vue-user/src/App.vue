<template>
    <router-view/>
</template>

<script>
    import AppFunctions from './helpers/AppFunctions';

    export default {
        data() {
            return {
                AppFunctions
            }
        },
        beforeMount() {
            this.AppFunctions.addClass('body', 'active-dark-mode');
        },
        watch: {
            '$route': function (value) {
                if (value.name === 'HomePageFive') {
                    this.AppFunctions.addClass('body', 'with-particles');
                } else if (value.name === 'HomePageSeven' || value.name === 'HomePageEight') {
                    this.AppFunctions.addClass('body', 'home-sticky-pin');
                    this.AppFunctions.addClass('body', 'sidebar-header');
                    this.AppFunctions.addClass('body', 'scrollspy-example');
                    this.AppFunctions.addClass('body', 'position-relative');
                } else {
                    const body = document.querySelector('body');

                    if (body.classList.contains('with-particles')) {
                        this.AppFunctions.removeClass('body', 'with-particles');
                    }
                    if (body.classList.contains('home-sticky-pin')) {
                        this.AppFunctions.removeClass('body', 'home-sticky-pin');
                    }
                    if (body.classList.contains('sidebar-header')) {
                        this.AppFunctions.removeClass('body', 'sidebar-header');
                    }
                    if (body.classList.contains('scrollspy-example')) {
                        this.AppFunctions.removeClass('body', 'scrollspy-example');
                    }
                    if (body.classList.contains('position-relative')) {
                        this.AppFunctions.removeClass('body', 'position-relative');
                    }
                }
            }
        },
    }
</script>
