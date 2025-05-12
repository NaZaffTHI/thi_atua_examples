package de.thi.winfo.components.ejb;

import jakarta.ejb.Remote;

@Remote
public interface DiscountBeanRemote {
	public abstract Float calculateDiscount(String customerId, Float totalAmount);
}
