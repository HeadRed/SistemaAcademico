<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Login</title>
        <meta charset="utf-8">
        <!--JSP-->
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <c:import url="/cabecalho.jsp"/>
        <style type="text/css">

        </style>
        <!--jQuery-->

        <!--bootstrap-->
        <link rel="stylesheet" href="style/css/bootstrap.min.css">
        <!--HTML5SHIV-->
        <!--[if lt IE 9]>
            <script src="js/html5shiv.js"></script>
        <![endif]-->

    </head>
    <body> 
        <div style="position: absolute; left: 35%;">
            <div class="col-sm-12">
                <h3>Logar</h3>

                <div class="form-group">
                    <input type="Email" class="form-control" id="email" placeholder="Digite seu email">   
                </div>

                <div class="form-group">
                    <input type="password" class="form-control" id="senha" placeholder="Digite sua senha">
                </div>
                <button type="submit" class="btn btn-primary">Entrar</button>
            </div>

        </div>
    </body>
</html>