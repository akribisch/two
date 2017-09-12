<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>流水修改</title>
<%@ include file="../common/commoncss.jsp" %>
<%@ include file="../common/commonjs.jsp" %>
</head>
<body>
<span style="color:red">银行流水修改</span>
<form action="">
储蓄卡号：
<input type="text" name="SavingsID" placeholder="请输入修改后的储蓄卡号">
业务类型：
<select name="serId">
	<option value="1">存款</option>
	<option value="2">取款</option>
	<option value="3">还款</option>
	<option value="4">贷款</option>
</select>
员工编号：
<input type="text" value="staffID" placeholder="请输入修改后的员工编号">

</form>
</body>
</html>