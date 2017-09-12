<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>岗位管理</title>
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
    	  
    	  $("#selectDepId").val("${Paging.map.depId}");
      });
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/station/selectStation.do" method="post" class="form-horizontal" role="form" id="myform">
			<table class="table">
				<h3 class="title1">岗位管理</h3>
				<tr>
					<td>
						<div class="form-group">
			   				<label for="firstname" class="col-sm-6 control-label">岗位名</label>
			    			<div class="col-sm-6">
			     				 <input type="text" class="form-control" id="firstname" name="statName" placeholder="请输入岗位名"
			     				 value="${Paging.map.statName }"
			     				 >
			    			</div>
			  			</div>
					</td>
					<td>
						<div class="form-group">
			   				<label for="firstname" class="col-sm-6 control-label">岗位人数</label>
			    			<div class="col-sm-6">
			     				 <input type="text" class="form-control" id="firstname" name="statNumMin"
			     				 value="${Paging.map.statNumMin }"
			     				 >
			    			</div>
			  			</div>
					</td>
					<td>
						<div class="form-group">
			   				<label for="firstname" class="col-sm-6 control-label">—</label>
			    			<div class="col-sm-6">
			     				 <input type="text" class="form-control" id="firstname" name="statNumMax"
			     				 value="${Paging.map.statNumMax }"
			     				 >
			    			</div>
			  			</div>
					</td>
					<td>
						<div class="form-group">
			   				<label for="firstname" class="col-sm-6 control-label">所属部门</label>
			    			<div class="col-sm-6">
			     				<select id="selectDepId" class="form-control" name="depId" >
									<option value="0">无</option>
									<c:forEach items="${DepList }" var="dep">
										<option value="${dep.depId }">${dep.depName }</option>
									</c:forEach>
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
			  <thead>
			    <tr>
			      <th>编号</th>
			      <th>岗位名称</th>
			      <th>岗位人数</th>
			      <th>底薪</th>
			      <th>所属部门</th>
			      <th>
			      	<a class="btn btn-default" href="${pageContext.request.contextPath }/station/addStation.do" role="button" >新增</a>
			      </th>
			    </tr>
			  </thead>
			  <tbody>
				<c:forEach items="${Paging.list }" var="m">
					<tr class="success">
						<td>${m.statId }</td>
						<td>${m.statName }</td>
						<td>${m.statNum }</td>
						<td>${m.money }</td>
						<td>${m.department.depName }</td>
						<td>
							<a class="btn btn-default" href="${pageContext.request.contextPath }/station/updateById.do?statId=${m.statId }" role="button" >修改</a>
							<a class="btn btn-default" href="${pageContext.request.contextPath }/station/deleteById.do?statId=${m.statId }" role="button" >删除</a>
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