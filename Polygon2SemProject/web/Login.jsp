<%-- 
    Document   : CreateUser
    Created on : Mar 31, 2016, 12:19:59 PM
    Author     : JAJAJABLESES
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        
        <link href="<c:url value="/Resources/Theme/Index.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Customer/Customer.css"/>" rel="stylesheet">
         
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <div class="wrapper">  
        
        <ul>
            <li><a href="CreateUser.jsp">CreateUser</a></li>
            <li><a href="CreateBuilding.jsp">CreateBuilding</a></li>
            <li><a href="CreateReport.jsp">CreateReport</a></li>
        </ul>
             
            <h1>Hello, and welcome.</h1>
        
            <form class="login" NAME="form1" action="PolyServlet" method="get"> <img src="Logo.JPG" alt="Logo">
                    <input type="hidden" name="user" value="" />
                    <p class="title">Customer login</p>
                        <input type="text" placeholder="Username" name="Username"  autofocus/>
                        <i class="fa fa-user"></i>
                        <input type="password" placeholder="Password" name="Password" />
                        <i class="fa fa-key"></i>
                        <%
                        String text = (String)session.getAttribute("text");
                            if(text==null)
                            {
                              session.setAttribute("text", "");
                            }
                         %>
                        <%=session.getAttribute("text")%>
                    
                        <button type="submit" id="button1" value="Login" onclick="myFunction()">
                        Login
                        </button>
                                
                </form>

              <footer><a target="blank"> Gruppe 4 - A </a></footer>
              </p>
        </div> 
                        
             <script>
             function myFunction() 
             {
                document.form1.user.value='Login';
             }
         </script>
         
    </body>
</html>
