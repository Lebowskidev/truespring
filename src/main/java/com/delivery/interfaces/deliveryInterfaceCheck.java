package com.delivery.interfaces;

import java.util.Collection;

import com.delivery.entity.deliveryEntityCheck;

public interface deliveryInterfaceCheck {
	Collection<deliveryEntityCheck> infoDelivery(int page);
	void removeDelivery(int id);
	void createDekivery(deliveryEntityCheck deli);
}
