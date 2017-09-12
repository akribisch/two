<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>车库</title>
<%@ include file="../common/commoncss.jsp" %>
<%@ include file="../common/commonjs.jsp" %>
<script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>
</head>
<body>
<h3 class="title1">收费</h3>
<form action="${pageContext.request.contextPath }/car/selectMoner.do" method="post">
	<div class="input-group">
		<span class="input-group-addon" style="width: 100px ;height: 34px;" id="basic-addon1">车牌号：</span>
		<input class="form-control" style="width: 100px ;height: 34px;" type="text" name="plateNumber" placeholder="车牌号" value="${car.plateNumber }">
	</div>
	<div class="btn-group" style="life:100px" role="group" aria-label="...">
		<input class="btn btn-default" type="submit"  value="查看费用">
	</div>
</form>
<div class="input-group">
		<span class="input-group-addon" style="width: 100px ;height: 34px;" id="basic-addon1">费用：</span>
		<input class="form-control" style="width: 100px ;height: 34px;" type="text" readonly="readonly"  value="${charge.moneyPay }元">
</div>
<div class="input-group">
		<span class="input-group-addon" style="width: 100px ;height: 34px;" id="basic-addon1">进入时间：</span>
		<input class="form-control" style="width: 300px ;height: 34px;" type="text" readonly="readonly"  value="${car.carIn }">
</div>

<div class="input-group">
		<span class="input-group-addon" style="width: 100px ;height: 34px;" id="basic-addon1">离开时间：</span>
		<input class="form-control" style="width: 300px ;height: 34px;" type="text" readonly="readonly"  value="${car.carOut }">
</div>
<img alt="666" src="../carImg/lsls.jpg">
<h3 class="title1">车辆信息</h3>
<a class="btn btn-default" href="${pageContext.request.contextPath }/car/select.do" role="button">查看所有车辆信息</a>
<a class="btn btn-default" href="${pageContext.request.contextPath }/car/insert.jsp" role="button">停车</a>
<a class="btn btn-default" href="${pageContext.request.contextPath }/charge/select.do" role="button">收费信息</a>
</body>
</html>