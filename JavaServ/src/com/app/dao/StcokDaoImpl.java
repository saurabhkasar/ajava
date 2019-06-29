package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Stock;

@Repository // MANDATORY
@Transactional // MANDATORY
public class StcokDaoImpl implements IStockDao {
	// dep
	@Autowired // byType
	private SessionFactory sf;

	@Override
	public List<Stock> listAllStocks() {
		String jpql = "select s from Stock s";
		return sf.getCurrentSession().createQuery(jpql, Stock.class).getResultList();
	}

	@Override
	public List<Stock> listStocksByQty(int qty) {
		String jpql = "select s from Stock s where s.quantity > :qty";
		return sf.getCurrentSession().createQuery(jpql, Stock.class).setParameter("qty", qty).getResultList();

	}

	@Override
	public String addNewStock(Stock s) {
		sf.getCurrentSession().save(s);
		return "Stock added with id "+s.getId();
	}

	@Override
	public Stock getStockDetails(int stockId) {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().get(Stock.class,stockId);
	}

	@Override
	public Stock updateStock(Stock updateDetachedPOJO) {
		sf.getCurrentSession().update(updateDetachedPOJO);
		return updateDetachedPOJO;
	}

	@Override
	public String deleteStock(Stock s) {
		sf.getCurrentSession().delete(s);
		return "Stock deleted with ID="+s.getId();
	}
	
	
	

}
