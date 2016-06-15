<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="css/view_style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css"/>
</head>

<body>
<div id="content" class="float_r">
    <h1>Breloques</h1>
    <div class="product_box">
        <table cellpadding="5">
            <tr class="products_header">
                <td>name</td>
                <td>style</td>
                <td>description</td>
                <td>discount</td>
                <td>male</td>
                <td>weight, gr</td>
                <td>price</td>
            </tr>
            <c:forEach var="elem" items="${breloques}" varStatus="status">
                <tr>
                    <td><c:out value="${ elem.name }"/></td>
                    <td><c:out value="${ elem.style }"/></td>
                    <td><c:out value="${ elem.description }"/></td>
                    <td><c:out value="${ elem.discount }"/></td>
                    <td><c:out value="${ elem.male }"/></td>
                    <td><c:out value="${ elem.weight }"/></td>
                    <td><p class="product_price">$<c:out value="${elem.price}"/></p></td>
                    <td>
                        <div class="product_box">
                            <form action="${pageContext.request.contextPath}/AppServlet" method="post">
                                <input type="hidden" name="mainAction" value="getBucket">
                                <input type="hidden" name="subAction" value="addItem">
                                <input type="hidden" name="itemCategory" value=${ elem.category }>
                                <input type="hidden" name="itemId" value=${ elem.id }>
                                <input type="submit" value="Add to Cart"/>
                            </form>
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