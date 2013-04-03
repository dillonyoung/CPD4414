<%-- 
    Document   : preferences
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
        <script src="script/preferences.js"></script>
        <script src="script/support.js"></script>
        <link rel="stylesheet" href="./css/main.css" />
        <title>TraCare</title>

    </head>
    <body>
        <div id="status_message"></div>
        <div data-role="dialog" id="preferences" class="dialog-position">
            <div data-role="header" data-theme="b" data-position="fixed" data-tap-toggle="false">
                <h1>TraCare</h1>
            </div>
            <div data-role="content" class="dialog-settings">
                <div data-role="content" data-theme="c">
                    <form name="form_preferences" id="form_preferences">
                        <table width="100%">
                            <tr>
                                <td>Track Weight</td>
                                <td align="right">
                                    <select name="slideWeight" id="slideWeight" data-role="slider" data-mini="true">
                                        <option value="off">Off</option>
                                        <option value="on">On</option>
                                    </select>
                                </td>
                            </tr>

                            <tr>
                                <td>Track Sleep</td>
                                <td align="right">
                                    <select name="slideSleep" id="slideSleep" data-role="slider" data-mini="true">
                                        <option value="off">Off</option>
                                        <option value="on">On</option>
                                    </select>
                                </td>
                            </tr>

                            <tr>
                                <td>Track Blood Pressure</td>
                                <td align="right">
                                    <select name="slideBloodPressure" id="slideBloodPressure" data-role="slider" data-mini="true">
                                        <option value="off">Off</option>
                                        <option value="on">On</option>
                                    </select>
                                </td>
                            </tr>

                            <tr>
                                <td>Track Energy level</td>
                                <td align="right">
                                    <select name="slideEnergyLevel" id="slideEnergyLevel" data-role="slider" data-mini="true">
                                        <option value="off">Off</option>
                                        <option value="on">On</option>
                                    </select>
                                </td>
                            </tr>

                            <tr>
                                <td>Track Quality of Sleep</td>
                                <td align="right">
                                    <select name="slideQualityofSleep" id="slideQualityofSleep" data-role="slider" data-mini="true">
                                        <option value="off">Off</option>
                                        <option value="on">On</option>
                                    </select>
                                </td>
                            </tr>

                            <tr>
                                <td>Track Fitness</td>
                                <td align="right">
                                    <select name="slideFitness" id="slideFitness" data-role="slider" data-mini="true">
                                        <option value="off">Off</option>
                                        <option value="on">On</option>
                                    </select>
                                </td>
                            </tr>

                            <tr>
                                <td>Track Nutrition</td>
                                <td align="right">
                                    <select name="slideNutrition" id="slideNutrition" data-role="slider" data-mini="true">
                                        <option value="off">Off</option>
                                        <option value="on">On</option>
                                    </select>
                                </td>
                            </tr>

                            <tr>
                                <td>Track Location</td>
                                <td align="right">
                                    <select name="slideLocation" id="slildeLocation" data-role="slider" data-mini="true">
                                        <option value="off">Off</option>
                                        <option value="on">On</option>
                                    </select>
                                </td>
                            </tr>
                        </table>

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
