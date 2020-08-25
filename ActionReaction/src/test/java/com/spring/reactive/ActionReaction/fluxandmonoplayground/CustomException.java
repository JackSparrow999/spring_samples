package com.spring.reactive.ActionReaction.fluxandmonoplayground;

import lombok.Data;

@Data
public class CustomException extends Throwable{
		
	public String message;
	
	public CustomException(Throwable e) {
		super(e);
	}
}
