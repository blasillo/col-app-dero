<%@ page contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>

<!DOCTYPE html>
<html lang="es">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<title>Col-App-Dero: Mis notas</title>
	
	
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
		<h2>Mis notas</h2>
	</div>
	
	<div class="row justify-content-center mt-5">   
	    <div class="col-10 col-md-8 col-lg-6">
	        <c:if test="${notas.size() == 0}">
				<p class="text-center">No tiene ninguna nota.</p>
			</c:if>
			<div class="d-flex flex-column">
			
	            <c:forEach var="nota" items="${notas}">
		            <div class="row justify-content-center note">
		            	 <div class="col-12">
					        <h5>${nota.titulo} <a href="notas_editar?id=${nota.id}"><i class="fas fa-pencil-alt ml-2"></i></a></h5>
					        <p>${nota.contenido}</p>
					        <p class="small"><i><fmt:formatDate value="${nota.creado}" pattern="yyyy-MM-dd HH:mm:ss" /> - ${nota.cerveza.nombre}</i></p>
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



