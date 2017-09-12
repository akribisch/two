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
		<form role="form" action="addSavState.do" method="post">
		  <div class="form-group">
		    <label for="name">账号状态</label>
		    <input name="savStat" type="text" class="form-control" id="savStat" placeholder="请输入账号状态" style="width: 300px">
		  </div>
		  
		  <button type="submit" class="btn btn-default">添加</button>
		</form>
</body>
</html>