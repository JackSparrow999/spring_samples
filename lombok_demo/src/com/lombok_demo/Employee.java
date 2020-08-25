package com.lombok_demo;

import com.sun.istack.internal.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
enum Designation{
	DEVELOPER("developer"), HR("hr"), MANAGER("manager");
	String value;
}

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Employee {
	@NotNull String name;
	int sal;
	Designation pos;
}
