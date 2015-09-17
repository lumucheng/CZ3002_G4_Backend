<%-- 
    Document   : InsertQns
    Created on : Sep 17, 2015, 4:56:14 PM
    Author     : Mucheng
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Question</title>
    </head>
    <body>
    <center>
        <h1>File Upload to Database Demo</h1>
        <form method="post" action="questionServlet" enctype="multipart/form-data">
            <table border="0">
                <tr>
                    <td>Answer: </td>
                    <td><input type="text" name="answer" size="50"/></td>
                </tr>
                <tr>
                    <td>Tag: </td>
                    <td><select name="tag">
                            <option value="Animal">Animal</option>
                            <option value="Celebrities">Celebrities</option>
                            <option value="Brands">Brands</option>
                        </select></td>
                </tr>
                <tr>
                    <td>Image: </td>
                    <td><input type="file" name="image" size="50"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Save">
                    </td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>
