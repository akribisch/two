<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改岗位</title>
<%@ include file="../common/commoncss.jsp" %>
<%@ include file="../common/commonjs.jsp" %>
<link href="${pageContext.request.contextPath }/css/authority.css" rel='stylesheet' type='text/css' />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/authority.js"></script>
<script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
      $(function(){
    	  $("#save").click(function(){
    		  $("form").submit();
    	  });
    	  
    	  $("#selectDepId").val("${upStation.department.depId}");
    	  
      });
</script>
</head>
<body>
	<form class="form-horizontal" action="${pageContext.request.contextPath }/station/sendUpdateStation.do" method="post">
		<h3 class="title1">修改岗位</h3>
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label">岗位名称</label>
			<div class="col-sm-4">
				<input type="hidden" name="statId" class="form-control1" id="focusedinput" value="${upStation.statId }">
				<input type="text" name="statName" class="form-control1" id="focusedinput" value="${upStation.statName }">
			</div>
		</div>
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label">岗位人数</label>
			<div class="col-sm-4">
				<input type="text" name="statNum" class="form-control1" id="focusedinput" value="${upStation.statNum }">
			</div>
		</div>
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label">岗位底薪</label>
			<div class="col-sm-4">
				<input type="text" name="money" class="form-control1" id="focusedinput" value="${upStation.money }">
			</div>
		</div>
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label">所属部门</label>
			<div class="col-sm-4">
				<select id="selectDepId" class="form-control" name="depId" >
					<c:forEach items="${DepList }" var="dep">
						<option value="${dep.depId }">${dep.depName }</option>
					</c:forEach>
				</select>
			</div>
		</div>
        <h3 class="title1">菜单权限</h3>
	   	<div class="panel-body">
			<div id="roleprivlieges">
				<div class="app">
					<p class="approot">
						<b>全选</b>  
						<input type="checkbox" name="cks" value="0" level="1">
					</p>
					<c:forEach items="${menuList }" var="m1">
						<c:if test="${m1.parentInt == 0 }">
							<dl class="clearfix">
								<dt>
									<b>${m1.menuName }</b> 
									<input type="checkbox" name="check" value="${m1.menuId }" level="2" 
										<c:if test="${m1.visible == true }">checked="checked"</c:if>
									>
								</dt>
							    <c:forEach items="${menuList }" var="m2">
									<c:if test="${m2.parentInt == m1.menuId }">
										<dd>
											<span>${m2.menuName }</span> 
									        <input type="checkbox" name="check" value="${m2.menuId }" level="3" 
									        	<c:if test="${m2.visible == true }">checked="checked"</c:if>
									        >
										</dd>
									</c:if>
								</c:forEach>
							</dl>
						</c:if>
					</c:forEach>
				</div>
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