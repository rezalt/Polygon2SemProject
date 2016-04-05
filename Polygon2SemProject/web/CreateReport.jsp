<%-- 
    Document   : CreateReport
    Created on : Apr 5, 2016, 1:12:24 PM
    Author     : Henrik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        
        <link href="<c:url value="/Resources/Report/Report.css" />" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        
        <div class="wrapper">
      
            
                <h1>
                    Please insert building info.
                </h1>

                <form class="login" action="PolyServlet" method="POST"> <img src="Logo.JPG" id="Image1" alt="Logo">  <img src="SB.JPG" id="Image2" alt="SB">
                    

                    <p class="title">
                    
                    <table border="0" id="thisTable">
                        <tr>  
                            <td>
                                <input type="text" placeholder="Navn på bygning" name="buildingName">
                            </td>                       
                            <td>
                                <input type="date" placeholder="Dato" name="buildingOwner">
                            </td>
                        </tr>
                        <tr>  
                            <td>
                                <input type="text" placeholder="Adresse" name="address">
                            </td>
            
                        </tr>
                        <tr>  
                            <td>
                                <input type="number" placeholder="Postnr. / By" name="Zip">
                            </td>
                        </tr>
                        <tr>  
                            <td>
                                <button type="submit" name="submit" value="CREATE">
                                    <i class="spinner"></i>
                                    <span class="state">Submit</span>                  
                            </td>
                        </tr>
                    </table>  
                </form>
                   <footer><a target="blank"> Gruppe 4 - A </a></footer>
                </p>
                  
        </div> 
          
    </body>
</html>
