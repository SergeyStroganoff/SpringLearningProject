<%--
  Created by IntelliJ IDEA.
  User: Server
  Date: 02.08.2022
  Time: 0:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My View</title>
</head>
<body>
<h2>My fist View</h2>

<form action="${pageContext.request.contextPath}/showAnswer" method="get">
    <input type="text" name="askForm" placeholder="Enter your name">
    <input type="submit">
</form>
</body>
</html>
