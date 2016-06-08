<%--
  Created by IntelliJ IDEA.
  User: Anastasiia
  Date: 07.06.2016
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Create Person</title></head>
<body bgcolor="cyan">
<h1>Enter your details</h1>
<form action="display.jsp" method="post">
  <table>
    <tr><td>First name:</td>
      <td><input type="text" name="firstName" /></td>
    </tr>
    <tr><td>Last name:</td>
      <td><input type="text" name="lastName" /></td>
    </tr>
    <tr><td>Email-id:</td>
      <td><input type="text" name="email" /></td>
    </tr>
    <tr><td>Place of Birth:</td>
      <td><input type="text" name="Placeofbirth" /></td>
    </tr>
    <tr><td>Contact No:</td>
      <td><input type="text" name="cono" /></td>
    </tr>
    <tr><td>Age:</td>
      <td><input type="text" name="age" /></td>
    </tr>
  </table>
  <input type="submit" value="Submit details" />
</form>
</body>
</html>