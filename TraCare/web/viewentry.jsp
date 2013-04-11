<%-- 
    Document   : viewentry
    Created on : 9-Mar-2013, 5:04:33 PM
    Author     : Dillon
--%>

<%@page import="java.text.DecimalFormat"%>
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
        <script src="script/viewentry.js"></script>
        <script src="script/support.js"></script>
        <link rel="stylesheet" href="./css/main.css" />
        <title>TraCare</title>

    </head>
    <body>
        <div id="status_message"></div>
        <div data-role="page" id="entrylist">
            <%@include file="header.jsp" %>
            <div data-role="content">
                <h2>View Entry</h2>
                <%
                    // Create a new entry instance
                    Entry entry = new Entry();

                    // Load the entry details
                    EntryObject obj = entry.loadEntry(Integer.parseInt(session.getAttribute("userid").toString()), Integer.parseInt(request.getParameter("id")));

                    // Create the decimal formatter instance
                    DecimalFormat df = new DecimalFormat("###.00");
                %>

                <% if (obj.getWeight() != -1) { %>
                <p class="heading">Weight: (Weight in Pounds)</p>
                <p><% out.write(df.format(obj.getWeight()) + " Lbs"); %></p>
                <% } %>
                <% if (obj.getSleep() != -1) { %>
                <p class="heading">Sleep: (Number of Hours Slept)</p>
                <p><% out.write(df.format(obj.getSleep()) + " Hours"); %></p>
                <% } %>
                <% if (obj.getEnergylevel() != -1) { %>
                <p class="heading">Energy Level:</p>
                <p>
                    <% 
                    switch(obj.getEnergylevel()) {
                        case 0:
                            out.write("Not Specified");
                            break;
                        case 1:
                            out.write("Terrible");
                            break;
                        case 2:
                            out.write("Poor");
                            break;
                        case 3:
                            out.write("Average");
                            break;
                        case 4:
                            out.write("Good");
                            break;
                        case 5:
                            out.write("Excellent");
                            break;
                    }
                    %>
                </p>
                <% } %>
                <% if (obj.getQualityofsleep() != -1) { %>
                <p class="heading">Quality of Sleep:</p>
                <p>
                    <% 
                    switch(obj.getQualityofsleep()) {
                        case 0:
                            out.write("Not Specified");
                            break;
                        case 1:
                            out.write("Terrible");
                            break;
                        case 2:
                            out.write("Poor");
                            break;
                        case 3:
                            out.write("Average");
                            break;
                        case 4:
                            out.write("Good");
                            break;
                        case 5:
                            out.write("Excellent");
                            break;
                    }
                    %>
                </p>
                <% } %>
                <% if (obj.getFitness() != "<{[blank]}>") { %>
                <p class="heading">Fitness Activity:</p>
                <p><% out.write(obj.getFitness()); %></p>
                <% } %>
                <% if (obj.getNutrition() != "<{[blank]}>") { %>
                <p class="heading">Nutrition:</p>
                <p><% out.write(obj.getNutrition()); %></p>
                <% } %>
                <% if (obj.getSymptom() != -1) { %>
                <p class="heading">Symptom Type:</p>
                <p>
                    <% 
                    switch(obj.getSymptom()) {
                        case 0:
                            out.write("Not Specified");
                            break;
                        case 1:
                            out.write("Other");
                            break;
                        case 2:
                            out.write("Abdominal Pain");
                            break;
                        case 3:
                            out.write("Chest Pain");
                            break;
                        case 4:
                            out.write("Constipation");
                            break;
                        case 5:
                            out.write("Cought");
                            break;
                        case 6:
                            out.write("Diarrea");
                            break;
                        case 7:
                            out.write("Dizziness");
                            break;
                        case 8:
                            out.write("Eye Discomfort");
                            break;
                        case 9:
                            out.write("Foot Pain");
                            break;
                        case 10:
                            out.write("Headaches");
                            break;
                        case 11:
                            out.write("Hip Pain");
                            break;
                        case 12:
                            out.write("Knee Pain");
                            break;
                        case 13:
                            out.write("Low Back Pain");
                            break;
                        case 14:
                            out.write("Nasal Congestion");
                            break;
                        case 15:
                            out.write("Nausea");
                            break;
                        case 16:
                            out.write("Neck Pain");
                            break;
                        case 17:
                            out.write("Numbness");
                            break;
                        case 18:
                            out.write("Shortness of Breath");
                            break;
                        case 19:
                            out.write("Shoulder Pain");
                            break;
                        case 20:
                            out.write("Sore Throat");
                            break;
                        case 21:
                            out.write("Vision Problems");
                            break;
                        case 22:
                            out.write("Wheezing");
                            break;
                    }
                    %>
                </p>
                <% } %>
                <% if (obj.getSymptomdescription() != "<{[blank]}>") { %>
                <p class="heading">Symptom Description:</p>
                <p><% out.write(obj.getSymptomdescription()); %></p>
                <% } %>
                <% if (obj.getLatitude() != 0 && obj.getLongitude() != 0) { %>
                <p class="heading">Location:</p>
                <p><img id="map-canvas" /></p>
                <input type="hidden" name="latitude" id="latitude" value="<% out.write(String.format("%f", obj.getLatitude())); %>" />
                <input type="hidden" name="longitude" id="longitude" value="<% out.write(String.format("%f", obj.getLongitude())); %>" />
                <% } %>
                <a href="" data-role="button" data-theme="b" id="btn_deleteentry">Delete Entry</a>       
                <a href="entrylist.jsp" rel="external" data-role="button" data-theme="c" id="btn_cancel">Return to Entry List</a> 
                <input type="hidden" name="pageid" id="pageid" value="<% out.write(request.getParameter("id")); %>" />
            </div>
            <%@include file="footer.jsp" %>
        </div>

    </body>
</html>
