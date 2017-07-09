/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessmap.models;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author erode
 */
public class SocialMediaAccountTest {
    
    public SocialMediaAccountTest() {
    }

    /**
     * Test of getAccount method, of class SocialMediaAccount.
     */
    @Test
    public void testGetAccount() throws MalformedURLException {
        URL aSMUrl = new URL("http://www.webpage.com/");
        URL aUrl = new URL("http://www.webpage.com/username");

        SocialMedia anAcc = new SocialMedia("FAcetest", aSMUrl);
        SocialMediaAccount sm = new SocialMediaAccount("username", aUrl, anAcc);
        
        assertEquals(sm.getAccount(), anAcc);    
    }

    /**
     * Test of setAccount method, of class SocialMediaAccount.
     */
    @Test
    public void testSetAccount() {
    }

    /**
     * Test of getUserName method, of class SocialMediaAccount.
     */
    @Test
    public void testGetUserName() {
    }

    /**
     * Test of setUserName method, of class SocialMediaAccount.
     */
    @Test
    public void testSetUserName() {
    }

    /**
     * Test of getEmpId method, of class SocialMediaAccount.
     */
    @Test
    public void testGetEmpId() {
    }

    /**
     * Test of setEmpId method, of class SocialMediaAccount.
     */
    @Test
    public void testSetEmpId() {
    }
    
}
