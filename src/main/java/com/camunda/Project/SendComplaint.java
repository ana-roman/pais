package com.camunda.Project;

import java.util.HashMap;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class SendComplaint implements JavaDelegate {
	private HashMap<String, Integer> productList = new HashMap<String, Integer>();
	private boolean inStock;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		
		String nameOfProduct = (String) execution.getVariable("productName");
		Integer priceOfProduct = (Integer) execution.getVariable("price");
		String complaintComment = (String) execution.getVariable("comment");
		execution.getProcessEngineServices().getRuntimeService()
		.createMessageCorrelation("complaint")
		.setVariable("ProductName", nameOfProduct)
		.setVariable("ProductPrice", priceOfProduct)
		.setVariable("ComplaintComment", complaintComment)
		.correlate();
		
		

	}

}
