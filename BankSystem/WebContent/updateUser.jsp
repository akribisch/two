<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath }/plugin/js/bootstrap.js"></script>
<script type="text/javascript">
	$(function(){
		$(function() {
			var sexnum = ${user.sex};
			console.log(sexnum);
			$("select[name = 'sex'] option[value = '"+sexnum+"']").attr("selected",true);
		});
	});
</script>
</head>
<body>
<center>
		<form action="updateUser.do" method="post">
		<input type="hidden" name="userId" value="${user.userId }"/>	
			<table>	
				<tr>
					<td>用户名</td>
					<td>
						<input type="text" name="username" value="${user.username }"/>
					</td>	
				</tr>
				<tr>
					<td>手机号</td>
					<td>
						<input type="text" name="uphone" value="${user.uphone }" />
					</td>
				</tr>
				<tr>
					<td>身份证</td>
					<td>
						<input type="text" name="uidcard" value="${user.uidcard }" />
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
						<input type="text" name="birthday" value="${user.birthday }" />
					</td>
				</tr>
			</table>
			<button type="submit">提交</button>
		</form>
	</center>
</body>
</html>