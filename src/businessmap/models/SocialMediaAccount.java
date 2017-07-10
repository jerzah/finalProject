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
    
    private SocialMedia account; // Social media site 
    private int empId; // employee unique id from database

    public SocialMediaAccount()
    {
        
    }
         
    public SocialMediaAccount(String userName, SocialMedia sMediaAcc) {
        super(userName, sMediaAcc.getAddress());
        this.account = sMediaAcc;
    }
        
    public SocialMediaAccount(String userName, SocialMedia sMediaAcc, int employeeId) {
        super(userName, sMediaAcc.getAddress());
        this.account = sMediaAcc;
        this.empId = employeeId;

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

    @Override
    public void setEmpId(int empId) {
        this.empId = empId;
    }
        
}
