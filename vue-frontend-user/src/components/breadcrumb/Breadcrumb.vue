<template>
    <div class="rn-breadcrumb-inner ptb--30">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-6 col-md-6 col-12">
                    <h5 class="title text-center text-md-start">{{ title }}</h5>
                </div>
                <div class="col-lg-6 col-md-6 col-12">
                    <ul class="breadcrumb-list">
                        <li class="item"><router-link :to="root.url">{{ root.title }}</router-link></li>
                        <li class="separator"><i class="feather-chevron-right"/></li>
                        <li class="item current">{{ current }}</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'Breadcrumb',
        props: {
            title: {
                type: String
            },
            root: {
                type: Object,
                default() {
                    return {
                        title: 'Home',
                        url: '/'
                    }
                }
            },
            current: {
                type: String
            }
        }
    }
</script>