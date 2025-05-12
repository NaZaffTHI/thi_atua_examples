package de.thi.winfo.components.ejb;

import de.thi.winfo.components.bean.Customer;
import jakarta.ejb.Stateless;

import java.util.ArrayList;
import java.util.List;

/**
 * Session Bean implementation class SearchCustomerBean
 */
@Stateless
public class SearchCustomerBean implements SearchCustomerBeanRemote {

    public SearchCustomerBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Customer> searchCustomers(String email) {
		System.out.println("Searching for " + email);
		List<Customer> customerList = new ArrayList<>();
		Customer customer = new Customer();
		customer.setId(4711L);
		customer.setPassword("secret1");
		customer.setEmail("donald.duck@demo.org");
		customerList.add(customer);
		customer = new Customer();
		customer.setId(4712L);
		customer.setPassword("secret2");
		customer.setEmail("susan.summer@demo.org");
		customerList.add(customer);
		return customerList;
	}
}
