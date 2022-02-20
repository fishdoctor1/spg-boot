package com.myexample.demo.config;

public class ForceTerminateException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private int code = -1;
	private Object obj;
	
	public ForceTerminateException(int code, String msg) {
		super(msg);
		this.code = code;
	}
	
	public ForceTerminateException(int code, String msg, Throwable cause) {
		super(msg, cause);
		this.code = code;
	}
	
	public ForceTerminateException(int code, String msg, Throwable cause, Object obj) {
		super(msg, cause);
		this.code = code;
		this.obj = obj;
	}
	
	public int getCode() {
		return this.code;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
	
}

