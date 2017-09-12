<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询优惠活动</title>
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
<form action="${pageContext.request.contextPath }/Vacation/queryVacation.do" method="post" class="form-horizontal" role="form" id="myform">
			<table>
				<tr>
					<td>
						<div class="form-group">
			   				 <label for="firstname" class="col-sm-5 control-label">活动名称：</label>
			    			<div class="col-sm-7">
			     				 <input type="text" class="form-control" id="firstname" name="activeName" placeholder="请输入活动名称"
			     				 value="${map.activeName }"
			     				 >
			    			</div>
			  			</div>
					
					</td>
				
				
				<td>
					<div class="form-group">
			    		<label for="lastname" class="col-sm-4 control-label">折扣：</label>
			    		<div class="col-sm-8">
			     			 <input type="text" class="form-control" id="lastname" name="discount1" placeholder="请输入折扣" value="${map.discount1 }">
			    		</div>
			 		 </div>
			 	</td>
			 	<td>
			 		 <div class="form-group">
			    		<label for="lastname" class="col-sm-2 control-label">至</label>
			    		<div class="col-sm-8">
			     			 <input type="text" class="form-control" id="lastname" name="discount2" placeholder="请输入折扣" value="${map.discount2 }">
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
			 	</tr>
			 	
				
			
			</table>
				
	<table class="table">
	  <caption><h2>优惠活动表</h2><div style="margin-left: 995px"><a class="btn btn-default" href="${pageContext.request.contextPath }/Vacation/sendAddVacation.do" role="button" >添加</a></div></caption>
	  <thead>
	    <tr>
	      <th>活动编号</th>
	      <th>活动名称</th>
	      <th>活动项目</th>
	      <th>折扣</th>
	      
	      <th>操作</th>
	     </tr>
	  </thead>
	  <tbody>
	 	 <c:forEach items="${pageUtil.list}" var="vacation">
			
			<tr class="success">
	      		<td>${vacation.vacationId }</td>
	     	 	<td>${vacation.activeName }</td>
	      		<td>${vacation.recreation.rname }</td>
	      		<td>${vacation.discount }</td>
	      		
	      		<td><a class="btn btn-default" href="${pageContext.request.contextPath }/Vacation/sendUpdateVacation.do?vacationId=${vacation.vacationId }" role="button" >修改</a>
	      		<a class="btn btn-default" href="${pageContext.request.contextPath }/Vacation/deleteVacation.do?vacationId=${vacation.vacationId }" role="button" >删除</a></td>
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