<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>银行查询页</title>
<%@ include file="../common/commoncss.jsp" %>
<%@ include file="../common/commonjs.jsp" %>
<script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
      $(function(){
    	  
    	  <!-- 提交表单 -->
    	  $(".pagination li a").click(function(){
    		  var page = $(this).attr("pagedata");//获取属性pagedata的值
    		  $("#myPage").val(page);//设置隐藏框的值
    		  $("#myForm").submit();//表单提交
    	  });
    	  
      });
</script>
</head>
<body class="cbp-spmenu-push">
   <div class="main-content">
		<div class="main-page">
			<div class="tables">
				<h3 class="title1">银行查询页</h3>
				<div class="panel-body widget-shadow">
					<form id="myForm" action="${pageContext.request.contextPath }/bank/selectBank.do" method="post">
						<table class="table">
							<thead>
								<tr>
								  <th>序号</th>
								  <th>银行地名</th>
								  <th>
								  	<div class="form-group">
							      		<a id="add" class="btn btn-default" href="${pageContext.request.contextPath }/bank/addBank.jsp" role="button" >新增</a>
							 		</div>
								  </th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${Paging.list }" var="bank">
									<tr>
									  <td>${bank.bankId }</td>
									  <td>${bank.bankName }</td>
									  <td>
									  	<a id="update" class="btn btn-default" href="${pageContext.request.contextPath }/bank/updateBank.do?bankId=${bank.bankId }" role="button" >修改</a>
									  </td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="panel-body">
				        	${Paging.nav }
				        </div>
					</form>
				</div>
			</div>
		</div>
   </div>
</body>
</html>