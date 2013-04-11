<%-- 
    Document   : index
    Created on : 9-Mar-2013, 5:04:33 PM
    Author     : Dillon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.0/jquery.mobile-1.3.0.min.css" />
	<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.3.0/jquery.mobile-1.3.0.min.js"></script>
        <link rel="stylesheet" href="./css/main.css" />
        <title>TraCare</title>

    </head>
    <body>
        <div data-role="page" id="main">
            <div data-role="header" data-theme="b" data-position="fixed" data-tap-toggle="false">
                <h1>TraCare</h1>
            </div>
            <div data-role="content">
                <a href="register.jsp" data-role="button" data-theme="c" data-transition="flip" rel="external" id="btn_register2">Register</a>
                <a href="login.jsp" data-role="button" data-theme="c" data-transition="flip" rel="external" id="btn_login">Login</a>
                
            </div>
            <div data-role="footer" data-position="fixed" data-tap-toggle="false">
                <h1>&nbsp;</h1>
            </div>
        </div>

    </body>
</html>
