<%@ page import="org.hibernate.Session" %><%--
  Created by IntelliJ IDEA.
  User: УВД
  Date: 25.04.2017
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get" action="/employee">
    <input type="text" name="firstname">
    <input type="text" name="lastname">
    <input type="text" name="employeeId">
    <input type="submit" name="add" value="add">
    <input type="submit" name="takeList" value="showAll">
</form>
<%
    String login=null;
    String s=null;
    String sessions;
    try {
        login = (String) session.getAttribute("login");
        Cookie[] cookies = request.getCookies();
        sessions= (String) session.getAttribute("session");
//        for (Cookie cookie : cookies) {
//            cookie.getValue();
//            s = cookie.getValue();
//        }
//        if (!login.equals("asd") && login==null) {
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
//            requestDispatcher.forward(request, response);
//        }
        if(sessions==null){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(request, response);
        }
    }catch (NullPointerException e){
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(request,response);
    }
%>
<%=s%>
<%=login%>
<c:out value="${filter}"/>
<%=session%>
</body>
</html>
