<%-- 
    Document   : MainPage
    Created on : Apr 12, 2016, 12:12:43 PM
    Author     : JAJAJABLESES
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="<c:url value="/Resources/Theme/Index.css"/>" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <img src="Logo.JPG" alt="Logo">
        <ul>
            <li><a href="CreateBuilding.jsp">CreateBuilding</a></li>
            <li><a href="CreateReport.jsp">CreateReport</a></li>
        </ul>
        
        Hello mr 
        <%
            //out.print(session.getAttribute("loggedIn"));
            if(session.getAttribute("loggedIn")== null)
            {
                response.sendRedirect("index.html");
            }
            
            String name = (String) session.getAttribute("Name");
            out.print(name);
        %>
        
        You have the following buildings;
        <br>
        <br>
        <%
           //out.print(session.getAttribute("username"));
            if(session.getAttribute("loggedIn")== null)
            {
                response.sendRedirect("index.html");
            }
            else
            {
                ArrayList<String> buildingNames = new ArrayList();
                buildingNames = (ArrayList<String>) session.getAttribute("buildingNames");
                for(int i = 0; i < buildingNames.size(); i++)
                {
                    out.print(buildingNames.get(i)+"<br>");  
                }
            }
        %>
                    
    </body>
</html>
