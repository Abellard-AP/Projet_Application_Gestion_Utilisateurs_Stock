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
		<f:form method="POST" action="menuuser">
		<input type="hidden" name="idLoggedUser" value="${idLoggedUser}">
		<img src="${contextPath}/resources/img/users.png" width="20em"><input class="menuform" type ="submit" name="ajout" value="GESTION DES UTILISATEURS">
		</f:form>
		</div>
		</c:if>
		<div id="do">
		<f:form method="POST" action="menuprod">
		<input type="hidden" name="idLoggedUser" value="${idLoggedUser}">
		<img src="${contextPath}/resources/img/dolly.png" width="20em"><input class="menuform" type ="submit" name="ajout" value="GESTION DES PRODUITS">
		</f:form>
		</div>
		<div id="fo">
		<f:form  method="POST" action="menufourni">
		<input type="hidden" name="idLoggedUser" value="${idLoggedUser}">
		<img src="${contextPath}/resources/img/truck.png" width="20em"><input class="menuform" type ="submit" name="ajout" value="GESTION DES FOURNISSEURS">
		</f:form>
		</div>
		<div id="exit">
		<f:form  method="POST" action="exit">
		<img src="${contextPath}/resources/img/times.png" width="20em"><input class="menuform" type ="submit" name="ajout" value="EXIT">
		</f:form>
		</div>
	</div>
</div>

<div id="conect">
	Bienvenue ${loggedUser.login} <a href="disconnect">Déconnexion</a>
</div>
