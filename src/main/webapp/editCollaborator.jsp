<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head charset="utf-8">
<meta charset="ISO-8859-1">
<title>Editar</title>
<link rel="stylesheet" href="style.css">
<link rel="icon" href="assets/mv-icon.png">
</head>
<body>
	<h1>Editar dados do colaborador</h1>
	<form name="frmCollaborator" action="update">
		<table>
			<tr>
				<td><input  name="id" readonly
					type="hidden" value="<%out.print(request.getAttribute("id"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="contributorName" class="Box1"
					value="<%out.print(request.getAttribute("contributorName"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="cpf" class="Box1"
					value="<%out.print(request.getAttribute("cpf"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="breakfastFood" class="Box1"
					value="<%out.print(request.getAttribute("breakfastFood"));%>"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="Button"
			onclick="validator()">
	</form>
	<script src="scripts/validator.js"></script>
</body>
</html>