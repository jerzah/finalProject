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
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author erode
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SocialMediaTest {
    
    public SocialMediaTest() {
    }

    /**
     * Test of getId method, of class SocialMedia.
     */
    @Test
    public void testGetId() throws MalformedURLException 
    {
        URL aUrl = new URL("http://www.webpage.com");
        SocialMedia sm = new SocialMedia("testMedia", aUrl);
        sm.setId(1);
        assertEquals(sm.getId(), 1);
                
    }

    /**
     * Test of setId method, of class SocialMedia.
     */
    @Test
    public void testSetId() throws MalformedURLException 
    {
        URL aUrl = new URL("http://www.webpage.com");
        SocialMedia sm = new SocialMedia("testMedia", aUrl);
        sm.setId(1);
        assertEquals(sm.getId(), 1);
    }

    /**
     * Test of getName method, of class SocialMedia.
     */
    @Test
    public void testGetName() throws MalformedURLException 
    {
        URL aUrl = new URL("http://www.webpage.com");
        SocialMedia sm = new SocialMedia("testMedia", aUrl);
        assertEquals(sm.getName(), "testMedia");
    }

    /**
     * Test of setName method, of class SocialMedia.
     */
    @Test
    public void testSetName() throws MalformedURLException 
    {
        URL aUrl = new URL("http://www.webpage.com");
        SocialMedia sm = new SocialMedia("testMedia", aUrl);
        sm.setName("NEWNAME");
        assertEquals(sm.getName(), "NEWNAME");
    }


    /**
     * Test of getAddress method, of class SocialMedia.
     */
    @Test
    public void testGetAddress() throws MalformedURLException 
    {
        URL aUrl = new URL("http://www.webpage.com");
        SocialMedia sm = new SocialMedia("testMedia", aUrl);
        assertEquals(sm.getAddress(), aUrl);
    }

   

    /**
     * Test of setAddress method, of class SocialMedia.
     */
    @Test
    public void testSetAddress() throws MalformedURLException 
    {
        URL aUrl = new URL("http://www.webpage.com");
        SocialMedia sm = new SocialMedia("testMedia", aUrl);
        URL newUrl = new URL("http://www.wooe.com");
        sm.setAddress(newUrl);
        assertEquals(sm.getAddress(), newUrl);
    }
        
    @Test 
    public void testSave() throws MalformedURLException
    {
        URL aUrl = new URL("http://www.hello.com");
        SocialMedia sm = new SocialMedia("one", aUrl);
        assertEquals(sm.save(), true);      
        assertEquals(sm.deleteEntry(), true);      
    }
    
    @Test 
    public void isSaved() throws MalformedURLException
    {
        URL aUrl = new URL("http://www.webpage.com");
        SocialMedia sm = new SocialMedia("testMedia", aUrl);
        assertEquals(sm.save(), true);
        assertEquals(sm.isSaved(), true);
        sm.deleteEntry();
    }
    
    @Test 
    public void deleteEntry() throws MalformedURLException
    {
        URL aUrl = new URL("http://www.webpage.com");
        SocialMedia sm = new SocialMedia("one love", aUrl);
        assertEquals(sm.deleteEntry(), true);      
        assertEquals(sm.getId(),0);
    }
    
}
