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
        <link href="<c:url value="/Resources/Theme/main.css" />" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
       <div class="wrapper">
        
        <ul>
            <li><a href="CreateBuilding.jsp">CreateBuilding</a></li>
            <li><a href="CreateReport.jsp">CreateReport</a></li>
        </ul>
        
        Hello,
        <%
            //out.print(session.getAttribute("loggedIn"));
            if(session.getAttribute("loggedIn")== null)
            {
                response.sendRedirect("index.html");
            }
            
            String name = (String) session.getAttribute("Name");
            out.print(name + ".");
        %>
        
      
        <br>
        <br>
     
            
        <form class="login" action="buildingServ2" method="POST"> 
            <img src="Logo.JPG" alt="Logo">
            <p class="title">Your company have the following buildings. <br> </p>
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
                    out.print("<INPUT TYPE=\"SUBMIT\" name=\"buildingChosen\" value=\""+buildingNames.get(i)+"\"><br>");  
                }
       
            }
        %>          
              
            
        </form>
        </div>
    </body>
</html>
