<%-- 
    Document   : Services
    Created on : Mar 5, 2023, 6:30:22 PM
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
	<link rel="icon" href="./resources/repair-service-icon.png">
</head>

<body>
    <%session.removeAttribute("service_code");%>
    <%session.removeAttribute("status");%>
    <%session.removeAttribute("errorMessage");%>
    <%session.removeAttribute("SQLError");%>
    <%session.removeAttribute("FB");%>
    <%session.removeAttribute("FB_error");%>    
    <%session.removeAttribute("form_error");%>    
       <div class="menu_bar">
        <div class="icon"></div>

        <div class="content_bar">
            <a href="/Services/Services.jsp">Services</a>
    
            
            <div class="dropdown_info">
                <a href="">Service Options</a>
                <div class="dropdown_content">
                    <a href="/Services/TrackService.jsp">Track Service</a>
                    <a href="/Services/HistoryHandler">Service History</a>
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
                    
                    <a href="/Services/SigninSignup.jsp" target="_self">
                        <%
                         String Email = (String)session.getAttribute("Email");
                        if(Email == null){
                        out.println("Sign in / Sign up");
                        }
                        %>
                    </a>
                    <a href="/Services/AccountInfo.jsp">Account Information</a>
                    <a href="/Services/LogoutHandler"><%
                        if(Email != null){
                        out.println("Logout");
                        }
                        %></a>
                </div>
            </div>
           
        </div>
    </div>
    
    
    <div class="heading">
		Services we offer
	</div>

    <form action="/Services/FormRedirector" class="services" action="/Services/ServiceForm.jsp">
        <div class="item">
            <button type="submit" value="Electric Repair" name="btn"></button>
            <p>Electrical Repair</p>
        </div>

        <div class="item">
            <button type="submit" value="Furniture Repair" name="btn"></button>
            <p>Furniture Repair</p>
        </div>

        <div class="item">
            <button type="submit" value="Plumbing Repair" name="btn"></button>
            <p>Plumbing Repair</p>
        </div>

        <div class="item">
            <button type="submit" value="Air Conditioning Repair" name="btn"></button>
            <p>Air Conditioning</p>
        </div>

        <div class="item">
            <button type="submit" value="House Heating Repair" name="btn"></button>
            <p>House Heating</p>
        </div>

        <div class="item">
            <button type="submit" value="Construction Repair" name="btn"></button>
            <p>Construction</p>
        </div>

        <div class="item">
            <button type="submit" value="General Repair" name="btn"></button>
            <p>General Repairing</p>
        </div>

        <div class="item">
            <button type="submit" value="House Cleaning" name="btn"></button>
            <p>House Cleaning</p>
        </div>

        <div class="item">
            <a href="/Services/OtherServices.jsp"></a>
            <p>Other Services</p>
        </div>
    </form>
</body>
</html>
