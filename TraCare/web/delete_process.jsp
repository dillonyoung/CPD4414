<%-- 
    Document   : delete_process
    Created on : 7-Apr-2013, 10:12:57 AM
    Author     : Dillon Young (C0005790)
--%>

<%@page import="TraCarePackage.Entry"%>
<%@page import="TraCarePackage.ResultObject"%>
<%@page import="TraCarePackage.EntryObject"%>
<%@page import="com.google.gson.Gson"%>
<%
    // Set the reponse type to JSON
    response.setHeader("Content-type", "application/json");

    // Create a new instance of the Google JSON library
    Gson json = new Gson();
    
    // Get the JSON request string
    String requestJSON = request.getParameter("json");
    
    // Convert the JSON string into an object
    ResultObject obj = json.fromJson(requestJSON, ResultObject.class);

    // Set the user ID for the object based on the session value
    obj.setUserId(Integer.parseInt(session.getAttribute("userid").toString()));
    
    // Create a new entry object instance
    Entry entry = new Entry();
    
    // Create a new result object instance
    ResultObject result = new ResultObject();

    // Attempt to delete the selected entry from the database
    result.setStatus(entry.deleteEntry(obj.getStatus()));
    
    // Output the results as a JSON string
    out.print(json.toJson(result));
%>
