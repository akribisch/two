<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>维修记录</title>
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
<form action="queryAll.do" method="post" id="myform">
<div>
	设备：<select name="deviceId">
	<option value="0">--请选择--</option>
				<c:forEach items="${list }" var="d">
					<option value="${d.deviceId }">${d.deviceName }</option>
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
				<td>维修人员</td>
				<td>维修时间</td>
				<td>维修价格</td>
				<td>备注</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${paging.list }" var="d">
				<tr>
					<td>${d.device.deviceTypeId }</td>
					<td>${d.device.deviceName }</td>
					<td>${d.repairPeople }</td>
					<td>${d.beginDate }</td>
					<td>${d.repairPrice }</td>
					<td>${d.remark }</td>
					<td>
						<a href="changeRepair.do?repairId=${d.repairId }">修改</a>
						<a href="deleteRepair.do?repairId=${d.repairId }">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		
			<div class="panel-body">
		            ${paging.nav }
		      </div>
		 </div>
       </form>

</body>
</html>