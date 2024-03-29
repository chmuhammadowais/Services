<%-- 
    Document   : AccountInfo
    Created on : Mar 6, 2023, 9:25:21 AM
    Author     : Muhammad
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    <div class="popup_service_code" id="popup_service_code">
        <h2>Success</h2>
        <img src="./resources/check.png" alt="" class="check">
        <div class="srvc_info">
            <p id="FBpopup">Account Information Updated Successfully</p>
        </div>
        <button class="ok_btn" id="ok_btn">Ok</button>
    </div>
    
        <div id="err" class="err"> <%
              String errorMessage = (String) session.getAttribute("update_err");
              if(errorMessage != null){
              %> <p id="err_text">  <%out.println("Error updating the information. Please try again in a few moments. We apoligize for the inconvinience.");%></p> <%
            }
             
            %></div>
    
    <form action="AccountInfoHandler"  method="post" class="form_container">
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
                <label for="hrs1">Contact Hours From</label>
                <input type="time" id="hrs1" class="input_field_time" name="time1" value=<%out.println(session.getAttribute("Contact_hrs_from")); %> required >
                 <label for="hrs2">Till</label>
                <input type="time" id="hrs2" class="input_field_time" name="time2" value=<%out.println(session.getAttribute("Contact_hrs_till")); %> required>
            </div>

        
        </div>
         <button type="submit" class="submit_btn">Update</button>
    </form>
            <%
            String update_status = (String) session.getAttribute("update_status");
            if(update_status != null){
             out.println(update_status);
                }
            %>
              <script src="/Services/JavaScript/popup.js"></script>
            <script>
                let update_status = '<%=update_status%>';
                console.log(update_status);
                  if(update_status === null || update_status ==="" || update_status ==="null"){
               
             }
             else{
                  
                   start();
                   <%
                   if(update_status != null){
                   session.invalidate();
                       }
                   %>
             }
            </script>
</body>
</html>