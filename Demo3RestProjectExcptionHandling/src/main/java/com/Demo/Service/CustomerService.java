package com.Demo.Service;

import java.util.List;

import com.Demo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomer();
	
	public Customer addCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public void deleteCustomer(Integer cid);


}
