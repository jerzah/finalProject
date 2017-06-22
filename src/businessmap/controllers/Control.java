/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessmap.controllers;

import businessmap.models.Business;
import businessmap.models.Employee;
import businessmap.models.Department;
import businessmap.models.dbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author erode
 */


public class Control {
    private List<Business> businessList; 
    private Business selectedBusiness;
    private Department selectedDepartment;
    private Employee selectedEmployee;


    public Control() 
    {
        this.businessList = new ArrayList<>();
        this.selectedBusiness = new Business();
        this.selectedDepartment = new Department();
        this.selectedEmployee = new Employee();
    }
    /**
     * sets the instance variable selectedBusiness
     * @param aBusiness 
     */
    public void setSelectedBusiness(String aBusiness)
    {
        
        //this.businessList = new ArrayList<>();
        this.selectedBusiness.setName(aBusiness);
        if(this.selectedBusiness.isSaved())
        {
            this.selectedBusiness.setDepartments();
        }
      //  this.selectedBusiness.setEmployees();
    }
    /**
     * Sets a department as the instance variable selectedDepartment
     * @param aDepartment 
     */
    public void setSelectedDepartment(String aDepartment)
    {
        this.selectedDepartment.setName(aDepartment);
        if (this.selectedDepartment.isSaved())
        {
            this.selectedDepartment = new Department(this.selectedDepartment.getIdNum(), this.selectedDepartment.getName());
        }
    }
        
    /**
     * sets an employee as the instance variable selectedEmployee
     * @param idNum 
     */
    public void setSelectedEmployee(int idNum)
    {
        try
        {
            this.selectedEmployee = this.selectedEmployee.getEmployee(idNum);
        }
        catch (Exception anExcept)
        {
            System.out.print("setSelectedEployee Error: " + anExcept);
        }
    }
    
        public void setSelectedEmployee(Employee anEmployee)
        {
            this.selectedEmployee = anEmployee;
        }

    
    
    /**
     * Populates a list of all businesses from the business table
     */
    public void populateBusinesses()
    {
        String sql = "SELECT * From Business";
        try
        {
            this.businessList = new ArrayList<>();
            dbConnection dbCon = new dbConnection();
            Statement stmt = dbCon.getConnection().createStatement();
            ResultSet returnedTable = stmt.executeQuery(sql);
            while (returnedTable.next())
            {
                this.businessList.add(new Business(returnedTable.getInt("idNum"), returnedTable.getString("name")));
              //  System.out.println(id+name);
            }
           dbCon.getConnection().close();
        }
        catch (SQLException exception)   
        {
            System.out.println("An error occured: " + exception);  
        }   
     //   return this.businessList;
    }
    
    /**
     * populates a list of all departments for a given Business from DB
     * @param aBusinessName
     * @return 
     */
   /** public List<Department> getDepartments(Business aBusinessName)
    {
          //Business aBusiness = new Business(aBusinessName);
          //aBusiness.isSaved();
          //aBusiness.populateDepartments();
          return this.selectedBusiness.getDepartments();   
    }
    **/
    /**
     * returns a list of all employees for a department 
     * @param aDepartmentName
     * @return 
     */
   /**
    public List<Employee> getEmployees(Department aDepartmentName)
    {
        List<Employee> emplyeeList = new ArrayList<>();
       
        //Business aBusiness = new Business(aBusinessName);
        //aBusiness.isSaved();
        //aBusiness.populateDepartments();

        //Department aDept = new Department(aDepartmentName);
       // aDept.isSaved();
        //aDept.populateEmployees(aBusiness);
       
        return aDepartmentName.getEmployees();   
    }**/
    
    public Employee getEmployee(int idNum)
    {
        Employee aEmployee = new Employee();
        return aEmployee.getEmployee(idNum);
    }
    
    /**
     * Prints a list of all saved businesses
     */
    public void printBusinesses()
    {
        for(Business test : this.businessList)
        {
            System.out.println(test.getName() + "\t" + test.getIdNum());
        }
    }
    
    //USE CASE IMPLEMENTATION - REMEMEBR TO DECOMPOSE INTERFACE AND USE CASE IMP
    
        /**
     * 
     * @param aDepartment
     * @param aBusiness
     * @param firstName
     * @param secondName
     * @return anEmployee
     */
    public Employee addEmployee(Department aDepartment, Business aBusiness, String firstName, String secondName)
    {
        this.selectedEmployee = new Employee(firstName, secondName, aBusiness, aDepartment);
        this.selectedEmployee.save();
        return this.selectedEmployee;        
    }
    
    /**
     * use case - add business
     * @param aBusiness
     * @return boolean
     */
    public boolean addBusiness(String aBusiness)
    {
        Business newBusiness = new Business(aBusiness);
        this.selectedBusiness = newBusiness;
        this.selectedBusiness.save();
        return newBusiness.isSaved();
    }
    /**
     * 
     * Use case to add department
     * @param newdept
     * @return boolean 
     */
    
        public boolean addDepartment(String newdept)
    {
        Department department = new Department(newdept);
        this.selectedDepartment = department;
        this.selectedDepartment.save();
        return this.selectedDepartment.isSaved();
    }

    /**
     * use case - remove a business
     * @return boolean
     */
    public boolean removeEmployee()
    {
       return this.selectedEmployee.deleteEntry();
    }
    
    public boolean removeBusiness()
    {
        return this.selectedBusiness.deleteEntry();
    }
    
    public boolean removeDepartment()
    {
        return this.selectedDepartment.deleteEntry();
    }
    
        public Business getSelectedBusiness()
    {
        return this.selectedBusiness;
    }
    
    public Department getSelectedDepartment()
    {
        return this.selectedDepartment;
    }
    
    public Employee getSelectedEmployee()
    {
        return this.selectedEmployee;
    }
    
    public List<Department>getDepartments()
    {
        this.selectedBusiness.populateDepartments();
        return this.selectedBusiness.getDepartments();
    }
    
    public List<Employee>getDeptEmployees()
    {
        this.selectedDepartment.setEmployeeList(this.selectedBusiness);
        return this.getSelectedDepartment().getEmployees();
    }
    
    public List<Business>getBusinesses()
    {
        this.populateBusinesses();
        return this.businessList;
    }
    
}
    
