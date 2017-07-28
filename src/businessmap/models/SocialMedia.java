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

/**
 *
 * @author erode
 */

public class SocialMedia implements SocialMediaIF{
   
    private int id;
    private String name;
    private URL address;
    
     public SocialMedia()
    {
        
    }
     
    public SocialMedia(int idNum)
    {
        this.id = idNum;
    }

        public SocialMedia(String aName)
    {
        this.name = aName;
    }
    
    public SocialMedia(String aName, URL aURL)
    {
        this.name = aName;
        this.address = aURL;
    }

    
    public SocialMedia(int anId, String aName, URL aURL) {
        this.id = anId;
        this.name = aName;
        this.address = aURL;
    }
    
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override   public void setName(String name) {
        this.name = name;
    }
     
    @Override
    public URL getAddress() {
        return address;
    }

    @Override
    public void setAddress(URL address) {
        this.address = address;
    }
        
    
    public boolean save()
    {
        Statement stmt = null;
        boolean result = false;
        String sqlQuery = "INSERT INTO Social_Media (name, link)" +
                          "VALUES ('"+ this.getName() +"', '"+ this.getAddress()+"' )";
            try
            {
                dbConnection dbCon = new dbConnection();
                stmt = dbCon.getConnection().createStatement();
                stmt.executeUpdate(sqlQuery);
                System.out.println("name saved");
                ResultSet genKey = stmt.getGeneratedKeys();
                result = true;
                try
                {
                    if (genKey.next())
                    {
                        this.setId(genKey.getInt(1));
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
    
    
    
    public boolean isSaved() throws MalformedURLException
    {
        
        String isSavedQuery = "SELECT * From Social_Media WHERE name =='" + this.getName()+ "'";
        boolean result = false;
        try
        {
            dbConnection dbCon = new dbConnection();
            Statement stmt = dbCon.getConnection().createStatement();
            ResultSet returnedItem = stmt.executeQuery(isSavedQuery);
            while (returnedItem.next())
            {
                this.setId(returnedItem.getInt("idNum"));
                this.setName(returnedItem.getString("name"));
                this.setAddress(new URL(returnedItem.getString("link")));
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
        
        String deleteQuery = "DELETE From Social_Media WHERE name =='" + this.getName()+ "'";
        boolean result = false;
        try
        {
            dbConnection dbCon = new dbConnection();
            Statement stmt = dbCon.getConnection().createStatement();
            stmt.executeUpdate(deleteQuery);
            this.setId(0);
            this.setName("");
            this.setAddress(null);
            dbCon.getConnection().close();
            result = true;

        }
        catch (SQLException sqlexcept)
        {
            System.out.println("save failed, "  + sqlexcept);   
        }
        return result;
    }
    
    
}
