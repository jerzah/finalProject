/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessmap.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author erode
 */
public class PersonalityAccess {
    private Personality personality;
    private int idNum;
    private String description;
    private Employee employee;


    
    public PersonalityAccess(Personality personality)
    {
            this.personality = personality;
    }
    
    public void init()
    {
        switch (personality)
        {
            case UNKNOWN:
                this.idNum = 0;
                this.description = "Unknown personality type";
                break;
                
            case ASSERTIVE:
                this.idNum = 1;
                this.description = "Copetititve person - Appeal to them by appealing to their ego";
                break;
                
            case AMIABLE:
                this.idNum = 2;
                this.description = "Kind adveturous -  Appeal to them by matching their energy, having a good time";
                break;
                
            case EXPRESSIVE:
                this.idNum = 3;
                this.description = "Socialable person - Appeal by socialising and being emphatic";
                break;
                
            case ANALYTICAL:
                this.idNum = 4;
                this.description = "Methodolical person - Appeal by being thourough and giving them time";
                break;
        }
    }

    public Personality getPersonality() {
        return personality;
    }

    public void setPersonality(Personality personality) {
        this.personality = personality;
    }
    
    
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    
     //***DATABASE OPERATIONS***

    /**
     * Will save a new employee objects variables into the table Employee
     * @return boolean value
     */
    public boolean save()
    {
        boolean returnValue = false; 
       // if( ( this.business.isSaved() )  && ( this.departnment.isSaved() ) )
       // {
            Statement stmt = null;
            String sqlQuery = "INSERT INTO Personality (personality, employee_id,)" +
                                  "VALUES ('"+ this.getPersonality().toString() +"', '"+ this.getEmployee().getIdNum()+ "')";
            
            try
            {
                dbConnection dbCon = new dbConnection();
                stmt = dbCon.getConnection().createStatement();
                stmt.executeUpdate(sqlQuery);
                System.out.println("personality");
                ResultSet genKey = stmt.getGeneratedKeys();
                returnValue = true;
                dbCon.getConnection().close(); 
            }
            catch (SQLException sqlexcept)
            {
                System.out.println("save failed, "  + sqlexcept);
            }
   //     }
        return returnValue;
    }
    
}
