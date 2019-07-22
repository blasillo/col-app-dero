<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html >
<html lang="es">
<head>
<title>Col-App-Dero</title>


<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" >
<link rel="stylesheet" href="fontawesome/css/all.min.css">
<link rel="stylesheet" href="fontawesome/css/fontawesome.min.css">


<script src="js/jquery-3.2.1.slim.min.js"  crossorigin="anonymous"></script>
<script src="js/popper.min.js" crossorigin="anonymous"></script>
<script src="js/bootstrap.min.js" crossorigin="anonymous"></script>




<style>
    body {
      position: relative; /* For scrollyspy */
      padding-top: 0px; /* Account for fixed navbar */
    }
    
    
    
    .login-page {
		  width: 360px;
		  padding: 8% 0 0;
		  margin: auto;
		}
		
	.form {
	  position: relative;
	  z-index: 1;
	  background: #FFFFFF;
	  max-width: 360px;
	  margin: 0 auto 100px;
	  padding: 45px;
	  text-align: center;
	  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
	}
	
	.form input {
	  font-family: "Roboto", sans-serif;
	  outline: 0;
	  background: #f2f2f2;
	  width: 100%;
	  border: 0;
	  margin: 0 0 15px;
	  padding: 15px;
	  box-sizing: border-box;
	  font-size: 14px;
	}
	.form button {
	  font-family: "Roboto", sans-serif;
	  text-transform: uppercase;
	  outline: 0;
	  background: #4CAF50;
	  width: 100%;
	  border: 0;
	  padding: 15px;
	  color: #FFFFFF;
	  font-size: 14px;
	  -webkit-transition: all 0.3 ease;
	  transition: all 0.3 ease;
	  cursor: pointer;
	}
	.form button:hover,.form button:active,.form button:focus {
	  background: #43A047;
	}
</style>

</head>


<body>


<jsp:include page="comun/cabecera.jsp"></jsp:include>

<%
  if(session.getAttribute("tieneSesion")!=null) { 
%>


<h2>Col-app-dero: principal</h2>

<!-- menu -->



 
 
  <jsp:include page="comun/pie.jsp"></jsp:include>
  
<%
} // 
else {
    out.print("Sin sesión!");
    
}

%>

</body>
</html>
