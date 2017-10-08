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
</head>
<body>
	<img style="margin: auto" width="800" height="700" src="/images/smarthouse.png">
	<div>
		<input type="button" id="user_info_button" value="user info">
	</div>
	<br>
	<div>
		<input type="button" id="user_detailinfo_button" value="detail user info">
	</div>
</body>
<script type="text/javascript">
$(function(){
	$('#user_info_button').click(function(){
		var userid = 'scw3315';
		
		var trans_objeect = 
		{
	    	'user_id':userid
	    }
		var trans_json = JSON.stringify(trans_objeect); //json으로 반환//
		
		$.ajax({
			url: "http://172.30.1.2:8000/userinfo",
			type: 'POST',
			dataType: 'json',
			data: trans_json,
			contentType: 'application/json',
			mimeType: 'application/json',
			success: function(retVal){
				alert(""+retVal.result);
			},
			error: function(retVal, status, er){
				alert("error: "+retVal+" status: "+status+" er:"+er);
			}
		});
	});
	
	$('#user_detailinfo_button').click(function(){
		var userid = 'scw3315';
		
		var trans_objeect = 
		{
	    	'user_id':userid
	    }
		var trans_json = JSON.stringify(trans_objeect); //json으로 반환//
		
		$.ajax({
			url: "http://172.30.1.2:8000/userdetailinfo",
			type: 'POST',
			dataType: 'json',
			data: trans_json,
			contentType: 'application/json',
			mimeType: 'application/json',
			success: function(retVal){
				alert(""+retVal.result);
			},
			error: function(retVal, status, er){
				alert("error: "+retVal+" status: "+status+" er:"+er);
			}
		});
	});
});
</script>
</html>