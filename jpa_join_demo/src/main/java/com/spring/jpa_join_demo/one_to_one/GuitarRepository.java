package com.spring.jpa_join_demo.one_to_one;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.jpa_join_demo.one_to_one.Guitar;

@Repository
public interface GuitarRepository extends JpaRepository<Guitar, Long>{
	
}
