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
	<form action="findStation.do" method="post">
	<div>
		岗位名称：<input type="text" placeholder="请输入岗位名称" name="statName" value="${map.statName }">
		人数：<input type="text" name="minNum" value="${map.minNum }">
		-<input type="text" name="maxNum" value="${map.maxNum }">
		部门：<select name="depId">
		
			<option value="0">--请选择--</option>
			<c:forEach items="${deplist }" var="d">
				<option value="${d.depId }" <c:if test="${d.depId==map.depId }">selected="selected"</c:if>>${d.depName }</option>
			</c:forEach>
		</select>
		银行：<select name="bankId">
			<option value="0">--请选择--</option>
			<c:forEach items="${banklist }" var="b">
				<option value="${b.bankId }" <c:if test="${b.bankId==map.bankId }">selected="selected"</c:if>>${b.bankName }</option>
			</c:forEach>
		</select>
		<button>查询</button>
	</div>
	</form>
	<table>
		<tr>
			<td>岗位编号</td>
			<td>岗位名称</td>
			<td>部门名称</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${page.list }" var="s">
		<tr>
			<td>${s.statNum }</td>
			<td>${s.statName }</td>
			<td>${s.department.depName }</td>
			<td>
			<a href="${pageContext.request.contextPath }/menu/queryMenu.do?statId=${s.statId }">分配权限</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	<form action="findStation.do" method="post" id="myform">
	<div class="panel-body">
		${page.nav }
	</div>
	</form>
</body>
</html>