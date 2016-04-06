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
        
        <link href="<c:url value="/Resources/Building/building.css" />" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        
        <div class="wrapper">
      
            
                <h1>
                    Please insert building info.
                </h1>

                <form class="login" name="form2" action="buildingServlet" method="get"> <img src="Logo.JPG" alt="Logo">
                   <input type="hidden" name="building" value="" />
                    <p class="title">Create building</p>
                    <table border="0">
                        <tr>  
                            <td>
                                <input type="text" placeholder="Building name" name="name">
                            </td>                       
                            <td>
                                <input type="text" placeholder="Address" name="address">
                            </td>
                        </tr>
                        <tr>  
                            <td>
                                <input type="number" placeholder="buildingCondition" name="condition" min="0" max="3">
                            </td>
                            <td>
                                <input type="text" placeholder="Owner" name="owner">
                            </td>
                        </tr>
                        <tr>  
                             <td>
                                <input type="number" placeholder="parcelNr" name="parcelNr">
                            </td>
                            <td>
                                <input type="number" placeholder="Size in m3" name="Size">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="number" placeholder="Zipcode" name="Zipcode">
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
                                     
                   </form>
                   <footer><a target="blank"> Gruppe 4 - A </a></footer>
                </p>
                  
                        <%
                        String text = (String)session.getAttribute("text");
                            if(text==null)
                            {
                              session.setAttribute("text", "");
                            }
                         %>
                        <%=session.getAttribute("text")%>
        </div> 
          
        <script>
             function myFunction() 
             {
                 document.form2.building.value='create';
             }
         </script>
    </body>
</html>
