package week1.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrame {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/frame.xhtml");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys("Gokul");
		driver.switchTo().frame(0);
		
		WebElement element = driver.findElement(By.id("Click"));
		element.click();
		driver.switchTo().defaultContent();// helps to transfer the driver control back to the webpage
		driver.findElement(By.xpath("//input[@placeholder='Search...']")).clear();
		
		List<WebElement> elements = driver.findElements(By.tagName("iframe"));
		System.out.println("Frame present in the webpage is "+elements.size());
		
		WebElement frame = driver.findElement(By.xpath("//h5[text()=' Click Me (Inside Nested frame)']/following-sibling::iframe"));
		driver.switchTo().frame(frame);
		System.out.println("Frame count inside the three frame is "+driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame("frame2");
		driver.findElement(By.id("Click")).click();
		
		/*
		 * driver.switchTo().parentFrame(); 
		 * driver.switchTo().parentFrame();
		 */
		
		driver.switchTo().defaultContent();
		System.out.println("Frame count is "+driver.findElements(By.tagName("iframe")).size());
	}

}
