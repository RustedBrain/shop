<%--
  Created by IntelliJ IDEA.
  User: Anastasiia
  Date: 07.06.2016
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@page import="lab4.Klient"%>
<%@page import="lab5.TableWorker"%>
<%@page import="java.util.Collection"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Klients list</title>
</head>
<body>
<%
  Collection<Klient> listObj = TableWorker.getAllKlients();
  pageContext.setAttribute("listObj", listObj);
%>
<font color = "blue" size = 5 >Klients list</font>

<table border=1>
  <tr>
    <td width="10%"><div align=center><b>FIO</b></div></td>
    <td width="10%"><div align=center><b>ID</b></div></td>
    <td width="20%"><div align=center><b>Adres</b></div></td>
    <td width="10%"><div align=center><b>Telefon</b></div></td>
  </tr>
  <%
    for(Klient kl : listObj){
  %>
  <tr>
    <td><% out.println(kl.getFio()); %></td>
    <td><% out.println(kl.getLicevoiSchet()); %></td>
    <td><% out.println(kl.getAdres()); %></td>
    <td><% out.println(kl.getTelefon()); %></td>
  </tr>
  <%}%>

  <c:set var="testing" value="blah"/>
  <c:out value="${testing}"/>

</table>
</body>
</html>