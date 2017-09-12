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
			var sexnum = ${department.bank.bankId };
			console.log(sexnum);
			$("select[name = 'banks'] option[value = '"+sexnum+"']").attr("selected",true);
		});
	});
</script>
</head>
<body>
<center>
		<form action="${pageContext.request.contextPath }/department/updateDepartment.do" method="post">
		<input type="hidden" name="depId" value="${department.depId }"/>
			<table>	
				<tr>
					<td>部门名称</td>
					<td>
						<input type="text" name="depName" value="${department.depName }"/>
					</td>	
				</tr>
				<tr>
					<td>部门人数</td>
					<td>
						<input type="text" name="depNum" value="${department.depNum }" />
					</td>
				</tr>
				<tr>
					<td>职能</td>
					<td>
						<input type="text" name="depFunc" value="${department.depFunc }" />
					</td>
				</tr>
				<tr>
					<td>银行地址</td>
					<td>
						<select name="bankId">
								<c:forEach items="${list }" var="c">
										<option value="${c.bankId }">${c.bankName }</option>
								</c:forEach>
						</select>
					</td>
				</tr>
			</table>
			<button type="submit">提交</button>
		</form>
	</center>
</body>
</html>