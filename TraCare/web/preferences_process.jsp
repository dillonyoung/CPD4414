<%-- 
    Document   : preferences_process
    Created on : 6-Apr-2013, 6:24:29 PM
    Author     : Dillon
--%>

<%@page import="TraCarePackage.ResultObject"%>
<%@page import="TraCarePackage.Preferences"%>
<%@page import="TraCarePackage.PreferencesObject"%>
<%@page import="com.google.gson.Gson"%>
<%
    // Set the reponse type to JSON
    response.setHeader("Content-type", "application/json");

    // Create a new instance of the Google JSON library
    Gson json = new Gson();
    
    // Get the JSON request string
    String requestJSON = request.getParameter("json");
    
    // Convert the JSON string into an object
    PreferencesObject obj = json.fromJson(requestJSON, PreferencesObject.class);
    
    // Set the user ID for the object based on the session value
    obj.setUserID(Integer.parseInt(session.getAttribute("userid").toString()));
    
    // Create a new preferences instance
    Preferences preferences = new Preferences(obj);
    
    // Create a new result object instance
    ResultObject result = new ResultObject();

    // Attempt to save the preferences
    result.setStatus(preferences.savePreferences());
    
    // Output the results as a JSON string
    out.print(json.toJson(result));
%>
