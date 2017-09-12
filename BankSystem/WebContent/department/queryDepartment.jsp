<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门信息</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/plugin/css/bootstrap.css">  
<script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath }/plugin/js/bootstrap.js"></script>
<script type="text/javascript">
	
	$(function(){
		<!-- 分页提交表单 -->
  	  $(".pagination li a").click(function(){
  		  var page = $(this).attr("pagedata");//获取属性pagedata的值
  		  $("#myPage").val(page);//设置隐藏框的值
  		  $("#myform").submit();//表单提交
  	  });
  	  
    });
</script>
</head>
<body>
	<form id="myform" action="${pageContext.request.contextPath }/department/queryDepartment.do" method="post">
		<table>
			<tr>
				<td>
						<div class="form-group">
			   				 <label for="firstname" class="col-sm-6 control-label">部门名称查询</label>
			    			<div class="col-sm-6">
			     				 <input type="text" class="form-control" id="firstname" name="depName" placeholder="部门名称">
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
			</tr>
		</table>
		<table class="table">
			<thead>
				<tr>
					<td>部门编号</td>
					<td>部门名称</td>
					<td>部门人数</td>
					<td>职能</td>
					<td>银行地址</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${Paging.list }" var="c">
					<tr class="success">
						<td>${c.depId }</td>
						<td>${c.depName }</td>
						<td>${c.depNum }</td>
						<td>${c.depFunc }</td>
						<td>${c.bank.bankName }</td>
						<td><a class="btn btn-default" href="${pageContext.request.contextPath }/department/sendAllDepartment.do?depId=${c.depId }" role="button" data="${c.depId }">修改</a>
	      				</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<table>
		<tr><td colspan="4">${Paging.nav }</td></tr>
		</table>	
	</form>
</body>
</html>