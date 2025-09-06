package stepDefinition.leaftaps;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.github.javafaker.Faker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateAccount extends BaseClass{
	String fullName;
	@When("Click on the accounts tab")
	public void click_on_the_accounts_tab() {
	    driver.findElement(By.linkText("Accounts")).click();
	}
	@When("Click on the create account link")
	public void click_on_the_create_account_link() {
	    driver.findElement(By.linkText("Create Account")).click();
	}
	@Given("Enter the account name")
	public void enter_the_account_name() {
	Faker faker = new Faker();
	fullName = faker.name().fullName();
	   driver.findElement(By.id("accountName")).sendKeys(fullName);
	}
	@When("Click on the create account button")
	public void click_on_the_create_account_button() {
	   driver.findElement(By.className("smallSubmit")).click();
	}
	@Then("Validate the account name is same")
	public void validate_the_account_name_is_same() {
	   String actualAccountName = driver.findElement(By.xpath("//table[@class='fourColumnForm']/tbody/tr[1]/td[2]")).getText();
	   Assert.assertTrue(actualAccountName.contains(fullName),"The Account name is "+actualAccountName+" and the expected account name is "+fullName);
	}
	
	
}
