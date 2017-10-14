<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Home Page</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- jQuery, bootstrap CDN -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="http://code.jquery.com/jquery-migrate-1.2.1.js"></script> <!-- msie 문제 해결 -->
	<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	<!-- TTS CDN -->
    <script src="/js/talkify/talkify.min.js"></script>
</head>
<body>
	<input type="hidden" id="serverip" value="${serverip}">
	<input type="hidden" id="serverport" value="${serverport}">
	<input type="hidden" id="userid" value="${user_id}">
	<img style="margin: auto" width="800" height="700" src="/images/smarthouse.png">
	<br>
	<div id="userinfo">
		<c:if test="${user_id == null}">
			<label>not login...(로그인을 해주세요)</label>
		</c:if>
		<c:if test="${user_id != null}">
			<div id="infoprint">
			</div>
		</c:if>
	</div>
</body>
<script type="text/javascript">
$(function(){
	var serverip = $('#serverip').val();
	var serverport = $('#serverport').val();
	var userid = $('#userid').val();
		
	var trans_objeect = 
	{
	    'user_id':userid
	}
	var trans_json = JSON.stringify(trans_objeect); //json으로 반환//
		
	$.ajax({
		url: "http://"+serverip+":"+serverport+"/userdetailinfo",
		type: 'POST',
		dataType: 'json',
		data: trans_json,
		contentType: 'application/json',
		mimeType: 'application/json',
		success: function(retVal){
			console.log('user detail info get success...');
			
			var infoStr = "";
			
			console.log('user name: ' + retVal.username);
			infoStr += "<label>*이름: "+retVal.username+"</label><br>"
			
			console.log('user address: ' + retVal.useraddress);
			infoStr += "<label>*주소: "+retVal.useraddress+"</label><br>"
			
			console.log('user phonenumber: ' + retVal.userphonenumber);
			infoStr += "<label>*전화번호: "+retVal.userphonenumber+"</label><br>"
			
			var sensorarray = [];
			sensorarray= retVal.usersensor;
			
			for(var i=0; i<retVal.usersensor.length; i++){
				console.log('sensor name: ' + sensorarray[i].sensor_name);
				infoStr += "<label>*가용센서: "+sensorarray[i].sensor_name+"</label><br>"
			}
			
			$('#infoprint').empty();
			$('#infoprint').append(infoStr);
		},
		error: function(retVal, status, er){
			console.log("error: "+retVal+" status: "+status+" er:"+er);
		}
	});
});
</script>
</html>