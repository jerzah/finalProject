/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessmap.controllers;

import businessmap.models.Business;
import businessmap.models.Department;
import businessmap.models.Employee;
import businessmap.models.SocialMedia;
import businessmap.models.SocialMediaAccount;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author erode
 */
public class ControlTest {
    
    Control testControl;
    public ControlTest() {
    }

    /**
     * Test of setSelectedBusiness method, of class Control.
     */
    @Test
    public void testSetSelectedBusiness() {
        System.out.println("test -> setSelectedBusiness(): ");
        this.testControl = null;
        assertNull(this.testControl);
        this.testControl = new Control();
        assertNotNull(this.testControl);
        String testBus = "test ";
        testControl.setBusiness(testBus);
        assertEquals(testControl.getBusiness().getName(), testBus);
    }

    /**
     * Test of setSelectedDepartment method, of class Control.
     */
    @Test
    public void testSetSelectedDepartment() 
    {
        System.out.println("test -> setSelectedDepartment(): ");
        assertNull(this.testControl);
        this.testControl = new Control();
        assertNotNull(this.testControl);
        assertEquals(this.testControl.getDepartment().getName(), null);
        String testDept = "test Dep";
        testControl.setDepartment(testDept);
        assertEquals(testControl.getDepartment().getName(), testDept);
    }

    /**
     * Test of setSelectedEmployee method, of class Control.
     */
    @Test
    public void testSetEmployee() 
    {
        System.out.println("test -> setSelectedEmployee(): ");
        this.testControl = new Control();
        String testEmpl = "Doe";
        int idNum = 1;
        this.testControl.setEmployee(idNum);
        System.out.println(this.testControl.getEmployee().getSecondName());
        assertEquals(this.testControl.getEmployee().getSecondName(), testEmpl);
    }

    /**
     * Test of getSelectedBusiness method, of class Control.
     */
    @Test
    public void testGetSelectedBusiness() {
        System.out.println("test -> getSelectedBusiness(): ");
        this.testControl = null;
        assertNull(this.testControl);
        this.testControl = new Control();
        assertNotNull(this.testControl);
        String testBus = "business";
        assertEquals(this.testControl.addBusiness("business"),true);
        this.testControl.setBusiness(testBus);
        assertEquals(this.testControl.getBusiness().getName(), testBus);
    }

    
    /**
     * Test of getSelectedDepartment method, of class Control.
     */
    @Test
    public void testGetSelectedDepartment() {
        System.out.println("test -> getSelectedDepartment(): ");
        this.testControl = null;
        assertNull(this.testControl);
        this.testControl = new Control();
        assertNotNull(this.testControl);
        String testDept = "department";
        assertEquals(this.testControl.addDepartment(testDept),true);
        this.testControl.setDepartment(testDept);
        assertEquals(this.testControl.getDepartment().getName(), testDept);        

    }

    /**
     * Test of getSelectedEmployee method, of class Control.
     */
    @Test
    public void testGetSelectedEmployee() {
        System.out.println("test -> getSelectedEmployee(): ");
        this.testControl = null;
        assertNull(this.testControl);
        this.testControl = new Control();
        assertNotNull(this.testControl);
        String testName = "John";
        this.testControl.setEmployee(1);
        assertEquals(this.testControl.getEmployee().getFirstName(), testName); 

    }

    /**
     * Test of getDepartments method, of class Control.
     */
    @Test
    public void testGetDepartments() {
        System.out.println("test -> getDepartments(): ");

    }

    /**
     * Test of getEmployees method, of class Control.
     */
    @Test
    public void testGetEmployees_0args() {
                System.out.println("test -> getDepartments(): ");

    }

    /**
     * Test of getBusinesses method, of class Control.
     */
    @Test
    public void testGetBusinesses() {
    }

    /**
     * Test of getDepartments method, of class Control.
     */
    @Test
    public void testGetDepartments_Business() {
    }

    /**
     * Test of getEmployees method, of class Control.
     */
    @Test
    public void testGetEmployees_Department() {
    }

