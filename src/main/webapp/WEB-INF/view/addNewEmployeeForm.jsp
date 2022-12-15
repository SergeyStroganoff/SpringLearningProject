<%--
  Created by IntelliJ IDEA.
  User: Server
  Date: 18.09.2022
  Time: 1:01
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" buffer="none" isThreadSafe="true" errorPage="error.jsp"
         language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"
<body>
<%--
private String name;
private String surname;
private int salary;
private DetailDTO employeeDetail;
private DepartmentDTO department;
private transient List<SkillDTO> skillList;
--%>

<form:form action="${pageContext.request.contextPath}/saveEmployee" method="get" modelAttribute="newEmployee">
    Name <form:input path="name"/> <form:errors path="name"/>
    <br>
    <br>
    Surname <form:input path="surname"/><form:errors path="surname"/>
    <br>
    <br>
    Salary <form:input path="salary"/><form:errors path="salary"/>
    <br>
    <br>
    City <form:input path="employeeDetail.city"/><form:errors path="employeeDetail.city"/>
    <br>
    <br>
    Email <form:input path="employeeDetail.email"/><form:errors path="employeeDetail.email"/>
    <br>
    <br>
    PhoneNumber <form:input path="employeeDetail.phoneNumber"/><form:errors path="employeeDetail.phoneNumber"/>
    <br>
    Department <form:select path="department">
    <form:options items="${departments}"/>
</form:select>
    <br><br>
    <input type="submit" value="Ok">
</form:form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
