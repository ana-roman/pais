package com.camunda.Project;

import org.camunda.bpm.engine.delegate.DelegateExecution;


/*
 * Correlates the send message task for the customer information 
 * from the Client to the Webshop.
 */
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class SendCustomerInformationDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
	
		String address = (String) execution.getVariable("address");
		String cardNumber = (String) execution.getVariable("cardNumber");
		
		execution.getProcessEngineServices().getRuntimeService()
		.createMessageCorrelation("CustomerInformation")
		.setVariable("address", address)
		.setVariable("cardNumber", cardNumber)
		.correlate();
	}
}
