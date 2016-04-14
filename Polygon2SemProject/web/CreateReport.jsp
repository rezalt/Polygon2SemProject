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
     else if(session.getAttribute("loggedIn")!= "Admin")
     {
        session.setAttribute("text", "You need to be a Polygon A/S employee to create a report.");
        response.sendRedirect("Login.jsp");
     }
     %>
         
        <div class="wrapper">

            <ul>
                <li><a href="Login.jsp">Login</a></li>
                <li><a href="MainPage.jsp">MainPage</a></li>
                <li><a href="CreateBuilding.jsp">CreateBuilding</a></li>
                <li><a href="CreateUser.jsp">CreateUser</a></li>
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
                Please fill the report.
            </h1>
          
            <form class="login" name="form3" action="reportServlet" enctype="multipart/form-data" method="POST" > <img src="Logo.JPG" id="Image1" alt="Logo"> <img src="SB.JPG" id="Image2" alt="SB">
                <input type="hidden" name="report" value="" />
                <p class="title">
                <h2>
                    Bygningsgennemgang <br>
                      
                </h2>
                
                 
                <table border="0" id="rTable1">
                    <tr>  
                        <td>          
                            <input type="text" placeholder="Navn på bygning" name="buildingName">
                        </td>  
                        <td width="30%">

                        </td>
                        <td>
                            <input type="date" placeholder="Dato" name="dato" required="">
                        </td>
                    </tr>
                    <tr>  
                        <td>
                            <input type="text" placeholder="Adresse" name="address">
                        </td>
                        <td>            
                        </td>
                        <td>
                            <label id="smallFont">
                                Polygon<br>
                                Rypevang 5<br>
                                3450 Allerød
                            </label>    
                        </td>

                    </tr>
                    <tr>  
                        <td>
                            <input type="number" min="100" placeholder="Postnr. / By" name="Zip">
                        </td>
                        <td>

                        </td>
                        <td>
                            <label id="smallFont">
                                Tlf. 4814 0555<br>
                                sundebygninger@polygon.dk
                            </label>

                        </td>
                    </tr>
                </table>
                <table id="rTable2">
                    <tr>
                        <td>
                            <b>General information om bygningen</b>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="number" min="1000" placeholder="Byggeår" name="byggeår">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="number" placeholder="Bygningsareal i m2 (hver etage tælles separat)" name="size">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" placeholder="Hvad bruges bygningen til / Hvad har bygningen været brugt til?" name="bygningBrugesTil">
                        </td>
                    </tr>
                    <tr>

                    </tr>
                    <tr>
                        <td>
                            <b>Gennemgang af bygningen udvendig</b>
                        </td>
                    </tr>
                </table>    
                <table>

                    <tr>
                        <td width="70%" id="rTdBorderRight" bgcolor="#E6E6E6">
                            &nbsp Tag
                        </td>
                        <td id="rTdBorderRight">
                            Bemærkninger
                            <input type="checkbox" name="tagBemærkningCheck" value="">
                        </td>
                        <td id="rTdCenter">
                            Billede
                            <input type="checkbox" name="roofPictureCheck" value="">
                        </td>
                </table>
                <table>
                    <tr>
                        <td>
                           <input type="file" name="roofPicture" size="40" />
                        </td>
                    </tr>
                    <tr> 
                        <td>
                            <TEXTAREA NAME="textTagBemærkning" ROWS="5" cols="50"></TEXTAREA>
                        </td>
                    </tr>
                </table>
                <table>
                    <tr>
                    </tr>
                    <tr>
                        <td width="70%" id="rTdBorderRight" bgcolor="#E6E6E6">
                            &nbsp Ydervægge 
                        </td>
                        <td id="rTdBorderRight">
                            Bemærkninger
                             <input type="checkbox" name="vægBemærkningCheck" value="">
                        </td>
                        <td>
                            Billede
                            <input type="checkbox" name="wallPictureCheck" value="">
                        </td>
                </table>
                <table>
                    <tr>
                        <td>
                            <input type="file" name="wallPicture" size="40"/>
                        </td>
                    </tr>
                    <tr> 
                        <td>
                         <TEXTAREA NAME="textYdreVægBemærkning" ROWS="5" cols="50"></TEXTAREA>
                        </td>
                    </tr>

                </table>
 
                 <table id="rTable1">
                    <tr>
                        <td>
                            <b>General information om bygningen</b>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Bygningsgennemgangen er foretaget af
                        </td>
                        <td width="50%">
                            <input type="text" name="textGenForetagetAf">
                        </td>
                        <td>
                            ,Polygon
                        </td>
                    </tr>
                    <tr>
                        <td>
                            I samarbejde med 
                        </td>
                        <td>
                            <input type="text" name="textSamarbejdeMed">
                        </td>
                        <td>
                            (bygningsansvarlig)
                        </td>
                    </tr>
                </table>    

                <table id="rTable3" >

                    <tr bgcolor="#E6E6E6">
                        <td id="rTdBorderRight" width="20%">
                         <b>Tilstand</b>  
                        </td>
                        <td id="rTdBorderRight">
                           <b>Beskrivelse af bygningen </b>
                        </td>
                        <td id="rTdBorderRight">
                          <b>Funktion af bygningen</b>  
                        </td>
                        <td id="rTdBorderRight">
                           <b>Tilstandsgrad</b>
                        </td>
                    </tr>
                    <tr>
                        <td id="rTdBorder3Right">
                            <b>Tilstandsgrad 0</b> 
                        </td>
                        <td id="rTdBorder3Right">
                            Bygningsdelen er ny og som bygget
                        </td>
                        <td id="rTdBorder3Right">
                            Funktionen er som
                            beskrevet
                        </td>
                        <td id="rTdBorderRight">
                            <input type="radio" name="tilstand" value="tilstand0">
                        </td>
                    </tr>
                    <tr>
                        <td id="rTdBorder3Right">
                            <b>Tilstandsgrad 1 </b>
                        </td>
                        <td id="rTdBorder3Right">
                            Bygningsdelen er intakt, men med
                            begyndende slid og synlige skader
                            (kun kosmetiske skader)
                        </td>
                        <td id="rTdBorder3Right">
                            Funktionen er som
                            beskrevet
                        </td>
                        <td id="rTdBorderRight">
                            <input type="radio" name="tilstand" value="tilstand1">
                        </td>
                    </tr>
                    <tr>
                        <td id="rTdBorder3Right">
                            <b>Tilstandsgrad 2</b>
                        </td>
                        <td id="rTdBorder3Right">
                            Bygningsdelen er begyndt at forfalde,
                            med enkelte defekte komponenter
                        </td>
                        <td id="rTdBorder3Right">
                            Funktionen er nedsat –
                            fare for følgeskader
                        </td>
                        <td id="rTdBorderRight">
                            <input type="radio" name="tilstand" value="tilstand2">
                        </td>
                    </tr>             
                    <tr>
                        <td id="rTdBorder3Right">
                            <b>Tilstandsgrad 3</b>
                        </td>
                        <td id="rTdBorder3Right">
                            Bygningsdelen er nedbrudt og skal
                            udskiftes
                        </td>
                        <td id="rTdBorder3Right">
                            Funktionen er ophørt –
                            fare for følgeskader
                        </td>
                        <td id="rTdBorderRight">
                            <input type="radio" name="tilstand" value="tilstand3">
                        </td>
                    </tr>
                </table>

                <table>
                    <tr>  
                        <td>
                            <button type="submit" value="create" onclick="myFunction()">
                                <i class="spinner"></i>
                                <span class="state">Submit</span>         
                            </button>
                        </td>
                    </tr>
                </table>
                    
                    
                    
    <footer>Denne rapport og bygningsgennemgang er lavet for at klarlægge umiddelbare visuelle problemstillinger. Vores formål er at sikre, at
