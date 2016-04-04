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

/**
 *
 * @author JAJAJABLESES
 */
public class PolyServlet extends HttpServlet
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
                Logger.getLogger(PolyServlet.class.getName()).log(Level.SEVERE, null, ex );
            }
      
            
        super.init(conf);
        
        DBC.setDbURL("jdbc:mysql://localhost:3306/WriteNameHereDoods");
        DBC.setDbUsername("root");
        DBC.setDbPassword("");

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
        
        String do_this = request.getParameter("do_this");     
        
        if (do_this == null)
        {
             forward(request, response, "/index.html");
        }
        else 
            switch (do_this) 
                {

                   case "Login":

                       conn = DBC.getConnection();

                       if(request.getParameter("Username").equals("") || request.getParameter("Password").equals("") )
                       {
                           forward(request, response, "/index.html");
                       }
                       else
                       {
                           String sql = "SELECT * FROM users WHERE username =? and password =?";
                           try (PreparedStatement ps = conn.prepareStatement(sql))
                           {

                               ps.setString( 1, request.getParameter("Username") );
                               ps.setString( 2, request.getParameter("Password") );
                               ResultSet rs = ps.executeQuery();

                                   if(rs.next())
                                   {
                                     //  session.setAttribute("user", UB);  -- Bean doesn't exist yet.
                                       myID = rs.getInt("userID");                                                     
                                   }
                                   else
                                   {
                                      //besked
                                   }

                               ps.close();
                               forward(request, response, "/index.html");

                           }
                           catch(Exception e)
                           {
                               Logger.getLogger(PolyServlet.class.getName()).log(Level.SEVERE, null, e + "WHAT");
                                forward(request, response, "/index.html");
                           }
                       }

                   break;   

                   case "NewUser":

                       ID = 0;
                       conn = DBC.getConnection();
                       PreparedStatement ps = null;

                       try (Statement st = conn.createStatement()) 
                       {
                           // Creating a user                      
                           st.executeQuery("SELECT userid, username FROM users");
                           ResultSet rs = st.getResultSet();

                           while(rs.next())
                           {
                               ID = rs.getInt("userID") + 1; // Sørger for at den nye user har sit eget ID.

                               if( rs.getString("username").equals(request.getParameter("Username")))
                               {
                                   //besked
                                   st.close();
                                     forward(request, response, "/index.html");
                               }

                           }


                           // Her indsætter vi vores nye user ind i databasen.
                               ps = conn.prepareStatement("insert into users(userID,Username,Password) values(?,?,?)");

                               ps.setInt(1, ID);
                               ps.setString( 2, request.getParameter("Username") ); 
                               ps.setString( 3, request.getParameter("Password") ); 

                               st.close();   

                               int i = ps.executeUpdate();
                               if( i > 0 )
                               {
                                  // UB.setUserName(username); -- Bean doesn't exist yet.
                               }
                                   else
                                   {
                                       //besked
                                   }    

                               ps.close();
                               forward(request, response, "/index.html");        
                       } 
                       catch (SQLException e) 
                       {
                           Logger.getLogger(PolyServlet.class.getName()).log(Level.SEVERE, null, e + "new user");
                           forward(request, response, "/index.html"); 
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
