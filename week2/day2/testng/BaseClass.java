package week2.day2.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {
	protected  RemoteWebDriver driver;
	
	@Parameters({"username", "password", "browser"})
	@BeforeMethod
	public void setup(@Optional("demosalesmanager") String uname, @Optional("crmsfa") String pwd, @Optional("edge") String BrowserName) {
		switch (BrowserName) {
		case "chrome":
			ChromeOptions option = new ChromeOptions();
			option.addArguments("guest");
			driver = new ChromeDriver(option);
			break;
		
		case "edge":
			EdgeOptions edgeOption = new EdgeOptions();
			edgeOption.addArguments("guest");
			driver = new EdgeDriver(edgeOption);
			break;
		
		default:
			throw new IllegalArgumentException(BrowserName +" browser is unsupported");

		}
		
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
