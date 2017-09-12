<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<form class="form-horizontal" action="${pageContext.request.contextPath }/Access/sendaddAccess.do" method="post">
		<h3 class="title1">业务</h3>
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label">业务类型:</label>
			
			<div class="col-sm-4">
				<select id="selectService" class="form-control" name="serId" >
					<c:forEach items="${list }" var="ser">
						<option value="${ser.serId }">${ser.serName }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label">储蓄卡编号:</label>
			<div class="col-sm-4">
				<input type="hidden" name="savingsId" class="form-control1" id="focusedinput" value="${savingsId }">
				<input type="text" name="savingsNum" class="form-control1" id="focusedinput" value="${savingsNum }">
			</div>
		</div>
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label">金额:</label>
			<div class="col-sm-4">
				<input type="text" name="money" class="form-control1" id="focusedinput" placeholder="金额">
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