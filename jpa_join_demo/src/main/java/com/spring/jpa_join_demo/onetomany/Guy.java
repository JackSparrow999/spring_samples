package com.spring.jpa_join_demo.onetomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Guy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "gid")
	private Long id;
	
	private String name;
	
	@JoinColumn(name = "guy_fk", referencedColumnName = "gid")
	@OneToMany(cascade = CascadeType.ALL)
	private List<Song> songs;
	
}
