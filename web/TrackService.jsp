<%-- 
    Document   : TrackService
    Created on : Mar 7, 2023, 9:46:37 PM
    Author     : Muhammad
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Track Service</title>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&family=Roboto:wght@300&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="style.css" type="text/css">
	<link rel="icon" href="./resources/warehousing-icon.png">
</head>
<body>

     <div class="prog_cont" id="prog_cont">
        <h2>Your Service Progress</h2>
        <div class="prog_bar">
            <div class="subitem">
                 <div class="bar">
                    <canvas id="C1" width="50" height="50"></canvas>
                 </div>
                 <b><p>Initialize</p></b>
            </div>
           
            <div class="subitem">
                <div class="bar">
                    <canvas id="C2" width="50" height="50"></canvas>
                </div>
                <b><p>In Progress</p></b>
           </div>

           <div class="subitem">
            <div class="bar">
                <canvas id="C3" width="50" height="50"></canvas>
            </div>
            <b><p>Service Completed</p></b>
       </div>
        </div>

        <br>
        <br>
        
        <div class="contact">
            <h4>You can always get back to us through these contact numbers.</h4>
            <label for="email">Email</label>
            <input type="text" id="email" class="con" value="services@email.com"  readonly>
            <label for="UAN">UAN</label>
            <input type="text" id="UAN" class="con" value="XXX - XXX - XXX" readonly>
        </div>

        <button class="submit_btn" id="ok">Ok</button>
    </div>


<script>
    let status = '<%= session.getAttribute("status") %>';
    console.log("Status Var = " + status);
</script>

    </script>
    
     <script src="service_status.js"></script>
     <script>
     if(status === null || status ==="" || status ==="null"){
              
             }
             else{
                  start();
             }

    </script>
   
   
<div class="back">
        <a href="/Services/Services.jsp"></a>
    </div>
    <div class="heading">
		Track your service
	</div>

    <div class="truckavatar"></div>

    <h3>
        Please provide the tracking ID that was provided to you on confirmation to track the progress of your service.
    </h3>

    <form action="TrackServiceHandler" method="post" class="otherserviceform">
        <input type="text" name="srvc_code" class="input_field" placeholder="Tracking ID">
         <div id="err" class="err"> <%
             String error = (String) session.getAttribute("SQLError");
              if(error != null){
               out.print("<p>Error: " + error + "</p>");
            }
             
            %></div>
        <button type="submit" class="submit_btn">Submit</button>
    </form>
      

    
</body>
</html>
