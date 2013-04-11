<%@page import="TraCarePackage.ResultObject"%>
<%@page import="TraCarePackage.RegisterObject"%>
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
    RegisterObject obj = json.fromJson(requestJSON, RegisterObject.class);
    
    // Create a new register object instance
    Register register = new Register(obj);
    
    // Create a new result object instance
    ResultObject result = new ResultObject();

    // Attempt to register the new user
    result.setStatus(register.attemptRegistration());
    
    // Output the results as a JSON string
    out.print(json.toJson(result));
%>
