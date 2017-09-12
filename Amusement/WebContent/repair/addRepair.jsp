<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加维修设备</title>
</head>
<body>
<div>
	<form action="addRepair.do" method="post">
		<div>
			维修人员:<input type="text" name="repairPeople">
		</div>
		<div>
			设备：<select name="deviceId">
				<c:forEach items="${list }" var="d">
					<option value="${d.deviceId }">${d.deviceName }</option>
				</c:forEach>
			</select>
		</div>
		<div>
			设备维修价格:<input type="text" name="repairPrice">
		</div>
		<div>
			备注:<input type="text" name="remark">
		</div>
		<button>添加</button>
		</form>
	</div>
</body>
</html>