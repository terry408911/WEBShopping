package com.huel.bean;

public class ShoppingCartItem {
   Goods g; //商品
   int num;//购买数量
   public ShoppingCartItem(Goods g,int num){
	   this.g=g;
	   this.num=num;
	   
   }
//一个一个买产品项
public void incrment(){
 	num++;
}
//在原有的基础上再买一些
public void add(int n){
 	num+=n;	
}
public Goods getGoods() {
	return g;
}
public void setGoods(Goods g) {
	this.g = g;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}

   
}
