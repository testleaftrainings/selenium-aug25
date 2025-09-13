package week4.day1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnScreenshot {

	public static void main(String[] args) throws IOException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File("./snap/SalesforceLogin.png");
		FileUtils.copyFile(screenshotAs, screenshotPath);
		
		
		File mytra = driver.findElement(By.tagName("body")).getScreenshotAs(OutputType.FILE);
		File screenshot= new File("./snap/Myntra.png"); 
		FileUtils.copyFile(mytra, screenshot);
		
		driver.quit();
		
	}
	
	
}
