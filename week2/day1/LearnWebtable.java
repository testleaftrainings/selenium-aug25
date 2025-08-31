package week2.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWebtable {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://leafground.com/table.xhtml");
		List<WebElement> headerEles = driver.findElements(By.xpath("//div[@class='ui-datatable-scrollable-body']/table/thead/tr/th"));
		int columnCount = headerEles.size();
		System.out.println("Coulmn count is "+columnCount);
		
		for(int i=1; i<=columnCount; i++) {
			String text = driver.findElement(By.xpath("//div[@class='ui-datatable-scrollable-body']/table/thead/tr/th["+i+"]")).getText();
			System.out.println(text);
		}
		
		List<String> countryNames = new ArrayList<String>();
		int rowCount = driver.findElements(By.xpath("//div[@class='ui-datatable-scrollable-body']/table/tbody/tr")).size();
		for(int i=1; i<=rowCount; i++) {
		String text = driver.findElement(By.xpath("//div[@class='ui-datatable-scrollable-body']/table/tbody/tr["+i+"]/td[2]")).getText();
		countryNames.add(text);
		}
		
		System.out.println("Row Count is "+rowCount);
		System.out.println("Country Names are "+countryNames);
		
		List<List<String>> newStatusRecords = new ArrayList<List<String>>();
		for(int i=1; i<=rowCount; i++) {
			List<String> eachRecord = new ArrayList<String>();
			String actualStatus = driver.findElement(By.xpath("//div[@class='ui-datatable-scrollable-body']/table/tbody/tr["+i+"]/td[5]")).getText();
			if(actualStatus.contains("NEW")) {
				for(int j=1; j<=columnCount; j++) {
					String text = driver.findElement(By.xpath("//div[@class='ui-datatable-scrollable-body']/table/tbody/tr["+i+"]/td["+j+"]")).getText();
					eachRecord.add(text);					
				}
				newStatusRecords.add(eachRecord);
			}
		}
		
		System.out.println("Record with status as new are :\n"+newStatusRecords);
		
	}

}
