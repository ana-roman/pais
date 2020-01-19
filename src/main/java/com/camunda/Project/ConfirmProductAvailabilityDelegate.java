package com.camunda.Project;

import java.util.HashMap;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;


public class ConfirmProductAvailabilityDelegate implements JavaDelegate {

	private HashMap<String, Integer> stock = new HashMap<String, Integer>();
	private boolean isAvailable = false;
	private String productName;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		stock.put("apple", 10);
		stock.put("pear", 0);
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