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
public class SocialMediaTest {
    
    public SocialMediaTest() {
    }

    /**
     * Test of getId method, of class SocialMedia.
     */
    @Test
    public void testGetId() throws MalformedURLException {
        URL aUrl = new URL("http://www.webpage.com");
        SocialMedia sm = new SocialMedia("testMedia", aUrl,1 );
        assertEquals(sm.getId(), 1);
                
    }

    /**
     * Test of setId method, of class SocialMedia.
     */
    @Test
    public void testSetId() throws MalformedURLException {
        URL aUrl = new URL("http://www.webpage.com");
        SocialMedia sm = new SocialMedia("testMedia", aUrl);
        sm.setId(1);
        assertEquals(sm.getId(), 1);
    }

    /**
     * Test of getName method, of class SocialMedia.
     */
    @Test
    public void testGetName() throws MalformedURLException {
        URL aUrl = new URL("http://www.webpage.com");
        SocialMedia sm = new SocialMedia("testMedia", aUrl);
        assertEquals(sm.getName(), "testMedia");
    }

    /**
     * Test of setName method, of class SocialMedia.
     */
    @Test
    public void testSetName() throws MalformedURLException {
        URL aUrl = new URL("http://www.webpage.com");
        SocialMedia sm = new SocialMedia("testMedia", aUrl);
        sm.setName("NEWNAME");
        assertEquals(sm.getName(), "NEWNAME");
    }


    /**
     * Test of getAddress method, of class SocialMedia.
     */
    @Test
    public void testGetAddress() throws MalformedURLException {
        URL aUrl = new URL("http://www.webpage.com");
        SocialMedia sm = new SocialMedia("testMedia", aUrl);
        assertEquals(sm.getAddress(), aUrl);
    }

   

    /**
     * Test of setAddress method, of class SocialMedia.
     */
    @Test
    public void testSetAddress() throws MalformedURLException {
        URL aUrl = new URL("http://www.webpage.com");
        SocialMedia sm = new SocialMedia("testMedia", aUrl);
        URL newUrl = new URL("http://www.wooe.com");
        sm.setAddress(newUrl);
        assertEquals(sm.getAddress(), newUrl);
        
    }
    
}
