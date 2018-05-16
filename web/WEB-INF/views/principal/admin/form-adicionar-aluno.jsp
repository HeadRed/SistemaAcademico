<html>
    <body>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        
        <form action="cadastrarAluno" method="post">
            Nome de usuario: <input name="loginNome" type="text" value=""/> <br />
            Senha: <input name="loginSenha" type="password" value=""/> <br />
            Nome do aluno: <input name="nome" type="text" value=""/> <br />
            Turma do aluno: 
            <select name="turma">
                <c:forEach items="${turmas}" var="turma">
                    <option value="${turma.idTurma}">${turma.curso} / ${turma.semestre}</option>
                </c:forEach>
            </select>
            <br />
            <input type="submit" value="cadastrar"/>
        </form>
    </body>
</html>
