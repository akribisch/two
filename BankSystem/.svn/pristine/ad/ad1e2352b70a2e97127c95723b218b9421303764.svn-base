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
		<form action="getInterest.do" method="post" class="form-horizontal" role="form" id="myform">
			<table>
				<tr>
					<td>
						<div class="form-group">
			   				 <label for="firstname" class="col-sm-6 control-label">利率种类</label>
			    			<div class="col-sm-6">
			     				 <input type="text" class="form-control" id="firstname" name="interestName" placeholder="请输入利率种类"
			     				 value="${map.interestName }"
			     				 >
			    			</div>
			  			</div>
					
					</td>
				
				<td>
					<div class="form-group">
			    		<label for="lastname" class="col-sm-6 control-label">计息周期(月)</label>
			    		<div class="col-sm-6">
			     		 <input type="text" class="form-control" id="lastname" name="interestCycle" placeholder="请输入计息周期"
			     		 value="${map.interestCycle }"
			     		 >
			    		</div>
			  		</div> 
				</td>
				<td>
					<div class="form-group">
			    		<label for="lastname" class="col-sm-6 control-label">利率值</label>
			    		<div class="col-sm-6">
			     			 <input type="text" class="form-control" id="lastname" name="interest" placeholder="请输入利率值" value="${map.interest }">
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
	  <caption>产品利率表</caption>
	  <thead>
	    <tr>
	      <th>利率编号</th>
	      <th>利率种类</th>
	      <th>利率值</th>
	      <th>计息周期(月）</th>
	      <th>操作</th>
	     </tr>
	  </thead>
	  <tbody>
	 	 <c:forEach items="${pageUtil.list}" var="interest">
			
			<tr class="success">
	      		<td>${interest.interestId }</td>
	     	 	<td>${interest.interestName }</td>
	      		<td>${interest.interest }</td>
	      		<td>${interest.interestCycle }</td>
	      		<td><a class="btn btn-default" href="sendUpdate.do?interestId=${interest.interestId }" role="button" >修改</a>
	      		<a class="btn btn-default" href="deleteInterest.do?interestId=${interest.interestId }" role="button" >删除</a></td>
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