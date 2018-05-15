<html>    
    <head>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
        <!--Nome de usuario de aluno: ${aluno.loginNome}-->
        <h3>
            Bem vindo ${aluno.nome} <br />
            Semestre atual do aluno: ${turma.semestre} <br />
            Curso: ${turma.curso} <br />
        </h3>      
    
    </head>
    <body>                        
        <table border="1">
            <tr>
                <th>Nome</th>                
            </tr>
            <c:forEach items="${disciplinas}" var="disciplina">
                <tr>                                                         
                    <td><a href="tarefas?idTurma=${turma.idTurma}&idDisciplina=${disciplina.idDisciplina}">${disciplina.nome}</a>                                
                </tr>
            </c:forEach>
        </table>                            
    </body>
</html>
