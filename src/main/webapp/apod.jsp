<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>${apiData.getTitle()} - APOD</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/index.css">
</head>
<body>
    <div class="container">
        <h1>${apiData.getTitle()}</h1>
        <img class="apod-image" src="${apiData.getUrl()}" alt="Astronomy Picture: ${apiData.getTitle()}">

        <small>Date: ${apiData.getDate()}</small>
        <p>${apiData.getExplanation()}</p>

        <form class="search-form" method="POST" action="${pageContext.request.contextPath}/teste">
            <input placeholder="DD/MM/AAAA (Sem barras)" type="text" name="dateUser" maxlength="8" required>
            <button type="submit">Pesquisar nova data</button>
        </form>

        <div class="nav-buttons">
            <form method="POST" action="${pageContext.request.contextPath}/teste">
                <input type="hidden" name="tipoOperacao" value="-">
                <input type="hidden" name="dateNow" value="${apiData.getDate()}">
                <button type="submit" title="Previous Day"> - </button>
            </form>

            <form method="POST" action="${pageContext.request.contextPath}/teste">
                <input type="hidden" name="tipoOperacao" value="+">
                <input type="hidden" name="dateNow" value="${apiData.getDate()}">
                <button type="submit" title="Next Day"> + </button>
            </form>
        </div>
    </div>
</body>
</html>