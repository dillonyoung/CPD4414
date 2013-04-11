<%-- 
    Document   : login
    Created on : 9-Mar-2013, 5:04:33 PM
    Author     : Dillon Young (C0005790)
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
        <script src="script/login.js"></script>
        <script src="script/support.js"></script>
        <link rel="stylesheet" href="./css/main.css" />
        <title>TraCare</title>

    </head>
    <body>
        <div id="status_message"></div>
        <div data-role="page" id="login">
            <div data-role="header" data-theme="b" data-position="fixed" data-tap-toggle="false">
                <h1>TraCare</h1>

            </div>
            <div data-role="content">
		<div data-role="content" data-theme="c">
                    <form name="form_login" id="form_login">
                        <p class="bold">Email Address: <span class="error" id="error_email"></span><input type="text" name="email" id="email" /></p>
                        <p class="bold">Password: <span class="error" id="error_password"></span><input type="password" name="password" id="password" /></p>
                        <a href="" data-role="button" data-theme="b" id="btn_login">Login</a>       
                        <a href="index.jsp" data-role="button" data-theme="c" rel="external" id="btn_cancel">Cancel</a> 
                    </form>
                </div>
            <div data-role="footer" data-position="fixed" data-tap-toggle="false">
                <h1>&nbsp;</h1>
            </div>
 
        </div>
    </body>
</html>
