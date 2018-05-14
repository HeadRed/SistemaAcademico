<html>
    <body>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <table>
            <c:forEach items="${tarefas}" var="tarefa">
                <tr>
                    <td>${tarefa.nome}</td>                    
                </tr>
            </c:forEach>
        </table>
        <a href="principal">Voltar</a>
    </body>
</html>