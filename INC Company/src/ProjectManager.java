
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Saman
 */
public class ProjectManager {
    
    public ProjectManager(){
        
    }

    ProjectManager(Project project) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
    public boolean insert(Project project){
        
        int id=project.getpid();
        String name=project.getpname();
        double cost=project.getpcost();
        Connection dbcon;
        
        try{
        dbcon = DriveManager.getConnection("jdbc:derby://localhost:1527/INC;ctreate=true","app","app");
        PreparedStatement ps = dbcon.prepareStatement("insert into Project values(?,?,?) ");
        ps.setInt(1,id);
        ps.setString(2,name);
        ps.setDouble(3,cost);
        ps.executeUpdate();
        dbcon.close();
        return true;
        }
        
        catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public Project searchById(int key){
        
        Project project = new Project();
        Connection dbcon;
        try{
            dbcon = DriveManager.getConnection("jdbc:derby://localhost:1527/INC;ctreate=true","app","app");
            Statement stmt = dbcon.createStatement();
            System.out.println("Enter Project ID");
            ResultSet rslt=stmt.executeQuery("select * from Progect where pId=" + key + "");  
            
            if(rslt.next()){
                
                project = new Project(rslt.getInt("pId"),rslt.getString("pName"),rslt.getFloat("cost"));
                
            }
            dbcon.close();
            
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return project;  
    }
    
    public boolean update(Project project){
        
        int id=project.getpid();
        String name=project.getpname();
        double cost=project.getpcost();
        Connection dbcon;
        try{
            dbcon = DriveManager.getConnection("jdbc:derby://localhost:1527/INC company;ctreate=true","app","app");
            PreparedStatement ps = dbcon.prepareStatement("update Project set pName=?,cost=? where pId=?");
            ps.setString(1,name);
            ps.setDouble(2,cost);
            ps.setInt(3,id);
            ps.executeUpdate();
            dbcon.close();
            return true;
        }
        catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }        
    }
    
    public boolean delete(int key){
        
        Connection dbcon;
        
        try{
           dbcon=DriveManager.getConnection("jdbc:derby://localhost:1527/INC;ctreate=true","app","app");
           PreparedStatement ps = dbcon.prepareStatement("delete from Project where pId="+key+"");
           System.out.println("Enter project ID");
           ps.executeUpdate();
           dbcon.close();
           return true;    
        }
        catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }    
       
    }

    boolean insert(Skills skill) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
