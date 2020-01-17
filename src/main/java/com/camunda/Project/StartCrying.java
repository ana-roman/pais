package com.camunda.Project;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class StartCrying implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
//		String question = (String) execution.getVariable("question");
		
		execution.getProcessEngineServices().getRuntimeService()
		.createMessageCorrelation("Message")
//		.setVariable("question", question)
		.correlate();
	}
}
