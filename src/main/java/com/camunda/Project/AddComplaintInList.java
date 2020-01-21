package com.camunda.Project;

import java.util.HashMap;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class AddComplaintInList implements JavaDelegate {
	private HashMap<String, Integer> complaintList = new HashMap<String, Integer>();

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		
		String product = (String) execution.getVariable("ProductName");
		Integer highPrice = (Integer) execution.getVariable("ProductPrice");
		String comment = (String) execution.getVariable("ComplaintComment");
		
		
		Complaints complaint = new Complaints(product, highPrice, comment);
		
		
	}
	
	public class Complaints {
		String productName;
		String comment;
		Integer productPrice;
	
	  

	   public Complaints(String product, Integer price, String complaintComment) {
	      // This constructor has one parameter, name.
	     productName = product;
	     comment = complaintComment;
	     productPrice = price;
	   }
	   
	   public Integer getPrice()
	   {
		   return productPrice;
	   }
	   
	   public String getName()
	   {
		   return productName;
		   
	   }
	   
	   public String getComment()
	   {
		   return comment;
	   }

	 

}
}