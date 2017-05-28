/**
 * Created by AmanpreetNagi on 2017-03-23.
 */

function createChart1(data){
    Highcharts.chart('container', {

        title: {
            text: 'Mobile Phone Sales, March 2017'
        },

        subtitle: {
            text: 'Android, iOS, Others'
        },

        yAxis: {
            title: {
                text: 'Number of Units Sold'
            }
        },
        xAxis:{

            description: 'Days of month',
            categories: data[3]



        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle'
        },

        plotOptions: {
            series: {

            }
        },

        series: [{
            name: 'Android',
            data: data[0]

        },
            {
            name: 'iOS',
            data: data[1]
        },
            {
            name: 'Others',
            data: data[2]
        }]

    });
}
