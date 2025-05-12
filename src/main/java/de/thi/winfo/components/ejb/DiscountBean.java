package de.thi.winfo.components.ejb;

import jakarta.ejb.Stateless;

/**
 * Session Bean implementation class DiscountBean
 */
@Stateless
public class DiscountBean implements DiscountBeanRemote {

    public DiscountBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Float calculateDiscount(String customerId, Float totalAmount) {
		if (totalAmount > 100000)
			return Float.valueOf((float)10.5);
		else
			return  Float.valueOf((float)4.3);
	}

}
