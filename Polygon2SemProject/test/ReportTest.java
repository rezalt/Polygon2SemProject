/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JAJAJABLESES
 */
public class ReportTest
{
    
    public ReportTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of addRoom method, of class Report.
     */
    @Test
    public void testAddRoom()
    {
        System.out.println("addRoom");
        String roomName = "";
        Boolean notices = null;
        Boolean damagedRoom = null;
        String dateOfDamage = "";
        String descriptionOfLocation = "";
        String explanationOfDamage = "";
        String repairs = "";
        Boolean moisture = null;
        Boolean sponge = null;
        Boolean mold = null;
        Boolean fire = true;
        Boolean otherDamage = null;
        String moistureDesctription = "";
        String spongeDescription = "";
        String moldDescription = "";
        String fireDescription = "";
        String otherDamageDescription = "";
        ArrayList<Room> rooms = new ArrayList();
        Report instance = new Report(1, "john", "23", "23e", "4000", "2000", 123, "johnbuildin", false, false, "roofnotice", false, false, "no", rooms, "johnbørge", null, 2);
        
    
        instance.addRoom(roomName, notices, damagedRoom, dateOfDamage, descriptionOfLocation, explanationOfDamage, repairs, moisture, sponge, mold, fire, otherDamage, moistureDesctription, spongeDescription, moldDescription, fireDescription, otherDamageDescription);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println(instance.getRooms().get(0).getFire());
        assertEquals(instance.getRooms().get(0).getFire(), true);
    }

    /**
     * Test of getReportId method, of class Report.
     */
   

    /**
     * Test of setReportId method, of class Report.
     */
   
    
}
