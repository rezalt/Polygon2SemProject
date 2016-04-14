<%-- 
    Document   : BuildingJSP
    Created on : Apr 14, 2016, 1:23:43 PM
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
        <h1>Hello World!</h1>
        the building is:
        <%
            out.print(request.getAttribute("buildingChosen"));
            %>
            GB yoyo
    </body>
</html>
