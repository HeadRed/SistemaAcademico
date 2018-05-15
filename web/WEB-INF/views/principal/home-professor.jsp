<html lang="pt-br">    
    <head>
        <meta charset="utf-8">
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>                
        <h3>
            Bem vindo ${professor.nome} <br />            
        </h3>              
    </head>
    <body>         
        <c:forEach items="${cursos}" var="curso">
            <a href="mostrarDisciplinas?curso=${curso.idCurso}">${curso.nome}</a> <br />
        </c:forEach>
    </body>
</html>