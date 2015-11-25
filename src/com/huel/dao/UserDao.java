package com.huel.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.huel.bean.User;
import com.huel.tools.database.DataBaseConn;

public class UserDao {
   public String queryUserByName(String userName){
		//LinkedList<User> list = new LinkedList<User>();
	   String sql1="select username from user where username";
	   if(DataBaseConn.conn==null){
		   DataBaseConn.openConn();
	   }try{
		    Statement stmt = DataBaseConn.conn.createStatement();
			String sql="select username from user where username='"+userName+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				return userName;
			}
	   }catch(SQLException e){
		   e.printStackTrace();
		  
	   }
	   
	   return sql1;
   };
   public boolean queryByPassword(String u,String password){
	   if(DataBaseConn.conn==null){
		   DataBaseConn.openConn();
	   }try{
		   Statement stmt = DataBaseConn.conn.createStatement();
			String sql="select * from user where username='"+u+"' and password='"+password+"'";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				return true;
			}
	   }catch(SQLException e){
		   e.printStackTrace();
		   		   
	   }
     return false;
   }
   
}
