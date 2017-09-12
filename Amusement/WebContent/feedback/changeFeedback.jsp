<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改报修系统</title>
</head>
<body>
<div>
<form action="updateFeedback.do" method="post">
		<input type="hidden" name="feedId" value="${feedback.feedId }">
		<div>
			部门：<select name="depId">
				<c:forEach items="${departlist }" var="d">
					<option value="${d.depId }" <c:if test="${feedback.depart.depId==d.depId }">selected="selected"</c:if>>${d.depName }</option>
				</c:forEach>
			</select>
		</div>
		<div>
			报修人员:<input type="text" name="userName" value="${feedback.user.userName }">
		</div>
		<div>
			损坏时间:<input type="text" name="repairDates" value="${feedback.repairDate }">
		</div>
		<div>
			预约时间:<input type="text" name="orderDates" value="${feedback.orderDate }">
		</div>
		<div>
			设备类型：<select name="deviceId">
				<c:forEach items="${devicelist }" var="d">
					<option value="${d.deviceId }" <c:if test="${feedback.device.deviceId==d.deviceId }">selected="selected"</c:if>>${d.deviceName }</option>
				</c:forEach>
			</select>
		</div>
		<div>
			问题描述:<input type="text" name="question" value="${feedback.question }">
		</div>
		<div>
			状态:<select name="state">
				<option value="0" <c:if test="${feedback.state==0 }">selected="selected"</c:if>>处理中</option>
				<option value="1" <c:if test="${feedback.state==1 }">selected="selected"</c:if>>已完成</option>
			</select>
		</div>
		<button>修改</button>
		</form>
	</div>
</body>
</html>