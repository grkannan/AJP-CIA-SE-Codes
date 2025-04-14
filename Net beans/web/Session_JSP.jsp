<%-- 
    Document   : Session_JSP
    Created on : 14 Apr 2025, 10:36:36 pm
    Author     : Raguram
--%>

<%@page language="java" session="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Session</title>
    </head>
    <body>
        <h1>Session Code!</h1>
        <%
            String sname = request.getParameter("uname");
            out.println("<h2>Welcome " + sname + "</h2>");
            session.setAttribute("sessionname", sname);
        %>
        <a href="Output_Session.jsp">Click Here</a>
    </body>
</html>
