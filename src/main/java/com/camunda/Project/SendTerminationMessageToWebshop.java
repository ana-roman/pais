package com.camunda.Project;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class SendTerminationMessageToWebshop implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		
		execution.getProcessEngineServices().getRuntimeService()
		.createMessageCorrelation("WebshopTermination")
		.correlate();

	}

}
