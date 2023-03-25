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
import java.util.ArrayList;

/**
 *
 * @author Muhammad
 */
public class Client {
    private String Full_name;
    private int Age;
    private String Gender;
    private int Contact;
    private String Email;
    private String Password;
    private String Address;
    private String Contact_hrs_from;
    private String Contact_hrs_till;
    
    public Client(){
        
    }

    public Client(String Full_name, int Age, String Gender, int Contact, String Email, String Password, String Address, String Contact_hrs_from, String Contact_hrs_till) {
        this.Full_name = Full_name;
        this.Age = Age;
        this.Gender = Gender;
        this.Contact = Contact;
        this.Email = Email;
        this.Password = Password;
        this.Address = Address;
        this.Contact_hrs_from = Contact_hrs_from;
        this.Contact_hrs_till = Contact_hrs_till;
    }

    public String getFull_name() {
        return Full_name;
    }

    public void setFull_name(String Full_name) {
        this.Full_name = Full_name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public int getContact() {
        return Contact;
    }

    public void setContact(int Contact) {
        this.Contact = Contact;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getContact_hrs_from() {
        return Contact_hrs_from;
    }

    public void setContact_hrs_from(String Contact_hrs_from) {
        this.Contact_hrs_from = Contact_hrs_from;
    }

    public String getContact_hrs_till() {
        return Contact_hrs_till;
    }

    public void setContact_hrs_till(String Contact_hrs_till) {
        this.Contact_hrs_till = Contact_hrs_till;
    }

    @Override
    public String toString() {
        return "Client{" + "Full_name=" + Full_name + ", Age=" + Age + ", Gender=" + Gender + ", Contact=" + Contact + ", Email=" + Email + ", Password=" + Password + ", Address=" + Address + ", Contact_hrs_from=" + Contact_hrs_from + ", Contact_hrs_till=" + Contact_hrs_till + '}';
    }
    
    public boolean add_client(Client obj){
    if(obj.Full_name != null && obj.Age != 0 && obj.Gender != null && obj.Contact != 0 && obj.Email != null && obj.Password != null && obj.Address != null && obj.Contact_hrs_from != null && obj.Contact_hrs_till != null){
        try{
            Connection conn = DatabaseCon.connection();
            PreparedStatement ps = conn.prepareStatement("insert into Clients values(?,?,?,?,?,?,?,?,?)");
            ps.setString(1, obj.Full_name);
            ps.setInt(2, obj.Age);
            ps.setString(3, obj.Gender);
            ps.setInt(4, obj.Contact);
            ps.setString(5, obj.Email);
            ps.setString(6, obj.Password);
            ps.setString(7, obj.Address);
            ps.setString(8, obj.Contact_hrs_from);
            ps.setString(9, obj.Contact_hrs_till);
            ps.executeUpdate();
            System.out.println("Client Added");
            return true;
        }
        catch(SQLException e){
            System.out.println("Exception : "+e);
            return false;
        }
    }
    else{
        System.out.println("Error in the inout fields");
        return false;
    }
    }
    public static boolean verify_client(String email, String password){
        if(email != null && password != null){
            try{
                Connection conn = DatabaseCon.connection();
                PreparedStatement ps = conn.prepareStatement("select email, password from clients where email=?");
                ps.setString(1, email);
                ResultSet rs = ps.executeQuery();
                rs.next();
                String db_email = rs.getString("email");
                String db_password = rs.getString("password");
                
                if(db_email.equals(email) && db_password.equals(password)){
                    System.out.println("Credentials Matched");
                    return true;
                }
                else if(db_email.equals(email) && !db_password.equals(password)){
                    System.out.println("Invalid Password");
                    return false;
                }
                else{
                    System.out.println("User not found");
                    return false;
                }
            }
        catch(SQLException e){
            System.out.println("Exception : "+e);
            return false;
        }
        }
        else{
            System.out.println("Error in the inout fields");
            return false;
        }
       
    }
    public static ArrayList retrieve_info(String email, String password){
        if(email != null && password != null){
            try{
                Connection conn = DatabaseCon.connection();
                PreparedStatement ps = conn.prepareStatement("select Full_name, Age, Gender, Contact, Email, Address, Contact_hrs_from, Contact_hrs_till from clients where email=? and password=?");
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                rs.next();
                String Full_name = rs.getString("Full_name");
                int Age =  Integer.parseInt(rs.getString("Age"));
                String Gender = rs.getString("Gender");
                int Contact = Integer.parseInt(rs.getString("Contact"));
                String Email = rs.getString("Email");
                String Address = rs.getString("Address");
                String Contact_hrs_from = rs.getString("Contact_hrs_from");
                String Contact_hrs_till = rs.getString("Contact_hrs_till");
                
                ArrayList client_info = new ArrayList();
                client_info.add(Full_name);
                client_info.add(Age);
                client_info.add(Gender);
                client_info.add(Contact);
                client_info.add(Email);
                client_info.add(Address);
                client_info.add(Contact_hrs_from);
                client_info.add(Contact_hrs_till);
                
                return client_info;
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
    public boolean update_info(Client obj){
        String name = obj.Full_name;
        int age = obj.Age;
        String gender = obj.Gender;
        int contact = obj.Contact;
        String email = obj.Email;
        String password = obj.Password;
        String address = obj.Address;
        String contact_hrs_from = obj.Contact_hrs_from;
        String contact_hrs_till = obj.Contact_hrs_till;
        
        try{
             Connection con = DatabaseCon.connection();
             PreparedStatement ps = con.prepareStatement("update Clients set Full_name=?, Age=?, Gender=?, Contact=?, Email=?, Password=?,Address=?, Contact_hrs_from=?, Contact_hrs_till=? where Contact = ?; ");
             ps.setString(1, name);
             ps.setInt(2, age);
             ps.setString(3, gender);
             ps.setInt(4, contact);
             ps.setString(5, email); 
             ps.setString(6, password);
             ps.setString(7, address);
             ps.setString(8, contact_hrs_from);
             ps.setString(9, contact_hrs_till);
             ps.setInt(10, contact);
             
             ps.executeUpdate();
             System.out.println("Information Updated");
             return true;
        }
        catch(SQLException e){
            System.out.println("Exception : "+e);
            return false;
        }
       
        
    }
}

