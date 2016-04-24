package Domain;

import Model.reportServlet;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josephawwal
 */
public class ReportMapper {
    
    Connection conn;
    DBConnector DBC = new DBConnector();
    String company;
   
    public static Integer tryParse(String text){
        
        try{
            
            return Integer.parseInt(text);
            
        }
        catch(NumberFormatException e){
            
            return 0;
        }
    }
    
    public void createReport(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException, SQLException
    {
        
        InputStream iS1 = null;
        InputStream iS2 = null;
        
        Part filePart = request.getPart("roofPicture");
                
                if (filePart != null) 
                {
                    iS1 = filePart.getInputStream();
                }
                
        Part filePart2 = request.getPart("wallPicture");
                
                if (filePart2 != null) 
                {
                    iS2 = filePart2.getInputStream();
                }
        

        conn = DBC.getConnection();
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

     
                // Makes sure we don't show a meaningless error message.
            session.setAttribute("text", " ");
        
        
            
            // Inserting our new report to the database.
            ps1 = conn.prepareStatement("insert into "
                    + "report (nameOfBuilding, rDate, address, zipCode, yearBuild, buildingSizeInSquareMeters,"
                    + "buildingPurpose, roofNoticeBoolean, roofPictureBoolean, roofNotice, wallNoticeBoolean,"
                    + "wallPictureBoolean, WallNotice, writer, coWriter, buildingCondition, roofPicture, wallPicture)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            ps1.setString(1, request.getParameter("buildingName"));

            Date date = null;
            
            try{
                date = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("dato"));
            
            }
            catch (ParseException ex){
                ex.printStackTrace();
            }
            
            ps1.setDate(2, new java.sql.Date(date.getTime()));

            ps1.setString(3, request.getParameter("address"));
            ps1.setInt(4, tryParse(request.getParameter("Zip")));
            ps1.setInt(5, tryParse(request.getParameter("byggeår")));
            ps1.setInt(6, tryParse(request.getParameter("size")));
            ps1.setString(7, request.getParameter("bygningBrugesTil"));
            ps1.setInt(8, tryParse(request.getParameter("tagBemærkningCheck")));
            ps1.setInt(9, tryParse(request.getParameter("roofPictureCheck")));
            ps1.setString(10, request.getParameter("textTagBemærkning"));
            ps1.setInt(11, tryParse(request.getParameter("vægBemærkningCheck")));
            ps1.setInt(12, tryParse(request.getParameter("wallPictureCheck")));
            ps1.setString(13, request.getParameter("textYdreVægBemærkning"));
            ps1.setString(14, request.getParameter("textGenForetagetAf"));
            ps1.setString(15, request.getParameter("textSamarbejdeMed"));
            ps1.setInt(16, tryParse(request.getParameter("tilstand")));


            if(iS1 != null)
            {  
                ps1.setBinaryStream(17, iS1 );
            }
          
            if(iS2 != null)
            {
                ps1.setBinaryStream(18, iS2 );
            }
            
            int i = ps1.executeUpdate();
            if (i > 0)
            {
                // UB.setUserName(username); -- Bean doesn't exist yet.
            }
            else
            {
                session.setAttribute("text", "Error creating report");
                ps1.close();
                //forward(request, response, "/CreateReport.jsp");
                return;
            }
             session.setAttribute("text", "You have successfully created a report.");
            ps1.close();
          //  forward(request, response, "/MainPage.jsp");
}
}

