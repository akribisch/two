<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class=" sidebar" role="navigation">
    <div class="navbar-collapse">
		<nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1" style="overflow-y: scroll; height: 662px;">
		<ul class="nav" id="side-menu">
		   <c:forEach items="${menuList }" var="m1">
				<c:if test="${m1.parentInt == 0 }">
					<li class="active">
						<a class="catalog" href="javascript:void(0);" dataUrl="${m1.menuUrl }"><i class="fa fa-cogs nav_icon"></i>${m1.menuName } <span class="nav-badge"></span> <span class="fa arrow"></span></a>
						<ul class="nav nav-second-level collapse in" aria-expanded="true" style="display:none;">
							<c:forEach items="${menuList }" var="m2">
								<c:if test="${m2.parentInt == m1.menuId }">
									<li>
										<a id="chooseUrl" href="javascript:void(0);" dataUrl="${m2.menuUrl }">${m2.menuName } </a>
									</li>
								</c:if>
			             	</c:forEach>				
						</ul>
						<!-- /nav-second-level -->
					</li>
				</c:if>
			</c:forEach>
		</ul>
		<!-- //sidebar-collapse -->
		</nav>
	</div>
</div>