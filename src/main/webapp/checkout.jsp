<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="css/view_style.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<div id="content" class="float_r">
    <h2>Checkout</h2>
    <h5><strong>BILLING DETAILS</strong></h5>
    <div class="content_half float_l checkout">
        Enter your full name:
        <input type="text" style="width:300px;"/>
        Address:
        <input type="text" style="width:300px;"/>
        City:
        <input type="text" style="width:300px;"/>
        <br>
        N of post department:
        <input type="text" style="width:300px;"/>
    </div>

    <div class="content_half float_r checkout">
        Email:
        <input type="text" style="width:300px;"/>
        Phone:<br/>
        <span style="font-size:10px">Please, specify your phone number. YOU MAY BE GIVEN A CALL TO VERIFY AND COMPLETE THE ORDER.</span>
        <input type="text" style="width:300px;"/>
    </div>

    <div class="cleaner h20"></div>

    <h3>Shopping Cart</h3>
    <c:set var="total" value="${0}"/>
    <c:forEach var="elem" items="${products}" varStatus="status">
        <tr>
            <td><c:out value="${ elem.name }"/></td>
            <td><c:out value="${ elem.style }"/></td>
            <td><c:out value="${ elem.description }"/></td>
            <td><c:out value="${ elem.discount }"/></td>
            <td><c:out value="${ elem.male }"/></td>
            <td><c:out value="${ elem.weight }"/></td>
            <td><p class="product_price">$<c:out value="${elem.price}"/></p></td>
            <td>
                    <form action="${pageContext.request.contextPath}/AppServlet" method="post">
                        <input type="hidden" name="mainAction" value="getBucket">
                        <input type="hidden" name="subAction" value="deleteItem">
                        <input type="hidden" name="itemCategory" value=${ elem.category }>
                        <input type="hidden" name="itemId" value=${ elem.id }>
                        <input type="submit" value="Delete"/>
                    </form>
            </td>
        </tr>
        <c:set var="total" value="${total + elem.price}" />
    </c:forEach>
    <br><br><br><br>
    <h4>TOTAL: <strong><c:out value="${ total }"/></strong></h4>

    <p><input type="checkbox"/>I have accepted the Terms of Use.</p><br/>

    <p><input type="submit" value="MAKE ORDER"
              style="font-size:12pt;color:white; background-color:#000033;border:2px solid #000033;padding:3px;"></p>
</div>

<div class="cleaner"></div>

</body>
</html>