<%-- 
    Document   : login_status
    Created on : 6-Apr-2013, 4:49:03 PM
    Author     : Dillon
--%>

<%@page import="TraCarePackage.LoginStatus"%>
<%@page import="com.google.gson.Gson"%>
<%
    // Set the response type to JSON
    response.setHeader("Content-type", "application/json");

    // Create a new instance of the Google JSON library
    Gson json = new Gson();

    // Convert the JSON string into an object
    String requestJSON = request.getParameter("json");

    // Create a new login status instance
    LoginStatus login = new LoginStatus();
    
    // Check to see if the session contains user information
    if (session.getAttribute("firstname") == null) {
        
        // Clear the login user information
        login.setFirstname("");
        login.setStatus(-1);
        login.setUserId(-1);
    } else {
        
        // Update the login user information
        login.setFirstname(session.getAttribute("firstname").toString());
        login.setUserId(Integer.parseInt(session.getAttribute("userid").toString()));

        // Check the login status
        if (session.getAttribute("firstname").equals("")) {
            login.setStatus(0);
        } else {
            login.setStatus(1);
        }
    }

    // Output the results as a JSON string
    out.print(json.toJson(login));
%>
