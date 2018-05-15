<html>    
    <body>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        Lista de atividades: 
        <table>
            <c:forEach items="${tarefas}" var="tarefa">
                <tr>
                    <td><a href="tarefa?idTurma=${idTurma}&idDisciplina=${idDisciplina}"
                           onclick="">${tarefa.nome}</a></td>                                                                                
                </tr>
            </c:forEach>
        </table>
        <a href="home">Voltar</a>
    </body>
</html>