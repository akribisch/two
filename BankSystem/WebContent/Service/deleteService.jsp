<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除业务类型</title>
<%@ include file="../common/commoncss.jsp" %>
<%@ include file="../common/commonjs.jsp" %>
<script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>

</head>
<body>
<h3 class="title1">删除业务类型</h3>
<form action="deleteService.do" method="post">
	<div class="input-group">
		<span class="input-group-addon" style="width: 150px ;height: 34px;" id="basic-addon1">业务类型编号：</span>
		<input class="form-control" style="width: 500px ;height: 34px; type="text" name="serId" placeholder="请输入需要删除的业务类型编号">
	</div>
	<div class="btn-group" style="life:100px" role="group" aria-label="...">
		<input class="btn btn-default" type="submit"  value="提交">
	</div>
</form>
</body>
</html>