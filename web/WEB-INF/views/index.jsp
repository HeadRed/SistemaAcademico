<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <!--JSP-->
        
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
        
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">        
        <title>Sistema Academico</title>
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        
        <!-- Custom styles for this template -->                                       
        <link href="${pageContext.request.contextPath}/resources/CSS/cover.css" rel="stylesheet">
        
    </head>
    <body class="text-center"> 
            <div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
                <c:import url="cabecalho.jsp"/>
                <main role="main" class="inner cover">
                    <h1 class="cover-heading">Sistema Academico</h1>
                    <p class="lead">
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam pellentesque tortor sit amet tincidunt lobortis. Etiam vestibulum posuere ex, sit amet tincidunt ex convallis id.
                    </p>
                    <p class="lead">
                        <a href="entrar" class="btn btn-lg btn-secondary">Entrar</a>
                    </p>
                </main>
                <c:import url="rodape.jsp"/>
            </div>
    </body>
</html>