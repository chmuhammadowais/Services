<%-- 
    Document   : CustomerService
    Created on : Mar 6, 2023, 12:44:07 PM
    Author     : Muhammad
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Customer Service</title>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&family=Roboto:wght@300&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="style.css" type="text/css">
	<link rel="icon" href="./resources/headphones.png">
</head>
<body>
    <div class="back">
        <a href="/Services/Services.jsp"></a>
    </div>
    <div class="heading">
	Customer Service
    </div>

    <div class="cust_srvc"></div>

    <h3>
        Welcome to customer service. Please provide with details and our representative will be in touch with you shortly.
    </h3>
    
    <form class="otherserviceform" action="CustomerServiceHandler" method="post">
<div class="innerformcontainer">
	<div class="formitem">
		<label for="name">Full Name</label>
                <input type="text" id="Full_name" name="Full_name" class="input_field">
	</div>
   
	<div class="formitem">
		<label for="email">Email</label>
                <input type="email" id="Email" name="Email" class="input_field">
	</div>
	
	<div class="formitem">
		<label for="contact">Contact</label>
		<input type="tel" id="Contact" name="Contact" class="input_field">
	</div>

	<div class="formitem">
		<label for="feedback_type">Feedback Type</label>
                <input type="text" id="Feedback_type" name="Feedback_type" class="input_field">
	</div>
</div>

<div class="formtextarea">
	<label class="desc" for="feedback">Feedback</label>
	<textarea name="Feedback" id="Feedback"  cols="30" rows="10"></textarea> 
</div>
        <button type="submit" class="submit_btn">Submit</button>
    </form>
</body>
</html>
