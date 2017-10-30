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
	<!-- jqGrid CDN & paging -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqgrid/4.6.0/css/ui.jqgrid.css" />
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jqgrid/4.6.0/js/jquery.jqGrid.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jqgrid/4.6.0/js/i18n/grid.locale-en.js"></script>
	<script src="/js/util/paginate.js"></script>
	<!-- D3.js CDN & js file & css -->
	<script src="http://d3js.org/d3.v3.min.js" language="JavaScript"></script>
	<script src="/js/d3/liquidFillGauge.js"></script>
	<style>
        .liquidFillGaugeText { font-family: Helvetica; font-weight: bold; }
    </style>
    <!-- TTS CDN -->
    <script src="/js/talkify/talkify.min.js"></script>
</head>
<body>
	<input type="hidden" id="serverip" value="${serverip}">
	<input type="hidden" id="serverport" value="${serverport}">
	<input type="hidden" id="usersession" value="${userid}">
	<input type="hidden" id="username" value="${username}">
	<input type="hidden" id="useraddress" value="${useraddress}">
	
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
		    	<li><a href="#!tip">실생활 팁</a></li>
    		</ul>
    		<ul class="nav navbar-nav navbar-right">
    			<c:if test="${userid == null}">
    				<li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
		    		<li><a href="#"><span class="glyphicon glyphicon-log-in" id="logoutbutton"></span> Login</a></li>
    			</c:if>
    			<c:if test="${userid != null}">
    				<li><a href="#"><span class="glyphicon glyphicon-log-out" id="logoutbutton"></span> Logout</a></li>
    			</c:if>
    		</ul>
  		</div>
	</nav>
	<div ui-view>
		<img style="margin: auto" width="800" height="700" src="/images/mainimage.png">
		<br>
		<div>
			<input type="button" id="info" value="소개">
		</div>
	</div>
</body>
<script type="text/javascript">
$(function(){
	var player = new talkify.Html5Player();
	var userid = $('#usersession').val();
	var username = $('#username').val();
	var useraddress = $('#useraddress').val();
	
	if(userid == null){
		
	} else {
		//데이터 셋팅//
		var sayinfo = username + " 님 환영합니다!! 저희 홈 서비스와 함께 즐거운 하루 보내세요. 현재 등록된 주소지는 " + useraddress + " 입니다.";
		
		player.pause();
		player.dispose();
		player.playText(sayinfo);	
	}
	
	$('#logoutbutton').click(function(){
		var serverip = $('#serverip').val();
		var serverport = $('#serverport').val();
		
		$.ajax({
			url: "http://"+serverip+":"+serverport+"/logoutajax",
			type: 'POST',
			contentType: 'application/json',
			mimeType: 'application/json',
			success: function(retVal){
				var url = "http://"+serverip+":"+serverport+"/login.do";
		        $(location).attr("href", url);
			},
			error: function(retVal, status, er){
				console.log('logout fail...');
			}
		});
	});
	
	$('#info').click(function(){
		player.pause();
		player.dispose();
		var sayinfo = "홈 메뉴는 사용자의 기본 정보를 알 수 있습니다. 우리집 온도,습도 메뉴는 현재 집안의 온도와 습도 정보를 알 수 잇씁니다. 우리집 조도량 메뉴는 현재 집안에 불이 켜진곳과 꺼진 곳을 알 수 있습니다.";
		player.playText(sayinfo);	
	});
});
</script>
</html>