package week2.day1;

import java.time.LocalDateTime;

import org.testng.annotations.Test;

public class CreateLead {

	
	@Test(priority = 5)
	public void runcreateLead() {
		System.out.println("Create Lead "+ LocalDateTime.now().toString());
	}
	
	
	@Test(priority = 2)
	public void runEditLead() {
		System.out.println("Edit Lead "+LocalDateTime.now().toString());
	}
	
	@Test(priority = 2)
	public void runDeleteLead() {
		System.out.println("Delete Lead "+LocalDateTime.now().toString());
	}
	
	@Test(dependsOnMethods = {"runcreateLead","runCreateOpportunity"},priority = 0)
	public void runCreateAccount() {
		System.out.println("Create Account "+LocalDateTime.now().toString());
	}
	
	@Test(dependsOnMethods = {"runcreateLead"}, priority = 3)
	public void runCreateOpportunity() {
		System.out.println("Create Opportunity "+LocalDateTime.now().toString());
		throw new RuntimeException("Execution stopped due to issue in Opportunity");
	}
}
