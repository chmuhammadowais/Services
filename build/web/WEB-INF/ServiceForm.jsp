<%-- 
    Document   : ServiceForm
    Created on : Mar 6, 2023, 8:55:13 AM
    Author     : Muhammad
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Services Form</title>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&family=Roboto:wght@300&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="style.css" type="text/css">
	<link rel="icon" href="./resources/pages-icon.png">
</head>
<body>
    <div class="back">
        <a href="/Services/Services.jsp"></a>
    </div>

    <div class="heading">
		Services Form
	</div>
  
    <div class="subheading">
    <%
    String type = request.getParameter("btn");
     if(type != null){
     session.setAttribute("Service",type);
    	 out.print(type);
     }
     else{
    	 out.print("");
     }
     %>
    </div>

    <form action="ServiceFormHandler" method="post" class="form_container">
        <div class="innerformcontainer">
            <div class="formitem">
                <label for="name">Full Name</label>
                <input type="text" id="name" class="input_field" name="name" value = "<%out.println(session.getAttribute("Full_name")); %>" readonly>
            </div>
           
            <div class="formitem">
                <label for="email">Email</label>
                <input type="email" id="email" class="input_field" name="email" value="<%out.println(session.getAttribute("Email"));%>" readonly>
            </div>
            
            <div class="formitem">
                <label for="contact">Contact</label>
                <input type="tel" id="contact" class="input_field" name="contact" value="<%out.println(session.getAttribute("Contact"));%>" readonly>
            </div>
            
            <div class="formitem">
                 <label for="address">Address</label>
                 <input type="text" id="address" class="input_field" name="address" value="<%out.println(session.getAttribute("Address"));%>" readonly>
            </div>
            
            <div class="formitem">
                <label for="payment">Payment</label>
<!--                <input type="text" id="payment" class="input_field" name="payment">-->
                <select class="input_field_options" name="payment_opt">
                    <option value="cod">COD</option>
                    <option value="creditcard">Credit / Debit</option>
                    </select>
            </div>
            
            <div class="formitem">
                <label for="insurance">House Insured</label>
                <div class="radio_btn">
                    <label for="insured">Insured</label>
                    <input type="radio" id="insured" name="insurance" value="yes" name="insurance" required>
                    
                    <label for="notisnured">Not Insured</label>
                    <input type="radio" id="notinsured" name="insurance" value="no" name="insurance" required>
                </div>
               
            </div>
           
            <div class="formitem">
                <label for="cost">Service Fee</label>
                <input type="number" id="cost" class="input_field" value="1000" readonly required>
            </div>
    
            <div class="formitem">
                <label for="ownership">House Ownership</label>
                <div class="radio_btn">
                    <label for="yes">Yes</label>
                    <input type="radio" id="yes" name="ownership" value="yes" name="ownership" required>
                    <label for="no">No</label>
                    <input type="radio" id="no" name="ownership" value="no" name="ownership" required>
                </div>
                
            </div>
        </div>
       
       
        <div class="formtextarea">
            <label class="desc" for="description">Description</label>
            <textarea name="description" id="description" cols="30" rows="10" name="description" required></textarea>
        </div>
        
        <button type="submit" class="submit_btn">Submit</button>
    </form>
</body>
</html>
