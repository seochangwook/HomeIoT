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
	<!-- TTS CDN -->
    <script src="/js/talkify/talkify.min.js"></script>
</head>
<body>
	<input type="hidden" id="serverip" value="${serverip}">
	<input type="hidden" id="serverport" value="${serverport}">
	<input type="hidden" id="userid" value="${user_id}">
	<input type="hidden" id="lightsensor_id" value="${lightsensor_id}">
	
	<input type="hidden" id="room1value" value="${room1value}">
	<input type="hidden" id="room2value" value="${room2value}">
	<input type="hidden" id="room3value" value="${room3value}">
	
	<input type="hidden" id="room1valueonoff" value="${room1valueonoff}">
	<input type="hidden" id="room2valueonoff" value="${room2valueonoff}">
	<input type="hidden" id="room3valueonoff" value="${room3valueonoff}">
	<div>
		<input type="button" id="infobutton" value="요약">
	</div>
	<div>
		<img style="margin: auto" width="800" height="700" src="/images/house.png">
	</div>
	<div id="room1">
		<label>* 침실 1</label>
		<c:if test="${room1value > 120}">
			<img style="margin: auto" width="120" height="120" src="/images/light_off.png">
		</c:if>
		<c:if test="${room1value <= 120}">
			<img style="margin: auto" width="120" height="120" src="/images/light_on.png">
		</c:if>
		<c:if test="${room1valueonoff == 0}">
			<input type="button" id="light1_on_button" value="불 켜기">
		</c:if>
		<c:if test="${room1valueonoff == 1}">
			<input type="button" id="light1_off_button" value="불 끄기">
		</c:if>
	</div>
	<div id="room2">
		<label>* 침실 2</label>
		<c:if test="${room2value > 120}">
			<img style="margin: auto" width="120" height="120" src="/images/light_off.png">
		</c:if>
		<c:if test="${room2value <= 120}">
			<img style="margin: auto" width="120" height="120" src="/images/light_on.png">
		</c:if>
		<c:if test="${room2valueonoff == 0}">
			<input type="button" id="light2_on_button" value="불 켜기">
		</c:if>
		<c:if test="${room2valueonoff == 1}">
			<input type="button" id="light2_off_button" value="불 끄기">
		</c:if>
	</div>
	<div id="room3">
		<label>* 침실 3</label>
		<c:if test="${room3value > 120}">
			<img style="margin: auto" width="120" height="120" src="/images/light_off.png">
		</c:if>
		<c:if test="${room3value <= 120}">
			<img style="margin: auto" width="120" height="120" src="/images/light_on.png">
		</c:if>
		<c:if test="${room3valueonoff == 0}">
			<input type="button" id="light3_on_button" value="불 켜기">
		</c:if>
		<c:if test="${room3valueonoff == 1}">
			<input type="button" id="light3_off_button" value="불 끄기">
		</c:if>
	</div>
	<br>
	<iframe width="420" height="345" src="https://youtube.com/embed/dMjcCT0w7us">
	</iframe>
