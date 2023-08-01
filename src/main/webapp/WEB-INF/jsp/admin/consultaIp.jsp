
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Col-App-Dero Admin</title>
    <link rel="stylesheet" type="text/css" href="../../css/bootstrap.min.css" >
    <link rel="stylesheet" href="../../fontawesome/css/all.min.css">
    <link rel="stylesheet" href="../../fontawesome/css/fontawesome.min.css">

    <link rel="stylesheet" type="text/css" href="../../css/colapp.css" >

</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Col-App-Dero Admin</a>
        </div>
    </div>
</nav>

<div class="container" style="min-height: 500px">

    <div class="starter-template">
        <h2>Consulta IP</h2>

        <form class="form-horizontal" id="formulario-ip">
            <div class="form-group form-group-lg">
                <label class="col-sm-2 control-label">Dirección IP</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="ip" name="ip" required pattern="^([0-9]{1,3}\.){3}[0-9]{1,3}$"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" id="bth-search"
                            class="btn btn-primary btn-lg">Consultar
                    </button>
                </div>
            </div>
        </form>


        <div id="resultado"></div>

    </div>

</div>

<script src="../../js/jquery-3.2.1.slim.min.js"></script>
<script src="../../js/jquery-3.2.1.min.js"></script>
<script src="../../js/popper.min.js" ></script>
<script src="../../js/bootstrap.min.js"></script>


<script>
    $(document).ready(function () {
        $("#formulario-ip").submit(function (event) {
            event.preventDefault();
            fire_ajax_submit();
        });
    });

    function fire_ajax_submit() {
        var search = {}
        search["ip"] = $("#ip").val();
        $("#btn-search").prop("disabled", true);

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/colapp/admin/utiles/ping",
            data: $("#ip").val(), /*JSON.stringify(search),*/
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {

                var json = "<h4>Respuesta </h4><pre>"
                    + JSON.stringify(data, null, 4) + "</pre>";
                $('#resultado').html(json);

                console.log("EXITO : ", data);
                $("#btn-search").prop("disabled", false);

            },
            error: function (e) {
                var json = "<h4>Respuesta</h4>&lt;pre&gt;"
                    + e.responseText + "&lt;/pre&gt;";
                $('#resultado').html(json);

                console.log("ERROR : ", e);
                $("#btn-search").prop("disabled", false);

            }
        });

    }

</script>

</body>
</html>
