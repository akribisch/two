<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工登陆</title>
<%@ include file="../common/commoncss.jsp" %>
<%@ include file="../common/commonjs.jsp" %>
<script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>
</head>
<body>
<div class="main-content">
    	<div id="page-wrapper" style="min-height: 243px;">
        	<div class="main-page login-page ">
				<div class="widget-shadow">
					<div class="login-top">
						<h1>欢迎进入银行管理系统</h1>
					</div>
					<div class="login-body">
						<form id="myForm" action="${pageContext.request.contextPath }/Savings/login.do" method="post">
							<input type="text"  class="user" name="savingsNum" value="${savingsNum }" placeholder="输入卡号">
							<input type="password"  name="password" class="lock" placeholder="输入密码">
							<div id="v_container" style="width: 200px;height: 50px;"></div>
							<p id="SignInFlagPrompt"></p>
							<input type="submit" value="登录">
						</form>
					</div>
					<div class="login-body">
						
					</div>
				</div>
			</div>	
		</div>
	</div>
</body>
</html>