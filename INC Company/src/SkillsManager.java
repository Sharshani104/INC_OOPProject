
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
public class SkillsManager {
    
    public SkillsManager(){
        
    }

    
  
    public boolean insert(Skills skills){
        
        int id=skills.getsid();
        String name=skills.getsname();
        String description=skills.getsdescription();
        Connection dbcon;
        
        try{
        dbcon = DriveManager.getConnection("jdbc:derby://localhost:1527/INC;ctreate=true","app","app");
        PreparedStatement ps = dbcon.prepareStatement("insert into Project values(?,?,?)");
        ps.setInt(1,id);
        ps.setString(2,name);
        ps.setString(3,description);
        ps.executeUpdate();
        dbcon.close();
        return true;
        }
        
        catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public Skills searchById(int key){
        
        Skills skill = new Skills();
        Connection dbcon;
        try{
            dbcon = DriveManager.getConnection("jdbc:derby://localhost:1527/INC;ctreate=true","app","app");
            Statement stmt = dbcon.createStatement();
            System.out.println("Enter Project ID");
            ResultSet rslt=stmt.executeQuery("select * from Progect where pId=" + key + "");  
            
            if(rslt.next()){
                
                skill = new Skills(rslt.getInt("sId"),rslt.getString("sName"),rslt.getString("skillDescription"));
                
            }
            dbcon.close();
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return skill;  
    }
    
    public boolean update(Skills skill){
        
        int id=skill.getsid();
        String name=skill.getsname();
        String description=skill.getsdescription();
        Connection dbcon;
        try{
            dbcon = DriveManager.getConnection("jdbc:derby://localhost:1527/INC company;ctreate=true","app","app");
            PreparedStatement ps = dbcon.prepareStatement("update Skill set sName=?,skillDescription=? where sId =?");
            ps.setString(1,name);
            ps.setString(2,description);
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
           PreparedStatement ps = dbcon.prepareStatement("delete from Skill where sId="+key+"");
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

    
}
