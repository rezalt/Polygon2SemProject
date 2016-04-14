<%-- 
    Document   : addRoom
    Created on : 14-04-2016, 20:02:02
    Author     : Henrik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="<c:url value="/Resources/Theme/Index.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Report/Report.css" />" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     <%
     if(session.getAttribute("loggedIn")== null)
        {
            response.sendRedirect("Login.jsp");
        }
     %>
         
        <div class="wrapper">

            <ul>
                <li><a href="Login.jsp">Login</a></li>
                <li><a href="CreateUser.jsp">CreateUser</a></li>
                <li><a href="CreateBuilding.jsp">CreateBuilding</a></li>
            </ul>   
            
            <%
                String text = (String) session.getAttribute("text");
                if (text == null)
                {
                    session.setAttribute("text", "");
                }
            %>
            <%=session.getAttribute("text")%>


            <h1>
          
            </h1>

            <form class="login" name="addRoom" action="reportServlet" enctype="multipart/form-data" method="POST" > <img src="Logo.JPG" id="Image1" alt="Logo"> <img src="SB.JPG" id="Image2" alt="SB">
                <input type="hidden" name="room" value="" />
                <p class="title">

                <h2>
                    Lokale tilføjelse <br>
                </h2>    
        
                <table>
                    <tr>
                        <td width="50%">
                            <b>Skade og reperation</b>
                        </td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <td width="70%" >
                            &nbsp <input type="number" name="roomNr" placeholder="Lokale"> 
                        </td>
                        <td>
                            Bemærkninger
                            <input type="checkbox" name="bemærkning" value="lokaleBemærkning">
                        </td>
                    </tr>
                </table>

                <table>
                    <tr>
                         <td width="85%" id="rTdBorderRight" bgcolor="#E6E6E6">
                            Har der været skade i lokalet? 
                        </td>
                        <td style="padding-right:20px" id="rTdBorderRight">
                            Ja
                            <input type="radio" name="skadet" value="skadeJa">    
                        </td>
                        <td id="rTdCenter"> 
                            Nej
                            <input type="radio" name="skadet" value="skadeNej"> 
                        </td>
                    </tr>
                </table>

                <table id="rTable1">
                    <tr>
                        <td>
                            <input type="date" placeholder="Dato" name="skadeDato">
                        </td>
                        <td width="30%">

                        </td>
                        <td>
                            <input type="text" placeholder="Hvor" name="skadeHvor">
                        </td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <td>
                            <TEXTAREA NAME="hvadErDerSket" placeholder="Hvad er der sket?" ROWS="5" cols="31"></TEXTAREA>                 
                        </td>
                        <td width="20%">
                        </td>
                        <td>
                            <TEXTAREA NAME="HvadErReperaret" placeholder="Hvad er repareret?" ROWS="5" cols="31"></TEXTAREA>  
                        </td>
                    </tr>
                </table>  

                <table>
                    <tr>
                        <td  width="50%" id="rTdBorderRight" bgcolor="#E6E6E6">
                            Skade 
                        </td>
                    </tr>
                    <tr>

                        <td>
                            <input type="checkbox" name="skadeFugt" value="skadeFugt">    
                        </td>
                        <td>
                            Fugt
                        </td>
                    </tr>
                    <tr>
                        <td> 
                            <input type="checkbox" name="skadeRåd" value="skadeRåd"> 
                        </td>
                        <td>
                            Råd og svamp
                        </td>
                    </tr>
                    <tr>
                        <td> 
                            <input type="checkbox" name="skadeSkimmel" value="skadeSkimmel"> 
                        </td>
                        <td>
                            Skimmel
                        </td>
                    </tr>
                    <tr>
                        <td> 
                            <input type="checkbox" name="skadeBrand" value="skadeBrand"> 
                        </td>
                        <td>
                            Brand
                        </td>
                    </tr>
                    <tr>
                        <td> 
                            <input type="checkbox" name="skadeAnden" value="skadeAnden"> 
                        </td>
                        <td>
                            <input type="text" placeholder="Anden skade" name="skadeAndenText">
                        </td>
                    </tr>
                </table>

                <table>
                    <tr>
                        <td width="50%">
                            <b>Gennemgang af…</b>
                        </td>
                    </tr>
                </table>
                <table>
                    <tr>
                    </tr>
                    <tr>
                        <td width="58%" id="rTdBorderRight" bgcolor="#E6E6E6">
                            &nbsp Vægge 
                        </td>
                        <td id="rTdBorderRight">
                            Bemærkninger
                            <input type="checkbox" name="genVBemærkning" value="genVBemærkning">
                        </td>
                        <td>
                            Billede
                            <input type="checkbox" name="genVBillede" value="genVBillede">
                        </td>
                </table>
                <table>
                    <tr> 
                        <td width="100">
                         <TEXTAREA NAME="textGenVBemærkning" ROWS="5" cols="85"></TEXTAREA>
                        </td>
                    </tr>
                </table>            
                <table>
                    <tr>
                    </tr>
                    <tr>
                        <td width="58%" id="rTdBorderRight" bgcolor="#E6E6E6">
                            &nbsp Loft 
                        </td>
                        <td id="rTdBorderRight">
                            Bemærkninger
                             <input type="checkbox" name="genLoftBemærkning" value="genLoftBemærkning">
                        </td>
                        <td>
                            Billede
                            <input type="checkbox" name="genLoftBillede" value="genLoftBillede">
                        </td>
                </table>
                <table>
                    <tr> 
                        <td width="100">
                         <TEXTAREA NAME="textGenLoftBemærkning" ROWS="5" cols="85"></TEXTAREA>
                        </td>
                    </tr>
                </table>
                <table>
                    <tr>
                    </tr>
                    <tr>
                        <td width="58%" id="rTdBorderRight" bgcolor="#E6E6E6">
                            &nbsp Gulv 
                        </td>
                        <td id="rTdBorderRight">
                            Bemærkninger
                             <input type="checkbox" name="genGulvBemærkning" value="genGulvBemærkning">
                        </td>
                        <td>
                            Billede
                            <input type="checkbox" name="genGulvBillede" value="genGulvBillede">
                        </td>
                </table>
                <table>
                    <tr> 
                        <td width="100">
                         <TEXTAREA NAME="textGenGulvBemærkning" ROWS="5" cols="85"></TEXTAREA>
                        </td>
                    </tr>
                </table>
                <table>
                    <tr>
                    </tr>
                    <tr>
                        <td width="58%" id="rTdBorderRight" bgcolor="#E6E6E6">
                            &nbsp Vinduer/døre 
                        </td>
                        <td id="rTdBorderRight">
                            Bemærkninger
                             <input type="checkbox" name="genVDBemærkning" value="genVDBemærkning">
                        </td>
                        <td>
                            Billede
                            <input type="checkbox" name="genVDBillede" value="genVDBillede">
                        </td>
                </table>
                <table>
                    <tr> 
                        <td width="100">
                         <TEXTAREA NAME="textGenVDBemærkning" ROWS="5" cols="85"></TEXTAREA>
                        </td>
                    </tr>
                </table>
                <table>
                    <tr>
                    </tr>
                    <tr>
                        <td width="58%" id="rTdBorderRight" bgcolor="#E6E6E6">
                            <input type="text" placeholder="Udfyld hvis mere" name="genExtra1Des">
                        </td>
                        <td id="rTdBorderRight">
                            Bemærkninger
                             <input type="checkbox" name="genExtra1Bemærkning" value="genExtra1Bemærkning">
                        </td>
                        <td>
                            Billede
                            <input type="checkbox" name="genExtra1Billede" value="genExtra1Billede">
                        </td>
                </table>
                <table>
                    <tr> 
                        <td width="100">
                         <TEXTAREA NAME="textgenExtra1Bemærkning" ROWS="5" cols="85"></TEXTAREA>
                        </td>
                    </tr>
                </table>


                <table>
                    <tr>
                        <td width="50%">
                            <b>Fugtscanning</b>
                        </td>
                    </tr>
                </table>


                <table>
                    <tr>
                         <td  width="50%" id="rTdBorderRight" bgcolor="#E6E6E6">
                            Er der foretaget fugtscanning?
                        </td>
                        <td width="50px" id="rTdBorderRight">
                            Ja
                            <input type="radio" name="fugtScan" value="fugtScanJa">    
                        </td>
                        <td width="40px" id="rTdCenter"> 
                            Nej
                            <input type="radio" name="fugtScan" value="fugtScanNej"> 
                        </td>
                    </tr>
                </table>


                 <table id="rTable1">
                    <tr>
                        <td>
                            <input type="text" placeholder="Fugtscanning" name="fugtscanning">
                        </td>
                        <td width="30%">
                        </td>
                        <td>
                            <input type="text" placeholder="Målepunkt" name="målepunkt">
                        </td>
                    </tr>
                </table>

                 <table>
                    <tr> 
                        <td width="100">
                         <TEXTAREA NAME="fugtKommentar" ROWS="4" cols="85"></TEXTAREA>
                        </td>
                    </tr>
                </table>
        
                <table>
                    <tr>  
                        <td>
                            <button type="submit" id="button5" value="add" onclick="myFunction()">
                                <i class="spinner"></i>
                                <span class="state">Submit</span>         
                            </button>
                        </td>
                    </tr>
                </table>
                
        <script>
        function myFunction()
        {
            document.addRoom.room.value = 'add';
        }
        </script>       
                
                
    </body>
</html>
