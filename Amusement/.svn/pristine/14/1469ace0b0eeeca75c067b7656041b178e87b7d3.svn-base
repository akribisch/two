<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>全查报修系统</title>
<%@ include file="../common/commoncss.jsp" %>
<%@ include file="../common/commonjs.jsp" %>
<style type="text/css">
	.test{
		position: absolute;
		z-index: 100;
		
	}
	.test p{
		padding:10px;
		font:微软雅黑;
		width:150px;
	}
	.user{
		display:none;
		position: relative;
		z-index: 300;
		top: -50px;
		left: 40px;
		border-radius:10px;
		background-color: rgba(216,202,80,0.5);
	}
</style>
<script type="text/javascript">
$(function(){
	  $("li a").click(function(){
		  var page = $(this).attr("pagedata");//获取属性pdata的值
		  $("#myPage").val(page);
		  
		  $("#myform").submit();
		  
	  });
	  $(".test").mouseover(function(){
		  $(this).children(".user").show();
	  });
	  $(".test").mouseout(function(){
		  $(this).children(".user").hide();
	  });
});  		
 </script>
</head>
<body>

	<div>
		<form action="queryFeedback.do" method="post" id="myform">
		<div>
			用户:<input type="text" name="userName">
			设备名称:<input type="text" name="deviceName">
			设备类型：<select name="departId">
			<option value="0">--请选择--</option>
				<c:forEach items="${departlist }" var="d">
					<option value="${d.depId }">${d.depName }</option>
				</c:forEach>
			</select>
			<button>查询</button>
			
		</div>
		<div>
			<a href="sendAddFeedback.do">添加设备</a>
		</div>
	<div>
		<table class="table">
			<tr>
				<td>报修部门</td>
				<td>报修人员</td>
				<td>损坏时间</td>
				<td>预约时间</td>
				<td>设备</td>
				<td>问题描述</td>
				<td>状态</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${paging.list }" var="d">
				<tr>
					<td>${d.depart.depName }</td>
					<td class="test">
					${d.user.userName }
					<div class="user">
						<p>姓名：${d.user.userName }</p>
						<p>状态：
						<c:if test="${d.user.state==0 }">正常</c:if>
						<c:if test="${d.user.state==1 }">禁用</c:if>
						</p>
						<p>生日：${d.user.birthday }</p>
						<p>岗位：${d.user.station.statName }</p>
						<p>电话：${d.user.phone }</p>
					</div>
					</td>
					<td>${d.repairDate }</td>
					<td>${d.orderDate }</td>
					<td>${d.device.deviceName }</td>
					<td>${d.question }</td>
					<td>
					<c:if test="${d.state==0 }">处理中</c:if>
					<c:if test="${d.state==1 }">已完成</c:if>
					</td>
					<td>
						<a href="changeFeedback.do?feedId=${d.feedId }">修改</a>
						<a href="deleteFeedback.do?feedId=${d.feedId }">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		
			<div class="panel-body">
		            ${paging.nav }
		      </div>
		      </div>
       </form>
       </div>
</body>
</html>