<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class=" sidebar" role="navigation">
            <div class="navbar-collapse">
				<nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
					<ul class="nav" id="side-menu">
					   <c:forEach items="${list }" var="m1">
							<li class="active">
								<a href="javascript:void(0);" dataUrl="${m1.menuUrl }"><i class="fa fa-cogs nav_icon"></i>${m1.menuName } <span class="nav-badge">12</span> <span class="fa arrow"></span></a>
								<ul class="nav nav-second-level collapse in" aria-expanded="true">
									<c:forEach items="${m1.childMenu }" var="m2">
											<li>
												<a href="javascript:void(0);" dataUrl="${m2.menuUrl }">${m2.menuName } </a>
											</li>
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