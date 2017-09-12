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
	<form id="myform" action="${pageContext.request.contextPath }/Savings/querySavings.do" method="post">
		<table>
			<tr>
				<td>
						<div class="form-group">
			   				 <label for="firstname" class="col-sm-6 control-label">卡号</label>
			    			<div class="col-sm-6">
			     				 <input type="text" class="form-control" id="firstname" name="savingsNum" placeholder="卡号">
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
					<td>储蓄卡序号</td>
					<td>卡号</td>
					<td>用户编号</td>
					<td>余额</td>
					<td>开户行编号</td>
					<td>员工</td>
					<td>状态</td>
					<td>利率</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${Paging.list }" var="c">
					<tr class="success">
						<td>${c.savingsId }</td>
						<td>${c.savingsNum }</td>
						<td>${c.user.username }</td>
						<td>${c.balance }</td>
						<td>${c.bank.bankName }</td>
						<td>${c.staff.staffName }</td>
						<td>${c.savState.savStat }</td>
						<td>${c.interest.interestName }</td>
						<td><a class="btn btn-default" href="${pageContext.request.contextPath }/Savings/sendLogin.do?savingsId=${c.savingsId }" role="button" data="${c.savingsId }">登录</a>
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