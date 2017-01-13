package com.delivery.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.delivery.interfaces.deliveryInterfaceStorage;
import com.delivery.entity.deliveryEntityStorage;

public class DeliveryServiceDaoStorage implements deliveryInterfaceStorage  {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public static class workingWithRowMap implements RowMapper<deliveryEntityStorage>{
		
	public deliveryEntityStorage mapRow(ResultSet rs, int rowNum) throws SQLException{
		deliveryEntityStorage deli = new deliveryEntityStorage();
		deli.setId(rs.getInt(1));
		deli.setGoods(rs.getString(2));
		deli.setCount(rs.getInt(3));

		return deli;
		}
	}
	
	public deliveryEntityStorage surchById(int id){
		final String SQL = "SELECT * FROM storage WHERE id=?";
		deliveryEntityStorage deli = jdbc.queryForObject(SQL, new workingWithRowMap());
		return deli;
	}
	
	public void updateDelivery(deliveryEntityStorage deli){
		final String SQL = "UPDATE storage SET goods=?, count=? WHERE id=?";
		final int id = deli.getId();
		final String goods = deli.getGoods();
		final int count = deli.getCount();

jdbc.update(SQL, new Object[] { goods, count, id });
	}
	
	public Collection<deliveryEntityStorage> infoDelivery(int page) {
		page *= 3;
		final String SQL = "SELECT * FROM storage LIMIT 3 offset ?";
		List<deliveryEntityStorage> deli = jdbc.query(SQL, new workingWithRowMap(), page);
		return deli;
	}
	
    public void removeDelivery(int id){
    	final String SQL = "DELETE FROM storage WHERE id=?";
    	jdbc.update(SQL,id);
    }
    
    public void createDekivery(deliveryEntityStorage deli){
    	
    	final String SQL = "INSERT INTO storage (goods, count) values (?, ?) ";
		final String goods = deli.getGoods();
		final int count = deli.getCount();

		jdbc.update(SQL, new Object[] { goods, count });
    }
}
