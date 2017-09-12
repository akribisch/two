<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加</title>
<%@ include file="../common/commoncss.jsp" %>
<%@ include file="../common/commonjs.jsp" %>
<script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
$(function(){
	  <!-- 提交表单  -->
	  $("#save").click(function(){
		  $("form").submit();
	  });
	  
});
</script>
</head>
<body>
	<form class="form-horizontal" action="addUser.do" method="post">
		<h3 class="title1">用户注册</h3>
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label">用户名:</label>
			<div class="col-sm-4">
					<input type="text" name="username" class="form-control1" id="focusedinput" placeholder="用户名">
			</div>
		</div>
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label">手机号:</label>
			<div class="col-sm-4">
				<input type="text" name="uphone" class="form-control1" id="focusedinput" placeholder="手机号">
			</div>
		</div>
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label">身份证:</label>
			<div class="col-sm-4">
				<input type="text" name="uidcard" class="form-control1" id="focusedinput" placeholder="身份证">
			</div>
		</div>
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label">性别:</label>
			<div class="col-sm-4">
				<select id="selectService" class="form-control" name="sex" >
					<option value="1">男</option>
					<option value="2">女</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label">出生日期:</label>
			<div class="col-sm-4">
				<input type="text" name="birthday" class="form-control1" id="focusedinput" placeholder="出生日期">
			</div>
		</div>
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label"></label>
			<div class="col-sm-4">
				<a id="save" class="btn btn-default" href="javascript:void(0);" role="button" >确定</a>
				<a id="cancel" class="btn btn-default" href="${pageContext.request.contextPath }/Savings/querySavings.do" role="button" >取消</a>
			</div>
		</div>
	</form>
</body>
</html>