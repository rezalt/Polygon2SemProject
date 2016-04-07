
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
    ArrayList<Building> buildings = new ArrayList();
    
    public void addBuilding(int ID, String name, String address, int condition, String owner, String parcelNo)
    {
        Building tempBuilding=new Building(ID, name, address, condition, owner, parcelNo);
        buildings.add(tempBuilding);
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
   
    
    public User(int id, String username, String password)
    {
        this.id=id;
        this.password=password;
        this.username=username;
        
    }
}
