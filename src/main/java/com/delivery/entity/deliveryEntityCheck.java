package com.delivery.entity;

public class deliveryEntityCheck {
	private int id;
	private String goods;
	private int price;
	private int count;
	
	public deliveryEntityCheck(){
		this.id = 0;
		this.goods = "";
		this.price = 0;
		this.count = 0;
	}
	
	public deliveryEntityCheck(int id,String goods,int price, int count){
		this.id = id;
		this.goods = goods;
		this.price = price;
		this.count = count;
	}
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getGoods(){
		return goods;
	}
	public void setGoods(String goods){
		this.goods = goods;
	}
	public int getPrice(){
		return price;
	}
	public void setPrice(int price){
		this.price = price;
	}
	public int getCount(){
		return count;
	}
	public void setCount(int count){
		this.count = count;
	}
}
