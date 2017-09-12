<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加设备</title>
</head>
<body>
	<div>
	<form action="addDevice.do" method="post">
		<div>
			设备型号:<input type="text" name="deviceTypeId">
		</div>
		<div>
			设备名称:<input type="text" name="deviceName">
		</div>
		<div>
			设备价格:<input type="text" name="price">
		</div>
		<div>
			设备类型：<select name="typeId">
				<c:forEach items="${list }" var="d">
					<option value="${d.typeId }">${d.typeName }</option>
				</c:forEach>
			</select>
		</div>
		<button>添加</button>
		</form>
	</div>
</body>
</html>