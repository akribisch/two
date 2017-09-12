<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/plugin/css/bootstrap.css">  
	<script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>
	<script src="${pageContext.request.contextPath }/plugin/js/bootstrap.js"></script>
	
	
</head>
<body>


	<form action="addInterest.do" method="post" class="form-horizontal" role="form">
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">利率种类</label>
	    <div class="col-sm-6">
	      <input type="text" class="form-control" id="firstname" name="interestName" placeholder="请输入利率种类">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="lastname" class="col-sm-2 control-label">利率值</label>
	    <div class="col-sm-6">
	      <input type="text" class="form-control" id="lastname" name="interest" placeholder="请输入利率值"  >
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="lastname" class="col-sm-2 control-label">计息周期(月)</label>
	    <div class="col-sm-6">
	      <input type="text" class="form-control" id="lastname" name="interestCycle" placeholder="请输入计息周期">
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