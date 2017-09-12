<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<%@ include file="../common/commoncss.jsp" %>
<%@ include file="../common/commonjs.jsp" %>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	  $("li a").click(function(){
		  var page = $(this).attr("pagedata");//获取属性pdata的值
		  $("#myPage").val(page);
		  
		  $("#myform").submit();
		  
	  });
});  		
 </script>
<body>
	<table>
		<tr>
			<td>编号</td>
			<td>货币</td>
			<td>汇率</td>
		</tr>
		<c:forEach items="${page.list }" var="l">
			<tr>
			<td>${l.rateId }</td>
			<td>${l.coin }</td>
			<td>${l.rate }</td>
		</tr>
		</c:forEach>
		
	</table>
	<form action="query.do" method="post" id="myform">
	<div class="panel-body">
             ${page.nav }
       </div>
       </form>
</body>
</html>