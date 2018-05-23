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
            <h3>
            Bem vindo ${aluno.nome} <br />
            Semestre atual do aluno: ${turma.semestre} <br />
            Curso: ${turma.curso} <br />
            </h3>
        <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Professor</th>
                        <th scope="col">Atividade</th>
                        <th scope="col">Descrição</th>
                        <th scope="col">Acessar disciplina</th>
                    </tr>
                </thead>
                    <tbody>
                        <tr>
                            <th scope="row">1</th>
                                <td>Quele Quiroz</td>
                                <td><c:forEach items="${disciplinas}" var="disciplina">
                                <tr>                                                         
                                <td><a href="tarefas?idTurma=${turma.idTurma}&idDisciplina=${disciplina.idDisciplina}">${disciplina.nome}</a>                                
                                </tr>
                                </c:forEach></td>
                                
                                <td>Integrais definidas</td>
                                <td><a href="#" class="badge badge-secondary">Entrar</a></td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                                <td>Alan David</td>
                                <td>Banco de dados</td>
                                <td>Modelagem</td>
                                <td><a href="#" class="badge badge-secondary">Entrar</a></td>

                        </tr>
                        <tr>
                            <th scope="row">3</th>
                                <td>Marco Antonio</td>
                                <td>Redes de computadores</td>
                                <td>Pacotes</td>
                                <td><a href="#" class="badge badge-secondary">Entrar</a></td>
                        </tr>
                    </tbody>
            </table>






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
    </div>
</body>
</html>