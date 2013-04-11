<%-- 
    Document   : newentry
    Created on : 9-Mar-2013, 5:04:33 PM
    Author     : Dillon
--%>

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
        <%
            Preferences pref = new Preferences();
            PreferencesObject obj = pref.loadPreferences(Integer.parseInt(session.getAttribute("userid").toString()));
        %>
        <div id="status_message"></div>
        <div data-role="page" id="newentry">
            <%@include file="header.jsp" %>
            <div data-role="content">
                <h2>New Entry</h2>
                <% if (obj.isTrackWeight()) { %>
                <p class="heading">Weight: (Weight in Pounds) <span class="error" id="error_weight"></span><input type="number" min="0" max="300" name="weight" id="weight" /></p>
                <% } %>
                <% if (obj.isTrackSleep()) { %>
                <p class="heading">Sleep: (Number of Hours Slept) <span class="error" id="error_sleep"></span><input type="number" min="0" max="24" name="sleep" id="sleep" /></p>
                <% } %>
                <% if (obj.isTrackEnergyLevel()) { %>
                <p class="heading">Energy Level: <span class="error" id="error_energy_level"></span>
                    <select name="energy_level" id="energy_level">
                        <option value="0">Not Specified</option>
                        <option value="1">Terrible</option>
                        <option value="2">Poor</option>
                        <option value="3">Average</option>
                        <option value="4">Good</option>
                        <option value="5">Excellent</option>
                    </select>    
                </p>
                <% } %>
                <% if (obj.isTrackQualityofSleep()) { %>
                <p class="heading">Quality of Sleep: <span class="error" id="error_quality_of_sleep"></span>
                    <select name="quality_of_sleep" id="quality_of_sleep">
                        <option value="0">Not Specified</option>
                        <option value="1">Terrible</option>
                        <option value="2">Poor</option>
                        <option value="3">Average</option>
                        <option value="4">Good</option>
                        <option value="5">Excellent</option>
                    </select>    
                </p>
                <% } %>
                <% if (obj.isTrackFitness()) { %>
                <p class="heading">Fitness Activity: <span class="error" id="error_fitness"></span>
                    <textarea name="fitness" id="fitness"></textarea>
                </p>
                <% } %>
                <% if (obj.isTrackNutrition()) { %>
                <p class="heading">Nutrition: <span class="error" id="error_nutrition"></span>
                    <textarea name="nutrition" id="nutrition"></textarea>
                </p>
                <% } %>
                <% if (obj.isTrackSymptom()) { %>
                <p class="heading">Symptom: <span class="error" id="error_symptom"></span>
                    <select name="symptom" id="symptom">
                        <option value="0">Not Specified</option>
                        <option value="1">Other</option>
                        <option value="2">Abdominal Pain</option>
                        <option value="3">Chest Pain</option>
                        <option value="4">Constipation</option>
                        <option value="5">Cought</option>
                        <option value="6">Diarrea</option>
                        <option value="7">Dizziness</option>
                        <option value="8">Eye Discomfort</option>
                        <option value="9">Foot Pain</option>
                        <option value="10">Headaches</option>
                        <option value="11">Hip Pain</option>
                        <option value="12">Knee Pain</option>
                        <option value="13">Low Back Pain</option>
                        <option value="14">Nasal Congestion</option>
                        <option value="15">Nausea</option>
                        <option value="16">Neck Pain</option>
                        <option value="17">Numbness</option>
                        <option value="18">Shortness of Breath</option>
                        <option value="19">Shoulder Pain</option>
                        <option value="20">Sore Throat</option>
                        <option value="21">Vision Problems</option>
                        <option value="22">Wheezing</option>
                    </select>
                    <textarea name="symptom_description" id="symptom_description"></textarea>
                </p>
                <% } %>
                <% if (obj.isTrackLocation()) { %>
                <p class="heading">Location: <span class="error" id="error_location"></span><br /><img id="map-canvas" /></p>
                <% } %>
                <input type="hidden" name="latitude" id="latitude" />
                <input type="hidden" name="longitude" id="longitude" />
                <a href="" data-role="button" data-theme="b" id="btn_addentry">Add Entry</a>       
                <a href="entrylist.jsp" rel="external" data-role="button" data-theme="c" id="btn_cancel">Cancel</a> 


            </div>
            <%@include file="footer.jsp" %>
        </div>

    </body>
</html>
