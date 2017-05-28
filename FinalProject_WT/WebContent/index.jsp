<%--
  Created by IntelliJ IDEA.
  User: AmanpreetNagi
  Date: 2017-03-16
  Time: 11:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Final Project</title>
    <script src="https://code.highcharts.com/highcharts.js"></script>
    <script src="https://code.highcharts.com/modules/exporting.js"></script>


    <link href="stylesheet1.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

    <script src="chart1style.js"></script>
    <script src="chart2.js" type="text/javascript"></script>
    <script src="chart1.js" type="text/javascript"></script>
    <script src="Chart3.js" type="text/javascript"></script>
    <script src="Chart4.js" type="text/javascript"></script>

</head>
<body>

<%-- <c:import url="/data1"/> --%>




<h1 align="center" >Game of Phones</h1>

<div id="container"></div>
<br>

<script>
    var gameSale = [];
    gameSale[0] = [<c:forEach items="${xboxSales}" var="xboxSales">
        <c:out value="${xboxSales}" />,
        </c:forEach>];

    gameSale[1] = [<c:forEach items="${ps4Sales}" var="ps4Sales">
        <c:out value="${ps4Sales}"/>,
        </c:forEach>];

    gameSale[2] = [<c:forEach items="${pcSales}" var="pcSales">
        <c:out value="${pcSales}"/>,
        </c:forEach>];
    gameSale[3] = [<c:forEach items="${salesDate}" var="salesDate">
        <c:out value="${salesDate}"/>,
        </c:forEach>];
    createChart1(gameSale);
</script>

<form method="get" action="data1">
	<br>
    <input type="submit" value="Show Chart Data">
</form>

<form action="date1" method="get">
<fieldset>
<legend> Select Dates </legend>
	   	Start Date:
    	<input type="text" name="startDate" placeholder="yyyy/mm/dd" class="startDate">
    	End Date:
    	<input type="text" name="endDate" placeholder="yyyy/mm/dd" class="endDate">
    	<br>
    	<br>
    	<input type="submit" value="Submit">
</fieldset>
</form>

<form action="platform1" method="get">
<fieldset>
<legend> Select Type </legend>
    <select name="platform">
        <option value="androidSale"selected>Android</option>
        <option value="iosSale">iOS</option>
        <option value="otherSale">Others</option>
    </select>
    <br>
    <br>
    <input type="submit" value="Submit">
</fieldset>
</form>

<form action="combined1" method="get">
<fieldset>
<legend> Select Exact Date </legend>
    Particular Date:
    <input type="text" name="pDate" placeholder="yyyy/mm/dd" class="startDate">

    <select name="platform">
        <option value="androidSale"selected>Android</option>
        <option value="iosSale">iOS</option>
        <option value="otherSale">Others</option>
    </select>
    <br>
    <br>
    <input type="submit" value="Submit">
</fieldset>
</form>

</body>

<div id="chart_2" style="min-width: 310px; height: 400px; margin: 0 auto"></div>

<script>
    var gameRevenue = [];

    gameRevenue[0] = [<c:forEach items="${months}" var="months">
        '<c:out value="${months}"/>',
        </c:forEach>];
    gameRevenue[1] = [<c:forEach items="${androidRevenue}" var="androidRevenue">
        <c:out value="${androidRevenue}"/>,
        </c:forEach>];
    gameRevenue[2] = [<c:forEach items="${iosRevenue}" var="iosRevenue">
        <c:out value="${iosRevenue}"/>,
        </c:forEach>];
    gameRevenue[3] = [<c:forEach items="${otherRevenue}" var="otherRevenue">
        <c:out value="${otherRevenue}"/>,
        </c:forEach>];

    createChart2(gameRevenue);


</script>

<form method="get" action="data2">
		<br>
		<br>
    	<input type="submit" value="Show Chart Data">
</form>

