<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>流水展示</title>
<%@ include file="../common/commoncss.jsp" %>
<%@ include file="../common/commonjs.jsp" %>
<script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
$(function(){
//	  分页提交表单 
	  $(".pagination li a").click(function(){
		  var page = $(this).attr("pagedata");//获取属性pagedata的值
		  $("#myPage").val(page);//设置隐藏框的值
		  
		  $("#myform").submit();//表单提交
	  }); 
});
</script>
</head>
<body>
<form id="myform" action="${pageContext.request.contextPath }/Flow/showFlow.do" class="form-horizontal" method="post">
	<h3 align="center" class="title1">JAVA18银行流水</h3>
		<table class="table">
					<tr>
						<td>
						<div class="form-group">
							<label for="lastname" class="col-sm-6 control-label">业务类型</label>
						<div class="col-sm-6">
							<select id="selectService" class="form-control" name="serId">
										<option value=" ">请选择</option>
								<c:forEach items="${serList }" var="ser">
										<option value="${ser.serId }">${ser.serName }</option>
								</c:forEach>
							</select>
						</div>
						</div>
						</td>
						<td>
							<div class="form-group">
					    		<label for="lastname" class="col-sm-6 control-label">结束时间</label>
					    		<div class="col-sm-6">
					     			 <input type="text" class="form-control" id="lastname" name="beginDate" placeholder="请输入开始时间" value="${(Paging.map.endDate == null || Paging.map.beginDate == '') ? '' : Paging.getTimeToString(Paging.map.beginDate)}">
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
				<tr>
				</tr>
				<tr>
						<td>流水编号</td>
						<td>金额</td>
						<td>办理时间</td>
						<td>储蓄卡号</td>
						<td>业务</td>
						<td>办理员工编号</td>
						<td>提成类型</td>
						<td>提成利率</td>
					</tr>
					<c:forEach items="${Pageing.list }" var="flow">
						<tr>
							<td>${flow.flowId }</td>
							<td>${flow.money }</td>
							<td>${Pageing.getTimeToString(flow.flowDate)	}</td>
							<td>${flow.savings.savingsNum }</td>
							<td>${flow.service.serName }</td>
							<td>${flow.staff.staffId }</td>
							<td>${flow.commission.commissionType }</td>
							<td>${flow.commission.commissionRate }</td>
						</tr>
					</c:forEach>
			</table>
        <table>
			<tr>
				<td colspan="4">${Pageing.nav }</td>
			</tr>
		</table>
	</form>
</body>
</html>