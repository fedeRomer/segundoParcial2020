<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Añadir Chofer</title>
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
	href="${pageContext.request.contextPath}/html/tablas/datosChoferes/datatableStyle.css"
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
				<li class="nav-item active"><a class="nav-link" href="http://localhost:8080/FrontEnd">Inicio
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
							 <a class="dropdown-item" href="http://localhost:8080/FrontEnd/html/tablas/datosTablaDistancia/TablaDistanciaData.jsp">Viajes (Administrador)</a>
							  <a class="dropdown-item" href="http://localhost:8080/FrontEnd/html/tablas/datosTablaDistancia/TablaDistanciaData.jsp">Viajes (Chofer)</a>
							
					</div></li>
			</ul>
		</div>
	</nav>
</header>

<body>

	<form action="http://localhost:8080/FrontEnd/ChoferesController"
		method="post" id="form">


		<dl>
			<dd>
				<table border="1">
					<tr>
						<td>Nombre</td>
						<td><input type="text" name="nombre" required></td>
					</tr>
					<tr>
						<td>Apellido</td>
						<td><input type="text" name="apellido" required></td>
					</tr>
					<tr>
						<td>Dni</td>
						<td><input type="number" name="dni" min="1" max="99999999" required></td>
					</tr>
					<tr>
						<td>Fecha de nacimiento</td>
						<td><input type="text" name="fechaDeNacimiento" required></td>
					</tr>
					<tr>
						<td>Categoria</td>
						<td><input type="number" name="categoria" min="1" max="5" required></td>
					</tr>
					<tr>
						<td>Telefono</td>
						<td><input type="text" name="telefono" required></td>
					</tr>
					<tr>
						<td><input type="button" class="btn btn-primary"
							value="Volver" onclick="history.back()"></td>

						<td><button type="submit" class="btn btn-primary"
								name="nuevo" value="nuevo">Añadir Chofer</button></td>

					</tr>
				</table>
		</dl>


	</form>

</body>
</html>