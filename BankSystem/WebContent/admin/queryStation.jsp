<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="banksystem?method=queryStation" method="post">
<table border="1">
<tr>
<td type="text" name="statid">岗位编号</td>
<td type="text" name="statname">岗位名称</td>
<td type="text" name="statnum">人数</td>
</tr>
<tr>
<c:forEach items="${list}" var="c">
<td>${c.statid}</td>
<td >${c.statname}</td>
<td >${c.statnum}</td>
</c:forEach>
</tr>
</table>
</form>
</body>
</html>