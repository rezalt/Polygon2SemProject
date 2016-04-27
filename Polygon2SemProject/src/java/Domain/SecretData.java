/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author Henrik
 */
public class SecretData
{
    
    String URL = "jdbc:mysql://91.100.100.141:3360/polygondb";
    String Username = "Admin";
    String Password = "CBAmoria";

    public String getURL()
    {
        return URL;
    }

    public String getUsername()
    {
        return Username;
    }

    public String getPassword()
    {
        return Password;
    }

    
}
