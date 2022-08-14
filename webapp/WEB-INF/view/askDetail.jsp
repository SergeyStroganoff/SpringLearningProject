<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Server
  Date: 08.08.2022
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ask Detail Page</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/detail/showResult" method="get" modelAttribute="detail">
    Phone <form:input path="phone"/>
    <form:errors path="phone"/>
    <br>
    Email <form:input path="email"/>
    <form:errors path="email"/>
    <br>
    City <form:select path="city">
    <form:option value="Moskow" label="Moskow"/>
    <form:option value="Tver" label="TVR"/>
    <form:option value="Leningrad" label="Leningrad"/>
</form:select>
    <br><br>
    <input type="submit" value="Ok">
</form:form>
</body>
</html>
