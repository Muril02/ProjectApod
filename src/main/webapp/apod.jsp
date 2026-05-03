<%@ page contentType="text/html;charset=UTF-8" language="java"
    isELIgnored="false"
%>
<html>
<body>

    <h1>${apiData.getTitle()}</h1>
    <img src="${apiData.getUrl()}" alt="Astronomy Picture">
    <p>${apiData.getExplanation()}</p>
    <small>Date: ${apiData.getDate()}</small>

    <form method="POST" action="${pageContext.request.contextPath}/teste">
        <input placeholder="DD/MM/YYYY (Sem as barras)" type="text" name="dateUser"></input>
        <button type="submit"> Enviar </button>
    </form>

    <form method="POST" action="${pageContext.request.contextPath}/teste">
        <input type="hidden" name="tipoOperacao" value="+"></input>
        <input type="hidden" name="dateNow" value="${apiData.getDate()}"></input>
        <button type="submit"> + </button>
    </form>
    <form method="POST" action="${pageContext.request.contextPath}/teste">
        <input type="hidden" name="tipoOperacao" value="-"></input>
        <input placeholder="Date of the day" type="hidden" name="dateNow" value="${apiData.getDate()}"></input>
        <button type="submit"> - </button>
    </form>
</body>
</html>
