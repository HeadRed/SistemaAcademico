<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Sistema Academico</title>
        <meta charset="utf-8">
        <!--JSP-->
        <!-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> -->
        <!--CSS-->
        <style type="text/css">
            .thumbnails {
                text-align:center;
            }

            .thumbnails > li {
                display: inline-block;
                *display:inline; /* ie7 fix */
                float: none; /* this is the part that makes it work */
            }
            #centro{
                position: absolute; 
                left: 19%; 
            }
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
        <!--NAV-->
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">
                        <img alt="Brand" src="img/Creeper.png" style="width: 35px; height: 35px; text-align: center;">
                    </a>
                </div>
            </div>
        </nav>
        <!--Fim da nav-->
        <div id="centro" class="row">
            <div class="col-sm-8 col-md-8">
                <div class="thumbnail " style="text-align: center;">
                    <img src="img/educacao.gif" alt="Imagem Educação">
                    <div class="caption">
                        <h3>Sistema Academico</h3>
                        <p>Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI,
                            quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos.</p>
                        <p><a href="login.jsp" class="btn btn-primary" role="button">Login</a> <a href="cabecalho.jsp" class="btn btn-default" role="button">Cabeçalho</a></p>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>