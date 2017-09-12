<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<form action="${pageContext.request.contextPath }/menu/selectMenu.do" method="post" class="form-horizontal" role="form" id="myform">
			<table class="table">
				<h3 class="title1">菜单管理</h3>
				<tr>
					<td>
						<div class="form-group">
			   				<label for="firstname" class="col-sm-6 control-label">菜单名</label>
			    			<div class="col-sm-6">
			     				 <input type="text" class="form-control" id="firstname" name="menuName" placeholder="请输入菜单名"
			     				 value="${Paging.map.menuName }"
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
			  <thead>
			    <tr>
			      <th>菜单编号</th>
			      <th>菜单名称</th>
			      <th>菜单地址</th>
			      <th>父级菜单编号</th>
			      <th>
			      	<a class="btn btn-default" href="${pageContext.request.contextPath }/menu/addMenu.do" role="button" >新增</a>
			      </th>
			    </tr>
			  </thead>
			  <tbody>
				<c:forEach items="${Paging.list }" var="m">
					<tr class="success">
						<td>${m.menuId }</td>
						<td>${m.menuName }</td>
						<td>${m.menuUrl }</td>
						<td>${m.parentInt }</td>
						<td>
							<a class="btn btn-default" href="${pageContext.request.contextPath }/menu/updateById.do?menuId=${m.menuId }" role="button" >修改</a>
							<a class="btn btn-default" href="${pageContext.request.contextPath }/menu/deleteById.do?menuId=${m.menuId }" role="button" >删除</a>
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