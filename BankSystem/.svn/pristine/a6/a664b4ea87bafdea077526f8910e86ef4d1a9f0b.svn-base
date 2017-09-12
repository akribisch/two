<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>存取款流水</title>
<%@ include file="../common/commoncss.jsp" %>
<%@ include file="../common/commonjs.jsp" %>
<script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
      $(function(){
    	  <!-- 分页提交表单 -->
    	  $(".pagination li a").click(function(){
    		  var page = $(this).attr("pagedata");//获取属性pagedata的值
    		  $("#myPage").val(page);//设置隐藏框的值
    		  $("#myform").submit();//表单提交
    	  });
    	  
    	  $("#selectService").val("${Paging.obj.service.serId }");
      });
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/Access/selectAccess.do" method="post" class="form-horizontal" role="form" id="myform">
			<table>
				<h3 class="title1">存取款流水查询页</h3>
				<tr>
					<td>
						<div class="form-group">
			   				<label for="firstname" class="col-sm-6 control-label">储蓄卡号</label>
			    			<div class="col-sm-6">
			     				 <input type="text" class="form-control" id="firstname" name="savingsNum" placeholder="请输入储蓄卡号"
			     				 value="${Paging.obj.savings.savingsNum }"
			     				 >
			    			</div>
			  			</div>
					</td>
					<td>
						<div class="form-group">
				    		<label for="lastname" class="col-sm-6 control-label">业务类型</label>
				    		<div class="col-sm-6">
					     		<select id="selectService" class="form-control" name="serId" >
									<option value="0">请选择</option>
									<option value="1">存款</option>
									<option value="2">取款</option>
								</select>
				    		</div>
				  		</div> 
					</td>
					<td>
						<div class="form-group">
				    		<label for="lastname" class="col-sm-6 control-label">开始时间</label>
				    		<div class="col-sm-6">
				     			 <input type="text" class="form-control" id="lastname" name="beginDate" placeholder="请输入开始时间" value="${(Paging.map.beginDate == null || Paging.map.beginDate == '') ? '' : Paging.getTimeToString(Paging.map.beginDate)}">
				    		</div>
				 		 </div>
					</td>
					<td>
						<div class="form-group">
				    		<label for="lastname" class="col-sm-6 control-label">结束时间</label>
				    		<div class="col-sm-6">
				     			 <input type="text" class="form-control" id="lastname" name="endDate" placeholder="请输入结束时间" value="${(Paging.map.endDate == null || Paging.map.endDate == '') ? '' : Paging.getTimeToString(Paging.map.endDate)}">
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
			  <caption>存取款流水表</caption>
			  <thead>
			    <tr>
			      <th>编号</th>
			      <th>储蓄卡号</th>
			      <th>业务类型</th>
			      <th>金额</th>
			      <th>办理时间</th>
			      <th>办理员工</th>
			      <th>办理银行</th>
			    </tr>
			  </thead>
			  <tbody>
				<c:forEach items="${Paging.list }" var="ac">
					<tr class="success">
						<td>${ac.accessId }</td>
						<td>${ac.savings.savingsNum }</td>
						<td>${ac.service.serName }</td>
						<td>${ac.money }</td>
						<td>${Paging.getTimeToString(ac.currentTime) }</td>
						<td>${ac.staff.staffId }</td>
						<td>${ac.bank.bankName }</td>
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