package com.Demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Demo.Exception.BusinessException;
import com.Demo.Exception.ControllerException;
import com.Demo.Service.CustomerServiceImpl;
import com.Demo.entity.Customer;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
	@GetMapping("/getCustomer")
	public List<Customer> getCourse(){
		return this.customerServiceImpl.getCustomer();
	}
	
	@PostMapping("/addCustomer")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
		try {
			Customer customerSave = customerServiceImpl.addCustomer(customer);
			return new ResponseEntity<Customer>(customerSave,HttpStatus.CREATED) ;
		}catch(BusinessException be) {
		   ControllerException ce = new ControllerException(be.getErrorCode(),be.getErrorMessage());
		   return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			ControllerException ce = new ControllerException("611","Something Went Wrong");
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/updateCustomer/{cid}")
	public Customer updateCustomer(@RequestBody Customer customer){
		return this.customerServiceImpl.updateCustomer(customer);
	}
	
	@DeleteMapping("/deleteCustomer/{cid}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable Integer cid){
		try {
			this.customerServiceImpl.deleteCustomer(cid);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
