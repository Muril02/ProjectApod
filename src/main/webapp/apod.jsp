<%@ page contentType="text/html;charset=UTF-8" language="java"
    isELIgnored="false"
%>
<html>
<body>

    <h1>${apiData.getTitle()}</h1>
    <img src="${apiData.getUrl()}" alt="Astronomy Picture">
    <p>${apiData.getExplanation()}</p>
    <small>Date: ${apiData.getDate()}</small>
</body>
</html>
