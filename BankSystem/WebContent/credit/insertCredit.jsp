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
<script type="text/javascript">
	$(function(){
		$("#detail").click(function(){
			var savingsNum=$("input[name='savingsNum']").val();
			var money=$("input[name='money']").val();
			var interestId= $("select").val();
			
			location.href="datailCredit.do?savingsNum="+savingsNum+"&money="+money+"&interestId="+interestId;
		})
	})
</script>
</head>
<body>
<form action="insertCredit.do" method="post">
	<div>
		存储卡号<input type="text" placeholder="输入卡号" name="savingsNum" value="${savingsNum }">
		贷款金额<input type="text" placeholder="输入贷款金额" name="money">
		<select name="interestId">
			<c:forEach items="${creditList }" var="in">
				<option value="${in.interestId }">${in.interestName }</option>
			</c:forEach>
		</select>
		<a href="javascript:void(0);" id="detail">明细</a>
		<c:if test="${list!=null }">
		<table>
			<tr>
				<td>月份</td>
				<td>还款金额</td>
			</tr>
			<c:forEach items="${list }" var="m">
				<tr>
					<td>${m.month }</td>
					<td>${m.money }</td>
				</tr>
			</c:forEach>
		</table>
		</c:if>
	</div>
	<button>购买</button>
</form>

</body>
</html>