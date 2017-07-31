/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessmap.controllers;

import businessmap.models.Analytics;
import businessmap.models.Business;
import businessmap.models.Employee;
import businessmap.models.Department;
import businessmap.models.Personality;
import businessmap.models.PersonalityAccess;
import businessmap.models.SocialMedia;
import businessmap.models.SocialMediaAccount;
import businessmap.models.dbConnection;
import java.io.IOException;
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


public class Control {
    private List<Business> businessList; 
    private List<Department> departmentList;
    List<SocialMediaAccount>  socialMediaAccountList;
    List<SocialMedia>  socialMediaList;

    private Business selectedBusiness;
    private Department selectedDepartment;
    private Employee selectedEmployee;
    private SocialMedia socialMedia;
    private SocialMediaAccount socialMediaAccount;
    private Analytics analyt; 

    private PersonalityAccess personality;




    public Control() 
    {
        this.businessList = new ArrayList<>();
        this.departmentList = new ArrayList<>();

        this.selectedBusiness = new Business();
        this.selectedDepartment = new Department();
        this.selectedEmployee = new Employee();
        this.socialMediaAccount = new SocialMediaAccount();
        
        this.socialMediaAccountList = new ArrayList<>();
        this.socialMediaList = new ArrayList<>();  
        
        this.analyt = new Analytics();
        

    }
    
    // **Business Setter and Getters ** 
    /**
     * sets the instance variable selectedBusiness
     * @param aBusiness 
     */
    public void setBusiness(String aBusiness)
    {
        
        //this.businessList = new ArrayList<>();
        this.selectedBusiness.setName(aBusiness);
        if(this.selectedBusiness.isSaved())
        {
            this.selectedBusiness.setDepartments();
        }
      //  this.selectedBusiness.setEmployees();
    }
    
     public Business getBusiness()
    {
        return this.selectedBusiness;
    }
     
     // ** Department Setter and Getters **
     
    /**
     * Sets a department as the instance variable selectedDepartment
     * @param aDepartment 
     */
    public void setDepartment(String aDepartment)
    {
        this.selectedDepartment.setName(aDepartment);
        if (this.selectedDepartment.isSaved())
        {
            this.selectedDepartment = new Department(this.selectedDepartment.getIdNum(), this.selectedDepartment.getName());
        }
    }
    
    public Department getDepartment()
    {
        return this.selectedDepartment;
    }
    
    // ** Employee Setters and Getters **
    
    /**
     * sets an employee as the instance variable selectedEmployee
     * @param idNum 
     */
    public void setEmployee(int idNum)
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
    
    public void setEmployee(Employee anEmployee)
    {
        this.selectedEmployee = anEmployee;
    }
        
    public Employee getEmployee()
    {
        return this.selectedEmployee;
    }
    
    public Employee getEmployee(int idNum)
    {
        Employee aEmployee = new Employee();
        return aEmployee.getEmployee(idNum);
    }

    
    public Analytics getAnalyt() {
        return analyt;
    }

    public void setAnalyt(Analytics analyt) {
        this.analyt = analyt;
    }
    
    
    // ** Social media getter and setters **

    public void setSocialMedia(SocialMedia socialMedia) throws MalformedURLException {
        this.socialMedia = socialMedia;
        this.socialMedia.isSaved();
    }

    
    public SocialMedia getSocialMedia() {
        return this.socialMedia;
    }
    
    
    public void setPopulateSocialMedia() throws MalformedURLException
    {
        this.populateSocialMedia();
    }
    
        public void setSocialMediaAccount(URL aURL) throws MalformedURLException
    {
        this.socialMediaAccount = new SocialMediaAccount(aURL);
        this.socialMediaAccount.isSaved();
    }
    
    public void setSocialMediaAccount(SocialMediaAccount sma) throws MalformedURLException
    {        
        sma.save();
        sma.isSaved();
        this.socialMediaAccount = sma;
        
    }
    
    public List<SocialMedia> getSocialMediaList() throws MalformedURLException //throws MalformedURLException
    {
        return this.socialMediaList;
    }

    public List<SocialMediaAccount> getSocialMediaAccountList() {
        return this.getEmployee().getSmAccountList();
    }
    
    public SocialMediaAccount getSocialMediaAccount()
    {
        return this.socialMediaAccount;
    }

    public void isSavedSocialMediaAccount(String aURL) throws MalformedURLException
    {
        System.out.println("Control test :" + aURL);
        this.getSocialMediaAccount().setLink(aURL);
        this.getSocialMediaAccount().isSaved();
    }
    


    public void setSocialAccountMediaList() throws MalformedURLException {
       // this.setEmployee(anEmp);
       this.getEmployee().populateSocialMediaAccounts();
    }

    public PersonalityAccess getPersonality() 
    {
        return personality;
    }

    public void setPersonality(PersonalityAccess personality) 
    {
        this.personality = personality;
    }
    
    public List<PersonalityAccess> displayPersonalies()
    {
        List<PersonalityAccess> personality = new ArrayList();
        personality.add(new PersonalityAccess(Personality.UNKNOWN));
        personality.add(new PersonalityAccess(Personality.ASSERTIVE));
        personality.add(new PersonalityAccess(Personality.AMIABLE));
        personality.add(new PersonalityAccess(Personality.EXPRESSIVE));
        personality.add(new PersonalityAccess(Personality.ANALYTICAL));

        return personality;
    }

   
    /**
  
    public void printBusinesses()
    {
        for(Business test : this.businessList)
        {
            System.out.println(test.getName() + "\t" + test.getIdNum());
        }
    }
    **/
    // ** USE CASE IMPLEMENTATION - REMEMEBR TO DECOMPOSE INTERFACE AND USE CASE IMP **
    
