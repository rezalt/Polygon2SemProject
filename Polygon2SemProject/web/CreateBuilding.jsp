<%-- 
    Document   : CreateBuilding
    Created on : 31-03-2016, 13:49:47
    Author     : Henrik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="<c:url value="/Resources/Theme/Index.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Building/building.css" />" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if (session.getAttribute("loggedIn") == null)
            {
                session.setAttribute("text", "You need to log in first.");
                response.sendRedirect("Login.jsp");
            }
        %> 
        <div class="wrapper">
            <ul>
                <li><a href="Login.jsp">Login</a></li>
                <li><a href="MainPage.jsp">MainPage</a></li>
                <li><a href="CreateReport.jsp">CreateReport</a></li>
                <li><a href="CreateUser.jsp">CreateUser</a></li>
            </ul>

            <h1>
                Please insert building info.
            </h1>

            <form class="login" name="form2" action="BuildingServlet" method="get"> <img src="Logo.JPG" alt="Logo">
                <input type="hidden" name="building" value="" />
                <p class="title">Create building
                <div align="center">
                    <table border="0">
                        <tr>  
                            <td>
                                <input type="text" placeholder="Building name" name="buildingName" required="">
                            </td>  
                            <td>
                                <input type="text" placeholder="Address" name="address" required="">
                            </td>
                        </tr>
                        <tr>  
                            <td>
                                <input type="number" placeholder="buildingCondition" name="buildingCondition" required="" min="0" max="3" title= "From 0-3 where 0 is the best possible condition.">
                            </td>
                            <td>
                                <input type="text" placeholder="Owner" name="buildingCompany" required="" value="<c:out value="${buildingCompany}"/>"  >
                            </td>
                        </tr>
                        <tr>  
                            <td>
                                <input type="number" placeholder="parcelNr" name="parcelNr" required="">
                            </td>
                            <td>
                                <input type="number" placeholder="Size in m3" name="Size" required="">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="number" placeholder="Zipcode" name="Zipcode" required="">
                            </td>
                        </tr>
                        <tr>  
                            <td>
                                <button type="submit" id="button3" value="create" onclick="myFunction()">
                                    <i class="spinner"></i>
                                    <span class="state">Submit</span> 
                                </button> 
                            </td>
                        </tr>
                    </table>  
                </div>    
            </form>
            <footer><a target="blank"> Gruppe 4 - A </a></footer>
        </p>

        <%
            String text = (String) session.getAttribute("text");
            if (text == null)
            {
                session.setAttribute("text", "");
            }
        %>
        <%=session.getAttribute("text")%>
    </div> 

    <script>
        function myFunction()
        {
            document.form2.building.value = 'create';
        }
    </script>
</body>
</html>
