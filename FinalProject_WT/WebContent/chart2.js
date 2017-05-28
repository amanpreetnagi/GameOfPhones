/**
 * Created by AmanpreetNagi on 2017-03-26.
 */
 //$(document).ready(function(){

function createChart2(revenueData){

        Highcharts.chart('chart_2', {
            chart: {
                type: 'column'
            },
            title: {
                text: 'Monthly Average Revenue'
            },
            subtitle: {
                text: '2016'
            },
            xAxis: {
                categories: revenueData[0],
                crosshair: true
            },
            yAxis: {
                min: 0,
                title: {
                    text: 'Revenue ($)'
                }
            },
            tooltip: {
                headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}:</td>' +
                '<td style="padding:0"><b>{point.y:.1f} $ </b></td></tr>',
                footerFormat: '</table>',
                shared: true,
                useHTML: true
            },
            plotOptions: {
                column: {
                    pointPadding: 0.2,
                    borderWidth: 0
                }
            },
            series: [{
                name: 'Android Phones Revenue',
                data: revenueData[1]

            }, {
                name: 'iOS Phones Revenue',
                data: revenueData[2]

            }, {
                name: 'Other OS Phones Revenue',
                data: revenueData[3]

            }

            ]
        });
}
//});