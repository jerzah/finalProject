/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessmap.models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author erode
 */
public class dbConnection {
    Connection con;
    String host = "jdbc:sqlite:businessDB";
    String username = "businessApp";
    String password;
            
    public dbConnection() throws SQLException
            {
                this.con = DriverManager.getConnection( host, username, password );
            }
    
    public Connection getConnection()
    {
        return this.con;
    }
    
    public void setPassword(String aPassword)
    {
        this.password = aPassword;   
    }
    /**
     * Creates three new tables for the database
     * @throws SQLException 
     */
    public void createNewTables() throws SQLException
    {
        String createBusinessTable = "CREATE TABLE IF NOT EXISTS Business" + 
                "(idNum INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \n" +
                "name VARCHAR(32) NOT NULL UNIQUE)";
        
        String createDepartmentTable = "CREATE TABLE IF NOT EXISTS Department" + 
                "(idNum INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \n" +
                "name VARCHAR(32) NOT NULL UNIQUE)";
        
        String createEmployeeTable = "CREATE TABLE IF NOT EXISTS Employee" + 
                "(idNum INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \n" +
                "first_name VARCHAR(32) NOT NULL, \n" +
                "second_name VARCHAR(32) NOT NULL, \n" +
                "business_id INTEGER NOT NULL, \n" + 
                "department_id INTEGER NOT NULL, \n" +
                "FOREIGN KEY(business_id) REFERENCES Business(idNum), \n" +
                "FOREIGN KEY(department_id) REFERENCES Department(idNum))";
        try{
            Statement stmt = null;
            stmt = this.con.createStatement();
            stmt.executeUpdate(createBusinessTable);
            stmt.executeUpdate(createDepartmentTable);
            stmt.executeUpdate(createEmployeeTable);
        } catch (SQLException exception)
        {
            System.out.println("An error occured: " + exception);
        }
    }
    
    /**
     * THIS WILL DROP THE BUSINESS TABEL AND COULD CORRUPT DB
     * ONLY TO USED WHILE BUILDING
     */
    public void dropBusinessTable()
    {
        String DropBusinessTable = "DROP TABLE Business";
        try{
            Statement stmt = null;
            stmt = this.con.createStatement();
            stmt.executeUpdate(DropBusinessTable);
        } catch (SQLException exception)
        {
            System.out.println("An error occured: " + exception);
        }
    }
    
    /**
     * THIS WILL DROP THE BUSINESS TABEL AND COULD CORRUPT DB
     * ONLY TO USED WHILE BUILDING
     */
    public void dropDepartmentTable()
    {
        String DropDepartmentTable = "DROP TABLE Department";
        try{
            Statement stmt = null;
            stmt = this.con.createStatement();
            stmt.executeUpdate(DropDepartmentTable);
        } catch (SQLException exception)
        {
            System.out.println("An error occured: " + exception);
        }
    }
    
    public void dropEmployeeTable()
    {
        String DropEmployeeTable = "DROP TABLE Employee";
        try{
            Statement stmt = null;
            stmt = this.con.createStatement();
            stmt.executeUpdate(DropEmployeeTable);
        } catch (SQLException exception)
        {
            System.out.println("An error occured: " + exception);
        }
    }
    
    /**
     * 
     * @param tableName
     * @throws SQLException 
     * Prints all of the entries for tableName
     */
    public void checkTable(String tableName) throws SQLException{
        String sql = "SELECT * From " + tableName;
            try
            {
                Statement stmt = this.con.createStatement();
                ResultSet returnedTable = stmt.executeQuery(sql);
                if (!tableName.equals("Employee"))
                {
                while (returnedTable.next())
                {
                    System.out.print(
                        returnedTable.getInt("idNum") + "\t " + 
                        returnedTable.getString("name") + "\n");// + "\n" +
                        //returnedTable.getString("first_name") + "\t " +
                        //returnedTable.getString("second_name") + "\t " +
                        //returnedTable.getInt("business_id") + "\t " +
                        //returnedTable.getInt("department_id") + "\n" );
                }
            }
            else
            {
                while (returnedTable.next())
                {
                System.out.print(
                        returnedTable.getInt("idNum") + "\t " + 
                        //returnedTable.getString("name") + "\n");// + "\n" +
                        returnedTable.getString("first_name") + "\t " +
                        returnedTable.getString("second_name") + "\t " +
                        returnedTable.getInt("business_id") + "\t " +
                        returnedTable.getInt("department_id") + "\n" );
                }
            }
        }
        catch (SQLException exception)   
        {
            System.out.println("An error occured: " + exception);            
        }    
    }
    
}
