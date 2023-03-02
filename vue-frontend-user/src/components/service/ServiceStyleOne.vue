<template>
    <div class="rn-service-area rn-section-gapTop">
        <div class="container">
            <div class="row">
                <div class="col-12 mb--50">
                    <h3 class="title" data-sal-delay="150" data-sal="slide-up" data-sal-duration="800">Create and sell your NFTs</h3>
                </div>
            </div>
            <div class="row g-5">
                <template v-for="(service, index) in serviceList"
                          :key="`service-${index}`">
                    <div v-if="index < serviceLimit" :class="serviceColumn">
                        <service-card :service-data="service"/>
                    </div>
                </template>
            </div>
        </div>
    </div>
</template>

<script>
    import ServiceCard from '@/components/service/ServiceCard'

    export default {
        name: 'ServiceStyleOne',
        components: {ServiceCard},
        props: {
            serviceLimit: {
                type: Number,
                default: 4
            },
            serviceColumn: {
                type: String,
                default: 'col-xxl-3 col-lg-4 col-md-6 col-sm-6 col-12'
            }
        },
        data() {
            return {
                serviceList: [
                    {
                        image: require(`@/assets/images/icons/shape-7.png`),
                        subtitle: 'Step-01',
                        title: 'Set up your wallet',
                        description: `Powerful features and inclusions, which makes Nuron standout, easily customizable and scalable.`,
                        link: '/connect'
                    },
                    {
                        image: require(`@/assets/images/icons/shape-1.png`),
                        subtitle: 'Step-02',
                        title: 'Create your collection',
                        description: `A great collection of beautiful website templates for your need. Choose the best suitable template.`,
                        link: '/collection'
                    },
                    {
                        image: require(`@/assets/images/icons/shape-5.png`),
                        subtitle: 'Step-03',
                        title: `Add your NFT's`,
                        description: `We've made the template fully responsive, so it looks great on all devices: desktop, tablets and.`,
                        link: '/connect'
                    },
                    {
                        image: require(`@/assets/images/icons/shape-6.png`),
                        subtitle: 'Step-04',
                        title: `Sell Your NFT's`,
                        description: `I throw myself down among the tall grass by the stream as I lie close to the earth NFT's.`,
                        link: '/creator'
                    }
                ],
            }
        }
    }
</script>