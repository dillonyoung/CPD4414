<%-- 
    Document   : newentry_process
    Created on : 7-Apr-2013, 10:12:57 AM
    Author     : Dillon
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
    EntryObject obj = json.fromJson(requestJSON, EntryObject.class);

    // Set the user ID for the object based on the session value
    obj.setUserid(Integer.parseInt(session.getAttribute("userid").toString()));
    
    // Create a new entry object instance
    Entry entry = new Entry(obj);
    
    // Create a new result object instance
    ResultObject result = new ResultObject();

    // Attempt to save the new entry to the database
    result.setStatus(entry.saveEntry());
    
    // Output the results as a JSON string
    out.print(json.toJson(result));
%>
