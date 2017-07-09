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
public class Business implements BusinessIF {
    
    private String Name;
    private int idNum;
    private List<Department> aDepartmentList;


    public Business() 
    {
        this.aDepartmentList = new ArrayList<>();
    }
        
    public Business(String aName)
    {
        this.Name = aName;
        this.aDepartmentList = new ArrayList<>();

    }

    public Business(int id, String name) {
        this.Name = name;
        this.idNum = id;
        this.aDepartmentList = new ArrayList<>();

    }

    @Override
    public String toString()
    {
        return this.getName();
    }
    /**
     *
     * @param aName
     */
   // @Override
    public void setName(String aName)
    {
        this.Name = aName;
    }
    
    //@Override
    //  public String toString()
    //  {
    //      return this.getName();
    //  }
      
    @Override
    public void setIdNum(int aIdNum)
    {
        this.idNum = aIdNum;
    }
    
    
    @Override
    public String getName()
    {
        return this.Name;
    }
    
   @Override
    public int getIdNum()
    {
        return this.idNum;
    }
    
    public List<Department> getDepartments()
    {
        return this.aDepartmentList;
    }
    
    public void addDepartment(Department aDept)
    {
        this.aDepartmentList.add(aDept);
    }
    
    
    public Department getDept(int aNum)
    {
        return this.aDepartmentList.get(aNum);
    }
    
    
    public void setDepartments()
    {
        this.populateDepartments();
        this.setEmployees();
    }
    
    public void setEmployees()
    {
        this.aDepartmentList.forEach((d) -> 
        {
            d.setEmployeeList(this);
        });
    }
    /**
     * Saves the Business to the business table 
     * @return Boolean 
     */
 //   @Override
    public boolean save()
    {
        Statement stmt = null;
        String saveQuery = "INSERT INTO '" +this.getClass().getSimpleName()  + "' (name) VALUES ('"+this.getName()+"')";
        //System.out.println(this.getClass().getSimpleName());
        //if( (this.getName() != null) && (!this.getName().isEmpty()) )
        //{
            try
            {
                dbConnection dbCon = new dbConnection();
                stmt = dbCon.getConnection().createStatement();
                stmt.executeUpdate(saveQuery);
                System.out.println("name saved");
                ResultSet genKey = stmt.getGeneratedKeys();
                try
                {
                    if (genKey.next())
                    {
                        this.setIdNum(genKey.getInt(1));
                    }
                }
                catch (SQLException sqlexcept)
                {
                    System.out.println("save failed, "  + sqlexcept);   
                }
                dbCon.getConnection().close();
                return true;

            }
            catch (SQLException sqlexcept)
            {
                System.out.println("connection failed , "  + sqlexcept);
            }

        //} 
        return false;
    }
    
    /*
    Checks if the name is already saved in db
    */
  //  @Override
    public boolean isSaved()
    {
            String isSavedQuery = "SELECT * From '" +this.getClass().getSimpleName()  + "' WHERE name =='" + this.getName()+ "'";
            boolean returnValue = false;

                try
                {
                    dbConnection dbCon = new dbConnection();
                    Statement stmt = dbCon.getConnection().createStatement();
                    ResultSet returnedItem = stmt.executeQuery(isSavedQuery);
                    while (returnedItem.next())
                    {
                        this.setIdNum(returnedItem.getInt("idNum"));
                        this.setName(returnedItem.getString("name"));
                        System.out.println(returnedItem.getString("name"));
                    }
     
                    dbCon.getConnection().close();
                    if(this.getIdNum()!=0)
                    {
                    returnValue = true;
                    System.out.println("Is saved under the name: " + this.getName() + " with the id: " + this.getIdNum());
                    return returnValue;
                    }
                   } 
                catch (SQLException exception)   
                {
                    System.out.println("An error occured: " + exception);  
                }  
            System.out.println("The name: " + this.getName() + " does not exist in DB " + returnValue);
            return returnValue;
    }
    
    
    
    
    public void populateDepartments()
    {
        try
        {
            this.aDepartmentList = new ArrayList<>();
            String populateDepQuery = "SELECT DISTINCT Employee.department_id, Department.name From Department JOIN Employee ON '"
                    +this.getIdNum()+ "' == Employee.business_id AND Employee.department_id == Department.idNum";
            try
            {
                dbConnection dbCon = new dbConnection();
                Statement stmt = dbCon.getConnection().createStatement();
                ResultSet returnedTable = stmt.executeQuery(populateDepQuery);
                while (returnedTable.next())
                {
                    System.out.println(returnedTable.getInt("department_id") + returnedTable.getString("name"));
                    this.aDepartmentList.add(new Department(returnedTable.getInt("department_id"), returnedTable.getString("name")));
                }
                dbCon.getConnection().close();
            }
            catch (SQLException exception)   
            {
                System.out.println("An error occured: " + exception);  
            }
        }
        catch (NullPointerException exception)
        {
            System.out.println("An error occured: " + exception);  
        }
     //   return this.aDepartmentList;
    }
    
    /**
     *returns an entry from db table of class 
     * @return 
     */
    /*
    public Business getEntry()
        {
                String sql = "SELECT * From '" +this.getClass().getSimpleName()  + "' WHERE name =='" +this.getName()+ "'";
                Business returnedBus = new Business();
        //if(this.isSaved())
        //{
        try
        {
 
            dbConnection dbCon = new dbConnection();
            Statement stmt = dbCon.getConnection().createStatement();
            ResultSet returnedTable = stmt.executeQuery(sql);
            while (returnedTable.next())
            {
                returnedBus.setIdNum(returnedTable.getInt("idNum"));
                returnedBus.setName(returnedTable.getString("name"));

            }
           dbCon.getConnection().close();
        }
        catch (SQLException exception)   
        {
            System.out.println("An error occured: " + exception);  
        }   
        //}
        return returnedBus;
    }
    */
    
    
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
                System.out.println(this.getName() + " is deleted");
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
    
    private boolean purgeEmp()
    {
        String deleteAll = "Delete FROM Employee WHERE business_id ='" + this.getIdNum()+ "'";
        Statement stmt = null;
        if(this.getIdNum()!=0)
        {
            try
            {
                System.out.println("TEST DELETEENTRY QUERY "+deleteAll);
                dbConnection dbCon = new dbConnection();
                stmt = dbCon.getConnection().createStatement();
                stmt.executeUpdate(deleteAll);
                dbCon.getConnection().close();
                return true;
            }
            catch (SQLException sqlexcept)
            {
                System.out.println("connection failed , "  + sqlexcept);
            }
        }
        return false;
    }
    
    public void purgeBusiness()
    {
        System.out.println(this.getIdNum());
        this.purgeEmp();
        System.out.println(this.getIdNum());
        this.deleteEntry();
    }
    
}
