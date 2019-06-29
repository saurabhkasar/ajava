package com.app.dao;

import java.util.List;

import com.app.pojos.Stock;

public interface IStockDao {
	List<Stock> listAllStocks();
	List<Stock> listStocksByQty(int qty);
	String addNewStock(Stock s);
	Stock getStockDetails(int stockId);
	Stock updateStock(Stock updateDetachedPOJO);
	String deleteStock(Stock s);
}
