<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="es">
<head>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	
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
	<div class="row justify-content-center align-items-center mt-3">
	    <h2>${cerveza.nombre}</h2>
	</div>
	
	<div class="row justify-content-center align-items-center mt-3 mb-3">
	    <div class="col-sm-4 col-md-4 col-lg-3 text-center p-4">
	        <img class="img-fluid img-blur" src="imagenes/${cerveza.imagen}">
	        <p>
	            <div class="text-left">Category: <i>${cerveza.categoria}</i></div>
	            <div class="text-left">Color: <i>${cerveza.color}</i></div>
	            <div class="text-left">Alcohol: <i>${cerveza.alcohol} %</i></div>
	        </p>
	    </div>
	    <div class="col-sm-8 col-md-7 col-lg-5 text-center mt-3 mt-md-0">
	        <p class="text-justify">
	            ${cerveza.descripcion}
	        </p>
	    </div>
	</div>
	
	
	
	<div class="row justify-content-center mt-5">
	    <div class="col-10 col-md-8 col-lg-6 text-center">
			
				<% if ( true ) { %>
					<a class="nav-item btn btn-primary" href="notas?id=${cerveza.id}">Nueva nota</a>
				<%} else { %>    
					<p>Es necesario iniciar sesión para poner una nota</p>
					<a class="nav-item btn btn-primary" href="login">Iniciar sesión</a>
				<%} %>
			
	    </div>
	</div>
	
	
	<div class="row justify-content-center mt-5">
	    <div class="col-10 col-md-8 col-lg-6">
	        <div class="d-flex flex-column">
	            <c:forEach var="nota" items="${notas}">
		            <div class="row justify-content-center note">
					    <div class="col-12">
					        <h5>${nota.titulo}</h5>
					        <p>${nota.contenido}</p>
					        
					        <p class="small"><i><fmt:formatDate value="${nota.creado}" pattern="yyyy-MM-dd HH:mm:ss" /> - ${nota.autor}</i></p>
					        
					    </div>
					</div>
				</c:forEach>
	        </div>
	    </div>
	</div>
	
</div>

<jsp:include page="comun/pie.jsp"></jsp:include>
  
  <script src="js/jquery-3.2.1.slim.min.js"></script>
  <script src="js/popper.min.js" ></script>
  <script src="js/bootstrap.min.js"></script>
</body>
</html>
	