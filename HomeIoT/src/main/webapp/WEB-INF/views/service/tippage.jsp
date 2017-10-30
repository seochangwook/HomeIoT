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
	<!-- jqGrid CDN & paging -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqgrid/4.6.0/css/ui.jqgrid.css" />
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jqgrid/4.6.0/js/jquery.jqGrid.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jqgrid/4.6.0/js/i18n/grid.locale-en.js"></script>
	<script src="/js/util/paginate.js"></script>
</head>
<body>
	<h1>실생활 팁!!</h1>
	<h3>유용하게 알아두자 (수도, 전기, 환기 등)</h3>	
	<br>
	<button id="refresh"><img src='/images/refreshbutton.PNG' width='50' height='50'></button>&nbsp
	<select name="rownumselect" onchange="setValues(this.value);">
    	<option value="2">rowNum</option>
    	<option value="1">1</option>
    	<option value="5">5</option>
    	<option value="10">10</option>
	</select>
	<br>
	<div>
		<table id="grid"></table>
	</div>
	<br>
	<div id="paginate" class="pagenate" align="center">
	</div>
	<br>
	<div>
		<label>* Search Info</label><br>
		<input type="text" placeholder="input search tip name" id="searchtext">&nbsp
		<input type="button" value="search(table reload)" id="searchbutton">&nbsp
		<input type="button" value="refresh" id="refreshbutton">
	</div>
</body>
<script type="text/javascript">
$(function(){
	//Grid 새로고침//
	$('#refresh').click(function(){
		$("#grid").jqGrid('GridUnload'); //그리드를 전체 지운다.//
		
		datainit(); //재로드//
	});
	$('#refreshbutton').click(function(){
		$('#searchtext').val('');
		$("#grid").jqGrid('GridUnload'); //그리드를 전체 지운다.//
		
		datainit(); //재로드//
	});
	//Grid에서 검색 및 테이블 리로드//
	$('#searchbutton').click(function(){
		$('#grid').jqGrid('setGridParam', {
			search:true,
			datatype:"json",
			loadonce:true,
			postData:{
				tip_name : $('#searchtext').val() //조건값 설정//
			},
			page : 1
		}).trigger('reloadGrid');
	});
});
</script>
<script type="text/javascript">
$(function(){
	datainit(); //Grid 초기화//
});
function datainit(){
	//jqGrid Setting//
	$('#grid').jqGrid({
		url:'<c:url value="/tiplist"/>',
		mtype:'POST',
		datatype:"json",
		height:'auto',
		width:'auto',
		autowidth:true,
		rowNum:2,
		pager:'#pager',
		loadonce:true,
		colModel:[
			{label:'tipid', name:'tip_id', index:'tip_id', hidden:true},
         	{label:'팁 이름',name:'tip_name',index:'tip_name', width:50},
            {label:'팁 내용',name:'tip_content',index:'tip_content', width:50},
            {label:'팁 주소',name:'tip_ref_address',index:'tip_ref_address', width:50, formatter:infoclick}
        ],
		caption:"<label>* 총 <strong id='totalCnt'>0</strong>건의 검색결과가 있습니다.</label>",
		loadComplete:function(data){
			//그리드 로드가 종료된 후 실행//
			$('#totalCnt').text(data.records);
			//페이징 작업(loadonce가 true가 되야지 페이징 가능 = sort도 동일)//
			initPage("paginate", data.records, $('#grid').jqGrid("getGridParam", "rowNum"), data.page);
		}
	});
    
    console.log('data load success...');
}
////////////////////////////
function infoclick(cellvalue, options, rowdata, action){
	//테이블 내 버튼을 출력//
	return "<input type=\"button\" value=\"click\" onclick=\"info('"+rowdata.tip_ref_address+"')\"/>";
}
////////////////////////////
function info(tip_ref_address){
	console.log('------------------------');
	console.log('cell info print');
	console.log('tip_ref_address: ' + tip_ref_address);
	console.log('------------------------');
}
////////////////////////////
//페이지 이동(Search)//
function Search(searchPage){
	console.log('page['+searchPage+'] search...');
	
	$('#grid').jqGrid('setGridParam',{
		search:true,
		page:searchPage,
	}).trigger('reloadGrid');
}
/////////////////////////////
//select 박스 선택 이벤트//
function setValues(rowNum){
	console.log('select rowNum : ' + rowNum);
	
	//변경된 rowNum에 따라 호출//
	$('#grid').jqGrid('setGridParam', {
		page : 1,
		rowNum:rowNum,
	}).trigger('reloadGrid');
}
</script>
</html>