<%-- 
    Document   : delete_process
    Created on : 7-Apr-2013, 10:12:57 AM
    Author     : Dillon
--%>

<%@page import="TraCarePackage.Entry"%>
<%@page import="TraCarePackage.ResultObject"%>
<%@page import="TraCarePackage.EntryObject"%>
<%@page import="com.google.gson.Gson"%>
<%
    response.setHeader("Content-type", "application/json");

    Gson json = new Gson();
    
    String requestJSON = request.getParameter("json");
    
    ResultObject obj = json.fromJson(requestJSON, ResultObject.class);

    obj.setUserId(Integer.parseInt(session.getAttribute("userid").toString()));
    
    Entry entry = new Entry();
    
    ResultObject result = new ResultObject();

    result.setStatus(entry.deleteEntry(obj.getStatus()));
    
    out.print(json.toJson(result));
%>
