<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<%@ page session="false"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />



<div id="allmenu">
	<div id="imgmenu" onclick="menuclick();">
		<img src="${contextPath}/resources/img/bars.png" width="50em">
	</div>
	<div id="menu" style="display: none;">
	<c:if test="${loggedUser.role=='ADMIN'}">
		<div id="us">
			<a href="menuuser?idLoggedUser=${idLoggedUser}" class="ml">
				<img src="${contextPath}/resources/img/users.png" width="20em">
			<p class="mi ml">Gestion des utilisateurs</p>
			</a>
		</div>
		</c:if>
		<div id="do">
			<a href="menuprod?idLoggedUser=${idLoggedUser}" class="ml">
				<img src="${contextPath}/resources/img/dolly.png" width="20em">
			<p class="mi ml">Gestion des produits</p>
			</a>
		</div>
		<div id="fo">
			<a href="menufourni?idLoggedUser=${idLoggedUser}" class="ml"> <img
				src="${contextPath}/resources/img/truck.png" width="20em">
			<p class="mi ml">Gestion des fournisseurs</p>
			</a>
		</div>
		<div id="exit">
			<a href="disconnect" class="ml"> <img
				src="${contextPath}/resources/img/times.png" width="20em">
			<p class="mi ml">EXIT</p>
			</a>
		</div>
	</div>
</div>

<div id="conect">
	Bienvenue ${loggedUser.login} <a href="disconnect">Déconnexion</a>
</div>
