<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加VIP卡级别</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/plugin/css/bootstrap.css">  
	<script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>
	<script src="${pageContext.request.contextPath }/plugin/js/bootstrap.js"></script>
	
</head>
<body>
	<!-- localhost:8080/Amusement/VipLevel/addVipLevel.jsp -->
	
	<form action="${pageContext.request.contextPath }/VipLevel/addVipLevel.do" method="post" class="form-horizontal" role="form">
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">VIP卡级别</label>
	    <div class="col-sm-6">
	      <input type="text" class="form-control" id="firstname" name="level" placeholder="请输入VIP卡级别">
	    </div>
	  </div>
	 <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">VIP卡总价（元）</label>
	    <div class="col-sm-6">
	      <input type="text" class="form-control" id="firstname" name="cPrice" placeholder="请输入VIP卡总价">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">有效时间（月）</label>
	    <div class="col-sm-6">
	      <input type="text" class="form-control" id="firstname" name="validDate" placeholder="请输入有效时间">
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