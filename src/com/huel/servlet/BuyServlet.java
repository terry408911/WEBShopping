package com.huel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.huel.bean.ShoppingCart;
@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet{  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
		   String id=req.getParameter("id");
		   String num1=req.getParameter("num");
		   String img = req.getParameter("img");
		   System.out.println(img);
		   String page = req.getParameter("page");
		   
		   int pageIndex = Integer.parseInt(page);
		   
		   if(num1.equals("")){
			   num1="1";
		   }
		   int num=Integer.parseInt(num1);
		   
		   HttpSession session=req.getSession(true);
		   
		   if(session.getAttribute("ShoppingCart")!=null){
			   ShoppingCart cart=(ShoppingCart)session.getAttribute("ShoppingCart");
			   cart.addGoods(id, num, img);
		   }else{
			   ShoppingCart cart=new ShoppingCart();
			   cart.addGoods(id, num, img);
			   session.setAttribute("ShoppingCart",cart);
		   }
		   
		   if (session.getAttribute("totalItem")!=null) {
				session.setAttribute("totalItem", session.getAttribute("totalItem"));
			}else {
				session.setAttribute("totalItem", 1);
			}
//		   req.getRequestDispatcher("ViewGoods?pageIndex="+pageIndex).forward(req, resp);
		   
		   resp.sendRedirect("ViewGoods?pageIndex="+pageIndex);
		}
	
  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
