package week1.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CreateLeadLeaftaps {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps");
		WebElement usernameEle = driver.findElement(By.id("username"));
		usernameEle.sendKeys("demosalesmanager");
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("C")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Qeagle");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Gokul");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Sekar");
		
		// To handle dropdown locate the Dropdown Element 
		WebElement sourceEle = driver.findElement(By.id("createLeadForm_dataSourceId"));
		
		// Create object reference for Select class and pass the dropdown element reference you want to interact
		Select sourceDD = new Select(sourceEle);
		
		// Select the option from the dropdown using built select class object reference 
		sourceDD.selectByIndex(3);
		
		
		WebElement marketCampEle = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select marketCampDD = new Select(marketCampEle);
		marketCampDD.selectByValue("CATRQ_AUTOMOBILE");
		
		WebElement industryEle = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select industryDD = new Select(industryEle);
		industryDD.selectByVisibleText("Computer Software");
		
		driver.findElement(By.name("submitButton")).click();
		
	}

}
