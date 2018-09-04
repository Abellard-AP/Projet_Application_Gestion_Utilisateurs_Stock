<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<%@ page session="false"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<title>Gestion des fournisseurs</title>
<link type="text/css" rel="stylesheet"
	href="${contextPath}/resources/css/projet.css" />
<script src="${contextPath}/resources/js/menu.js"></script>
<link href="https://fonts.googleapis.com/css?family=Pacifico"
	rel="stylesheet">
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<h1>Gestion des fournisseurs</h1>
	<jsp:include page="menu.jsp"></jsp:include>
	${message }
	<f:form name="f" method="POST" action="ajoutFournisseur"
		modelAttribute="fournisseur">
		<fieldset id="fs">
			<legend>AJOUT FOURNISSEURS</legend>
			<label>Référence :</label><input type="text" name="reference"
				required> <br> <label>Nom :</label><input type="text"
				name="nom" required> <br> <label>Adresse :</label><input
				type="text" name="adresse.voirie" required><br> <label>Code
				postale :</label><input type="text" name="adresse.codePostal" required><br>
			<label>Ville :</label><input type="text" name="adresse.ville"
				required><br> <input type="hidden" name="idLoggedUser"
				value="${idLoggedUser}"> <input type="submit" name="ajout"
				value="Ajouter"> <input type="reset" name="annuler"
				value="Annuler">
		</fieldset>
	</f:form>
	<br>
	<br>
	<fieldset id="fs">
		<legend>LISTE DES FOURNISSEURS</legend>
		<table>
			<tr>
				<th>Référence</th>
				<th>Nom</th>
				<th>Adresse</th>
				<th>Code Postale</th>
				<th>Ville</th>
				<th class="tabtaill"></th>
				<th class="tabtaill"></th>
			</tr>
			<c:forEach items="${ listefournisseur }" var="u">
				<tr>
					<td>${u.reference }</td>
					<td>${u.nom}</td>
					<td>${u.adresse.voirie }</td>
					<td>${u.adresse.codePostal }</td>
					<td>${u.adresse.ville }</td>
					<td class="boutonactionmd">
					<f:form method="POST"
							action="modifyFournisseur" modelAttribute="Integer">
							<input type="hidden" name="idu" value="${u.id }">
							<input type="hidden" name="idLoggedUser" value="${idLoggedUser}">
							<input type="submit" value="Modifier">
					</f:form>
					</td>
					<td class="boutonactionmd">
					<f:form method="POST"
							action="deletFournisseur" modelAttribute="Integer">
							<input type="hidden" name="idu" value="${u.id }">
							<input type="hidden" name="idLoggedUser" value="${idLoggedUser}">
							<input type="submit" value="Supprimer">
					</f:form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</fieldset>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>