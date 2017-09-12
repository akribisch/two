<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限列表</title>
<%@ include file="../../common/commoncss.jsp" %>
<%@ include file="../../common/commonjs.jsp" %>
</head>
<body>
	<div class="container-widget">
		<div class="container-padding">
		  <!-- Start Row -->
		  <div class="row">
		    <div class="col-md-12">
		      <div class="panel panel-default">
		        <div class="panel-title">
		          	管理员
		        </div>
					   <div class="panel-body">
						  <c:forEach items="${list }" var="m1">
								<dl class="clearfix">
									<dt>
										<span>${m1.menuName }</span>
									</dt>
									     <c:forEach items="${m1.childMenu }" var="m2">
											<dd>
												<span>${m2.menuName }</span> 
											</dd> 
										</c:forEach>
								</dl> 
							</c:forEach>
						</div>
					</div>
	            </div>
	        </div>
	      </div>
	    </div>
</body>
</html>