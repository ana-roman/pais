package com.camunda.Project;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class SendProductConfirmationDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
	
		boolean inStock = (boolean) execution.getVariable("productInStock");
		
		execution.getProcessEngineServices().getRuntimeService()
		.createMessageCorrelation("ProductInStock")
		.setVariable("productInStock", inStock)
		.correlate();
	
	}
}
