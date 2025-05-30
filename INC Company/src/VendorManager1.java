/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author rochana
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VendorManager1 {
     
    public class Vendor_manager {
    
    Vendor_manager()
    {
        try{
            
        }
        catch(Exception ex)
        {
            
        }
    }
  }
     public boolean insert(Vendor1 v)
   {
       Connection conn;
       
      String Vname=v.getvName();
      String Vaddress=v.getvAdddress();
       
       try{
           conn=(Connection) DriverManager.getConnection("jdbc:derby://localhost:1527/INC;create=true\",\"app\",\"app");
           PreparedStatement p=conn.prepareStatement("insert into vendor values(??)");
           p.setString(1,Vname);
           p.setString(2, Vaddress);
           p.executeUpdate();
           conn.close();
           return true;
           
       } catch (SQLException ex) {
           return false;
        }
   }
     public boolean deletebyname(String name)
   {
      
     
       try
       {
           Connection conn;
           conn=DriverManager.getConnection("jdbc:derby://localhost:1527/INC;create=true\",\"app\",\"app");
           PreparedStatement p= conn.prepareStatement("delete from Vendor where Vname=?");
           p.setString(1, name);
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
       public boolean Update(Vendor1 v)
   {
       String Vname=v.getvName();
      String Vaddress=v.getvAdddress();
      
      try{
          Connection conn;
          conn=DriverManager.getConnection("jdbc:derby://localhost:1527/INC;create=true\",\"app\",\"app");
          PreparedStatement p=conn.prepareStatement("update Vendor set Vname=?");
          p.setString(1, Vname);
          p.setString(2, Vaddress);
          conn.close();
          return true;
          
      }
      catch(SQLException ex)
      {
          System.out.print(ex);
          return false;
      }
     
   }  
    public Vendor1 Searchbyname(String name)
   {
       Vendor1 v=new Vendor1();
       Connection conn;
       try{
           
           conn=DriverManager.getConnection("jdbc:derby://localhost:1527/INC;create=true\",\"app\",\"app");
           Statement stmt = conn.createStatement();
           System.out.println("Enter the name to Search");
           ResultSet rslt = stmt.executeQuery("Select * from Vendor where vname = " + name + " ");
           
           while (rslt.next()){
               v.setvName(rslt.getString("vname"));
               
           }
            
           
           conn.close();
           
       }
       catch(SQLException ex)
       {
           System.out.print(ex);
       }
       
       return v;
   }
   
}
