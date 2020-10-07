<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Camiones</title>
<!-- CSS only -->

<!-- CSS only -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap.min.css">


<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<link href="${pageContext.request.contextPath}/html/tablas/datosCamiones/datatableStyle.css" rel="stylesheet">
</head>

<script>

function sortTable(n) {
  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
  table = document.getElementById("datatable1");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc";
  /* Make a loop that will continue until
  no switching has been done: */
  while (switching) {
    // Start by saying: no switching is done:
    switching = false;
    rows = table.rows;
    /* Loop through all table rows (except the
    first, which contains table headers): */
    for (i = 1; i < (rows.length - 1); i++) {
      // Start by saying there should be no switching:
      shouldSwitch = false;
      /* Get the two elements you want to compare,
      one from current row and one from the next: */
      x = rows[i].getElementsByTagName("TD")[n];
      y = rows[i + 1].getElementsByTagName("TD")[n];
      /* Check if the two rows should switch place,
      based on the direction, asc or desc: */
      if (dir == "asc") {
        if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
          // If so, mark as a switch and break the loop:
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
          // If so, mark as a switch and break the loop:
          shouldSwitch = true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
      // Each time a switch is done, increase this count by 1:
      switchcount ++;
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}
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
							  <a class="dropdown-item" href="http://localhost:8080/FrontEnd/html/tablas/datosViajesAsignados/ViajesAsignadosData.jsp">Viajes (Chofer)</a>
							
					</div></li>
			</ul>
		</div>
	</nav>
</header>

<body>


    <h1>Lista de camiones</h1>
    <table id="datatable1" class="table table-striped table-bordered table-sm" style="width:100%">
    <thead>
        <tr>
        	<!-- <td style="color:black" >Id</td> -->
            <th class="th-sm" style="color:black" onclick="sortTable(0)" >Marca</th>
            <th class="th-sm" style="color:black" onclick="sortTable(1)">Modelo</th>
            <th class="th-sm" style="color:black" onclick="sortTable(2)">Dominio</th>
            <th class="th-sm" style="color:black" onclick="sortTable(3)">Categoria</th>
            <th class="th-sm" style="color:black" onclick="sortTable(4)">CargaMaximaTn</th>
            <th class="th-sm" style="color:black" onclick="sortTable(5)">LitrosTanque </th>
            <th class="th-sm" style="color:black" onclick="sortTable(6)">ConsumoLitrosKm (Litros cada 100km)</th>
            <th  style="color:black" colspan=2>Opciones</th>
        </tr>
       </thead>

        <c:forEach var="camiones" items="${lista}">
        <form action="http://localhost:8080/FrontEnd/CamionesController" method="post" id="form">
	        <tbody>
	            <tr>
            	
                <td style="color:black" ><input type="text" name="marca" value="${camiones.marca}" ></td>
                <td style="color:black" ><input type="text" name="modelo" value="${camiones.modelo}" ></td>
                <td style="color:black" ><input type="text" name="dominio" value="${camiones.dominio}" ></td>
                <td style="color:black" ><input type="number"  name="categoria" min="1" max="5" value="${camiones.categoria}" ></td>
                <td style="color:black" ><input type="number"  name="cargaMaximaTn" min="1" max="99" value="${camiones.cargaMaximaTn}" ></td>
                <td style="color:black" ><input type="number" name="litrosTanque" min="1" max="9999" value="${camiones.litrosTanque}" ></td>
                <td style="color:black" ><input type="number" name="consumoLitrosKm" min="1" max="9999" value="${camiones.consumoLitrosKm}" ></td>
                <td style="display:none"><input type="text" name="id" value="${camiones.idCamiones}" ></td>
                <td style="color:black" > <button type="submit" class="btn btn-primary" name="modificar" value="modificar">Modificar</button> </td>
                <td style="color:black" > <button type="submit" class="btn btn-danger" name="eliminar" value="eliminar">Eliminar</button></td>
                
           		 </tr>
            </tbody>
            </form>
        </c:forEach>
    </table>
				
<a href="http://localhost:8080/FrontEnd/html/tablas/datosCamiones/NewCamion.jsp" class="btn btn-primary my-2">Añadir Camion</a>

</body>
</html>