<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ page import="java.util.*,com.huel.bean.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Shoes Store, free template</title>
<meta name="keywords" content="shoes store, free template, ecommerce, online shop, website templates, CSS, HTML" />
<meta name="description" content="Shoes Store is a free ecommerce template provided " />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="nivo-slider.css" type="text/css" media="screen" />

<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/ddsmoothmenu.js">

</script>

<script type="text/javascript">

ddsmoothmenu.init({
	mainmenuid: "top_nav", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})

function Treat(id)
{ 
   //alert("book id"+id);
   var url="/Shopping/BuyServlet?";
   url=url+"id="+id;
   url=url+"&num="+document.getElementById(id+"num").value;
   url=url+"&img="+document.getElementById("img").href;
   url=url+"&page="+${requestScope.pagesIndex };
   window.location.href=url;
   //alert("url:"+url);
}


var xmlHttpRequest;

function createXmlHttpRequest()
{
	if(window.ActiveXObject)
 	{
  		try
  		{
   			xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
  		}
  		catch(e)
  		{
   			xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
 		 }
  		return xmlHttpRequest;
 	}
 	else if(window.XMLHttpRequest)
 	{
  		return new XMLHttpRequest();
 	}
}

function auto()
{
 	var query = document.getElementById("query");
 	var auto = document.getElementById("auto");
	var tags = document.getElementById("tags");
 	if(event.keyCode == 40)
 	{  
  		if(query.value != "" && auto.style.visibility != "hidden")
  		{
   			tags.focus();
   			tags.selectedIndex = 0;
   			query.value = tags.options[0].text;
   			return;
  		}
 	}
 	xmlHttpRequest = createXmlHttpRequest();
 	xmlHttpRequest.onreadystatechange = backFct;
 	var url = "<%=basePath %>database?tag=" + query.value;
		xmlHttpRequest.open("post", url, true);
		xmlHttpRequest.send(null);
	}

	function backFct() {
		if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
			var rs = xmlHttpRequest.responseText;
			if (rs != "") {
				var tagsRs = rs.split(",");
				var auto = document.getElementById("auto");
				var tags = document.getElementById("tags");
				var query = document.getElementById("query");
				tags.length = 0;
				tags.size = tagsRs.length;
				for (var i = 0; i < tagsRs.length; i++) {
					var option = document.createElement("option");
					option.setAttribute("text", tagsRs[i]);
					tags.options[i] = option;
				}
				auto.style.width = query.style.width;
				tags.style.width = query.style.width;
				auto.style.left = query.offsetLeft - 1;
				auto.style.top = query.offsetTop + query.offsetHeight + 1;
				auto.style.visibility = "visible";
			} else {
				document.getElementById("auto").style.visibility = "hidden";
			}
		}
	}

	function text() {
		var query = document.getElementById("query");
		var auto = document.getElementById("auto");
		var tags = document.getElementById("tags");
		if (event.keyCode == 40 || event.keyCode == 38) {
			if (query.value != "" && auto.style.visibility != "hidden") {
				query.value = tags.options[tags.selectedIndex].text;
			}
		} else if (event.keyCode == 13) {
			auto.style.visibility = "hidden";
			query.focus();
		}
	}
	
	function add(){
		document.getElementsByName("num").value = document.getElementsByName("num")+1;
	}
</script>

</head>

<body>

