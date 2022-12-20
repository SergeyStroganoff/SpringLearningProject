<%--
  Created by IntelliJ IDEA.
  User: Server
  Date: 08.08.2022
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Result off operation</title>
</head>
<body>
<h2>Operation completed ${operationResult} </h2>

<label>${detail.city}</label>
<br>
<br><label>${detail.email}</label>
<br>
<br><label>${detail.phoneNumber}</label>

<a href="${pageContext.request.contextPath}/" type="" id="Go to index page">Go to main page</a>
</body>
</html>
