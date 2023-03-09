/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management;

import DB.DatabaseCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Muhammad
 */
public class ServiceForm {
       private String Full_name;
       private String Email;
       private int Contact;
       private String Address;
       private String Payment_method;
       private String Insurance;
       private String Ownership;
       private String Description;

    public ServiceForm(String Full_name, String Email, int Contact, String Address, String Payment_method, String Insurance, String Ownership, String Description) {
        this.Full_name = Full_name;
        this.Email = Email;
        this.Contact = Contact;
        this.Address = Address;
        this.Payment_method = Payment_method;
        this.Insurance = Insurance;
        this.Ownership = Ownership;
        this.Description = Description;
    }

    public String getFull_name() {
        return Full_name;
    }

    public void setFull_name(String Full_name) {
        this.Full_name = Full_name;
    }

    public String getEmai() {
        return Email;
    }

    public void setEmai(String Emai) {
        this.Email = Emai;
    }

    public int getContact() {
        return Contact;
    }

    public void setContact(int Contact) {
        this.Contact = Contact;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPayment_method() {
        return Payment_method;
    }

    public void setPayment_method(String Payment_method) {
        this.Payment_method = Payment_method;
    }

    public String getInsurance() {
        return Insurance;
    }

    public void setInsurance(String Insurance) {
        this.Insurance = Insurance;
    }

    public String getOwnership() {
        return Ownership;
    }

    public void setOwnership(String Ownership) {
        this.Ownership = Ownership;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    @Override
    public String toString() {
        return "ServiceForm{" + "Full_name=" + Full_name + ", Emai=" + Email + ", Contact=" + Contact + ", Address=" + Address + ", Payment_method=" + Payment_method + ", Insurance=" + Insurance + ", Ownership=" + Ownership + ", Description=" + Description + '}';
    }
        
    public boolean add_srvc(ServiceForm srvcfrm){
        if(Full_name != null && Email != null && Contact != 0 && Address!= null && Payment_method != null && Insurance != null && Ownership != null && Description != null){
          try{
                Connection conn = DatabaseCon.connection();
                PreparedStatement ps = conn.prepareStatement("insert into Services values(?,?,?,?,?,?,?,?,?)");
                ps.setString(1, srvcfrm.Full_name);
                ps.setString(2, srvcfrm.Email);
                ps.setInt(3, srvcfrm.Contact);
                ps.setString(4, srvcfrm.Address);
                ps.setString(5, srvcfrm.Payment_method);
                ps.setString(6, srvcfrm.Insurance);
                ps.setString(7,srvcfrm.Ownership );
                ps.setString(8, srvcfrm.Description);
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
                LocalDateTime now = LocalDateTime.now();  
                ps.setString(9,now.toString() );
               ps.executeUpdate();
               System.out.println("Form Added");
              return true;
          }
          catch(SQLException e){
              System.out.println("Exception : "+e);
              return false;
          }
        }
        else{
            return false;
        }
    }
}
