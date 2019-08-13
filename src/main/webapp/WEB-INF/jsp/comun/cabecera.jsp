<%@ page import="es.jcyl.eclap.colapp.filtros.Sesion" %>



<nav class="navbar navbar-expand-lg navbar-dark bg-dark navbar-fixed-top" >

  <div class="container-fluid">
  
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#contenidobarra" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
  
    <span class="navbar-brand">
        <a class="navbar-brand" href="#"><i class='fa fa-bug'></i> Col-App-Dero</a>
    </span>
    
    
  
    <div class="collapse navbar-collapse  ml-2 navbar-right" id="contenidobarra">
     
    <ul class="navbar-nav mr-auto navbar-right">
    
      <li class="nav-item active">
        <a class="nav-link" href="inicio"><i class="fa fa-home"></i> Inicio <span class="sr-only">(current)</span></a>
      </li>
      
      <li class="nav-item">
		<a class="nav-link" href="cervezas"><i class="fas fa-beer"></i> Listados de Cervezas</a>
	 </li>


<%
  Sesion sesion = ((Sesion)request.getAttribute("session"));
  

  if( sesion.estaAutenticado() ) { 
%>
   	 
	 <li class="nav-item">
		 <a class="nav-link" href="notas_usuario"><i class="fa fa-sticky-note"></i> Mis notas</a>
	 </li>
<%
  }
%>
      
      <li class="nav-item">
        <a class="nav-link" href="#"><i class="fa fa-book"></i> Aprendizaje</a>
      </li>
      

<%
  if( sesion.estaAutenticado() ) {
%>
       <li class="nav-item">
        <a class="nav-link" href="logout"><i class="fas fa-sign-out-alt" aria-hidden="true"></i> Cerrar sesi&oacute;n</a>
      </li>     
<%
  } 
  else {
%>
       <li class="nav-item">
        <a class="nav-link" href="login"><i class="fa fa-user-circle" aria-hidden="true"></i> Inicio de sesi&oacute;n</a>
      </li>
<%
  }
%>       
            
     </ul>
    </div>
    
  </div>
</nav>