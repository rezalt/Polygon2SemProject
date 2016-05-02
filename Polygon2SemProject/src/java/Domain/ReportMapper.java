package Domain;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
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
public class ReportMapper
{

    Connection conn;
    DBConnector DBC = new DBConnector();

    public void createReport(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException, SQLException
    {

        InputStream iS1 = null;
        InputStream iS2 = null;
        int myId = 0;
        int buildingId = 0;

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
        
        // Here we save the userId.
        PreparedStatement st = null;
        
        st = conn.prepareStatement("SELECT userID, name FROM user WHERE name = ?");
        
        st.setString( 1, (String)session.getAttribute("Name") );
        
        ResultSet rs = st.executeQuery();
        
        if( rs.next() )
        {
            myId = rs.getInt("userId");
        }
        
        st = conn.prepareStatement("SELECT buildingId, buildingName FROM building WHERE buildingName = ?");
        
        st.setString( 1, request.getParameter("buildingName") );
        
        rs = st.executeQuery();
        
        if( rs.next() )
        {
            buildingId = rs.getInt("buildingId");
        }
        st.close();
        
        PreparedStatement ps = null;

        // Inserting our new report to the database.
        ps = conn.prepareStatement("INSERT INTO "
                + "REPORT (nameOfBuilding, rDate, address, zipCode, yearBuild, buildingSizeInSquareMeters,"
                + "buildingPurpose, roofNoticeBoolean, roofPictureBoolean, roofNotice, wallNoticeBoolean,"
                + "wallPictureBoolean, WallNotice, writer, coWriter, buildingCondition, roofPicture, wallPicture, userId)"
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

        ps.setString(1, request.getParameter("buildingName"));

        Date date = null;

        try
        {
            date = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("dato"));

        }
        catch (ParseException ex)
        {
            session.setAttribute("text", ex);
        }

        ps.setDate(2, new java.sql.Date(date.getTime()));

        ps.setString(3, request.getParameter("address"));
        ps.setInt(4, tryParse(request.getParameter("Zip")));
        ps.setInt(5, tryParse(request.getParameter("byggeår")));
        ps.setInt(6, tryParse(request.getParameter("size")));
        ps.setString(7, request.getParameter("bygningBrugesTil"));
        ps.setInt(8, tryParse(request.getParameter("tagBemærkningCheck")));
        ps.setInt(9, tryParse(request.getParameter("roofPictureCheck")));
        ps.setString(10, request.getParameter("textTagBemærkning"));
        ps.setInt(11, tryParse(request.getParameter("vægBemærkningCheck")));
        ps.setInt(12, tryParse(request.getParameter("wallPictureCheck")));
        ps.setString(13, request.getParameter("textYdreVægBemærkning"));
        ps.setString(14, request.getParameter("textGenForetagetAf"));
        ps.setString(15, request.getParameter("textSamarbejdeMed"));
        ps.setInt(16, tryParse(request.getParameter("tilstand")));

        if (iS1 != null)
        {
            ps.setBinaryStream(17, iS1);
        }

        if (iS2 != null)
        {
            ps.setBinaryStream(18, iS2);
        }
        
        ps.setInt(19, myId);

        
        int i = ps.executeUpdate();
        if (i > 0)
        {

        }
        else
        {
            session.setAttribute("text", "Error creating report");
            ps.close();

            return;
        }
        session.setAttribute("text", "You have successfully created a report.");
        ps.close();

    }

    public static Integer tryParse(String text)
    {
        try
        {
            return Integer.parseInt(text);
        }
        catch (NumberFormatException e)
        {
            return 0;
        }
    }
}
