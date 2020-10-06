<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Añadir Camion</title>
<!-- CSS only -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap.min.css">


<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<link href="${pageContext.request.contextPath}/html/tablas/datosCamiones/datatableStyle.css" rel="stylesheet">

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
				<li class="nav-item active"><a class="nav-link" href="http://localhost:8080/FrontEnd">Inicio
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Choferes</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="http://localhost:8080/FrontEnd/CamionesController">Camiones</a></li>
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

<form action="http://localhost:8080/FrontEnd/CamionesController" method="post" id="form">


<dl>
      <dd>
        <table border="1">
          <tr>
            <td>Marca</td>
            <td><input type="text" name="marca" required></td>
          </tr>
          <tr>
            <td>Modelo</td>
            <td><input type="text" name="modelo" required></td>
          </tr>
          <tr>
            <td>Dominio</td>
            <td><input type="text" name="dominio" required></td>
          </tr>
          <tr>
            <td>Categoria</td>
            <td><input type="number" name="categoria" required></td>
          </tr>
          <tr>
            <td>CargaMaximaTn</td>
            <td><input type="number" name="cargaMaximaTn" required></td>
          </tr>
          <tr>
            <td>LitrosTanque</td>
            <td><input type="number" name="litrosTanque" required></td>
          </tr>
          <tr>
            <td>ConsumoLitrosKm</td>
            <td><input type="number" name="consumoLitrosKm" required></td>
          </tr>
          <tr>
            <td><input type="button" class="btn btn-primary" value="Volver" onclick="history.back()"></td>
            
            <td><button type="submit" class="btn btn-primary" name="nuevo"
				value="nuevo">Añadir Camion</button></td>
             
          </tr>
        </table>
    </dl>
    
    
</form>

</body>
</html>