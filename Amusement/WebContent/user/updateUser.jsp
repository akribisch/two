<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册用户</title>
<%@ include file="../common/commoncss.jsp" %>
<%@ include file="../common/commonjs.jsp" %>
<script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
      $(function(){
    	  $("#save").click(function(){
    		  $("form").submit();
    	  });
    	  
    	  $("#selectSex").val("${upUser.sex }");
    	  $("#selectStatId").val("${upUser.station.statId }");
    	  $("#selectState").val("${upUser.state }");
    	  
      });
</script>
</head>
<body>
	<form class="form-horizontal" action="${pageContext.request.contextPath }/user/sendUpdateUser.do" method="post">
		<h3 class="title1">修改用户</h3>
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label">姓名:</label>
			<div class="col-sm-4">
				<input type="hidden" name="userId" class="form-control1" id="focusedinput" value="${upUser.userId }">
				<input type="text" name="userName" class="form-control1" id="focusedinput" value="${upUser.userName }">
			</div>
		</div>
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label">密码:</label>
			<div class="col-sm-4">
				<input type="text" name="password" class="form-control1" id="focusedinput" value="${upUser.password }">
			</div>
		</div>
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label">联系电话:</label>
			<div class="col-sm-4">
				<input type="text" name="phone" class="form-control1" id="focusedinput" value="${upUser.phone }">
			</div>
		</div>
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label">性别:</label>
			<div class="col-sm-4">
				<select id="selectSex" class="form-control" name="sex" >
					<option value="1">男</option>
					<option value="0">女</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label">出生日期:</label>
			<div class="col-sm-4">
				<input type="text" name="birthday" class="form-control1" id="focusedinput" value="${upUser.birthday }">
			</div>
		</div>
		<input type="hidden" name="oldStatId" value="${upUser.station.statId }">
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label">岗位:</label>
			<div class="col-sm-4">
				<select id="selectStatId" class="form-control" name="statId" >
					<c:forEach items="${StatList }" var="s">
						<option value="${s.statId }">${s.statName }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label">状态:</label>
			<div class="col-sm-4">
				<select id="selectState" class="form-control" name="state" >
					<option value="0">正常</option>
					<option value="1">禁用</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label"></label>
			<div class="col-sm-4">
				<a id="save" class="btn btn-default" href="javascript:void(0);" role="button" >确定</a>
				<a class="btn btn-default" href="${pageContext.request.contextPath }/user/select.do" role="button" >取消</a>
			</div>
		</div>
	</form>
</body>
</html>