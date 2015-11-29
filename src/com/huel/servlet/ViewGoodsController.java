package com.huel.servlet;
import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huel.bean.Goods;
import com.huel.common.Parameters;
import com.huel.dao.GoodsDao;

/**
 * Servlet implementation class ViewGoods
 */
public class ViewGoodsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * Default constructor.
	 */
	public ViewGoodsController() {
		// TODO Auto-generated constructor stub
		//super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String pi = (String) request.getAttribute("pageIndex");
		//PrintWriter out = response.getWriter();
		String pi=(String) request.getParameter("pageIndex");
		//System.out.println(pi);
		int pageIndex;
		if (pi == null)
			pageIndex = 1;
		else {
			try {
				pageIndex = Integer.parseInt(pi.trim());
			} catch (NumberFormatException e) {
				pageIndex = 1;
			}
		}
		//System.out.println(pageIndex);
		//System.out.println(pi);
		GoodsDao gd = new GoodsDao();
		LinkedList<Goods> g = new LinkedList<Goods>(); 
		g = gd.queryByPageIndex(GoodsDao.SALESCOUNT,
				GoodsDao.ORDER_DESC, pageIndex);
        request.setAttribute("viewGoods", g);
        int recordCount=gd.getRecordCount();//����Ŀ��       
        int pagesCount=recordCount%Parameters.pageSize==0?recordCount/Parameters.pageSize:recordCount/Parameters.pageSize+1;   //��ҳ��     
        request.setAttribute("pagesCount",pagesCount);
        request.setAttribute("pageIndex", pageIndex);
        //LinkedList<Goods> allGoods=GoodsDao.getAllGoods();
		//request.setAttribute("goods",allGoods);
        request.getRequestDispatcher("/main.jsp").forward(request, response);        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
