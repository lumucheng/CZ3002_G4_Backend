<%-- 
    Document   : response
    Created on : Sep 17, 2015, 5:20:02 PM
    Author     : Mucheng
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Message</title>
    </head>
    <body>
    <center>
        <h3><%=request.getAttribute("Message")%></h3>
        <a href="viewqns.jsp">View Dataset Questions</a>
    </center>
</body>
</html>
