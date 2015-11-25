<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*,com.huel.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function Treat(id)
{ 
   //alert("book id"+id);
   var url="/Shopping_11_18/PurchaseServlet?";
   url=url+"id="+id;
   url=url+"&num="+document.getElementById(id+"num").value;
   window.location.href=url;
   //alert("url:"+url);
}

</script>
</head>
<body>
	<%
		LinkedList<Goods> GoodsList=(LinkedList<Goods>)request.getAttribute("books");
	%>



	本站提供的图书有：
	<br>
	<form>
		<%
			String url;
			for (Goods g : GoodsList) {
			 url = "/Shopping/PurchaseServlet?id=" + g.getId();
		%>
		<%=g.getName()%>
		<input type='text' id='<%=g.getId()%>num' value=' '> 
		<a href='javascript:Treat(<%=g.getId()%>)'>点击购买</a><br>
		<%
		}
		%>		
	</form>	



</body>
</html>