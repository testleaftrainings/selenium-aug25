package week2.day1.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class CreateLeadSalesforce {

	@Test
	public void runCreateLead() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']/ancestor::a")).click();
		WebElement leadsTabEle = driver.findElement(By.xpath("//a[@title='Leads']"));
		driver.executeScript("arguments[0].click();",leadsTabEle);
		driver.findElement(By.xpath("//a[@title='New']")).click();
		driver.findElement(By.xpath("//label[text()='Last Name']/following::input")).sendKeys("Sekar");
		driver.findElement(By.xpath("//label[text()='Company']/following::input")).sendKeys("Qeagle");
		WebElement salutationEle = driver.findElement(By.xpath("//label[text()='Salutation']/following::button"));
		salutationEle.click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Mr.']")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		driver.quit();
	}
	
}
