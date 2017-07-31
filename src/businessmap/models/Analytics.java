/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessmap.models;

import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author erode
 */
public class Analytics {
    private Business aBusiness;
    private List<SocialMediaAccount>smAccounts;
    private int deptCount;
    private int EmpCount;
    private int usernames;
    private int passwords;
    private int socialMediaAccounts;
    private Map<String, Integer> aMap;
    
    String csvFile; //= getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + "./test.csv";
    FileWriter writer;

   
        
    public Analytics() 
    {
        this.aMap = new HashMap<>();
        this.smAccounts = new ArrayList();
        this.aBusiness = new Business();
    }
    
    public Analytics(Business aBus)
    {
        //this.writer = new FileWriter(this.csvFile);
        this.aBusiness = aBus;
        this.smAccounts = new ArrayList();
        this.aMap = new HashMap<>();
    }
    
    public void setBusiness(Business aBus)
    {
        this.aBusiness = aBus;
    }
    
    private void setDeptCount(int anAmount)
    {
        this.deptCount = anAmount;
    }

    public String getCsvFile() {
        return csvFile;
    }

    public void setCsvFile(String csvFile) {
        this.csvFile = csvFile;
    }
    
    private void setEmpCount(int anAmount)
    {
        this.EmpCount = anAmount;
    }
    
    public Business getBusiness()
    {
        return this.aBusiness;
    }
    
    public int getDeptAmount()
    {
        return this.deptCount;
    }

    public int getUsernames() {
        return usernames;
    }

    public void setUsernames(int usernames) {
        this.usernames = usernames;
    }

    public int getPasswords() {
        return passwords;
    }

    public void setPasswords(int passwords) {
        this.passwords = passwords;
    }

    public int getSocialMediaAccounts() {
        return socialMediaAccounts;
    }

    public void setSocialMediaAccounts(int socialMediaAccounts) {
        this.socialMediaAccounts = socialMediaAccounts;
    }

    public List<SocialMediaAccount> getSmAccounts() {
        return smAccounts;
    }

    public void setSmAccounts(List<SocialMediaAccount> smAccounts) {
        this.smAccounts = smAccounts;
    }

    public Map<String, Integer> getaMap() {
        return aMap;
    }

    public void setaMap(Map<String, Integer> aMap) {
        this.aMap = aMap;
    }
    
    
    
    public int getEmpAmount()
    {
        return this.EmpCount;
    }
    
    private int countDept()
    {
        if(this.getBusiness()!=null)
        {
            this.setDeptCount(this.aBusiness.getDepartments().size());
        }
        return this.getDeptAmount();
    }
    
    private void countSocialMediaAccounts() throws MalformedURLException
    {
        int i = 0;
        int u= 0;
        int p = 0;
         if(this.getBusiness()!=null)
         {
            for (Department d : this.getBusiness().getDepartments())
            {
               
                for(Employee e : d.getEmployees())
                {
                    e.populateSocialMediaAccounts();
                    this.setSmAccounts(e.getSmAccountList());
                    i += e.getSmAccountList().size();
                    this.setSocialMediaAccounts(i);
                    for (SocialMediaAccount s : this.getSmAccounts())
                    {
                        if (!"".equals(s.getPassword()))
                        {
                            p += 1;
                        }
                        if (!"".equals(s.getUserName()))
                        {
                            u += 1;
                        }
                    }   
                }
            }
                this.setPasswords(p);
                this.setUsernames(u);
        }
       // return this.getSocialMediaAccounts();
    }
    
    private int countDeptEmps(List<Department> aDept)
    {
        int i=0;
        if(this.getBusiness()!=null)
        {
            for (Department d : aDept)
            {
                 d.setEmployeeList(this.getBusiness());
                 i += d.getEmployees().size();
                 this.setEmpCount(i);
            }
            }
        return this.getEmpAmount();
    }
   
   public void iniCount() throws MalformedURLException
   {
     this.countDept();
     this.countDeptEmps(this.getBusiness().getDepartments());
     this.countSocialMediaAccounts();
     this.aMap.put("departments", this.deptCount);
     this.aMap.put("employees", this.EmpCount);
     this.aMap.put("socialMediaAccounts", this.socialMediaAccounts);
     this.aMap.put("usernames", this.usernames);
     this.aMap.put("passwords", this.passwords);
     //return aMap;
   
   }
   
   
   
   public void exportStats() throws IOException
   {
       try
       {
       this.writer = new FileWriter(this.csvFile);
       this.writer.append(this.aBusiness.getName());
       this.writer.append('\n');

       for (String a : this.aMap.keySet())
       {
           
            this.writer.append(a);
            System.out.println(a);
            this.writer.append(',');
       }
        this.writer.append('\n');
        for (Integer i : this.aMap.values())
        {
            this.writer.append(i.toString());
            System.out.println(i);
            this.writer.append(',');
        }
        this.writer.flush();
        this.writer.close();
       }
       catch (Exception anExcept)
       {
           System.out.println("ERROR: " + anExcept);
       }
   }
}