</body>
<script type="text/javascript">
$(function(){
	$('#infobutton').click(function(){
		var infostr = "";
		
		var player = new talkify.Html5Player();
		
		var room1value = $('#room1value').val();
		var room2value = $('#room2value').val();
		var room3value = $('#room3value').val();
		
		if(room1value > 120){
			infostr += "침실1 불 꺼짐,";
		} else if(room1value <= 120){
			infostr += "침실1 불 켜짐,";
		}
		
		if(room2value > 120){
			infostr += "침실2 불 꺼짐";
		} else if(room2value <= 120){
			infostr += "침실2 불 켜짐,";
		}
		
		if(room3value > 120){
			infostr += "침실3 불 꺼짐,";
		} else if(room3value <= 120){
			infostr += "침실3 불 켜짐,";
		}
		
		//데이터 셋팅//
		player.playText(infostr);
	});
	$('#light1_on_button').click(function(){
		var infostr = "";
		
		var player = new talkify.Html5Player();
		
		var serverip = $('#serverip').val();
		var serverport = $('#serverport').val();
		var userid = $('#userid').val();
		var lightsensor_id = $('#lightsensor_id').val();
		var room_number = 'sensor_value_1_on_off_flag';
		var onoffflag = '1';
		
		var trans_objeect = 
		{
		    'user_id':userid,
		    'sensor_id':lightsensor_id,
		    'room_number':room_number,
		    'onoffflag':onoffflag
		}
		var trans_json = JSON.stringify(trans_objeect); //json으로 반환//
			
		$.ajax({
			url: "http://"+serverip+":"+serverport+"/lightonoffupdate",
			type: 'POST',
			dataType: 'json',
			data: trans_json,
			contentType: 'application/json',
			mimeType: 'application/json',
			success: function(retVal){
				console.log(retVal.result);
				
				infostr = '침실1 불이 켜집니다.';
				//데이터 셋팅//
				player.playText(infostr);
			},
			error: function(retVal, status, er){
				console.log("error: "+retVal+" status: "+status+" er:"+er);
			}
		});
	});
	$('#light1_off_button').click(function(){
		var infostr = "";
		
		var player = new talkify.Html5Player();
		
		var serverip = $('#serverip').val();
		var serverport = $('#serverport').val();
		var userid = $('#userid').val();
		var lightsensor_id = $('#lightsensor_id').val();
		var room_number = 'sensor_value_1_on_off_flag';
		var onoffflag = '0';

		var trans_objeect = 
		{
		    'user_id':userid,
		    'sensor_id':lightsensor_id,
		    'room_number':room_number,
		    'onoffflag':onoffflag
		}
		var trans_json = JSON.stringify(trans_objeect); //json으로 반환//
			
		$.ajax({
			url: "http://"+serverip+":"+serverport+"/lightonoffupdate",
			type: 'POST',
			dataType: 'json',
			data: trans_json,
			contentType: 'application/json',
			mimeType: 'application/json',
			success: function(retVal){
				console.log(retVal.result);
				
				infostr = '침실1 불이 꺼집니다.';
				//데이터 셋팅//
				player.playText(infostr);
			},
			error: function(retVal, status, er){
				console.log("error: "+retVal+" status: "+status+" er:"+er);
			}
		});
	});
	$('#light2_on_button').click(function(){
		var infostr = "";
		
		var player = new talkify.Html5Player();
		
		var serverip = $('#serverip').val();
		var serverport = $('#serverport').val();
		var userid = $('#userid').val();
		var lightsensor_id = $('#lightsensor_id').val();
		var room_number = 'sensor_value_2_on_off_flag';
		var onoffflag = '1';
		
		var trans_objeect = 
		{
		    'user_id':userid,
		    'sensor_id':lightsensor_id,
		    'room_number':room_number,
		    'onoffflag':onoffflag
		}
		var trans_json = JSON.stringify(trans_objeect); //json으로 반환//
			
		$.ajax({
			url: "http://"+serverip+":"+serverport+"/lightonoffupdate",
			type: 'POST',
			dataType: 'json',
			data: trans_json,
			contentType: 'application/json',
			mimeType: 'application/json',
			success: function(retVal){
				console.log(retVal.result);
				
				infostr = '침실2 불이 켜집니다.';
				//데이터 셋팅//
				player.playText(infostr);
			},
			error: function(retVal, status, er){
				console.log("error: "+retVal+" status: "+status+" er:"+er);
			}
		});
	});
	$('#light2_off_button').click(function(){
		var infostr = "";
		
		var player = new talkify.Html5Player();
		
		var serverip = $('#serverip').val();
		var serverport = $('#serverport').val();
		var userid = $('#userid').val();
		var lightsensor_id = $('#lightsensor_id').val();
		var room_number = 'sensor_value_2_on_off_flag';
		var onoffflag = '0';

		var trans_objeect = 
		{
		    'user_id':userid,
		    'sensor_id':lightsensor_id,
		    'room_number':room_number,
		    'onoffflag':onoffflag
		}
		var trans_json = JSON.stringify(trans_objeect); //json으로 반환//
			
		$.ajax({
			url: "http://"+serverip+":"+serverport+"/lightonoffupdate",
			type: 'POST',
			dataType: 'json',
			data: trans_json,
			contentType: 'application/json',
			mimeType: 'application/json',
			success: function(retVal){
				console.log(retVal.result);
				
				infostr = '침실2 불이 꺼집니다.';
				//데이터 셋팅//
				player.playText(infostr);
			},
			error: function(retVal, status, er){
				console.log("error: "+retVal+" status: "+status+" er:"+er);
			}
		});
	});
	$('#light3_on_button').click(function(){
		var infostr = "";
		
		var player = new talkify.Html5Player();
		
		var serverip = $('#serverip').val();
		var serverport = $('#serverport').val();
		var userid = $('#userid').val();
		var lightsensor_id = $('#lightsensor_id').val();
		var room_number = 'sensor_value_3_on_off_flag';
		var onoffflag = '1';
		
		var trans_objeect = 
		{
		    'user_id':userid,
		    'sensor_id':lightsensor_id,
		    'room_number':room_number,
		    'onoffflag':onoffflag
		}
		var trans_json = JSON.stringify(trans_objeect); //json으로 반환//
			
		$.ajax({
			url: "http://"+serverip+":"+serverport+"/lightonoffupdate",
			type: 'POST',
			dataType: 'json',
			data: trans_json,
			contentType: 'application/json',
			mimeType: 'application/json',
			success: function(retVal){
				console.log(retVal.result);
				
				infostr = '침실3 불이 켜집니다.';
				//데이터 셋팅//
				player.playText(infostr);
			},
			error: function(retVal, status, er){
				console.log("error: "+retVal+" status: "+status+" er:"+er);
			}
		});
	});
	$('#light3_off_button').click(function(){
		var infostr = "";
		
		var player = new talkify.Html5Player();
		
		var serverip = $('#serverip').val();
		var serverport = $('#serverport').val();
		var userid = $('#userid').val();
		var lightsensor_id = $('#lightsensor_id').val();
		var room_number = 'sensor_value_3_on_off_flag';
		var onoffflag = '0';

		var trans_objeect = 
		{
		    'user_id':userid,
		    'sensor_id':lightsensor_id,
		    'room_number':room_number,
		    'onoffflag':onoffflag
		}
		var trans_json = JSON.stringify(trans_objeect); //json으로 반환//
			
		$.ajax({
			url: "http://"+serverip+":"+serverport+"/lightonoffupdate",
			type: 'POST',
			dataType: 'json',
			data: trans_json,
			contentType: 'application/json',
			mimeType: 'application/json',
			success: function(retVal){
				console.log(retVal.result);
				
				infostr = '침실3 불이 꺼집니다.';
				//데이터 셋팅//
				player.playText(infostr);
			},
			error: function(retVal, status, er){
				console.log("error: "+retVal+" status: "+status+" er:"+er);
			}
		});
	});
});
</script>
</html>