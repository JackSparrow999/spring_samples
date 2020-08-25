package com.spring.jpa_join_demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.jpa_join_demo.dto.JoinDto;
import com.spring.jpa_join_demo.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	@Query("SELECT new com.spring.jpa_join_demo.dto.JoinDto(c.name, p.productName) FROM Customer c JOIN c.products p")
	public List<JoinDto> getCustomerAndProductName();
	
}
