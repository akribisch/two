<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加娱乐vip卡</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/plugin/css/bootstrap.css">  
	<script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>
	<script src="${pageContext.request.contextPath }/plugin/js/bootstrap.js"></script>
	
	
</head>
<body>

<!-- localhost:8080/Amusement/Vip/addVip.jsp -->
	<form action="${pageContext.request.contextPath }/Vip/addVip.do" method="post" class="form-horizontal" role="form">
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">卡号</label>
	    <div class="col-sm-6">
	      <input type="text" class="form-control" id="firstname" name="vNo" placeholder="请输入卡号">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="lastname" class="col-sm-2 control-label">卡级别</label>
	    <div class="col-sm-6">
	      <select class="form-control" name="levelId">
			<option selected="selected" value="0">选择卡级别</option>
		      <c:forEach items="${list }" var="level">
		      	 <option  value="${level.levelId }">${level.level }</option>
		      </c:forEach>
   			</select>
	    </div>
	  </div>
	  
	  <div class="form-group">
	    <label for="lastname" class="col-sm-2 control-label">剩余次数</label>
	    <div class="col-sm-6">
	      <input type="text" class="form-control" id="lastname" name="vCount" placeholder="请输入剩余次数">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="lastname" class="col-sm-2 control-label">总次数</label>
	    <div class="col-sm-6">
	     <input type="text" class="form-control" id="lastname" name="vWholenumber" placeholder="请输入总次数">
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