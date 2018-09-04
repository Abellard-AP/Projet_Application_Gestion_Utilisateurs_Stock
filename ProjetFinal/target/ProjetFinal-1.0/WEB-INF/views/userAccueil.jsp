<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<%@ page session="false"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>

<html>
<head>
<title>Accueil utilisateurs</title>
<link type="text/css" rel="stylesheet"
	href="${contextPath}/resources/css/projet.css" />
	<link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet">
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>

	<h1 class="auth">Authentification</h1>
	<c:if test="${loggedUser.id == 0}">
		<div id="con">
			<f:form method="POST" action="loginAction"
				modelAttribute="loggedUser">
				<label>Nom d'utilisateur :</label>
				<f:input path="login" size="20" />
				<br>
				<label>Mot de passe :</label>
				<f:password path="password" size="20" />
				<br>
				<br>
				<input type="submit" value="Connexion" />
				<input type="reset" value="Annuler" />
			</f:form>
		</div>
	</c:if>

	<c:if test="${loggedUser.id != 0}">
		<div>
			Vous êtes ${loggedUser.login} <a
				href="disconnect?idLoggedUser=${loggedUser.id}" style="">Se
				déconnecter</a>
		</div>
	</c:if>

	<div class="auth">
		<c:out value="${message}" />
	</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
