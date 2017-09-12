<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询定单信息</title>
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
		<form action="${pageContext.request.contextPath }/OrderInformation/queryOrder.do" method="post" class="form-horizontal" role="form" id="myform">
			<table>
				<tr>
					<td>
						<div class="form-group">
			   				 <label for="firstname" class="col-sm-4 control-label">游客姓名</label>
			    			<div class="col-sm-8">
			     				 <input type="text" class="form-control" id="firstname" name="tourName" placeholder="请输入游客姓名"
			     				 value="${map.tourName }"
			     				 >
			    			</div>
			  			</div>
					
					</td>
				
				<td>
					<div class="form-group">
			    		<label for="lastname" class="col-sm-4 control-label">游客电话</label>
			    		<div class="col-sm-8">
			     		 <input type="text" class="form-control" id="lastname" name="tourPhone" placeholder="请输入游客电话"
			     		 value="${map.tourPhone }"
			     		 >
			    		</div>
			  		</div> 
				</td>
				<td>
					<div class="form-group">
			    		<label for="lastname" class="col-sm-4 control-label">VIP卡号</label>
			    		<div class="col-sm-8">
			     		 <input type="text" class="form-control" id="lastname" name="vNo" placeholder="请输入VIP卡号"
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
				
	<table class="table">
	  <caption><h2>订单详情表</h2><div style="margin-left: 1115px"><a class="btn btn-default" href="${pageContext.request.contextPath }/OrderInformation/sendAddOrder.do" role="button" >订票</a></div></caption>
	  <thead>
	    <tr>
	      <th>订单编号</th>
	      <th>所用VIP卡</th>
	      <th>姓名</th>
	      <th>性别</th>
	      <th>电话</th>
	      <th>娱乐项目名称</th>
	      <th>价格</th>
	      <th>订购时间</th>
	      <th>操作</th>
	     </tr>
	  </thead>
	  <tbody>
	 	 <c:forEach items="${pageUtil.list}" var="order">
			
			<tr class="success">
	      		<td>${order.orderId }</td>
	      		<td>${order.vip.vNo }</td>
	     	 	<td>${order.tourist.tourName }</td>
	      		<td><c:if test="${order.tourist.tourSex==0 }">男</c:if>
	      		<c:if test="${order.tourist.tourSex==1 }">女</c:if>
	      		</td>
	      		<td>${order.tourist.tourPhone }</td>
	      		<td>${order.recreation.rname }</td>
	      		<td>${order.recreation.rpice }</td>
	      		<td>${order.orderDate }</td>
	      		<td>
	      		<a class="btn btn-default" href="deleteOrder.do?orderId=${order.orderId }" role="button" >删除</a></td>
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