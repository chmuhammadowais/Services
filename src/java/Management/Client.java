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
    public boolean verify_client(String email, String password){
        if(email != null && password != null){
            try{
                Connection conn = DatabaseCon.connection();
                PreparedStatement ps = conn.prepareStatement("select email, password from clients where email=?");
                ps.setString(1, email);
                ResultSet rs = ps.executeQuery();
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
}

