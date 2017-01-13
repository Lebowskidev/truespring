package com.delivery.interfaces;

import java.util.Collection;
import com.delivery.entity.deliveryEntityStorage;

public interface deliveryInterfaceStorage {
	public deliveryEntityStorage surchById(int id);
	void updateDelivery(deliveryEntityStorage deli);
	Collection<deliveryEntityStorage> infoDelivery(int page);
	void removeDelivery(int id);
	void createDekivery(deliveryEntityStorage deli);
}