package com.delivery.entity;

public class deliveryEntity {
	
	private int id;
	private String goods;
	private int price;
	
	public deliveryEntity(){
		this.id = 0;
		this.goods = "";
		this.price = 0;
	}
	
	public deliveryEntity(int id,String goods,int price){
		this.id = id;
		this.goods = goods;
		this.price = price;
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
}
