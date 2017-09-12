<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<%@ include file="../common/commoncss.jsp" %>
<%@ include file="../common/commonjs.jsp" %>
<script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
      $(function(){
    	  
    	  $(".pagination li a").click(function(){
    		  var page = $(this).attr("pagedata");//获取属性pagedata的值
    		  $("#myPage").val(page);//设置隐藏框的值
    		  $("#myform").submit();//表单提交
    	  });
    	  
    	  $("#selectSex").val("${Paging.map.sex }");
    	  $("#selectState").val("${Paging.map.state }");
    	  $("#selectStatId").val("${Paging.map.stationid }");
      });
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/user/select.do" method="post" class="form-horizontal" role="form" id="myform">
			<table class="table">
				<h3 class="title1">用户管理</h3>
				<tr>
					<td>
						<div class="form-group">
			   				<label for="firstname" class="col-sm-6 control-label">用户名</label>
			    			<div class="col-sm-6">
			     				 <input type="text" class="form-control" id="firstname" name="userName" placeholder="请输入用户名"
			     				 value="${Paging.map.userName }"
			     				 >
			    			</div>
			  			</div>
					</td>
					<td>
						<div class="form-group">
				    		<label for="lastname" class="col-sm-6 control-label">性别</label>
				    		<div class="col-sm-6">
					     		<select id="selectSex" class="form-control" name="sex" >
									<option value="-1">请选择</option>
									<option value="1">男</option>
									<option value="0">女</option>
								</select>
				    		</div>
				  		</div> 
					</td>
					<td>
						<div class="form-group">
				    		<label for="lastname" class="col-sm-6 control-label">岗位</label>
				    		<div class="col-sm-6">
				    			<select id="selectStatId" class="form-control" name="stationid" >
									<option value="-1">请选择</option>
									<c:forEach items="${StatList }" var="sta">
										<option value="${sta.statId }">${sta.statName }</option>
									</c:forEach>
								</select>
				    		</div>
				 		 </div>
					</td>
					<td>
						<div class="form-group">
				    		<label for="lastname" class="col-sm-6 control-label">状态</label>
				    		<div class="col-sm-6">
				    			<select id="selectState" class="form-control" name="state" >
									<option value="-1">请选择</option>
									<option value="0">正常</option>
									<option value="1">禁用</option>
								</select>
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
			  <caption></caption>
			  <thead>
			    <tr>
			      <th>编号</th>
			      <th>用户名</th>
			      <th>岗位</th>
			      <th>电话</th>
			      <th>性别</th>
			      <th>出生日期</th>
			      <th>状态</th>
			      <th>
			      	<a class="btn btn-default" href="${pageContext.request.contextPath }/user/addUser.do" role="button" >新增</a>
			      </th>
			    </tr>
			  </thead>
			  <tbody>
				<c:forEach items="${Paging.list }" var="us">
					<tr class="success">
						<td>${us.userId }</td>
						<td>${us.userName }</td>
						<td>${us.station.statName }</td>
						<td>${us.phone }</td>
						<td>${us.sex != 1 ? "女" : "男" }</td>
						<td>${us.birthday }</td>
						<td>${us.state != 1 ? "正常" : "禁用" }</td>
						<td>
							<a class="btn btn-default" href="${pageContext.request.contextPath }/user/updateById.do?userId=${us.userId }" role="button" >修改</a>
							<a class="btn btn-default" href="${pageContext.request.contextPath }/user/deleteById.do?userId=${us.userId }" role="button" >删除</a>
						</td>
					</tr>
				</c:forEach>
			  </tbody>
			</table> 
		<table>
			<tr>
				<td colspan="4">${Paging.nav }</td>
			</tr>
		</table>
	</form>
</body>
</html>