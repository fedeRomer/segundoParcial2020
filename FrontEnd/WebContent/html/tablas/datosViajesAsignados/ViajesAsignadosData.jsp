<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Viajes Asignados</title>
<!-- CSS only -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap.min.css">


<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<link href="${pageContext.request.contextPath}/html/tablas/datosViajesAsignados/datatableStyle.css" rel="stylesheet">
</head>

<script type="text/javascript">
$(document).ready(function() {
    $('#datatable').DataTable();
} );

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
			if(cookie.getValue().equals("Admin"))
				response.sendRedirect("http://localhost:8080/FrontEnd/html/Home2.html");
		}
	}
	%>

	<h1>Viajes Asignados</h1>
	
	<table id="datatable" class="table table-striped table-bordered table-sm" style="width:100%">
		<tr>
			<!-- <th class="th-sm" style="color: black">Chofer</th> -->
			<th class="th-sm" style="color: black">Camión</th>
			<th class="th-sm" style="color: black">Origen</th>
			<th class="th-sm" style="color: black">Destino</th>
			<th class="th-sm" style="color: black">Distancia (km)</th>
			<th class="th-sm" style="color: black">Tiempo de Viaje (dias)</th>
			<th class="th-sm" style="color: black">Tanques De combustible (cantidad)</th>
			<th  style="color:black" colspan=2>Opciones</th>
		</tr>

		<c:forEach var="viajes" items="${lista}">
		<form action="http://localhost:8080/FrontEnd/ViajesAsignadosController" method="post" id="form">
           <tr>
			
			<!-- <td style="color:black"><c:out value="${viajes.chofer}" /></td> -->
			<td style="color:black"><c:out value="${viajes.camion}" /></td>
			<td style="color:black"><c:out value="${viajes.origen}" /></td>
			<td style="color:black"><c:out value="${viajes.destino}" /></td>
			<td style="color:black"><c:out value="${viajes.distancia}" /></td>
			<td style="color:black"><c:out value="${viajes.tiempoDeViaje}" /></td>
			<td style="color:black"><c:out value="${viajes.tanquesDeCombustible}" /></td>
			 <td style="display:none"><input type="text" name="id" value="${viajes.idViaje}" ></td>
			<td style="color:black" > <button type="submit" class="btn btn-success" name="eliminar" value="eliminar">Finalizar Viaje</button></td>
			 
			</tr>
			</form>
		</c:forEach>
		
	</table> 
	

</body>
</html>