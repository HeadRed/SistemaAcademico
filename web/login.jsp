<html>
    <body>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <c:import url="/cabecalho.jsp"/>

        <h2>
            <form action="index.jsp" method="post" >
                Usuario: <input type="text" name="usuario"/><br />
                Senha: <input type="password" name="senha"/><br />
                <button type="submit">Entrar</button><br />
            </form>
        </h2>

    </body>
</html>