/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessmap.models;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erode
 */
public class SocialMediaAccount extends SocialMedia implements SocialMediaAccountIF {
    
    private SocialMedia account; // Social media site 
    private int empId; // employee unique id from database
    //private URL link;
    private Employee aEmployee;
    private String password;

    
    public SocialMediaAccount()
    {
        
    }
     public SocialMediaAccount(URL aURL)
    {
        super.setAddress(aURL);
    }
    
    
    public SocialMediaAccount(int id, String userName, SocialMedia sMedia)
    {
        super(userName, sMedia.getAddress());
        super.setId(id);
        this.account = sMedia;
    }
         
        public SocialMediaAccount(int id, String userName, SocialMedia sMediaAcc, URL aURL)
    {
        super(userName, aURL);
        super.setId(id);
        this.account = sMediaAcc;

    }
        
    public SocialMediaAccount(Employee anEmp, String userName, String pass,  SocialMedia sMedia, URL aURL)
    {
        super(userName, aURL);
        this.aEmployee = anEmp;
        this.empId = anEmp.getIdNum();
        this.account = sMedia;
        this.password = pass;
    }
         
    public SocialMediaAccount(Employee anEmp, String userName, SocialMedia sMedia) 
    {
        super(userName, sMedia.getAddress());
        this.account = sMedia;
        this.aEmployee = anEmp;
    }
        
    public SocialMediaAccount(int id, String userName, String password, SocialMedia sMediaAcc, URL aURL) {
        super(userName, sMediaAcc.getAddress());
        this.account = sMediaAcc;
        this.empId = id;
        //this.aEmployee = anEmp;
        super.setAddress(aURL);
        this.password = password;
    }
       
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public SocialMedia getAccount() {
        return this.account;
    }

    @Override
    public void setAccount(SocialMedia account) {
        this.account = account;
    }

    @Override
    public String getUserName() {
        return super.getName();
    }
    
    
    @Override
    public void setUserName(String name) {
        super.setName(name);
    }        

    @Override
    public int getEmpId() {
        return this.empId;
    }

    public void setEmpId() {
        this.empId = this.aEmployee.getIdNum();
    }
    
    public void setEmpId(int anId)
    {
        this.empId = anId;
    }
    
   
    public URL getLink()
    {
        return super.getAddress();
    }
   
    
    public void setLink(String aLink) throws MalformedURLException
    {
        super.setAddress(new URL(aLink));
    }
    
    public Employee getEmployee()
    {
        return this.aEmployee;
    }
    
    public void setEmployee(Employee aEmp) throws MalformedURLException
    {
        this.aEmployee = aEmp;
    }
    
    //DB ACCESS
    @Override
    public boolean save()
    {
        Statement stmt = null;
        boolean result = false;
        String sqlQuery = "INSERT INTO Social_Media_User (link, user_name, password, employee_id, social_Media_id)" +
                          "VALUES ('"+ this.getLink()+"', '"+ this.getUserName()+"' , '"+ this.getPassword() +"', '" + this.getEmployee().getIdNum()+"', '"+ this.getAccount().getId()+"')";
            try
            {
                dbConnection dbCon = new dbConnection();
                stmt = dbCon.getConnection().createStatement();
                stmt.executeUpdate(sqlQuery);
                ResultSet genKey = stmt.getGeneratedKeys();
                //result = true;
                try
                {
                    if (genKey.next())
                    {
                        this.setId(genKey.getInt(1));
                        result = true;
                    }
                }
                catch (SQLException sqlexcept)
                {
                    System.out.println("save failed, "  + sqlexcept);   
                }
                dbCon.getConnection().close();
            }
            catch (SQLException sqlexcept)
            {
                System.out.println("connection failed , "  + sqlexcept);
            }
        return result;
    }
    
    @Override
        public boolean isSaved() throws MalformedURLException
    {
        
        String isSavedQuery = "SELECT * From Social_Media_User WHERE link =='" + this.getLink()+ "'";
        boolean result = false;
        try
        {
            dbConnection dbCon = new dbConnection();
            Statement stmt = dbCon.getConnection().createStatement();
            ResultSet returnedItem = stmt.executeQuery(isSavedQuery);
            while (returnedItem.next())
            {
                this.setId(returnedItem.getInt("idNum"));
                this.setAddress(new URL(returnedItem.getString("link")));
                this.setUserName(returnedItem.getString("user_name"));
                this.setPassword(returnedItem.getString("password"));

                result = true;
            }
            dbCon.getConnection().close();
        }
        catch (SQLException sqlexcept)
        {
            System.out.println("error, "  + sqlexcept);   
        }
        return result;
    }

    
    public boolean deleteEntry()
    {
        String deleteQuery = "DELETE FROM Social_Media_User WHERE idNum = '" + this.getId()+ "'";
        Statement stmt = null;
        boolean result = false;
        if(this.getEmpId()!=0)
        {
            try
            {
                dbConnection dbCon = new dbConnection();
                stmt = dbCon.getConnection().createStatement();
                stmt.executeUpdate(deleteQuery);
                dbCon.getConnection().close();
                this.setEmpId(0);
                this.setAccount(null);
                result = true;
            }
            catch (SQLException sqlexcept)
            {
                System.out.println("connection failed , "  + sqlexcept);
            } 
           
        }
        return result;
    }
    
    

 
}
