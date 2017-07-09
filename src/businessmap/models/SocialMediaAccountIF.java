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
public interface SocialMediaAccountIF {
    
    public SocialMedia getAccount();
    public void setAccount(SocialMedia anAccount);
    
    public String getUserName();
    public void setUserName(String userName);
    
    public int getEmpId();
    public void setEmpId(int anId);
    
}
