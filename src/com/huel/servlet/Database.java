package com.huel.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huel.dao.GoodsDao;


@SuppressWarnings("serial")
@WebServlet("/database")
public class Database extends HttpServlet
{
 private List<String> db = new ArrayList<String>();
 
 public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
 {
  String tag = request.getParameter("tag");
  if(tag != "")
  {
   String rs = "";
   for(int i=0;i<this.db.size();i++)
   {
    if(this.db.get(i).startsWith(tag))
    {
     rs = rs + this.db.get(i) + ",";
    }
   }
   if(rs != "")
   {
    rs = rs.substring(0, rs.length()-1); 
   }
   PrintWriter pw = response.getWriter();
   pw.write(rs);
   pw.flush();
   pw.close(); 
  }
 }

 public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
 {
  this.doGet(request, response);
 }

 public void init() throws ServletException
 {
	 GoodsDao gDao = new GoodsDao();
	 db = gDao.suggestionQuery();
 }
}