/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josephawwal
 */


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserMapper {
     Connection conn;
            DBConnector DBC = new DBConnector();
            String company;
            
            
              public ArrayList<String> getUsersBuildingNames(HttpServletRequest request, HttpServletResponse response, String username)throws IOException, ServletException
    {
        ArrayList<String> buildingNames = new ArrayList();
                conn = DBC.getConnection();

        String sql = "SELECT * FROM building WHERE buildingCompany =?";
        
    
        
        return buildingNames;
    }
}
