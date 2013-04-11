<%-- 
    Document   : login_process
    Created on : 7-Apr-2013, 10:12:57 AM
    Author     : Dillon Young (C0005790)
--%>

<%@page import="TraCarePackage.Login"%>
<%@page import="TraCarePackage.LoginObject"%>
<%@page import="TraCarePackage.ResultObject"%>
<%@page import="TraCarePackage.LoginObject"%>
<%@page import="java.awt.Point"%>
<%@page import="TraCarePackage.Register" %>
<%@page import="com.google.gson.Gson" %>
<%@page language="java" %>
<%
    // Set the reponse type to JSON
    response.setHeader("Content-type", "application/json");

    // Create a new instance of the Google JSON library
    Gson json = new Gson();
    
    // Get the JSON request string
    String requestJSON = request.getParameter("json");
    
    // Convert the JSON string into an object
    LoginObject obj = json.fromJson(requestJSON, LoginObject.class);
    
    // Create a new login object instance
    Login login = new Login(obj);
    
    // Create a new result object instance
    ResultObject result = new ResultObject();

    // Attempt to login to the application
    result = login.attemptLogin();
    
    // If the login was successful update the session
    if (result.getStatus() == 0) {
        session.setAttribute("firstname", result.getFirstName());
        session.setAttribute("userid", result.getUserId());
    }
    
    // Output the results as a JSON string
    out.print(json.toJson(result));
%>