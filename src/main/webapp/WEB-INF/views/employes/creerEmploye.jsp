<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<a href=http://localhost:8080/paie>Accueil</a>
	<center>
		<h1>Créer Employé(e)</h1>
		<form action="<%=request.getContextPath()%>/mvc/employes/validerForm" method="post">
			Matricule <input type="text" name="matricule" value=""><br>
			
			<br>Profil <select name="entrepriseId"> -->
				<c:forEach items="${listeEntreprises}" var="uneEntreprise"> 
					<option value="${uneEntreprise.id}">${uneEntreprise.denomination}</option>
				</c:forEach>
 			</select> <br> 
 			
 			<br>Profil <select name="profilId"> -->
				<c:forEach items="${listeProfilRemuneration}" var="unProfil">
					<option value="${unProfil.id}">${unProfil.code}</option>
				</c:forEach>
 			</select> <br> 
 			
 			<br>Grade <select name="gradeId"> -->
				<c:forEach items="${listeGrades}" var="unGrade">
					<option value="${unGrade.id}">${unGrade.code} - ${unGrade.tauxBase} K€ / an</option>
				</c:forEach>
			</select> <br> 
			<input type="submit" value="Submit">
		</form>
	</center>
</body>
</html>

<!-- 			 -->
<!-- 			 -->
<!-- 			<br> <input type="submit" value="Valider"> -->
<!-- 			 -->
<%-- 				<c:forEach items="${listeEntreprises}" var="uneEntreprise"> --%>
<%-- 					<option value="${uneEntreprise.id}">${uneEntreprise.denomination}</option> --%>
<%-- 				</c:forEach> --%>
<!-- 			 <br> <br>Profil <select name="profilId"> -->
<%-- 				<c:forEach items="${listeProfilRemuneration}" var="unProfil"> --%>
<%-- 					<option value="${unProfil.id}">${unProfil.code}</option> --%>
<%-- 				</c:forEach> --%>
<!-- 			</select> <br> <br>Grade <select name="gradeId"> -->
<%-- 				<c:forEach items="${listeGrades}" var="unGrade"> --%>
<%-- 					<option value="${unGrade.id}">${unGrade.code}- --%>
<%-- 						${unGrade.tauxBase} K€ / an</option> --%>
<%-- 				</c:forEach> --%>
<!-- 			</select> <input type="submit" value="Valider"> -->


