<%-- 
    Document   : login_status
    Created on : 6-Apr-2013, 4:49:03 PM
    Author     : Dillon
--%>
<%@page import="TraCarePackage.LoginStatus"%>
<%@page import="com.google.gson.Gson"%>
<%
    response.setHeader("Content-type", "application/json");

    Gson json = new Gson();

    String requestJSON = request.getParameter("json");

    LoginStatus login = new LoginStatus();
    if (session.getAttribute("firstname") == null) {
        login.setFirstname("");
        login.setStatus(-1);
        login.setUserId(-1);
    } else {
        login.setFirstname(session.getAttribute("firstname").toString());
        login.setUserId(Integer.parseInt(session.getAttribute("userid").toString()));

        if (session.getAttribute("firstname").equals("")) {
            login.setStatus(0);
        } else {
            login.setStatus(1);
        }
    }

    out.print(json.toJson(login));
%>
