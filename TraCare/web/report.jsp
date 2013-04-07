<%-- 
    Document   : report
    Created on : 9-Mar-2013, 5:04:33 PM
    Author     : Dillon
--%>

<%@page import="TraCarePackage.Report"%>
<%@page import="TraCarePackage.ReportObject"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Date"%>
<%@page import="TraCarePackage.PreferencesObject"%>
<%@page import="TraCarePackage.Preferences"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.0/jquery.mobile-1.3.0.min.css" />
        <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
        <script src="http://code.jquery.com/mobile/1.3.0/jquery.mobile-1.3.0.min.js"></script>
        <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDlBGZszz5_k6aF5rP03rYZfgRm-PmBAWc&sensor=true"></script>
        <script src="script/summary.js"></script>
        <script src="script/support.js"></script>
        <link rel="stylesheet" href="./css/main.css" />
        <title>TraCare</title>

    </head>
    <body>
        <div id="status_message"></div>
        <div data-role="page" id="newentry">
            <%@include file="header.jsp" %>
            <div data-role="content">
                <%
                DateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
                Date startDate = df.parse(request.getParameter("start"));
                Date endDate = df.parse(request.getParameter("end"));
                String displayStart = new SimpleDateFormat("MMMMM d, yyyy").format(startDate);
                String displayEnd = new SimpleDateFormat("MMMMM d, yyyy").format(endDate);
                Report report = new Report();
                ReportObject obj = report.runReport(startDate, endDate, Integer.parseInt(session.getAttribute("userid").toString()));
                
                String lowestDate = new SimpleDateFormat("MMMMM d, yyyy").format(obj.getLowestDate());
                String highestDate = new SimpleDateFormat("MMMMM d, yyyy").format(obj.getHighestDate());
                %>
                <p class="heading">Start Date:</p>
                <p><% out.write(displayStart); %></p>
                <p class="heading">End Date:</p>
                <p><% out.write(displayEnd); %></p>
                <p class="heading">Lowest Weight Date:</p>
                <p><% out.write(lowestDate); %></p>
                
                <p class="heading">Highest Weight Date:</p>
                <p><% out.write(highestDate); %></p>
                <a href="summary.jsp" rel="external" data-role="button" data-theme="c" id="btn_cancel">Back</a> 

            </div>
            <%@include file="footer.jsp" %>
        </div>

    </body>
</html>
