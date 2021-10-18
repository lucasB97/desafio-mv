<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.CollaboratorModel"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<CollaboratorModel> list = (ArrayList<CollaboratorModel>) request.getAttribute("collaborators");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="style.css">
<link rel="icon" href="assets/mv-icon.png">
<title>lista</title>
</head>
<body>
	<div class="container">
		<h1>Lista de cáfe da manhã</h1>
		<a href="newCollaborator.html"  id="ButtonGreen">Novo colaborador</a>
		<table id="table">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Cpf</th>
					<th>Prato de cáfe da manhã</th>
					<th>Opções</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (int i = 0; i < list.size(); i++) {
				%>
				<tr>
					<td><%=list.get(i).getcontributorName()%></td>
					<td><%=list.get(i).getCpf()%></td>
					<td><%=list.get(i).getbreakfastFood()%></td>
					<td><a href="select?id=<%=list.get(i).getId()%>" class="Button">Editar</a>
						<a href="javascript: confirmDeletion(<%=list.get(i).getId()%>)"
						class="ButtonRed">Excluir</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<script src="scripts/confirmDeletion.js"></script>
	</div>
</body>
</html>