<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <!--JSP-->
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Pagina do Aluno</title>
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <!--Meu CSS-->
        <link href="${pageContext.request.contextPath}/resources/css/cover.css" rel="stylesheet"> 
    </head>
    <body class="text-center">
        <div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
            <c:import url="../cabecalho.jsp"/>
            <h5>
                Bem vindo ${aluno.nome} <br />
                Semestre atual do aluno: ${turma.semestre} <br />
                Curso: ${turma.curso} <br />
            </h5>
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Professor</th>
                        <th scope="col">Atividade</th>
                        <th scope="col">Descri?o</th>
                        <th scope="col">Acessar disciplina</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${disciplinas}" var="disciplina">
                        <tr>
                            <th scope="row">1</th>
                            <td scope="col">${disciplina.professor}</td>                            
                            <td scope="col">${disciplina.nome}</a>                                
                            <td><p>sei l?/p></td>
                            <td><a class="btn btn-primary" href="tarefas?idTurma=${turma.idTurma}&idDisciplina=${disciplina.idDisciplina}" role="button">Logar</a></td>                        
                        </tr>
                    </c:forEach>                    
                </tbody>
            </table>
            <c:import url="../rodape.jsp"/>    
        </div>
    </body>
</html>