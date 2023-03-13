<%-- 
    Document   : SigninSignup
    Created on : Mar 6, 2023, 9:24:34 AM
    Author     : Muhammad
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Sign in / Sign up</title>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&family=Roboto:wght@300&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="style.css" type="text/css">
	<link rel="icon" href="./resources/lock-icon-11.png">
</head>
<body>
  <div class="back">
        <a href="/Services/Services.jsp"></a>
    </div>
<div class="heading">
		Sign in / Sign up
	</div>

    <div class="accountavatar"></div>

    <form action="SigninHandler" method="post" class="otherserviceform">
        <input type="email" class="input_field" placeholder="Email" name="email">
        <input type="password" class="input_field" placeholder="Password" name="password">
        <button type="submit" class="submit_btn">Submit</button>
    </form>

    <form class="otherlogin" method="post" action="SignupRequestHandler">
       <button type="submit" value="Email" name="btn" class="email">Sign up with Email</button>
       
       <button type="submit" value="Google" name="btn" class="google">Sign up with Google</button>
       
       <button type="submit" value="Facebook" name="btn" class="facebook">Sign up with Facebook</button>
    </form>        
</body>
</html>