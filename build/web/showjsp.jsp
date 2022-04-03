<%-- 
    Document   : showjsp
    Created on : 25-Mar-2022, 6:39:44 PM
    Author     : Vishal
--%>

<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Departmenttb"%>
<%@page import="ejb.DataModelLocal" %>
<%@page import="javax.naming.InitialContext" %>
<%@page import="javax.naming.Context" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%!
    DataModelLocal dml=null;
    public void jspInit()
    {
        try {
                InitialContext ic = new InitialContext();
                dml=(DataModelLocal)ic.lookup("java:global/EmployeeApplication/DataModel");
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    public void jspDestroy()
    {
        dml=null;
    }
%>
        <h1>DepartmentData</h1>
        <table border="1">
            <%
                Collection<Departmenttb> dept=dml.getAllDepartment();
                for (Departmenttb object : dept) {
                        out.println("<tr><td>"+object.getDeptid()+"</td><td>"+object.getDeptname()+"</td></tr>");
                    }
            %>
        </table>
    </body>
</html>
