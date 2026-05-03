<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>NASA APOD - Welcome</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/index.css">
</head>
<body>
    <div class="container">
        <h1>Bem vindo ao ProjetoApod!</h1>
        <p>Insira uma data abaixo para descobrir o cosmos.</p>

        <form class="search-form" method="POST" action="${pageContext.request.contextPath}/teste">
            <input placeholder="DD/MM/AAAA (Sem barras)" type="text" name="dateUser" maxlength="8" required>
            <button type="submit">Pesquisar</button>
        </form>
    </div>
</body>
</html>