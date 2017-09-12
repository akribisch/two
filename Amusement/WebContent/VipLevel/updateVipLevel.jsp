<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改VIP卡级别</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/plugin/css/bootstrap.css">  
	<script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>
	<script src="${pageContext.request.contextPath }/plugin/js/bootstrap.js"></script>
	
</head>
<body>
	<div class="page-header">
    <h1>修改VIP卡级别
     
    </h1>
</div><!-- localhost:8080/Amusement/VipLevel/updateVipLevel.jsp -->
	 <form action="${pageContext.request.contextPath }/VipLevel/updateVipLevel.do" method="post" class="form-horizontal" role="form">
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">卡级别</label>
	    <div class="col-sm-6">
	    	<input type="hidden" name="levelId" value="${vipLevel.levelId }"/>
	      <input type="text" class="form-control" id="firstname" name="level" value="${vipLevel.level }">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">总价（元）</label>
	    <div class="col-sm-6">
	    	
	      <input type="text" class="form-control" id="firstname" name="cPrice" value="${vipLevel.cPrice }">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">有效时间（月）</label>
	    <div class="col-sm-6">
	    	
	      <input type="text" class="form-control" id="firstname" name="validDate" value="${vipLevel.validDate }">
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-default">确定修改</button>
	    </div>
	  </div>
	</form>
</body>
</html>