<form action="date2" method="get">
	<fieldset>
	<legend> Select Month</legend>
    <select name="selected_month">
        <option value="jan" selected>January</option>
        <option value="feb">February</option>
        <option value="mar">March</option>
        <option value="apr">April</option>
        <option value="may">May</option>
        <option value="jun">June</option>
        <option value="jul">July</option>
        <option value="aug">August</option>
        <option value="sep">September</option>
        <option value="oct">October</option>
        <option value="nov">November</option>
        <option value="dec">December</option>
    </select>
    <br>
    <br>
    <input type="submit" value="Submit">
    </fieldset>
</form>

<form method="get" action="range">
	<fieldset>
	<legend>Select OS Revenue</legend>

    <h5>Android Revenue: </h5>
    <select name="xboxRev">
        <option value="3500" selected> >3500</option>
        <option value="4000"> >4000</option>
        <option value="4500"> >4500</option>
        <option value="5000"> >5000</option>
    </select>
    
    <h5>iOS Revenue:</h5>
    <select name="ps4Rev">
        <option value="3500" selected> >3500</option>
        <option value="4000"> >4000</option>
        <option value="4500"> >4500</option>
        <option value="5000"> >5000</option>
    </select>
    
    <h5>Others Revenue:</h5>
    <select name="pcRev">
        <option value="3500" selected> >3500</option>
        <option value="4000"> >4000</option>
        <option value="4500"> >4500</option>
        <option value="5000"> >5000</option>
    </select>
	<br>
	<br>
    <input type="submit" value="Submit">
    </fieldset>
</form>

<form method="get" action="combined2">
	<fieldset>
    <legend>Select Month</legend>
    <input type="checkbox" name="month" value="jan">January<br>
    <input type="checkbox" name="month" value="feb">February<br>
    <input type="checkbox" name="month" value="mar">March<br>
    <input type="checkbox" name="month" value="apr">April<br>
    <input type="checkbox" name="month" value="may">May<br>
    <input type="checkbox" name="month" value="jun">June<br>
    <input type="checkbox" name="month" value="jul">July<br>
    <input type="checkbox" name="month" value="aug">August<br>
    <input type="checkbox" name="month" value="sep">September<br>
    <input type="checkbox" name="month" value="oct">October<br>
    <input type="checkbox" name="month" value="nov">November<br>
    <input type="checkbox" name="month" value="dec">December<br>
	<br>
    <select name="platform">
        <option value="androidRevenue">Android</option>
        <option value="iosRevenue">iOS</option>
        <option value="otherRevenue">Others</option>
    </select>
    <br>
    <br>
    <input type="submit" value="Submit">
	</fieldset>
</form>


<div id="chart_3" style="min-width: 310px;height: 400px;margin: 0 auto"></div>

<script>

    var gameHours = [];

    gameHours[0] = [<c:forEach items="${games}" var="games">
        '<c:out value="${games}"/>',
        </c:forEach>];
    gameHours[1] = [<c:forEach items="${xboxHours}" var="xboxHours">
        <c:out value="${xboxHours}"/>,
        </c:forEach>];
    gameHours[2] = [<c:forEach items="${ps4Hours}" var="ps4Hours">
        <c:out value="${ps4Hours}"/>,
        </c:forEach>];
    gameHours[3] = [<c:forEach items="${pcHours}" var="pcHours">
        <c:out value="${pcHours}"/>,
        </c:forEach>];

    createChart3(gameHours);

</script>

<form method="get" action="data3">
	<br>
    <input type="submit" value="Show Chart Data">
</form>

<form method="get" action="c3f1">
	<fieldset>
    <legend>Select Number of Users</legend>
    <select name="hours">
        <option value="10000" selected>>12000</option>
        <option value="15000">>15000</option>
        <option value="18000">>18000</option>
        <option value="21000">>21000</option>
        <option value="24000">>24000</option>
        <option value="28000">>28000</option>
    </select>
    <br>
    <br>
    <input type="submit" value="Submit">
	</fieldset>
</form>

