package com.spring.jpa_join_demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Customer {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String email;
	private String gender;

	@JoinColumn(name = "cp_fk", referencedColumnName = "id")
	@OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
	private List<Product> products;
}
