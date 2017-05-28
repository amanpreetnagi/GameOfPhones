function createChart3(hoursData) {


    Highcharts.chart('chart_3', {
        chart: {
            type: 'column'
        },
        title: {
            text: 'Overall application downloads'
        },
        subtitle: {
            text: 'In Each Week'
        },
        xAxis: {
            categories: hoursData[0]
        },
        yAxis: {
            min: 10000,
            title: {
                text: 'Total Downloads'
            }
        },
        tooltip: {
            pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.y}</b> ({point.percentage:.0f}%)<br/>',
            shared: true
        },
        plotOptions: {
            column: {
                stacking: 'percentage'
            }
        },
        series: [{
            name: 'Android',
            data: hoursData[2]
        }, {
            name: 'iOS',
            data: hoursData[1]
        }, {
            name: 'Others',
            data: hoursData[3]
        }]
    });

}