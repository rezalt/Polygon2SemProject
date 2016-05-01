<%-- 
    Document   : BuildingJSP
    Created on : Apr 14, 2016, 1:23:43 PM
    Author     : JAJAJABLESES
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
        <ul><li><a href="MainPage.jsp">Main page</a></li></ul>
        The building:
        <%
            out.print(session.getAttribute("buildingChosen"));
            %>
        Has the following attributes;
        
        <table style ="width:50%">
        <%
            
            
            //out.print("<td>The address is: <td"+);
            // 
            out.print("<tr><td>The address is: </td><td>"+session.getAttribute("thisAddress")+"</td></tr>");
            String strOut = "<tr><td>";
            
            out.print("<tr><td>The company owning the building is: </td><td>"+session.getAttribute("thisBuildingCompany")+"</td></tr>");
            out.print("<tr><td>The parcel nr for this building: </td><td>"+session.getAttribute("thisParcelNr")+"</td></tr>");
            out.print("<tr><td>The size is: </td><td>"+session.getAttribute("thisSize")+"m2</td></tr>");
            out.print("<tr><td>The zipcode is: </td><td>"+session.getAttribute("thisZipcode")+"</td></tr>");
            
            String buildingCondition = ""+session.getAttribute("thisBuildingCondition");
            if(buildingCondition.equals("0"))
            {
            out.print("<tr><td>The buildings condtion is: </td><td>"+"Bygningsdelen er ny og som bygget, og Funktionen er som beskrevet "+"</td></tr>");
                
            }
            else if(buildingCondition.equals("1"))
            {
            out.print("<tr><td>The buildings condtion is: </td><td>"+"Bygningsdelen er intakt, men med begyndende slid og synlige skader (kun kosmetiske skader), og Funktionen er som beskrevet"+"</td></tr>");
                
            }
            else if(buildingCondition.equals("2"))
            {
            out.print("<tr><td>The buildings condtion is: </td><td>"+"Bygningsdelen er begyndt at forfalde, med enkelte defekte komponenter, og Funktionen er nedsat – fare for følgeskader"+"</td></tr>");
                
            }
            else if(buildingCondition.equals("3"))
            {
            out.print("<tr><td>The buildings condtion is: </td><td>"+"Bygningsdelen er nedbrudt og skal udskiftes, og Funktionen er ophørt – fare for følgeskader"+"</td></tr>");
                
            }
            /*
            
            
            out.print("<br>The address is: "+session.getAttribute("address"));
            out.print("<br>The buildings condtion is: "+session.getAttribute("buildingCondition"));
            out.print("<br>The company owning the building is: "+session.getAttribute("buildingCompany"));
            out.print("<br>The parcel nr for this building: "+session.getAttribute("parcelNr"));
            out.print("<br>The size is: "+session.getAttribute("size")+"m2");
            out.print("<br>The zipcode is: "+session.getAttribute("zipcode"));
            */
            
        %>
        </table>
            
            
    </body>
</html>
