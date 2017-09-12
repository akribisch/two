<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询Vip卡</title>
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
	<form action="${pageContext.request.contextPath }/Vip/queryVip.do" method="post" class="form-horizontal" role="form" id="myform">
			<table>
				<tr>
					<td>
						<div class="form-group">
			   				 <label for="firstname" class="col-sm-4 control-label">卡号</label>
			    			<div class="col-sm-8">
			     				 <input type="text" class="form-control" id="firstname" name="vNo" placeholder="请输入卡号"
			     				 value="${map.vNo }"
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
			 	</tr>
			 	
				
			
			</table>
		<div>${map.waring }</div>		
	<table class="table">
	  <caption><h2>查询Vip卡</h2><div style="margin-left: 1115px"><a class="btn btn-default" href="${pageContext.request.contextPath }/VipLevel/queryVipLevelToAdd.do" role="button" >添加</a></div></caption>
	  <thead>
	    <tr>
	      <th>卡编号</th>
	      <th>发卡日期</th>
	      <th>结束日期</th>
	     
	      
	      <th>卡级别</th>
	      <th>总价</th>
	      <th>余额</th>
	      <th>操作</th>
	     </tr>
	  </thead>
	  <tbody>
	 	 <c:forEach items="${pageUtil.list}" var="vip">
			
			<tr class="success">
	      		<td>${vip.vNo }</td>
	     	 	<td>${vip.vDate }</td>
	     	 	<td>${vip.overDate }</td>
	      		
	      		<td>${vip.vipLevel.level }</td>
	      		<td>${vip.vipLevel.cPrice }</td>
	      		<td>${vip.remaining }</td>
	      		<td>
	      		<a class="btn btn-default" href="${pageContext.request.contextPath }/Vip/deletevId.do?vId=${vip.vId }" role="button" >删除</a></td>
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