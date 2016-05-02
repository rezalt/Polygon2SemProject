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
import java.sql.Statement;

public class UserMapper
{

    public UserMapper()
    {

    }

    DBConnector DBC = new DBConnector();
    Connection conn = DBC.getConnection();
    ;
    User user = null;

    public User login(String username, String password) throws DataMapperException
    {

        if (conn != null) {
            String sql = "SELECT * FROM user WHERE name =? and password =?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {

                    int type = rs.getInt(7);
                    String company = rs.getString(4);

                    if (type == 2) // Admin 
                    {
                        user = new User(username, password, company, type);
                        user.setBuildingNames(setUserBuildingNames(username, company, type));
                    }

                    else if (type == 1) // 1: Employee
                    {
                        user = new User(username, password, company, type);
                        user.setBuildingNames(setUserBuildingNames(username, company, type));
                    }

                    else if (type == 0) // 0: User
                    {
                        user = new User(username, password, company, type);
                        user.setBuildingNames(setUserBuildingNames(username, company, type));
                    }
                }
                else {
                    // 4: User does not exist
                    user = new User(username, password, "doesNotExists", 4);
                }
                return user;

            }
            catch (SQLException e) {
                throw new DataMapperException("Error occured at user log-in ", e);
            }

        }

        user = new User(username, password, "doesNotExists", 5); // 5: No connection.
        return user;
    }

    public User newUser(String username, String password, String companyName, String companyAddress, int Zip) throws DataMapperException
    {

        if (conn != null) {
            try (Statement st = conn.createStatement()) {

                // Creating a user                      
                st.executeQuery("SELECT userid, name FROM user");
                ResultSet rs = st.getResultSet();

                while (rs.next()) {

                    if (rs.getString("name").equals(username)) {
                        // type 3: User already exists
                        user = new User(username, password, "alreadyExists", 3);
                        st.close();
                        return user;
                    }

                }
                st.close();

                try ( // Her indsætter vi vores nye user ind i databasen.
                        PreparedStatement ps = conn.prepareStatement("insert into user(name,password,"
                                + "companyName,companyAddress,Zip) "
                                + "values(?,?,?,?,?)")) {
                    ps.setString(1, username);
                    ps.setString(2, password);
                    ps.setString(3, companyName);
                    ps.setString(4, companyAddress);
                    ps.setInt(5, Zip);

                    int i = ps.executeUpdate();
                    if (i > 0) {
                        user = new User(username, password, companyName, 0);
                        user.setBuildingNames(setUserBuildingNames(username, companyName, 0));
                    }
                    else {
                        // Error creating user
                        // 4: User does not exist
                        user = new User(username, password, "doesNotExists", 4);
                        ps.close();
                    }
                }

                return user;
            }
            catch (SQLException e) {
                throw new DataMapperException("Error occured at user creation ", e);
            }
        }
        user = new User(username, password, "doesNotExists", 5); // 5: No connection.
        return user;
    }

    public ArrayList<String> setUserBuildingNames(String username, String company, int type) throws DataMapperException
    {
        ArrayList<String> buildingNames = new ArrayList();
        String sql;

        if (type == 2 || type == 1) {
            sql = "SELECT buildingName FROM building";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    buildingNames.add(rs.getString("buildingName"));
                }
                ps.close();
            }
            catch (SQLException e) {
                throw new DataMapperException("Error occured when getting building names to admin ", e);
            }
        }
        else {
            sql = "SELECT buildingName, buildingCompany FROM building WHERE buildingCompany = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, company);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    buildingNames.add(rs.getString(2));
                }
                ps.close();
            }
            catch (SQLException e) {
                throw new DataMapperException("Error occured when getting building names", e);
            }
        }

        return buildingNames;

    }

}
