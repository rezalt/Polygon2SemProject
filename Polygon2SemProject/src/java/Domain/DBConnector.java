package Domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Henrik
 */
public class DBConnector
{

    String URL;
    String Username;
    String Password;

    public Connection getConnection()
    {
        Connection conn = null;
        try
        {
            conn = DriverManager.getConnection(getDbURL(), getDbUsername(), getDbPassword());
        }
        catch (SQLException e)
        {
            System.out.println("Could not connect to DB: " + e.getMessage());
        }
        return conn;
    }

    public void putConnection(Connection conn)
    {
        if (conn != null)
        {
            try
            {
                conn.close();
            }
            catch (SQLException e)
            {
            }
        }
    }

    public void setDbURL(String URL)
    {
        this.URL = URL;
    }

    public void setDbUsername(String Username)
    {
        this.Username = Username;
    }

    public void setDbPassword(String Password)
    {
        this.Password = Password;
    }

    public String getDbURL()
    {
        return URL;
    }

    public String getDbUsername()
    {
        return Username;
    }

    public String getDbPassword()
    {
        return Password;
    }

}
