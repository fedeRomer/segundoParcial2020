<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tabla de distancias</title>

<!-- CSS only -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
	integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
	crossorigin="anonymous"></script>
	<link href="${pageContext.request.contextPath}/html/tablas/datosTablaDistancia/datatableStyle.css" rel="stylesheet">
</head>

<header>


	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="http://localhost:8080/FrontEnd">Navbar</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="http://localhost:8080/FrontEnd">Inicio <span
						class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Choferes</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="http://localhost:8080/FrontEnd/TestController">Camiones</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#"
					id="navbarDropdownMenuLink" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> Viajes </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item" href="#">Destinos</a> <a
							class="dropdown-item" href="#">Categorias</a> <a
							class="dropdown-item" href="#">Tabla de distancias</a>
					</div></li>
			</ul>
		</div>
	</nav>
</header>

<body>


	<h1>Tabla de distancias</h1>
	<table>
		<tr>
			<!-- <td><a href="Admincontroler?action=index">Volver al menú</a></td> -->
		</tr>

	</table>

	<table border="1" width="100%">
		<tr>
			<td style="color:white">--------</td>
			<td style="color:white">Ciudad Autónoma de Buenos Aires</td>
			<td style="color:white">Córdoba</td>
			<td style="color:white">Corrientes</td>
			<td style="color:white">Formosa</td>
			<td style="color:white">La Plata</td>
			<td style="color:white">La Rioja</td>
			<td style="color:white">Mendoza</td>
			<td style="color:white">Neuquén</td>
			<td style="color:white"  colspan=2>Opciones</td>
		</tr>

		<c:forEach var="distancias" items="${lista}">
			<tr>
				<td style="color:white">--------</td>
				<td style="color:white"><c:out value="${distancias.caba}" /></td>
				<td style="color:white"><c:out value="${distancias.cord}" /></td>
				<td style="color:white"><c:out value="${distancias.corr}" /></td>
				<td style="color:white"><c:out value="${distancias.form}" /></td>
				<td style="color:white"><c:out value="${distancias.lapl}" /></td>
				<td style="color:white"><c:out value="${distancias.mend}" /></td>
				<td style="color:white"><c:out value="${distancias.neuq}" /></td>
				<!--   <td><a href="Admincontroler?action=eliminar&dni=<c:out value="${chofer.dni}"/>">Eliminar</a></td>
                <td><a href="vistas/modificar.jsp">Modificar</a></td>
				-->
			</tr>
		</c:forEach>
	</table>


</body>
</html>