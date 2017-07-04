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
    
    public void setDeptCount(int anAmount)
    {
        this.deptCount = anAmount;
    }
    
    public void setEmpCount(int anAmount)
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
    
    public int countDept()
    {
        if(this.getBusiness()!=null)
        {
            this.setDeptCount(this.aBusiness.getDepartments().size());
        }
        return this.getDeptAmount();
    }
    
    public int countEmp()
    {
        int i = 0;
        if(this.getBusiness()!=null)
        {
            for (Department a : this.getBusiness().getDepartments())
            {
                a.setEmployeeList(this.getBusiness());
                i += a.getEmployees().size();
            }
            this.setEmpCount(i);
        }
        return this.getEmpAmount();
    }
   
   
}
