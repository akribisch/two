<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>设备调拨</title>
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
<form action="queryTranstion.do" method="post" id="myform">
	<div>
			设备：<select name="deviceId">
			<option value="0">--请选择--</option>
				<c:forEach items="${devicelist }" var="d">
					<option value="${d.deviceId }">${d.deviceName }</option>
				</c:forEach>
			</select>
		</div>
		<div>
			部门：<select name="depId">
				<c:forEach items="${deplist }" var="d">
					<option value="${d.depId }">${d.depName }</option>
				</c:forEach>
			</select>
		</div>
		<button>查询</button>
		
		<div>
			<a href="sendAddDevice.do">添加设备</a>
		</div>
	<div>
		<table class="table">
			<tr>
				<td>设备名称</td>
				<td>部门名称</td>
				<td>使用人员</td>
				<td>调拨时间</td>
				<td>使用几个月</td>
				<td>备注</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${paging.list }" var="d">
				<tr>
					<td>${d.device.deviceName }</td>
					<td>${d.depart.depName }</td>
					<td>${d.usePeople }</td>
					<td>${d.beginDate }</td>
					<td>${d.useOfMonth }</td>
					<td>${d.remark }</td>
					<td>
						<a href="changeTranstion.do?transId=${d.transId }">修改</a>
						<a href="deleteTranstion.do?transId=${d.transId }">删除</a>
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