package week1.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LearnWindowHandling {

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
		driver.findElement(By.xpath("//button[@title=': Mobile Publisher']")).click();
		Thread.sleep(5000);
		System.out.println("Title of the webpage is "+driver.getTitle());
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		System.out.println("-------------------------------");
		Set<String> windowHandles = driver.getWindowHandles();
		//option 1: convert the set into list
		List<String> windows = new ArrayList<String>(windowHandles);
		System.out.println(windows.get(0));
		System.out.println(windows.get(1));
		System.out.println("-------------------------------");
		//option 2: enhanced for loop
		for(String window : windowHandles) {
			System.out.println(window);
		}
		
		System.out.println("Before switch Title of the webpage is "+driver.getTitle());
		driver.switchTo().window(windows.get(1));
		System.out.println("After switch Title of the webpage is "+driver.getTitle());
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		System.out.println("Title of the webpage is "+driver.getTitle());
		driver.close();
		System.out.println("Title of the webpage is "+driver.getTitle());
	}

}
