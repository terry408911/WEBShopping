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
//��ʾ���ﳵ�е����ݣ���Ʒ��Ϣ���������ܼ۸�
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	@SuppressWarnings({ "unchecked", "unused" })
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		HttpSession session=req.getSession(false);
		LinkedList<ShoppingCart> cart=null;
		// ����pruFlag����û��Ƿ������Ʒ
		boolean purFlag = true;
		if(session==null){
			purFlag=false;
		}else{
			// ����û����ﳵ
			cart = (LinkedList)session.getAttribute("shoppingCart");
			// ����õĹ��ﳵΪnull��purFlag��Ϊfalse
			if (cart == null) {
			purFlag = false;
						}
		}
		if (!purFlag) {
			out.write("�Բ�������û�й����κ���Ʒ��<br>");
		} else {
			// ������ʾ�û�������Ʒ����Ϣ
			out.write("���������Ʒ�У�<br>");
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