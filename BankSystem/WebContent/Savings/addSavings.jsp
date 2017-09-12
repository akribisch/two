<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册用户和储蓄卡信息</title>
<%@ include file="../common/commoncss.jsp" %>
<%@ include file="../common/commonjs.jsp" %>
<script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>
</head>
<body>
<div class="main-content">
    	<div id="page-wrapper" style="min-height: 100px;">
        	<div class="main-page login-page ">
				<div class="widget-shadow">
					<div class="login-top">
						<h3>注册用户和储蓄卡信息</h3>
					</div>
					<div class="login-body">
						<form action="${pageContext.request.contextPath }/Savings/addSavings.do" method="post">
						<table>
						<tr>
							<td>用户名</td>
							<td>
								<input type="text" name="username"/>
							</td>
						</tr>
							<tr>
								<td>手机号</td>
								<td>
									<input type="text" name="uphone" />
								</td>
							</tr>
							<tr>
								<td>身份证</td>
								<td>
									<input type="text" name="uidcard" />
								</td>
							</tr>
							<tr>
								<td>性别</td>
								<td>
									<select name="sex">
										<option value="1">男</option>
										<option value="0">女</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>出生日期</td>
								<td>
									<input type="text" name="birthday" />
								</td>
							</tr>
							<tr>
								<td>卡号</td>
								<td>
									<input type="text" name="savingsNum"/>
								</td>	
							</tr>
							<tr>
								<td>密码</td>
								<td>
									<input type="password" name="password" />
								</td>
							</tr>
							<tr>
								<td>利率种类</td>
								<td>
									<select name="interestName">
										<option value="活期">活期</option>
										<option value="定期">定期</option>
									</select>
								</td>
							</tr>
						</table>
						<button type="submit">提交</button>
					</form>
					</div>
				</div>
			</div>	
		</div>
	</div>
		

</body>
</html>