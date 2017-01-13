package com.delivery.Service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.delivery.interfaces.deliveryInterfaceCheck;
import com.delivery.Service.DeliveryServiceDaoStorage.workingWithRowMap;
import com.delivery.entity.deliveryEntityCheck;
import com.delivery.entity.deliveryEntityStorage;

public class deliveryServiceDaoCheck implements deliveryInterfaceCheck  {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public static class workingWithRowMap implements RowMapper<deliveryEntityCheck>{
		
	public deliveryEntityCheck mapRow(ResultSet rs, int rowNum) throws SQLException{
		deliveryEntityCheck deli = new deliveryEntityCheck();
		deli.setId(rs.getInt(1));
		deli.setGoods(rs.getString(2));
		deli.setCount(rs.getInt(3));

		return deli;
		}
	}
	
	public Collection<deliveryEntityCheck> infoDelivery(int page) {
		page *= 3;
		final String SQL = "SELECT * FROM Check LIMIT 3 offset ?";
		List<deliveryEntityCheck> deli = jdbc.query(SQL, new workingWithRowMap(), page);
		return deli;
	}
	
	 public void removeDelivery(int id){
	    	final String SQL = "DELETE FROM Check WHERE id=?";
	    	jdbc.update(SQL,id);
	    }
	    
	    public void createDekivery(deliveryEntityCheck deli){
	    	
	    	final String SQL = "INSERT INTO Check (goods, count,price) values (?, ?, ?) ";
			final String goods = deli.getGoods();
			final int count = deli.getCount();
			final int price = deli.getPrice();
			
			jdbc.update(SQL, new Object[] { goods, count , price });
	    }
}

