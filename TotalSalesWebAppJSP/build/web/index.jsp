<%-- 
    Document   : index
    Created on : Nov 6, 2014, 3:33:43 PM
    Author     : Jacob
--%>
<%--
-- Jacob Kapusta C14 --
-- COSC 3380 FALL 2014 --
-- This is MY work --
-- Will NOT disseminate --
--%>

<%@ page import = "java.sql.*"%>
<%@ page import = "java.io.*"%>
<%  Class.forName("oracle.jdbc.driver.OracleDriver");%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Total Sales</title>
    </head>
    <body>
        <h1>Total Sales</h1>
        <%
            Connection connection = DriverManager.getConnection("");

            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("select sum(OL_Price) from Order_Line");
        %>
        <TABLE BORDER="1" BGCOLOR="CCFFFF" width='50%' cellspacing='1' cellpadding='0'   bordercolor="black" border='1'>
            <TR>
                <TH bgcolor='#DAA520'> <font size='2'/>Website Total Sales</TH>
            </TR>

            <% while (resultset.next()) {%>
            <TR>
                <TD> <font size='2'/><center><%= resultset.getString(1)%></center></TD>
            </TR>

            <% }%>

        </TABLE>
    </body>
</html>
