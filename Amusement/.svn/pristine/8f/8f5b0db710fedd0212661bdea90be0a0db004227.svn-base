<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>上班时间:</td>
			<td>下班时间:</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list }" var="c">
		<tr>
			<td>${fn:substring(c.start,11,19) }</td>
			<td>${fn:substring(c.end,11,19) }</td>
			<td>
			<a href="sendupdateWorkTime.do?wid=${c.wid }">修改工作时间</a>
			</td>
		</tr>
		</c:forEach>
		
	</table>
</body>
</html>