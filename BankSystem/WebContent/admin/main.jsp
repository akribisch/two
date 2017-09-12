<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>银行管理系统的主页面</title>
<%@ include file="../../common/commoncss.jsp" %>
<%@ include file="../../common/commonjs.jsp" %>
<style type="text/css">
.cbp-spmenu-vertical {
    width: 200px;
    height: 100%;
    top: 76px;
    z-index: 1000;
    background-color: #4F52BA;
    padding: 2em 0;
}
.logo {
    background: #6164C1;
    text-align: center;
    float: left;
    width: 200px;
    height: 76px;
}
.cbp-spmenu-vertical {
    width: 200px;
    height: 100%;
    top: 76px;
    z-index: 1000;
    background-color: #4F52BA;
    padding: 2em 0;
    font-size: 13px;
}
.nav {
    padding-left: 0;
    margin-bottom: 0;
    list-style: none;
    margin-top: -0px;
}
#page-wrapper {
    padding: 7em 2em 2.5em;
    /* background-color: #F1F1F1; */
}
.nav .nav-second-level{
	display: none;
}
</style>
</head>
<body class="cbp-spmenu-push">
	<div class="main-content">
		<!--left-fixed -菜单-->
		
		<jsp:include page="../common/menu.jsp"></jsp:include>
		
		<!--left-fixed -navigation-->
		<!-- header-starts -->
		<div class="sticky-header header-section ">
			<div class="header-left">
				
				<!--toggle button end-->
				<!--logo -->
				<div class="logo">
					<a href="index.html">
						<h1>银行</h1>
						<span>管理系统</span>
					</a>
				</div>
				<!--//logo-->
				
				<div class="clearfix"> </div>
			</div>
			<div class="header-right">
				<div class="profile_details_left"><!--notifications of menu start -->
					<div class="clearfix"> </div>
				</div>
				<!--notification menu end -->
				<div class="profile_details">		
					<ul>
						<li class="dropdown profile_details_drop">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">	
							</a>
							<h3>${Staff.staffName }</h3>
							<ul class="dropdown-menu drp-mnu">
								<li> <a href="#"><i class="fa fa-cog"></i> Settings</a> </li> 
								<li> <a href="#"><i class="fa fa-user"></i> Profile</a> </li> 
								<li> <a href="#"><i class="fa fa-sign-out"></i> Logout</a> </li>
							</ul>
						</li>
					</ul>
				</div>
				<div class="clearfix"> </div>				
			</div>
			<div class="clearfix"> </div>	
		</div>
		<!-- //header-ends -->
		<!-- main content start-->
		<div id="page-wrapper">
			<div class="main-page">
				<div class="row-one" style="margin-left: -80px;">
					<iframe id="menuFrame" src="${pageContext.request.contextPath }/login/loginSavings.jsp" scrolling="no" 
					frameborder="0" width="100%" height="2000"></iframe>
					
				</div>
				
				<div class="clearfix"> </div>
			</div>
		</div>
		<!--footer-->
		<div class="footer">
		   <p>Copyright &copy; 2017.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
		</div>
        <!--//footer-->
	</div>
	
	<script src="${pageContext.request.contextPath }/plugin/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript">
	   $(function(){
		    $(".nav a").click(function(){
		    	
		    	var menuUrl = $(this).attr("dataUrl");
		    	
		    	$("#menuFrame").attr("src","${pageContext.request.contextPath }"+menuUrl);
		    });
		   $(".fa").mouseover(function(){
			   var dis=$(this).parent().next(".nav .nav-second-level").css("display");console.log(dis);
			   if(dis=='block'){
				   $(this).parent().next(".nav .nav-second-level").css('display','none');
			   }
			   if(dis=='none'){
				   $(this).parent().next(".nav .nav-second-level").css('display','block');
			   }
		   });
	   })
	</script>
</body>
</html>