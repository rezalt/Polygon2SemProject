package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Domain.DataMapperException;
import Domain.UserMapper;
import Domain.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    Connection conn;
    String company;

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

            /*
             Type 0: User
             Type 1: Employee
             Type 2: Admin
             Type 3: User already exists
             Type 4: Account does not exist.
             Type 5: No connection.
             This is an interesting way of doing things.
             */
            UserMapper um = new UserMapper();
            User user = new User();
            int type = 4;
            ArrayList buildingNames = new ArrayList();
            switch (do_this)
            {

                case "Login":
                    try
                    {
                        user = um.login(request.getParameter("Username"), request.getParameter("Password"));
                        type = user.getType();
                        buildingNames = user.getBuildingNames();
                    }
                    catch (DataMapperException ex)
                    {
                        session.setAttribute("text", " Error creating user object for Login " + ex);
                        forward(request, response, "/Login.jsp");
                    }

                    if (type == 2)
                    {
                        session.setAttribute("text", " ");
                        session.setAttribute("loggedIn", "Admin");
                        session.setAttribute("Name", user.getUsername());
                        request.setAttribute("buildingNames", buildingNames);

                        forward(request, response, "/MainPage.jsp");

                    }
                    else if (type == 0)
                    {
                        session.setAttribute("text", " ");
                        session.setAttribute("loggedIn", "user");
                        request.setAttribute("buildingNames", buildingNames);
                        session.setAttribute("Name", user.getUsername());

                        forward(request, response, "/MainPage.jsp");
                    }
                    else if(type == 4)
                    {
                        session.setAttribute("text", "Wrong username or password.");
                        
                        forward(request, response, "/Login.jsp");
                    }
                    else
                    {
                        session.setAttribute("text", "Cannot get connection to server.");
                        
                        forward(request, response, "/Login.jsp");
                    }

                    break;

                case "NewUser":

                    try
                    {
                        user = um.newUser(
                                request.getParameter("Username"), request.getParameter("Password"), request.getParameter("companyName"),
                                request.getParameter("companyAddress"), tryParse(request.getParameter("Zip"))
                        );
                        type = user.getType();
                        buildingNames = user.getBuildingNames();
                    }
                    catch (DataMapperException ex)
                    {
                        session.setAttribute("text", " Error creating user object for NewUser " + ex);
                        forward(request, response, "/CreateUser.jsp");
                    }

                    if (type == 0)
                    {

                        session.setAttribute("text", " ");
                        session.setAttribute("loggedIn", "user");
                        session.setAttribute("Name", user.getUsername());
                        request.setAttribute("buildingNames", buildingNames);

                        forward(request, response, "/MainPage.jsp");
                    }
                    else if (type == 3)
                    {
                        session.setAttribute("text", "User already exists");
                        forward(request, response, "/MainPage.jsp");
                    }
                    else if(type == 4) // Type 4
                    {
                        session.setAttribute("text", "Error creating user");
                        forward(request, response, "/MainPage.jsp");
                    }       
                    else
                    {
                        session.setAttribute("text", "Cannot get connection to server.");
                        forward(request, response, "/CreateUser.jsp");
                    }
                    
                    break;
            }

        }

        // end of doPost
    }

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
