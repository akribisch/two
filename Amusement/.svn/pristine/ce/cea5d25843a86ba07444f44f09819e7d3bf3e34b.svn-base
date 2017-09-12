<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改车辆信息</title>

<%@ include file="../common/commoncss.jsp" %>
<%@ include file="../common/commonjs.jsp" %>
<script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>

</head>
<body>
<h3 class="title1">修改车辆信息</h3>
<form action="update.do" method="post">
	<div class="input-group">
		<input class="form-control" style="width: 500px ;height: 34px;" type="hidden" name="carId" placeholder=${car1.carId}>
	</div>
	<div class="input-group">
		<span class="input-group-addon" style="width: 150px ;height: 34px;" id="basic-addon1">车牌号：</span>
		<input class="form-control" style="width: 500px ;height: 34px;" type="text" name="plateNumber" placeholder="${car1.plateNumber}">
	</div>
	<div class="input-group">
		<span class="input-group-addon" style="width: 150px ;height: 34px;" id="basic-addon1">颜色：</span>
		<input class="form-control" style="width: 500px ;height: 34px;" type="text" name="color" placeholder="${car1.color}">
	</div>
	<div class="input-group">
		<span class="input-group-addon" style="width: 150px ;height: 34px;" id="basic-addon1">在位情况：</span>
		<select id="selectService" class="form-control" name="carAt">
					<option value="0">正在使用</option>
					<option value="1">空闲</option>
		</select>
	</div>
	<div class="input-group">
		<span class="input-group-addon" style="width: 150px ;height: 34px;" id="basic-addon1">进入时间：</span>
		<input class="form-control" style="width: 500px ;height: 34px;" type="text" name="carIn" placeholder="${car1.carIn}">
	</div>
	<div class="input-group">
		<span class="input-group-addon" style="width: 150px ;height: 34px;" id="basic-addon1">离开时间：</span>
		<input class="form-control" style="width: 500px ;height: 34px;" type="${car.carOut !=null ? text : hidden} " name="carOut" placeholder="${car1.carOut}">
	</div>
	<div class="btn-group" style="life:100px" role="group" aria-label="...">
		<input class="btn btn-default" type="submit"  value="提交">
	</div>
</form>
</body>
</html>