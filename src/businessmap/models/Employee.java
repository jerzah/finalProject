/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessmap.models;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author erode
 */
public class Employee implements EmployeeIF { 
    
private String firstName;
private String secondName;
private int idNum;
private Business business;
private Department departnment;
private List<String>userNames ; //List of usernames
private String[] address;
private List<SocialMediaAccount> smAccountList;
private PersonalityAccess personality;
//private String phoneNumber;
//private InetAddress ipAddress;


 public Employee ()
    {

    }
 
     public Employee(int id, String aFirstName, String aSecondName)
    {
      //  super();
       // this.idNum = id;
        this.idNum = id;
        this.firstName = aFirstName; 
        this.secondName = aSecondName;
        this.userNames = new ArrayList<>();
    }
    
    public Employee(String aFirstName, String aSecondName, Business aBusiness, Department aDepartment)
    {
      //  super();
       // this.idNum = id;
        this.firstName = aFirstName; 
        this.secondName = aSecondName;
        this.business = aBusiness;
        this.departnment = aDepartment;
        this.smAccountList = new ArrayList<>();
    }
    
        public Employee(int id, String aFirstName, String aSecondName, Business aBusiness, Department aDepartment)
    {
       // super();
        //this.idNum = id;
        this.idNum = id;
        this.firstName = aFirstName; 
        this.secondName = aSecondName;
        this.business = aBusiness;
        this.departnment = aDepartment;
        this.userNames = new ArrayList<>();
        this.smAccountList = new ArrayList<>();
    }
    //Setter Methods
    /**
     *
     * @param aAddress
     * @return 
     */
    /*
    public void setIpAddress(InetAddress aIpAddr)
    {
        this.ipAddress = aIpAddr;
    }
    
    
    public void setAddress(String[] aAddress)
    {
        this.address = aAddress;
    }
    */
    
    @Override
    public String toString()
    {
        return this.getFirstName() + " " +this.getSecondName();
    }
    
    @Override
    public void setFirstName(String aName)
    {
        this.firstName = aName;
    }
    
    @Override
    public void setSecondName(String aName)
    {
        this.secondName = aName;
    }
  
    @Override
    public void setIdNum(int aIdNum)
    {
        this.idNum = aIdNum;
    }

    public List<SocialMediaAccount> getSmAccountList() {
        return smAccountList;
    }

    public void setSmAccountList(List<SocialMediaAccount> smAccountList) {
        this.smAccountList = smAccountList;
    }
    
    
    
    //Getter methods
    /*
    public InetAddress getIpAddr()
    {
        return this.ipAddress;
    }
    
    public String[] getAddress()
    {
        return this.address;
    }
    */
    @Override
    public String getFirstName()
    {
        return this.firstName;
    }
        @Override

    public String getSecondName()
    {
        return this.secondName;
    }
    @Override
    public int getIdNum()
    {
        return this.idNum;
    }
    
    public void addUserName(String aUsrName)
    {
        this.userNames.add(aUsrName);
    }

    public List<String>getUserNames()
    {
        return this.userNames;
    }
    
    
    public PersonalityAccess getPersonality() 
    {
        return personality;
    }

    public void setPersonality(PersonalityAccess personality) 
    {
        this.personality = personality;
    }
    //***DATABASE OPERATIONS***

    /**
     * Will save a new employee objects variables into the table Employee
     * @return boolean value
     */
   @Override
    public boolean save()
    {
        boolean returnValue = false; 
       // if( ( this.business.isSaved() )  && ( this.departnment.isSaved() ) )
       // {
            Statement stmt = null;
            String sqlQuery = "INSERT INTO '" +this.getClass().getSimpleName()  + 
                              "' (first_name, second_name, personality, business_id, department_id)" +
                                  "VALUES ('"+ this.getFirstName() +"', '"+ this.getSecondName()+"', '"
                               +this.getPersonality().getPersonality()+"', '"
                              +this.business.getIdNum()+"', '"
                              +this.departnment.getIdNum()+"' )";
            
            try
            {
                dbConnection dbCon = new dbConnection();
                stmt = dbCon.getConnection().createStatement();
                stmt.executeUpdate(sqlQuery);
                System.out.println("name saved");
                ResultSet genKey = stmt.getGeneratedKeys();
                returnValue = true;
                try
                {
                    //If save is sucessful, setIdNum will set the returned table id
                    if (genKey.next())
                    {
                        this.setIdNum(genKey.getInt(1));
                    }
                dbCon.getConnection().close();
                }
                catch (SQLException sqlexcept)
                {
                    System.out.println("save failed, "  + sqlexcept);   
                }     
            }
            catch (SQLException sqlexcept)
            {
                System.out.println("save failed, "  + sqlexcept);
            }
   //     }
        return returnValue;
    }
    
    /**
     * Returns an Employee based on idNum
     * @param idNum
     * @return 
     */
    @Override
    public Employee getEmployee(int idNum)
    {
            Statement stmt = null;
            String sql = "SELECT * From Employee WHERE idNum =='" +idNum+ "'";
            Employee anEmployee = new Employee();
            try
            {
                anEmployee = new Employee();
                dbConnection dbCon = new dbConnection();
                stmt = dbCon.getConnection().createStatement();
                stmt.executeUpdate(sql);
                ResultSet returnedTable = stmt.executeQuery(sql);
                while (returnedTable.next())
                    {
                        anEmployee.setFirstName(returnedTable.getString("first_name"));
                        //anEmployee.setFirstName(returnedTable.getString("first_name"));
                        anEmployee.setSecondName(returnedTable.getString("second_name"));
                        anEmployee.setPersonality(new PersonalityAccess(Personality.valueOf(returnedTable.getString("personality"))));
                        anEmployee.setIdNum(returnedTable.getInt("idNum"));
                    }
                dbCon.getConnection().close();
            }
            catch (SQLException sqlexcept)
            {
                System.out.println("connection failed , "  + sqlexcept);
            }
        return anEmployee;
    
    }


      
    
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
                System.out.println(this.getFirstName() + " " +this.getSecondName() + " is deleted");
                this.setIdNum(0);
                this.setFirstName(""); 
                this.setSecondName(""); 
                return true;
            }
            catch (SQLException sqlexcept)
            {
                System.out.println("connection failed , "  + sqlexcept);
            }
        }
        return false;
    }
    
        public void populateSocialMediaAccounts() throws MalformedURLException
    {
        this.smAccountList = new ArrayList();
        String sql = "SELECT * From Social_Media_User WHERE Employee_id = '" + this.getIdNum()+ "'";
        try
        {
            dbConnection dbCon = new dbConnection();
            Statement stmt = dbCon.getConnection().createStatement();
            ResultSet returnedTable = stmt.executeQuery(sql);
            while (returnedTable.next())
            {
                this.smAccountList.add(new SocialMediaAccount(returnedTable.getInt("idNum"), returnedTable.getString("user_name"),returnedTable.getString("password"), new SocialMedia(returnedTable.getInt("social_Media_id")), new URL(returnedTable.getString("link"))));
            }
           dbCon.getConnection().close();
        }
        catch (SQLException exception)   
        {
            System.out.println("An error occured: " + exception);  
        }   
    }
    

        
}
