/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class Department {
    
    private int Depid;
    private String DepName;
    private String DepNum;
    
    private Department d;
   
    public void setDepid(int id)
    {
        this.Depid=id;
    }
    public void setDepName(String name)
    {
        this.DepName=name;
    }
    public void setDepNum(String number)
    {
        this.DepNum=number;
    }
    
    public int getid()
    {
       return Depid;
       
    }
    public String getDepname()
    {
        return DepName;
    }
    public String getnumber()
    {
        return DepNum;
    }
}
