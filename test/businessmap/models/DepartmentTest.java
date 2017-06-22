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
 */
public class DepartmentTest {
    
    Department aDept;
    
    public DepartmentTest() {
    }

   /**
     * Test of setName method
     */
    @Test
    public void testSetName() {
        System.out.println("setName() test");
        String name = "test Department";
        this.aDept = null;
        assertNull(this.aDept);
        this.aDept = new Department();
        this.aDept.setName(name);
        assertEquals(this.aDept.getName(), name);
    }

    /**
     * Test of getName method
     */
    @Test
    public void testGetName() {
        System.out.println("getName() test");
        this.aDept=null;
        assertNull(this.aDept);
        String name = "test Department";
        this.aDept = new Department();
        this.aDept.setName(name);  
        assertEquals(this.aDept.getName(), name);
    }

    /**
     * Test of getIdNum method
     */
    @Test
    public void testSetIdNum() {
    this.aDept = new Department("test Department");
    int num = 1;
     this.aDept.setIdNum(num);
    assertEquals(this.aDept.getIdNum(), num);

    }
    
    
    
    @Test
    public void testSave() 
    {
        System.out.println("save() test");
        Department aDepartment = new Department("test department");
        assertEquals(aDepartment.save(), true);
        aDepartment.deleteEntry();

    }

    /**
     * Test of isSaved method, of class Department.
     */
    @Test
    public void testIsSaved() {
        System.out.println("isSaved() test");
        this.aDept = new Department("deleted department");
        assertEquals(this.aDept.save(), true);
        assertEquals(this.aDept.isSaved(), true);
        assertEquals( this.aDept.deleteEntry(), true);
    }
    
    @Test
    public void testdeleteEntry() {
        System.out.println("deleteEntry() test");
        this.aDept = new Department("test Department");
        assertEquals(this.aDept.save(),true);
        assertEquals(this.aDept.deleteEntry(), true);

    }

    /**
     * Test of getEntryDB method, of class Department.
     */
    /*UNUSED SO DEACTIVATED
    @Test
    public void testGetEntry() {
        String bus = "a Department";
        Department testDep = new Department(bus);
        assertEquals(testDep.getEntry().getName(), null);
        assertEquals(testDep.save(), true);
        assertEquals(testDep.getEntry().getName(), bus);
        assertNotNull(testDep.getEntry().getIdNum());
        assertEquals(testDep.deleteEntry(), true);
    }
    */
    /**
     * Test of getDepartments method, of class Department.
     */
    @Test
    public void testGetDepartments() {
    }
    
}
