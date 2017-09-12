<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%@ include file="../../common/commoncss.jsp" %>
<%@ include file="../../common/commonjs.jsp" %>
 <link rel="stylesheet" href="${pageContext.request.contextPath }/plugin/kindeditor/themes/default/default.css" />

</head>
<body>
     <form class="form-horizontal" action="menu/saveMenu.do" method="post">
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label">菜单名称：</label>
			<div class="col-sm-4">
				<input type="text" name="menuName" class="form-control1" id="focusedinput" placeholder="请输入菜单名称" value="">
			</div>
		</div>
		
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label">父级菜单：</label>
			<div class="col-sm-4">
			    <select class="form-control" name="parentId">
			        <option value="0">请选择</option>
			    
			       <!-- 第一层 -->
			       <c:forEach items="${menuList }" var="m1">
			          <option value="${m1.menuId }">${m1.menuName }</option>
			          
			          <!-- 第二层 -->
			          <c:forEach items="${m1.childMenu }" var="m2">
			              <option value="${m2.menuId }">&nbsp;&nbsp;&nbsp;&nbsp;${m2.menuName }</option>
			          </c:forEach>
			       </c:forEach>
				</select>
			</div>
		</div>
		
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label">菜单访问路径：</label>
			<div class="col-sm-4">
				<input type="text" name="menuUrl" class="form-control1" id="focusedinput" placeholder="请输入菜单访问路径">
			</div>
		</div>
		
		<div class="form-group">
			<label for="focusedinput" class="col-sm-2 control-label"></label>
			<div class="col-sm-4">
				<input type="submit"  class="form-control1"  value="添加">
			</div>
		</div>
   </form>
  <script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath }/plugin/kindeditor/kindeditor.js"></script>
<script src="${pageContext.request.contextPath }/plugin/kindeditor/lang/zh_CN.js"></script>

<script type="text/javascript">
		KindEditor.ready(function(K) {
			var editor = K.editor({
				allowFileManager : true
			});
			K('#image1').click(function() {
				editor.loadPlugin('image', function() {
					editor.plugin.imageDialog({
						imageUrl : K('#url1').val(),
						clickFn : function(url, title, width, height, border, align) {
							K('#url1').val(url);
							editor.hideDialog();
						}
					});
				});
			});
		});
</script>
</body>
</html>