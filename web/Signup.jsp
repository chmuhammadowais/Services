<%-- 
    Document   : Signup
    Created on : Mar 25, 2023, 5:29:07 PM
    Author     : Muhammad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Account Information</title>
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
		Account Information
	</div>

    <div class="accountavatar"></div>

    <form action="SignupHandler"  method="post" class="form_container">
        <div class="innerformcontainer">
            <div class="formitem">
                <label for="name">Full Name</label>
                <input type="text" id="name" class="input_field" name="name" value=<%
                    String Full_name = (String) session.getAttribute("Full_name");
                    if(Full_name != null){
                        out.println(Full_name);
                    }
                %>>
            </div>

            <div class="formitem">
                <label for="age">Age</label>
                <input type="number" id="age" class="input_field" name="age" value=<%
                    Integer Age = (Integer) session.getAttribute("Age");
                  if(Age != null){
                  out.println(Age);
                }
                %>>
            </div>

            <div class="formitem">
                <label for="gender">Gender</label>
                <input type="text" id="gender" class="input_field" name="gender" value=<%
                    String Gender = (String )session.getAttribute("Gender");
                    if(Gender != null){
                        out.println(Gender);
                    }
                %>>
            </div>

            <div class="formitem">
                <label for="contact">Contact</label>
                <input type="tel" id="contact" class="input_field" name="contact" value=<%
                  Integer Contact = (Integer) session.getAttribute("Contact");
                  if(Contact != null){
                    out.println(Contact);
                    }
                %>>
            </div>

            <div class="formitem">
                <label for="email">Email</label>
                <input type="email" id="email" class="input_field" name="email" value=<%
                    String Email = (String) session.getAttribute("Email"); 
                    if(Email != null){
                     out.println(Email);
                    }
                %>>
            </div>

            <div class="formitem">
                <label for="password">Password</label>
                <input type="password" id="password" class="input_field" name="password">
            </div>

            <div class="formitem">
                <label for="address">Address</label>
                <input type="text" id="address" class="input_field" name="address" value=<%
                    String Address = (String) session.getAttribute("Address");
                    if(Address != null){
                    out.println(Address);
                    }
                %>>
            </div>

            <div class="formitem">
                <label for="hrs">Contact Hours</label>
                <input type="time" id="hrs" class="input_field_time" name="time1" value=<%out.println(session.getAttribute("Contact_hrs_from")); %> required >
                <input type="time" id="hrs" class="input_field_time" name="time2" value=<%out.println(session.getAttribute("Contact_hrs_till")); %> required>
            </div>

        
        </div>
         <button type="submit" class="submit_btn">Signup</button>
    </form>
</body>
</html>