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

<br>
<br>
<br>

<div class="container-fluid">
    <form:form action="${pageContext.request.contextPath}/saveEmployee" method="get" modelAttribute="newEmployeeDTO">
        <div class="row">
            <div class="col-md-auto">
                Name <form:input path="name"/>
                <form:errors path="name"/>
            </div>
            <div class="col-md-auto">
                Surname <form:input path="surname"/>
                <form:errors path="surname"/>
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-auto">
                Salary <form:input path="salary"/>
                <form:errors path="salary"/>
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-auto">
                City <form:input path="employeeDetail.city"/>
                <form:errors path="employeeDetail.city"/>
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-auto">
                Email <form:input path="employeeDetail.email"/>
                <form:errors path="employeeDetail.email"/>
            </div>
            <div class="col-md-auto">
                PhoneNumber <form:input path="employeeDetail.phoneNumber"/>
                <form:errors path="employeeDetail.phoneNumber"/>
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-auto">
                Department <form:select path="department.departmentName">
                <form:options items="${departmentsDTO}"/>
            </form:select>
            </div>
        </div>
        <br>
        <input type="submit" class="btn btn-primary" value="Ok">
    </form:form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
