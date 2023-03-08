<%-- 
    Document   : index
    Created on : Mar 5, 2023, 6:14:08 PM
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
	<title>Services</title>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&family=Roboto:wght@300&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="style.css">
	<link rel="icon" href="./resources/home.png">
</head>
<body>
       <div class="menu_bar">
        <div class="icon"></div>

        <div class="content_bar">
            <a href="/Services/Services.jsp">Services</a>
    
            
            <div class="dropdown_info">
                <a href="">Service Options</a>
                <div class="dropdown_content">
                    <a href="/Services/TrackService.jsp">Track Service</a>
                    <a href="/Services/ServiceHistory.jsp">Service History</a>
                </div>
            </div>

            <div class="dropdown_info">
                <a href="">Other</a>
                <div class="dropdown_content">
                <a href="/Services/CustomerService.jsp">Customer Service</a>
                    <a href="/Services/PrivacyPolicy.jsp" target="_self">Privacy Policy</a>
                    <a href="/Services/About.jsp">About</a>
                </div>
            </div>

            <div class="dropdown_info">
               <a href="" class="account"></a>
                <div class="dropdown_content">
                    <a href="/Services/SigninSignup.jsp" target="_self">Sign-in / Sign-up</a>
                    <a href="/Services/AccountInfo.jsp">Account Information</a>
                </div>
            </div>
           
        </div>
    </div>
    
    
	<div class="heading">Welcome to Services</div>
	<div class="container">
		<div class="left"></div>
		<div class="right">
			<p>
				At services we provide the best services to our customers so they would have all required household services at a click away. We prioritize our customers so that things would be done in accordance to the customer.
			</p>
			<a class="btn" href="/Services/Services.jsp">Explore</a>
		</div>
	</div>
</body>
</html>
