<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/plugin/css/bootstrap.css">  
	<script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>
	<script src="${pageContext.request.contextPath }/plugin/js/bootstrap.js"></script>
	<script type="text/javascript">
	
	$(function(){
		$(function(){
			  $("li a").click(function(){
				  var page = $(this).attr("pagedata");//获取属性pdata的值
				  $("#myPage").val(page);
				  
				  $("#myform").submit();
				  
			  });//导航条提交数据
		}); 
		$("li").click(function(){
			$("li .active").removeClass("active");
			$(this).addClass("active");
		});//导航条选中样式
		
		$("tr").hover(function(){
			$("tbody tr").prop("class","success");
			$(this).prop("class","active");
			
		});//添加表格选中样式
	});
	
</script>
</head>
<body>
	<form action="querySavState.do" method="post" class="form-horizontal" role="form" id="myform">
			<table>
				<tr>
					<td>
						<div class="form-group">
			   				 <label for="firstname" class="col-sm-6 control-label">账号状态</label>
			    			<div class="col-sm-6">
			     				 <input type="text" class="form-control" id="firstname" name="savStat" placeholder="请输入账号状态"
			     				 value="${map.savstat }"
			     				 >
			    			</div>
			  			</div>
					
					</td>
				
				
				<td>
					<div class="form-group">
			   			 <div class="col-sm-offset-2 col-sm-10">
			      			<button type="submit" class="btn btn-default">查询</button>
			   			 </div>
			 		 </div>
				</td>
			
			</table>
	<table class="table">
	  <caption>账号状态表</caption>
	  <thead>
	    <tr>
	      <th>账号编号</th>
	      <th>账号状态</th>
	     
	     </tr>
	  </thead>
	  <tbody>
	 	 <c:forEach items="${pageUtil.list }" var="sav">
			
			<tr class="success">
	      		<td>${sav.savId }</td>
	     	 	<td>${sav.savStat }</td>
	      		
	      	</tr>
				
		</c:forEach>
	    
	  </tbody>
	</table> 
	<table>
		
		<tr><td colspan="4">${nav }</td></tr>
	</table>
	</form>
	
</body>
</html>