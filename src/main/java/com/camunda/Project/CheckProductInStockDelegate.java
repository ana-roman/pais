package com.camunda.Project;

import java.util.ArrayList;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CheckProductInStockDelegate implements JavaDelegate {

	private ArrayList<String> productList = new ArrayList<String>();
	private boolean inStock;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
	
		// Manually defined list of products - will act as our 'database'
		productList.add("apple");
		productList.add("samsung");
		
	    // Get the product that we ask for in the process
		String productName = (String) execution.getVariable("productName");
		
		// Simple check to determine if we actually have that product
		inStock = productList.contains(productName);
		
		// Set the variable for the model
		execution.setVariable("productInStock", inStock);
	
	}
}
