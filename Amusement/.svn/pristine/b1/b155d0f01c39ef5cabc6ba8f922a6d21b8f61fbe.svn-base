<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门管理</title>
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
	<form action="${pageContext.request.contextPath }/department/select.do" method="post" class="form-horizontal" role="form" id="myform">
			<table class="table">
				<h3 class="title1">部门管理</h3>
				<tr>
					<td>
						<div class="form-group">
			   				<label for="firstname" class="col-sm-6 control-label">部门名称</label>
			    			<div class="col-sm-6">
			     				 <input type="text" class="form-control" id="firstname" name="depName"
			     				 value="${Paging.map.depName }"
			     				 >
			    			</div>
			  			</div>
					</td>
					<td>
						<div class="form-group">
			   				<label for="firstname" class="col-sm-6 control-label">部门人数</label>
			    			<div class="col-sm-6">
			     				 <input type="text" class="form-control" id="firstname" name="depNumMin"
			     				 value="${Paging.map.depNumMin }"
			     				 >
			    			</div>
			  			</div>
					</td>
					<td>
						<div class="form-group">
			   				<label for="firstname" class="col-sm-6 control-label">—</label>
			    			<div class="col-sm-6">
			     				 <input type="text" class="form-control" id="firstname" name="depNumMax"
			     				 value="${Paging.map.depNumMax }"
			     				 >
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
			  <caption>部门管理</caption>
			  <thead>
			    <tr>
			      <th>编号</th>
			      <th>部门名称</th>
			      <th>部门人数</th>
			      <th>
			      	<a class="btn btn-default" href="${pageContext.request.contextPath }/department/addDepartment.jsp" role="button" >新增</a>
			      </th>
			    </tr>
			  </thead>
			  <tbody>
				<c:forEach items="${Paging.list }" var="dep">
					<tr class="success">
						<td>${dep.depId }</td>
						<td>${dep.depName }</td>
						<td>${dep.depNum }</td>
						<td>
							<a class="btn btn-default" href="${pageContext.request.contextPath }/department/updateById.do?depId=${dep.depId }" role="button" >修改</a>
							<a class="btn btn-default" href="${pageContext.request.contextPath }/department/deleteById.do?depId=${dep.depId }" role="button" >删除</a>
						</td>
					</tr>
				</c:forEach>
			  </tbody>
			</table> 
		<table>
			<tr>
				<td colspan="4">${Paging.nav }</td>
			</tr>
		</table>
	</form>
</body>
</html>