    /**
     * 
     * @param aDepartment
     * @param aBusiness
     * @param firstName
     * @param secondName
     * @param personality
     * @return anEmployee
     */
    public Employee addEmployee(Department aDepartment, Business aBusiness, String firstName, String secondName, PersonalityAccess personality)
    {
        this.selectedEmployee = new Employee(firstName, secondName, aBusiness, aDepartment);
        this.selectedEmployee.setPersonality(personality);
        System.out.println("PRINT PERSONALITY : " + this.selectedEmployee.getPersonality().getPersonality());
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
    
    public boolean addSocialMediaAccount(Employee anEmp, SocialMedia sm, String username, URL aURL, String password)
    {
        boolean result = false;
        try
        {

            this.setSocialMediaAccount(new SocialMediaAccount(anEmp, username, password, sm, aURL));            

           // this.getSocialMediaAccount().save();
            this.getSocialMediaAccount().isSaved();
            result =  true;
        }
        catch (Exception anExcept)
        {
            System.out.println(anExcept);
        }
        return result;
    }

    
    // ** REMOVE ENTRY USE CASES 
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
    
    public void initAnalytic() throws MalformedURLException
    {
        this.analyt.setBusiness(this.getBusiness());
        this.analyt.iniCount();
    }
     
    
    public List<Department>getDepartments(Business aBusiness)
    {
        aBusiness.populateDepartments();
        return aBusiness.getDepartments();
    }
    
    
    public List<Department>getDepartments()
    {
        this.populateDepartmentList();
        return this.departmentList;
    }
   
    public List<Employee>getEmployees(Department aDept)
    {
        aDept.setEmployeeList(this.selectedBusiness);
        return aDept.getEmployees();
    }
    
    public List<Business>getBusinesses()
    {
        this.populateBusinessList();
        return this.businessList;
    }
   
    public int countDepartments() throws MalformedURLException
    {
        return this.analyt.getaMap().get("departments");
    }
    
    public int countEmployees() throws MalformedURLException
    {
        return this.analyt.getaMap().get("employees");
    }
    
    public int countSocialMediaAccounts() throws MalformedURLException
    {
        return this.analyt.getaMap().get("socialMediaAccounts");
    }
    
    public int countSocialMediaPass() throws MalformedURLException
    {
        return this.analyt.getaMap().get("passwords");
    }
    
        public int countSocialMediaUsername() throws MalformedURLException
    {
        return this.analyt.getaMap().get("usernames");
    }
    public boolean addSocialMedia(SocialMedia aMedia) throws MalformedURLException
    {
        boolean result = aMedia.save();
        this.setSocialMedia(aMedia);
        if (result)
        {
            this.socialMediaList.add(this.getSocialMedia());
            this.setPopulateSocialMedia();
        }
        return result;
    }
    
    public boolean setSocialMedia(String sMedia) throws MalformedURLException
    {
        SocialMedia sm = new SocialMedia(sMedia);
        boolean result = sm.isSaved();
        this.setSocialMedia(sm);
        //if (result)
        //{
        //    this.setPopulateSocialMedia();
        //}
        return result;
    }
        
    public boolean warningMessage(String aValue)
    {
        boolean result = false;
        if(aValue=="y" || aValue== "Yes" || aValue== "Y")
        {
            result = true;
        }
    return result;
    }
    
    
    
     // ** DB ACCESSS AND POPULATION METHODS
    
    /**
     * Populates a list of all businesses from the business table
     */
    private void populateBusinessList()
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
    }
    
    
    private void populateDepartmentList()
    {
        String sql = "SELECT * From Department";
        try
        {
            this.departmentList = new ArrayList<>();
            dbConnection dbCon = new dbConnection();
            Statement stmt = dbCon.getConnection().createStatement();
            ResultSet returnedTable = stmt.executeQuery(sql);
            while (returnedTable.next())
            {
                this.departmentList.add(new Department(returnedTable.getInt("idNum"), returnedTable.getString("name")));
            }
           dbCon.getConnection().close();
        }
        catch (SQLException exception)   
        {
            System.out.println("An error occured: " + exception);  
        }   
    }
    

   
    private void populateSocialMedia() throws MalformedURLException
    {
        this.socialMediaList = new ArrayList();
        String sql = "SELECT * From Social_Media";
        try
        {
            dbConnection dbCon = new dbConnection();
            Statement stmt = dbCon.getConnection().createStatement();
            ResultSet returnedTable = stmt.executeQuery(sql);
            while (returnedTable.next())
            {
                this.socialMediaList.add(new SocialMedia(returnedTable.getInt("idNum"), returnedTable.getString("name"), new URL(returnedTable.getString("link"))));
                System.out.println("URL TEST: " + returnedTable.getString("name"));
            }
           dbCon.getConnection().close();
        }
        catch (SQLException exception)   
        {
            System.out.println("An error occured: " + exception);  
        }   
            
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
    

    
    
    
}
    
