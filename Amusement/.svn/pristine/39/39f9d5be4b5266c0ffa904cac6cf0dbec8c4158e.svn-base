<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收费记录</title>
<%@ include file="../common/commoncss.jsp" %>
<%@ include file="../common/commonjs.jsp" %>
<script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>
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
<div>
		<table class="table">
			<tr>
				<td>收费编号</td>
				<td>车牌号</td>
				<td>停车时间</td>
				<td>费用</td>
<%-- 				<td>操作<a class="btn btn-default" href="${pageContext.request.contextPath }/car/insert.jsp" role="button">新增</a></td>
 --%>			</tr>
			<c:forEach items="${pageing.list }" var="d">
				<tr>
					<td>${d.cwno }</td>
					<td>${d.car.plateNumber }</td>
					<td>${d.carTime == 0 ? "正在停车" : d.carTime}</td>
					<td>${d.moneyPay == 0 ? "正在停车" : d.moneyPay}</td>
					<%-- <td>
						<a class="btn btn-default" href="${pageContext.request.contextPath }/car/update.jsp" role="button">修改</a>
						<a class="btn btn-default" href="${pageContext.request.contextPath }/car/delete.do?carId=${d.carId }" role="button">删除</a>
					</td> --%>
				</tr>
			</c:forEach>
		</table>
		<form action="select.do" method="post" id="myform">
			<div class="panel-body">
		            ${pageing.nav }
		      </div>
       </form>
	</div>
	<a class="btn btn-default" href="${pageContext.request.contextPath }/car/garage.jsp" role="button">主页</a>
</body>
</html>