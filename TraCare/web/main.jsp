<%-- 
    Document   : main
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
        <script src="script/script.js"></script>
        <link rel="stylesheet" href="./css/main.css" />
        <title>TraCare</title>

    </head>
    <body>
        <div data-role="page" id="main">
            <div data-role="header" data-theme="b" data-position="fixed" data-tap-toggle="false">
                <h1>TraCare</h1>
                <a href="#" data-icon="grid" id="btn_logout" class="ui-btn-right">Logout</a>
            </div>
            <div data-role="content">

            </div>
            <div data-role="footer" data-position="fixed" data-tap-toggle="false">
                <div data-role="controlgroup" class="footer-center" data-type="horizontal">
                <a href="newentry.jsp" data-rel="dialog" data-role="button" data-iconpos="top" data-icon="info" class="footer-button">Add Entry</a> 
                <a href="newentry.jsp" data-rel="dialog" data-role="button" data-iconpos="top" data-icon="info" class="footer-button">Entry List</a> 
                <a href="newentry.jsp" data-rel="dialog" data-role="button" data-iconpos="top" data-icon="info" class="footer-button">Map</a> 
                <a href="newentry.jsp" data-rel="dialog" data-role="button" data-iconpos="top" data-icon="info" class="footer-button">Summary</a> 

                <a href="preferences.jsp" data-rel="dialog" data-role="button" data-iconpos="top" data-icon="info" class="footer-button">Preferences</a> 
                </div>
            </div>
        </div>

    </body>
</html>
