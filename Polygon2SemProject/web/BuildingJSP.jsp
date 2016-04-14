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
        
        the building:
        <%
            out.print(session.getAttribute("buildingChosen"));
            %>
        Has the following attributes;
        <%
            out.print("<br>The address is: "+session.getAttribute("address"));
            out.print("<br>The buildings condtion is: "+session.getAttribute("buildingCondition"));
            out.print("<br>The company owning the building is: "+session.getAttribute("buildingCompany"));
            out.print("<br>The parcel nr for this building: "+session.getAttribute("parcelNr"));
            out.print("<br>The size is: "+session.getAttribute("size")+"m2");
            out.print("<br>The zipcode is: "+session.getAttribute("zipcode"));
            
            
        %>
            
            
            
    </body>
</html>
