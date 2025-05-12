package de.thi.winfo.components.ejb;

import de.thi.winfo.components.bean.Customer;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface SearchCustomerBeanRemote {
	public abstract List<Customer> searchCustomers(String email);
}
