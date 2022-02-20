package com.myexample.demo.exception;

public class StockException extends BaseException {

	public StockException(String code) {
		super("stock." + code);
	}

	public static StockException matcodeNull() {
		return new StockException("matcode.null");
	}
}
