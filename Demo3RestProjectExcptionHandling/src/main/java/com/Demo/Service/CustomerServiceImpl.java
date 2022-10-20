package com.Demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Demo.Exception.BusinessException;
import com.Demo.Repository.CustomerRepository;
import com.Demo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public List<Customer> getCustomer() {
		return customerRepo.findAll();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		if(customer.getCustomerName().isEmpty() || customer.getCustomerName().length()==0) {
			throw new BusinessException("601","Please enter proper name");
		}
		
		try {
			customerRepo.save(customer);
			return customer;
		}catch(IllegalArgumentException iae) {
			iae.printStackTrace();
			throw new BusinessException("602","Given Customer Name is null"+iae.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
			throw new BusinessException("603","Something is wrong here"+e.getMessage());
		}
		
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		if(customer.getCustomerName().isEmpty() || customer.getCustomerName().length()==0) {
			throw new BusinessException("601","Please enter proper name");
		}
		
		try {
			customerRepo.save(customer);
			return customer;
		}catch(IllegalArgumentException iae) {
			iae.printStackTrace();
			throw new BusinessException("602","Given Customer Name is null"+iae.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
			throw new BusinessException("603","Something is wrong here"+e.getMessage());
		}
	}

	@Override
	public void deleteCustomer(Integer cid) {
		customerRepo.deleteById(cid);
	}

}
