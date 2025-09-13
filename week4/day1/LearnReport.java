package week4.day1;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LearnReport {

	public static void main(String[] args) {
		// Set the report path to store the report in html
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./report/result.html");
		
		//To maintain the report history
		reporter.setAppendExisting(true);
		//create instance for ExtentReports class 
		ExtentReports extent = new ExtentReports();
		
		// attach the report path
		extent.attachReporter(reporter);
		
		//Create test for each testcase
		ExtentTest test = extent.createTest("End to End flow for Lead");
			
		//add the author, category, testcase information for each testcase
		test.assignAuthor("Gokul");
		test.assignCategory("Regression");
		
		test.info("Browser launched successful");
		test.pass("Login is successfull");
		test.pass("Lead Created sucessfully");
		test.fail("The Lead ID 10318 is not available");
		
		
		ExtentTest tc2 = extent.createTest("Opportunity Module");
		ExtentTest node = tc2.createNode("Create Opportunity");
		node.assignAuthor("Valentina");
		node.assignCategory("functional");
		node.info("Chromedriver lunched");
		node.pass("login is success");
		node.pass("opportunity is created");
		node.fail("opportunity Id is missing");
		
		ExtentTest node2 = tc2.createNode("EditOpportunity");
		node2.assignAuthor("Gokul");
		node2.assignCategory("Sanity");
		node2.pass("Login is success");
		node2.fail("Opportunity is not present");
		
		//generate the report file (Save the new changes in the file)
		extent.flush();

		
	}

}
