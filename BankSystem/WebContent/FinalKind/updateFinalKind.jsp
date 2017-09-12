<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改利率记录</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/plugin/css/bootstrap.css">  
	<script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>
	<script src="${pageContext.request.contextPath }/plugin/js/bootstrap.js"></script>
	
</head>
<body>
	<div class="page-header">
    <h1>修改金融类型记录
       
    </h1>
</div>
	<form action="${pageContext.request.contextPath }/FinalKind/updateFinalKind.do" method="post" class="form-horizontal" role="form">
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">理财产品类型</label>
	    <div class="col-sm-6">
	    	<input type="hidden" name="fkId" value="${FinalKind.fkId }"/>
	      <input type="text" class="form-control" id="firstname" name="fkName" value="${FinalKind.fkName }">
	    </div>
	  </div>
	
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-default"><span class="label label-warning">确定修改</span></button>
	    </div>
	  </div>
	</form>
</body>
</html>