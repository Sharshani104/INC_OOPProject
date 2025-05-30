/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Saman
 */
public class final_emp {
    
    public int Netsalary; 
    int empid;
    private String Ename;
    private String E_dob;
    
    private String Date_of_marry;
    private int married_emp_id;
   
     
    
     Department dep=new Department();
    
    Skills s=new Skills();
    int Pnumber;
    
    public Project p;
    
    final_emp()
    {
        
    }
    
    final_emp(int id,String name,String dob)
    {
        
        this.empid=id;//assign the values to varibles
        this.Ename=name;
        this.E_dob=dob;
           
        
        
        
        
       
        
    }


   public void setpnum(int id)
   {
       this.Pnumber=id;
   }

    public void setproject(Project pro)
    {
        
        this.p=pro;
    }

    
    
       public void marry(int marryid,String marrydate)
        {
                this.married_emp_id=marryid;
                this.Date_of_marry=marrydate;
        }
        public void setid(int id)
        {
            empid=id;
       
        }
        public void setName(String name)
        {
       
            Ename=name;
        }
        public void setdob(String birthday_date)
        {
            E_dob=birthday_date;   
        }
        public void setmarryid(int marry_id)
        {
             married_emp_id=marry_id;    
        }
         public void set_marrydate(String marrydate)
         {
        
            Date_of_marry=marrydate;       
         }
    
   
    
    public String getName()
    {
         return Ename;   
    }
    public int getid()
    {
        return empid;
    }
    public String getdate()
    {
         return E_dob;
    }
    public String getmarrydate()
    {
        return Date_of_marry;
    }
    public int getmarryid()
    {
        
        return married_emp_id;
    }

    public int getPnumber()
    {
        return Pnumber;
    }
     public int full_calsalary(int Basic,int deduction,int allownce)
     {
            
            Netsalary=(Basic-deduction)+allownce;
            return Netsalary;
            
     }
     public int part_calsalary(int working_hr)
     {
         int hr_rate=850;
                 
         Netsalary=hr_rate*working_hr;
         return Netsalary;
         
     }

}
