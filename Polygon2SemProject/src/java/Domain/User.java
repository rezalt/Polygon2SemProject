package Domain;

import java.util.ArrayList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JAJAJABLESES
 */
public class User
{

    int id;
    String username;
    String password;
    String companyName;
    ArrayList buildingNames = new ArrayList();
    int type = 0;

    public ArrayList getBuildingNames()
    {
        return buildingNames;
    }

    public void setBuildingNames(ArrayList buildingNames)
    {
        this.buildingNames = buildingNames;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public User()
    {
        this.type = 0;
    }

    public User(String username, String password, String companyName, int type)
    {
        this.username = username;
        this.password = password;
        this.companyName = companyName;
        this.type = type;
    }
}
