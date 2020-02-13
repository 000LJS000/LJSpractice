<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session = "true" %>
<% 
String userId;
if(session.getAttribute("USER_ID") != null){
	userId = (String)session.getAttribute("USER_ID");
	request.setAttribute("USER_ID", userId);
}

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
<html>
<head><title>내가 찜한 공간</title>
<%@ include file="/WEB-INF/common/calendar-header.jspf" %>
<style>
	.optitle{font-size: 20px}
	.opt>a{font-size: 15px; color: black; margin-right: 10px; margin-left: 10px; text-decoration: none;}
	.option{text-align: left;}
	.opt>a:hover{font-weight: bold;}
	.infoImage:hover{cursor: pointer; outline: black;}
	.favBtn:hover{cursor: pointer; outline: black;}
</style>
</head>
<body>

	<div style="text-align:center; width: 100%">
		<c:if test="${!empty USER_ID}">
			<input id="userId" type="hidden" value="${USER_ID}">
		</c:if>	
	
		<p>
		<div style="width: 800px; display: inline-block;">
			<table style="width: 800px;">
			<colgroup>
				<col width="35%">
				<col width="35%">
				<col width="35%">
			</colgroup>
				<c:if test="${empty SPACE_LIST}">
				<%session.setAttribute("USER_ID", "admin"); %>
					내가 찜한 리스트가 없습니다.
				</c:if>
				<c:forEach var="space" items="${SPACE_LIST}" varStatus="st">
					<c:set var="thumbnail" value="${fn:split(space.SPACE_IMG,',')[0]}"></c:set>
					<c:if test="${st.index % 3 == 0 }">
						<tr valign="top" style="width: inherit">
					</c:if>
					<td>
						<div id="info" class="spaceInfo" style="width: inherit;">
							<dl>
								<img class="infoImage" src="<c:url value='/image/${thumbnail}'/>" style="max-width: 270px;">
								<input type="hidden" id="spaceID" value="${space.SPACE_ID}">
							</dl>
							<dl>
								<div style="float:left; width: 80%; text-align:left;">
									${space.SPACE_ID}<br>
									${space.SPACE_TITLE}<br>
									${space.SPACE_USE} <br>	 ${space.SPACE_POS }<br>
									${space.SPACE_PRI}
								</div>
								<div class="favBtn" style="float:left; width: 20%">
								<%-- <c:set var="favImage" value="☆"/>
								<c:forEach var="favID" items="${FAVORI_LIST}">
									<c:if test="${space.SPACE_ID eq favID}">
										<c:set var="favImage" value="★"/>
									</c:if>
								</c:forEach>
								${favImage} --%>
								</div>
							</dl>
						</div>
					</td>
					<c:if test="${st.index % 3 eq 2 or st.last}">
						<c:if test="${st.last}">
							<c:forEach var="i" begin="1" end="${3-(st.count mod 3 )}" step="1">
								<td></td>
							</c:forEach>
						</c:if>
						</tr>
					</c:if>
				</c:forEach>
			</table>
		</div>
	</div>
	<%@ include file="/WEB-INF/common/include-body.jspf" %>
	<script type="text/javascript">
	$(document).ready(function(){
		fn_updateFavSpace();
		fn_setradioButton('${SEARCH_TYPE}');
		fn_setOptButton();
		$("#searchBtn").on("click",function(e){
			e.preventDefault();
			fn_searchSpaceList($(this));
		});
		$(".infoImage").on("click",function(e){
			e.preventDefault();
			
			fn_openSpaceDetail($(this));
		});
		$(".opt > a").on("click",function(e){
			e.preventDefault();
			if($(this).attr("name")==null){
				$(this).parent().find(".opt_val").val($(this).html());
			}else{
				$(this).parent().find(".opt_val").val('');
			}
			
			fn_searchSpaceList();
		});
		$(".favBtn").on("click",function(e){
			e.preventDefault();
			var val = $(this).parents("div").find("#spaceID").val();
			var userId=sessionStorage.getItem('USER_ID');
			var data = "USER_ID="+userId+"&SPACE_ID="+val; 
			$.ajax({
				url : "<c:url value='/space/updateFavori' />",
				type : "POST",
				data : data,
				async : false,
				success : function(data, status){
						if (typeof (fn_updateFavSpace) == "function") {
							fn_updateFavSpace(data);
						} else {
							eval(fn_updateFavSpace + "(data);");
						}
					}
				});
			});
		});
		$("input[name='SEARCH_TYPE']").change(function(){
			fn_searchSpaceList();
		});
	
		function fn_setOptButton(){
			$(".opt").each(function(){
				var opt = $(this);
				$(".opt_val").get().forEach(function(item,index,arr){
					if(!gfn_isNull($(item).val())){
					var temp = opt.find("a:contains('"+$(item).val()+"')");
					if( temp != null){
						temp.css('font-weight', 'bold');
					}
					}
				});
			});
		}
		function fn_setradioButton(type){
			if(type !=null){
				$("#radioForm").find("input[value='"+type+"']").prop('checked',true);
			}
		}
		function fn_searchSpaceList() {
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/space/SearchList'/>");
			comSubmit.addParam("START_DATE", $("#startDate").val());
			comSubmit.addParam("END_DATE", $("#endDate").val());
			comSubmit.addParam("SEARCH_TYPE", $("input[name='SEARCH_TYPE']:checked").val());
			comSubmit.addParam("TITLE", $("#searchTitle").val());
			comSubmit.addParam("USE", $("#use").val());
			comSubmit.addParam("POS", $("#pos").val());
			comSubmit.addParam("SIZE", $("#size").val());

			comSubmit.submit();
		}
		function fn_openSpaceDetail(obj) {
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/space/detailSpace'/>");
			comSubmit.addParam("SPACE_ID", obj.parent().find("#spaceID").val());
			comSubmit.submit(); 
		}
		function fn_updateFavSpace(data) {
			$(".favBtn").html("☆");
			var info;
			var list;
			if(data == null){
				if(${!empty FAVORI_LIST}){
					data = {favList : ${FAVORI_LIST}};
				}
			}
			if(data != null && !gfn_isNull($("#userId").val())){
				list=data.favList;
				list.forEach(function(item,index,arr){
				info = $(".spaceInfo").find("input[value="+item+"]");
				info.closest("div").find(".favBtn").html("★");
			});
			}
		}
	</script>
</body>
</html>