<form method="get" action="c3f2">
	<fieldset>
    <legend>Select Type</legend>
    <input type="checkbox" name="platform" value="androidUsers">Android<br>
    <input type="checkbox" name="platform" value="iosUsers">iOS<br>
    <input type="checkbox" name="platform" value="otherUsers">Others<br>
    <br>
    <input type="submit" value="Submit">
    </fieldset>
</form>


<form method="get" action="c3f3">
	<fieldset>
    <legend>Choose Week Number</legend>
    <select name="week">
        <option value="Week 1" selected>Week 1</option>
        <option value="Week 2">Week 2</option>
        <option value="Week 3">Week 3</option>
        <option value="Week 4">Week 4</option>
        <option value="Week 5">Week 5</option>
    </select>
    <br>
    <br>
    <input type="submit" value="Submit">
    </fieldset>
</form>

<div id="chart_4" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
<br>

<script>


    var weekHours = [];

    weekHours[0] =[<c:forEach items="${day}" var="day">
    '<c:out value="${day}"/>',
    </c:forEach>];
    weekHours[1] = [<c:forEach items="${john}" var="john">
        <c:out value="${john}"/>,
        </c:forEach>];
    weekHours[2] = [<c:forEach items="${jane}" var="jane">
        <c:out value="${jane}"/>,
        </c:forEach>];
    weekHours[3] = [<c:forEach items="${joe}" var="joe">
        <c:out value="${joe}"/>,
        </c:forEach>];

    createChart4(weekHours)


</script>
<form method="get" action="data4">
	<br>
	<br>
    <input type="submit" value="Show Chart Data">
</form>

<br>

<form method="get" action="c4f1">
<fieldset>
<legend>Choose Day</legend>
	<select name="day">
		<option value="Sunday"selected>Sunday</option>
		<option value="Monday">Monday</option>
		<option value="Tuesday">Tuesday</option>
		<option value="Wednesday">Wednesday</option>
		<option value="Thursday">Thursday</option>
		<option value="Friday">Friday</option>
		<option value="Saturday">Saturday</option>
	</select>
	<br>
	<br>
	<input type="submit" value="Submit">
</fieldset>
</form>

<br>
<form method="get" action="c4f2">
<fieldset>
<legend>Average OS Users</legend>
	<select name="employee">
		<option value="games" selected>Games</option>
		<option value="utility">Utility</option>
		<option value="music">Music</option>
	</select>
	<br>
	<br>
	<input type="submit" value="Submit">
</fieldset>
</form>

<br>
<form method="get" action="c4f3">
<fieldset>
<legend>Select First Day and Last Day</legend>
<h5>Choose First Day</h5>
	<select name="firstDay">
		<option value="Sunday"selected>Sunday</option>
		<option value="Monday">Monday</option>
		<option value="Tuesday">Tuesday</option>
		<option value="Wednesday">Wednesday</option>
		<option value="Thursday">Thursday</option>
		<option value="Friday">Friday</option>
		<option value="Saturday">Saturday</option>
	</select>
<br>
<br>
<h5>Choose Last Day</h5>
	<select name="lastDay">
		<option value="Sunday">Sunday</option>
		<option value="Monday">Monday</option>
		<option value="Tuesday">Tuesday</option>
		<option value="Wednesday">Wednesday</option>
		<option value="Thursday">Thursday</option>
		<option value="Friday">Friday</option>
		<option value="Saturday"selected>Saturday</option>
	</select>
	<br>
	<br>
	<input type="submit" value="Submit">
</fieldset>
</form>

</body>

<script>

    $(document).ready(function () {

        $(".startDate").each(function () {
            $(this).datepicker({
                dateFormat: "yy/mm/dd",

                altFormat: "yy-mm-dd"

            });
        });
        $(".endDate").each(function () {
            $(this).datepicker({

                dateFormat: "yy/mm/dd",
                altFormat: "yy-mm-dd"

            });
        });
    });
</script>

</html>
