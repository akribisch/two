<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改娱乐项目信息</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/plugin/css/bootstrap.css">  
	<script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>
	<script src="${pageContext.request.contextPath }/plugin/js/bootstrap.js"></script>
	
</head>
<body>
	<div class="page-header">
    <h1>修改娱乐项目信息
     
    </h1>
</div><!-- localhost:8080/Amusement/VipLevel/updateVipLevel.jsp -->
	 <form action="${pageContext.request.contextPath }/Recreation/updateRecreation.do" method="post" class="form-horizontal" role="form">
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">娱乐项目名称</label>
	    <div class="col-sm-6">
	    	<input type="hidden" name="rno" value="${recreation.rno }"/>
	      <input type="text" class="form-control" id="firstname" name="rname" value="${recreation.rname }">
	    </div>
	  </div>
	   <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">地址</label>
	    <div class="col-sm-6">
	    
	      <input type="text" class="form-control" id="firstname" name="raddress" value="${recreation.raddress }">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">价格</label>
	    <div class="col-sm-6">

	      <input type="text" class="form-control" id="firstname" name="rpice" value="${recreation.rpice }">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="lastname" class="col-sm-2 control-label">简介</label>
	    <div class="col-sm-6">
	      <textarea class="form-control" name="rintroducion" value="${recreation.rintroducion }" placeholder="请输入简介" rows="3"></textarea>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="lastname" class="col-sm-2 control-label">注意事项</label>
	    <div class="col-sm-6">
	      <textarea class="form-control" name="rattention" value="${recreation.rattention }" placeholder="请输入注意事项" rows="3"></textarea>
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