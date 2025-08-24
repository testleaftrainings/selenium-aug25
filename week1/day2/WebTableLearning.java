package week1.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebTableLearning {

	public static void main(String[] args) throws InterruptedException {
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
		
		//To the row present in the table
		int rowCount = driver.findElements(By.xpath("//table/tbody/tr")).size();
		System.out.println("Row count is "+rowCount);
		int columnCount = driver.findElements(By.xpath("//table/thead/tr/th")).size();
		System.out.println("Coulmn count is "+columnCount);
		
		// To retrive specific column(Name column) in the webtable
		
//		driver.findElement(By.xpath("//table/tbody/tr[3]/th"));
		
		//Identify the column number for specific column by name
		//Lead Status
		int leadStatusColNo=0;
		for(int i=1; i<=columnCount;i++) {
			String headerName = driver.findElement(By.xpath("//table/thead/tr/th["+i+"]")).getText();
			if(headerName.contains("Lead Status")) {
				leadStatusColNo = i;
				break;
			}
		}
		
		System.out.println("Lead Status column header number is "+leadStatusColNo);
		
	}

}
