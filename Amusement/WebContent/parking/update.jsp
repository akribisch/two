<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h3 class="title1">修改车位信息</h3>
<form action="update.do" method="post">
	<div class="input-group">
		<span class="input-group-addon" style="width: 150px ;height: 34px;" id="basic-addon1">车位编号：</span>
		<input class="form-control" style="width: 500px ;height: 34px;" type="text" name="cwno"  placeholder="车位编号">
	</div>
	<div class="input-group">
		<span class="input-group-addon" style="width: 150px ;height: 34px;" id="basic-addon1">车位类型：</span>
		<input class="form-control" style="width: 500px ;height: 34px;" type="text" name="cwType" placeholder="车位类型">
	</div>
	<div class="input-group">
		<span class="input-group-addon" style="width: 150px ;height: 34px;" id="basic-addon1">车牌号码：</span>
		<input class="form-control" style="width: 500px ;height: 34px;" type="text" name="plateNumber" placeholder="车牌号码">
	</div>
	<div class="input-group">
		<span class="input-group-addon" style="width: 150px ;height: 34px;" id="basic-addon1">颜色：</span>
		<input class="form-control" style="width: 500px ;height: 34px;" type="text" name="color" placeholder="颜色">
	</div>
	<div class="input-group">
		<span class="input-group-addon" style="width: 150px ;height: 34px;" id="basic-addon1">车主姓名：</span>
		<input class="form-control" style="width: 500px ;height: 34px;" type="text" name="userName" placeholder="车主姓名">
	</div>
	<div class="input-group">
		<span class="input-group-addon" style="width: 150px ;height: 34px;" id="basic-addon1">余额：</span>
		<input class="form-control" style="width: 500px ;height: 34px;" type="text" name="carMons" placeholder="余额">
	</div>
	<div class="btn-group" style="life:100px" role="group" aria-label="...">
		<input class="btn btn-default" type="submit"  value="提交">
	</div>
</form>
</body>
</html>