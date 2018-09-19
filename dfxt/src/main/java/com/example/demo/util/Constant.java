package com.example.demo.util;

/**
 * @author 17842
 *
 */
public enum Constant {
	
	SUCCESS("200","成功"),
	ERROR("500","失败");
	
	private String code;
	private String message;
	public String getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	 private Constant(String code, String message) {
		this.code=code;
		this.message=message;
	}
	
}
