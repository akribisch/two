<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>设备</title>
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
		<form action="queryDevice.do" method="post" id="myform">
		<div>
			设备型号:<input type="text" name="deviceTypeId">
			设备名称:<input type="text" name="deviceName">
			设备类型：<select name="typeId">
			<option value="0">--请选择--</option>
				<c:forEach items="${list }" var="d">
					<option value="${d.typeId }">${d.typeName }</option>
				</c:forEach>
			</select>
			<button>查询</button>
			
		</div>
		<div>
			<a href="sendAddDevice.do">添加设备</a>
		</div>
	<div>
		<table class="table">
			<tr>
				<td>设备型号</td>
				<td>设备名称</td>
				<td>设备类型</td>
				<td>设备状态</td>
				<td>设备价格</td>
				<td>购买日期</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${paging.list }" var="d">
				<tr>
					<td>${d.deviceTypeId }</td>
					<td>${d.deviceName }</td>
					<td>${d.type.typeName }</td>
					<td>${d.deviceState }</td>
					<td>${d.price }</td>
					<td>${d.buyDate }</td>
					<td>
						<a href="changeDevice.do?deviceId=${d.deviceId }">修改</a>
						<a href="deleteDevice.do?deviceId=${d.deviceId }">删除</a>
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