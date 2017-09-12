<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<%@ include file="../common/commoncss.jsp" %>
<%@ include file="../common/commonjs.jsp" %>
<script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
      $(function(){
    	  
    	  $(".pagination li a").click(function(){
    		  var page = $(this).attr("pagedata");//获取属性pagedata的值
    		  $("#myPage").val(page);//设置隐藏框的值
    		  $("#myform").submit();//表单提交
    	  });
      });
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/Salary/querySalary.do?select=one" method="post" class="form-horizontal" role="form" id="myform">
			<table class="table">
				<h3 class="title1">工资管理</h3>
				<tr>
					<td>
						<div class="form-group">
				    		<label for="lastname" class="col-sm-6 control-label">开始日期</label>
				    		<div class="col-sm-6">
					     	 <input type="text" class="form-control" id="firstname" name="beginTime" placeholder="请输入开始日期:yyyy-mm-dd" value="${paging.map.beginTime }">
				    		</div>
				  		</div> 
					</td>
					<td>
						<div class="form-group">
				    		<label for="lastname" class="col-sm-6 control-label">结束日期</label>
				    		<div class="col-sm-6">
				    			<input type="text" class="form-control" id="firstname" name="endTime" placeholder="请输入结束日期:yyyy-mm-dd" value="${paging.map.endTime }">
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
			  <caption></caption>
			  <thead>
			    <tr>
			      <th>编号</th>
			      <th>用户名</th>
			      <th>迟到早退次数</th>
			      <th>出勤次数</th>
			      <th>工资</th>
			      <th>日期</th>
			    </tr>
			  </thead>
			  <tbody>
				<c:forEach items="${paging.list }" var="us">
					<tr class="success">
						<td>${us.id }</td>
						<td>${us.user.userName }</td>
						<td>${us.unnormal }</td>
						<td>${us.normal }</td>
						<td>${us.monthMoney }</td>
						<td>${fn:substring(us.month,0,11) }</td>
					</tr>
				</c:forEach>
			  </tbody>
			</table> 
		<table>
			<tr>
				<td colspan="4">${paging.nav }</td>
			</tr>
		</table>
	</form>
</body>
</html>