<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
		<form action="Userlogin.do" method="post">
			<table>
				<tr>
					<td colspan="2" align="center">用户登录</td>
				</tr>
				<tr>
					<td>用户名</td>
					<td>
						<input type="text" name="phone" />
					</td>
				</tr>
				<tr>
					<td>密码</td>
					<td>
						<input type="password" name="pwd" />
					</td>
				</tr>
			</table>
			<button type="submit">登录</button>
			<a href="addUser.jsp">注册</a>
		</form>
		</center>
</body>
</html>