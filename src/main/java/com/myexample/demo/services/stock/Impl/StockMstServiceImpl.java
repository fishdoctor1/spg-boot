package com.myexample.demo.services.stock.Impl;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.myexample.demo.config.ForceTerminateException;
import com.myexample.demo.entity.StockMstEntity;
import com.myexample.demo.repository.StockMstRepository;
import com.myexample.demo.services.stock.StockMstService;

@Service("StrockMstServiceImpl")
public class StockMstServiceImpl implements StockMstService {

//	@Autowired
	private StockMstRepository stockMstRepository;
	
	public void setStockMstRepository(StockMstRepository stockMstRepository) {
		this.stockMstRepository = stockMstRepository;
	}
//	@PersistenceContext
//	private EntityManager entityManager;
	
	@Override
	public void deleteCosmetic(String id) {
//		stockMstRepository.deleteById(id);
	}
	
	@Override
	public String uploadFile(MultipartFile file) {
		if (file == null) {
			// throw error
		}
		if (file.getSize() > 10 * 1024) {

		}

		try {
			byte[] bytes = file.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public List<StockMstEntity> getAllStockMst() {
//		return (List<StockMstEntity>) stockMstRepository.findAll();
		return null;
	}

	@Override
	@Transactional
	public StockMstEntity addStockMst(StockMstEntity stockMst) throws DataAccessException {
		try {
			stockMstRepository.save(stockMst);
			return stockMst;
		} catch(Exception e) {
			e.printStackTrace();
			throw new ForceTerminateException(0, "ee");			
		}
		
		
	}

	@Override
	public String findAllActiveUsersNative(String request) {
//		if (request == null) {
////	int a= 1/0;
//	throw StockException.matcodeNull();
//}
		return "";
////stockMstRepository.findAllActiveUsersNative();
	}

}
