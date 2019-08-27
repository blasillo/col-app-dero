<%@ page isErrorPage="true"%>
<%@ page session="false"%>
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

        <div class="container">
            <div class="row justify-content-center mt-4">
                <h2 class="col-12 text-center">Me temo que has roto Col-App-Dero</h2>
            </div>
            
            <div class="row justify-content-center mt-4">
                <div class="alert alert-danger">
                    <p class="m-0">${errorMensaje}</p>
                </div>
            </div>
            <div class="row  mt-2">
                <c:if test="${ exception != null}">
                    <h3 class="col-12">Volcado de excepci&oacute;n:</h3>
                    <pre class="small">
                        ${pageContext.out.flush()}${exception.printStackTrace(pageContext.response.writer)}
                    </pre>
                </c:if>
            </div>	

        </div>         

</body>
</html>


