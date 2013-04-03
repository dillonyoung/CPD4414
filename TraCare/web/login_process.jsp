<%@page import="TraCarePackage.Login"%>
<%@page import="TraCarePackage.LoginObject"%>
<%@page import="TraCarePackage.ResultObject"%>
<%@page import="TraCarePackage.LoginObject"%>
<%@page import="java.awt.Point"%>
<%@page import="TraCarePackage.Register" %>
<%@page import="com.google.gson.Gson" %>
<%@page language="java" %>
<%
    response.setHeader("Content-type", "application/json");
    
    Gson json = new Gson();
    
    String requestJSON = request.getParameter("json");
    
    LoginObject obj = json.fromJson(requestJSON, LoginObject.class);
    Login login = new Login(obj);
    
    ResultObject result = new ResultObject();

    result = login.attemptLogin();
    
    if (result.getStatus() == 0) {
        session.setAttribute("firstname", result.getFirstName());
        session.setAttribute("userid", result.getUserId());
    }
    
    out.print(json.toJson(result));
%>