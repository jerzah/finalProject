/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessmap.models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author erode
 * Test cases for Business class
 */
public class BusinessTest {
    
    private Business testBus;
    private String name;
    
    public BusinessTest() {
    }
    
    /**
     * Test of setName method
     */
    @Test
    public void testSetName() {
        System.out.println("setName() test");
        this.name = "test business";
        assertNull(this.testBus);
        this.testBus = new Business();
        assertNull(this.testBus.getName());
        this.testBus.setName(name);
        assertEquals(testBus.getName(), name);
    }

    /**
     * Test of getName method
     */
    @Test
    public void testGetName() {
        System.out.println("getName() test");
        this.testBus = new Business();
        assertNull(this.testBus.getName());
        this.name = "test business";
        this.testBus.setName(this.name);
        assertEquals(this.testBus.getName(), this.name);
    }

    /**
     * Test of getIdNum method
     */
    @Test
    public void testSetIdNum() {
    this.testBus  = new Business("test business");
    assertEquals(this.testBus.getIdNum(), 0);
    int num = 1;
    this.testBus.setIdNum(num);
    assertEquals(this.testBus.getIdNum(), num);

    }
    
    /*
     @Test
     public void testPopulateDepartments()
     {
         Business testBusiness = new Business("test business");
         assertEquals(testBusiness.populateDepartments().getClass().getSimpleName(), List<Department> );
     }
    */
    
    @Test
    public void testSave() 
    {
        System.out.println("save() test");
        assertNull(this.testBus);
        this.testBus = new Business("test save");
        assertEquals(this.testBus.isSaved(),false);
        assertEquals(this.testBus.save(),true);
        assertEquals(this.testBus.isSaved(),true);
        assertEquals(this.testBus.deleteEntry(), true);
        System.out.println("TEST DELETED VALUE " +this.testBus.isSaved());
    }

    /**
     * Test of isSaved method, of class Business.
     */
    @Test
    public void testIsSaved() {
        System.out.println("isSaved() test");
        this.testBus = new Business("test isSaved");
        assertEquals(this.testBus.isSaved(), false);
        this.testBus.save();
        this.testBus.isSaved();
        assertEquals(this.testBus.deleteEntry(), true);
        assertEquals(this.testBus.isSaved(), false);

    }
    
    @Test
    public void testdeleteEntry() {
        System.out.println("deleteEntry() test");
        this.testBus = new Business("test deleteBus");
        //assertEquals(this.testBus.save(),true);
        this.testBus.save();
        assertEquals(this.testBus.deleteEntry(), true);
    }

    /**
     * Test of getBusinessDB method, of class Business.
     */
    /*UNUSED SO DEACTIVATED
    @Test
    public void testGetEntry() {
        String bus = "a Business";
        Business testBus = new Business(bus);
        assertEquals(testBus.getEntry().getName(), null);
        testBus.save();
        System.out.println("TESTER :" + testBus.getEntry().getIdNum() );
        assertEquals(testBus.getEntry().getName(), bus);
        assertNotNull(testBus.getEntry().getIdNum());
        testBus.deleteEntry();
    }
    */
    /**
     * Test of getDepartments method, of class Business.
     */
    @Test
    public void testGetDepartments() {
    }
    
}
