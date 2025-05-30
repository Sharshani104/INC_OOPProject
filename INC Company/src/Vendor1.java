

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Date;
/**
 *
 * @author Saman
 */

    
public class Vendor1 {
     private int vId;
     private String vName;
     private String vAddress;
     private Date LastDate;
     
     
     public int getvId()
     {
         return vId;
     }
     
     
     public String getvName()
     {
         return vName;
     }
     
     public String getvAdddress()
     {
         return vAddress;
     }
     
     public Date getLastDate()
     {
         return LastDate;
     }
      
     public void setvName(String na)
     {
         this.vName=na;                
     }
     
     public void setvAddress(String add)
     {
         this.vAddress=add;
     }
     
     public void setLastdate(Date last)
     {
         this.LastDate=last;
     }
     
     public void setvId(int id)
     {
        vId=id;
     }
     

    String getvAddress() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Object setLastdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}