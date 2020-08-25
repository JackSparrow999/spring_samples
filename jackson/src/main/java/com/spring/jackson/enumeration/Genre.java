package com.spring.jackson.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Genre {

	CLASSICAL("classical"), ELECTRIC("electric"), ACOUSTIC("acoustic");

	String value;
	
	Genre(String value) {
		this.value = value;
	}
	
	@JsonValue
	String value() {
		return value;
	}
	
}
