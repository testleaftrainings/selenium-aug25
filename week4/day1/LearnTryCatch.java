package week4.day1;

import org.openqa.selenium.chrome.ChromeDriver;

public class LearnTryCatch {
	
	
	public static void main(String[] args) {
		String price ="$ 189.32";
		ChromeDriver driver = null;
		try {
			String[] strings = price.split(" ");
			price = strings[1];
			System.out.println(price);
			double priceDouble = Integer.parseInt(price);
			if(priceDouble>89.23) {
				System.out.println("Price is greater than 89.23");
			 }
			
		}catch(NumberFormatException e) {
			int int1 = Integer.parseInt(price.replace(".", ""));
			System.out.println(int1);
		}catch(RuntimeException e) {
			
		}
		
		
		try {
			driver = new ChromeDriver();
		}finally {
			if(driver!=null)
				driver.quit();
			
		}
		
	}

}
