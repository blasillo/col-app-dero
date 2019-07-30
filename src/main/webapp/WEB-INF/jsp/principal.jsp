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
