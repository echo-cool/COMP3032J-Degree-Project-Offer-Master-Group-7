<template>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="subscribe-wrapper_1 text-center p-0">

                    <div style="height: 400px; width: 100%">
<!--                        <highcharts :options="chartOptions2"></highcharts>-->
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

        },
        components: {
            highcharts: Chart
        },
        data(){
            return{
                chartOptions2: {
                    credits: {
                        enabled: false
                    },
                    chart: {
                        scrollablePlotArea: {
                            minWidth: 700
                        }
                    },

                    data: {
                        csvURL: 'https://cdn.jsdelivr.net/gh/highcharts/highcharts@v7.0.0/samples/data/analytics.csv',
                        beforeParse: function (csv) {
                            return csv.replace(/\n\n/g, '\n');
                        }
                    },

                    title: {
                        text: 'Daily sessions at www.highcharts.com',
                        align: 'left'
                    },

                    subtitle: {
                        text: 'Source: Google Analytics',
                        align: 'left'
                    },

                    xAxis: {
                        tickInterval: 7 * 24 * 3600 * 1000, // one week
                        tickWidth: 0,
                        gridLineWidth: 1,
                        labels: {
                            align: 'left',
                            x: 3,
                            y: -3
                        }
                    },

                    yAxis: [{ // left y axis
                        title: {
                            text: null
                        },
                        labels: {
                            align: 'left',
                            x: 3,
                            y: 16,
                            format: '{value:.,0f}'
                        },
                        showFirstLabel: false
                    }, { // right y axis
                        linkedTo: 0,
                        gridLineWidth: 0,
                        opposite: true,
                        title: {
                            text: null
                        },
                        labels: {
                            align: 'right',
                            x: -3,
                            y: 16,
                            format: '{value:.,0f}'
                        },
                        showFirstLabel: false
                    }],

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
                            }
                        }
                    },

                    series: [{
                        name: 'All sessions',
                        lineWidth: 4,
                        marker: {
                            radius: 4
                        }
                    }, {
                        name: 'New users'
                    }]
                },

                chartOptions1: {
                    // series: [{
                    //     data: [1,2,3] // sample data
                    // }]
                    credits: {
                        enabled: false
                    },
                    title: {
                        text: '2010 ~ 2016 年太阳能行业就业人员发展情况'
                    },
                    subtitle: {
                        text: '数据来源：thesolarfoundation.com'
                    },
                    yAxis: {
                        title: {
                            text: '就业人数'
                        }
                    },
                    legend: {
                        layout: 'vertical',
                        align: 'right',
                        verticalAlign: 'middle'
                    },
                    plotOptions: {
                        series: {
                            label: {
                                connectorAllowed: false
                            },
                            pointStart: 2010
                        }
                    },
                    series: [{
                        name: '安装，实施人员',
                        data: [43934, 52503, 57177, 69658, 97031, 119931, 137133, 154175]
                    }, {
                        name: '工人',
                        data: [24916, 24064, 29742, 29851, 32490, 30282, 38121, 40434]
                    }, {
                        name: '销售',
                        data: [11744, 17722, 16005, 19771, 20185, 24377, 32147, 39387]
                    }, {
                        name: '项目开发',
                        data: [null, null, 7988, 12169, 15112, 22452, 34400, 34227]
                    }, {
                        name: '其他',
                        data: [12908, 5948, 8105, 11248, 8989, 11816, 18274, 18111]
                    }],
                    responsive: {
                        rules: [{
                            condition: {
                                maxWidth: 500
                            },
                            chartOptions: {
                                legend: {
                                    layout: 'horizontal',
                                    align: 'center',
                                    verticalAlign: 'bottom'
                                }
                            }
                        }]
                    }
                }
            }
        },
        created() {

        },
        mounted() {
            this.initChart();
        },
        methods:{
            initChart() {
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

                    // data: {
                    //     csvURL: 'https://cdn.jsdelivr.net/gh/highcharts/highcharts@v7.0.0/samples/data/analytics.csv',
                    //     beforeParse: function (csv) {
                    //         return csv.replace(/\n\n/g, '\n');
                    //     }
                    // },

                    title: {
                        text: 'Daily sessions at www.highcharts.com',
                        align: 'left'
                    },

                    subtitle: {
                        text: 'Source: Google Analytics',
                        align: 'left'
                    },

                    xAxis: {
                        tickInterval: 7 * 24 * 3600 * 1000, // one week
                        tickWidth: 0,
                        gridLineWidth: 1,
                        labels: {
                            align: 'left',
                            x: 3,
                            y: -3
                        }
                    },

                    // yAxis: [{ // left y axis
                    //     title: {
                    //         text: null
                    //     },
                    //     labels: {
                    //         align: 'left',
                    //         x: 3,
                    //         y: 16,
                    //         format: '{value:.,0f}'
                    //     },
                    //     showFirstLabel: false
                    // }, { // right y axis
                    //     linkedTo: 0,
                    //     gridLineWidth: 0,
                    //     opposite: true,
                    //     title: {
                    //         text: null
                    //     },
                    //     labels: {
                    //         align: 'right',
                    //         x: -3,
                    //         y: 16,
                    //         format: '{value:.,0f}'
                    //     },
                    //     showFirstLabel: false
                    // }],

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
                            }
                        }
                    },

                    series: [{
                        name: 'All sessions',
                        lineWidth: 4,
                        marker: {
                            radius: 4
                        },
                        data: [1, 2, 3, 4, 5]
                    }, {
                        name: 'New users',
                        data: [2, 3, 4, 5, 6]
                    }]
                });
            }
        }
    }
</script>

<style>

</style>
