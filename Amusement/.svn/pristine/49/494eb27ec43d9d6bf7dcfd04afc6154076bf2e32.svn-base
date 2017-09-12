<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改维修信息</title>
</head>
<body>
<div>
	<form action="updateRepair.do" method="post">
		<input type="hidden" name="repairId" value="${repair.repairId }">
		<input type="hidden" name="beginDates" value="${repair.beginDate }">
		<div>
			维修人员:<input type="text" name="repairPeople" value="${repair.repairPeople }">
		</div>
		<div>
			设备：<select name="deviceId">
				<c:forEach items="${list }" var="d">
					<option value="${d.deviceId }" <c:if test="${repair.device.deviceId==d.deviceId }">selected="selected"</c:if>>${d.deviceName }</option>
				</c:forEach>
			</select>
		</div>
		<div>
			设备维修价格:<input type="text" name="repairPrice" value="${repair.repairPrice }">
		</div>
		<div>
			备注:<input type="text" name="remark" value="${repair.remark }">
		</div>
		<button>修改</button>
		</form>
	</div>
</body>
</html>