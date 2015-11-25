<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.huel.bean.*" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
你的购物车： 
<table border=1>
<tr><td>商品id</td><td>商品名称</td><td>商品价格</td><td>商品数量</td><td>该商品总价</td></tr>
<%ShoppingCart cart=null;
double totalprice=0.0;
if(session.getAttribute("ShoppingCart")!=null){
	cart=(ShoppingCart)session.getAttribute("ShoppingCart");
	Map map=cart.getMap();
	Iterator iter=map.values().iterator();
	while(iter.hasNext()){
		ShoppingCartItem caritem=(ShoppingCartItem)iter.next();
		Goods good=caritem.getGoods();
		int num=caritem.getNum();
		double goodsprice=good.getPrice()*num;
		totalprice+=goodsprice;		
		 %>		
		 <tr><td><%=good.getId() %></td> 
		 <td><%=good.getName() %></td>	
		 <td><%=good.getPrice() %></td>	
		 <td><%=num %></td>	
		 <td><%=goodsprice %></td>
		 </tr>			
	<% }
}
%>
<tr>
<td colspan=5>
               总价格:<%=totalprice%></td>
</tr>
</table>
</body>
</html>