<%-- 
    Document   : OtherServices
    Created on : Mar 6, 2023, 12:49:12 PM
    Author     : Muhammad
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Other Service Form</title>
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

    <h3>
        Not sure for your repair? You can provide the details of your problem and we’ll get back to you.
    </h3>

    <form action="" class="form_container">
        <div class="otherserviceform">
            <textarea name="description" id="description" cols="30" rows="10" placeholder="Description"></textarea>
            <button type="submit" class="submit_btn">Submit</button>
        </div>
    </form>

    <div class="other_contact">
        <div class="cont">
            <label for="uan">UAN</label>
            <a href="#" id="uan">xxx - xxx - xxx</a>
        </div>
        <div class="cont">
            <label for="email">Email</label>
            <a href="#" id="email">services@email.com</a>
        </div>
    </div>
</body>
</html>
