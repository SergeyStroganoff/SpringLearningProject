<%@ page contentType="text/html;charset=UTF-8" buffer="none" isThreadSafe="true" errorPage="error.jsp" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Server
  Date: 08.08.2022
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="icon" href="${pageContext.request.contextPath}/icon/icon-3914464.png" type="image/x-icon">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/icon/icon-3914464.png" type="image/x-icon">
    <title>Ask Detail Page</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/detail/showResult" method="get" modelAttribute="detail">
    Phone <form:input path="phoneNumber"/>
    <form:errors path="phoneNumber"/>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
