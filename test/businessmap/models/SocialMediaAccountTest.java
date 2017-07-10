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
        //URL aUrl = new URL("http://www.webpage.com/username");

        SocialMedia anAcc = new SocialMedia("FAcetest", aSMUrl);
        SocialMediaAccount sm = new SocialMediaAccount("username", anAcc);
        
        assertEquals(sm.getAccount(), anAcc);    
    }

    /**
     * Test of setAccount method, of class SocialMediaAccount.
     */
    @Test
    public void testSetAccount() throws MalformedURLException{
       URL aSMUrl = new URL("http://www.webpage.com/");
        SocialMedia smAcc = new SocialMedia("FAcetest", aSMUrl);
        SocialMediaAccount anAcc = new SocialMediaAccount();
        anAcc.setAccount(smAcc);
        assertEquals(anAcc.getAccount(),smAcc);
    }

    /**
     * Test of getUserName method, of class SocialMediaAccount.
     */
    @Test
    public void testGetUserName() throws MalformedURLException {
        URL aSMUrl = new URL("http://www.webpage.com/");
     //   URL aUrl = new URL("http://www.webpage.com/username");

        SocialMedia anAcc = new SocialMedia("FAcetest", aSMUrl);
        SocialMediaAccount sm = new SocialMediaAccount("username", anAcc);
        assertEquals(sm.getUserName(), "username");    
    }

    /**
     * Test of setUserName method, of class SocialMediaAccount.
     */
    @Test
    public void testSetUserName() throws MalformedURLException {
        URL aSMUrl = new URL("http://www.webpage.com/");
        SocialMedia anAcc = new SocialMedia("FAcetest", aSMUrl);
        SocialMediaAccount sm = new SocialMediaAccount("username", anAcc);
        assertEquals(sm.getUserName(), "username");
     
    }

    /**
     * Test of getEmpId method, of class SocialMediaAccount.
     */
    @Test
    public void testGetEmpId() throws MalformedURLException {
        URL aSMUrl = new URL("http://www.webpage.com/");
        SocialMedia anAcc = new SocialMedia("FAcetest", aSMUrl);
        SocialMediaAccount sm = new SocialMediaAccount("username", anAcc, 1);
        
        assertEquals(sm.getEmpId(), 1);
        
    }

    /**
     * Test of setEmpId method, of class SocialMediaAccount.
     */
    @Test
    public void testSetEmpId() throws MalformedURLException {
        URL aSMUrl = new URL("http://www.webpage.com/");
        SocialMedia anAcc = new SocialMedia("FAcetest", aSMUrl);
        SocialMediaAccount sm = new SocialMediaAccount("username", anAcc);
        sm.setEmpId(1);
        assertEquals(sm.getEmpId(), 1);
        
    }
    
}
