<%-- 
    Document   : CreateUser
    Created on : Mar 31, 2016, 12:19:59 PM
    Author     : JAJAJABLESES
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Hello and welcome, please insert your user settings.</h1>
        <form action="PolyServlet" method="post">
        username<input type="text" name="username"><br>
        password<input type="text" name="password"><br>
        submit<input type="submit" name="submit" value="do_this">  <%-- Der stod "create" som value før. --%>
        </form>
        
            

    </body>
</html>
