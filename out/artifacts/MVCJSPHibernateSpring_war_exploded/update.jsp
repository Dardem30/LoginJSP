<%--
  Created by IntelliJ IDEA.
  User: УВД
  Date: 25.04.2017
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/employee">
    <input type="text" name="firstname" value="<c:out value="${employee.firstname}"/>"/>
    <input type="text" name="lastname" value="<c:out value="${employee.lastname}"/>"/>
    <input type="text" readonly="readonly" name="employeeId" value="<c:out value="${employee.employeeId}"/>"/>
    <input type="submit" name="update" value="update">
</form>
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
</body>
</html>
