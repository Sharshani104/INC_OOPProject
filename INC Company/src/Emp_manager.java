/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Saman
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

public class Emp_manager {
    
    
    public boolean deleteByid(int id)//make deletebyid method to get that inserted id 
    
    {
        Connection conn;
            try {
                conn=DriverManager.getConnection("");
                PreparedStatement p=conn.prepareStatement("delete from Employee where empId=?");
                p.setInt(1,id);//assign values to querry from inserted
                p.executeUpdate();//execute the querry
                conn.close();
                return true;
            } catch (SQLException ex) {
               System.out.println(ex +"Cannot delete"); 
               return false;
            }
        
    
    }
    public boolean insert(final_emp e)
    {        
            int id=e.getid();//call the getid method from employee object e
            String Name=e.getName();
            String dob=e.getdate();
            int mid=e.getmarryid();
            String dom=e.getmarrydate();
        Connection conn;
            try {
              
                //Connection 
                conn=DriverManager.getConnection("\"jdbc:derby://localhost:1527/INC;ctreate=true\",\"app\",\"app\"");
                PreparedStatement p=conn.prepareStatement("insert into Employee(empId,empName,dateOfBirth,spouseId,dateOfMarriage) values(?,?,?,?,?)");
                p.setInt(1,id);
                p.setString(2,Name);
                p.setString(3,dob);
                p.setInt(4,mid);
                p.setString(5,dom);
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
     public boolean update(final_emp e) 
     {
        Connection conn;
        int id = e.getid();
        String name = e.getName();
        try 
        {
            conn = DriverManager.getConnection("\"jdbc:derby://localhost:1527/INC;ctreate=true\",\"app\",\"app\"");
            PreparedStatement ps = conn.prepareStatement("update Employee set empName = ? where empId = ?");
            ps.setString(1, name);
            ps.setInt(2, id);
            ps.executeUpdate();
            conn.close();
            return true;
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex);
            return false;
        } 
     }
        
    /**
     *
     * @param
     * @return
     */

    /**
     *
     * @param num
     * @return 
     */
    public final_emp  searchById(int num) 
    {
       Connection conn;
       final_emp e= new final_emp();
       Project p=new Project();
        try {
            conn = DriverManager.getConnection("\"jdbc:derby://localhost:1527/INC;ctreate=true\",\"app\",\"app\"");
            java.sql.Statement stmt = conn.createStatement();
            System.out.println("Enter the name to Search");
            ResultSet rslt = stmt.executeQuery("Select * from Employee where empId = " + num + " ");
            while (rslt.next()) {

              //  e = new Employee(result.getInt("empid"), result.getName("empName"));
              e.setid(rslt.getInt("empId"));
              e.setName(rslt.getString("empName"));
               e.setdob(rslt.getString("dateOfBirth"));
               p.setpid(rslt.getInt("pId"));
               e.setmarryid(rslt.getInt("spouseId"));
               e.set_marrydate(rslt.getString("dateOfMarriage"));
           
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return e;
    }
    
    

    public int Searchsalaray(int id) {
        
        final_emp e=new final_emp();
        try{
            
            Connection conn;
            conn= DriverManager.getConnection("\"jdbc:derby://localhost:1527/INC;ctreate=true\",\"app\",\"app\"");
            java.sql.Statement stmt = conn.createStatement();
            ResultSet rslt = stmt.executeQuery("Select deduction,allowences,basicSalary from Employee where empId='" +id+ "'");
             while (rslt.next()) {
                 
                 
                
                e.full_calsalary(rslt.getInt("basicSalary"),rslt.getInt("deduction"),rslt.getInt("allowences"));
                
            }
            conn.close(); 
        }
        catch(SQLException ex)
        {
            System.out.println("Enter your salary");
            
        }
        return 0;
    }
    
    
}
