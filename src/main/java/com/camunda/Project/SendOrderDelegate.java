package com.camunda.Project;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class SendOrderDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
	
		execution.getProcessEngineServices().getRuntimeService()
		.createMessageCorrelation("OrderMessage")
		.correlate();
	}
}
