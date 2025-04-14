<%-- 
    Document   : Output_Session
    Created on : 14 Apr 2025, 10:54:09 pm
    Author     : Raguram
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Session Output</title>
    </head>
    <body>
        <%
            String n = (String) session.getAttribute("sessionname");
        %>
        <h1>Hello <% out.println(n);%></h1>
    </body>
</html>
