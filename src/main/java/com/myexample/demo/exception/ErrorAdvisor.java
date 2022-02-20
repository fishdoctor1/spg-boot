package com.myexample.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorAdvisor {

	@ExceptionHandler(BaseException.class)
	public ResponseEntity<ErrorResponse> handleBaseException(BaseException e) {
		ErrorResponse res = new ErrorResponse();
		res.setError("sss");
		res.setStatus(HttpStatus.EXPECTATION_FAILED.value());
		System.out.println("aaaaaaaaaaaaaaa");
		return new ResponseEntity<>(res, HttpStatus.EXPECTATION_FAILED);
	}

	public static class ErrorResponse {
		private String error;
		private int status;

		public String getError() {
			return error;
		}

		public void setError(String error) {
			this.error = error;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

	}
}
