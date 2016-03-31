/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Gruppe 4 - A
 */
public interface BuildingInterface
{

    /**
     * Pre: This adds a new building to the mySQL database.
     * @param ID
     * @param name
     * @param address
     * @param condition
     * @param owner
     * @param ParcelNo
     * @return 
     */
    int addBuilding( int ID, String name, String address, int condition, String owner, String ParcelNo);


    /**
     * This deletes a building from the application and mySQL database.
     * @return 
     */
    int delBuilding();
    
    /**
    * This updates a buidling with the current attributes selected in the application, to the database. 
    */
    void updateBuilding();
    
    
    int getId();
    
    void setId();
    
    String getName();
    
    void setName();
    
    String getAdress();
    
    void setAdress();
            
    int getCondition();
    
    void setCondition();
    
    String getOwner();
    
    void setOwner();
            
    String getParcelNo();
    
    void setParcelNo();
}



