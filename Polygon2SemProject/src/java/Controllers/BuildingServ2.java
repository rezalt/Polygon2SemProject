package Controllers;

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
public class BuildingServ2 extends HttpServlet
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  

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
        String buildingName = (String) request.getParameter("buildingChosen");
        System.out.println("-------->"+buildingName+"<---------");
        session.setAttribute("buildingChosen", buildingName);
        setBuildingAttributes(session, request, response, buildingName);
        
        
        
        
        forward(request, response, "/BuildingJSP.jsp");
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
    
     private void forward(HttpServletRequest request, HttpServletResponse response, String path) throws IOException, ServletException
    {
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher(path);
        rd.forward(request, response);
    }
     
    public void setBuildingAttributes(HttpSession session, HttpServletRequest request, HttpServletResponse response, String buildingName) throws IOException, ServletException
    {
        DBConnector DBC = new DBConnector();
        Connection conn = DBC.getConnection();
        
        String sql = "SELECT * FROM building WHERE buildingName =?";
        
        try(PreparedStatement ps = conn.prepareStatement(sql))
        {
          ps.setString(1, buildingName);
          ResultSet rs = ps.executeQuery();
          System.out.println("<-<-<-<-<-<>_>_>_>_>_");
          
          if(rs.next())
          {
              // "this" is added as prefix to prevent overriding user session info, 
              // especially the users company name. Was a problem for Polygon employees.
              System.out.println("<-<-<-<-<-<>_>_>_>_>_2");
              System.out.println(rs.getString(5));
              session.setAttribute("thisAddress", (String)rs.getString(3));
              session.setAttribute("thisBuildingCondition", rs.getInt(4));
              session.setAttribute("thisBuildingCompany", rs.getString(5));
              session.setAttribute("thisParcelNr", rs.getInt(6));
              session.setAttribute("thisSize", rs.getInt(7));
              session.setAttribute("thisZipcode", rs.getInt(8));
          }
        }
        catch (Exception e)
        {
            session.setAttribute("text", e);
            Logger.getLogger(PolyServlet.class.getName()).log(Level.SEVERE, null, e + "WHAT");
            forward(request, response, "/Login.jsp");
        }

    }

}
