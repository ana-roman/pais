package com.camunda.Project;

import java.util.HashMap;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CheckProductInStockDelegate implements JavaDelegate {

	private HashMap<String, Integer> productList = new HashMap<String, Integer>();
	private boolean inStock;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
	
		// Manually defined list of products - will act as our 'database'
		productList.put("apple", 120);
		productList.put("pear", 50);
		
	    // Get the product that we ask for in the process
		String productName = (String) execution.getVariable("productName");
		
		// Simple check to determine if we actually have that product
		inStock = productList.containsKey(productName);
		if (inStock) {
			execution.setVariable("price", productList.get(productName));
		}
		
		// Set the variable for the model
		execution.setVariable("productInStock", inStock);
	}
}
