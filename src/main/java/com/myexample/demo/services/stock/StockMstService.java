package com.myexample.demo.services.stock;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.myexample.demo.entity.StockMstEntity;

@Component
public interface StockMstService {

	public List<StockMstEntity> getAllStockMst();
	
	public StockMstEntity addStockMst(StockMstEntity stockMst) throws DataAccessException;

	public void deleteCosmetic(String id);

	public String findAllActiveUsersNative(String request);

	public String uploadFile(MultipartFile file);
}
