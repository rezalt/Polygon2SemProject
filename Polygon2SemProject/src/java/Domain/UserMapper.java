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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserMapper
{

    Connection conn;
    DBConnector DBC = new DBConnector();
    String company;

    public ArrayList<String> getUsersBuildingNames(String username) throws DataMapperException
    {
        ArrayList<String> buildingNames = new ArrayList();
        conn = DBC.getConnection();

        String sql = "SELECT * FROM building WHERE buildingCompany =?";

        try (PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setString(1, company);
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {

                buildingNames.add(rs.getString(2));

            }
        }
        catch (SQLException e)
        {
            throw new DataMapperException("Error occured when getting building names", e);
        }

        return buildingNames;

    }

    public String getUserType(String username)
    {
        return null;
    }

}
