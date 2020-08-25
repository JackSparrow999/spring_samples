package com.spring.jpa_join_demo.one_to_one;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Guitar {

	@Id
	@GeneratedValue
	@Column(name = "gid")
	private Long id;
	private String brand;
	
}
