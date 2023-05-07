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
       private int Contact;
       private String Address;
       private String Service;
       private String Service_code;
       private int Total_cost;
       private String Payment_method;
       private String Insurance;
       private String Ownership;
       private String Description;
       private String Service_status;
       static LinkedList srvc_codes = new LinkedList();

    public ServiceForm(int Contact, String Address,String Service,String Service_code,int Total_cost,String Payment_method, String Insurance, String Ownership, String Description, String Service_status) {
        this.Contact = Contact;
        this.Address = Address;
        this.Service = Service;
        this.Service_code =  Service_code;
        this.Total_cost = Total_cost;
        this.Payment_method = Payment_method;
        this.Insurance = Insurance;
        this.Ownership = Ownership;
        this.Description = Description;
        this.Service_status = Service_status;
    }

    public ServiceForm(int Contact, String Address, String Service,int Total_cost, String Payment_method, String Insurance, String Ownership, String Description, String Service_status) {
        this.Contact = Contact;
        this.Address = Address;
        this.Service = Service;
        this.Total_cost = Total_cost;
        this.Payment_method = Payment_method;
        this.Insurance = Insurance;
        this.Ownership = Ownership;
        this.Description = Description;
        this.Service_status = Service_status;
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

    public int getTotal_cost() {
        return Total_cost;
    }

    public void setTotal_cost(int Total_cost) {
        this.Total_cost = Total_cost;
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

    public String getService_status() {
        return Service_status;
    }

    public void setService_status(String Service_status) {
        this.Service_status = Service_status;
    }

    @Override
    public String toString() {
        return "ServiceForm{" + "Contact=" + Contact + ", Address=" + Address + ", Service=" + Service + ", Service_code=" + Service_code + ", Total_cost=" + Total_cost + ", Payment_method=" + Payment_method + ", Insurance=" + Insurance + ", Ownership=" + Ownership + ", Description=" + Description + ", Service_status=" + Service_status + '}';
    }
        
    public String add_srvc(ServiceForm srvcfrm){
        if(srvcfrm.Contact != 0 && srvcfrm.Address!= null && srvcfrm.Service != null && srvcfrm.Total_cost == 0 && srvcfrm.Payment_method != null && srvcfrm.Insurance != null && srvcfrm.Ownership != null && srvcfrm.Description != null && srvcfrm.Service_status != null){
          try{
                Connection conn = DatabaseCon.connection();
                PreparedStatement ps = conn.prepareStatement("insert into Services values(?,?,?,?,?,?,?,?,?,?,?)");
                ps.setInt(1, srvcfrm.Contact);
                ps.setString(2, srvcfrm.Address);
                ps.setString(3, srvcfrm.Service);
                String code = generator();
                ps.setString(4, code);
                ps.setInt(5, 0);
                ps.setString(6, srvcfrm.Payment_method);
                ps.setString(7, srvcfrm.Insurance);
                ps.setString(8,srvcfrm.Ownership );
                ps.setString(9, srvcfrm.Description);
                ps.setString(10, srvcfrm.Service_status);
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
                LocalDateTime now = LocalDateTime.now();  
                ps.setString(11,now.toString() );
               ps.executeUpdate();
               System.out.println("Form Added");
              return code;
          }
          catch(SQLException e){
              System.out.println("Exception : "+e);
              return null;
          }
        }
        else{
            return null;
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
