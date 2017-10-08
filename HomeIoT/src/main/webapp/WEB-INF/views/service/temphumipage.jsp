<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Main Page</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- jQuery, bootstrap CDN -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="http://code.jquery.com/jquery-migrate-1.2.1.js"></script> <!-- msie 문제 해결 -->
	<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
</head>
<body>
	<div style="float: left">
		<h2>* 현재 온도: </h2>
		<c:if test="${tempvalue == -1}">
			<label>wait...(server connect)</label>
		</c:if>
		<c:if test="${tempvalue != -1}">
			<input type="hidden" id="tempvalue" value="${tempvalue}">
			<svg id="fillgauge1" width="97%" height="250" onclick="gauge1.update('${tempvalue }');"></svg>
		</c:if>
		<br>
		<h2>* 현재 습도: </h2>
		<c:if test="${humivalue == -1}">
			<label>wait...(server connect)</label>
		</c:if>
		<c:if test="${humivalue != -1}">
			<input type="hidden" id="humivalue" value="${humivalue}">
			<svg id="fillgauge2" width="97%" height="250" onclick="gauge2.update('${humivalue}');"></svg>
		</c:if>
	</div>
</body>
<script type="text/javascript">
var tempvalue = document.getElementById("tempvalue").value;

var gauge1 = loadLiquidFillGauge("fillgauge1", tempvalue);
var config1 = liquidFillGaugeDefaultSettings();
config1.circleColor = "#FF7777";
config1.textColor = "#FF4444";
config1.waveTextColor = "#FFAAAA";
config1.waveColor = "#FFDDDD";
config1.circleThickness = 0.2;
config1.textVertPosition = 0.2;
config1.waveAnimateTime = 2000;
config1.waveCount = 1;
/////////////////////////////
var humivalue = document.getElementById("humivalue").value;

var gauge2= loadLiquidFillGauge("fillgauge2", humivalue, config1);
var config1= liquidFillGaugeDefaultSettings();
config1.circleColor = "#D4AB6A";
config1.textColor = "#553300";
config1.waveTextColor = "#805615";
config1.waveColor = "#AA7D39";
config1.circleThickness = 0.1;
config1.circleFillGap = 0.2;
config1.textVertPosition = 0.8;
config1.waveAnimateTime = 2000;
config1.waveHeight = 0.3;
config1.waveCount = 1;
//////////////////////////////
$(function(){
	
});
</script>
</html>