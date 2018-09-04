<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<%@ page session="false"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<title>Gestion des utilisateurs</title>
<link type="text/css" rel="stylesheet"
	href="${contextPath}/resources/css/projet.css" />
<script src="${contextPath}/resources/js/menu.js"></script>
<link href="https://fonts.googleapis.com/css?family=Pacifico"
	rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<h1>Gestion des utilisateurs</h1>
	<jsp:include page="menu.jsp"></jsp:include>
	${message }

	<fieldset id="fs">
		<legend>MODIFIER UTILISATEUR</legend>

		<f:form method="POST" action="modifierUser" modelAttribute="user">
			<label>Nom d'utilisateur :</label>
			<input type="text" name="login" value="${user1.login}" required>
			<br>
			<label>Mot de passe :</label>
			<input type="password" name="password" required>
			<br>
			<label>Rôle :</label>
			<select name="role" required>
				<c:if test="${user1.role == 'USER'}">
					<option value="USER">Utilisateur</option>
					<option value="ADMIN">Administrateur</option>
				</c:if>
				<c:if test="${user1.role == 'ADMIN'}">
					<option value="ADMIN">Administrateur</option>
					<option value="USER">Utilisateur</option>
				</c:if>
			</select>
			<input type="hidden" name="idLoggedUser" value="${idLoggedUser}">
			<input type="hidden" name="id" value="${user1.id }">
			<br>
			<input type="submit" value="Modifier">
		</f:form>
	</fieldset>
	<br>

	<br>
<%-- 	<fieldset id="fs"> --%>
<!-- 		<legend>LISTE DES UTILISATEURS</legend> -->
<!-- 		<table> -->
<!-- 			<tr> -->
<!-- 				<th>Nom d'utilisateur</th> -->
<!-- 				<th>Mot de passe</th> -->
<!-- 				<th>Rôle</th> -->
<!-- 			</tr> -->
<%-- 			<c:forEach items="${ listeuser }" var="u"> --%>
<!-- 				<tr> -->
<%-- 					<td>${u.login }</td> --%>
<%-- 					<td>${u.password }</td> --%>
<%-- 					<td>${u.role }</td> --%>
<%-- 					<td><f:form method="POST" action="modifyUser" --%>
<%-- 							modelAttribute="user"> --%>
<%-- 							<input type="hidden" value="${u.id }"> --%>
<!-- 							<input type="submit" value="Modifier"> -->
<%-- 						</f:form></td> --%>
<%-- 					<td><f:form method="POST" action="deletUser" --%>
<%-- 							modelAttribute="Integer"> --%>
<%-- 							<input type="hidden" name="idu" value="${u.id }"> --%>
<!-- 							<input type="submit" value="Supprimer"> -->
<%-- 						</f:form></td> --%>
<!-- 				</tr> -->
<%-- 			</c:forEach> --%>
<!-- 		</table> -->
<%-- 	</fieldset> --%>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>