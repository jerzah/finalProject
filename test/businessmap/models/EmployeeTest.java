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
public class EmployeeTest {
    
    public EmployeeTest() {
    }

    Employee anEmploy;
   /**
     * Test of setName method
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName() test");
        assertNull(this.anEmploy);
        String name = "firstnameString";
        this.anEmploy = new Employee();
        this.anEmploy.setFirstName(name);
        assertEquals(this.anEmploy.getFirstName(), name);
    }

    @Test
    public void testSetSecondName() {
        System.out.println("setSecondName() test");
        this.anEmploy=null;
        assertNull(this.anEmploy);
        String name = "secondNameString";
        this.anEmploy = new Employee();
        this.anEmploy.setSecondName(name);
        assertEquals(this.anEmploy.getSecondName(), name);
    }
    /**
     * Test of getName method
     */
    /**
    @Test
    public void testGetFirstName() {
        System.out.println("getName() test");
        String name = "test Department";
        Department dep = new Department(name);  
        System.out.println("TESTGETNAME: " + dep.getName());
        assertEquals(dep.getName(), name);
    }
**
* /
* 
    /**
     * Test of getIdNum method
     */
    @Test
    public void testSetIdNum() {
    Employee aEmploy = new Employee();
    int num = 1;
    assertEquals(aEmploy.getIdNum(), 0);
    aEmploy.setIdNum(num);
    assertEquals(aEmploy.getIdNum(), num);

    }
    
    
    
    @Test
    public void testSave() 
    {
        System.out.println("save() test");
        Business aBus = new Business("huxley");
        Department aDep = new Department("Finance");
        aDep.save();
        Employee aEmploy = new Employee("Stephen", "Rinder", aBus, aDep);
        //aEmploy.deleteEntry();
        assertEquals(aEmploy.save(), true);
    }

    /**
     * Test of isSaved method, of class Department.
 
    @Test
    public void testIsSaved() {
        System.out.println("isSaved() test");
        Department aDepartment = new Department("test Department");
        assertEquals(aDepartment.isSaved(), false);
        aDepartment.save();
        assertEquals(aDepartment.isSaved(), true);
        aDepartment.deleteEntry();
    }
    **/
    
    /*DOES NOT YET EXIST
    @Test
    public void testdeleteEntry() {
        System.out.println("deleteEntry() test");
        Employee anEmployee = new Employee();
        anEmployee.setFirstName("myNAme");
        assertEquals(anEmployee.deleteEntry(), true);
    }
*/
    /**
     * Test of getEntryDB method, of class Department.
     */
    /*
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

   
