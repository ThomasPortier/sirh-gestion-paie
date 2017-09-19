<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
table {
	border-collapse: collapse;
	width: 50%;
}

td, th {
	border: 2px solid #dddddd;
	text-align: center;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
<title>Liste Employe(e)s</title>
</head>
<body>
	<a href=http://localhost:8080/paie>Accueil</a> -
	<a href=http://localhost:8080/paie/mvc/employes/creer> Creer
		Employe - </a>
	<a href=http://localhost:8080/paie/mvc/bulletins/create> Creer
		Bulletin</a>
	<center>
		<table>
			<tr>
				<th>Periodes</th>
				<th>Matricule</th>
				<th>Prime Exceptionnelle</th>
				<th>Salaire Brut</th>
				<th>Net Imposable</th>
				<th>Net a Payer</th>
			</tr>
			<c:forEach items="${listeBulletinSalaire}" var="unBulletin">
				<tr>
					<td>${unBulletin.periode.dateDebut}-
						${unBulletin.periode.dateFin}</td>
					<td>${unBulletin.remunerationEmploye.matricule}</td>
					<td>${unBulletin.primeExceptionnelle}</td>
					<td>XXXX</td>
					<td>XXXX</td>
					<td>XXXX</td>
				</tr>
				</option>
				<br>
			</c:forEach>
		</table>
	</center>
</body>
</html>