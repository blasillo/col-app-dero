<%@ page contentType="text/html; charset=ISO-8859-1" session="false" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="utf-8">
	
	
	
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
		<h2 class="col-12 text-center">Bienvenidos a Col-App-Dero</h2>
		<h5 class="col-12 text-center">Una aplicaci&oacute;n vulnerable con fines did&aacute;cticos</h5>
	</div>
	
	<div class="row justify-content-center align-items-center mt-5">
		<div class="col-10 col-md-6 text-center">
			<img src="imagenes/colador.png" width="40%" class="img-fluid rounded-circle mx-auto">
		</div>
		<div class="col-10 col-md-6 p-2 pl-4">
			<p>Col-App-Dero es una aplicaci&oacute;n deliberadamente insegura que permite a los desarrolladores 
			   probar las vulnerabilidades que se encuentran frecuentemente en aplicaciones Java.</p>
			   
			<p>El &uacute;nico prop&oacute;sito es aprender sobre las vulnerabilidades de seguridad y comprender qu&eacute; sucede cuando incluso un peque&ntilde;o c&oacute;digo malicioso se introduce en las aplicaciones.</p>
			
			<p>Garcias por el inter&eacute;s</p> 
		</div>
	</div>
	
	
	<div class="row justify-content-center mt-5 mb-5">
		<h4 class="col-12 text-center">Col.App.Dero es un proyecto personal</h4>
		<div class="col-12 text-center">
			<p>Si tienes cualquier sugerencia, queja, opini&oacute;n ... </p>
		</div>
	</div>	
 
 </div>
 
 <jsp:include page="comun/pie.jsp"></jsp:include>
  
  <script src="js/jquery-3.2.1.slim.min.js"></script>
  <script src="js/popper.min.js" ></script>
  <script src="js/bootstrap.min.js"></script>
</body>
</html>