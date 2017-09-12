<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改设备</title>
</head>
<body>
	<div>
	<form action="updateDevice.do" method="post">
	<input type="hidden" name="deviceId" value="${device.deviceId }">
	<input type="hidden" name="buyDates" value="${device.buyDate }">
		<div>
			设备型号:<input type="text" name="deviceTypeId" value="${device.deviceTypeId }">
		</div>
		<div>
			设备名称:<input type="text" name="deviceName" value="${device.deviceName }">
		</div>
		<div>
			设备价格:<input type="text" name="price" value="${device.price }">
		</div>
		<div>
			设备类型：<select name="typeId">
				<c:forEach items="${list }" var="d">
					<option value="${d.typeId }" <c:if test="${device.type.typeId==d.typeId }">selected="selected"</c:if>>${d.typeName }</option>
				</c:forEach>
			</select>
		</div>
		<div>
			设备状态：<select name="stateId">
				<option value="1">正常</option>
				<option value="2">维修中</option>
				<option value="3">报废</option>
			</select>
		</div>
		<button>修改</button>
		</form>
	</div>
</body>
</html>