<div id="templatemo_body_wrapper">
<div id="templatemo_wrapper">

	<div id="templatemo_header">
    	<div id="site_title"><h1><a href="#">Online Shoes Store</a></h1></div>
        <div id="header_right">
        	<p>
	        <a href="#">My Account</a> | <a href="#">My Wishlist</a> | <a href="#">My Cart</a> | <a href="#">Checkout</a> | <a href="#">Log In</a></p>
            <p>
            	Shopping Cart: <strong>3 items</strong> ( <a href="shoppingcart.jsp">Show Cart</a> )
			</p>
		</div>
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_header -->
    
    <div id="templatemo_menubar">
    	<div id="top_nav" class="ddsmoothmenu">
            <ul>
                <li><a href="index.html" class="selected">Home</a></li>
                <li><a href="products.html">Products</a>
                    <ul>
                        <li><a href="#">Sub menu 1</a></li>
                        <li><a href="#">Sub menu 2</a></li>
                        <li><a href="#">Sub menu 3</a></li>
                        <li><a href="#">Sub menu 4</a></li>
                        <li><a href="#">Sub menu 5</a></li>
                  </ul>
                </li>
                <li><a href="about.html">About</a>
                    <ul>
                        <li><a href="#">Sub menu 1</a></li>
                        <li><a href="#">Sub menu 2</a></li>
                        <li><a href="#">Sub menu 3</a></li>
                  </ul>
                </li>
                <li><a href="faqs.html">FAQs</a></li>
                <li><a href="checkout.html">Checkout</a></li>
                <li><a href="contact.html">Contact Us</a></li>
            </ul>
            <br style="clear: left" />
        </div> <!-- end of ddsmoothmenu -->
        <div id="templatemo_search">
            <form action="#" method="get">
              <input type="text" value=" " name="keyword" id="query" title="keyword" onkeyup="auto();" onfocus="clearText(this)" onblur="clearText(this)" class="txt_field" />
              <input type="submit" name="Search" value=" " alt="Search" id="searchbutton" title="Search" class="sub_btn"  />
            </form>
        </div>
        <div id="auto" style="border-style: solid; border-width: 1px; visibility: hidden; position: absolute;">
			<select id="tags" onkeyup="text();" size="0" style="margin: -2px;"></select>
		</div>
    </div> <!-- END of templatemo_menubar -->
	<div class="copyrights">Collect from <a href="#"  title="网页模板">网页模板</a></div>
    
    <div id="templatemo_main">
    	<div id="sidebar" class="float_l">
        	<div class="sidebar_box"><span class="bottom"></span>
            	<h3>Categories</h3>   
                <div class="content"> 
                	<ul class="sidebar_list">
                    	<li class="first"><a href="#">Sed eget purus</a></li>
                        <li><a href="#">Vestibulum eleifend</a></li>
                        <li><a href="#">Nulla odio ipsum</a></li>
                        <li><a href="#">Suspendisse posuere</a></li>
                        <li><a href="#">Nunc a dui sed</a></li>
                        <li><a href="#">Curabitur ac mauris</a></li>
                        <li><a href="#">Mauris nulla tortor</a></li>
                        <li><a href="#">Nullam ultrices</a></li>
                        <li><a href="#">Nulla odio ipsum</a></li>
                        <li><a href="#">Suspendisse posuere</a></li>
                        <li><a href="#">Nunc a dui sed</a></li>
                        <li><a href="#">Curabitur ac mauris</a></li>
                        <li><a href="#">Mauris nulla tortor</a></li>
                        <li><a href="#">Nullam ultrices</a></li>
                        <li class="last"><a href="#">Sed eget purus</a></li>
                    </ul>
                </div>
            </div>
            <div class="sidebar_box"><span class="bottom"></span>
            	<h3>Bestsellers </h3>   
                <div class="content"> 
                	<div class="bs_box">
                    	<a href="#"><img src="images/templatemo_image_01.jpg" alt="image" /></a>
                        <h4><a href="#">Donec nunc nisl</a></h4>
                        <p class="price">$10</p>
                        <div class="cleaner"></div>
                    </div>
                    <div class="bs_box">
                    	<a href="#"><img src="images/templatemo_image_01.jpg" alt="image" /></a>
                        <h4><a href="#">Lorem ipsum dolor sit</a></h4>
                        <p class="price">$12</p>
                        <div class="cleaner"></div>
                    </div>
                    <div class="bs_box">
                    	<a href="#"><img src="images/templatemo_image_01.jpg" alt="image" /></a>
                        <h4><a href="#">Phasellus ut dui</a></h4>
                        <p class="price">$20</p>
                        <div class="cleaner"></div>
                    </div>
                    <div class="bs_box">
                    	<a href="#"><img src="images/templatemo_image_01.jpg" alt="image" /></a>
                        <h4><a href="#">Vestibulum ante</a></h4>
                        <p class="price">$8</p>
                        <div class="cleaner"></div>
                    </div>
                </div>
            </div>
        </div>
        <div id="content" class="float_r">
        	<div id="slider-wrapper">
                <div id="slider" class="nivoSlider">
                    <img src="images/slider/02.jpg" alt="" />
                    <a href="#"><img src="images/slider/01.jpg" alt="" title="This is an example of a caption" /></a>
                    <img src="images/slider/03.jpg" alt="" />
                    <img src="images/slider/04.jpg" alt="" title="#htmlcaption" />
                </div>
                <div id="htmlcaption" class="nivo-html-caption">
                    <strong>This</strong> is an example of a <em>HTML</em> caption with <a href="#">a link</a>.
                </div>
            </div>
            <script type="text/javascript" src="js/jquery-1.4.3.min.js"></script>
            <script type="text/javascript" src="js/jquery.nivo.slider.pack.js"></script>
            <script type="text/javascript">
            $(window).load(function() {
                $('#slider').nivoSlider();
            });
            </script>
        	<h1>New Products</h1>    	
       		
       		<c:forEach var="good" items="${requestScope.viewGoods }">
       			<div class="product_box">
  				<h3>${good.name }</h3>
  				<a  href="/Shopping/BuyServlet?id=${good.id }"><img id="img" src="${good.pic }"></img></a>
  				<div style="height:50px">${good.desp }</div>
  				<p class="product_price">${good.price }</p>
  				<input name="num" type="text" id="${good.id }num" class="num" value="1"/>&nbsp;<a href="javascript:add();" style="margin-left: -40px;font-size: 16px;">+</a>
  				<a href="javascript:Treat(${good.id })" class="addtocart"></a>
  				</div>
       		</c:forEach>
       	
       	<!-- show page  -->
       	
       	<center>
            <table>	<tr>
				<span><a href="ViewGoods?pageIndex=1">首页</a></span>
				<c:choose>
					<c:when test="${requestScope.pagesIndex==1 }">
						<span>上一页</span>
					</c:when>
					<c:otherwise>
						<span><a href="ViewGoods?pageIndex=${requestScope.pagesIndex-1 }">上一页</a></span>
					</c:otherwise>
				</c:choose>
				<c:forEach begin="1" end="${requestScope.pagesCount }" var="i" step="1">
					<c:choose>
						<c:when test="${i != requestScope.pageIndex}">
							<td>	
							<a href="ViewGoods?pageIndex=${i }">${i }</a><td>
						</c:when>
						<c:otherwise>
							${i }
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:choose>
					<c:when test="${requestScope.pageIndex == requestScope.pageCount }">
						<span>下一页</span>
					</c:when>
					<c:otherwise>
						<span><a href="ViewGoods?pageIndex=${requestScope.pageIndex+1 }">下一页</a></span>
					</c:otherwise>
				</c:choose>

				<span><a href="ViewGoods?pageIndex=${requestScope.pageCount }">尾页</a></span>
				</tr>
				</table>
				</center>
            </div>
 
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_main -->
    
    <div id="templatemo_footer">
    	<p><a href="#">Home</a> | <a href="#">Products</a> | <a href="#">About</a> | <a href="#">FAQs</a> | <a href="#">Checkout</a> | <a href="#">Contact Us</a>
		</p>

    	Copyright &copy; 2014.Company name All rights reserved.<a target="_blank" href="#">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
    </div> <!-- END of templatemo_footer -->
    
</div> <!-- END of templatemo_wrapper -->
</div> <!-- END of templatemo_body_wrapper -->
</body>
</html>