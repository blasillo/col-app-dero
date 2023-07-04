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

<div class='container' style='min-height: 450px'>
    <div class='row'>
        <div class='col-md-12'>

             <h2 class="align-content-center">Subir archivos</h2>

            <form action = "subir-archivo" method = "post" enctype = "multipart/form-data">
                <input type = "file" name = "archivo" size = "50" />
                <br />
                <input type = "submit" value = "Subir archivo" />
            </form>

            <br>
            <br>





        </div>
    </div>
</div>


<jsp:include page="comun/pie.jsp"></jsp:include>

</body>
</html>
