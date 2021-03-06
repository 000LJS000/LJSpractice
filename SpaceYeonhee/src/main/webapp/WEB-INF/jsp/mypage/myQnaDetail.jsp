<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
</head>
<title>1:1문의 상세</title>
<table class="qna_view">
<body>
<tr>
<th>글번호</th>
<td>
${map.ADQNA_NUM }
<input type="hidden" id="ADQNA_NUM" name="ADQNA_NUM" value="${map.ADQNA_NUM }">
</td>
<tr>
<th>답변여부</th>
<td>${map.ADQNA_ANS }</td>
<th>작성일자</th>
<td>${map.ADQNA_DATE }</td>
</tr>
<tr>
<th>제목</th>
<td colspan="3">${map.ADQNA_TITLE }</td>
<th>내용</th>
<td colspan="4">${map.ADQNA_CNT }</td>
</tr>
</table>

<a href="#this" class="btn" id="update">수정</a>
<a href="#this" class="btn" id="list">목록</a>
<a href="#this" class="btn" id="delete">삭제</a>

<%@ include file="/WEB-INF/include/include-body.jspf" %>
<script type="text/javascript">
$(document).ready(function(){
	$("#list").on("click", function(e){
		e.preventDefault();
		fn_Myqnalist();
	});
	
	$("#update").on("click", function(e){
		e.preventDefault();
		fn_Myqnaupdate();
	});
	
	$("#delete").on("click", function(e){
		e.preventDefault();
		fn_Myqnadelete();
	});
});

function fn_Myqnalist(){
	var comSubmit = new ComSubmit();
	comSubmit.setUrl("<c:url value='Myqnalist'/>");
	comSubmit.submit();
}

function fn_Myqnaupdate(){
	var adqna_num = "${map.ADQNA_NUM}";
	var comSubmit = new ComSubmit();
	comSubmit.setUrl("<c:url value='/mypage/Myqnaupdate'/>");
	comSubmit.addParam("ADQNA_NUM", adqna_num);
	comSubmit.submit();
}

function fn_Myqnadelete(){
	var comSubmit = new ComSubmit();
	comSubmit.setUrl("<c:url value='/mypage/Myqnadelete'/>");
	comSubmit.addParam("ADQNA_NUM", $("#ADQNA_NUM").val());
	comSUbmit.submit();
}
</script>

</body>
</html>