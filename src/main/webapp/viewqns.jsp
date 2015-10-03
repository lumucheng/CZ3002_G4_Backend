<%-- 
    Document   : viewqns
    Created on : Oct 3, 2015, 1:44:58 PM
    Author     : Mucheng
--%>

<%@page import="com.ntu.cz3002.manager.QuestionManager"%>
<%@page import="com.ntu.cz3002.entity.Question"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>View Dataset Questions</title>
        <link href="css/demo_page.css" rel="stylesheet" type="text/css" />
        <link href="css/demo_table.css" rel="stylesheet" type="text/css" />       
        <link href="css/demo_table_jui.css" rel="stylesheet" type="text/css" />
        <link href="css/jquery-ui-1.8.24.custom.css" rel="stylesheet" type="text/css" media="all" />
        <!-- Scripts -->
        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="js/jquery.dataTables.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $("#sales").dataTable({
                    "sPaginationType": "full_numbers",
                    "bJQueryUI": true
                });
            });
        </script>
    </head>
    <body id="dt_example">
        <div id="container">
            <h1>Dataset Questions</h1>
            <div id="demo_jui">
                <table id="sales" class="display">
                    <thead>
                        <tr>
                            <th><u>ID</u></th>
                            <th><u>Tag</u></th>
                            <th><u>Image</u></th>
                            <th><u>Answer</u></th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            QuestionManager mgr = new QuestionManager();
                            for (Question question : mgr.getRandomQuestions(200)) {%>
                        <tr>
                            <td><%=question.getId()%></td>
                            <td><%=question.getTag()%></td>
                            <td><img src=<%=question.getImage_url()%> 
                                     alt=<%=question.getImage_name()%>
                                     height="240" width="240"></td>
                            <td><%=question.getAnswer()%></td>
                        </tr>
                        <% }%>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
