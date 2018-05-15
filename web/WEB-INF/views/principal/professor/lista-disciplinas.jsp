<html lang="pt-br">    
    <head>
        <meta charset="utf-8">
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>                
        <h3>
            Disciplinas ministradas <br />            
        </h3>              
    </head>
    <body>         
        <c:forEach items="${disciplinas}" var="disciplina">
            <a href="">${disciplina.nome}</a> <br />
        </c:forEach>
    </body>
</html>
