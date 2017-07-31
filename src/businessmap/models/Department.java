/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessmap.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author erode
 */
public class Department extends Business implements DepartmentIF
{   
    //private String Name;
    //private int idNum;
    private List<Employee> aEmployeeList;

    
    public Department(String aName)
    {
        super();
        super.setName(aName);
        this.aEmployeeList = new ArrayList<>();
    }

    public Department() 
    {
        super();
        this.aEmployeeList = new ArrayList<>();

    }
      public Department(int id, String name) {
        super();
        super.setIdNum(id);
        super.setName(name);
        this.aEmployeeList = new ArrayList<>();

    }
      
    /**
     *
     * @return
     */
    public List<Employee>getEmployees()
    {
        return this.aEmployeeList;
    }
    
    /**
     *
     * @param aBusiness
     */
    public void setEmployeeList(Business aBusiness)
    {
        //this.aEmployeeList = new ArrayList<>();
        this.populateEmployees(aBusiness);
    }
    
    
    public void addEmployee(Employee aEmp)
    {
        this.aEmployeeList.add(aEmp);
    }
    
    
    public Employee getEmp(int aNum)
    {
        return this.aEmployeeList.get(aNum);
    }
   
    private void populateEmployees(Business aBusiness)
    {
        try
        {
            this.aEmployeeList = new ArrayList<>();
            int id = 0;
            int employId = 0;
        
            String sql = "SELECT DISTINCT Employee.idNum, Employee.first_name, Employee.second_name From Department JOIN Employee ON '" 
                    +this.getIdNum()+ "' == Employee.department_id AND '" 
                    +aBusiness.getIdNum() +"' == Employee.business_id";
            try
            {
                dbConnection dbCon = new dbConnection();
                Statement stmt = dbCon.getConnection().createStatement();
                ResultSet returnedTable = stmt.executeQuery(sql);
                while (returnedTable.next())
                {
                    System.out.println("TEST pop EMployee - id: " + returnedTable.getInt("idNum"));
                    employId = returnedTable.getInt("idNum");
                    String firstName = returnedTable.getString("first_name");
                    String secondName = returnedTable.getString("second_name");
                    this.aEmployeeList.add(new Employee(employId, firstName, secondName));
                    System.out.println(employId + " " + firstName + " " +  secondName);
                }
                dbCon.getConnection().close();
            }
            catch (SQLException exception)   
            {
                System.out.println("An error occured: " + exception);  
            }   
        }
        catch(NullPointerException exception)
        {
            System.out.println("An error occured " + exception);
        }
    }
    
    
    public Department getDepartmentDB()
    {
        Department aDept = new Department();
        try
        {
            String sql = "SELECT * From Department WHERE idNum == '" 
                    +this.getIdNum()+ "'";
            try
            {
                dbConnection dbCon = new dbConnection();
                Statement stmt = dbCon.getConnection().createStatement();
                ResultSet returnedTable = stmt.executeQuery(sql);
                while (returnedTable.next())
                {
                    System.out.println("TEST pop EMployee - id: " + returnedTable.getInt("idNum"));
                    //employId = returnedTable.getInt("idNum");
                    this.setName(returnedTable.getString("name"));
                }
                dbCon.getConnection().close();
                aDept = new Department(this.getIdNum(), this.getName());

            }
            catch (SQLException exception)   
            {
                System.out.println("An error occured: " + exception);  
            }   
        }
        catch(NullPointerException exception)
        {
            System.out.println("An error occured " + exception);
        }
        return aDept;
    }
      
    
    @Override
    public boolean deleteEntry()
    {
        String deleteQuery = "DELETE FROM '" + this.getClass().getSimpleName()  + "' WHERE idNum = '" + this.getIdNum()+ "'";
        Statement stmt = null;
        if(this.getIdNum()!=0)
        {
            try
            {
               System.out.println("TEST DELETEENTRY QUERY "+deleteQuery);

                dbConnection dbCon = new dbConnection();
                stmt = dbCon.getConnection().createStatement();
                stmt.executeUpdate(deleteQuery);
                dbCon.getConnection().close();
                System.out.println(this.getName() + " Department ?is deleted");
                this.setIdNum(0);
                this.setName(""); 
                return true;
            }
            catch (SQLException sqlexcept)
            {
                System.out.println("connection failed , "  + sqlexcept);
            }
        }
        return false;
    }
    
}
