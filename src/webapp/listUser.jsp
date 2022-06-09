<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Привет
  Date: 08.06.2022
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show All Persons</title>
</head>
<body>
<table border="1">
    <thead>
    <tr>
    <th>UserId</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Data</th>
    <th>Email</th>
    <th colspan="2">action</th>
    </tr>
    </thead>
    <tbody>
<jsp:useBean id="person1" type="model.Person" class="model.Person"  scope="page">
<c:forEach items="persons" var="person" >
    <tr>
        <td><c:out value="${person1.userId}"/></td>
        <td><c:out value="${person1.firstName}"/></td>
        <td><c:out value="${person1.lastName}"/></td>
        <td><fmt:formatDate pattern="MM/dd/yyyy"  value="${person1.data}"/></td>
        <td><c:out value="${person1.email}"/></td>
        <td><a href="PersonController?action=edit&userId=<c:out value="${Person1.userId}"/>">Update</a></td>
        <td><a href="PersonController?action=delete&userId=<c:out value="${Person1.userId}"/>">Delete</a></td>
    </tr>
    </tr>
</c:forEach>
</jsp:useBean>
    </tbody>
</table>
</body>
</html>
