<%-- 
    Document   : preferences
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
        <script src="script/preferences.js"></script>
        <script src="script/support.js"></script>
        <link rel="stylesheet" href="./css/main.css" />
        <title>TraCare</title>

    </head>
    <body>
        <%
            // Create a new preferences object instance
            Preferences pref = new Preferences();
            
            // Load the user preferences
            PreferencesObject obj = pref.loadPreferences(Integer.parseInt(session.getAttribute("userid").toString()));
        %>
        <div id="status_message"></div>
        <div data-role="page" id="preferences">
            <%@include file="header.jsp" %>
            <div data-role="content">

                <form name="form_preferences" id="form_preferences">
                    <table width="100%">
                        <tr>
                            <td colspan="2">
                                <h2>Track Entry</h2>
                            </td>
                        </tr>
                        <tr>
                            <td>Track Weight</td>
                            <td align="right">
                                <select name="slideWeight" id="slideWeight" data-role="slider" data-mini="true">
                                    <option value="false" <% if (!obj.isTrackWeight()) {
                                                out.print("selected=\"selected\"");
                                            }%>>Off</option>
                                    <option value="true" <% if (obj.isTrackWeight()) {
                                                out.print("selected=\"selected\"");
                                            }%>>On</option>
                                </select>
                            </td>
                        </tr>

                        <tr>
                            <td>Track Sleep</td>
                            <td align="right">
                                <select name="slideSleep" id="slideSleep" data-role="slider" data-mini="true">
                                    <option value="false" <% if (!obj.isTrackSleep()) {
                                                out.print("selected=\"selected\"");
                                            }%>>Off</option>
                                    <option value="true" <% if (obj.isTrackSleep()) {
                                                out.print("selected=\"selected\"");
                                            }%>>On</option>
                                </select>
                            </td>
                        </tr>

                        <tr>
                            <td>Track Energy Level</td>
                            <td align="right">
                                <select name="slideEnergyLevel" id="slideEnergyLevel" data-role="slider" data-mini="true">
                                    <option value="false" <% if (!obj.isTrackEnergyLevel()) {
                                                out.print("selected=\"selected\"");
                                            }%>>Off</option>
                                    <option value="true" <% if (obj.isTrackEnergyLevel()) {
                                                out.print("selected=\"selected\"");
                                            }%>>On</option>
                                </select>
                            </td>
                        </tr>

                        <tr>
                            <td>Track Quality of Sleep</td>
                            <td align="right">
                                <select name="slideQualityofSleep" id="slideQualityofSleep" data-role="slider" data-mini="true">
                                    <option value="false" <% if (!obj.isTrackQualityofSleep()) {
                                                out.print("selected=\"selected\"");
                                            }%>>Off</option>
                                    <option value="true" <% if (obj.isTrackQualityofSleep()) {
                                                out.print("selected=\"selected\"");
                                            }%>>On</option>
                                </select>
                            </td>
                        </tr>

                        <tr>
                            <td>Track Fitness</td>
                            <td align="right">
                                <select name="slideFitness" id="slideFitness" data-role="slider" data-mini="true">
                                    <option value="false" <% if (!obj.isTrackFitness()) {
                                                out.print("selected=\"selected\"");
                                            }%>>Off</option>
                                    <option value="true" <% if (obj.isTrackFitness()) {
                                                out.print("selected=\"selected\"");
                                            }%>>On</option>
                                </select>
                            </td>
                        </tr>

                        <tr>
                            <td>Track Nutrition</td>
                            <td align="right">
                                <select name="slideNutrition" id="slideNutrition" data-role="slider" data-mini="true">
                                    <option value="false" <% if (!obj.isTrackNutrition()) {
                                                out.print("selected=\"selected\"");
                                            }%>>Off</option>
                                    <option value="true" <% if (obj.isTrackNutrition()) {
                                                out.print("selected=\"selected\"");
                                            }%>>On</option>
                                </select>
                            </td>
                        </tr>

                        <tr>
                            <td>Track Symptom</td>
                            <td align="right">
                                <select name="slideSymptom" id="slideSymptom" data-role="slider" data-mini="true">
                                    <option value="false" <% if (!obj.isTrackSymptom()) {
                                                out.print("selected=\"selected\"");
                                            }%>>Off</option>
                                    <option value="true" <% if (obj.isTrackSymptom()) {
                                                out.print("selected=\"selected\"");
                                            }%>>On</option>
                                </select>
                            </td>
                        </tr>

                        <tr>
                            <td>Track Location</td>
                            <td align="right">
                                <select name="slideLocation" id="slideLocation" data-role="slider" data-mini="true">
                                    <option value="false" <% if (!obj.isTrackLocation()) {
                                                out.print("selected=\"selected\"");
                                            }%>>Off</option>
                                    <option value="true" <% if (obj.isTrackLocation()) {
                                                out.print("selected=\"selected\"");
                                            }%>>On</option>
                                </select>
                            </td>
                        </tr>

                    </table>

                    <a href="" data-role="button" data-theme="b" id="btn_save">Save Preferences</a>       
                </form>

            </div>
            <%@include file="footer.jsp" %>
        </div>

    </body>
</html>
