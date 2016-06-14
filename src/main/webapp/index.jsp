<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Hand-made store</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />

    <link href="css/view_style.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />

    <script type="text/javascript" src="js/ddsmoothmenu.js"></script>

    <script language="javascript" type="text/javascript">
        function clearText(field)
        {
            if (field.defaultValue == field.value) field.value = '';
            else if (field.value == '') field.value = field.defaultValue;
        }
    </script>

    <script type="text/javascript">
        ddsmoothmenu.init({
            mainmenuid: "top_nav", //menu DIV id
            orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
            classname: 'ddsmoothmenu', //class added to menu's outer DIV
            //customtheme: ["#1c5a80", "#18374a"],
            contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
        })
    </script>

    <script type="text/javascript">
        $(document).ready(function() {
            $(".carousel").dualSlider({
                auto:true,
                autoDelay: 6000,
                easingCarousel: "swing",
                easingDetails: "easeOutBack",
                durationCarousel: 1000,
                durationDetails: 600
            });
        });
    </script>

</head>

<body>
<div id="templatemo_wrapper">
    <div id="templatemo_header">
        <div id="site_title">
            <h1><a href="${pageContext.request.contextPath}/AppServlet?action=getAll" target="Frame">Hand-made store</a></h1>
        </div>

        <div id="header_right">
            <a href="shoppingcart.jsp" target="Frame">Cart</a> | <a href="checkout.jsp" target="Frame">Chekcout</a>
        </div>

        <div class="cleaner"></div>
    </div> <!-- END of header -->

    <div id="templatemo_menu">
        <div id="top_nav" class="ddsmoothmenu">
            <ul>
                <li><a href="${pageContext.request.contextPath}/AppServlet?action=getAll" target="Frame">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/AppServlet?action=getAll" target="Frame">Products</a>
                    <ul>
                        <li><a href="earings.jsp" target="Frame">Earings</a></li>
                        <li><a href="braslets.jsp" target="Frame">Braslets</a></li>
                        <li><a href="breloques.jsp" target="Frame">Breloque</a></li>
                        <li><a href="watches.jsp" target="Frame">Watches</a></li>
                    </ul>
                </li>
                <li><a href="faqs.html" target="Frame">FAQs</a></li>
                <li><a href="checkout.jsp" target="Frame">Chekcout</a></li>
                <li><a href="contact.html" target="Frame">Contacts</a></li>
            </ul>
            <br style="clear: left" />
        </div> <!-- end of ddsmoothmenu -->

        <div id="menu_second_bar">
            <div id="top_shopping_cart">
                Cart: <strong>(!!!!!!!!!!!)3 Products</strong> ( <a href="shoppingcart.jsp" target="Frame">Cart</a> )
            </div>
            <div class="cleaner"></div>
        </div>
    </div> <!-- END of menu -->

    <div id="templatemo_main">
        <div id="sidebar" class="float_l">
            <div class="sidebar_box"><span class="bottom"></span>
                <h3>Products</h3>
                <div class="content">
                    <ul class="sidebar_list">
                        <li class="first"><a href="${pageContext.request.contextPath}/AppServlet?action=getAll" target="Frame">All</a></li>
                        <li><a href="${pageContext.request.contextPath}/AppServlet?action=getEarings" target="Frame">Earings</a></li>
                        <li><a href="${pageContext.request.contextPath}/AppServlet?action=getBraslets" target="Frame">Braslets</a></li>
                        <li><a href="${pageContext.request.contextPath}/AppServlet?action=getBreloques" target="Frame">Breloques</a></li>
                        <li><a href="${pageContext.request.contextPath}/AppServlet?action=getWatches" target="Frame">Watches</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <iframe name="Frame" src="products.jsp"></iframe>

        <div class="cleaner"></div>
    </div> <!-- END of main -->

    <div id="templatemo_footer">
        <p>	<a href="${pageContext.request.contextPath}/AppServlet?action=getAll" target="Frame">Home</a> | <a href="${pageContext.request.contextPath}/AppServlet?action=getAll" target="Frame">Products</a> | <a href="faqs.html" target="Frame">FAQs</a> | <a href="checkout.jsp" target="Frame">Chekcout</a> | <a href="contact.html" target="Frame">Contacts</a>
        </p>
        <span style="color: #0099CC; ">Copyright © 2016</span> <span style="color: #000033; ">Samotiazhko. Muhin. Kiparoidze</span>
    </div> <!-- END of footer -->

</div> <!-- END of wrapper -->

</body>
</html>