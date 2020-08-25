package com.spring.jpa_join_demo.one_to_one;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "person_table")
public class Person {

	@Id
	@GeneratedValue
	@Column(name = "pid")
	private Long id;
	private String name;
	private Integer age;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pid", referencedColumnName = "gid")
	private Guitar guitar;
	
}