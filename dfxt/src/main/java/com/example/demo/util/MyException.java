package com.example.demo.util;

public class MyException extends RuntimeException{
	
	private String code;
	
	public MyException (String message) {
		super(message);
	}
	
	public MyException() {
		
	}
}
