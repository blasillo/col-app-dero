<%@ page contentType="text/html; charset=ISO-8859-1" %>

<!DOCTYPE html>
<html lang="es">
<head>
	<title>Col-App-Dero</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	
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

 <div class='container' style='min-height: 450px'>
    <div class='row'>
    <div class='col-md-12'>
	    <div class="login-page">
	      <div class="form">
	       
	       <form class="login-form" action="autenticacion" method="get">
	          <h2>Inicio de sesi&oacute;n</h2>
	          
	          <div class="input-container">
	            <i class="fa fa-envelope icon"></i>
 	            <input class="input-field" type="text" name="login" placeholder="email" value="${login}"/>		       
		      </div> 
		      
		      <div class="input-container">
	            <i class="fa fa-key icon"></i>
		        <input class="input-field" type="password" name="password" placeholder="contraseņa"/>
		      </div>
		      
		      <c:if test="${mensaje.length() > 0}">
					<div class="row justify-content-center mt-4">
						<div class="alert alert-danger">
							<p class="m-0">${mensaje}</p>
						</div>
					</div>
			  </c:if>
		     
		      
		      <button>Iniciar sesi&oacute;n</button>
		      
		      
		    </form>
	       </div> 
         </div>
    </div>
    </div>     
 </div>


<jsp:include page="comun/pie.jsp"></jsp:include>

</body>
</html>




