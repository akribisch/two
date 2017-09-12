<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询游客</title>
<%@ include file="../common/commoncss.jsp" %>
<%@ include file="../common/commonjs.jsp" %>
<script type="text/javascript">
$(function(){
	  $("li a").click(function(){
		  var page = $(this).attr("pagedata");//获取属性pdata的值
		  $("#myPage").val(page);
		  
		  $("#myform").submit();
		  
	  });
});  		
 </script>
</head>
<body>
	<div>
	<a href="excelTourist.do">导出</a>
		<form action="queryDevice.do" method="post" id="myform">
		<div>
			游客账户:<input type="text" name="tourCount">
			游客名称:<input type="text" name="tourName">
			游客性别:<input type="radio" value="0" name="tourSex">男
			<input type="radio" value="1" name="tourSex">女
			<button>查询</button>
			
		</div>
		<div>
			<a href="sendAddDevice.do">添加设备</a>
		</div>
	<div>
		<table class="table">
			<tr>
				<td>游客账户</td>
				<td>游客名称</td>
				<td>游客性别</td>
				<td>游客电话</td>
				<td>游客电子邮箱</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${paging.list }" var="d">
				<tr>
					<td>${d.tourCount }</td>
					<td>${d.tourName }</td>
					<td>
					<c:if test="${d.tourSex==0 }">
						男
					</c:if>
					<c:if test="${d.tourSex==1 }">
						女
					</c:if>
					</td>
					<td>${d.tourPhone }</td>
					<td>${d.tourEmail }</td>
					<td>
						<a href="changeTourist.do?touId=${d.touId }">修改</a>
						<a href="deleteTourist.do?touId=${d.touId }">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		
			<div class="panel-body">
		            ${paging.nav }
		      </div>
		      </div>
       </form>
       </div>
</body>
</html>