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
import java.util.ArrayList;
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
            Logger.getLogger(PolyServlet.class.getName()).log(Level.SEVERE, null, ex);
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

        String do_this = request.getParameter("user");

        if (do_this == null)
        {
            forward(request, response, "/index.html");
        }
        else

        {
            switch (do_this)
            {

                case "Login":

                    if (request.getParameter("Username").isEmpty() || request.getParameter("Password").isEmpty())
                    {

                        session.setAttribute("text", "You need to enter a username and password.");
                        forward(request, response, "/Login.jsp");
                    }

                    conn = DBC.getConnection();

                    int type;
                    String sql = "SELECT * FROM user WHERE name =? and password =?";
                    try (PreparedStatement ps = conn.prepareStatement(sql))
                    {
                        String tempUser = request.getParameter("Username");
                        ps.setString(1, request.getParameter("Username"));
                        ps.setString(2, request.getParameter("Password"));
                        ResultSet rs = ps.executeQuery();

                        if (rs.next())
                        {
                            type = rs.getInt(7);
                            if (type == 2)
                            {

                                session.setAttribute("loggedIn", "admin");

                                ArrayList<String> buildingNames = new ArrayList();
                                //buildingNames.add("JohnHytten");
                                //buildingNames.add("Bygning nr fucking 2");
                                
                                buildingNames = getUsersBuildingNames(request, response, tempUser);
                                
                                session.setAttribute("Name", tempUser);
                                session.setAttribute("buildingNames", buildingNames);
                                myID = rs.getInt("userId");
                                ps.close();
                                forward(request, response, "/MainPage.jsp");
                            }
                            else
                            {
                                ps.close();
                                session.setAttribute("loggedIn", "user");
                                RequestDispatcher rd = request.getRequestDispatcher("CreateUser.jsp");
                                rd.include(request, response);
                            }

                        }
                        else
                        {
                            //besked
                            ps.close();
                            session.setAttribute("text", "Wrong username or password.");
                            forward(request, response, "/Login.jsp");
                        }

                    }
                    catch (Exception e)
                    {
                        session.setAttribute("text", e);
                        Logger.getLogger(PolyServlet.class.getName()).log(Level.SEVERE, null, e + "WHAT");
                        forward(request, response, "/Login.jsp");
                    }

                    break;

                case "NewUser":

                    if (request.getParameter("Username").isEmpty() || request.getParameter("Password").isEmpty())
                    {

                        session.setAttribute("text", "You need to enter a username and password.");
                        forward(request, response, "/CreateUser.jsp");
                    }

                    conn = DBC.getConnection();
                    PreparedStatement ps = null;

                    try (Statement st = conn.createStatement())
                    {

                        // Creating a user                      
                        st.executeQuery("SELECT userid, name FROM user");
                        ResultSet rs = st.getResultSet();

                        while (rs.next())
                        {

                            if (rs.getString("name").equals(request.getParameter("Username")))
                            {

                                session.setAttribute("text", "Username already exists");
                                st.close();
                                forward(request, response, "/CreateUser.jsp");
                            }

                        }
                        // Makes sure we don't show a meaningless error messages.
                        session.setAttribute("text", " ");
                        st.close();

                        // Her indsætter vi vores nye user ind i databasen.
                        ps = conn.prepareStatement("insert into user(name,password,"
                                + "companyName,companyAddress,Zip) "
                                + "values(?,?,?,?,?)");

                        ps.setString(1, request.getParameter("Username"));
                        ps.setString(2, request.getParameter("Password"));
                        ps.setString(3, request.getParameter("companyName"));
                        ps.setString(4, request.getParameter("companyAddress"));
                        ps.setString(5, request.getParameter("Zip"));

                        int i = ps.executeUpdate();
                        if (i > 0)
                        {
                            // UB.setUserName(username); -- Bean doesn't exist yet.
                        }
                        else
                        {
                            session.setAttribute("text", "Error creating user");
                            ps.close();
                            forward(request, response, "/CreateUser.jsp");
                        }

                        ps.close();
                        forward(request, response, "/index.html");
                    }

                    catch (SQLException e)
                    {
                        Logger.getLogger(PolyServlet.class.getName()).log(Level.SEVERE, null, e + "new user");
                        session.setAttribute("text", "" + e);
                        forward(request, response, "/CreateUser.jsp");
                    }

                    break;

            }
        }

        processRequest(request, response);
    } // end of doPost

    public ArrayList<String> getUsersBuildingNames(HttpServletRequest request, HttpServletResponse response, String username)throws IOException, ServletException
    {
        ArrayList<String> buildingNames = new ArrayList();
        conn = DBC.getConnection();
        String sql = "SELECT * FROM building WHERE buildingOwner =?";
        try (PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                buildingNames.add(rs.getString(2));
            }
        }
        catch (Exception e)
        {
            Logger.getLogger(PolyServlet.class.getName()).log(Level.SEVERE, null, e + "WHAT");
            forward(request, response, "/index.html");
            
        }
        
        return buildingNames;
    }

    

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
