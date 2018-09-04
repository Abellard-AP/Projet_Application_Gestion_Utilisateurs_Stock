<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<%@ page session="false"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<title>Gestion des produits</title>
<link type="text/css" rel="stylesheet"
	href="${contextPath}/resources/css/projet.css" />
<script src="${contextPath}/resources/js/menu.js"></script>
<link href="https://fonts.googleapis.com/css?family=Pacifico"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h1>Gestion des produits</h1>
	<jsp:include page="menu.jsp"></jsp:include>
	${message }
	<f:form name="f" method="POST" action="ajoutProduit"
		modelAttribute="produit">
		<fieldset id="fs">
			<legend>AJOUT PRODUITS</legend>
			<label>Référence :</label><input type="text" name="reference"
				required><br> <label>Désignation :</label><input
				type="text" name="designation" required> <br> <label>Prix
				:</label><input type="text" name="prix" required><br> <label>Quantité
				:</label><input type="text" name="quantite" required><br> <label>Fournisseur
				:</label><select name="fournisseur.id" required>
				<c:forEach items="${listefournisseur}" var="u">
					<option value="${u.id}">${u.reference}</option>
				</c:forEach>
			</select><br> <input type="hidden" name="idLoggedUser"
				value="${idLoggedUser}"> <input type="submit" name="ajout"
				value="Ajouter"> <input type="reset" name="annuler"
				value="Annuler">
		</fieldset>
	</f:form>
	<br>
	<br>
	<fieldset id="fs">
		<legend>LISTE DES PRODUITS</legend>
		<table>
			<tr>
				<th>Référence</th>
				<th>Désignation</th>
				<th>Prix</th>
				<th>Quantité</th>
				<th>Fournisseur</th>
				<th class="tabtaill"></th>
				<th class="tabtaill"></th>
			</tr>
			<c:forEach items="${ listeproduit }" var="p">
				<tr>
					<td>${p.reference }</td>
					<td>${p.designation}</td>
					<td>${p.prix }</td>
					<td>${p.quantite }</td>
					<td>${p.fournisseur.reference }</td>
					<td class="boutonactionmd"><f:form method="POST" action="modifyProduit"
							modelAttribute="Integer">
							<input type="hidden" name="idu" value="${p.id }">
							<input type="hidden" name="idLoggedUser" value="${idLoggedUser}">
							<input type="submit" value="Modifier">
						</f:form></td>
					<td class="boutonactionmd"><f:form method="POST" action="deletProduit"
							modelAttribute="Integer">
							<input type="hidden" name="idu" value="${p.id }">
							<input type="hidden" name="idLoggedUser" value="${idLoggedUser}">
							<input type="submit" value="Supprimer">
						</f:form></td>
				</tr>
			</c:forEach>
		</table>
	</fieldset>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>