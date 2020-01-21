package com.camunda.Project;

import java.util.HashMap;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class SendComplaint implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
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
