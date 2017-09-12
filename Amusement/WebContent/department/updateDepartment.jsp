<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增部门</title>
<%@ include file="../common/commoncss.jsp" %>
<%@ include file="../common/commonjs.jsp" %>
<script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
      $(function(){
    	  $("#save").click(function(){
    		  $("form").submit();
    	  });
    	  
      });
</script>
</head>
<body>
	<form class="form-horizontal" action="${pageContext.request.contextPath }/department/sendUpdateDepartment.do" method="post">
		<h3 class="title1">新增部门</h3>
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label">部门名称</label>
			<div class="col-sm-4">
				<input type="hidden" name="depId" class="form-control1" id="focusedinput" value="${upDep.depId }">
				<input type="hidden" name="depNum" class="form-control1" id="focusedinput" value="${upDep.depNum }">
				<input type="text" name="depName" class="form-control1" id="focusedinput" value="${upDep.depName }">
			</div>
		</div>
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label"></label>
			<div class="col-sm-4">
				<a id="save" class="btn btn-default" href="javascript:void(0);" role="button" >确定</a>
			</div>
		</div>
	</form>
</body>
</html>