<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>定票</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/plugin/css/bootstrap.css">  
	<script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>
	<script src="${pageContext.request.contextPath }/plugin/js/bootstrap.js"></script>
	
	
</head>
<body>

<!-- localhost:8080/Amusement/Recreation/addRecreation.jsp -->
<h2>游客订票</h2>
	
	</form>
	
	<form action="${pageContext.request.contextPath }/OrderInformation/addOrderInformation.do" method="post" class="form-horizontal" role="form">
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">姓名</label>
	    <div class="col-sm-6">
	      <input type="text" class="form-control" id="firstname" name="tourName" placeholder="请输入姓名">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="lastname" class="col-sm-2 control-label">性别</label>
	    <div class="col-sm-6">
	     	<input type="radio" value="0" name="tourSex">男
			<input type="radio" value="1" name="tourSex">女
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="lastname" class="col-sm-2 control-label">电话</label>
	    <div class="col-sm-6">
	      <input type="text" class="form-control" id="lastname" name="tourPhone" placeholder="请输入电话"  >
	    </div>
	  </div>
	   <div class="form-group">
	    <label for="lastname" class="col-sm-2 control-label">邮箱</label>
	    <div class="col-sm-6">
	      <input type="text" class="form-control" id="lastname" name="tourEmail" placeholder="请输入邮箱"  >
	    </div>
	  </div>
	 </div>
	   <div class="form-group">
	    <label for="lastname" class="col-sm-2 control-label">VIP卡号</label>
	    <div class="col-sm-6">
	      <input type="text" class="form-control" id="lastname" name="vNo" placeholder="请输入VIP卡号"  >
	    </div>
	  </div>
	 
	   <div class="form-group">
	    <label for="lastname" class="col-sm-2 control-label">活动项目</label>
	    <div class="col-sm-6">
	      <select name="recreationId">
	      	<c:forEach items="${list }" var="recreation">
	      		<option value="${recreation.rno }">${recreation.rname }</option>
	      	</c:forEach>
	      </select>
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-default">添加</button>
	    </div>
	  </div>
	</form>
	
</body>
</html>