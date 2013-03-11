<%@page import="TraCarePackage.ResultObject"%>
<%@page import="TraCarePackage.RegisterObject"%>
<%@page import="java.awt.Point"%>
<%@page import="TraCarePackage.Register" %>
<%@page import="com.google.gson.Gson" %>
<%@page language="java" %>
<%
    response.setHeader("Content-type", "application/json");
    
    Point testing = new Point(1, 2);
    Gson test = new Gson();
    
    String requestJSON = request.getParameter("json");
    
    RegisterObject obj = test.fromJson(requestJSON, RegisterObject.class);
    Register register = new Register(obj);
    
    ResultObject result = new ResultObject();

    result.setStatus(register.attemptRegistration());
    
    out.print(test.toJson(result));
%>
