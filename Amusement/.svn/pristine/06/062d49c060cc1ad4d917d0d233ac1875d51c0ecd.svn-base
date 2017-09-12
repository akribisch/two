<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改游客</title>
<%@ include file="../common/commoncss.jsp" %>
<%@ include file="../common/commonjs.jsp" %>
</head>
<body>
<div>
	<form action="updateTourist.do" method="post">
	<input type="hidden" value="${tourist.touId }" name="touId">
		<div>
			游客账户:<input type="text" name="tourCount" value="${tourist.tourCount }">
		</div>
		<div>
			游客名称:<input type="text" name="tourName" value="${tourist.tourName }">
		</div>
		<div>
		
			<input type="radio" value="0" name="tourSex" <c:if test="${tourist.tourSex==0 }">checked="checked"</c:if>>男
			<input type="radio" value="1" name="tourSex" <c:if test="${tourist.tourSex==1 }">checked="checked"</c:if>>女
		</div>
		<div>
			游客电话:<input type="text" name="tourPhone" value="${tourist.tourPhone }">
		</div>
		<div>
			游客电子邮箱:<input type="text" name="tourEmail" value="${tourist.tourEmail }">
		</div>
		<button>修改</button>
		</form>
	</div>
</body>
</html>