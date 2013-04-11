<%-- 
    Document   : entrylist
    Created on : 9-Mar-2013, 5:04:33 PM
    Author     : Dillon Young (C0005790)
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="TraCarePackage.EntryObject"%>
<%@page import="java.util.ArrayList"%>
<%@page import="TraCarePackage.Entry"%>
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
        <script src="script/newentry.js"></script>
        <script src="script/support.js"></script>
        <link rel="stylesheet" href="./css/main.css" />
        <title>TraCare</title>

    </head>
    <body>
        <div id="status_message"></div>
        <div data-role="page" id="entrylist">
            <%@include file="header.jsp" %>
            <div data-role="content">
                <ul data-role="listview">
                <%
                    // Check to see if the session is not valid
                    if (session.getAttribute("userid") == null) {

                        // Redirect the user to the main page
                        response.setStatus(response.SC_MOVED_TEMPORARILY);
                        response.setHeader("Location", "index.jsp");
                    } else {
                        
                        // Create a entry object instance
                        Entry entry = new Entry();

                        // Load the entries for the current user from the database
                        ArrayList<EntryObject> entries = entry.loadEntries(Integer.parseInt(session.getAttribute("userid").toString()));

                        // Loop through the entries and add an entry to the display list
                        for (int i = 0; i < entries.size(); i++) {
                            String entrydate = new SimpleDateFormat("MMMMM d, yyyy HH:mm:ss aa").format(entries.get(i).getDatetime());
                            out.write("<li><a href='viewentry.jsp?id=" + entries.get(i).getId() + "' rel='external'>" + entrydate + "</a></li>");
                        }

                        // Check to see if the entries list is blank and display a message to the user
                        if (entries.size() == 0) {
                            out.write("<li>No entries are currently available</li>");
                        }
                    }
                %>
                </ul>
            </div>
            <%@include file="footer.jsp" %>
        </div>

    </body>
</html>
