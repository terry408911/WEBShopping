package com.huel.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.huel.dao.UserDao;

//1.service(ServletRequest,ServletResponse)
//2.service(HttpServletRequest,HttpServletResponse)
//3.doGet/doPost             ����Ա��ͼ
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String userName = req.getParameter("userName");
		String pwd = req.getParameter("password");
		int pageIndex=1;
		HttpSession session;
		UserDao ud=new UserDao();
		if(userName.equals("")){
			req.setAttribute("ErrorInfo", "No username");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
		else{
			if(ud.queryUserByName(userName).equals(userName)){
				if(!ud.queryByPassword(userName,pwd)){					
					req.setAttribute("ErrorInfo", "�û��������");
				    req.getRequestDispatcher("/login.jsp").forward(req, resp);
			        }
				else{
					session = req.getSession();// ��ȡ session����
			        session.setAttribute("userName", userName);
			        session.setAttribute("pageIndex", pageIndex);
			         // ʵ����ת
			        req.getRequestDispatcher("/ViewGoods").forward(req, resp);
			         // this.getServletContext();//application
					
				    }
				}
			else
			{
				req.setAttribute("ErrorInfo", "�û���������");
			    req.getRequestDispatcher("/login.jsp").forward(req, resp);
			    }
			}
		
		
		}

	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
