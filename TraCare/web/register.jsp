<%-- 
    Document   : register
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
        <script src="script/register.js"></script>
        <script src="script/support.js"></script>
        <link rel="stylesheet" href="./css/main.css" />
        <title>TraCare</title>

    </head>
    <body>
        <div id="status_message"></div>
        <div data-role="page" id="register">
            <div data-role="header" data-theme="b" data-position="fixed" data-tap-toggle="false">
                <h1>TraCare</h1>

            </div>
            <div data-role="content">
		<div data-role="content" data-theme="c">
                    <form name="form_register" id="form_register">
                        <p>First Name: <span class="error" id="error_first_name"></span><input type="text" name="first_name" id="first_name" /></p>
                        <p>Last Name: <span class="error" id="error_last_name"></span><input type="text" name="last_name" id="last_name" /></p>
                        <p>Gender: <span class="error" id="error_gender"></span><select name="gender" id="gender">
                                <option value="">Select Gender</option>
                                <option value="1">Male</option>
                                <option value="2">Female</option>
                            </select></p>
                        <p>Weight: <span class="error" id="error_weight"></span><input type="text" name="weight" id="weight" /></p>
                        <p>Height: <span class="error" id="error_height"></span><input type="text" name="height" id="height" /></p>
                        <p>Email Address: <span class="error" id="error_email"></span><input type="text" name="email" id="email" /></p>
                        <p>Password: <span class="error" id="error_password1"></span><input type="password" name="password1" id="password1" /></p>
                        <p>Confirm Password: <span class="error" id="error_password2"></span><input type="password" name="password2" id="password2" /></p>
                        <a href="" data-role="button" data-theme="b" id="btn_register">Register</a>       
                        <a href="index.jsp" data-role="button" data-theme="c" data-transition="flip" id="btn_cancel">Cancel</a> 
                    </form>
                </div>
            <div data-role="footer" data-position="fixed" data-tap-toggle="false">
                <h1>&nbsp;</h1>
            </div>
 
        </div>
    </body>
</html>
