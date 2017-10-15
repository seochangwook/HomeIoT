<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login</title>
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
	<h1>Home IoT</h1>
	<div>
		<c:url value="/j_spring_security_check" var="loginUrl" />
		<form action="${loginUrl}" method="POST">
        	ID : <input type="text" name="j_username" size="20" maxlength="50" /><br />
        	Password : <input type="password" name="j_password" size="20" maxlength="50" /><br/>
        	<br>
        	<input type="submit" value="Login" />
        	<button type="button" data-toggle="modal" data-target="#myModal">회원가입</button>
    	</form>
	</div>
	<br>
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
	    	<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	    	<li data-target="#myCarousel" data-slide-to="1"></li>
	    	<li data-target="#myCarousel" data-slide-to="2"></li>
	  	</ol>

  		<!-- Wrapper for slides -->
  		<div class="carousel-inner" role="listbox">
    		<div class="item active">
      			<img src="/images/tempinfo.png" alt="New York" style="margin: auto" width="420" height="420">
     		<div class="carousel-caption">
        		<h3>온도</h3>
        		<p>현재 집 안의 온도정보를 알 수 있습니다.</p>
      		</div> 
    	</div>

    	<div class="item">
	    	<img src="/images/humiinfo.png" alt="Chicago" style="margin: auto" width="420" height="420">
	      	<div class="carousel-caption">
	        	<h3>습도</h3>
	        	<p>현재 집 안의 습도정보를 알 수 있습니다.</p>
	      	</div> 
	    </div>
	
	    <div class="item">
	    	<img src="/images/lightinfo.png" alt="Los Angeles" style="margin: auto" width="420" height="420">
	      		<div class="carousel-caption">
	        		<h3>조도량</h3>
	        		<p>현재 집 안의 불이 켜진곳과 꺼진곳을 알 수 있습니다.</p>
	      		</div> 
	    	</div>
		</div>

  		<!-- Left and right controls -->
  		<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    		<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    		<span class="sr-only">Previous</span>
  		</a>
  		<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    		<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    		<span class="sr-only">Next</span>
  		</a>
	</div>
	
	
	<!-- Modal -->
  	<div class="modal fade" id="myModal" role="dialog">
    	<div class="modal-dialog modal-lg">
      		<div class="modal-content">
        		<div class="modal-header">
          			<button type="button" class="close" data-dismiss="modal">&times;</button>
          			<h4 class="modal-title">회원가입</h4>
        		</div>
        		<div class="modal-body">
          			<p>This is a large modal.</p>
        		</div>
        		<div class="modal-footer">
          			<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
        		</div>
      		</div>
    	</div>
  	</div>
  	
</body>
</html>