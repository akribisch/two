<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改菜单</title>
<%@ include file="../common/commoncss.jsp" %>
<%@ include file="../common/commonjs.jsp" %>
<script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
      $(function(){
    	  $("#save").click(function(){
    		  $("form").submit();
    	  });
    	  
    	  $("#selectParentInt").val("${upMenu.parentInt}");
    	  
      });
</script>
</head>
<body>
	<form class="form-horizontal" action="${pageContext.request.contextPath }/menu/sendUpdateMenu.do" method="post">
		<h3 class="title1">修改菜单</h3>
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label">菜单名称</label>
			<div class="col-sm-4">
				<input type="hidden" name="menuId" class="form-control1" id="focusedinput" value="${upMenu.menuId }">
				<input type="text" name="menuName" class="form-control1" id="focusedinput" value="${upMenu.menuName }">
			</div>
		</div>
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label">菜单地址</label>
			<div class="col-sm-4">
				<input type="text" name="menuUrl" class="form-control1" id="focusedinput" value="${upMenu.menuUrl }">
			</div>
		</div>
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label">父级菜单</label>
			<div class="col-sm-4">
				<select id="selectParentInt" class="form-control" name="parentInt" >
					<c:forEach items="${menuList }" var="m1">
						<c:if test="${m1.parentInt == 0 }">
							<option value="${m1.menuId }">${m1.menuName }</option>
							<c:forEach items="${menuList }" var="m2">
								<c:if test="${m2.parentInt == m1.menuId }">
									<option value="${m2.menuId }">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&mdash;${m2.menuName }</option>
								</c:if>
							</c:forEach>
						</c:if>
					</c:forEach>
				</select>
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