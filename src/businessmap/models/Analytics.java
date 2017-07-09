/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessmap.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author erode
 */
public class Analytics {
    private Business aBusiness;
    private int deptCount;
    private int EmpCount;
   
        
    public Analytics()
    {

    }
    
    public Analytics(Business aBus)
    {
        this.aBusiness = aBus;
    }
    
    public void setBusiness(Business aBus)
    {
        this.aBusiness = aBus;
    }
    
    private void setDeptCount(int anAmount)
    {
        this.deptCount = anAmount;
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
    
    private int countDeptEmps(List<Department> aDept)
    {
        int i=0;
        for (Department d : aDept)
        {
             d.setEmployeeList(this.getBusiness());
             i += d.getEmployees().size();
             this.setEmpCount(i);
        }
        return this.getEmpAmount();
    }
   
   public Map<String,Integer> iniCount()
   {
     Map<String, Integer> aMap = new HashMap<>();
     this.countDept();
     this.countDeptEmps(this.getBusiness().getDepartments());
     aMap.put("Departments", this.getDeptAmount());
     aMap.put("Employees", this.EmpCount);
     return aMap;
   
   }
}
