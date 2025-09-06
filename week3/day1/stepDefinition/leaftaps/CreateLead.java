package stepDefinition.leaftaps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateLead extends BaseClass{
	
	@Given("Login into the Leaftaps application using username as {string} and password as {string}")
	public void login_into_the_leaftaps_application(String uname, String pwd) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://leaftaps.com/opentaps/");
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pwd);
	    driver.findElement(By.className("decorativeSubmit")).click();
	}
	@When("Click on the CRMSFA")
	public void click_on_the_crmsfa() {
	    driver.findElement(By.linkText("CRM/SFA")).click();
	}
	@When("Click on the Leads tab")
	public void click_on_the_leads_tab() {
	    driver.findElement(By.linkText("Leads")).click();
	}
	@When("Click on the Create Lead link")
	public void click_on_the_create_lead_link() {
	    driver.findElement(By.linkText("Create Lead")).click();
	}
	@Given("Enter the Company name as {string}")
	public void enter_the_company_name(String cname) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
	}
	@Given("Enter the First name as {string}")
	public void enter_the_first_name(String fname) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
	}
	@Given("Enter the Last name as {string}")
	public void enter_the_last_name(String lname) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
	}
	@When("Click on the submit button for create")
	public void click_on_the_submit_button_for_create() {
		driver.findElement(By.name("submitButton")).click();
	}
	@Then("Validate the Lead ID.")
	public void validate_the_lead_id() {
	    String leadStr = driver.findElement(By.id("viewLead_companyName_sp")).getText().replaceAll("[^0-9]", "");
	    System.out.println("Lead Id is "+leadStr);
	}

	
	
}
