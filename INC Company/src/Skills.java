/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Saman
 */
public class Skills {
    
    private int sid;
    private String sname;
    private String sdiscription;
    
    public Skills(){
        
    }

    
    
    Skills(int id,String name,String discription){
        this.sid=id;
        this.sname=name;
        this.sdiscription=discription;
    }
    
     public void setsid(int id){
        
        sid=id;
    }
    
    public void setsname(String name){
        
        sname=name;
    }
    
    public void setscost(String discription){
        
        sdiscription=discription;
    }
    
    public int getsid(){
        
        return sid;
    }
    
    public String getsname(){
        
        return sname;
    }
    
    public String getsdescription(){
        
        return sdiscription;
    }
}
