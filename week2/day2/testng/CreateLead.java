package week2.day2.testng;


import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import week2.day2.ReadDataFromExcel;



public class CreateLead extends BaseClass{

	
	@Test(dataProvider = "testData")
	public void runCreateLead(String cname, String fname, String lname, String phno) {
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phno);
		driver.findElement(By.name("submitButton")).click();
		
}
	
	@DataProvider(name = "testData", indices = {1})
	  public Object[][] dp() throws InvalidFormatException, IOException {
		  System.out.println("Data Provider");
	   return ReadDataFromExcel.readData("CreateLead");
	  }
	
}






