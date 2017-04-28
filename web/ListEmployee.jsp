<%--
  Created by IntelliJ IDEA.
  User: УВД
  Date: 25.04.2017
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/PoiskController">
    <input type="text" name="findById">
    <select name="select">
        <option value="findById">find by id</option>
        <option value="findByName">find by name</option>
        <option value="findByLastname">find by lastname</option>
    </select>
    <input type="submit" name="findByName" value="поиск">
</form>

<table>
    <tr>
        <th>Id</th>
        <th>name</th>
        <th>lastname</th>
    </tr>
    <c:forEach items="${list}" var="list">
        <tr>
            <td>${list.employeeId}</td>
            <td>${list.firstname}</td>
            <td>${list.lastname}</td>
            <td><a href="EmployeeController?action=update&employeeId=<c:out value="${list.employeeId}"/>">update</a></td>
            <td><a href="EmployeeController?action=delete&employeeId=<c:out value="${list.employeeId}"/>">delete</a></td>
        </tr>
    </c:forEach>
    <%
        String login= (String) session.getAttribute("login");
        Cookie[] cookies= request.getCookies();
        String s=null;
        for(Cookie cookie: cookies){
            cookie.getValue();
            s=cookie.getValue();
        }
        if(!s.equals("asd")){
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(request,response);
        }
    %>
</table>
</body>
</html>
