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
		<h1>Création d'un bulletin </h1>
		<form
			action="<%=request.getContextPath()%>/mvc/bulletins/validerFormBulletin"
			method="post">


			<br>Periode <select name="periodeId"> 
				<c:forEach items="${listePeriodes}" var="unePeriode">
					<option value="${unePeriode.id}">${unePeriode.dateDebut} - ${unePeriode.dateFin}</option>
				</c:forEach>
			</select> <br> <br>Matricule <select name="remunerationId"> 
				<c:forEach items="${listeRemunerationEmploye}" var="uneRemuneration">
					<option value="${uneRemuneration.id}">${uneRemuneration.matricule}</option>
				</c:forEach>
			</select>  <br> <br>Prime<input type="text"
				name="PrimeExceptionnelle" value=""><br> <input
				type="submit" value="Valider">
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


