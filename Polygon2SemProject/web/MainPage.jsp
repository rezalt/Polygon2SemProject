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

        <c:if test="${updateBuildingList == 1}">
            <c:redirect url="PolyServlet?user=updateBuildingList"/>
        </c:if>
        
        
        <div class="wrapper">

            
            
            <ul>
                <li><a href="CreateBuilding.jsp">CreateBuilding</a></li>
                <li><a href="CreateReport.jsp">CreateReport</a></li>
            </ul>
            <br>


            Hello,
            <%-- 
            Redirects to index if the user is not logged in.
            If logged in, the username will be shown. 
            Should not even be here without being logged in.
            --%>
            <c:if test="${empty loggedIn}">
                <c:redirect url="login.jsp"/>
            </c:if>
            <c:out value="${Name}."/>


            <br>
            <br>


            <form name="buildingList" class="login" action="buildingServ2" method="POST"> 
                <img src="Logo.JPG" alt="Logo">
                <p class="title">Your company has the following buildings. <br> </p>

                <%-- Error message shown here, if any. --%>
                <c:if test="${empty text}">
                    <c:set var="text" value="" scope="session"/>
                </c:if>
                <c:out value="${text}"/>

                <%-- List of buildings --%>       
                <c:forEach var="buildingName" items="${sessionScope.buildingNames}">

                    <input type="submit" id="buildingName" name="buildingChosen" value="<c:out value="${buildingName}"/>">

                </c:forEach>

            </form>
        </div>
    </body>
</html>
