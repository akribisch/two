<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
    	  $("#selectSex").val("${paging.map.beginState }");
    	  $("#selectState").val("${paging.map.endState }");
      });
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/Attendance/queryAttendance.do?select=all" method="post" class="form-horizontal" role="form" id="myform">
			<table class="table">
				<h3 class="title1">考勤管理</h3>
				<tr>
					<td>
						<div>
			   				<label for="firstname" class="col-sm-3 control-label">员工名称</label>
			    			<div class="col-sm-9">
			     				 <input type="text" class="form-control" id="firstname" name="userName" placeholder="请输入用户名"
			     				 value="${paging.map.userName }"
			     				 >
			    			</div>
			  			</div>
					</td>
					<td>
						<div>
			   				<label for="firstname" class="col-sm-3 control-label">开始时间</label>
			    			<div class="col-sm-9">
			     				 <input type="text" class="form-control" id="firstname" name="beginTime" placeholder="请输入开始时间：yyyy-dd-mm" value="${paging.map.beginTime }">
			    			</div>
			  			</div>
					</td>
					
					<td>
						<div>
			   				<label for="firstname" class="col-sm-3 control-label">结束时间</label>
			    			<div class="col-sm-9">
			     				 <input type="text" class="form-control" id="firstname" name="endTime" placeholder="请输入结束时间：yyyy-dd-mm" value="${paging.map.endTime }">
			    			</div>
			  			</div>
					</td>
				</tr>
				<tr>
				<td>
						<div>
			   				<label for="firstname" class="col-sm-3 control-label">状态</label>
			    			<div class="col-sm-9">
			     				<select id="selectSex" class="form-control" name="beginState" >
									<option value="无">请选择</option>
									<option value="正常">正常</option>
									<option value="迟到">迟到</option>
								</select>
			    			</div>
			  			</div>
					</td>
					<td>
						<div>
			   				<label for="firstname" class="col-sm-3 control-label">状态</label>
			    			<div class="col-sm-9">
			     				<select id="selectState" class="form-control" name="endState" >
									<option value="无">请选择</option>
									<option value="正常">正常</option>
									<option value="早退">早退</option>
								</select>
			    			</div>
			  			</div>
					</td>
					<td>
						<div>
				   			 <div>
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
			      <th>考勤编号</th>
			      <th>员工名称</th>
			      <th>上班时间</th>
			      <th>状态</th>
			      <th>下班时间</th>
			      <th>状态</th>
			    </tr>
			  </thead>
			  <tbody>
				<c:forEach items="${paging.list }" var="d">
					<tr>
					<td>${d.aid }</td>
					<td>${d.user.userName }</td>
					<td>${fn:substring(d.beginTime,0,16) }</td>
					<td>${d.beginState }</td>
					<td>${fn:substring(d.endTime,0,16) }</td>
					<td>${d.endState }</td>
					</tr>
				</c:forEach>
			  </tbody>
			</table> 
		<table>
			<tr>
				<td colspan="4">${paging.nav }</td>
			</tr>
		</table>
	</form>
</body>
</html>