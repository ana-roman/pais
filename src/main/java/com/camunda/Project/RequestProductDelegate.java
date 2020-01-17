package com.camunda.Project;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class RequestProductDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
	
		String productName = (String) execution.getVariable("productName");
		
		execution.getProcessEngineServices().getRuntimeService()
		.createMessageCorrelation("ProductName")
		.setVariable("productName", productName)
		.correlate();
	
	}
}
