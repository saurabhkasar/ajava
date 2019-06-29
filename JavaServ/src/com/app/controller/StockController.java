package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IStockDao;
import com.app.pojos.Stock;

@RestController // =@Controller + @RespBody
@RequestMapping("/stocks")
public class StockController {
	// dep
	@Autowired
	private IStockDao dao;// i/f ref.

	public StockController() {
		System.out.println("in cnstr of " + getClass().getName());
	}

	// REST req handling method to show all stocks
	@GetMapping
	public List<Stock> getAllStocks() {
		System.out.println("in get stocks...");
		List<Stock> l1 = dao.listAllStocks();
		l1.forEach(System.out::println);
		return l1;
	}

	// REST req handling method to show selected stocks
	@GetMapping("/{stockQty}")
	public List<Stock> getSelectedStocks(@PathVariable int stockQty) {
		System.out.println("in get selected stocks");
		return dao.listStocksByQty(stockQty);
	}

	// REST req handling method to create a new stock
	/*
	 * @PostMapping public String addStock(@RequestBody Stock s) {
	 * System.out.println("in add stock "+s); return dao.addNewStock(s); }
	 */
	@PostMapping
	public ResponseEntity<String> addStock(@RequestBody Stock s) {
		System.out.println("in add stock " + s);
		try {
			String sts = dao.addNewStock(s);
			// success
			return new ResponseEntity<String>(sts, HttpStatus.CREATED);
		} catch (RuntimeException e) {
			System.out.println("err in add stock " + e);
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	// REST req handling method to update existing stock
	@PutMapping("/{sid}")
	public ResponseEntity<?> updateStock(@PathVariable int sid, @RequestBody Stock s) {
		// invoke dao's for checking if stock exists
		Stock s1 = dao.getStockDetails(sid);
		if (s1 == null) {
			// failure
			return new ResponseEntity<String>("Stock with " + sid + " doesn't exist", HttpStatus.NOT_FOUND);
		}
		// invoke dao's method to update
		Stock updatedStock = dao.updateStock(s);
		return new ResponseEntity<Stock>(updatedStock, HttpStatus.OK);
	}

	// REST req handling method to delete existing stock
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStock(@PathVariable int id) {
		// invoke dao's for checking if stock exists
		Stock s1 = dao.getStockDetails(id);
		if (s1 == null) {
			// failure
			return new ResponseEntity<String>("Stock with " + id + " doesn't exist", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(dao.deleteStock(s1),HttpStatus.OK);
	}

}
