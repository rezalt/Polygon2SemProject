package Domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author josephawwal
 */
import Controllers.PolyServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BuildingMapper
{

    DBConnector DBC = new DBConnector();
    Connection conn = DBC.getConnection();

    public BuildingMapper()
    {

    }

    public void create(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws DataMapperException
    {
        if (conn != null) {

            PreparedStatement ps = null;

            try (Statement st = conn.createStatement()) {

                // Creating a building                     
                st.executeQuery("SELECT buildingId, buildingName FROM building");
                ResultSet rs = st.getResultSet();

                while (rs.next()) {

                    if (rs.getString("buildingName").equals(request.getParameter("buildingName"))) {
                        session.setAttribute("text", "Building already exists");
                        st.close();
                    }

                }
                // Makes sure we don't show a meaningless error message.
                session.setAttribute("text", " ");
                st.close();

                // Inserting our new building to the database.
                ps = conn.prepareStatement("insert into building(buildingName, address, buildingCondition, buildingCompany, parcelNr, size, zipcode) values(?,?,?,?,?,?,?)");

                ps.setString(1, request.getParameter("buildingName"));
                ps.setString(2, request.getParameter("address"));
                ps.setInt(3, Integer.parseInt(request.getParameter("buildingCondition")));
                ps.setString(4, request.getParameter("buildingCompany"));
                ps.setInt(5, Integer.parseInt(request.getParameter("parcelNr")));
                ps.setInt(6, Integer.parseInt(request.getParameter("Size")));
                ps.setInt(7, Integer.parseInt(request.getParameter("Zipcode")));

                int i = ps.executeUpdate();

                ps.close();

            }
            catch (SQLException e) {
                throw new DataMapperException("Error occured at building creation ", e);
            }

        }

    }

    public void setBuildingAttributes(HttpSession session, HttpServletRequest request, HttpServletResponse response, String buildingName) throws IOException, ServletException
    {
        DBConnector DBC = new DBConnector();
        Connection conn = DBC.getConnection();

        String sql = "SELECT * FROM building WHERE buildingName =?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, buildingName);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // "this" is added as prefix to prevent overriding user session info, 
                // especially the users company name. Was a problem for Polygon employees.
                session.setAttribute("thisAddress", (String) rs.getString(3));
                session.setAttribute("thisBuildingCondition", rs.getInt(4));
                session.setAttribute("thisBuildingCompany", rs.getString(5));
                session.setAttribute("thisParcelNr", rs.getInt(6));
                session.setAttribute("thisSize", rs.getInt(7));
                session.setAttribute("thisZipcode", rs.getInt(8));
            }
        }
        catch (Exception e) {
            session.setAttribute("text", e);
            //Logger.getLogger(PolyServlet.class.getName()).log(Level.SEVERE, null, e + "WHAT");
            //forward(request, response, "/Login.jsp");
        }

    }

    public static Integer tryParse(String text)
    {
        try {
            return Integer.parseInt(text);
        }
        catch (NumberFormatException e) {
            return 0;
        }
    }

}
