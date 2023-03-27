/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management;

import DB.DatabaseCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Muhammad
 */
public class ServiceForm {
       private String Full_name;
       private String Email;
       private int Contact;
       private String Address;
       private String Service;
       private String Service_code;
       private String Payment_method;
       private String Insurance;
       private String Ownership;
       private String Description;
       static LinkedList srvc_codes = new LinkedList();

    public ServiceForm(String Full_name, String Email, int Contact, String Address,String Service,String Service_code,String Payment_method, String Insurance, String Ownership, String Description) {
        this.Full_name = Full_name;
        this.Email = Email;
        this.Contact = Contact;
        this.Address = Address;
        this.Service = Service;
        this.Service_code =  Service_code;
        this.Payment_method = Payment_method;
        this.Insurance = Insurance;
        this.Ownership = Ownership;
        this.Description = Description;
    }

    public ServiceForm(String Full_name, String Email, int Contact, String Address, String Service, String Payment_method, String Insurance, String Ownership, String Description) {
        this.Full_name = Full_name;
        this.Email = Email;
        this.Contact = Contact;
        this.Address = Address;
        this.Service = Service;
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
    
    public void setService(String Service){
        this.Service = Service;
    }
    public String Service(){
        return this.Service;
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

    public void setService_code(String Service_code){
        this.Service_code =  Service_code;
    }
    public String getService_code(){
        return  Service_code;
    }
    @Override
    public String toString() {
        return "ServiceForm{" + "Full_name=" + Full_name + ", Email=" + Email + ", Contact=" + Contact + ", Address=" + Address + ", Service=" + Service + ", Service Code="+ Service_code+", Payment_method=" + Payment_method + ", Insurance=" + Insurance + ", Ownership=" + Ownership + ", Description=" + Description + '}';
    }


        
    public boolean add_srvc(ServiceForm srvcfrm){
        if(Full_name != null && Email != null && Contact != 0 && Address!= null && Service != null &&Payment_method != null && Insurance != null && Ownership != null && Description != null){
          try{
                Connection conn = DatabaseCon.connection();
                PreparedStatement ps = conn.prepareStatement("insert into Services values(?,?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1, srvcfrm.Full_name);
                ps.setString(2, srvcfrm.Email);
                ps.setInt(3, srvcfrm.Contact);
                ps.setString(4, srvcfrm.Address);
                ps.setString(5, srvcfrm.Service);
                String code = generator();
                ps.setString(6, code);
                ps.setString(7, srvcfrm.Payment_method);
                ps.setString(8, srvcfrm.Insurance);
                ps.setString(9,srvcfrm.Ownership );
                ps.setString(10, srvcfrm.Description);
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
                LocalDateTime now = LocalDateTime.now();  
                ps.setString(11,now.toString() );
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
        public static String generator(){
        getCodes();
        Random rand = new Random();
        char char_value = 'a';
       
        int check_counter = 0;
        while(true){
            int int_value =  rand.nextInt(1000,10000);
            String code = char_value+String.valueOf(int_value);

            if(check_counter == 3){
                char_value ++;
                check_counter = 0;
            }
            if(srvc_codes.contains(code)){
             check_counter++;
            }
            else{
                System.out.println("Code generated : "+code);
              return code;
            }
        }
    
    }
        public static LinkedList getCodes(){
            try{
               // LinkedList srvc_codes = new LinkedList();
                 Connection conn = DatabaseCon.connection();
                 PreparedStatement ps = conn.prepareStatement("select Service_code from Services");
                 ResultSet rs = ps.executeQuery();
                 System.out.println("=============");
                 System.out.println("Codes below:");
                 System.out.println("=============");
                 while(rs.next()){
                     String code = rs.getString("Service_code");
                     srvc_codes.add(code);
                     
                     System.out.println(code);
                 }
                 System.out.println("=============");
                 return srvc_codes;
            }
            catch(SQLException e){
                System.out.println("Exception : "+e);
                return null;
            }
        }
}
