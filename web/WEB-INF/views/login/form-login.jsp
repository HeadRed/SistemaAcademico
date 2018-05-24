<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">        
        <title>Login</title>
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <!-- Custom styles for this template -->        
        <link href="${pageContext.request.contextPath}/resources/CSS/cover.css" rel="stylesheet">
    </head>

    <body class="text-center"> 
        <div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
        <c:import url="../cabecalho.jsp"/>
        
        <form class="form-signin" action="autenticar" method="post">                                    
            <img class="mb-4" src="https://blog.clippingcacd.com.br/wp-content/uploads/2015/08/Imagem_para_texto_Bruno.png" alt="" width="72" height="72">
            <h1 style="color: white;" class="h3 mb-3 font-weight-normal">Entrar</h1>
            
        <c:if test="${erro eq true}">
            <label style="color: red">Nome de usuário ou senha incorretos</label>
        </c:if>
            
        <label for="inputEmail" class="sr-only">Email</label>
        <input type="email" name="loginNome" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Senha</label>
        <input type="password" name="loginSenha" class="form-control" placeholder="Password" required>
        <div class="checkbox mb-3">
                <!--label>
                    <input type="checkbox" style="color: white" value="Lembra-me"> Lembra
                </label-->
        </div>
        <button class="btn btn-lg btn-primary btn-block btn btn-lg btn-secondary" type="submit">Entrar</button>
        <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
        </form> 
        <c:import url="../rodape.jsp"/>
    </div>
    </body>

</html>
