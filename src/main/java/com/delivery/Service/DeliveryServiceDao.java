package com.delivery.Service;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.delivery.interfaces.DeliveryInterface;
import com.delivery.entity.deliveryEntity;

public class DeliveryServiceDao implements DeliveryInterface  {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public static class workingWithRowMap implements RowMapper<deliveryEntity>{
		
	public deliveryEntity mapRow(ResultSet rs, int rowNum) throws SQLException{
		deliveryEntity deli = new deliveryEntity();
		deli.setId(rs.getInt(1));
		deli.setGoods(rs.getString(2));
		deli.setPrice(rs.getInt(3));

		return deli;
		}
	}
		/**
		 * surch elements
		 * @param id
		 * @return deliveryEntity object deli
		 */
	public deliveryEntity surchById(int id){
		final String SQL = "SELECT * FROM menu WHERE id=?";
		deliveryEntity deli = jdbc.queryForObject(SQL, new workingWithRowMap());
		return deli;
	}
	
		/**
		 * update data
		 * @param deliveryEntity object deli
		 */
	public void updateDelivery(deliveryEntity deli){
		final String SQL = "UPDATE menu SET goods=?, price=? WHERE id=?";
		final int id = deli.getId();
		final String goods = deli.getGoods();
		final int price = deli.getPrice();

jdbc.update(SQL, new Object[] { goods, price, id });
	}
	/**
	 * view elements 
	 * @return deliveryEntity object deli
	 */
	public Collection<deliveryEntity> infoDelivery(int page) {
		page *= 3;
		final String SQL = "SELECT * FROM menu LIMIT 3 offset ?";
		List<deliveryEntity> deli = jdbc.query(SQL, new workingWithRowMap(), page);
		return deli;
	}
	/**
	 * delete data by id
	 */
    public void removeDelivery(int id){
    	final String SQL = "DELETE FROM menu WHERE id=?";
    	jdbc.update(SQL,id);
    }
    /**
     * create new data    
     */
    public void createDekivery(deliveryEntity deli){
    	
    	final String SQL = "INSERT INTO menu (goods, price) values (?, ?) ";
		final String goods = deli.getGoods();
		final int price = deli.getPrice();

		jdbc.update(SQL, new Object[] { goods, price });
    }
    
}
