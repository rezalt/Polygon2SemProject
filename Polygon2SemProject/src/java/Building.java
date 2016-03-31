/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Henrik
 */
public class Building
{

    int ID;
    String name;
    String address;
    int condition;
    String owner;
    String ParcelNo;

    public int getID()
    {
        return ID;
    }
      
    public void setID(int ID)
    {
        this.ID = ID;
    }

    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public int getCondition()
    {
        return condition;
    }

    public void setCondition(int condition)
    {
        this.condition = condition;
    }
    
    public String getOwner()
    {
        return owner;
    }

    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    public String getParcelNo()
    {
        return ParcelNo;
    }
    
    public void setParcelNo(String ParcelNo)
    {
        this.ParcelNo = ParcelNo;
    }

    public Building(int ID, String name, String address, int condition, String owner, String ParcelNo)
    {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.condition = condition;
        this.owner = owner;
        this.ParcelNo = ParcelNo;
    }

    
    
}
