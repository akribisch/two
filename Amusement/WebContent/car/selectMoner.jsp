<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../common/commoncss.jsp" %>
<%@ include file="../common/commonjs.jsp" %>
<script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath }/car/selectMoner.do?plateNumber=${car.plateNumber }" method="post">
	<div class="input-group">
		<span class="input-group-addon" style="width: 150px ;height: 34px;" id="basic-addon1">车牌号：</span>
		<input class="form-control" style="width: 500px ;height: 34px;" type="hidden" name="carAt" value="1" >
	</div>
	<div class="input-group">
		<span class="input-group-addon" style="width: 150px ;height: 34px;" id="basic-addon1">车牌号：</span>
		<input class="form-control" style="width: 500px ;height: 34px;" readonly="readonly" type="text"  value="￥${car.plateNumber }" >
	</div>
	<div class="btn-group" style="life:100px" role="group" aria-label="...">
		<input class="btn btn-default" type="submit"  value="确认收款">
	</div>
</form>
</body>
</html>