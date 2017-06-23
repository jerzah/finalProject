/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessmap.controllers;

import businessmap.models.Business;
import businessmap.models.Department;
import businessmap.models.Employee;
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
        testControl.setSelectedBusiness(testBus);
        assertEquals(testControl.getSelectedBusiness().getName(), testBus);
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
        assertEquals(this.testControl.getSelectedDepartment().getName(), null);
        String testDept = "test Dep";
        testControl.setSelectedDepartment(testDept);
        assertEquals(testControl.getSelectedDepartment().getName(), testDept);
    }

    /**
     * Test of setSelectedEmployee method, of class Control.
     */
    @Test
    public void testSetSelectedEmployee() 
    {
        System.out.println("test -> setSelectedEmployee(): ");
        this.testControl = new Control();
        String testEmpl = "Rinder";
        int idNum = 2;
        this.testControl.setSelectedEmployee(idNum);
        System.out.println(this.testControl.getSelectedEmployee().getSecondName());
        assertEquals(this.testControl.getSelectedEmployee().getSecondName(), testEmpl);
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
        this.testControl.setSelectedBusiness(testBus);
        assertEquals(this.testControl.getSelectedBusiness().getName(), testBus);
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
        this.testControl.setSelectedDepartment(testDept);
        assertEquals(this.testControl.getSelectedDepartment().getName(), testDept);        

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
        String testName = "Adam";
        this.testControl.setSelectedEmployee(1);
        assertEquals(this.testControl.getSelectedEmployee().getFirstName(), testName); 

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
        assertEquals(aControl.getSelectedEmployee().getFirstName(),"firstName");
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
}