bygningens anvendelse kan opretholdes. Vi udbedrer ikke skader som en del af bygningsgennemgangen/rapporten. 
<br> <br> 
Gennemgangen af bygningen indeholder ikke fugtmålinger af hele bygningen, men vi kan foretage fugtscanninger enkelte steder i bygningen, hvis vi
finder det nødvendigt. Hvis vi finder kritiske områder i bygningen vil vi fremlægge anbefalinger angående yderligere tiltag så som
yderligere undersøgelser, reparationer eller bygningsopdateringer. <br>
<br>
Bemærk at vi skal have adgang til hele bygningen for at kunne udføre en fuld gennemgang (dette inkluderer adgang til tag, tagrum,
kælder, krybekælder eller andre aflukkede områder). Denne bygningsgennemgang er ikke-destruktiv. Hvis der skal laves destruktive
indgreb, skal dette først godkendes af de bygningsansvarlige. Destruktive indgreb er ikke en del af denne rapport eller
bygningsgennemgang.
Den bygningsansvarlige skal udlevere plantegning over bygningen inden bygningsgennemgangen kan foretages.</footer>
                </form>
          
                </p>
            
        </div> 
   
    <script type="text/javascript">
        
     function getCookie(name)
    {
      var re = new RegExp(name + "=([^;]+)");
      var value = re.exec(document.cookie);
      return (value != null) ? unescape(value[1]) : null;
    }

    if(buildingName = getCookie("buildingName")) document.form3.buildingName.value = buildingName;
    if(dato = getCookie("dato")) document.form3.dato.value = dato;
    if(address = getCookie("address")) document.form3.address.value = address;
    if(Zip = getCookie("Zip")) document.form3.Zip.value = Zip;
    if(byggeår = getCookie("byggeår")) document.form3.byggeår.value = byggeår;
    if(size = getCookie("size")) document.form3.size.value = size;
    if(bygningBrugesTil = getCookie("bygningBrugesTil")) document.form3.bygningBrugesTil.value = bygningBrugesTil;
    if(tagBemærkningCheck = getCookie("tagBemærkningCheck")) document.form3.tagBemærkningCheck.value = tagBemærkningCheck;
    if(roofPictureCheck = getCookie("roofPictureCheck")) document.form3.roofPictureCheck.value = roofPictureCheck;
    if(roofPicture = getCookie("roofPicture")) document.form3.roofPicture.value = roofPicture;
    if(textTagBemærkning = getCookie("textTagBemærkning")) document.form3.textTagBemærkning.value = textTagBemærkning;
    if(vægBemærkningCheck = getCookie("vægBemærkningCheck")) document.form3.vægBemærkningCheck.value = vægBemærkningCheck;
    if(wallPicture = getCookie("wallPicture")) document.form3.wallPicture.value = wallPicture;
    if(textGenForetagetAf = getCookie("textGenForetagetAf")) document.form3.textGenForetagetAf.value = textGenForetagetAf;
    if(textSamarbejdeMed = getCookie("textSamarbejdeMed")) document.form3.textSamarbejdeMed.value = textSamarbejdeMed;
    if(tilstand = getCookie("tilstand")) document.form3.tilstand.value = tilstand;
  
    </script>       
            
            
            
    <script type="text/javascript">
        function myFunction()
        {
            
            document.form3.report.value = 'create';
            
            var expired = new Date(today.getTime() - 24 * 3600 * 1000); // less than 24 hours
            document.cookie=name + "=null; path=/; expires=" + expired.toGMTString();
            
        }
        
        function saveCookies(form3)
        {
            
             var today = new Date();
             var expiry = new Date(today.getTime() + 1 * 3600 * 1000); // plus 1 hour
  
                setCookie("buildingName", form3.buildingName.value);
                setCookie("dato", form3.dato.value);
                setCookie("address", form3.address.value);
                setCookie("Zip", form3.Zip.value);
                setCookie("byggeår", form3.byggeår.value);
                setCookie("size", form3.size.value);
                setCookie("bygningBrugesTil", form3.bygningBrugesTil.value);
                setCookie("tagBemærkningCheck", form3.tagBemærkningCheck.value);
                setCookie("roofPictureCheck", form3.roofPictureCheck.value);
                setCookie("roofPicture", form3.roofPicture.value);
                setCookie("textTagBemærkning", form3.textTagBemærkning.value);
                setCookie("vægBemærkningCheck", form3.vægBemærkningCheck.value);
                setCookie("wallPicture", form3.textYdreVægBemærkning.value);
                setCookie("textGenForetagetAf", form3.textGenForetagetAf.value);
                setCookie("textSamarbejdeMed", form3.textSamarbejdeMed.value);
                setCookie("tilstand", form3.tilstand.value); 
                 return true;
        }
        
        
        
        
    </script>

        
    </body>
</html>
