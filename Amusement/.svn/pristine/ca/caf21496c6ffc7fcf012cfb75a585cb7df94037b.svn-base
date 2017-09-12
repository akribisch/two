<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加报修信息</title>
</head>
<body>
<div>
	<form action="addFeedback.do" method="post">
		<div>
			部门：<select name="depId">
				<c:forEach items="${departlist }" var="d">
					<option value="${d.depId }">${d.depName }</option>
				</c:forEach>
			</select>
		</div>
		<div>
			报修人员:<input type="text" name="userName">
		</div>
		<div>
			损坏时间:<input type="text" name="repairDates">
		</div>
		<div>
			预约时间:<input type="text" name="orderDates">
		</div>
		<div>
			设备类型：<select name="deviceId">
				<c:forEach items="${devicelist }" var="d">
					<option value="${d.deviceId }">${d.deviceName }</option>
				</c:forEach>
			</select>
		</div>
		<div>
			问题描述:<input type="text" name="question">
		</div>
		<button>添加</button>
		</form>
	</div>
</body>
</html>