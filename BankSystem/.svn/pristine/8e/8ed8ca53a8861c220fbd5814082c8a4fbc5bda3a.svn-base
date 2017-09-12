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
    	  <!-- 返回首页  -->
    	  $("#cancel").click(function(){
    		  location.href="http://localhost:8080/BankSystem/bank/selectBank.do";
    	  });
      });
</script>
</head>
<body>
	<form class="form-horizontal" action="${pageContext.request.contextPath }/bank/sendUpdateBank.do" method="post">
		<h3 class="title1">修改银行地址</h3>
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label">银行地址名:</label>
			<div class="col-sm-4">
				<input type="text" name="bankId" value="${bank.bankId }"/>
				<input type="text" name="bankName" class="form-control1" id="focusedinput" value="${bank.bankName }">
			</div>
		</div>
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label"></label>
			<div class="col-sm-4">
				<a id="save" class="btn btn-default" href="javascript:void(0);" role="button" >确定</a>
				<a id="cancel" class="btn btn-default" href="javascript:void(0);" role="button" >取消</a>
			</div>
		</div>
	</form>
</body>
</html>