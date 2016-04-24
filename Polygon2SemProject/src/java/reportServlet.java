/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Domain.DBConnector;
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

/**
 *
 * @author JAJAJABLESES
 */
@MultipartConfig
public class reportServlet extends HttpServlet
{

    // VARIABLES
    String username = "";
    int myID = 0;
    int ID = 0;

    // END OF VARIABLES
    DBConnector DBC = new DBConnector();
    Connection conn;

    @Override
    public void init(ServletConfig conf) throws ServletException
    {

        try
        {
            java.lang.Class.forName(conf.getInitParameter("jdbcDriver"));
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(reportServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        super.init(conf);

        DBC.setDbURL("jdbc:mysql://91.100.100.141:3360/polygondb");
        DBC.setDbUsername("Admin");
        DBC.setDbPassword("CBAmoria");

    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession(true);

        String do_this = request.getParameter("report");

        if (do_this == null)
        {
            forward(request, response, "/index.html");
        }
        
        else
        {
            switch (do_this)
            {

                case "create":
                    createReport(request, response, session);

                    forward(request, response, "/CreateReport.jsp");
                    break;

                default:
                    forward(request, response, "/index.html");
                    break;

            }
        }
    } // end of doPost

    public void forward(HttpServletRequest request, HttpServletResponse response, String path) throws IOException, ServletException
    {
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher(path);
        rd.forward(request, response);
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
    
  

    public void createReport(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException
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
        try
        {
            
            // Inserting our new report to the database.
            ps1 = conn.prepareStatement("insert into "
                    + "report (nameOfBuilding, rDate, address, zipCode, yearBuild, buildingSizeInSquareMeters,"
                    + "buildingPurpose, roofNoticeBoolean, roofPictureBoolean, roofNotice, wallNoticeBoolean,"
                    + "wallPictureBoolean, WallNotice, writer, coWriter, buildingCondition, roofPicture, wallPicture)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            ps1.setString(1, request.getParameter("buildingName"));

            Date date = null;
            try
            {
                date = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("dato"));
            }
            catch (ParseException ex)
            {
                Logger.getLogger(reportServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            forward(request, response, "/MainPage.jsp");
//            ps2 = conn.prepareStatement("insert into "
//                    + "room( roomName, notices, damagedRoom, dateOfDamage, descriptionOfLocation, explanationOfDamage,"
//                    + "repairs, moisture, sponge, mold, fire, otherDamage,"
//                    + "otherDamageDescription)"
//                    + " values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
//
//            ps2.setString(1, request.getParameter("roomNr"));
//            ps2.setInt(2, tryParse(request.getParameter("bemærkning")));
//            ps2.setInt(3, tryParse(request.getParameter("skadet")));
//
//            try
//            {
//                date = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("skadeDato"));
//            }
//            catch (ParseException ex)
//            {
//                Logger.getLogger(reportServlet.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            ps2.setDate(4, new java.sql.Date(date.getTime()));
//
//            ps2.setString(5, request.getParameter("skadeHvor"));
//            ps2.setString(6, request.getParameter("hvadErDerSket"));
//            ps2.setString(7, request.getParameter("HvadErReperaret"));
//            ps2.setInt(8, tryParse(request.getParameter("skadeFugt")));
//            ps2.setInt(9, tryParse(request.getParameter("skadeRåd")));
//            ps2.setInt(10, tryParse(request.getParameter("skadeSkimmel")));
//            ps2.setInt(11, tryParse(request.getParameter("skadeBrand")));
//            ps2.setInt(12, tryParse(request.getParameter("skadeAnden")));
//            ps2.setString(13, request.getParameter("skadeAndenText"));
//
//            int i2 = ps2.executeUpdate();
//            if (i2 > 0)
//            {
//                // UB.setUserName(username); -- Bean doesn't exist yet.
//            }
//            else
//            {
//                session.setAttribute("text", "Error creating report");
//                ps2.close();
//                //forward(request, response, "/CreateReport.jsp");
//                return;
//            }
//
//            ps2.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(reportServlet.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
