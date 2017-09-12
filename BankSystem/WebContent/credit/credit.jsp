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
</head>
<body>
	<table>
		<tr>
			<td>存储卡号</td>
			<td>金额</td>
			<td>贷款时间</td>
			<td>还款时间</td>
			<td>剩余金额</td>
			<td>利率</td>
			<td>办理银行</td>
			<td>办理人员</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${page.list }" var="l">
		<tr>
			<td>${l.savings.savingsNum }</td>
			<td>${l.money }</td>
			<td>${page.getTimeToString(l.currentTime) }</td>
			<td>${page.getTimeToString(l.totalTime) }</td>
			<td>${l.surplusMoney }</td>
			<td>${l.interest.interest }</td>
			<td>${l.bank.bankName }</td>
			<td>${l.staff.staffName }</td>
			<td><a href="returnCredit.do?creditId=${l.creditId }">还款</a></td>
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