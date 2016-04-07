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
      
            
                <%
                        String text = (String)session.getAttribute("text");
                            if(text==null)
                            {
                              session.setAttribute("text", "");
                            }
                         %>
                        <%=session.getAttribute("text")%>
                        
                        
                <h1>
                    Please fill the report.
                </h1>

                <form class="login" name="form3" action="reportServlet" method="POST"> <img src="Logo.JPG" id="Image1" alt="Logo"> <img src="SB.JPG" id="Image2" alt="SB">
                       <input type="hidden" name="report" value="" />
                    <p class="title">
                        
                    <table id="rTable0">
                        <tr>
                            <td>
                                <input type="number" placeholder="Rapport nr.:" name="rapportNr">
                            </td>
                        </tr>
                    </table>
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
                                <input type="date" placeholder="Dato" name="dato">
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
                    </table>    
                    <table>
                        <tr>
                            <td>
                                <b>Gennemgang af bygningen udvendig</b>
                            </td>
                        </tr>
                        <tr>
                            <td width="50%" id="rTdBorderRight" bgcolor="#E6E6E6">
                                &nbsp Tag
                            </td>
                            <td id="rTdBorderRight">
                                Bemærkninger
                                 <input type="checkbox" name="bemærkning" value="tagBemærkning">
                            </td>
                            <td id="rTdBorderRight">
                                Ingen bemærkninger
                                <input type="checkbox" name="ingenBemærkning" value="tagIngenBemærkning">
                            </td>
                            <td>
                                Billede
                                <input type="checkbox" name="billede" value="tagBillede">
                            </td>
                    </table>
                    <table>
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
                            <td width="50%" id="rTdBorderRight" bgcolor="#E6E6E6">
                                &nbsp Ydervægge 
                            </td>
                            <td id="rTdBorderRight">
                                Bemærkninger
                                 <input type="checkbox" name="bemærkning" value="vægBemærkning">
                            </td>
                            <td id="rTdBorderRight">
                                Ingen bemærkninger
                                <input type="checkbox" name="ingenBemærkning" value="vægIngenBemærkning">
                            </td>
                            <td>
                                Billede
                                <input type="checkbox" name="billede" value="vægBillede">
                            </td>
                    </table>
                    <table>
                        <tr> 
                            <td>
                             <TEXTAREA NAME="textYdreVægBemærkning" ROWS="5" cols="50"></TEXTAREA>
                            </td>
                        </tr>
                    </table>

                    <table>
                        <tr>
                            <td width="50%">
                                <b>Skade og reperation</b>
                            </td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <td >
                                &nbsp <input type="number" name="roomNr" placeholder="Lokale"> 
                            </td>
                            <td width="20%">
                                
                            </td>
                            <td id="rTdBorderRight">
                                Bemærkninger
                                <input type="checkbox" name="bemærkning" value="lokaleBemærkning">
                            </td>
                            <td>
                                Ingen bemærkninger
                                <input type="checkbox" name="ingenBemærkning" value="lokaleIngenBemærkning">
                            </td>
                        </tr>
                    </table>
  
                    <table>
                        <tr>
                             <td  width="50%" id="rTdBorderRight" bgcolor="#E6E6E6">
                                Har der været skade i lokalet? 
                            </td>
                            <td width="50px" id="rTdBorderRight">
                                Ja
                                <input type="checkbox" name="skadeJa" value="skadeJa">    
                            </td>
                            <td width="40px" id="rTdCenter"> 
                                Nej
                                <input type="checkbox" name="skadeNej" value="skadeNej"> 
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
                            <td width="50%" id="rTdBorderRight" bgcolor="#E6E6E6">
                                &nbsp Vægge 
                            </td>
                            <td id="rTdBorderRight">
                                Bemærkninger
                                <input type="checkbox" name="genVBemærkning" value="genVBemærkning">
                            </td>
                            <td id="rTdBorderRight">
                                Ingen bemærkninger
                                <input type="checkbox" name="genVIngenBemærkning" value="genVIngenBemærkning">
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
                            <td width="50%" id="rTdBorderRight" bgcolor="#E6E6E6">
                                &nbsp Loft 
                            </td>
                            <td id="rTdBorderRight">
                                Bemærkninger
                                 <input type="checkbox" name="genLoftBemærkning" value="genLoftBemærkning">
                            </td>
                            <td id="rTdBorderRight">
                                Ingen bemærkninger
                                <input type="checkbox" name="genLoftIngenBemærkning" value="genLoftIngenBemærkning">
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
                            <td width="50%" id="rTdBorderRight" bgcolor="#E6E6E6">
                                &nbsp Gulv 
                            </td>
                            <td id="rTdBorderRight">
                                Bemærkninger
                                 <input type="checkbox" name="genGulvBemærkning" value="genGulvBemærkning">
                            </td>
                            <td id="rTdBorderRight">
                                Ingen bemærkninger
                                <input type="checkbox" name="genGulvIngenBemærkning" value="genGulvIngenBemærkning">
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
                            <td width="50%" id="rTdBorderRight" bgcolor="#E6E6E6">
                                &nbsp Vinduer/døre 
                            </td>
                            <td id="rTdBorderRight">
                                Bemærkninger
                                 <input type="checkbox" name="genVDBemærkning" value="genVDBemærkning">
                            </td>
                            <td id="rTdBorderRight">
                                Ingen bemærkninger
                                <input type="checkbox" name="genVDIngenBemærkning" value="genVDIngenBemærkning">
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
                            <td width="50%" id="rTdBorderRight" bgcolor="#E6E6E6">
                                <input type="text" placeholder="Udfyld hvis mere" name="genExtra1Des">
                            </td>
                            <td id="rTdBorderRight">
                                Bemærkninger
                                 <input type="checkbox" name="genExtra1Bemærkning" value="genExtra1Bemærkning">
                            </td>
                            <td id="rTdBorderRight">
                                Ingen bemærkninger
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
                                <input type="checkbox" name="fugtScanJa" value="fugtScanJa">    
                            </td>
                            <td width="40px" id="rTdCenter"> 
                                Nej
                                <input type="checkbox" name="fugtScanNej" value="fugtScanNej"> 
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
                            <td width="50%">
                                <b>Konklusion</b>
                            </td>
                        </tr>
                    </table>
                    
                    <table id="rTable1">
                        <tr>
                            <td width="20%" id="rTdBorderRight" bgcolor="#E6E6E6">
                                &nbsp Lokale
                            </td>
                            <td width="80%" bgcolor="#E6E6E6">
                                &nbsp Anbefalinger
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="number" name="konLokale1" >
                            </td>
                            <td>
                                <input type="text" name ="konAnbefaling1">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="number" name="konLokale2" >
                            </td>
                            <td>
                                <input type="text" name ="konAnbefaling2">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="number" name="konLokale3" >
                            </td>
                            <td>
                                <input type="text" name ="konAnbefaling3">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="number" name="konLokale4" >
                            </td>
                            <td>
                                <input type="text" name ="konAnbefaling4">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="number" name="konLokale5">
                            </td>
                            <td>
                                <input type="text" name ="konAnbefaling5">
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
                                <input type="checkbox" name="tilstand0" value="tilstand0">
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
                                <input type="checkbox" name="tilstand1" value="tilstand1">
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
                                <input type="checkbox" name="tilstand2" value="tilstand2">
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
                                <input type="checkbox" name="tilstand3" value="tilstand3">
                            </td>
                        </tr>
                        
                        
                        
                    </table>
                    
                    <table>
                        <tr>  
                            <td>
                                <button type="submit" id="button4" value="create" onclick="myFunction()">
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
        <script>
             function myFunction() 
             {
                 document.form3.report.value='create';
             }
         </script>
         
        
    </body>
</html>
