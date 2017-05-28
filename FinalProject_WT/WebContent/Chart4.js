/**
 * Created by AmanpreetNagi on 2017-04-16.
 */

//$(document).ready(function () {

function createChart4(weekhours) {

    Highcharts.chart('chart_4', {
        chart: {
            type: 'areaspline'
        },
        title: {
            text: 'Average application downloads'
        },
        subtitle: {
            text: 'During One Week'
        },
        legend: {
            layout: 'vertical',
            align: 'left',
            verticalAlign: 'top',
            x: 150,
            y: 100,
            floating: true,
            borderWidth: 1,
            backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
        },
        xAxis: {
            categories: weekhours[0]
               ,
            plotBands: [{ // visualize the weekend
                from: 4.5,
                to: 6.5,
                color: 'rgba(68, 170, 213, .2)'
            }]
        },
        yAxis: {
            title: {
                text: 'Total Downloads (in Millions)'
            }
        },
        tooltip: {
            shared: true,
            valueSuffix: ' units'
        },
        credits: {
            enabled: false
        },
        plotOptions: {
            areaspline: {
                fillOpacity: 0.5
            }
        },
        series: [{
            name: 'Games',
            data: weekhours[1]
        }, {
            name: 'Utility',
            data: weekhours[2]
        }, {
            name: 'Music',
            data: weekhours[3]
        }

        ]
    });
}

//})
