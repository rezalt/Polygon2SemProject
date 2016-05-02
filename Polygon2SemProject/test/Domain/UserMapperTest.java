/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.ArrayList;
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
public class UserMapperTest
{
    
    public UserMapperTest()
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
     * Test of login method, of class UserMapper.
     */
    @Test
    public void testLogin() throws Exception
    {
        System.out.println("login");
        String username = "Admin";
        String password = "1234";
        UserMapper instance = new UserMapper();
        User expResult = null;
        User result = instance.login(username, password);
        //assertEquals(expResult, result);
        assertNotNull(result);
        username = "Ad123min";
        password = "1234";
        instance = new UserMapper();
        expResult = null;
        result = instance.login(username, password);
        assertEquals(result.getCompanyName(), "doesNotExists");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
    
    
}
