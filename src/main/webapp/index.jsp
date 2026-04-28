<%@ page contentType="text/html;charset=UTF-8" language="java"
    isELIgnored="false"
%>
<html>
<body>

    <h1>${apiData.getTitle()}</h1>
    <img src="${apiData.getUrl()}" alt="Astronomy Picture">
    <p>${apiData.getExplanation()}</p>
    <small>Date: ${apiData.getDate()}</small>
    <p>Teste</p>

    <form method="POST" action="${pageContext.request.contextPath}/teste">
        <input placeholder="Date of the day" type="text" name="dateUser"></input>
        <button type="submit"> Enviar </button>
    </form>
</body>
</html>
