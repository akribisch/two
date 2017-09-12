<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/plugin/css/bootstrap.css">  
	<script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>
	<script src="${pageContext.request.contextPath }/plugin/js/bootstrap.js"></script>
	<script type="text/javascript">
	
	$(function(){
		$("li").click(function(){
			$("li.active").removeClass("active");
			$(this).addClass("active");
		});
		
		$("tr").hover(function(){
			$("tbody tr").prop("class","success");
			$(this).prop("class","active");
			
		});
	});
	$(function(){
		$("li a").click(function(){
			var page=$(this).attr("pagedata");
			window.location.href="queryUser.do?currentPage="+page;
		})
		
	});
</script>
</head>
<body>
		<form action="queryUser.do" method="post" class="form-horizontal" role="form">
			<table>
				<tr>
					<td>
						<div class="form-group">
			   				 <label for="firstname" class="col-sm-6 control-label">手机号</label>
			    			<div class="col-sm-6">
			     				 <input type="text" class="form-control" id="firstname" name="uphone" placeholder="请输入手机号">
			    			</div>
			  			</div>
					
					</td>
				
				<td>
					<div class="form-group">
			    		<label for="lastname" class="col-sm-6 control-label">身份证</label>
			    		<div class="col-sm-6">
			     		 <input type="text" class="form-control" id="lastname" name="uidcard" placeholder="请输入身份证">
			    		</div>
			  		</div>
				</td>
				<td>
					<div class="form-group">
			   			 <div class="col-sm-offset-2 col-sm-10">
			      			<button type="submit" class="btn btn-default">查询</button>
			   			 </div>
			 		 </div>
				</td>
			
			</table>
			  
		</form>
	<table class="table">
	  <caption>用户信息表</caption>
	  <thead>
	    <tr>
	      <th>用户编号</th>
	      <th>用户名</th>
	      <th>手机号</th>
	      <th>身份证</th>
	      <th>性别</th>
	      <th>出生日期</th>
	      <th>操作</th>
	     </tr>
	  </thead>
	  <tbody>
	 	 <c:forEach items="${page.list}" var="c">
			
			<tr class="success">
	      		<td>${c.userId }</td>
	     	 	<td>${c.username }</td>
	      		<td>${c.uphone }</td>
	      		<td>${c.uidcard }</td>
	      		<td>${c.sex == 1 ? "男" : "女" }</td>
	      		<td>${c.birthday }</td>
	      		<td><a class="btn btn-default" href="sendAllUser.do?userId=${c.userId }" role="button" data="${c.userId }">修改</a>
	      		<a class="btn btn-default" href="javascript:void(0);" role="button" data="${c.userId }">删除</a></td>
	      	</tr>
		</c:forEach>
	  </tbody>
	</table>
	<table>
		<tr><td colspan="4">${page.nav }</td></tr>
	</table>

</body>
</html>