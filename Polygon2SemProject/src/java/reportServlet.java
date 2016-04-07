/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
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


/**
 *
 * @author JAJAJABLESES
 */
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
                Logger.getLogger(reportServlet.class.getName()).log(Level.SEVERE, null, ex );
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
            switch (do_this) 
                {

                   case "create":

                       
                       if( request.getParameter("buildingName").isEmpty() || request.getParameter("address").isEmpty() || request.getParameter("dato").isEmpty() )
                       {

                            session.setAttribute("text", "You need to fill out name, address and date.");
                                forward(request, response, "/CreateReport.jsp");
                       }
        

                       conn = DBC.getConnection();
                       PreparedStatement ps1 = null;

  
                       try (Statement st = conn.createStatement()) 
                       {
                           
                           // Creating a building                     
                           st.executeQuery("SELECT reportId, reportNr FROM report");
                           ResultSet rs = st.getResultSet();

                           while(rs.next())
                           {

                               if( rs.getString("reportNr").equals(request.getParameter("rapportNr")))
                               {
                                  
                                    session.setAttribute("text", "report  already exists");
                                        st.close();
                                        forward(request, response, "/CreateReport.jsp");
                               }

                               
                           }
                            // Makes sure we don't show a meaningless error message.
                                session.setAttribute("text", " ");
                                st.close(); 
                                
                           // Inserting our new report to the database.
                               ps1 = conn.prepareStatement("insert into "
                                + "report(reportNr, nameOfBuilding, rDate, address, zipCode, yearBuild, buildingSizeInSquareMeters,"
                                         + "buildingPurpose, roofNoticeBoolean, roofPictureBoolean, roofNotice, wallNoticeBoolean,"
                                       + "wallPictureBoolean, WallNotice, roomId, writer, coWriter, buildingCondition)"
                                + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    
                               ps1.setInt( 1, tryParse(request.getParameter("rapportNr")) );
                               ps1.setString( 2, request.getParameter("buildingName"));
                                    
                               Date date = null;
                                    try
                                    {
                                        date = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("dato"));
                                    } catch (ParseException ex)
                                    {
                                        Logger.getLogger(reportServlet.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                               ps1.setDate(3, new java.sql.Date(date.getTime()) );
                              
                               ps1.setString(4, request.getParameter("address"));
                               ps1.setInt(5, tryParse(request.getParameter("Zip")) );
                               ps1.setInt(6, tryParse(request.getParameter("byggeår")) ); 
                               ps1.setInt(7, tryParse(request.getParameter("size")) );
                               ps1.setString(8, request.getParameter("bygningBrugesTil"));
                               ps1.setInt(9, tryParse(request.getParameter("tagBemærkning")) );
                               ps1.setInt(10, tryParse(request.getParameter("tagBillede")) );
                               ps1.setString(11, request.getParameter("textTagBemærkning"));
                               ps1.setInt(12, tryParse(request.getParameter("vægBemærkning")) );
                               ps1.setInt(13, tryParse(request.getParameter("vægBillede")) );
                               ps1.setString(14, request.getParameter("textYdreVægBemærkning"));
                               ps1.setInt(15, tryParse(request.getParameter("roomNr")) );
                               ps1.setString(16, request.getParameter("textGenForetagetAf"));
                               ps1.setString(17, request.getParameter("textSamarbejdeMed"));
                               ps1.setInt(18, tryParse(request.getParameter("tilstand0")) );
                             

                 
                               int i = ps1.executeUpdate();
                               if( i > 0 )
                               {
                                  // UB.setUserName(username); -- Bean doesn't exist yet.
                               }
                                   else
                                   {
                                        session.setAttribute("text", "Error creating report");
                                        ps1.close();
                                        forward(request, response, "/CreateReport.jsp");
                                   }    
                               
                               ps1.close();
                               forward(request, response, "/CreateReport.jsp");        
                            } 
                           
                       catch (SQLException e) 
                       {
                           Logger.getLogger(reportServlet.class.getName()).log(Level.SEVERE, null, e + "new building");
                           session.setAttribute("text", "" +e);
                           forward(request, response, "/CreateReport.jsp"); 
                       }
                        break;
            }
        
        processRequest(request, response);
    } // end of doPost
    
    
    private void forward(HttpServletRequest request, HttpServletResponse response, String path) throws IOException, ServletException 
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
