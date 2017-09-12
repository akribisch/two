<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询VIP卡级别</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/plugin/css/bootstrap.css">  
	<script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>
	<script src="${pageContext.request.contextPath }/plugin/js/bootstrap.js"></script>
	<script type="text/javascript">
	
	$(function(){
		$(function(){
			  $("li a").click(function(){
				  var page = $(this).attr("pagedata");//获取属性pdata的值
				  $("#myPage").val(page);
				  
				  $("#myform").submit();
				  
			  });//导航条提交数据
		}); 
		$("li").click(function(){
			$("li .active").removeClass("active");
			$(this).addClass("active");
		});//导航条选中样式
		
		$("tr").hover(function(){
			$("tbody tr").prop("class","success");
			$(this).prop("class","active");
			
		});//添加表格选中样式
	});
	
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/Recreation/queryRecreation.do" method="post" class="form-horizontal" role="form" id="myform">
			
				
	<table class="table">
	  <caption><h2>VIP卡级别表</h2><div style="margin-left: 1110px"><a class="btn btn-default" href="${pageContext.request.contextPath }/VipLevel/queryVipLevelToAdd.do" role="button" >添加</a></div></caption>
	  <thead>
	    <tr>
	      <th>卡级别编号</th>
	      <th>VIP卡级别</th>
	      <th>VIP卡总价（元）</th>
	      <th>有效时间（月）</th>
	      <th>操作</th>
	     </tr>
	  </thead>
	  <tbody>
	 	 <c:forEach items="${list}" var="level">
			
			<tr class="success">
	      		<td>${level.levelId }</td>
	     	 	<td>${level.level }</td>
	      		<td>${level.cPrice }</td>
	      		<td>${level.validDate }</td>
	      		<td><a class="btn btn-default" href="${pageContext.request.contextPath }/VipLevel/sendUpdateVipLevel.do?levelId=${level.levelId }" role="button" >修改</a>
	      		</td>
	      	</tr>
				
		</c:forEach>
	    
	  </tbody>
	</table> 
	<table>
		
		<tr><td colspan="4">${nav }</td></tr>
	</table>
	</form>
</body>
</html>