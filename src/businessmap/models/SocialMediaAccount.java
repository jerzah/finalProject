/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessmap.models;

import java.net.URL;

/**
 *
 * @author erode
 */
public class SocialMediaAccount extends SocialMedia implements SocialMediaAccountIF {
    
    private SocialMedia account;
    private int empId;

    public SocialMediaAccount()
    {
        
    }
    
    public SocialMediaAccount(String userName, URL aURL) {
        super(userName, aURL);
    }
    
    public SocialMediaAccount(String userName, URL aURL, int id) {
        super(userName, aURL, id);
    }
        
        public SocialMediaAccount(String userName, URL aURL,  SocialMedia sMediaAcc) {
        super(userName, aURL);
        this.account = sMediaAcc;
    }
        
    public SocialMediaAccount(String userName, URL aURL, int id, SocialMedia sMediaAcc) {
        super(userName, aURL, id);
        this.account = sMediaAcc;
    }
    
    @Override
    public SocialMedia getAccount() {
        return account;
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
        return empId;
    }

    @Override
    public void setEmpId(int empId) {
        this.empId = empId;
    }
        
}
