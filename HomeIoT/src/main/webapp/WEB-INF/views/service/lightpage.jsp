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
	<input type="hidden" id="room1value" value="${room1value}">
	<input type="hidden" id="room2value" value="${room2value}">
	<input type="hidden" id="room3value" value="${room3value}">
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
	</div>
	<div id="room2">
		<label>* 침실 2</label>
		<c:if test="${room2value > 120}">
			<img style="margin: auto" width="120" height="120" src="/images/light_off.png">
		</c:if>
		<c:if test="${room2value <= 120}">
			<img style="margin: auto" width="120" height="120" src="/images/light_on.png">
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
	</div>
</body>
<script type="text/javascript">
$(function(){
	
});
</script>
</html>