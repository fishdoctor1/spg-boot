package com.myexample.demo;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.myexample.demo.entity.StockMstEntity;
import com.myexample.demo.exception.BaseException;
import com.myexample.demo.exception.StockException;
import com.myexample.demo.service.beans.stock.StockMstRequest;
import com.myexample.demo.services.stock.StockMstService;;

@RestController
@RequestMapping(value = "/api")
public class HelloController {

//	@Autowired
	private StockMstService stockMstService; // singleton object instance injected to be used/shared by all controllers

	public void setStockMstService(StockMstService stockMstService) {
		this.stockMstService = stockMstService;
	}

	public HelloController() {
		//
	}

	@GetMapping("/")
	public String welcome() {
		return "Welcome to Spring Boot";
	}

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("/{id}")
	public String hello2(@PathVariable("id") String id) {
		return id;
	}

	@RequestMapping(value = "/add-stock", method = RequestMethod.POST)
	public ResponseEntity<?> stock(@RequestBody StockMstRequest stockMstRequest) {
		Gson gson = new Gson();
		System.out.println("sssssssssssssssssssss");
		System.out.println(gson.toJson(stockMstRequest));
//		req = gson.fromJson(stockMstRequest, StockMstRequest.class);
		Date date = new Date();
		StockMstEntity stockMstEntity = new StockMstEntity();
		stockMstEntity.setMatcode(stockMstRequest.getMatCode());
		stockMstEntity.setQty(1L);		
		stockMstEntity.setCreateDate(date);
		stockMstEntity.setUpdateDate(date);
		StockMstEntity s = new StockMstEntity ();
		s = stockMstService.addStockMst(stockMstEntity);
		StockMstRequest res = new StockMstRequest();
		res.setMatCode("matttttttttt");
		return ResponseEntity.status(HttpStatus.OK).body(gson.toJson(res));
	}

	@RequestMapping(value = "/find-stock", method = RequestMethod.POST)
	public ResponseEntity<?> findStock(@RequestBody StockMstRequest stockMstRequest) throws BaseException {
		// if throw error from other inside and dont have try catch block
		// then read throw on function then go to controllerAdvice find BaseException
		Gson gson = new Gson();
		System.out.println("sssssssssssssssssssss");
		System.out.println(gson.toJson(stockMstRequest));
//		BeanUtil.isEmpty()
		StockMstRequest res = new StockMstRequest();

//		req = gson.fromJson(stockMstRequest, StockMstRequest.class);
		stockMstService.findAllActiveUsersNative(null);
		res.setMatCode("matttttttttt");
		return ResponseEntity.status(HttpStatus.OK).body(gson.toJson(res));

	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadImage(@RequestBody MultipartFile stockMstRequest) throws BaseException {
		return "";
	}

}
