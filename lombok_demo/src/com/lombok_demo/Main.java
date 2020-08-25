package com.lombok_demo;

public class Main {
	
	public static void main(String[] args) {
		Employee p = new Employee("ronaq", 88090965, Designation.DEVELOPER);
		System.out.println(p.pos.getValue());
	}
	
}
