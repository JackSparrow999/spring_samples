package com.springflux.reactivebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenericOutput<T> {
	
	T data;
}
