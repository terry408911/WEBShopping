package com.huel.bean;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import com.huel.dao.GoodsDao;
//购物车
public class ShoppingCart {
	private Map map=Collections.synchronizedMap(new HashMap());
	LinkedList<ShoppingCartItem> shoppingList = new LinkedList<ShoppingCartItem>();

	public LinkedList<ShoppingCartItem> getShoppingList() {
		return shoppingList;
	}

	public void setShoppingList(LinkedList<ShoppingCartItem> shoppingList) {
		this.shoppingList = shoppingList;
	}
    //商品价格
	public double getGoodsPrice(String id) {
		ShoppingCartItem caritem=(ShoppingCartItem)map.get(id);
		double listprice=caritem.getGoods().getPrice();
		int num=caritem.getNum();
		return listprice*num;
	}
	//商品总价
	public double getTotalPrice(){
		double totalprice=0.0;
		Iterator iter=map.values().iterator();
		while(iter.hasNext()){
			ShoppingCartItem caritem = (ShoppingCartItem)iter.next();
			double listprice=caritem.getGoods().getPrice();
			int num=caritem.getNum();
			totalprice+=listprice*num;
		}
		return totalprice;
	}
	//向购物车中添加商品
	public void addGoods(String id,int num){
		boolean is=this.isContain(id);
		if(is){
			ShoppingCartItem caritem=(ShoppingCartItem)map.get(id);
			caritem.add(num);
		}else{
			Goods good=GoodsDao.getGoodsById(id);
			ShoppingCartItem caritem=new ShoppingCartItem(good,num);
			map.put(id, caritem);
		}
	}
	public boolean isContain(String id){
		return map.containsKey(id);
	}
	 //数量更新
	public void updateNum(String id,int num){
		ShoppingCartItem caritem=(ShoppingCartItem)map.get(id);
        caritem.setNum(num);	
	}
	public void removeGood(String id)
    {
       map.remove(id);	 //移除
    }
	
	public Map getMap(){
		return map;
	}

}
