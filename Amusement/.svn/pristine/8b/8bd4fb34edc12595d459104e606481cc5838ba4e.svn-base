<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询娱乐项目</title>
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
		<form action="${pageContext.request.contextPath }/Recreation/queryRecreation.do" method="post" class="form-horizontal" role="form" id="myform">
			<table>
				<tr>
					<td>
						<div class="form-group">
			   				 <label for="firstname" class="col-sm-4 control-label">项目名称</label>
			    			<div class="col-sm-8">
			     				 <input type="text" class="form-control" id="firstname" name="rname" placeholder="请输入利率种类"
			     				 value="${map.Rname }"
			     				 >
			    			</div>
			  			</div>
					
					</td>
				
				<td>
					<div class="form-group">
			    		<label for="lastname" class="col-sm-4 control-label">地址</label>
			    		<div class="col-sm-8">
			     		 <input type="text" class="form-control" id="lastname" name="raddress" placeholder="请输入计息周期"
			     		 value="${map.Raddress }"
			     		 >
			    		</div>
			  		</div> 
				</td>
				<td>
					<div class="form-group">
			    		<label for="lastname" class="col-sm-4 control-label">价格</label>
			    		<div class="col-sm-8">
			     			 <input type="text" class="form-control" id="lastname" name="Rpice1" placeholder="请输入利率值" value="${map.Rpice1 }">
			    		</div>
			 		 </div>
			 	</td>
			 	<td>
			 		 <div class="form-group">
			    		<label for="lastname" class="col-sm-4 control-label">至</label>
			    		<div class="col-sm-8">
			     			 <input type="text" class="form-control" id="lastname" name="Rpice2" placeholder="请输入利率值" value="${map.Rpice2 }">
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
	  <caption><h2>娱乐项目表</h2><div style="margin-left: 1115px"><a class="btn btn-default" href="addRecreation.jsp" role="button" >添加</a></div></caption>
	  <thead>
	    <tr>
	      <th>娱乐项目编号</th>
	      <th>娱乐项目名称</th>
	      <th>地址</th>
	      <th>价格</th>
	      <th>简介</th>
	      <th>注意事项</th>
	      <th>操作</th>
	     </tr>
	  </thead>
	  <tbody>
	 	 <c:forEach items="${pageUtil.list}" var="recreation">
			
			<tr class="success">
	      		<td>${recreation.rno }</td>
	     	 	<td>${recreation.rname }</td>
	      		<td>${recreation.raddress }</td>
	      		<td>${recreation.rpice }</td>
	      		<td>${recreation.rintroducion }</td>
	      		<td>${recreation.rattention }</td>
	      		<td><a class="btn btn-default" href="${pageContext.request.contextPath }/Recreation/sendUpdateRecreation.do?rno=${recreation.rno }" role="button" >修改</a>
	      		<a class="btn btn-default" href="${pageContext.request.contextPath }/Recreation/deleteRecreation.do?rno=${recreation.rno }" role="button" >删除</a></td>
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