package com.myexample.demo.repository;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myexample.demo.entity.StockMstEntity;
import com.myexample.demo.exception.BaseException;

//@Repository
//public interface StockMstRepository extends CrudRepository<StockMstEntity, Long> {
//	@Query(value = "SELECT u.matcode FROM stock_mst u", nativeQuery = true)
//	Collection<StockMstEntity> findAllActiveUsersNative() throws BaseException;
////	@Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2")
////	StockMstEntity findUserByStatusAndName(Integer status, String name);
////
////	@Query("SELECT u FROM User u WHERE u.status = :status and u.name = :name")
////	StockMstEntity findUserByUserStatusAndUserName(@Param("status") Integer userStatus, @Param("name") String userName);
////
////	@Query(value = "SELECT * FROM Users u WHERE u.status = :status and u.name = :name", nativeQuery = true)
////	StockMstEntity findUserByStatusAndNameNamedParamsNative(@Param("status") Integer status, @Param("name") String name);
//}

@Repository
public class StockMstRepository {
	
//	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	public StockMstEntity save(StockMstEntity stock) {
		Session session =this.sessionFactory.getCurrentSession();
		session.save(stock);
		return stock;
	}
//	
//	public List<StockMstEntity> getAllStock(){
//		Session session = this.sessionFactory.getCurrentSession();
//		Criteria crit = session.createCriteria(StockMstEntity.class);
////		crit.add(Restrictions.eq("matcode", "s"));
//		return crit.list();
//	}
//	
//	public List<StockMstEntity> getAllStockByCriteria(){
//		Session session = this.sessionFactory.getCurrentSession();
//		Criteria crit = session.createCriteria(StockMstEntity.class);
//		crit.add(Restrictions.eq("matcode", "s"));
//		List<StockMstEntity> results = crit.list();
//		return results;
//	}
	
}