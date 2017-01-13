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
}