    /**
     * Test of getEmployee method, of class Control.
     */
    @Test
    public void testGetEmployee() {
    }

    /**
     * Test of printBusinesses method, of class Control.
     */
    @Test
    public void testPrintBusinesses() {
    }

    
    /**
     * Test of saveEmployee method, of class Control.
     */
    @Test
    public void testAddEmployee() 
    {
        Control aControl = new Control();        
        aControl.addEmployee(new Department("Finance"), new Business("huxley"), "firstName", "secondName");
        assertEquals(aControl.getEmployee().getFirstName(),"firstName");
        assertEquals(aControl.removeEmployee(),true);
    }
    
    /**
     * Test of addBusiness method, of class Control.
     */
    @Test
    public void testAddBusiness() 
    {
        Control aControl = new Control();
        assertEquals(aControl.addBusiness("ABusiness"), true);
        assertEquals(aControl.removeBusiness(), true);
    }
    
    
        /**
     * Test of addBusiness method, of class Control.
     */
    @Test
    public void testAddDepartment() 
    {
        Control aControl = new Control();
        assertEquals(aControl.addDepartment("aDept"), true);
        assertEquals(aControl.removeDepartment(), true);
    }
    
    
    @Test
    public void testRemoveEmployee()
    {
        Control aControl = new Control();
        aControl.addEmployee(new Department("Finance"), new Business("huxley"), "firstName", "secondName");
        assertEquals(aControl.removeEmployee(),true);
    }
    
        @Test
    public void removeBusiness()
    {
        Control aControl = new Control();
        assertEquals(aControl.addBusiness("ABusiness"), true);
        assertEquals(aControl.removeBusiness(), true);
    }
    
    
    @Test 
    public void countDepartments() throws MalformedURLException
    {
        Control aCont = new Control();
        assertEquals(aCont.countDepartments(),0);
    }
    
    @Test
    public void TestaddSocialMedia() throws MalformedURLException
    {
        Control aCont = new Control();
        SocialMedia sm = new SocialMedia("Test media", new URL("http://www.testyurl.com"));
        assertEquals(aCont.getSocialMedia(), null);
        sm.save();
        assertEquals(sm.isSaved(), true);
        aCont.setSocialMedia(sm);
        //Check that object has been created
        assertNotNull(aCont.getSocialMedia());
        //Test id has been retrrieved and set
        assertNotEquals(aCont.getSocialMedia().getId(),0);
        System.out.println("AddSocialMedia(): "+aCont.getSocialMedia().getName());   
        sm.isSaved();
        assertEquals(sm.deleteEntry(), true);    
    }
    
    @Test 
    public void TestAddSocialMediaAccount() throws MalformedURLException
    {
        Control aControl = new Control();
        Business bus =  new Business("huxley");
        Department dept = new Department("Finance");
        bus.save();
        dept.save();     
        bus.isSaved();
        dept.isSaved();
        
        aControl.addEmployee(dept, bus, "firstName", "secondName");
        assertEquals(aControl.getEmployee().getFirstName(),"firstName");
        
        URL testURL =  new URL("http://www.bhjghbhjbhj.com");
        URL testURLAcc =  new URL("http://www.bhjghbhjbhj.com/user");

        SocialMedia sm = new SocialMedia("Test88media", testURL);
        aControl.addSocialMedia(sm);
        
        assertEquals(aControl.addSocialMediaAccount("helper", testURLAcc, "Password"), true) ;
        assertNotNull(sm.getId());
    }
    
    @Test
    public void warningMessage()
    {
        Control aControl = new Control();
        assertEquals(aControl.warningMessage("no"), false);
        assertEquals(aControl.warningMessage("n"), false);
        assertEquals(aControl.warningMessage("No"), false);
        assertEquals(aControl.warningMessage("y"), true);
        assertEquals(aControl.warningMessage("Y"), true);
        assertEquals(aControl.warningMessage("Yes"), true);
    }
            
}
