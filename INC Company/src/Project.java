/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Project
 * @author 
 */
public class Project  {
    
    private int pid;
    private String pname;
    private double pcost;
    
    public Project(){
        
    }

    Project(int parseInt, String trim, float parseFloat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void Project(int id,String name,double cost){
        
        this.pid=id;
        this.pname=name;
        this.pcost=cost;
        
    }
    
    public void setpid(int id){
        
        pid=id;
    }
    
    public void setpname(String name){
        
        pname=name;
    }
    
    public void setpcost(double cost){
        
        pcost=cost;
    }
    
    public int getpid(){
        
        return pid;
    }
    
    public String getpname(){
        
        return pname;
    }
    
    public double getpcost(){
        
        return pcost;
    }
    
    
    
}
