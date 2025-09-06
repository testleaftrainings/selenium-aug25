package stepDefinition.leaftaps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class EditLead extends BaseClass{
	
	@When("Click on the Find Lead link")
	public void click_on_the_find_lead_link() {
		driver.findElement(By.linkText("Find Leads")).click();
	}
	@Given("Search for the existing lead with phone number")
	public void search_for_the_existing_lead_with_phone_number() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("99");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
	}
	@When("Click on the first result for the searched phone number")
	public void click_on_the_first_result_for_the_searched_phone_number() {
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}
	@When("Click on the Edit button for lead")
	public void click_on_the_edit_button_for_lead() {
		driver.findElement(By.linkText("Edit")).click();
	}
	@Given("Update the existing company name")
	public void update_the_existing_company_name() {
		WebElement companyNameEle = driver.findElement(By.id("updateLeadForm_companyName"));
		companyNameEle.clear();
		companyNameEle.sendKeys("Qeagle");
	}
	@When("Click on the submit button for edit Lead")
	public void click_on_the_submit_button_for_edit_lead() {
		driver.findElement(By.name("submitButton")).click();
	}
	
}
