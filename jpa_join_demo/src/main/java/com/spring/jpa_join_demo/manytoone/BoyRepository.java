package com.spring.jpa_join_demo.manytoone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoyRepository extends JpaRepository<Boy, Long>{

}
