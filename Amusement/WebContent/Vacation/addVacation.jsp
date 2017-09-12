<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加优惠活动</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/plugin/css/bootstrap.css">  
	<script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>
	<script src="${pageContext.request.contextPath }/plugin/js/bootstrap.js"></script>
	
</head>
<body>
	<form action="${pageContext.request.contextPath }/Vacation/addVacation.do" method="post" class="form-horizontal" role="form">
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">活动名称</label>
	    <div class="col-sm-6">
	      <input type="text" class="form-control" id="firstname" name="activeName" placeholder="请输入活动名称">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="lastname" class="col-sm-2 control-label">活动项目</label>
	    <div class="col-sm-6">
	      <select name="recreationId">
	      	<c:forEach items="${list }" var="recreation">
	      		<option value="${recreation.rno }">${recreation.rname }</option>
	      	</c:forEach>
	      </select>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="lastname" class="col-sm-2 control-label">折扣</label>
	    <div class="col-sm-6">
	      <input type="text" class="form-control" id="lastname" name="discount" placeholder="请输入折扣">
	    </div>
	  </div>
	 
	 
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-default">添加</button>
	    </div>
	  </div>
	</form>
	
</body>
</html>