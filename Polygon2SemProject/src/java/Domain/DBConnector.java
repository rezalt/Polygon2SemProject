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
    SecretData sd = new SecretData();
    String url = sd.getURL();
    String username = sd.getUsername();
    String password = sd.Password;

    public Connection getConnection()
    {
        Connection conn = null;
        try
        {
            conn = DriverManager.getConnection(getDbURL(), getDbUsername(), getDbPassword());
        }
        catch (Exception e)
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

    public void setDbURL(String url)
    {
        this.url = url;
    }

    public void setDbUsername(String username)
    {
        this.username = username;
    }

    public void setDbPassword(String password)
    {
        this.password = password;
    }

    public String getDbURL()
    {
        return url;
    }

    public String getDbUsername()
    {
        return username;
    }

    public String getDbPassword()
    {
        return password;
    }

}
