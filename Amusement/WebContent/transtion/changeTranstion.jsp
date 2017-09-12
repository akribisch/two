<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改调拨</title>
</head>
<body>
<div>
	<form action="updateTranstion.do" method="post">
		<input type="hidden" name="transId" value="${trans.transId }">
		<input type="hidden" name="beginDates" value="${trans.beginDate }">
		<div>
			设备：<select name="deviceId">
				<c:forEach items="${devicelist }" var="d">
					<option value="${d.deviceId }" <c:if test="${trans.device.deviceId==d.deviceId }">selected="selected"</c:if>>${d.deviceName }</option>
				</c:forEach>
			</select>
		</div>
		<div>
			部门：<select name="depId">
				<c:forEach items="${deplist }" var="d">
					<option value="${d.depId }" <c:if test="${trans.depart.depId==d.depId }">selected="selected"</c:if>>${d.depName }</option>
				</c:forEach>
			</select>
		</div>
		<div>
			使用人员:<input type="text" name="usePeople" value="${trans.usePeople }">
		</div>
		<div>
			使用几个月:<input type="text" name="useOfMonth" value="${trans.useOfMonth }">
		</div>
		<div>
			备注:<input type="text" name="remark" value="${trans.remark }">
		</div>
		<button>修改</button>
		</form>
	</div>
</body>
</html>