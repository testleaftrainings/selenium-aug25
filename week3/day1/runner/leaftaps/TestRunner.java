package runner.leaftaps;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src\\test\\resources\\features\\leaftaps", },
				glue = {"stepDefinition\\leaftaps"},
				dryRun = false,
				tags ="@CreateMulti",
				monochrome = true,
				publish = true
		)
public class TestRunner extends AbstractTestNGCucumberTests{

}
