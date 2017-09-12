<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提成类型展示</title>
<%@ include file="../common/commoncss.jsp" %>
<%@ include file="../common/commonjs.jsp" %>
<script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
      $(function(){
    	  $(".pagination li a").click(function(){
    		  var page = $(this).attr("pagedata");//获取属性pdata的值
    		  $("#myPage").val(page);//设置隐藏框的值
    		  $("#myForm").submit();//表单提交
    	  });
      });
</script>
</head>
<body>
<body class="cbp-spmenu-push">
<form id="myForm" action="${pageContext.request.contextPath }/Commission/showCommission.do" method="post">
   <div class="main-content">
		<div class="main-page">
			<div class="tables">
				<h3 class="title1" align="center">提成展示</h3>
				<div class="panel-body widget-shadow">
					<table class="table" >
						<thead>
							<tr>
							  <th>提成类型</th>
							  <th>提成率</th>
							  <th>操作 <a class="btn btn-default" href="${pageContext.request.contextPath }/Commission/insertCommission.jsp" role="button">新增</a></th>
							</tr>
						</thead>
						<c:forEach items="${Pageing.list }" var="s">
							<tr>
								<td>${s.commissionType }</td>
								<td>${s.commissionRate }</td>
								<td>
									<a class="btn btn-default" href="${pageContext.request.contextPath }/Commission/updateCommission.jsp" role="button">修改</a>
									<a class="btn btn-default" href="${pageContext.request.contextPath }/Commission/deleteCommission.jsp" role="button">删除</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
   </div>
<div class="panel-body">
        	${Pageing.nav }
        </div>
</body>
</form>
</body>
</html>