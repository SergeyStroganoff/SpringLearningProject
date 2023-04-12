<%@ page contentType="text/html;charset=UTF-8" buffer="none" isThreadSafe="true" errorPage="error.jsp"
         language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Index page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="icon" href="${pageContext.request.contextPath}/icon/icons8-web-ios-16-glyph-32.png" type="image/x-icon">
</head>
<body>

<div class="container">
    <h1>Hello, welcome to Employee base</h1>
</div>
<!-- Not used in this project!!!
<a href="${pageContext.request.contextPath}/askName" type="" id="Go">AskName</a>
<br>
<a href="${pageContext.request.contextPath}/detail/add" type="" id="askDetail">AskDetail menu</a>
<br>
-->

<div class="container-sm table-responsive">
    <table class="table" aria-describedby="allEmpl">
        <thead class="bg-light">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>surname</th>
            <th>salary</th>
            <th>City</th>
            <th>phoneNumber</th>
            <th>email</th>
            <th>Operations</th>
        </tr>
        </thead>
        <tbody class="table-striped">
        <c:forEach var="empl" items="${allEmployee}">
            <c:url var="delete_action" value="/deleteEmployee">
                <c:param name="empid" value="${empl.id}">3</c:param>
            </c:url>
            <tr>
                <td>${empl.id}</td>
                <td>${empl.name}</td>
                <td>${empl.surname}</td>
                <td>${empl.salary}</td>
                <td>${empl.employeeDetail.city}</td>
                <td>${empl.employeeDetail.phoneNumber}</td>
                <td>${empl.employeeDetail.email}</td>
                <td>
                    <security:authorize access="hasRole('ADMIN')">
                    <div class="container-sm">
                        <input type="button" class="btn btn-link" value="Delete"  onclick="window.location.href='${delete_action}'">
                    </div>
                    </security:authorize>

                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div class="container-sm">
    <input type="button" class="btn btn-primary" value="Add Employee" onclick="window.location.href='addNewEmployee'">
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>

