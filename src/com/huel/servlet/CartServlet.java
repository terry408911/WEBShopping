package com.huel.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.huel.bean.Goods;
import com.huel.bean.ShoppingCart;
import com.huel.bean.ShoppingCartItem;
//显示购物车中的数据（商品信息、数量，总价格）
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	@SuppressWarnings({ "unchecked", "unused" })
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		HttpSession session=req.getSession(false);
		LinkedList<ShoppingCart> cart=null;
		// 变量pruFlag标记用户是否买过商品
		boolean purFlag = true;
		if(session==null){
			purFlag=false;
		}else{
			// 获得用户购物车
			cart = (LinkedList)session.getAttribute("shoppingCart");
			// 如果用的购物车为null，purFlag置为false
			if (cart == null) {
			purFlag = false;
						}
		}
		if (!purFlag) {
			out.write("对不起！您还没有购买任何商品！<br>");
		} else {
			// 否则显示用户购买商品的信息
			out.write("您购买的商品有：<br>");
			double totalprice=0;
			double price = 0;
			for (ShoppingCart spc : cart) {
				for(int i=0;i<spc.getShoppingList().size();i++){
					ShoppingCartItem sci=spc.getShoppingList().get(i);										
				    Goods g=sci.getGoods();
				    price=g.getPrice();
				    out.write(g.getName());
				    out.write((int) price);
				    out.write(sci.getNum());
				    totalprice+=sci.getNum()*price;				    
				}
			}out.write((int) totalprice);
		}
	}
}