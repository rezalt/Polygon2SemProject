<%-- 
    Document   : CreateBuilding
    Created on : 31-03-2016, 13:49:47
    Author     : Henrik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <style>
        label
        {
            display: inline-block;
            float: left;
            clear: left;
            width: 125px;
            text-align: left;
        }
        
        input 
        {
            display: inline-block;
            float: left;
        }
        
        .container 
        {
            position: relative;
            width:500px;
            margin:0 auto;
            margin-left: 25px;
            padding:5px;
            border:3px solid #02AEF0;
            background:#ffffff; 
            height:400px;
        }
        
        div.inside
        {
            margin:0 0 0 0;
            margin-left: 82px;
            padding:10px 5px 10px 5px;
            width:320px;
            border:1px solid #02AEF0;
        }
        
         </style>
         
         
    </head>
    <body>
        
        <div class="container">
      
            
                <h1>
                    <img src="Logo.JPG" alt="Logo"> <br>
                    Please insert building info.
                </h1>

            <div class="inside"
            
                <form action="PolyServlet" method="post">
                    <table border="0">
                        <tr>  
                            <td>
                                <label>Name:</label>
                                <input type="text" name="buildingName">
                            </td>
                        </tr>
                        <tr>  
                            <td>
                                <label>Owner:</label>
                                <input type="text" name="buildingOwner">
                            </td>
                        </tr>
                        <tr>  
                            <td>
                                <label>Address:</label>
                                <input type="text" name="address">
                            </td>
                        </tr>
                        <tr>  
                            <td>
                                <label>ParcelNo:</label>
                                <input type="text" name="parcelNo">
                            </td>
                        </tr>
                        <tr>  
                            <td>
                                <label>Condition:</label>
                                <input type="text" name="buildingCondition">
                            </td>
                        </tr>
                        <tr>  
                            <td>
                                <input type="submit" name="submit" value="CREATE">
                            </td>
                        </tr>
                </form>
            </div>
        </div> 

    </body>
</html>
