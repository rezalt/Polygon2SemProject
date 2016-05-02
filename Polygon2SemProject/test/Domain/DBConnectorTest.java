/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jaw40
 */
public class DBConnectorTest
{
    
    public DBConnectorTest()
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
     * Test of getConnection method, of class DBConnector.
     */
    @Test
    public void testGetConnection()
    {
        System.out.println("getConnection");
        DBConnector instance = new DBConnector();
        Connection expResult = null;
        Connection result = instance.getConnection();
        System.out.println(result);
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of putConnection method, of class DBConnector.
     */

}
