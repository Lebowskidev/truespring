package com.delivery.interfaces;

import java.util.Collection;
import com.delivery.entity.deliveryEntity;

public interface DeliveryInterface {
	public deliveryEntity surchById(int id);
	void updateDelivery(deliveryEntity deli);
	Collection<deliveryEntity> infoDelivery(int page);
	void removeDelivery(int id);
	void createDekivery(deliveryEntity deli);
}
