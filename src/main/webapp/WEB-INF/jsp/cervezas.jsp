<%@ page contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<c:set var="title" scope="request" value="List of Beers"/>

<!DOCTYPE html>
<html lang="es">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<title>Col-App-Dero</title>
	
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" >
	<link rel="stylesheet" href="fontawesome/css/all.min.css">
	<link rel="stylesheet" href="fontawesome/css/fontawesome.min.css">
	
	<link rel="stylesheet" type="text/css" href="css/colapp.css" >


  

</head>
<body>
<jsp:include page="comun/cabecera.jsp"></jsp:include>

<div class="container">
    <div class="row justify-content-center mt-4">
		<h2>Listado de cervezas</h2>
	</div>
	
	<div class="row justify-content-center mt-4">
		<form class="form-inline" action="cervezas">
			<label class="sr-only" for="searchField">Búsqueda</label>
			<div class="input-group mb-2 mr-sm-2 mb-sm-0">
				<div class="input-group-addon">
					<i class="fa fa-search"></i>
				</div>
				<input type="text" class="form-control" id="searchField" name="busqueda" size="50" 
					placeholder="criterios de b&uacute;squeda">
			</div>
			<button type="submit" class="btn btn-primary">Buscar</button>
		</form>
	</div>
	
	
	<div class="row justify-content-center mt-7">
	
		<c:if test="${cervezas.size() == 0}">
			<p class="text-center">No se han encontrado cervezas.</p>
		</c:if>
		
		<c:forEach var="cerv" items="${cervezas}">
		
			<div class="card tarjeta m-3">
				<img class="card-img-top" src="imagenes/${cerv.imagen}">
				
				<div class="card-block">
					<h5 class="text-center">${cerv.nombre}</h5>
					<div>Categoria: <i>${cerv.categoria}</i></div>
					<div>Color: <i>${cerv.color}</i></div>
					<div>Alcohol: <i>${cerv.alcohol}%</i></div>
				</div>
				<div class="card-block row justify-content-center">
					<a href="/cervezas?id=${cerv.id}" class="btn btn-outline-primary btn-text-l">
						<i class="fa fa-info-circle"></i>
					</a>
				</div>
			
			</div>
			
		</c:forEach>
		
	</div>	
	
	
	
	

</div>

<jsp:include page="comun/pie.jsp"></jsp:include>
  
  <script src="js/jquery-3.2.1.slim.min.js"></script>
  <script src="js/popper.min.js" ></script>
  <script src="js/bootstrap.min.js"></script>
</body>
</html>



