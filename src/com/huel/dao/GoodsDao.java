package com.huel.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import com.huel.bean.Goods;
import com.huel.common.Parameters;
import com.huel.tools.database.DataBaseConn;
public class GoodsDao {
	public static final String PRICE = "price";
	public static final String SALESCOUNT = "salesCount";
	public static final String ORDER_DESC = "desc";
	public static final String ORDER_ASC = "asc";
	private static Map<String, Goods> goods = new LinkedHashMap<String, Goods>();
	//Connection conn;

	//获取总记录数
	public int getRecordCount()
	{
	  String sql="select count(id) from goods";
	  //return Integer.parseInt(sql.trim());
	  try{
	  PreparedStatement psmt =DataBaseConn.conn.prepareStatement(sql);
	  ResultSet rs=psmt.executeQuery();
	  while(rs.next()){
		  int q=rs.getInt(1);		  
		  return q;
	  }
	  }catch(SQLException e){
		  e.printStackTrace();
	  }
	 return 0;	 	  
	}
	// 根据rule字段进行order(升序或降序)查询,返回第pageIndex页的数据
	public LinkedList<Goods> queryByPageIndex(String rule, String order, int pageIndex)//
	{
		LinkedList<Goods> goodsList = new LinkedList<Goods>();
		String sql = "select * from goods limit ?,?";
		try {
			
			PreparedStatement psmt =DataBaseConn.conn.prepareStatement(sql);			
			psmt.setInt(1, (pageIndex-1)*Parameters.pageSize);
			psmt.setInt(2, Parameters.pageSize);
			ResultSet rs=psmt.executeQuery();
			while(rs.next())
			{
				Goods g=new Goods();
				//g.set  .....
				g.setId(rs.getInt("id"));
				g.setName(rs.getString("name"));
				g.setPrice(rs.getDouble("price"));
				goodsList.add(g);
			}
			return goodsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	public static Goods getGoodsById(String id) {
		// TODO Auto-generated method stub
		Goods g=new Goods();
		String sql="select * from goods where id='"+id+"'";
		try{
			  PreparedStatement psmt =DataBaseConn.conn.prepareStatement(sql);
			  ResultSet rs=psmt.executeQuery();
			  while(rs.next()){
				  //Goods g=new Goods();
				  g.setId(rs.getInt("id"));
				  g.setName(rs.getString("name"));
				  g.setPrice(rs.getDouble("price"));
								  }
			  }catch(SQLException e){
				  e.printStackTrace();
			  }
		return g;
	}

}
