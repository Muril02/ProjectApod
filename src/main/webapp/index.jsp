<%@ page contentType="text/html;charset=UTF-8" language="java"
    isELIgnored="false"
%>
<html>
<link rel="stylesheet" href="./src/main/webapp/styles/index.css">
<body>

    <div>
        <h1> Bem vindo ao ProjectApod!</h1>
    </div>
    <form method="POST" action="${pageContext.request.contextPath}/teste">
        <input placeholder="DD/MM/YYYY (Sem as barras)" type="text" name="dateUser"></input>
        <button type="submit"> Enviar </button>
    </form>
</body>
</html>
