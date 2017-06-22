/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessmap.models;

/**
 *
 * @author erode
 */
public interface EmployeeIF {
    //
    //Setter methods
    //
    public void setFirstName(String aName);
    public void setSecondName(String aName);
    public void setIdNum(int aIdNum);
    //
    //Getter methods
    //
    public String getFirstName();
    public String getSecondName();
    public int getIdNum();
    //
    //DB read write access
    //
    public boolean save();
    public Employee getEmployee(int idNum);
    public boolean deleteEntry();

  
}
