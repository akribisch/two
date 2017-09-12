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
    	  
    	  $("#selectSex").val("${Paging.map.ssex }");
    	  $("#selectStatId").val("${Paging.map.statId }");
    	  $("#selectDepId").val("${Paging.map.depId }");
    	  $("#selectBankId").val("${Paging.map.bankId }");
      });
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/staff/selectStaff.do" method="post" class="form-horizontal" role="form" id="myform">
			<table class="table">
				<h3 class="title1">员工查询</h3>
				<tr>
					<td>
						<div class="form-group">
			   				<label for="firstname" class="col-sm-6 control-label">员工姓名</label>
			    			<div class="col-sm-6">
			     				 <input type="text" class="form-control" id="firstname" name="staffName"
			     				 value="${Paging.map.staffName }"
			     				 >
			    			</div>
			  			</div>
					</td>
					<td>
						<div class="form-group">
				    		<label for="lastname" class="col-sm-6 control-label">性别</label>
				    		<div class="col-sm-6">
					     		<select id="selectSex" class="form-control" name="ssex" >
									<option value="-1">无</option>
									<option value="1">男</option>
									<option value="0">女</option>
								</select>
				    		</div>
				  		</div> 
					</td>
					<td>
						<div class="form-group">
				    		<label for="lastname" class="col-sm-6 control-label">身份证</label>
				    		<div class="col-sm-6">
				     			 <input type="text" class="form-control" id="lastname" name="sidcard" value="${Paging.map.sidcard}">
				    		</div>
				 		 </div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="form-group">
				    		<label for="lastname" class="col-sm-6 control-label">岗位</label>
				    		<div class="col-sm-6">
				    			<select id="selectStatId" class="form-control" name="statId" >
									<option value="-1">无</option>
									<c:forEach items="${StatList }" var="sta">
										<option value="${sta.statId }">${sta.statName }</option>
									</c:forEach>
								</select>
				    		</div>
				 		 </div>
					</td>
					<td>
						<div class="form-group">
				    		<label for="lastname" class="col-sm-6 control-label">部门</label>
				    		<div class="col-sm-6">
				    			<select id="selectDepId" class="form-control" name="depId" >
									<option value="-1">无</option>
									<c:forEach items="${DepList }" var="dep">
										<option value="${dep.depId }">${dep.depName }</option>
									</c:forEach>
								</select>
				    		</div>
				 		 </div>
					</td>
					<td>
						<div class="form-group">
				    		<label for="lastname" class="col-sm-6 control-label">银行</label>
				    		<div class="col-sm-6">
				    			<select id="selectBankId" class="form-control" name="bankId">
									<option value="-1">无</option>
									<c:forEach items="${BankList }" var="bk">
										<option value="${bk.bankId }">${bk.bankName }</option>
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
				<tr>
					
				</tr>
			</table>
			<table class="table">
			  <caption>员工查询页</caption>
			  <thead>
			    <tr>
			      <th>编号</th>
			      <th>员工名称</th>
			      <th>电话</th>
			      <th>性别</th>
			      <th>出生日期</th>
			      <th>身份证</th>
			      <th>岗位</th>
			      <th>操作</th>
			    </tr>
			  </thead>
			  <tbody>
				<c:forEach items="${Paging.list }" var="stf">
					<tr class="success">
						<td>${stf.staffId }</td>
						<td>${stf.staffName }</td>
						<td>${stf.sPhone }</td>
						<td>${stf.ssex != 0 ? "男" : "女" }</td>
						<td>${Paging.getTimeToStringYMD(stf.sbirthday) }</td>
						<td>${stf.sidcard }</td>
						<td>${stf.station.statName }</td>
						<td>
							<a id="save" class="btn btn-default" href="${pageContext.request.contextPath }/staff/updateStaff.do?staffId=${stf.staffId }" role="button" >修改</a>
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