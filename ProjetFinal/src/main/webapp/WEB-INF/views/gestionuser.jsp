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

	<c:if test="${loggedUser.role=='ADMIN'}">
 ${message }

	<fieldset id="fs">
			<legend>AJOUT UTILISATEUR</legend>

			<f:form method="POST" action="ajoutUser" modelAttribute="user">
				<label>Nom d'utilisateur :</label>
				<input type="text" name="login" required>
				<br>
				<label>Mot de passe :</label>
				<input type="password" name="password" required>
				<br>
				<label>Rôle :</label>
				<select name="role" required>
					<option value="USER">Utilisateur</option>
					<option value="ADMIN">Administrateur</option>
				</select>
				<input type="hidden" name="idLoggedUser" value="${idLoggedUser}">
				<br>
				<input type="submit" value="Ajouter">
			</f:form>
		</fieldset>
		<br>

		<br>
		<fieldset id="fs">
			<legend>LISTE DES UTILISATEURS</legend>
			<table>
				<tr>
					<th>Nom d'utilisateur</th>
					<th>Mot de passe</th>
					<th>Rôle</th>
					<th class="tabtaill"></th>
					<th class="tabtaill"></th>
				</tr>
				<c:forEach items="${ listeuser }" var="u">
					<tr>
						<td>${u.login }</td>
						<td>${u.password }</td>
						<c:if test="${u.role =='ADMIN'}">
							<td>Administrateur</td>
						</c:if>
						<c:if test="${u.role =='USER'}">
							<td>Utilisateur</td>
						</c:if>
						<td class="boutonactionmd"><f:form method="POST"
								action="modifyUser" modelAttribute="Integer">
								<input type="hidden" name="idu" value="${u.id }">
								<input type="hidden" name="idLoggedUser" value="${idLoggedUser}">
								<input type="submit" value="Modifier">
							</f:form></td>
						<td class="boutonactionmd">
						<c:if test="${loggedUser.id != u.id}">
								<f:form method="POST" action="deletUser"
									modelAttribute="Integer">
									<input type="hidden" name="idu" value="${u.id }">
									<input type="hidden" name="idLoggedUser"
										value="${idLoggedUser}">
									<input type="submit" value="Supprimer">
								</f:form>
						</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</fieldset>
	</c:if>
	<c:if test="${loggedUser.role=='USER'}">
	Vous n'avez pas les droits !!
	</c:if>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>