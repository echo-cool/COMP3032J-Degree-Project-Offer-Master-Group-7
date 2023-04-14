<template>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="subscribe-wrapper_1 text-center p-0">

                    <div style="height: 400px; width: 100%">
                        <div id="chart"></div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</template>

<script>

    import {Chart} from 'highcharts-vue'

    // for export btn
    import Highcharts from 'highcharts'
    import exportingInit from 'highcharts/modules/exporting'
    exportingInit(Highcharts)


    export default {
        name: 'Offer-Timeline',
        props:{
            dataAD: {
                type: Array,
                default: function () {
                    return new Array(52).fill(0);
                }
            },
            dataREJ: {
                type: Array,
                default: function () {
                    return new Array(52).fill(0);
                }
            }
        },
        components: {
            highcharts: Chart
        },
        data(){
            return{

            }
        },
        created() {

        },
        mounted() {
            this.loadChart();
        },
        watch: {
            dataAD: function (newVal, oldVal) {
                this.loadChart();
            },

            dataREJ: function (newVal, oldVal) {
                this.loadChart();
            },
        },
        methods:{

            loadChart() {
                if (this.chart) {
                    this.chart.destroy();
                }
                // 初始化 Highcharts 图表
                this.chart = new Highcharts.chart('chart',{
                    credits: {
                        enabled: false
                    },

                    chart: {
                        scrollablePlotArea: {
                            minWidth: 700
                        }
                    },

                    title: {
                        text: 'Offer-Timeline of ',
                        align: 'left'
                    },

                    // subtitle: {
                    //     text: 'Source: Google Analytics',
                    //     align: 'left'
                    // },

                    xAxis: {
                        title: {
                            text: "weeks"
                        },
                        tickInterval: 1
                    },

                    yAxis: {
                        title: {
                            text: "Admission/Rejection Numbers"
                        },
                    },

                    legend: {
                        align: 'left',
                        verticalAlign: 'top',
                        borderWidth: 0
                    },

                    tooltip: {
                        shared: true,
                        crosshairs: true
                    },

                    plotOptions: {
                        series: {
                            cursor: 'pointer',
                            className: 'popup-on-click',
                            marker: {
                                lineWidth: 1
                            },
                            pointStart: 1
                        }
                    },

                    series: [
                        {
                            name: 'Admissions',
                            lineWidth: 4,
                            marker: {
                                radius: 4
                            },
                            data: this.dataAD
                        },
                        {
                            name: 'Rejections',
                            data: this.dataREJ
                        }
                    ]
                });
            }
        }
    }
</script>
