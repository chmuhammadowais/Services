/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management;

/**
 *
 * @author Muhammad
 */
public class ServiceForm {
       private String Full_name;
       private String Emai;
       private int Contact;
       private String Address;
       private String Payment_method;
       private String Insurance;
       private String Ownership;
       private String Description;

    public ServiceForm(String Full_name, String Emai, int Contact, String Address, String Payment_method, String Insurance, String Ownership, String Description) {
        this.Full_name = Full_name;
        this.Emai = Emai;
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
        return Emai;
    }

    public void setEmai(String Emai) {
        this.Emai = Emai;
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
        return "ServiceForm{" + "Full_name=" + Full_name + ", Emai=" + Emai + ", Contact=" + Contact + ", Address=" + Address + ", Payment_method=" + Payment_method + ", Insurance=" + Insurance + ", Ownership=" + Ownership + ", Description=" + Description + '}';
    }
        
    public boolean add_srvc(String Full_name,  String Email, int Contact,  String Address, String Payment_method, String Insurance,String Ownership, String Description){
        if(Full_name != null && Email != null && Contact != 0 && Address!= null && Payment_method != null && Insurance != null && Ownership != null && Description != null){
          try{
              return true;
          }
          catch(Exception e){
              System.out.println("Exception : "+e);
              return false;
          }
        }
        else{
            return false;
        }
    }
}
