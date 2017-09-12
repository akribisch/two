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
		<form action="select.do" method="post" id="myform">
		<div>
			车牌号:<input type="text" name="plateNumber">
			进入时间:<input type="text" name="deviceName">
			离开时间：<input type="text" name="carOut">
			<button>查询</button>
			
		</div>
<div>


		<table class="table">
			<tr>
				<td>车牌号</td>
				<td>颜色</td>
				<td>在位情况</td>
				<td>进入时间</td>
				<td>离开时间</td>
				<td><a class="btn btn-default" href="${pageContext.request.contextPath }/car/insert.jsp" role="button">新增</a></td>
			</tr>
			<c:forEach items="${pageing.list }" var="d">
				<tr>
					<td>${d.plateNumber }</td>
					<td>${d.color }</td>
					<td>${d.carAt == 0 ? "正在使用" : "离开"}</td>
					<td>${d.carIn }</td>
					<td>${d.carOut == null ? "在位" : d.carOut} </td>
					<%-- <td>
						<a class="btn btn-default" href="${pageContext.request.contextPath }/car/sendCarId.do?carId=${d.carId }" role="button">修改</a>
						<a class="btn btn-default" href="${pageContext.request.contextPath }/car/delete.do?carId=${d.carId }" role="button">删除</a>
					</td> --%>
				</tr>
			</c:forEach>
		</table>
			<div class="panel-body">
		            ${pageing.nav }
		      </div>
       </form>
	</div>
	<a class="btn btn-default" href="${pageContext.request.contextPath }/car/garage.jsp" role="button">主页</a>
</body>
</html>