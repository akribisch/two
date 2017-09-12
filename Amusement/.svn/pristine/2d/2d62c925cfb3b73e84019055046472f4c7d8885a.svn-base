<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>全查游玩信息</title>

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
		width:200px;
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
		<form action="queryPlayGame.do" method="post" id="myform">
		<div>
			游客账户:<input type="text" name="tourCount">
			项目名称:<input type="text" name="rname">
			价格：<input type="text" name="minPrice">
			-<input type="text" name="maxPrice">
			<button>查询</button>
			
		</div>
		<div>
			<a href="sendAddPlayGame.do">添加游玩信息</a>
		</div>
	<div>
		<table class="table">
			<tr>
				<td>游客名称</td>
				<td>游玩项目</td>
				<td>游玩时间</td>
				<td>游玩价格</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${paging.list }" var="d">
				<tr>
					<td class="test">
					${d.tourist.tourName }
					<div class="user">
						<p>游客账户：${d.tourist.tourCount }</p>
						<p>游客名称：${d.tourist.tourName }</p>
						<p>游客性别：
						<c:if test="${d.tourist.tourSex==0 }">男</c:if>
						<c:if test="${d.tourist.tourSex==1 }">女</c:if>
						</p>
						<p>游客电话：${d.tourist.tourPhone }</p>
						<p>游客电子邮箱：${d.tourist.tourEmail }</p>
					</div>
					</td>
					<td>${d.recreation.rname }</td>
					<td>${d.playDate }</td>
					<td>${d.playPrice }</td>
					<td>
						<a href="changePlayGame.do?playGameId=${d.playGameId }">修改</a>
						<a href="deletePlayGame.do?playGameId=${d.playGameId }">删除</a>
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