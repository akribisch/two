<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class=" sidebar" role="navigation">
            <div class="navbar-collapse">
				<nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
					<ul class="nav" id="side-menu">
						<c:if test="${Staff.staffName=='admin' }">
							<li class="active">
								<a href="javascript:void(0);" dataUrl="/station/findStation.do"><i class="fa fa-cogs nav_icon"></i>分配权限<span class="fa arrow"></span></a>
								<ul class="nav nav-second-level collapse in" aria-expanded="true">
									<li>
										<a href="javascript:void(0);" dataUrl="/menu/sendAdd.do">增加功能 </a>
										<a href="javascript:void(0);" dataUrl="/menu/allMenu.do">展示功能 </a>
									</li>
								</ul>
							</li>
						</c:if>
					   <c:forEach items="${list }" var="m1">
							<li class="active">
								<c:if test="${m1.hasAuthority==1 }">
								<a href="javascript:void(0);" dataUrl="${m1.menuUrl }"><i class="fa fa-cogs nav_icon"></i>${m1.menuName } <span class="fa arrow"></span></a>
								</c:if>
								<ul class="nav nav-second-level collapse in" aria-expanded="true">
									<c:forEach items="${m1.childMenu }" var="m2">
											<c:if test="${m2.hasAuthority==1 }">
											<li>
												<a href="javascript:void(0);" dataUrl="${m2.menuUrl }">${m2.menuName } </a>
											</li>
											</c:if>
					             </c:forEach>				
								</ul>
								<!-- /nav-second-level -->
							</li>
						</c:forEach>
					</ul>
					<!-- //sidebar-collapse -->
				</nav>
			</div>
		</div>