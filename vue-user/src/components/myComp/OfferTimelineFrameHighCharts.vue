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
            adCountThisYear: {
                type: Array,
                default: function () {
                    return new Array(52).fill(0);
                }
            },
            adCountLastYear: {
                type: Array,
                default: function () {
                    return new Array(52).fill(0);
                }
            },
            programName: {
                type: String,
                default: ""
            },
            schoolName: {
                type: String,
                default: ""
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
            adCountThisYear: function (newVal, oldVal) {
                this.loadChart();
            },

            adCountLastYear: function (newVal, oldVal) {
                this.loadChart();
            },
        },
        methods:{

            loadChart() {
                if (this.chart) {
                    this.chart.destroy();
                }
                // Init Highcharts offer-timeline
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
                        text: this.schoolName + " - " + this.programName,
                        align: 'left'
                    },

                    xAxis: {
                        title: {
                            text: "weeks"
                        },
                        tickInterval: 1
                    },

                    yAxis: {
                        title: {
                            text: "Admission Numbers"
                        },
                    },

                    legend: {
                        align: 'left',
                        verticalAlign: 'top',
                        borderWidth: 0
                    },

                    tooltip: {
                        shared: true,
                        crosshairs: true,
                        headerFormat: '<span style="font-size: 10px">week-{point.key}</span><br/>'
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
                            name: 'This Year',
                            lineWidth: 4,
                            marker: {
                                radius: 4
                            },
                            data: this.adCountThisYear
                        },
                        {
                            name: 'Last Year',
                            data: this.adCountLastYear
                        }
                    ]
                });
            }
        }
    }
</script>
