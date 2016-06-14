<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="css/view_style.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<div id="content" class="float_r">
    <h1>Braslets</h1>
    <div class="product_box">
        <table cellpadding="5" >
            <tr class="products_header">
                <td> name </td>
                <td> style </td>
                <td> description </td>
                <td> discount </td>
                <td> male </td>
                <td> weight ,gr</td>
                <td> price </td>
            </tr>
            <c:forEach var="elem" items="${braslets}" varStatus="status">
                <tr>
                    <td> <c:out value=" ${ elem.name } "/> </td>
                    <td> <c:out value=" ${ elem.style } "/> </td>
                    <td> <c:out value=" ${ elem.description } "/> </td>
                    <td> <c:out value=" ${ elem.discount } "/> </td>
                    <td> <c:out value=" ${ elem.male } "/> </td>
                    <td> <c:out value=" ${ elem.weight } "/> </td>
					<td><p class="product_price">$<c:out value="${elem.price} "/></p></td>
					<td>
                        <div class="product_box">
                            <a href="shoppingcart.jsp" class="add_to_card">Add to Cart</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<div class="cleaner"></div>
</body>
</html>