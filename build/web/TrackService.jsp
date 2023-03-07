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

    <form action="" class="otherserviceform">
        <input type="text" class="input_field" placeholder="Tracking ID">
        <button type="submit" class="submit_btn">Submit</button>
    </form>
</body>
</html>
