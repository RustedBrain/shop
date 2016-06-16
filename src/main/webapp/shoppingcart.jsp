<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <link href="css/view_style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css"/>

</head>

<body>
<div id="content" class="float_r">
    <h1>Shopping Cart</h1>
    <div class="product_box">
        <table bgcolor="#f0f0f0" cellpadding="5" width="91%" height="100%">
            <tr>
                <td colspan="5"><span style="font-size: x-large; color: black; "> All products</span></td>
            </tr>
            <tr class="products_header">
                <td>name</td>
                <td>style</td>
                <td>description</td>
                <td>discount</td>
                <td>male</td>
                <td>weight, gr</td>
                <td>price</td>
            </tr>
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
                            <input type="hidden" name="subAction" value="addItem">
                            <input type="hidden" name="itemCategory" value=${ elem.category }>
                            <input type="hidden" name="itemId" value=${ elem.id }>

                            <input type="submit" value="Add to Cart"
                                   style="color: whitesmoke; font-size: 12pt;
                                       font-style: italic; font-weight: bold;
                                       background-color: #21bdd0; vertical-align: bottom "/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <br/>
    <div style="float:left; width: 100%; margin-top: 20px;">

        <p><a href="checkout.jsp">Proceed to checkout</a></p>
        <p><a href="javascript:history.back()">Continue shopping</a></p>

    </div>

</div>

</body>
</html>