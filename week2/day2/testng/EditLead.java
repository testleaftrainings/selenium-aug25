package week2.day2.testng;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import week2.day2.RetryEngine;



public class EditLead extends BaseClass{

	
	@Test//(retryAnalyzer = RetryEngine.class)
	public void runEditLead() throws InterruptedException {
		
		driver.findElement(By.linkText("Lead")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("99");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TCS");
		driver.findElement(By.name("submitButton")).click();
		
}
}






