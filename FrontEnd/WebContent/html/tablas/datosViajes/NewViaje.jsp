<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuevo Viaje</title>
<!-- CSS only -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap.min.css">


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
<link
	href="${pageContext.request.contextPath}/html/tablas/datosViajes/datatableStyle.css"
	rel="stylesheet">
</head>

<script type="text/javascript">
	$(document).ready(function() {
		$('#datatable').DataTable();
	});
</script>

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
				<li class="nav-item active"><a class="nav-link" href="http://localhost:8080/FrontEnd/html/Home2.html">Inicio
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="http://localhost:8080/FrontEnd/ChoferesController">Choferes</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="http://localhost:8080/FrontEnd/CamionesController">Camiones</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#"
					id="navbarDropdownMenuLink" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> Viajes </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item" href="http://localhost:8080/FrontEnd/DestinosController">Destinos</a> <a
							class="dropdown-item" href="http://localhost:8080/FrontEnd/CategoriasController">Categorias</a> 
							<a class="dropdown-item" href="http://localhost:8080/FrontEnd/html/tablas/datosTablaDistancia/TablaDistanciaData.jsp">Tabla de distancias</a>
							 <a class="dropdown-item" href="http://localhost:8080/FrontEnd/ViajesController">Viajes (Administrador)</a>
							  <a class="dropdown-item" href="http://localhost:8080/FrontEnd/ViajesAsignadosController">Viajes (Chofer)</a>
							
					</div></li>
			</ul>
		</div>
	</nav>
</header>

<body>
<%
String userName = null;
Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if(cookie.getValue().equals("Chofer"))
				response.sendRedirect("http://localhost:8080/FrontEnd/html/Home2.html");
		}
	}
	%>
	

	

<form action="http://localhost:8080/FrontEnd/ViajesController" method="post" id="form">

		<dl>
			<dd>
				<table border="1">
					<tr>
						<td>Chofer (DNI)</td>
						<td><select name="chofer">
							<c:forEach items="${choferes}" var="choferes"
								varStatus="loop">
								<option type="text" value="${choferes.idChoferes}" id="chofer" name="chofer">${choferes.dni}</option>
							</c:forEach>
						</select></td>
						
						
						
					</tr>
					<tr>
						<td>Camión (Dominio)</td>
						<td><select name="camion">
							<c:forEach items="${camiones}" var="camiones"
								varStatus="loop">
								<option type="text" value="${camiones.idCamiones}" id="camion" name="camion">${camiones.dominio}</option>
							</c:forEach>
						</select>
						</td>
						
					</tr>
					<tr>
						<td>Origen</td>
						<td><select name=origen>
							<c:forEach items="${provincias}" var="origen"
								varStatus="loop">
								<option type="text" value="${origen.idProvincia}" id="origen" name="origen">${origen.provincia}</option>
							</c:forEach>
						</select></td>
						
					</tr>
					<tr>
						<td>Destino</td>
						<td><select name="destino">
							<c:forEach items="${provincias}" var="destino"
								varStatus="loop">
								<option type="text" value="${destino.idProvincia}" id="destino" name="destino">${destino.provincia}</option>
							</c:forEach>
						</select>
						</td>
						
					</tr>
					<tr>
						<td><input type="button" class="btn btn-primary"
							value="Volver" onclick="history.back()"></td>

						<td><button type="submit" class="btn btn-primary" name="nuevo" value="nuevo">Añadir Nuevo Viaje</button></td>

					</tr>
				</table>
		</dl>


	</form>
</body>
</html>