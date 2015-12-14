package com.huel.bean;

public class ShoppingCartItem {
   Goods g; //��Ʒ
   int num;//��������
   String img;
   public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}
public ShoppingCartItem(Goods g,int num,String img){
	   this.g=g;
	   this.num=num;
	   this.img = img;
   }
//һ��һ�����Ʒ��
public void incrment(){
 	num++;
}
//��ԭ�еĻ���������һЩ
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
