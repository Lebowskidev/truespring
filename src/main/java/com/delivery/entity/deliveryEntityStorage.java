package com.delivery.entity;

public class deliveryEntityStorage {
	private int id;
	private String goods;
	private int count;
	
	public deliveryEntityStorage(){
		this.id = 0;
		this.goods = "";
		this.count = 0;
	}
	
	public deliveryEntityStorage(int id,String goods,int count){
		this.id = id;
		this.goods = goods;
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
	public int getCount(){
		return count;
	}
	public void setCount(int count){
		this.count = count;
	}
}
