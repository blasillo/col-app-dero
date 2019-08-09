<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<div class="row justify-content-center mt-4">
		<h2 class="col-12 text-center">Nueva nota</h2>
	</div>
	
	<c:if test="${error.length() > 0}">
		<div class="row justify-content-center mt-4">
			<div class="alert alert-danger">
				<p class="m-0">${error}</p>
			</div>
		</div>
	</c:if>
	
	
	<div class="row justify-content-center mt-4 mb-2">
	    <form method="POST" action="notas/nueva">
	    		<input type="hidden" name="cervezaid" value="${cerveza.id}">
	    		
	        <div class="form-group">
	            <label>Título</label>
	            <input type="text" class="form-control" size="40" name="titulo" value="${nota.titulo}">
	        </div>
	        <div class="form-group">
	            <label>Comentarios</label>
	            <textarea class="form-control" rows="3" name="contenido">${nota.contenido}</textarea>
	        </div>
	        <div class="form-check">
	            <label class="form-check-label">
	                <input type="checkbox" class="form-check-input" name="notaPublica" value="${nota.notaPublica}">
	                ¿Compartida para todos los usuarios?
	            </label>
	        </div>
	        <div class="mt-2 text-center">
	            <input class="btn btn-primary" type="submit" value="Guardar">
	        </div>
	    </form>
	</div>
</div>



<jsp:include page="comun/pie.jsp"></jsp:include>
  
  <script src="js/jquery-3.2.1.slim.min.js"></script>
  <script src="js/popper.min.js" ></script>
  <script src="js/bootstrap.min.js"></script>
</body>
</html>