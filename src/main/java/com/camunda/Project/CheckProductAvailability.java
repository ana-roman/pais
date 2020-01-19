package com.camunda.Project;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CheckProductAvailability implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub

		String productAvailabilityCheck = (String)execution.getVariable("productAvailabilityCheck");
		Boolean productIsAvailable = null;
		
		if (productAvailabilityCheck.equals("yes")) {
			System.out.println("The product is available");
			productIsAvailable = true;
		
		} else if (productAvailabilityCheck.equals("no")) {
			System.out.println("The product is no longer available");
			throw new BpmnError("Product_No_Longer_Available");
			//productIsAvailable = null;
		}
	
		execution.setVariable("productIsAvailable", productIsAvailable);
	}

}
