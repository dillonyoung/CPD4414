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
        <script src="script/main.js"></script>
        <link rel="stylesheet" href="./css/main.css" />
        <title>TraCare</title>

    </head>
    <body>
        <div id="status_message"></div>
        <div data-role="page" id="main">
            <%@include file="header.jsp" %>
            <div data-role="content">

            </div>
            <%@include file="footer.jsp" %>
        </div>

    </body>
</html>
