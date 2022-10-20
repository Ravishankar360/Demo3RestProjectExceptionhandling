package com.Demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Demo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
