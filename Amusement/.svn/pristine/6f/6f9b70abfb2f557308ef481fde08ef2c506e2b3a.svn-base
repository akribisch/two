<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/plugin/css/bootstrap.css">  
	<script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>
	<script src="${pageContext.request.contextPath }/plugin/js/bootstrap.js"></script>
	
</head>
<body>
	<div class="page-header">
    <h1>修改优惠活动
     
    </h1>
</div><!-- localhost:8080/Amusement/VipLevel/updateVipLevel.jsp -->
	 <form action="${pageContext.request.contextPath }/Vacation/updateVacation.do" method="post" class="form-horizontal" role="form">
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">活动名称</label>
	    <div class="col-sm-6">
	    	<input type="hidden" name="vacationId" value="${vacation.vacationId }"/>
	      <input type="text" class="form-control" id="firstname" name="activeName" value="${vacation.activeName }">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">参与活动项目</label>
	    <div class="col-sm-6">
	    	<select name="rno">
	    		<c:forEach items="${list }" var="recreation">
	    			<option value="${recreation.rno }" <c:if test="${recreation.rno==vacation.recreation.rno }">selected="selected"</c:if>>${recreation.rname }</option>
	    		</c:forEach>
	    	</select>
	     
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">折扣</label>
	    <div class="col-sm-6">
	    	
	      <input type="text" class="form-control" id="firstname" name="discount" value="${vacation.discount }">
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-default">确定修改</button>
	    </div>
	  </div>
	</form>
</body>
</html>