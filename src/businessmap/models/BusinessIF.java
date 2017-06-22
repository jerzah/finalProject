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
public interface BusinessIF {

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



    
}
