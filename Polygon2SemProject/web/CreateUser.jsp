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
        
        <link href="<c:url value="/Resources/Login/login.css" />" rel="stylesheet">
        <script src="<c:url value="/Resources/Login/login.js" />"></script>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
         <div class="wrapper">  
   
            <h1>Hello and welcome, please insert your user settings.</h1>
      
                <form class="login" NAME="form1">
                    <input type="hidden" name="user" value="" />
                    <p class="title">Create user</p>
                        <input type="text" placeholder="Username" autofocus/>
                        <i class="fa fa-user"></i>
                        <input type="password" placeholder="Password" />
                        <i class="fa fa-key"></i>
                        <button onclick="myFunction()">
                          <i class="spinner"></i>
                          <span class="state">Submit</span> 
                        </button>
                </form>

              <footer><a target="blank"> Gruppe 4 - A </a></footer>
              </p>
        </div> 

        
        <script>
            function myFunction() 
            {
                document.form1.user.value='NewUser';
                document.form["form1"].submit();
                document.form1.submit();
            }
        </script>

    </body>
</html>
