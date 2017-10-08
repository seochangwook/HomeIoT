<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html ng-app="routerApp">
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
	<!-- AngularJS CDN -->
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.3.2/angular-ui-router.js"></script>
	<!-- AngularJS External File -->
	<script src="/js/views/router.js"></script>
	<!-- Zebra-Dialog CDN -->
	<script src="/js/dialog/zebra_dialog.src.js"></script>
	<link rel="stylesheet" href="/css/dialog/zebra_dialog.css" type="text/css"/>
	<!-- D3.js CDN & js file & css -->
	<script src="http://d3js.org/d3.v3.min.js" language="JavaScript"></script>
	<script src="/js/d3/liquidFillGauge.js"></script>
	<style>
        .liquidFillGaugeText { font-family: Helvetica; font-weight: bold; }
    </style>
</head>
<body>
	<!-- ui-view는 페이지 주입 위치이다. -->
	<nav class="navbar navbar-inverse">
		<div class="center" style="text-align: center">
			<img src="/images/ioticon.png" class="img-circle" alt="Cinque Terre" width="70" height="70">
		</div>
		<div class="center" style="text-align: center">
			<h1 style="text-shadow: 3px 2px white">Home IoT</h1>
		</div>
		<div class="navbar-header">
      		<a class="navbar-brand" href="#!home">Home</a>
    	</div>
  		<div class="container-fluid">
    		<ul class="nav navbar-nav">
		      	<li><a href="#!temphumi">우리집 온도/습도</a></li>
		    	<li><a href="#!light">우리집 조도량</a></li>
    		</ul>
    		<ul class="nav navbar-nav navbar-right">
		    	<li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
		    	<li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    		</ul>
  		</div>
	</nav>
	<div ui-view>
		<img style="margin: auto" width="800" height="700" src="/images/smarthouse.png">
	</div>
</body>
</html>