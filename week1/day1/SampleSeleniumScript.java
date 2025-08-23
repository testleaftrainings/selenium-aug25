package week1.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SampleSeleniumScript {
	// organize input use shortcut ctrl + shift + o
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps");
		WebElement usernameEle = driver.findElement(By.id("username"));
		usernameEle.sendKeys("demosalesmanager");
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("C")).click();
		String title = driver.getTitle();
		System.out.println("Title of the current webpage is "+title);
		WebElement firstLinkEle = driver.findElement(By.tagName("a"));
		String text = firstLinkEle.getText();
		System.out.println("The first link text is "+text);
		System.out.println("The first link is "+firstLinkEle.getDomAttribute("hre"));
		
//		driver.close();// close method is used to close only the current browser and browser driver will not close
//		driver.quit();// Quit method is used to close all the browser opened and also close the browser driver
	}

}
