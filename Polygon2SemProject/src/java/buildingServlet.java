/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Domain.DBConnector;
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
public class buildingServlet extends HttpServlet
{

    // VARIABLES
    String username = "";
    int myID = 0;
    int ID = 0;
 String company;
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
            Logger.getLogger(buildingServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        super.init(conf);

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

        String do_this =(String) request.getParameter("building");
//        String buildingChosen = request.getParameter("buildingChosen");
//        if (buildingChosen!=null)
//        {
//            forward(request, response, "/BuildingJSP.jsp");
//        }

        if (do_this == null)
        {
            forward(request, response, "/index.html");
        }
        else
        {
            switch (do_this)
            {

                case "create":

                    if (request.getParameter("buildingName").isEmpty() || request.getParameter("address").isEmpty())
                    {

                        session.setAttribute("text", "You need to fill out all the fields.");
                        forward(request, response, "/CreateBuilding.jsp");
                    }

                    conn = DBC.getConnection();
                    PreparedStatement ps1 = null;

                    try (Statement st = conn.createStatement())
                    {

                        // Creating a building                     
                        st.executeQuery("SELECT buildingId, buildingName FROM building");
                        ResultSet rs = st.getResultSet();

                        while (rs.next())
                        {

                            if (rs.getString("buildingName").equals(request.getParameter("buildingName")))
                            {

                                session.setAttribute("text", "Building already exists");
                                st.close();
                                forward(request, response, "/CreateBuilding.jsp");
                            }

                        }
                        // Makes sure we don't show a meaningless error message.
                        session.setAttribute("text", " ");
                        st.close();

                        // Inserting our new building to the database.
                        ps1 = conn.prepareStatement("insert into building(buildingName, address, buildingCondition, buildingCompany, parcelNr, size, zipcode) values(?,?,?,?,?,?,?)");

                        ps1.setString(1, request.getParameter("buildingName"));
                        ps1.setString(2, request.getParameter("address"));
                        ps1.setInt(3, Integer.parseInt(request.getParameter("buildingCondition")));
                        ps1.setString(4, request.getParameter("buildingCompany"));
                        ps1.setInt(5, Integer.parseInt(request.getParameter("parcelNr")));
                        ps1.setInt(6, Integer.parseInt(request.getParameter("Size")));
                        ps1.setInt(7, Integer.parseInt(request.getParameter("Zipcode")));

                        int i = ps1.executeUpdate();
                        if (i > 0)
                        {
                            // UB.setUserName(username); -- Bean doesn't exist yet.
                        }
                        else
                        {
                            session.setAttribute("text", "Error creating building");
                            ps1.close();
                            forward(request, response, "/CreateBuilding.jsp");
                        }

                        ps1.close();
                        forward(request, response, "/Login.jsp");
                    }

                    catch (SQLException e)
                    {
                        session.setAttribute("text", "" + e);
                        forward(request, response, "/CreateBuilding.jsp");
                    }
                    break;
            }
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
