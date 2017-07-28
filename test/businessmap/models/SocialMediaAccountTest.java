/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessmap.models;

import businessmap.controllers.Control;
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
     **/
    @Test
    public void testGetAccount() throws MalformedURLException {
        Control con = new Control();
        Business aBus = new Business("Mister Valet");
        
        Department aDept = new Department("Software");
        aBus.save();
        aDept.save();
        con.addEmployee(aDept, aBus, "Mike", "pain");
        URL aSMUrl = new URL("http://www.webpage.com/");

        SocialMedia anAcc = new SocialMedia("FAcetest", aSMUrl);
        SocialMediaAccount sm = new SocialMediaAccount(con.getEmployee(), "username", anAcc);
        
        assertEquals(sm.getAccount(), anAcc);  
        con.getEmployee().deleteEntry();
    }


    @Test
    public void testSetAccount() throws MalformedURLException{
       URL aSMUrl = new URL("http://www.webpage.com/");
        SocialMedia smAcc = new SocialMedia("FAcetest", aSMUrl);
        SocialMediaAccount anAcc = new SocialMediaAccount();
        anAcc.setAccount(smAcc);
        assertEquals(anAcc.getAccount(),smAcc);

    }


    @Test
    public void testGetUserName() throws MalformedURLException {
        URL aSMUrl = new URL("http://www.webpage.com/");
         Control con = new Control();
         Business aBus = new Business("Mister Valet");
         Department aDept = new Department("Software");
                  aBus.save();
         aDept.save();
         con.addEmployee(aDept, aBus, "Mike", "pain");
        SocialMedia anAcc = new SocialMedia("FAcetest", aSMUrl);
        SocialMediaAccount sm = new SocialMediaAccount(con.getEmployee(),"username", anAcc);
        assertEquals(sm.getUserName(), "username");  
        con.getEmployee().deleteEntry();

    }


    @Test
    public void testSetUserName() throws MalformedURLException {
        Control con = new Control();
        Business aBus = new Business("Mister Valet");
        Department aDept = new Department("Software");
        aBus.save();
        aDept.save();
        con.addEmployee(aDept, aBus, "Mike", "pain");
        URL aSMUrl = new URL("http://www.webpage.com/");
        SocialMedia anAcc = new SocialMedia("FAcetest", aSMUrl);
        SocialMediaAccount sm = new SocialMediaAccount(con.getEmployee(), "username", anAcc);
        assertEquals(sm.getUserName(), "username");
        con.getEmployee().deleteEntry();

    }


    @Test
    public void testGetEmpId() throws MalformedURLException {
        Control con = new Control();
        Business aBus = new Business("Mister Valet");
        Department aDept = new Department("Software");
        aBus.save();
        aDept.save();
        con.addEmployee(aDept, aBus, "Mike", "pain");
        URL aSMUrl = new URL("http://www.webpage.com/");
        SocialMedia anAcc = new SocialMedia("FAcetest", aSMUrl);
        SocialMediaAccount sm = new SocialMediaAccount(con.getEmployee(),"username", anAcc);
        sm.setEmpId(1);
        assertEquals(sm.getEmpId(), 1);
        con.getEmployee().deleteEntry();
    }


    @Test
    public void testSetEmpId() throws MalformedURLException {
        URL aSMUrl = new URL("http://www.webpage.com/");
        Control con = new Control();
        Business aBus = new Business("Mister Valet");
        Department aDept = new Department("Software");
        aBus.isSaved();
        aDept.isSaved();
        con.addEmployee(aDept, aBus, "Mike", "pain");
        SocialMedia anAcc = new SocialMedia("FAcetest", aSMUrl);
        SocialMediaAccount sm = new SocialMediaAccount(con.getEmployee(),"username", anAcc);
        sm.setEmpId(1);
        assertEquals(sm.getEmpId(), 1);        
    }
    
    
    @Test
    public void testSave() throws MalformedURLException
    {
         Control con = new Control();
         Business aBus = new Business("Mister Valet");
         Department aDept = new Department("Software");
         aBus.isSaved();
         aDept.isSaved();
         
         con.addEmployee(aDept, aBus, "austin", "zoo");
         URL aSMUrl = new URL("http://www.help.com/");
         SocialMedia anAcc = new SocialMedia("FAcetest", aSMUrl);
         System.out.println(con.getEmployee().getIdNum());
         anAcc.save();
         anAcc.isSaved();
         System.out.println("Check anAcc: " + anAcc.getId() +" " +anAcc.getName());
         SocialMediaAccount sm = new SocialMediaAccount(con.getEmployee(),"test", anAcc);
         sm.setEmpId();
         
         sm.setLink("http://www.test.com/toldyu");
         assertEquals(sm.save(),true);
         System.out.println("ID NUMBER: " + sm.getEmpId());
         assertNotEquals(sm.getEmpId(),0);
         sm.deleteEntry();
    }
    
    @Test
    public void testIsSaved()
    {
        
    }
    
    @Test
    public void testDeleteEntry() throws MalformedURLException
    {
        Control con = new Control();
         Business aBus = new Business("Mister Valet");
         Department aDept = new Department("Software");
         aBus.isSaved();
         aDept.isSaved();
         
         con.addEmployee(aDept, aBus, "John", "Doe");
         URL aSMUrl = new URL("http://www.webpage.com/");
         SocialMedia anAcc = new SocialMedia("FAcetest", aSMUrl);
         System.out.println(con.getEmployee().getIdNum());
         anAcc.save();
         anAcc.isSaved();
         
         SocialMediaAccount sm = new SocialMediaAccount(con.getEmployee(),"ghgh", anAcc);
         sm.setEmpId();
         sm.setLink("http://www.help.com/tolgfghgf");
         sm.save();
         assertEquals(sm.deleteEntry(), true);

    }
    
}
