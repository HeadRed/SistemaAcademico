<html>    
    <body>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        Lista de atividades: <br />
        <c:forEach items="${tarefas}" var="tarefa">                
            <a href="tarefa?idTurma=${idTurma}&idDisciplina=${idDisciplina}">${tarefa.nome}</a> <br />                
        </c:forEach>
        <a href="homeAluno">Voltar</a>
    </body>
</html>