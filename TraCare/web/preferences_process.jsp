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
    response.setHeader("Content-type", "application/json");

    Gson json = new Gson();
    
    String requestJSON = request.getParameter("json");
    
    PreferencesObject obj = json.fromJson(requestJSON, PreferencesObject.class);
    
    obj.setUserID(Integer.parseInt(session.getAttribute("userid").toString()));
    
    Preferences preferences = new Preferences(obj);
    
    ResultObject result = new ResultObject();

    result.setStatus(preferences.savePreferences());
    
    out.print(json.toJson(result));
%>
