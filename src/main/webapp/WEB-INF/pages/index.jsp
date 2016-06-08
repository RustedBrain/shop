<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>Hand-made store</title>
    <link href="./style/styles.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<header>
        <img src="./style/title_main.png" alt=""/>
</header>


    <h3>Hand-Made store</h3>
    <iframe name="Auth" width="95%" height="50%">

    </iframe>
    <br>
    <iframe name="User" src="/userDetail.jsp" width="95%" height="20%">
    </iframe>
    <br>
    <iframe name="Scheta" src="" width="820" height="200">
    </iframe>
    <br><br>

    <br>
Добро пожаловать! Сегодня <%= getFormattedDate () %>

    <h1>Maven + Spring MVC Web Project Example</h1>

    <h2>Message : ${message}</h2>
    <h2>Counter : ${counter}</h2>

</body>
</html>

<%!
    String getFormattedDate ()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        return sdf.format (new Date());
    }
%>