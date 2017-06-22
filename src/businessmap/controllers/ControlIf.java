/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessmap.controllers;

import businessmap.models.Business;
import businessmap.models.Department;
import businessmap.models.Employee;
import java.util.List;

/**
 *
 * @author erode
 */
public interface ControlIf {
    //SETTERS
    public void setSelectedBusiness(String aBusiness);
    public void setSelectedDepartment(String aDepartment);
    public void setSelectedEmployee(int idNum);
    public void setSelectedEmployee(Employee anEmployee);
    
    //GETTERS
    public Business getSelectedBusiness();
    public Department getSelectedDepartment();
    public Employee getSelectedEmployee();
    
    public List<Department>getDepartments();
    public List<Employee>getDeptEmployees();
    public List<Business>getBusinesses();
    
    
    //MIST
    public void printBusinesses();

  //  public List<Department> getDepartments(Business aBusinessName);
 //   public List<Employee> getEmployees(Department aDepartmentName);
    
    //DB ACCESS
    public Employee getEmployee(int idNum);
    public void populateBusinesses();

    
    public Employee addEmployee(Department aDepartment, Business aBusiness, String firstName, String secondName);
    public boolean addBusiness(String aBusiness);
    public boolean addDepartment(String newdept);
   
    public boolean removeEmployee();
    public boolean removeBusiness();
    public boolean removeDepartment();

    



    
}
