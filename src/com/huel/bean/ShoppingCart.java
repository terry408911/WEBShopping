package com.huel.bean;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import com.huel.dao.GoodsDao;
//���ﳵ
public class ShoppingCart {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Map map=Collections.synchronizedMap(new HashMap());
	LinkedList<ShoppingCartItem> shoppingList = new LinkedList<ShoppingCartItem>();

	public LinkedList<ShoppingCartItem> getShoppingList() {
		return shoppingList;
	}

	public void setShoppingList(LinkedList<ShoppingCartItem> shoppingList) {
		this.shoppingList = shoppingList;
	}
    //��Ʒ�۸�
	public double getGoodsPrice(String id) {
		ShoppingCartItem caritem=(ShoppingCartItem)map.get(id);
		double listprice=caritem.getGoods().getPrice();
		int num=caritem.getNum();
		return listprice*num;
	}
	//��Ʒ�ܼ�
	public double getTotalPrice(){
		double totalprice=0.0;
		@SuppressWarnings("rawtypes")
		Iterator iter=map.values().iterator();
		while(iter.hasNext()){
			ShoppingCartItem caritem = (ShoppingCartItem)iter.next();
			double listprice=caritem.getGoods().getPrice();
			int num=caritem.getNum();
			totalprice+=listprice*num;
		}
		return totalprice;
	}
	//���ﳵ�������Ʒ
	@SuppressWarnings("unchecked")
	public void addGoods(String id,int num,String url){
		boolean is=this.isContain(id);
		if(is){
			ShoppingCartItem caritem=(ShoppingCartItem)map.get(id);
			caritem.add(num);
		}else{
			Goods good=GoodsDao.getGoodsById(id);
			ShoppingCartItem caritem=new ShoppingCartItem(good,num,url);
			map.put(id, caritem);
		}
	}
	public boolean isContain(String id){
		return map.containsKey(id);
	}
	 //��������
	public void updateNum(String id,int num){
		ShoppingCartItem caritem=(ShoppingCartItem)map.get(id);
        caritem.setNum(num);	
	}
	public void removeGood(String id)
    {
       map.remove(id);	 //�Ƴ�
    }
	
	@SuppressWarnings("rawtypes")
	public Map getMap(){
		return map;
	}

	

}
