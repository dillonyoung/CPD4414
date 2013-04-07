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
    response.setHeader("Content-type", "application/json");

    Gson json = new Gson();
    
    String requestJSON = request.getParameter("json");
    
    EntryObject obj = json.fromJson(requestJSON, EntryObject.class);

    obj.setUserid(Integer.parseInt(session.getAttribute("userid").toString()));
    
    Entry entry = new Entry(obj);
    
    ResultObject result = new ResultObject();

    result.setStatus(entry.saveEntry());
    
    out.print(json.toJson(result));
%>
