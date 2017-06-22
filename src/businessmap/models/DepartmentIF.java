/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessmap.models;

import java.util.List;


/**
 *
 * @author erode
 */
public interface DepartmentIF {
    //Setter methods
    public void setName(String aName);
    public void setIdNum(int aIdNum);        
    //Getter methods
    public String getName();
    public int getIdNum();
    //DB read/write methods    
    public boolean save();
    public boolean isSaved();
    public boolean deleteEntry();
    //public List<Employee>populateEmployees(Business aBusiness);
    public List<Employee>getEmployees();
    public void setEmployeeList(Business aBusiness);



    
}
