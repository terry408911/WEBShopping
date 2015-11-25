<%@page import="java.util.*,com.huel.bean.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function Treat(id)
{ 
   //alert("book id"+id);
   var url="/Shopping/BuyServlet?";
   url=url+"id="+id;
   url=url+"&num="+document.getElementById(id+"num").value;
   window.location.href=url;
   //alert("url:"+url);
}
</script>
</head>
<body>
<%
//Collection<Goods> goods=(Collection<Goods>)request.getAttribute("goods");
LinkedList<Goods>list=(LinkedList<Goods>)request.getAttribute("viewGoods");
int pageCount=(Integer)request.getAttribute("pagesCount");
int pageIndex=(Integer)request.getAttribute("pageIndex");
%>
	本站提供的商品有：
	<br>
	<form>
		<%
		  if(list!=null){
			  String url;
			for(int i=0;i<list.size();i++){
				url = "/Shopping/BuyServlet?id=" + list.get(i).getId();
				//out.println(list.get(i).getId());
				out.println(list.get(i).getName());
				out.println(list.get(i).getPrice());
				%>
				<input type='text' id='<%=list.get(i).getId()%>num' value=''>				
				<a href='javascript:Treat(<%=list.get(i).getId()%>)'>点击购买</a><br>
			<%}
		}
		%>		
	</form>		
<table>	<tr>
<td><a href="ViewGoods?pageIndex=1">首页</a></td>
<%if(pageIndex==1){	
%>
<td>上一页</td>
<% }else{
%>
<td><a href="ViewGoods?pageIndex=<%=pageIndex-1 %>">上一页</a></td>
<%} %>	
<%for(int i=1; i<=pageCount;i++){
	 if(i!=pageIndex){%>
<td>	
<a href="ViewGoods?pageIndex=<%=i %>"><%=i%></a><td>
<%}
	 else{
		 %>
		 <%=i%>
	 <%}
} %>	
<%if(pageIndex==pageCount){	
%>
<td>下一页</td>
<% }else{
%>
<td><a href="ViewGoods?pageIndex=<%=pageIndex+1 %>">下一页</a></td>
<%} %>

<td><a href="ViewGoods?pageIndex=<%=pageCount %>">尾页</a></td>
</tr>
</table>
</body>
</html>