<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加游玩信息</title>
</head>
<body>
	<div>
	<form action="addPlayGame.do" method="post">
		<div>
			游客:<input type="text" name="tourCount">
		</div>
		<div>
			项目名称：<select name="rno">
				<c:forEach items="${list }" var="d">
					<option value="${d.rno }">${d.rname }</option>
				</c:forEach>
			</select>
		</div>
		<div>
			游玩价格:<input type="text" name="playPrice">
		</div>
		<button>添加</button>
		</form>
	</div>
</body>
</html>