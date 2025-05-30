
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class Department_manager {
    
    
   Department_manager(){
      
    try{
    
            
        }
    catch(Exception ex)
    {
        System.out.print(ex);
        
    }
   }
    
    
    public boolean Update(Department d)
    {
        
            int id=d.getid(); 
            String Name=d.getDepname();
            
       try{
           Connection conn;
            conn=DriverManager.getConnection("\"jdbc:derby://localhost:1527/INC;ctreate=true\",\"app\",\"app\"");
             PreparedStatement p=conn.prepareStatement("update Department set Depname=? where depId=?" );
             
            p.setString(1,Name);
            p.setInt(2, id);
            p.executeUpdate();
            conn.close();
            return true;
           
       }     
       catch(SQLException ex)
       {
           System.out.print(ex);
           return false;
       }     
        
  }

    public boolean insert(Department d) {
        
        {
            
            int id=d.getid(); 
            String Name=d.getDepname();
            
    
        Connection conn;
            try {
                
                conn=DriverManager.getConnection("\"jdbc:derby://localhost:1527/INC;ctreate=true\",\"app\",\"app\"");
                PreparedStatement p=conn.prepareStatement("insert into Department values(?,?)");
                p.setInt(1,id);
                p.setString(2,Name);
                p.executeUpdate();
                conn.close();
                return true;
               
            }
            catch(SQLException ex)
            {
              System.out.println(ex);
              return false;
            }
      
      
  }
        
    }
public boolean deletebyid(int key)
  {
      Connection conn;
      try{
           conn=DriverManager.getConnection("\"jdbc:derby://localhost:1527/INC;ctreate=true\",\"app\",\"app\"");
           PreparedStatement p=conn.prepareStatement("delete from Department where depId=?");
            p.setInt(1,key);
                
                p.executeUpdate();
                conn.close();
                return true;
          
      }
      catch(SQLException ex)
      {
          System.out.println(ex);
          return false;
          
      }
      
  }
  
    public Department searchbyid(int id)
    {
        Connection conn;
        Department d=new Department();
        try{
            conn=DriverManager.getConnection("\"jdbc:derby://localhost:1527/INC;ctreate=true\",\"app\",\"app\"");
            Statement stmt= conn.createStatement();
            ResultSet  rslt=stmt.executeQuery("select * from Department where depId= " +id + " ");
            while(rslt.next())
            {
             d.setDepid(rslt.getInt("depId"));
             d.setDepName(rslt.getString("depName"));
             d.setDepNum(rslt.getString("phoneNumber"));
            }
            conn.close();
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        return d;
    }
    
}
