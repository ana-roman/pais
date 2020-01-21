package com.camunda.Project;

import java.util.HashMap;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * Adds an extra check right before sending the products
 * to see if the product is indeed in stock at the given moment.
 */
public class ConfirmProductAvailabilityDelegate implements JavaDelegate {

	private HashMap<String, Integer> stock = new HashMap<String, Integer>();
	private boolean isAvailable = false;
	private String productName;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		//the stock 'database'
		stock.put("apple", 120);
		stock.put("pear", 10);
		stock.put("bananas", 0);
		stock.put("oranges", 20);
		
		productName = (String) execution.getVariable("productName");
		
		if (stock.get(productName) != 0) {
			isAvailable  = true;
			System.out.println("The product is available");
		} else {
			System.out.println("The product is no longer available");
			execution.setVariable("isAvailable", isAvailable);
			execution.setVariable("amount", stock.get(productName));
			
			throw new BpmnError("Product_No_Longer_Available");
		}
	}
}
