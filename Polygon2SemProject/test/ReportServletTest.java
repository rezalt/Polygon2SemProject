/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controllers.reportServlet;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
public class reportServletTest
{
    
    public reportServletTest()
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
     * Test of createReport method, of class reportServlet.
     */
    @Test
    public void testCreateReport()
    {
        System.out.println("createReport");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        HttpSession session = null;
        
       
        reportServlet instance = new reportServlet();
        //instance.createReport(request, response, session);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
