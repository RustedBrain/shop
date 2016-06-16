<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<link href="css/view_style.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />

</head>

<body>
<div id="content" class="float_r">
	<h1>Shopping Cart</h1>
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
					<td align="center"> <a href="#"><font color="black" weight="bold">Remove</font></a>  </td>
				</tr>
			</c:forEach>

			<tr><td></td><td> </td></tr>
			<tr><td></td><td> </td></tr>
			<tr><td></td><td> </td></tr>
			<tr>
				<td align="right" style="background:#ddd; font-weight:bold"> Total </td>
				<td align="right" style="background:#ddd; font-weight:bold">!!! </td>
			</tr>
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

       
      