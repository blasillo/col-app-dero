<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html >
<html lang="es">
<head>
<title>Col-App-Dero</title>


<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" >
<link rel="stylesheet" href="fontawesome/css/all.min.css">
<link rel="stylesheet" href="fontawesome/css/fontawesome.min.css">

<link rel="stylesheet" type="text/css" href="css/colapp.css" >

<script src="js/jquery-3.2.1.slim.min.js"  crossorigin="anonymous"></script>
<script src="js/popper.min.js" crossorigin="anonymous"></script>
<script src="js/bootstrap.min.js" crossorigin="anonymous"></script>


</head>


<body>


<jsp:include page="comun/cabecera.jsp"></jsp:include>


<c:choose>
	<c:when test="${requestScope.session.estaAutenticado()}">
				

  <h2>Col-app-dero: principal</h2>

<!-- menu -->

  
  
</c:when>    
<c:otherwise>
   <p>Es necesario iniciar sesión. </p> <a class="nav-item btn btn-primary" href="login">Login</a>
</c:otherwise>
</c:choose>


<jsp:include page="comun/pie.jsp"></jsp:include>


</body>
</html>
